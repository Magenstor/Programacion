package trim02.parking;

public abstract class Vehiculo implements Tarifable {
	
	private Conductor conductor;
	private String matricula;

	public Vehiculo() {}
	
	public Vehiculo(String matricula) {
		this.matricula = matricula;
	}

	public Vehiculo(Conductor conductor, String matricula) {
		this(matricula);
		this.conductor = conductor;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public int calcularTarifa() {
		return 75;
	}
	
	@Override
	public boolean equals(Object obj) {
		Vehiculo otro = (Vehiculo) obj;
		return this.matricula.equals(otro.matricula);
	}
	
	public String mostrarVehiculo() {
		return this.toString();
	}

	@Override
	public String toString() {
		String c = (this.conductor == null) ? "No Asignado":conductor.getNombre();
		
		return "Datos del veh�culo:\n" + 
				"\tConductor: " + c +
				"\n\tMatricula: " + matricula + "\n";
	}

}

