package com.example.pfinal;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

/** Clase para ordenar una Pizza
 * @author Zamora Diego Arturo
 */
public class OrdenPizza {

    /* Nombre del pedido */
    private String nombrePedido;
    /* Tamanio del pedio 1 = chica; 2 = mediana; 3 = grande */
    private int tamanio;
    /* Tiene jamon */
    private boolean jamon;
    /* Tiene pepperoni */
    private boolean pepperoni;
    /* Tiene pinia */
    private boolean pinia;
    /* Tiene jalapenio */
    private boolean jalapenio;
    /* Tiene chorizo */
    private boolean chorizo;
    /* Tiene tocino */
    private boolean tocino;
    /* Tiene orilla rellena de queso */
    private boolean orillaQueso;
    /* Cupon de descuento */
    private String cupon;
    /* Fecha del pedido */
    private LocalDateTime fecha;

    /**
     * Constructor que recibe lo necesario para la orden de una pizza.
     * @param nombrePedido el nombre del pedido.
     * @param tamanio el tamanio de la pizza
     * @param jamon el valor booleano para saber si la pizza tiene jamon.
     * @param pepperoni el valor booleano para saber si la pizza tiene pepperoni.
     * @param pinia el valor booleano para saber si la pizza tiene pinia.
     * @param jalapenio el valor booleano para saber si la pizza tiene jalapenio.
     * @param chorizo el valor booleano para saber si la pizza tiene chorizo.
     * @param tocino el valor booleano para saber si la pizza tiene tocino.
     * @param orillaQueso el valor booleano para saber si la pizza tiene orillaQueso.
     * @param cupon el cupon del pedido.
     */
    public OrdenPizza(String nombrePedido, int tamanio, boolean jamon, boolean pepperoni,
                      boolean pinia, boolean jalapenio, boolean chorizo, boolean tocino,
                      boolean orillaQueso, String cupon) {
        this.nombrePedido = nombrePedido;
        this.tamanio = tamanio;
        this.jamon = jamon;
        this.pepperoni = pepperoni;
        this.pinia = pinia;
        this.jalapenio = jalapenio;
        this.chorizo = chorizo;
        this.tocino = tocino;
        this.orillaQueso = orillaQueso;
        this.cupon = cupon;
        this.fecha = LocalDateTime.now();
    }

    /**
     * Constructor vacio.
     */
    public OrdenPizza() {

    }

    /**
     * Regresa el nombre del pedido.
     * @return el nombre del pedido.
     */
    public String getNombre() {
        return this.nombrePedido;
    }

    /**
     * Regresa el tamanio de la pizza.
     * @return el tamanio de la pizza.
     */
    public String getTamanio() {
        switch (this.tamanio) {
            case 1:
                return "Chica";
            case 2:
                return "Mediana";
            case 3:
                return "Grande";
            default:
                return "(vacio)";
        }
    }

    /**
     * Regresa los ingredientes de la pizza.
     * @return los ingredientes de la pizza.
     */
    public String getIngredientes() {
        String ingredientes = "";
        if (this.jamon) {
            ingredientes += "Jamon ";
        }
        if (this.pepperoni) {
            ingredientes += "Pepperoni ";
        }
        if (this.pinia) {
            ingredientes += "Pinia ";
        }
        if (this.jalapenio) {
            ingredientes += "Jalapenio ";
        }
        if (this.chorizo) {
            ingredientes += "Chorizo ";
        }
        if (this.tocino) {
            ingredientes += "Tocino";
        }
        return ingredientes;
    }

    /**
     * Regresa "Si" si esta rellena de queso, "No" en otro caso.
     * @return "Si" si esta rellena de queso, "No" en otro caso.
     */
    public String getOrillaQueso() {
        if (this.orillaQueso) {
            return "Si";
        } else {
            return "No";
        }
    }

    /**
     * Regresa el cupon ingresado.
     * @return el cupon ingresado.
     */
    public String getCupon() {
        return this.cupon;
    }

    /**
     * Regresa el precio parcial de la pizza.
     * @return el precio parcial de la pizza.
     */
    public String getPrecio() {
        double precio = 80;
        switch (this.tamanio) {
            case 1:
                precio += 50;
                break;
            case 2:
                precio += 70;
                break;
            case 3:
                precio += 100;
                break;
        }
        if (this.jamon) {
            precio += 10;
        }
        if (this.pepperoni) {
            precio += 10;
        }
        if (this.pinia) {
            precio += 10;
        }
        if (this.jalapenio) {
            precio += 10;
        }
        if (this.chorizo) {
            precio += 10;
        }
        if (this.tocino) {
            precio += 10;
        }
        if (this.orillaQueso) {
            precio += 20;
        }
        return Double.toString(precio);
    }

    /**
     * Regresa el precio total de la pizza.
     * @return el precio total de la pizza.
     */
    public String getPrecioTotal() {
        double precio = Double.valueOf(getPrecio());
        double conDescuento = precio;
        if (this.cupon.equals("p1ZzaPumA")) {
            conDescuento = conDescuento * 0.90;
        }
        if (this.cupon.equals("fC13nc1as")) {
            conDescuento = conDescuento * 0.70;
        }
        return Double.toString(conDescuento);
    }

    /**
     * Regresa la fecha del pedido.
     * @return la fecha del pedido.
     */
    public String getFecha() {
        return this.fecha.toString();
    }

    /**
     * Regresa el ticket de la pizza.
     * @return el ticket de la pizza.
     */
    @Override public String toString() {
        String cadena = "|| TICKET ||\n\n";
        cadena += "NOMBRE: " + getNombre() + "\n\n";
        cadena += "TAMANIO: " + getTamanio() + "\n\n";
        cadena += "INGREDIENTES:\n" + getIngredientes() + "\n\n";
        cadena += "ORILLA DE QUESO: " + getOrillaQueso() + "\n\n";
        cadena += "CUPON: " + getCupon() + "\n\n";
        cadena += "PRECIO: " + getPrecio() + "\n\n";
        cadena += "TOTAL: " + getPrecioTotal() + "\n\n";
        cadena += "FECHA: " + getFecha();
        return cadena;
    }

    /**
     * Regresa una lista con los valores necesarios para guardar los datos.
     * @return una lista con los valores necesarios para guardar los datos.
     */
    public List<String> toSave() {
        List<String> datos = new ArrayList<String>();
        datos.add(this.nombrePedido);
        datos.add(Integer.toString(tamanio));
        datos.add(Boolean.toString(jamon));
        datos.add(Boolean.toString(pepperoni));
        datos.add(Boolean.toString(pinia));
        datos.add(Boolean.toString(jalapenio));
        datos.add(Boolean.toString(chorizo));
        datos.add(Boolean.toString(tocino));
        datos.add(Boolean.toString(orillaQueso));
        datos.add(cupon);
        datos.add(fecha.toString());
        return datos;
    }

    /**
     * Define la pizza con los valores recopilados de la lista.
     * @param datos los datos para definir la pizza.
     */
    public void toRescue(List<String> datos) {
        this.nombrePedido = datos.get(0);
        this.tamanio = Integer.valueOf(datos.get(1));
        this.jamon = Boolean.valueOf(datos.get(2));
        this.pepperoni = Boolean.valueOf(datos.get(3));
        this.pinia = Boolean.valueOf(datos.get(4));
        this.jalapenio = Boolean.valueOf(datos.get(5));
        this.chorizo = Boolean.valueOf(datos.get(6));
        this.tocino = Boolean.valueOf(datos.get(7));
        this.orillaQueso = Boolean.valueOf(datos.get(8));
        this.cupon = datos.get(9);
        this.fecha = LocalDateTime.parse(datos.get(10));
    }
}