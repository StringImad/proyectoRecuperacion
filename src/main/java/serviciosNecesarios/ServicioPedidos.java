/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosNecesarios;

import imad.proyectorecuperacionimad.Articulos;
import imad.proyectorecuperacionimad.Clientes;
import imad.proyectorecuperacionimad.Empresa;
import imad.proyectorecuperacionimad.Pedidos;
import imad.proyectorecuperacionimad.Productos;
import imad.proyectorecuperacionimad.Servicios;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
public class ServicioPedidos {

    private static String fechaPedido;
    private static String empresa;
    private static String cliente;
    private static String codigo;

    private static String formaEnvio;
    private static Productos productosPedidos;
    private static ArrayList<Productos> listaProductosSolicitados = new ArrayList<>();
    private static ArrayList<Pedidos> listaPedidos = new ArrayList<>();
    private static ArrayList<Clientes> listaClientesPedid = new ArrayList<>();
    private static ArrayList<Productos> listaProductosPedid = new ArrayList<>();
    private static Empresa empresaDefecto = new Empresa("345", "InformaTIC", "Calle del medio, Estepona (malaga)", "952830229");

//        private static ArrayList<Clientes> listaClientes;
    public static Pedidos crearPedido(ArrayList<Clientes> listaClientes, ArrayList<Productos> listaProductos, Empresa nueva) {
        //  Empresa empresaDefecto = new Empresa("345", "InformaTIC", "Calle del medio, Estepona (malaga)", "952830229", listaClientes, listaPedidos, listaProductos);

        boolean comprobacion = true;
        Pedidos pedidoNuevo = new Pedidos();
        Clientes clienteNuevo = new Clientes();
        boolean repetir = true;

        boolean repetirFecha = true;

        fechaPedido = JOptionPane.showInputDialog("Ingrese la fecha del pedido formato: (dd/MM/yyyy");

        LocalDate fechaPedi = LocalDate.parse(fechaPedido, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        pedidoNuevo.setFechaPedido(fechaPedi);

        cliente = JOptionPane.showInputDialog("Ingrese el codigo del cliente para asociar a un pedido: \n" + listaClientes);
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getCodCliente().equals(cliente)) {
                clienteNuevo = listaClientes.get(i);
            }
        }
        pedidoNuevo.setCliente(clienteNuevo);
        pedidoNuevo.setEmpresa(nueva);

        pedidoNuevo.setNumeroPedido(Pedidos.generadorNumeroPedido());

        formaEnvio = solicitudEnvi();
        pedidoNuevo.setFormaEnvio(formaEnvio);

        do {
            codigo = JOptionPane.showInputDialog("Ingrese un producto de la lista \n" + listaProductos);
            for (int i = 0; i < listaProductos.size(); i++) {
                if (listaProductos.get(i).getNumProducto().equals(codigo)) {
                    listaProductosSolicitados.add(listaProductos.get(i));
                }
            }

            repetir = solicitudMasProductos();
        } while (repetir);
        pedidoNuevo.setListaProductos(listaProductosSolicitados);
        //   empresaDefecto.setListaClientes(listaClientes);
        //  empresaDefecto.setListaProductos(listaProductos);
        listaPedidos.add(pedidoNuevo);
        // empresaDefecto.setListaPedidos(listaPedidos);
        return pedidoNuevo;

    }

    public static Pedidos modificarPedidos(String codPedido, Empresa empresaNueva) {
        Pedidos pedidoModificado = new Pedidos();
        listaClientesPedid = empresaNueva.getListaClientes();
        Clientes clienteModificado = new Clientes();
        for (int i = 0; i < empresaNueva.getListaPedidos().size(); i++) {
            if (codPedido.equals(empresaNueva.getListaPedidos().get(i).getNumeroPedido())) {

                pedidoModificado = listaPedidos.get(i);
                boolean repetir = true;
                do {
                    // Creamos un objeto de tipo pedfechaido
                    String[] botonesDatos = {"Nombre", "Cliente", "forma envio", "Productos", "salir"};

                    if (pedidoModificado != null) {
                        int ventanaModificar = JOptionPane.showOptionDialog(null, "¿Qué desea modificar?", " ",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botonesDatos, botonesDatos[0]);
                        switch (ventanaModificar) {
                            case 0:
                                fechaPedido = JOptionPane.showInputDialog("Ingrese la fecha del pedido formato: (dd/MM/yyyy");

                                LocalDate fechaPedi = LocalDate.parse(fechaPedido, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                pedidoModificado.setFechaPedido(fechaPedi);
                                break;
                            case 1:
                                cliente = JOptionPane.showInputDialog("Ingrese el codigo del nuevocliente para asociar a un pedido: \n" + listaClientesPedid);
                                for (int j = 0; j < listaClientesPedid.size(); j++) {
                                    if (listaClientesPedid.get(j).getCodCliente().equals(cliente)) {
                                        clienteModificado = listaClientesPedid.get(j);
                                    }
                                }

                                pedidoModificado.setCliente(clienteModificado);

                                break;
                            case 2:
                                formaEnvio = solicitudEnvi();
                                pedidoModificado.setFormaEnvio(formaEnvio);
                                break;
                            case 3:
                                do {
                                    codigo = JOptionPane.showInputDialog("Ingrese un producto de la lista \n" + empresaNueva.getListaProductos());
                                    for (int j = 0; j < empresaNueva.getListaProductos().size(); i++) {
                                        if (empresaNueva.getListaProductos().get(j).getNumProducto().equals(codigo)) {
                                            listaProductosSolicitados.add(empresaNueva.getListaProductos().get(j));
                                        }
                                    }

                                    repetir = solicitudMasProductos();
                                } while (repetir);
                                pedidoModificado.setListaProductos(listaProductosSolicitados);
                                break;

                            case 4:
                                JOptionPane.showMessageDialog(null, "Pulse aceptar para salir a la pantalla de inicio.");
                                // al pulsar en case 5 se pone reptir en false por lo tanto sale del programa y
                                // del bucle
                                repetir = false;

                                break;
                        }
                    }
                    return pedidoModificado;
                } while (repetir);
            } else {
                JOptionPane.showMessageDialog(null, "El pedido con ese codigo no existe.");

            }

        }
        return pedidoModificado;

    }

    public static boolean solicitudMasProductos() {
        boolean confirmacionMasProductos = true;
        int confirmacion = 0;
        confirmacion = JOptionPane.showConfirmDialog(null,
                "¿Quiere seguir añadiendo productos?", "Seleccione porfavor",
                JOptionPane.YES_NO_OPTION);
        if (confirmacion == 0) {
            confirmacionMasProductos = true;
        } else {
            if (confirmacion == 1) {
                confirmacionMasProductos = false;
            }
        }
        return confirmacionMasProductos;

    }

    public static String solicitudEnvi() {
        String confirmacionEnvio = "";
        int confirmacion = 0;
        confirmacion = JOptionPane.showConfirmDialog(null,
                "¿Quiere que se lo enviemos?", "Seleccione porfavor",
                JOptionPane.YES_NO_OPTION);
        if (confirmacion == 0) {
            confirmacionEnvio = "Si";
        } else {
            if (confirmacion == 1) {
                confirmacionEnvio = "No";
            }
        }
        return confirmacionEnvio;

    }

    public static void imprimirPedido(Pedidos pedido) {
        String idFichero = String.valueOf(LocalDate.now());
        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            flujo.write(pedido.toString());

            // Metodo newLine() añade salto de línea después de cada fila
            flujo.newLine();

            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Pedido " + idFichero + " impreso correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
