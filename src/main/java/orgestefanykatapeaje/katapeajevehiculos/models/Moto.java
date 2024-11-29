package orgestefanykatapeaje.katapeajevehiculos.models;



public class Moto extends Vehiculo {

    public Moto(String placa) {
        super(placa);
    }

    @Override
    public double calcularTarifa() {
        return 50.0;
    }
}
