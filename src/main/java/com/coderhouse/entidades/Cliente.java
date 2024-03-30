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
@Table (name = "cliente")
public class Cliente {
	
	@Id
	@Column(name = "Id_cliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dni;
	@Column(name = "nombre cliente")
	private String nombreCliente;
	@Column(name = "Apellido Cliente")
	private String apellidoCliente;
	@Column(name = "Socio")
	private Boolean esSocio;
	
	@OneToMany(mappedBy = "cliente")
	private List<Cliente> listaDeClientes;
	
	
	public Integer getId_cliente() {
	return dni;
		
	
	
	
		
		
	}
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(Integer id_cliente, String nombreCliente, String apellidoCliente, Boolean esSocio) {
		super();
		dni = id_cliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.esSocio = esSocio;
	}
	public void setId_cliente(Integer id_cliente) {
		dni = id_cliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public Boolean getEsSocio() {
		return esSocio;
	}
	public void setEsSocio(Boolean esSocio) {
		this.esSocio = esSocio;
	}
	
}
