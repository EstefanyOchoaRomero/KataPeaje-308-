package orgestefanykatapeaje.katapeajevehiculos.models;

public class Coche extends Vehiculo {

    public Coche(String placa) {
        super(placa);
    }

    @Override
    public double calcularTarifa() {
        return 100.0;
    }
}
