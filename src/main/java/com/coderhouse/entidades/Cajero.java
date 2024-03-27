package com.coderhouse.entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "Empleado")
public class Cajero {
	@Id
	@Column(name = "Id_cajero")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id_cajero;
	@Column(name = "nombre_cajero")
	private String nombreCajero;
	@Column(name = "apellido_cajero")
	private String apellidoCajero;
	
	@OneToMany(mappedBy = "cajero")
	private List<Cajero> listaEmpleado;
	
	public Cajero() {
		
	}
	
	public Integer getId_cajero() {
		return Id_cajero;
	}
	public void setId_cajero(Integer id_cajero) {
		Id_cajero = id_cajero;
	}
	public String getNombreCajero() {
		return nombreCajero;
	}
	public void setNombreCajero(String nombreCajero) {
		this.nombreCajero = nombreCajero;
	}
	public String getApellidoCajero() {
		return apellidoCajero;
	}
	public void setApellidoCajero(String apellidoCajero) {
		this.apellidoCajero = apellidoCajero;
	}

}
