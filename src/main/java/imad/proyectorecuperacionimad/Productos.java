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
public class Productos {

    private String numProducto;
    private String descriProducto;
    private double precioProducto;

    public Productos() {
    }

    public Productos(String numProducto, String descriProducto, double precioProducto) {
        this.numProducto = numProducto;

        this.descriProducto = descriProducto;
        this.precioProducto = precioProducto;
    }

    public String getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(String numProducto) {
        this.numProducto = numProducto;
    }

    public String getDescriProducto() {
        return descriProducto;
    }

    public void setDescriProducto(String descriProducto) {
        this.descriProducto = descriProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

//    @Override
//    public String toString() {
//        return "Producto: "+descriProducto +" ; " + precioProducto;
//    }

    @Override
    public String toString() {
        return "Productos{" + "numProducto=" + numProducto + ", descriProducto=" + descriProducto + ", precioProducto=" + precioProducto;
    }

}
