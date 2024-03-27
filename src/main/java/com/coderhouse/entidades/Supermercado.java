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
@Table (name = "Supermercado")
public class Supermercado {

	@Id
	@Column(name = "Id_supermercado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id_supermercado;
	@Column(name = "Nombre_sede")
	private String nombreSede;
	
	
	@OneToMany(mappedBy = "supermercado")
	private List<Supermercado> listaSedes;
	
	public Supermercado() {
		
	}


	public Integer getId_supermercado() {
		return Id_supermercado;
	}


	public void setId_supermercado(Integer id_supermercado) {
		Id_supermercado = id_supermercado;
	}


	public String getNombreSede() {
		return nombreSede;
	}


	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}


	public List<Supermercado> getListaSedes() {
		return listaSedes;
	}


	public void setListaSedes(List<Supermercado> listaSedes) {
		this.listaSedes = listaSedes;
	}
	
	
}
