package orgestefanykatapeaje.katapeajevehiculos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import orgestefanykatapeaje.katapeajevehiculos.models.Camion;
import orgestefanykatapeaje.katapeajevehiculos.models.Coche;
import orgestefanykatapeaje.katapeajevehiculos.models.Moto;
import orgestefanykatapeaje.katapeajevehiculos.models.Vehiculo;


class VehiculoTest {

    @Test
    void testGetPlaca() {
        Vehiculo coche = new Coche("ABC123");
        assertEquals("ABC123", coche.getPlaca(), "La placa del coche debería ser 'ABC123'.");

        Vehiculo moto = new Moto("XYZ987");
        assertEquals("XYZ987", moto.getPlaca(), "La placa de la moto debería ser 'XYZ987'.");
    }

    @Test
    void testCalcularTarifaCoche() {
        Vehiculo coche = new Coche("CAR123");
        assertEquals(20.0, coche.calcularTarifa(), "La tarifa para un coche debería ser 20.0.");
    }

    @Test
    void testCalcularTarifaMoto() {
        Vehiculo moto = new Moto("MOTO456");
        assertEquals(10.0, moto.calcularTarifa(), "La tarifa para una moto debería ser 10.0.");
    }

    @Test
    void testCalcularTarifaCamion() {
        Vehiculo camion = new Camion("TRUCK789", 3);
        assertEquals(45.0, camion.calcularTarifa(), "La tarifa para un camión con 3 ejes debería ser 45.0.");
    }

    @Test
    void testInvalidPlaca() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Coche(null));
        assertEquals("Placa no puede ser nula o vacía", exception.getMessage());
    }
}
