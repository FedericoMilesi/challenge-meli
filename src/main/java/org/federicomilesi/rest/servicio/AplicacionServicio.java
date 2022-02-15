package org.federicomilesi.rest.servicio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.federicomilesi.rest.dao.BaseDeDatos;
import org.federicomilesi.rest.modelo.Satelite;

public class AplicacionServicio {
    private final List<Satelite> satelites = BaseDeDatos.getInstancia().getSatelites();
    public String addSatelite(String nombre, Satelite satelite) {
        //Verificamos los nombres de los satélites y agregamos sus coordenadas según corresponda
        if(nombre.equals("kenobi")) {
            satelite.setNombre(nombre);
            satelite.setCoordenadaX(-500);
            satelite.setCoordenadaY(-200);
            this.satelites.add(0, satelite);
            return "Los datos del satélite Kenobi han sido ingresados exitosamente.";
        }
        else if(nombre.equals("skywalker")) {
            satelite.setNombre(nombre);
            satelite.setCoordenadaX(100);
            satelite.setCoordenadaY(-100);
            this.satelites.add(1, satelite);
            return "Los datos del satélite Skywalker han sido ingresados exitosamente.";
        }
        else if(nombre.equals("sato")) {
            satelite.setNombre(nombre);
            satelite.setCoordenadaX(500);
            satelite.setCoordenadaY(100);
            this.satelites.add(2, satelite);
            return "Los datos del satélite Sato han sido ingresados exitosamente.";
        }
        return "Uno o más datos fueron ingresados de forma incorrecta.";
    }
    public String addSatelites(List<Satelite> satelites) {
        //Vaciamos la lista para evitar apilamiento de elementos
        this.satelites.clear();
        //Recorremos la lista y asignamos las coordenadas de cada satélite según corresponda
        for(Satelite satelite : satelites) {
            if(satelite.getNombre().equals("kenobi")) {
                satelite.setCoordenadaX(-500);
                satelite.setCoordenadaY(-200);
            }
            else if(satelite.getNombre().equals("skywalker")) {
                satelite.setCoordenadaX(100);
                satelite.setCoordenadaY(-100);
            }
            else if(satelite.getNombre().equals("sato")) {
                satelite.setCoordenadaX(500);
                satelite.setCoordenadaY(100);
            }
        }
        this.satelites.addAll(satelites);
        return this.GetLocation();
    }
    public String GetLocation() {
        //Almacenamos la coordenada X de la posición de cada satélite en una variable distinta
        double x0 = this.satelites.get(0).getCoordenadaX();
        double x1 = this.satelites.get(1).getCoordenadaX();
        double x2 = this.satelites.get(2).getCoordenadaX();
        //Ahora las coordenadas Y
        double y0 = this.satelites.get(0).getCoordenadaY();
        double y1 = this.satelites.get(1).getCoordenadaY();
        double y2 = this.satelites.get(2).getCoordenadaY();
        //Ahora las distancias al emisor
        double r0 = this.satelites.get(0).getDistanciaAlEmisor();
        double r1 = this.satelites.get(1).getDistanciaAlEmisor();
        double r2 = this.satelites.get(2).getDistanciaAlEmisor();
        /*Paso A: Encontrar la intersección (si la hay) de dos de los tres satélites. 
        El rango de alcance de cada satélite vendría a ser un círculo, cuyo centro 
        son las coordenadas X e Y del satélite y su radio la distancia estimada hacia el emisor*/
        //Calculamos la distancia horizontal entre los centros de Kenobi y Skywalker
        double Dx = x1 - x0;
        //Ahora la distancia vertical
        double Dy = y1 - y0;
        //Calculamos la distancia en línea recta entre ambos centros
        double D = Math.sqrt((Dy*Dy) + (Dx*Dx));
        //Verificamos si existen soluciones
        //Si la distancia entre los centros es mayor que la suma de los radios los círculos no son secantes
        if(D > (r0 + r1)) {
            return "No fue posible determinar la ubicación de la nave.";
        }
        /*Si la distancia entre los centros es menor que el valor absoluto de la resta de los 
        radios, uno de los círculos está dentro del otro*/
        if(D < Math.abs(r0 - r1)) {
            return "No fue posible determinar la ubicación de la nave.";
        }
        /*Calculamos el punto (llamémosle A) en el que la línea que atraviesa los puntos de 
        intersección del círculo cruza la línea entre los centros de los círculos*/
        double A = ((r0*r0) - (r1*r1) + (D*D))/(2.0*D);
        //Extraemos las coordenadas X e Y del punto A
        double Ax = x0 + (Dx*A/D);
        double Ay = y0 + (Dy*A/D);
        //Calculamos la distancia desde el punto A hacia cualquiera de los puntos de intersección
        double DA = Math.sqrt((r0*r0) - (A*A));
        //Extraemos las coordenadas X e Y de los puntos de intersección del punto A
        double DAx = -Dy*(DA/D);
        double DAy = Dx*(DA/D);
        //Calculamos los puntos de intersección absolutos
        double PuntoInterseccion1x = Ax + DAx;
        double PuntoInterseccion2x = Ax - DAx;
        double PuntoInterseccion1y = Ay + DAy;
        double PuntoInterseccion2y = Ay - DAy;
        /*Paso B: Comprobar si el tercer círculo interseca en alguno de los puntos de intersección 
        anteriores*/
        //Calculamos la distancia entre el primer punto de intersección con el centro de Sato
        Dx = PuntoInterseccion1x - x2;
        Dy = PuntoInterseccion1y - y2;
        double D1 = Math.sqrt((Dy*Dy) + (Dx*Dx));
        //Ahora la distancia entre el segundo punto de intersección
        Dx = PuntoInterseccion2x - x2;
        Dy = PuntoInterseccion2y - y2;
        double D2 = Math.sqrt((Dy*Dy) + (Dx*Dx));
        //Comprobamos si las distancias son menores que el radio del tercer círculo
        if(D1 < r2) {
            return "x: " + this.redondearNumero(PuntoInterseccion1x) + "\n" + "y: " 
                         + this.redondearNumero(PuntoInterseccion1y) + "\n" + this.GetMessage();
        }
        else if(D2 < r2) {
            return "x: " + this.redondearNumero(PuntoInterseccion2x) + "\n" + "y: " 
                         + this.redondearNumero(PuntoInterseccion2y) + "\n" + this.GetMessage();
        }
        else {
            return "No fue posible determinar la ubicación de la nave.";
        }
    }
    public String GetMessage() {
        //Extraemos los mensajes recibidos por cada satélite
        String[] Mensaje1 = this.satelites.get(0).getMensajeRecibido();
        String[] Mensaje2 = this.satelites.get(1).getMensajeRecibido();
        String[] Mensaje3 = this.satelites.get(2).getMensajeRecibido();
        String[] MensajeCompleto = new String[5];
        String mensaje = "mensaje: ";
        /*Comprobamos cada mensaje palabra por palabra, las palabras que no estén 
        vacías se añaden a la cadena del mensaje final*/
        for(int it = 0; it < 5; it++) {
            if(!Mensaje1[it].equals("")) MensajeCompleto[it] = Mensaje1[it];
            else if(!Mensaje2[it].equals("")) MensajeCompleto[it] = Mensaje2[it];
            else if(!Mensaje3[it].equals("")) MensajeCompleto[it] = Mensaje3[it];
            mensaje += MensajeCompleto[it] + " ";
        }
        return mensaje;
    }
    public double redondearNumero(double numero) {
        //Redondeamos el número recibido para que tenga sólo un decimal
        return BigDecimal.valueOf(numero).setScale(1, RoundingMode.HALF_UP)
                         .doubleValue();
    }
}