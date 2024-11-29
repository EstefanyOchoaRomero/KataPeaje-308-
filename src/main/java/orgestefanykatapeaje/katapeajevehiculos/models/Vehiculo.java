package orgestefanykatapeaje.katapeajevehiculos.models;
import lombok.Data;




@Data
public abstract class Vehiculo {
    private String placa;


    Vehiculo(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return this.placa;
    }

    public abstract double calcularTarifa();



}
