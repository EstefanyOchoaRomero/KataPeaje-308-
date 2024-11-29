package orgestefanykatapeaje.katapeajevehiculos.models;


import java.util.ArrayList;
import java.util.List;

public class Peaje {
    private String nombre;
    private String ciudad;
    private double totalRecaudado;
    private List<Vehiculo> vehiculosRegistrados;

    public Peaje(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        
        this.vehiculosRegistrados = new ArrayList<>();
    }

    
    public void registrarVehiculo(Vehiculo vehiculo) {
        double peajeCobrado = vehiculo.calcularTarifa();
        this.totalRecaudado += peajeCobrado;
        this.vehiculosRegistrados.add(vehiculo);
    }


    public double getTotalRecaudado() {
        return this.totalRecaudado;
    }

    public void setTotalRecaudado(double totalRecaudado) {
        this.totalRecaudado = totalRecaudado;
    }


    public List<Vehiculo> getVehiculosRegistrados() {
        return this.vehiculosRegistrados;
    }

    
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

}
