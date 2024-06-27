package ar.edu.unju.fi.ejercicio04.model;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate años;
	private String nacionalidad;
	private float peso;
	private float altura;
	private Posicion pos;
	public Jugador() {
		// TODO Auto-generated constructor stub
	}
	public Jugador(String nombre, String apellido, LocalDate años, String nacionalidad, float peso, float altura,
			Posicion pos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.años = años;
		this.nacionalidad = nacionalidad;
		this.peso = peso;
		this.altura = altura;
		this.pos = pos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getAños() {
		return años;
	}
	public void setAños(LocalDate años) {
		this.años = años;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public Posicion getPos() {
		return pos;
	}
	public void setPos(Posicion pos) {
		this.pos = pos;
	}
	public int edad(){
		int total=0;
		LocalDate hoy = LocalDate.now();
		total = Period.between(años, hoy).getYears();
		return total;
	}
	@Override
	public String toString() {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Jugador [Nombre=" + nombre + ", Apellido=" + apellido + ", Fecha de Nacimiento=" + formatter.format(años) + ", Nacionalidad="
				+ nacionalidad + ", Peso=" + peso + ", Altura=" + altura + ", Posicion=" + pos + ", Edad=" + edad() +"]";
	}
	
	
}
