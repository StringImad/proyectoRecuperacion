/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.proyectorecuperacionimad;

/**
 *
 * @author MSI
 */
public class Clientes {

    private String nombre;
    private String apellido;
    private String direccion;
    private String codCliente;
    private String formaPago;

    public Clientes() {
    }

    public Clientes(String nombre, String apellido, String direccion, String codCliente, String formaPago) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.codCliente = codCliente;
        this.formaPago = formaPago;

    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre + " Apellido: " + apellido + " Direccion: " + direccion + " DNI: " + codCliente+"\n";
    }

}
