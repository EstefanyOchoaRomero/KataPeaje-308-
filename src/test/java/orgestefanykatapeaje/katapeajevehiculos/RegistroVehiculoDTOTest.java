package orgestefanykatapeaje.katapeajevehiculos;



import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import orgestefanykatapeaje.katapeajevehiculos.RegistroVehiculoDTO.RegistroVehiculoDTO;

class RegistroVehiculoDTOTest {

    @Test
    void testConstructorAndGetters() {

        String placa = "ABC123";
        String tipoVehiculo = "coche";
        int numeroEjes = 4;

    
        RegistroVehiculoDTO dto = new RegistroVehiculoDTO(placa, tipoVehiculo, numeroEjes);

        
        assertEquals(placa, dto.getPlaca(), "La placa debería ser 'ABC123'.");
        assertEquals(tipoVehiculo, dto.getTipoVehiculo(), "El tipo de vehículo debería ser 'coche'.");
        assertEquals(numeroEjes, dto.getNumeroEjes(), "El número de ejes debería ser 4.");
    }

    @Test
    void testSetters() {
        
        RegistroVehiculoDTO dto = new RegistroVehiculoDTO("XYZ987", "moto", 0);

    
        dto.setPlaca("DEF456");
        dto.setTipoVehiculo("camion");
        dto.setNumeroEjes(6);

    
        assertEquals("DEF456", dto.getPlaca(), "La placa debería ser 'DEF456'.");
        assertEquals("camion", dto.getTipoVehiculo(), "El tipo de vehículo debería ser 'camion'.");
        assertEquals(6, dto.getNumeroEjes(), "El número de ejes debería ser 6.");
    }

    @Test
    void testDefaultValues() {
        
        RegistroVehiculoDTO dto = new RegistroVehiculoDTO("LMN123", "moto", 0);

        
        assertEquals("LMN123", dto.getPlaca(), "La placa debería ser 'LMN123'.");
        assertEquals("moto", dto.getTipoVehiculo(), "El tipo de vehículo debería ser 'moto'.");
        assertEquals(0, dto.getNumeroEjes(), "El número de ejes debería ser 0.");
    }

    @Test
    void testNullValues() {
        
        RegistroVehiculoDTO dto = new RegistroVehiculoDTO(null, null, 0);

        
        dto.setPlaca("NOP789");
        dto.setTipoVehiculo("coche");

        
        assertEquals("NOP789", dto.getPlaca(), "La placa debería ser 'NOP789'.");
        assertEquals("coche", dto.getTipoVehiculo(), "El tipo de vehículo debería ser 'coche'.");
        assertEquals(0, dto.getNumeroEjes(), "El número de ejes debería ser 0.");
    }
}
