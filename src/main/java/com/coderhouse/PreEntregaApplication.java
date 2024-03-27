package com.coderhouse;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.entidades.Cliente;
import com.coderhouse.entidades.Producto;
import com.coderhouse.repositorio.CajeroRepository;
import com.coderhouse.repositorio.ClienteRepository;
import com.coderhouse.repositorio.ProductoRepository;
import com.coderhouse.repositorio.SupermercadoRepository;

@SpringBootApplication
public class PreEntregaApplication {
	
	@Autowired //permite acceder a los metodos sin pedir autorizacion
	private ProductoRepository productoRepository;
	private ClienteRepository clienteRepository;
	private CajeroRepository cajeroRepository;
	private SupermercadoRepository supermercadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(PreEntregaApplication.class, args);
		
		public void mostrarMenu() {
			try {
				Scanner scanner = new Scanner(System.in);
				
				int opcion = -1;
				do {
					try {
						System.out.println("Menu: ");
						System.out.println("1. Listar productos");
						System.out.println("2. Agregar productos");
						System.out.println("3. Buscar productods por codigo");
						System.out.println("4. Modificar procutos por codigo");
						System.out.println("5. Eliminar productos");
						System.out.println("6. Agregar clientes");
						System.out.println("7: Salir");
						System.out.println("Ingresar opcion: ");
						
						if (scanner.hasNextInt()) {
							opcion = scanner.nextInt();
							scanner.nextLine();
						}else {
							System.out.println("Entrada invalida, debe ingresar una de las opciones disponibles");
							scanner.nextLine();
							continue; //vuelve a iniciar otra vez
						}
						
						switch (opcion) {
						case 1: ListarTodosLosProductos();
						break;
						case 2: AgregarProductos();
						break;
						case 3: buscarProductoPorId();
						break;
						case 4: modificarProductoPorId();
						break;
						case 5: eliminarProductoPorId();
						break;
						case 6: agregarCliente();
						break;
						case 0 : System.out.println("Saliendo del programa");
						break;
						default: System.err.println("Opcion invalida, intente otra vez");
						}
					}catch (Exception inputMissmatchException) {
						System.err.println("Error, ingrese un numero valido");
						scanner.nextLine();
						opcion = -1;
					}
				} while (opcion != 0);
				
			}catch(Exception e) {
				e.getMessage();
			}
		}
		
		//metodos
		public void ListarTodosLosProductos() {
			List<Producto> listaProductos = productoRepository.findAll();
			if (listaProductos.isEmpty()) {
				System.out.println("No hay productos para mostrar");	
	}else {
		System.out.println("Lista de productos: ");
		for (Producto producto : listaProductos) { //para lista los productos con su precio
			System.out.println("El producto es " + producto.getNombreProducto() + 
				" , y vale $" + producto.getPrecio()	);
		}
	}
	}

		public void AgregarProductos() {  //para agregar productos al cliente que compra
			
			List<Cliente> listaCliente = clienteRepository.findAll(); 
			if (listaCliente.isEmpty()) {
				System.out.println("No hay clientes existentes");
				Scanner scanner = new Scanner(System.in);
				Cliente cliente = new Cliente();
				System.out.println("Ingrese el dni del cliente");
				cliente.setId_cliente(scanner.nextInt());
				scanner.nextLine();
				cliente.setNombreCliente(scanner.nextLine());
				scanner.nextLine();
				cliente.setApellidoCliente(scanner.nextLine ());
				scanner.nextLine();
				System.out.println("Clientes existentes: ");
				for (Cliente cliente1 : listaCliente) {
					System.out.println(" " + cliente1.getNombreCliente() + " " + cliente1.getApellidoCliente());
				}
				int clienteId;
				Cliente clienteSeleccionado = null;
				boolean clienteValido = false;
				
				while(!clienteValido) {
					try {
						System.out.println("Seleccione el id del cliente:");
						clienteId = scanner.nextInt();
						clienteSeleccionado = clienteRepository.findById(clienteId).orElse(null);
						if(clienteSeleccionado != null) {
							clienteValido = true;
						} else {
							System.out.println("El id del cliente no es valido");
						}
						} catch(Exception inputMismatchException) {
							System.err.println("El id del  cliente seleccionado no es valido");
							scanner.nextLine();						
					}
					
					Producto producto = new Producto();
					producto.setCliente(clienteSeleccionado);
					productoRepository.save(producto);
					System.out.println("Producto agregado a la lista del cliente.");
				}
			}
		}

		
		public void buscarProductoPorId() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Ingrese el codigo del producto buscado:");
			Integer codigo = scanner.nextInt();
			Producto producto = productoRepository.findById(codigo).orElse(null);
			if(producto != null) {
				System.out.println("Producto seleccionado " + producto.getNombreProducto());
			} else {
				System.out.println("El producto de codigo " + codigo + " no fue encontrado");
			}
		}
		
		public void modificarProductoPorId() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Ingrese el codigo del producto a modificar:");
			Integer codigo = scanner.nextInt();
			Producto producto = productoRepository.findById(codigo).orElse(null);
			if(producto != null) {
				System.out.println("Producto encontrado " + producto.getNombreProducto());
				System.out.println("Ingrese el nuevo nombre:");
				String nuevoNombre = scanner.nextLine();
				producto.setNombreProducto(nuevoNombre);
				productoRepository.save(producto);
				System.out.println("El producto fue modificado correctamente");
			} else {
				System.out.println("El producto de codigo " + codigo + " no fue encontrado");
			}
		}

		public void eliminarProductoPorId() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Ingrese el codigo del producto a modificar:");
			Integer codigo = scanner.nextInt();
			Producto producto = productoRepository.findById(codigo).orElse(null);
			if(producto != null) {
				productoRepository.delete(producto);
				System.out.println("El producto fue eliminado correctamente");
			} else {
				System.out.println("El producto de codigo " + codigo + " no fue encontrado");
			}
		}
		
		public void agregarCliente() {
			Cliente cliente = new Cliente();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Ingrese el nombre del cliente:");
			cliente.setNombreCliente(scanner.nextLine());
			cliente.setApellidoCliente(scanner.nextLine());
			clienteRepository.save(cliente);
			System.out.println("Cliente guardado exitosamente");
		}
	}
