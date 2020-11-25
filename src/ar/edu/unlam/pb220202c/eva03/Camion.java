package ar.edu.unlam.pb220202c.eva03;

public class Camion extends Vehiculo{
	private String Patente;
	private Integer VelocidadActual;
	private Integer limiteVelocidad= 80;
	private Integer cantidadDeEjes;
	
	public Camion (String Patente, Integer VelocidadActual, Integer limiteVelocidad, Integer cantidadDeEjes){
		this.Patente = Patente;
		this.VelocidadActual = VelocidadActual;
		this.limiteVelocidad = limiteVelocidad;
	}
	
	public String getPatente() {
		return Patente;
	}
	public void setPatente(String patente) {
		Patente = patente;
	}
	public Integer getVelocidadActual() {
		return VelocidadActual;
	}
	public void setVelocidadActual(Integer velocidadActual) {
		VelocidadActual = velocidadActual;
	}
	public Integer getLimiteVelocidad() {
		return limiteVelocidad;
	}
	public void setLimiteVelocidad(Integer limiteVelocidad) {
		this.limiteVelocidad = limiteVelocidad;
	}
	public Integer getCantidadDeEjes() {
		return cantidadDeEjes;
	}
	public void setCantidadDeEjes(Integer cantidadDeEjes) {
		this.cantidadDeEjes = cantidadDeEjes;
	}
	
	public Boolean enInfraccion() {
		
        if(this.VelocidadActual> this.limiteVelocidad)
            return true;

        return false;
    }

	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los que crean conveniente

	//el Limite de velociadad para autos es de 80km
	//en caso que supere dicho limite el este sera multado

	
}
