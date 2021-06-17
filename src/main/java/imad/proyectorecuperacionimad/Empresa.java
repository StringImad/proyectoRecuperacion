/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.proyectorecuperacionimad;

import java.util.ArrayList;

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
    private ArrayList<Pedidos> listaPedidos;
    private ArrayList<Productos> listaProductos;
//
    public Empresa(String Cif, String nomEmpresa, String direccionEmpresa, String numeroEmpresa) {
        this.Cif = Cif;
        this.nomEmpresa = nomEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.numeroEmpresa = numeroEmpresa;
    }

    public Empresa(String Cif, String nomEmpresa, String direccionEmpresa, String numeroEmpresa, ArrayList<Clientes> listaClientes, ArrayList<Pedidos> listaPedidos, ArrayList<Productos> listaProductos) {
        this.Cif = Cif;
        this.nomEmpresa = nomEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.numeroEmpresa = numeroEmpresa;
        this.listaClientes = listaClientes;
        this.listaPedidos = listaPedidos;
        this.listaProductos = listaProductos;
    }

//    public Empresa(String numeroEmpresa, ArrayList<Clientes> listaClientes, ArrayList<Pedidos> listaPedidos, ArrayList<Productos> listaProductos) {
//        this.Cif = "323";
//        this.nomEmpresa = "Bar Paco";
//        this.direccionEmpresa = "Calle del medio, Estepona (malaga)";
//        this.numeroEmpresa = numeroEmpresa;
//        this.listaClientes = listaClientes;
//        this.listaPedidos = listaPedidos;
//        this.listaProductos = listaProductos;
//    }

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
