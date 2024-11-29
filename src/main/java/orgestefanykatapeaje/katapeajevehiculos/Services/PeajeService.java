package orgestefanykatapeaje.katapeajevehiculos.Services;

import org.springframework.stereotype.Service;

import orgestefanykatapeaje.katapeajevehiculos.RegistroVehiculoDTO.RegistroVehiculoDTO;
import orgestefanykatapeaje.katapeajevehiculos.models.Camion;
import orgestefanykatapeaje.katapeajevehiculos.models.Coche;
import orgestefanykatapeaje.katapeajevehiculos.models.Moto;
import orgestefanykatapeaje.katapeajevehiculos.models.Peaje;
import orgestefanykatapeaje.katapeajevehiculos.models.Vehiculo;

@Service
public class PeajeService {
    public Peaje peaje = new Peaje("Estación Central", "Ciudad");

    public void registrarVehiculo(RegistroVehiculoDTO dto) {
        Vehiculo vehiculo;

        switch (dto.getTipoVehiculo().toLowerCase()) {
            case "coche" -> vehiculo = new Coche(dto.getPlaca());
            case "moto" -> vehiculo = new Moto(dto.getPlaca());
            case "camion" -> {
                

                if (dto.getNumeroEjes() == null || dto.getNumeroEjes() <= 0) {
                    throw new IllegalArgumentException("El número de ejes debe ser mayor a 0 para un camión.");
                }
                vehiculo = new Camion(dto.getPlaca(), dto.getNumeroEjes());
            }
            default -> throw new IllegalArgumentException("Tipo de vehículo no reconocido.");
            
        }

       this.peaje.registrarVehiculo(vehiculo);
    }

    public Peaje obtenerPeaje() {
        return this.peaje;
    }
}
