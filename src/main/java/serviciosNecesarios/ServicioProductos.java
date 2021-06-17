/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosNecesarios;

import imad.proyectorecuperacionimad.Articulos;
import imad.proyectorecuperacionimad.Productos;
import imad.proyectorecuperacionimad.Servicios;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
public class ServicioProductos {

    private static ArrayList<Productos> listaProductos = new ArrayList<>();
    private static ArrayList<Articulos> listaArticulos = new ArrayList<>();
    private static ArrayList<Servicios> listaServicios = new ArrayList<>();

    //Variables producto
    private static String numeroProducto = "";
    private static String descripcionProducto = "";
    private static String precioProducto = "";

    //Variables articulos
    private static String anyosGarantia = "";
    private static String peso = "";
    private static String lugarFabricacion = "";

    //variables servicios
    private static String horasEstimadas = "";
    private static String fechaComienzo = "";
    private static String fechaFin = "";

    public static Productos modificarProducto(String codProducto,ArrayList<Productos> listaProductos) {
        Productos productoModificado = new Productos();
        for (int i = 0; i < listaProductos.size(); i++) {
            if (codProducto.equals(listaProductos.get(i).getNumProducto())) {
                productoModificado = listaProductos.get(i);
                boolean repetir = true;
                do {
                    // Creamos un objeto de tipo usuario
                    String[] botonesDatos = {"Numero Producto", "Descripcion", "precio", "salir"};

                    if (productoModificado != null) {
                        int ventanaModificar = JOptionPane.showOptionDialog(null, "¿Qué desea modificar?", " ",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botonesDatos, botonesDatos[0]);
                        switch (ventanaModificar) {
                            case 0:
                                numeroProducto = JOptionPane.showInputDialog("Ingrese un nuevo numero");
                                productoModificado.setNumProducto(numeroProducto);
                                break;
                            case 1:
                                descripcionProducto = JOptionPane.showInputDialog("Ingrese una descripcion  nueva");
                                productoModificado.setDescriProducto(descripcionProducto);
                                break;
                            case 2:
                                precioProducto = JOptionPane.showInputDialog("Ingrese un nuevo precio del producto");
                                productoModificado.setPrecioProducto(Double.parseDouble(precioProducto));
                                break;

                            case 3:
                                JOptionPane.showMessageDialog(null, "Pulse aceptar para salir a la pantalla de inicio.");
                                // al pulsar en case 5 se pone reptir en false por lo tanto sale del programa y
                                // del bucle
                                repetir = false;

                                break;
                        }
                    }
                    return productoModificado;
                } while (repetir);
            } else {
                JOptionPane.showMessageDialog(null, "El producto con ese codigo no existe.");

            }

        }

        return productoModificado;

    }
//metodo para crear un nuevo cliente

    public static Productos crearProducto() {

        boolean comprobacion = true;
        Articulos productoCreadoArticulo = new Articulos();
        Servicios productoCreadoServicio = new Servicios();
        Productos productoCreado = new Productos();
        boolean repetir = true;

        // Creamos un objeto de tipo usuario
        String[] botonesDatos = {"Articulo", "Servicio"};

        int ventanaModificar = JOptionPane.showOptionDialog(null, "¿Qué desea crear?", " ",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botonesDatos, botonesDatos[0]);
        switch (ventanaModificar) {
            case 0:
                numeroProducto = JOptionPane.showInputDialog("Ingrese un nuevo numero");
                productoCreadoArticulo.setNumProducto(numeroProducto);

                descripcionProducto = JOptionPane.showInputDialog("Ingrese una descripcion  nueva");
                productoCreadoArticulo.setDescriProducto(descripcionProducto);

                precioProducto = JOptionPane.showInputDialog("Ingrese un nuevo precio del producto");
                productoCreadoArticulo.setPrecioProducto(Double.parseDouble(precioProducto));

                anyosGarantia = JOptionPane.showInputDialog("Ingrese el nuevo anyo de garantia");
                productoCreadoArticulo.setPrecioProducto(Integer.parseInt(anyosGarantia));

                peso = JOptionPane.showInputDialog("Ingrese un nuevo peso del producto");
                productoCreadoArticulo.setPeso(Double.parseDouble(peso));

                lugarFabricacion = JOptionPane.showInputDialog("Ingrese el lugar de fabricacion del producto");
                productoCreadoArticulo.setLugarFabricacion((lugarFabricacion));
                productoCreado = productoCreadoArticulo;
                listaArticulos.add(productoCreadoArticulo);
                listaProductos.add(productoCreadoArticulo);

                break;
            case 1:
                numeroProducto = JOptionPane.showInputDialog("Ingrese un nuevo numero");
                productoCreadoServicio.setNumProducto(numeroProducto);

                descripcionProducto = JOptionPane.showInputDialog("Ingrese una descripcion  nueva");
                productoCreadoServicio.setDescriProducto(descripcionProducto);

                precioProducto = JOptionPane.showInputDialog("Ingrese un nuevo precio del producto");
                productoCreadoServicio.setPrecioProducto(Double.parseDouble(precioProducto));

                horasEstimadas = JOptionPane.showInputDialog("Ingrese las horas estimas dde trabajo");
                productoCreadoServicio.setHorasEstimadas(Integer.parseInt(horasEstimadas));
                fechaComienzo = JOptionPane.showInputDialog("Ingrese la fecha de comienzo del servicio formato: (dd/MM/yyyy");

                LocalDate fechaIni = LocalDate.parse(fechaComienzo, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                productoCreadoServicio.setFechaComienzo(fechaIni);
                fechaFin = JOptionPane.showInputDialog("Ingrese la fecha de fin del servicio formato: (dd/MM/yyyy");
                LocalDate fechaFinServ = LocalDate.parse(fechaFin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                productoCreadoServicio.setFechaFin(fechaFinServ);

                productoCreado = productoCreadoServicio;
                break;

        }

        return productoCreado;

    }
//metodo que recibe un codigo que sera el codigo para borrar un producto

//    public static Productos borrarProducto(String codProductos) {
//        Productos productoBorrado = new Productos();
//        for (int i = 0; i < listaProductos.size(); i++) {
//            if (codProductos.equals(listaProductos.get(i).getNumProducto())) {
//                productoBorrado = listaProductos.get(i);
//
//            }
//
//        }
//        return productoBorrado;
//
//       
//
//    }
}
