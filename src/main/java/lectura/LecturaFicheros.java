/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectura;

import imad.proyectorecuperacionimad.Articulos;
import imad.proyectorecuperacionimad.Clientes;
import imad.proyectorecuperacionimad.Servicios;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MSI
 */
public class LecturaFicheros {
    
     public static ArrayList<Articulos> leerFicheroCsvArticulos(String idFichero) {
         ArrayList<Articulos> listaArticulos = new ArrayList<>();
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero CSV: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            //Omitimos la primera linea
//                datosFichero.nextLine();

            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un Stringç
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                Articulos tmp = new Articulos();

                for (String string : tokens) {
                    tmp.setNumProducto(tokens[0]);
                    tmp.setDescriProducto(tokens[1]);
                    tmp.setLugarFabricacion(tokens[2]);
                    tmp.setAnyosGarantia(Integer.parseInt(tokens[3]));
                    tmp.setPeso(Double.parseDouble(tokens[4]));
                    tmp.setPrecioProducto(Double.parseDouble(tokens[5]));
                }
                listaArticulos.add(tmp);

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return listaArticulos;
    }
     
     
    public static ArrayList<Servicios> leerFicheroCsvServicios(String idFichero) throws FileNotFoundException {
        String[] tokens;
        ArrayList<Servicios> listaServicios = new ArrayList<>();
        String linea;

        System.out.println("Leyendo el fichero CSV: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            //Omitimos la primera linea
//                datosFichero.nextLine();

            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un Stringç
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                Servicios tmp = new Servicios();

                for (String string : tokens) {
                    tmp.setNumProducto(tokens[0]);
                    tmp.setDescriProducto(tokens[1]);
                    LocalDate fechaIni = LocalDate.parse(tokens[2], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    LocalDate fechaFin = LocalDate.parse(tokens[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    tmp.setFechaComienzo(fechaIni);
                    tmp.setFechaFin(fechaFin);
                    tmp.setHorasEstimadas(Integer.parseInt(tokens[4]));
                    tmp.setPrecioProducto(Double.parseDouble(tokens[5]));

                }
                listaServicios.add(tmp);

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return listaServicios;
    }
     
    
       public static ArrayList<Clientes> leerFicheroCsvClientes(String idFichero) {
           ArrayList<Clientes> listaClientes = new ArrayList<>();
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero CSV: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            //Omitimos la primera linea
//                datosFichero.nextLine();

            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un Stringç
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                Clientes tmp = new Clientes();

                for (String string : tokens) {
                    tmp.setNombre(tokens[0]);
                    tmp.setApellido(tokens[1]);
                    tmp.setDireccion(tokens[2]);
                    tmp.setCodCliente(tokens[3]);
                    tmp.setFormaPago(tokens[4]);
                }
                listaClientes.add(tmp);

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return listaClientes;
    }
}
