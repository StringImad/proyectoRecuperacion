/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.proyectorecuperacionimad;

import java.io.File;
import serviciosNecesarios.ServicioProductos;
import serviciosNecesarios.ServicioClientes;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import lectura.LecturaFicheros;
import serviciosNecesarios.ServicioCopiasSeguridad;
import serviciosNecesarios.ServicioPedidos;

/**
 *
 * @author MSI
 */
public class Prueba {

    public static void main(String[] args) throws FileNotFoundException {

        //Rellenamos las listas con los datos que tenemos en los ficheros
        ArrayList<Clientes> listaClientes = LecturaFicheros.leerFicheroCsvClientes("clientes.csv");
        ArrayList<Articulos> listaArticulos = LecturaFicheros.leerFicheroCsvArticulos("articulos.csv");
        ArrayList<Servicios> listaServicios = LecturaFicheros.leerFicheroCsvServicios("servicios.csv");
//Para rellenar la lista de productos necitamos volcar los datos de las dos listas en la lista productos
        ArrayList<Productos> listaProductos = new ArrayList<>();
        ArrayList<Pedidos> listaPedidos = new ArrayList<>();

        for (int i = 0; i < listaArticulos.size(); i++) {
            listaProductos.add(listaArticulos.get(i));
        }
        for (int i = 0; i < listaServicios.size(); i++) {
            listaProductos.add(listaServicios.get(i));
        }
//  

        boolean repetir = true;
        String codigo = "";
        String[] botones = {"Consultar", "modificar", "añadir", "borrar", "Imprimir Pedido", "Copias Seguridad", "salir"};
        String[] botonesEntidades = {"Clientes", "Productos", "Pedidos", "salir"};
        String[] botonesCopias = {"Realizar copia", "Restaurar copia", "salir"};

        do {
            int ventana = JOptionPane.showOptionDialog(null, "Bienvenido al sistema, ¿Qué desea realizar?", " ",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
            switch (ventana) {
                case 0: {

                    int ventanaMostrar = JOptionPane.showOptionDialog(null, "¿Qué desea mostrar?", " ",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botonesEntidades,
                            botonesEntidades[0]);
                    switch (ventanaMostrar) {
                        case 0:
                            JOptionPane.showMessageDialog(null,
                                    "Actualmente tenemos registrados los siguientes clientes: \n" + listaClientes);

                            break;
                        case 1:
                            JOptionPane.showMessageDialog(null,
                                    "Actualmente tenemos registrados los siguientes productos: \n" + listaProductos);
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null,
                                    "Actualmente tenemos registrados los siguientes pedidos: \n" + listaPedidos);
                            break;

                        case 3:

                            JOptionPane.showMessageDialog(null, "Pulse aceptar para salir a la pantalla de inicio.");
                            // al pulsar en case 4 se pone reptir en false por lo tanto sale del programa y
                            // del bucle
                            repetir = false;

                            break;

                    }
                    break;
                }

                case 1: {
                    int ventanaModificar = JOptionPane.showOptionDialog(null, "¿Qué desea modificar?", " ",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botonesEntidades,
                            botonesEntidades[0]);
                    switch (ventanaModificar) {
                        case 0:

//                            do {
                            codigo = JOptionPane.showInputDialog(
                                    "Actualmente tenemos registrados los siguientes clientes: \n" + listaClientes
                                    + "Escriba el codigo");
                            ServicioClientes.modificarCliente(codigo, listaClientes);
                            break;
                        case 1:

                            codigo = JOptionPane.showInputDialog(
                                    "Actualmente tenemos registrados los siguientes Productos: \n"
                                    + listaProductos + "Escriba el codigo");
                            ServicioProductos.modificarProducto(codigo,listaProductos);
                            break;
                        case 2:
                            codigo = JOptionPane.showInputDialog(
                                    "Actualmente tenemos registrados los siguientes pedidos: \n"
                                    + listaPedidos + "Escriba el codigo");
                            ServicioPedidos.modificarPedidos(codigo, listaClientes, listaProductos);

                            break;

                        case 3:

                            JOptionPane.showMessageDialog(null, "Pulse aceptar para salir del sistema.");
                            // al pulsar en case 4 se pone reptir en false por lo tanto sale del programa y
                            // del bucle
                            repetir = false;

                            break;

                    }
                    break;
                }
                case 2: {
                    int ventanaCrear = JOptionPane.showOptionDialog(null, "¿Qué desea crear?", " ",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botonesEntidades,
                            botonesEntidades[0]);
                    switch (ventanaCrear) {
                        case 0:
                            JOptionPane.showMessageDialog(null,
                                    "Actualmente tenemos registrados los siguientes clientes: \n" + listaClientes
                            );
                            listaClientes.add(ServicioClientes.crearCliente());

                            break;
                        case 1:
                            JOptionPane.showMessageDialog(null,
                                    "Actualmente tenemos registrados los siguientes productos: \n" + listaProductos);
                            listaProductos.add(ServicioProductos.crearProducto());
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null,
                                    "Actualmente tenemos registrados los siguientes pedidos: \n" + listaPedidos);

                            //  ServicioPedidos.crearPedido(listaClientes, listaProductos);
                            listaPedidos.add(ServicioPedidos.crearPedido(listaClientes, listaProductos));
                            break;

                        case 3:

                            JOptionPane.showMessageDialog(null, "Pulse aceptar para salir del sistema.");
                            // al pulsar en case 4 se pone reptir en false por lo tanto sale del programa y
                            // del bucle
                            repetir = false;

                            break;

                    }
                    break;
                }
                case 3: {
                    int ventanaBorrar = JOptionPane.showOptionDialog(null, "¿Qué desea borrar?", " ",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botonesEntidades,
                            botonesEntidades[0]);
                    switch (ventanaBorrar) {
                        case 0:
                            codigo = JOptionPane.showInputDialog(
                                    "Actualmente tenemos registrados los siguientes clientes: \n" + listaClientes
                                    + "Escriba el codigo");

                            for (int i = 0; i < listaClientes.size(); i++) {
                                if (listaClientes.get(i).getCodCliente().equals(codigo)) {
                                    listaClientes.remove(i);
                                }
                            }

                            //   ServicioClientes.borrarCliente(codigo);
                            break;
                        case 1:
                            codigo = JOptionPane.showInputDialog(
                                    "Actualmente tenemos registrados los siguientes productos: \n" + listaProductos
                                    + "Escriba el codigo");

                            for (int i = 0; i < listaProductos.size(); i++) {
                                if (listaProductos.get(i).getNumProducto().equals(codigo)) {
                                    listaProductos.remove(i);
                                }
                            }
                            // ServicioProductos.borrarProducto(codigo);
                            // listaProductos.remove(ServicioProductos.borrarProducto(codigo));
                            break;
                        case 2:
                            codigo = JOptionPane.showInputDialog(
                                    "Actualmente tenemos registrados los siguientes pedidos: \n" + listaPedidos
                                    + "Escriba el codigo");
                            for (int i = 0; i < listaPedidos.size(); i++) {
                                if (listaPedidos.get(i).getNumeroPedido().equals(codigo)) {
                                    listaPedidos.remove(i);
                                }
                            }
                            break;

                        case 3:

                            JOptionPane.showMessageDialog(null, "Pulse aceptar para salir del sistema.");
                            // al pulsar en case 4 se pone reptir en false por lo tanto sale del programa y
                            // del bucle
                            repetir = false;

                            break;

                    }
                    break;
                }
                case 4:
//                    boolean existe = false;
//                    boolean comprobacion = true;
//                   do{
                       codigo = JOptionPane.showInputDialog(
                            "Actualmente tenemos registrados los siguientes pedidos: \n" + listaPedidos
                            + "Escriba el codigo");
                    for (int i = 0; i < listaPedidos.size(); i++) {
                        if (listaPedidos.get(i).getNumeroPedido().equals(codigo)) {
                            ServicioPedidos.imprimirPedido(listaPedidos.get(i));
//                            comprobacion = false;
                        }
                    }
//                    if(existe){
//                    JOptionPane.showMessageDialog(null, "El codigo introducido es incorrecto.");
//                    
//                    }
//                   }while(comprobacion);
                    
                    break;
                case 5:

                    int ventanaCopia = JOptionPane.showOptionDialog(null, "¿Qué desea realizar?", " ",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botonesCopias,
                            botonesCopias[0]);
                    switch (ventanaCopia) {
                        case 0:
                            ServicioCopiasSeguridad.crearDirectorio("backup");
                            //   String fechaActual = String.valueOf(LocalDate.now().format(DateTimeFormatter.ofPattern("hh:mm:ss dd/MM/yyyy")));

                            // Este objeto guarda fecha y hora
                            LocalDateTime ya = LocalDateTime.now();
                            DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
                            String fechaString2 = ya.format(formato2);

                            ServicioCopiasSeguridad.crearDirectorio("backup/" + fechaString2);
                            ServicioCopiasSeguridad.generarFicheroJSON(listaClientes, "backup/" + fechaString2 + "/listaClientes.json");
                            ServicioCopiasSeguridad.generarFicheroJSON(listaProductos, "backup/" + fechaString2 + "/listaProductos.json");

                            ServicioCopiasSeguridad.generarFicheroJSON(listaPedidos, "backup/" + fechaString2 + "/listaPedidos.json");
                            break;
                        case 1:
                            File directorio = new File("backup/");
                            String[] lista = directorio.list();
                            Arrays.sort(lista);
                             codigo = JOptionPane.showInputDialog(
                            "Actualmente tenemos lass siguientes copias: \n" + Arrays.toString(lista)
                            + "Escriba el codigo de la que quiera regenerar");
                      //       Para eliminar todos los elementos de un ArrayList bastará con que ejecutemos el método .clear().
                             listaClientes.clear();
                             listaClientes = ServicioCopiasSeguridad.leerJSONClientes("backup/"+codigo+"/listaClientes.json");
                            
                             listaPedidos.clear();
                             listaPedidos = ServicioCopiasSeguridad.leerJSONPedidos("backup/"+codigo+"/listaPedidos.json");
                          
//                             
//                             listaProductos.clear();
//                            listaProductos = ServicioCopiasSeguridad.leerJSONProductos("backup/"+codigo+"/listaProductos.json");
////                          
                             
                             break;

                        case 2:

                            JOptionPane.showMessageDialog(null, "Pulse aceptar para salir del sistema.");
                            // al pulsar en case 4 se pone reptir en false por lo tanto sale del programa y
                            // del bucle
                            repetir = false;

                            break;

                    }
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Pulse aceptar para salir del sistema.");
                    // al pulsar en case 4 se pone reptir en false por lo tanto sale del programa y
                    // del bucle
                    repetir = false;
                    break;
            }
        } while (repetir);

    }
}
