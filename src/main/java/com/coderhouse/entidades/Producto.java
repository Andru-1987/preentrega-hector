package com.coderhouse.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table (name = "Producto")
public class Producto {
	@Id
	@Column(name = "Id_producto")
	private Integer id_producto;
	@Column (name ="nombre_producto")
	private String nombreProducto;
	@Column (name = "tipo_producto")
	private String tipoProducto;
	@Column (name = "descripcion")
	private String descripcion;
	@Column (name = "Precio")
	private double precio;
	
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@ManyToOne //para vincularlo con la foreign key(FK)
	@JoinColumn(name="Id_cliente")
	private Cliente cliente;
	@Column(name = "Id_cliente", insertable = false, updatable = false) //para relacionar 2 claves
	private Integer idCliente;
	
	
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public void Producto() {
		
	}
	
	public Integer getId_producto() {
		return id_producto;
	}
	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
