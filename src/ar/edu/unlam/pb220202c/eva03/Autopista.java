package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Autopista {
	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los atributos o metodos que crean convenientes
	private HashMap <Integer,Vehiculo> telepase;
	private HashSet <Vehiculo> vehiculosEnCirculacion;
	private HashSet <Vehiculo> vehiculosEnInfraccion;
	private Integer numeroTelepase;
	private Integer cantidadDeVehiculosEnCirculacion=0;
	
	public Autopista(HashMap<Integer, Vehiculo> telapase, HashSet<Vehiculo> vehiculosEnCirculacion,
			Integer cantidadDeVehiculosEnCirculacion) {
		super();
		this.telepase = telapase;
		this.vehiculosEnCirculacion = vehiculosEnCirculacion;
		this.cantidadDeVehiculosEnCirculacion = cantidadDeVehiculosEnCirculacion;
	}
	
	public void agregarVehiculo(Vehiculo vehiculo) {
		if (this.vehiculosEnCirculacion.add(vehiculo))
			cantidadDeVehiculosEnCirculacion++;

	}
	public Boolean registrarTelepase (Integer numeroTelepase, Vehiculo vehiculo) {
		if(!telepase.containsKey(numeroTelepase) && !telepase.containsValue(vehiculo)) {
	        telepase.put(numeroTelepase, vehiculo);
	        return true;
	        }
	        return false;
	}
	public Boolean ingresarAutopista (Integer numeroTelepase)throws VehiculoNotFounException  {
	        //si el telepase no esta registrado lanza una Exceptios del tipo VehiculoNotFounException
	       // y no permite ingresar al autopista
	        Boolean sePudo = false;
	        if (!telepase.containsKey(numeroTelepase)) {
	            throw new VehiculoNotFounException();
	        }else {
	            sePudo = true;
	        }

	        return sePudo;
	    }
	
	
	public void salirAutopista (Vehiculo vehiculo)throws VehiculoNotFounException{
		if (!vehiculosEnCirculacion.contains(vehiculo)) {
            throw new VehiculoNotFounException();
        }else {
            vehiculosEnCirculacion.remove(vehiculo);
        }

    }
		//lanza Una exception VehiculoNotFounException si no esta en circulacion
	
	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente(){
		PorPatente ordenador = new PorPatente();
        TreeSet<Vehiculo> vehiculosPorPatente = new TreeSet<Vehiculo>(ordenador);
        vehiculosPorPatente.addAll(vehiculosEnInfraccion);


    return vehiculosPorPatente;
    }
		
	public Integer cantidadDeVehiculosENCirculacion() {
	
		return 0;
	}
	
	public void infraccionVelocidad() {
        for (Vehiculo vehiculo : vehiculosEnCirculacion) {
            if (vehiculo instanceof Automovil && vehiculo.getVelocidadActual()>vehiculo.getLimiteVelocidad()) {
                vehiculosEnInfraccion.add(vehiculo);
            }else if (vehiculo instanceof Camion && vehiculo.getVelocidadActual()>vehiculo.getLimiteVelocidad() ) {
                vehiculosEnInfraccion.add(vehiculo);
            }
        }
    }
}


