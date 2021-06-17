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

/**
 *
 * @author MSI
 */
public class Servicios extends Productos {

    private int horasEstimadas;
    //Anotaciones json para que al leer los mismo salga el correcto formato
    //no me hacen falta las clases serializadora y deserializadora ya que los
    //importo a traves de las dependencias en el pom.xml y el jsonformat
    //le da la forma correcta y el patron para que funcione
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate fechaComienzo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate fechaFin;

    public Servicios() {
    }

    public Servicios(int horasEstimadas, LocalDate fechaComienzo, LocalDate fechaFin, String numProducto, String descriProducto, double precioProducto) {
        super(numProducto, descriProducto, precioProducto);
        this.horasEstimadas = horasEstimadas;
        this.fechaComienzo = fechaComienzo;
        this.fechaFin = fechaFin;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public LocalDate getFechaComienzo() {
        return fechaComienzo;
    }

    public void setFechaComienzo(LocalDate fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

//    @Override
//    public String toString() {
//        return super.toString()+ horasEstimadas + ";" + fechaComienzo + ";" + fechaFin+"\n";
//    }
//    
    @Override
    public String toString() {
        return super.toString() + ", horasEstimadas=" + horasEstimadas + ", fechaComienzo=" + fechaComienzo + ", fechaFin=" + fechaFin + "\n";
    }

}
