package orgestefanykatapeaje.katapeajevehiculos.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import orgestefanykatapeaje.katapeajevehiculos.RegistroVehiculoDTO.RegistroVehiculoDTO;
import orgestefanykatapeaje.katapeajevehiculos.Services.PeajeService;
import orgestefanykatapeaje.katapeajevehiculos.models.Peaje;

@RestController
@RequestMapping("/peaje")
public class PeajeController {

    @Autowired
    private PeajeService peajeService;

    @PostMapping("/registrar")
    public String registroVehiculo(@RequestBody RegistroVehiculoDTO dto) {
        peajeService.registrarVehiculo(dto);
        return "Vehículo registrado con éxito.";
    }

    @GetMapping("/total")
    public double obtenerTotal() {
        return peajeService.obtenerPeaje().getTotalRecaudado();
    }

    @GetMapping("/vehiculos")
    public Peaje obtenerPeaje() {
        return peajeService.obtenerPeaje();
    }
}
