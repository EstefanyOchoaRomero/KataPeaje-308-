package orgestefanykatapeaje.katapeajevehiculos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import orgestefanykatapeaje.katapeajevehiculos.RegistroVehiculoDTO.RegistroVehiculoDTO;
import orgestefanykatapeaje.katapeajevehiculos.Services.PeajeService;
import orgestefanykatapeaje.katapeajevehiculos.models.Camion;
import orgestefanykatapeaje.katapeajevehiculos.models.Moto;
import orgestefanykatapeaje.katapeajevehiculos.models.Peaje;
import orgestefanykatapeaje.katapeajevehiculos.models.Vehiculo;


class PeajeServiceTest {

    private PeajeService peajeService;

    @BeforeEach
    void setUp() {
        peajeService = new PeajeService();
    }

    @Test
void testRegistrarVehiculoCoche() {

    RegistroVehiculoDTO dto = new RegistroVehiculoDTO("ABC123", "COCHE", 4);

    peajeService.registrarVehiculo(dto);


    assertNotNull(peajeService.obtenerPeaje().getVehiculosRegistrados());
    assertEquals(1, peajeService.obtenerPeaje().getVehiculosRegistrados().size());
}

    @Test
    void testRegistrarVehiculoMoto() {
        RegistroVehiculoDTO motoDTO = new RegistroVehiculoDTO("XYZ987", "moto", 0);
        motoDTO.setPlaca("XYZ987");
        motoDTO.setTipoVehiculo("moto");
        motoDTO.setNumeroEjes(0);
        peajeService.registrarVehiculo(motoDTO);

        Peaje peaje = peajeService.obtenerPeaje();
        assertEquals(1, peaje.getVehiculosRegistrados().size());
        Vehiculo vehiculoRegistrado = peaje.getVehiculosRegistrados().get(0);
        assertTrue(vehiculoRegistrado instanceof Moto);
        assertEquals("XYZ987", vehiculoRegistrado.getPlaca());
    }

    @Test
    void testRegistrarVehiculoCamion() {
        RegistroVehiculoDTO camionDTO = new RegistroVehiculoDTO("JKL456", "camion", 4);

        peajeService.registrarVehiculo(camionDTO);

        Peaje peaje = peajeService.obtenerPeaje();
        assertEquals(1, peaje.getVehiculosRegistrados().size());
        Vehiculo vehiculoRegistrado = peaje.getVehiculosRegistrados().get(0);
        assertTrue(vehiculoRegistrado instanceof Camion);
        assertEquals("JKL456", vehiculoRegistrado.getPlaca());
        assertEquals(4, ((Camion) vehiculoRegistrado).getNumeroEjes());
    }

    @Test
    void testRegistrarVehiculoCamionSinEjesLanzaExcepcion() {
        RegistroVehiculoDTO camionDTO = new RegistroVehiculoDTO("JKL456", "camion", 0);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                peajeService.registrarVehiculo(camionDTO));

        assertEquals("El número de ejes debe ser mayor a 0 para un camión.", exception.getMessage());
    }

    @Test
    void testRegistrarVehiculoTipoDesconocidoLanzaExcepcion() {
    RegistroVehiculoDTO vehiculoDesconocidoDTO = new RegistroVehiculoDTO("NOP789", "bicicleta", 0);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                peajeService.registrarVehiculo(vehiculoDesconocidoDTO));

        assertEquals("Tipo de vehículo no reconocido.", exception.getMessage());
    }

    @Test
    void testObtenerPeaje() {
        Peaje peaje = peajeService.obtenerPeaje();
        assertNotNull(peaje);
        assertEquals("Estación Central", peaje.getNombre());
        assertEquals("Ciudad", peaje.getCiudad());
        assertEquals(0, peaje.getVehiculosRegistrados().size());
    }
}
