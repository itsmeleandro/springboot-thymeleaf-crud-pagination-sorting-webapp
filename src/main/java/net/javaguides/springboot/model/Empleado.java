package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "empleado")
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private Long id;
	@Column(name= "nombreAp")
	private String nombreAp;
	@Column(name= "dni")
	private int dni;
	@Column(name= "fecha_Nac")
	private Date fecha_Nac;
	@Column(name= "fecha_Contratacion")
	private Date fecha_Contratacion;
	@Column(name= "direccion")
	private String direccion;
	@Column(name= "telefono")
	private String telefono;
	@Column(name= "email")
	private String email;

	//public Long getId() { eturn id;	}

	// public void setId(Long id) { this.id = id;	}

	public String getNombreAp() {
		return nombreAp;
	}

	public void setNombreAp(String nombreAp) {
		this.nombreAp = nombreAp;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Date getFecha_Nac() {
		return fecha_Nac;
	}

	public void setFecha_Nac(Date fecha_Nac) {
		this.fecha_Nac = fecha_Nac;
	}

	public Date getFecha_Contratacion() {
		return fecha_Contratacion;
	}

	public void setFecha_Contratacion(Date fecha_Contratacion) {
		this.fecha_Contratacion = fecha_Contratacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
