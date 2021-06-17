/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosNecesarios;

import imad.proyectorecuperacionimad.Clientes;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
public class ServicioClientes {

   private static ArrayList<Clientes> listaClientes = new ArrayList<>();
    private static String apellido = "";
    private static String dni = "";
    private static String formaPago = "";
    private static String direccion = "";
    private static String nombre = "";

    public static Clientes modificarCliente(String codCliente,ArrayList<Clientes> listaClientes ) {
        Clientes usuarioModificado = new Clientes();
        for (int i = 0; i < listaClientes.size(); i++) {
            if (codCliente.equals(listaClientes.get(i).getCodCliente())) {
                usuarioModificado = listaClientes.get(i);
                boolean repetir = true;
                do {
                    // Creamos un objeto de tipo usuario
                    String[] botonesDatos = {"Nombre", "Apellido", "Direccion", "Dni", "Formapago", "salir"};

                    if (usuarioModificado != null) {
                        int ventanaModificar = JOptionPane.showOptionDialog(null, "¿Qué desea modificar?", " ",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botonesDatos, botonesDatos[0]);
                        switch (ventanaModificar) {
                            case 0:
                                nombre = JOptionPane.showInputDialog("Ingrese un nuevo nombre");
                                usuarioModificado.setNombre(nombre);
                                break;
                            case 1:
                                apellido = JOptionPane.showInputDialog("Ingrese un  apellido  nuevo");
                                usuarioModificado.setApellido(apellido);
                                break;
                            case 2:
                                direccion = JOptionPane.showInputDialog("Ingrese una nueva direccion");
                                usuarioModificado.setDireccion(direccion);
                                break;
                            case 3:
                                dni = JOptionPane.showInputDialog("Ingrese un dni nuevo");
                                usuarioModificado.setCodCliente(dni);
                                break;
                            case 4:
                                formaPago = JOptionPane.showInputDialog("Ingrese una nueva forma de pago");
                                usuarioModificado.setFormaPago(formaPago);
                                break;
                            case 5:
                                JOptionPane.showMessageDialog(null, "Pulse aceptar para salir a la pantalla de inicio.");
                                // al pulsar en case 5 se pone reptir en false por lo tanto sale del programa y
                                // del bucle
                                repetir = false;

                                break;
                        }
                    }
                    return usuarioModificado;
                } while (repetir);
            } else {
                JOptionPane.showMessageDialog(null, "El usuario con ese codigo no existe.");

            }

        }

        return usuarioModificado;

    }
//metodo para crear un nuevo cliente
    public static Clientes crearCliente() {
        boolean comprobacion = true;
        Clientes usuarioCreado = new Clientes();

        //    do {
        nombre = JOptionPane.showInputDialog("Ingrese un nuevo nombre");
        usuarioCreado.setNombre(nombre);

        apellido = JOptionPane.showInputDialog("Ingrese un  apellido  nuevo");
        usuarioCreado.setApellido(apellido);

        direccion = JOptionPane.showInputDialog("Ingrese una nueva direccion");
        usuarioCreado.setDireccion(direccion);

        dni = JOptionPane.showInputDialog("Ingrese un dni nuevo");
        usuarioCreado.setCodCliente(dni);

        formaPago = JOptionPane.showInputDialog("Ingrese una nueva forma de pago");
        usuarioCreado.setFormaPago(formaPago);
        listaClientes.add(usuarioCreado);
        return usuarioCreado;

    }
////metodo que recibe un codigo que sera el codigo para borrar un cliente
//    public static Clientes borrarCliente(String codCliente) {
//        Clientes clienteBorrado = new Clientes();
//        for (int i = 0; i < listaClientes.size(); i++) {
//            if (codCliente.equals(listaClientes.get(i).getCodCliente())) {
//                listaClientes.remove(i);
//
//            }
//
//        }
//        return clienteBorrado;
//
//    }
}
