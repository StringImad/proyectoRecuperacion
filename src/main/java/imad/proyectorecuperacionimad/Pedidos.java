/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.proyectorecuperacionimad;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author MSI
 */
public class Pedidos {
    private String numeroPedido;
     //Anotaciones json para que al leer los mismo salga el correcto formato
    //no me hacen falta las clases serializadora y deserializadora ya que los
    //importo a traves de las dependencias en el pom.xml y el jsonformat
    //le da la forma correcta y el patron para que funcione
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate fechaPedido;
   private Empresa empresa;
    private Clientes cliente;
    private String formaEnvio;
    private Productos productosPedidos;
   private ArrayList<Productos> listaProductosPedidos;

    public Pedidos() {
    }

    public Pedidos(LocalDate fechaPedido, String numeroPedido,  Clientes cliente, ArrayList<Productos> listaProductos, String formaEnvio) {
        this.fechaPedido = fechaPedido;
        this.numeroPedido = numeroPedido;
        //this.empresa = empresa;
        this.cliente = cliente;
        this.listaProductosPedidos = listaProductosPedidos;
        this.formaEnvio = formaEnvio;

    }

    public Pedidos(String numeroPedido, LocalDate fechaPedido, Empresa empresa, Clientes cliente, String formaEnvio, ArrayList<Productos> listaProductosPedidos) {
        this.numeroPedido = numeroPedido;
        this.fechaPedido = fechaPedido;
        this.empresa = empresa;
        this.cliente = cliente;
        this.formaEnvio = formaEnvio;
        this.listaProductosPedidos = listaProductosPedidos;
    }

    public Pedidos(LocalDate fechaPedido, String numeroPedido, Clientes cliente, String formaEnvio) {
        this.fechaPedido = fechaPedido;
        this.numeroPedido = numeroPedido;
     //   this.empresa = empresa;
        this.cliente = cliente;
        this.formaEnvio = formaEnvio;
    }

    public String getFormaEnvio() {
        return formaEnvio;
    }

    public void setFormaEnvio(String formaEnvio) {
        this.formaEnvio = formaEnvio;
    }

    /**
     *
     * @return
     */
    public static String generadorNumeroPedido() {
        String numeroGenerado = "";
        Random aleatorio = new Random();
        int numeroAleatorio = aleatorio.nextInt(9999-1000+1)+1000;
        numeroGenerado = String.valueOf(numeroAleatorio)+LocalDate.now().getYear();
        return numeroGenerado;

    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Productos> getListaProductos() {
        return listaProductosPedidos;
    }

    public void setListaProductos(ArrayList<Productos> listaProductos) {
        this.listaProductosPedidos = listaProductos;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return empresa.getNomEmpresa() + "\n"
                + empresa.getDireccionEmpresa() + "\n"
                + empresa.getNumeroEmpresa() + "\n"
                + "---------------------------------------------------------------------------------------------------------------------------"
                + "\t\t\tfecha   " + fechaPedido + "\n"
                + "\t\t\tnumeroPedido    " + numeroPedido + "\n"
                + "Cliente: " + cliente.getNombre() + " " + cliente.getApellido() + "\n"
                + "Direccion del cliente: " + cliente.getDireccion() + "\n"
                + listaProductosPedidos + "\n"
                + cliente.getFormaPago()+ "\n"
                +"Envio  "+formaEnvio + "\n";
 
    
    }

}
