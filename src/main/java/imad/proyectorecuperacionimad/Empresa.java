/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.proyectorecuperacionimad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import lectura.LecturaFicheros;

/**
 *
 * @author MSI
 */
public class Empresa {

    private String Cif;
    private String nomEmpresa;
    private String direccionEmpresa;
    private String numeroEmpresa;
    private ArrayList<Clientes> listaClientes;
    @JsonIgnore
    private ArrayList<Pedidos> listaPedidos;
    private ArrayList<Productos> listaProductos;
//

    public Empresa(String Cif, String nomEmpresa, String direccionEmpresa, String numeroEmpresa) {
        this.Cif = Cif;
        this.nomEmpresa = nomEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.numeroEmpresa = numeroEmpresa;
    }
//String Cif, String nomEmpresa, String direccionEmpresa, String numeroEmpresa, ArrayList<Clientes> listaClientes, ArrayList<Pedidos> listaPedidos, ArrayList<Productos> listaProductos

    public Empresa(ArrayList<Pedidos> listaPedidos) throws FileNotFoundException {
        this.Cif = "345";
        this.nomEmpresa = "InformaTIC";
        this.direccionEmpresa = "Calle del medio, Estepona (malaga)";
        this.numeroEmpresa = "952830229";
        this.listaClientes = LecturaFicheros.leerFicheroCsvClientes("clientes.csv");

        this.listaPedidos = listaPedidos;
      
        this.listaProductos = rellenarListaProductos();

    }
     public static ArrayList<Pedidos> rellenarListaPedidos(Pedidos nuevo) throws FileNotFoundException {
         ArrayList<Pedidos> listaPedidos = new ArrayList<>();
     listaPedidos.add(nuevo);
        return listaPedidos;
    }
     
//         public static ArrayList<Pedidos> rellenarLista() throws FileNotFoundException {
//         ArrayList<Pedidos> listaPedidos =rellenarListaPedidos(nuevo);
//        return listaPedidos;
//         }
     
//      public static ArrayList<Pedidos> rellenarLista() {
//        ArrayList<Pedidos> listaPedidos = new ArrayList<>();
//     listaPedidos.add(nuevo);
//        return listaPedidos;
//    }
 public static ArrayList<Clientes> rellenarListaClientes() throws FileNotFoundException {
        ArrayList<Clientes> listaClientes =  LecturaFicheros.leerFicheroCsvClientes("clientes.csv");
     
        return listaClientes;
    }
    public static ArrayList<Productos> rellenarListaProductos() throws FileNotFoundException {
        ArrayList<Productos> listaProductos = new ArrayList<>();
        ArrayList<Articulos> listaArticulos = LecturaFicheros.leerFicheroCsvArticulos("articulos.csv");
        ArrayList<Servicios> listaServicios = LecturaFicheros.leerFicheroCsvServicios("servicios.csv");
        for (int i = 0; i < listaArticulos.size(); i++) {
            listaProductos.add(listaArticulos.get(i));
        }
        for (int i = 0; i < listaServicios.size(); i++) {
            listaProductos.add(listaServicios.get(i));
        }
        return listaProductos;
    }

    public ArrayList<Clientes> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Clientes> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Pedidos> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedidos> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public ArrayList<Productos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public String getCif() {
        return Cif;
    }

    public void setCif(String Cif) {
        this.Cif = Cif;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getNumeroEmpresa() {
        return numeroEmpresa;
    }

    public void setNumeroEmpresa(String numeroEmpresa) {
        this.numeroEmpresa = numeroEmpresa;
    }

    @Override
    public String toString() {
        return "Empresa{" + "Cif=" + Cif + ", nomEmpresa=" + nomEmpresa + ", direccionEmpresa=" + direccionEmpresa + ", numeroEmpresa=" + numeroEmpresa + '}';
    }

}
