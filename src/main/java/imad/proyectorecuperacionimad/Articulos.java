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
public class Articulos extends Productos {

    private int anyosGarantia;
    private double peso;
    private String lugarFabricacion;

    public Articulos() {
    }

    public Articulos(String numProducto, String descriProducto, String lugarFabricacion, int anyosGarantia, double peso, double precioProducto) {
        super(numProducto, descriProducto, precioProducto);
        this.anyosGarantia = anyosGarantia;
        this.peso = peso;
        this.lugarFabricacion = lugarFabricacion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAnyosGarantia() {
        return anyosGarantia;
    }

    public void setAnyosGarantia(int anyosGarantia) {
        this.anyosGarantia = anyosGarantia;
    }

    public String getLugarFabricacion() {
        return lugarFabricacion;
    }

    public void setLugarFabricacion(String lugarFabricacion) {
        this.lugarFabricacion = lugarFabricacion;
    }

//    @Override
//    public String toString() {
//        return super.toString() + peso + ";" + anyosGarantia + ";" + lugarFabricacion +"\n";
//    }

    @Override
    public String toString() {
        return super.toString() + "anyosGarantia=" + anyosGarantia + ", peso=" + peso + ", lugarFabricacion=" + lugarFabricacion +"\n";
    }

}
