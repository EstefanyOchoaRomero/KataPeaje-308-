package orgestefanykatapeaje.katapeajevehiculos.models;



import lombok.Data;

@Data
public class Camion extends Vehiculo {
    public int numeroEjes;

    public Camion(String placa, int numeroEjes) {
        super(placa);
        this.numeroEjes = numeroEjes;
    }

    public int getNumeroEjes() {
        return this.numeroEjes;
    }

    @Override
    public double calcularTarifa() {
        return 50.0 * this.numeroEjes;
    }
}
