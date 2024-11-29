package orgestefanykatapeaje.katapeajevehiculos.RegistroVehiculoDTO;
import lombok.Data;



@Data
public class RegistroVehiculoDTO {
    private String placa;
    private String tipoVehiculo;
    private int numeroEjes;

    public RegistroVehiculoDTO(String placa, String tipoVehiculo, int numeroEjes) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.numeroEjes = numeroEjes;
    }

public String getTipoVehiculo() {
    return tipoVehiculo;
}

public void setTipoVehiculo(String tipoVehiculo) {
    this.tipoVehiculo = tipoVehiculo;
}

public String getPlaca() {
    return placa;
}

public void setPlaca(String placa) {
    this.placa = placa;
}

public Integer getNumeroEjes() {
    return numeroEjes;
}

public void setNumeroEjes(Integer numeroEjes) {
    this.numeroEjes = numeroEjes;
}

}

