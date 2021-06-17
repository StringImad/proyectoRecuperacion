/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosNecesarios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import imad.proyectorecuperacionimad.Articulos;
import imad.proyectorecuperacionimad.Clientes;
import imad.proyectorecuperacionimad.Empresa;
import imad.proyectorecuperacionimad.Pedidos;
import imad.proyectorecuperacionimad.Productos;
import imad.proyectorecuperacionimad.Servicios;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI
 */
public class ServicioCopiasSeguridad {

    public static void crearDirectorio(String ruta) {
        Path file = Paths.get(ruta);
        try {
            if (!Files.exists(file)) {
                Files.createDirectory(file);
            } else {
                System.out.println("El directorio " + ruta + " ya existe");
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void generarFicheroJSON(ArrayList lista, String ruta) {

        //Creamos un objeto mapeador para poder configurar el archivo JSON
        //y para llevar a cabo la creación del mismo
        ObjectMapper mapeador = new ObjectMapper();

        //Utilizamos el método configure para que la estructura del JSON
        //este bien tabulada al guardar los objetos de la lista que le pasamos
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        try {
            //llamamos al método writeValue que se le pasa como parametros
            //un constructor new File con el idFichero que pasamos anteriormente
            //y la lista de donde sacará los objetos en cuestión
            System.out.println("------------------generando 1");
            mapeador.writeValue(new File(ruta), lista);
            System.out.println("Archivo JSON creado correctamente");
        } catch (IOException ex) {
            Logger.getLogger(ServicioCopiasSeguridad.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error");
        }

    }

    public static ArrayList leerJSONClientes(String idFichero, Empresa nueva) {
        System.out.println("----------------------------Leyendo fichero  JSON---------------------------------------");
        ArrayList<Clientes> listaClientesLeida = nueva.getListaClientes();

        try {
            ObjectMapper mapeador = new ObjectMapper();
            //vamos guardando en la lista lo que vamos leyendo del archivo llamado idFichero
            listaClientesLeida = mapeador.readValue(new File(idFichero),
                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Clientes.class));

        } catch (IOException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaClientesLeida;
    }

//    public static ArrayList leerJSONProductos(String idFichero) {
//        System.out.println("----------------------------Leyendo fichero  JSON---------------------------------------");
//        ArrayList<Productos> listaProductosLeida = new ArrayList<>();
//        ArrayList<Productos> listaProductosSacada = new ArrayList<>();
//
//        ArrayList<Articulos> listaArticulos = new ArrayList<>();
//        ArrayList<Servicios> listaServicios = new ArrayList<>();
//        ObjectMapper mapeador = new ObjectMapper();
//
//        try {
//            //vamos guardando en la lista lo que vamos leyendo del archivo llamado idFichero
//
//            listaArticulos = mapeador.readValue(new File(idFichero),
//                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Articulos.class));
//
//            listaServicios = mapeador.readValue(new File(idFichero),
//                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Servicios.class));
//        } catch (IOException ex) {
//            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        for (int i = 0; i < listaArticulos.size(); i++) {
//            if (Integer.parseInt(listaArticulos.get(i).getNumProducto()) < 999) {
//                listaProductosSacada.add(listaArticulos.get(i));
//            }
//        }
//
//        for (int i = 0; i < listaServicios.size(); i++) {
//            if (Integer.parseInt(listaArticulos.get(i).getNumProducto()) > 999) {
//                listaProductosSacada.add(listaServicios.get(i));
//            }
//        }
//        return listaProductosSacada;
//    }

    public static ArrayList leerJSONPedidos(String idFichero) {
        System.out.println("----------------------------Leyendo fichero  JSON---------------------------------------");
        ArrayList<Pedidos> listaPedidosLeida = new ArrayList<>();

        try {
            ObjectMapper mapeador = new ObjectMapper();
            //vamos guardando en la lista lo que vamos leyendo del archivo llamado idFichero
            listaPedidosLeida = mapeador.readValue(new File(idFichero),
                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Pedidos.class));

        } catch (IOException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaPedidosLeida;
    }
}
