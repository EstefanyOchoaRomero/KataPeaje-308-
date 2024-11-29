package orgestefanykatapeaje.katapeajevehiculos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import orgestefanykatapeaje.katapeajevehiculos.RegistroVehiculoDTO.RegistroVehiculoDTO;
import orgestefanykatapeaje.katapeajevehiculos.Services.PeajeService;
import orgestefanykatapeaje.katapeajevehiculos.controller.PeajeController;
import orgestefanykatapeaje.katapeajevehiculos.models.Peaje;

@WebMvcTest(PeajeController.class)
class PeajeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeajeService peajeService;

    @Autowired
    private ObjectMapper objectMapper;

    private Peaje mockPeaje;

    @BeforeEach
    void setUp() {
        mockPeaje = new Peaje("Estación Central", "Ciudad");
        mockPeaje.setTotalRecaudado(150.0);
    }

    @Test
    void testRegistroVehiculo() throws Exception {
        RegistroVehiculoDTO registroVehiculoDTO = new RegistroVehiculoDTO("ABC123", "coche", 0);

        mockMvc.perform(post("/peaje/registrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(registroVehiculoDTO)))
                .andExpect(status().isOk())
                .andExpect(content().string("Vehículo registrado con éxito."));

        verify(peajeService, times(1)).registrarVehiculo(Mockito.eq(registroVehiculoDTO));
    }

    @Test
    void testObtenerTotal() throws Exception {
        when(peajeService.obtenerPeaje()).thenReturn(mockPeaje);

        mockMvc.perform(get("/peaje/total"))
                .andExpect(status().isOk())
                .andExpect(content().string("150.0"));

        verify(peajeService, times(1)).obtenerPeaje();
    }

    @Test
    void testObtenerPeaje() throws Exception {
        when(peajeService.obtenerPeaje()).thenReturn(mockPeaje);

        mockMvc.perform(get("/peaje/vehiculos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Estación Central"))
                .andExpect(jsonPath("$.ciudad").value("Ciudad"))
                .andExpect(jsonPath("$.totalRecaudado").value(150.0));

        verify(peajeService, times(1)).obtenerPeaje();
    }
}
