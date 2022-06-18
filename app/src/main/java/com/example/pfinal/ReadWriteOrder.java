package com.example.pfinal;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de leer y escribir tickets.
 * @author Zamora Cruz Diego Arturo.
 */
public class ReadWriteOrder extends  AppCompatActivity {

    /* Nombre de los archivos con los tickets. */
    private final String DATA = "DataTickets.txt";
    /* Lista de los tickets. */
    private List<String> tickets;

    // private List<OrdenPizza> orders;

    /**
     * Constructor vacio.
     */
    public ReadWriteOrder(Context context) {
        this.tickets = new ArrayList<String>();
        readData(context);
    }

    /**
     * Regresa la lista de los tickets
     * @return la lista de los tickets
     */
    public List<String> getTickets() {
        return this.tickets;
    }

    /**
     * Actualiza la lista de tickets.
     * @param context el contexto
     * @param nuevoTicket el nuevo ticket que sera agregara a la lista.
     */
    public void updateData(Context context, String nuevoTicket) {
        this.tickets.add(nuevoTicket);
        writeData(context);
    }

    /**
     * Escribe un nuevo ticket.
     * @param context el contexto
     * @param ticket el nuevo ticket que se escribira.
     */
    public void writeTicket(Context context, List<String> ticket) {
        String fileName = "Ticket_" + ticket.get(ticket.size() - 1) + ".txt";
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(context.openFileOutput(fileName, Activity.MODE_PRIVATE));
            File file = new File(fileName);
            if (file.exists()) {
                return;
            }
            for (String value : ticket) {
                archivo.write(value + "\n");
                archivo.flush();
            }
            archivo.close();
            Log.i("Ficheros", "Se escribio el ticket " + fileName);
        } catch(Exception ex) {
            Log.e("Ficheros", "Error al escribir el ticket " + fileName);
        }
        updateData(context, fileName);
    }

    /**
     * Lee un nuevo ticket y regresa su conteniso.
     * @param fileName el nombre del ticket que se leera.
     * @param context el contexto.
     * @return regresa el contenido del ticket leido.
     */
    public List<String> readTicket(Context context, String fileName) {
        List<String> values = new ArrayList<String>();
        try {
            File misDatos = new File(fileName);
            if (!misDatos.exists()) {
                return null;
            }
            InputStreamReader archivo = new InputStreamReader(context.openFileInput(fileName));
            BufferedReader br = new BufferedReader(archivo);
            String linea;
            while ((linea = br.readLine()) != null) {
                values.add(linea);
            }
            Log.i("Ficheros", "Se leyo el ticket " + fileName);
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al leer el ticket " + fileName);
            return  null;
        }
        return  values;
    }

    /**
     * Escribe la lista de tickets.
     * @param context el contexto.
     */
    public void writeData(Context context) {
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(context.openFileOutput(DATA, Activity.MODE_PRIVATE));
            for (String ticket : this.tickets) {
                archivo.write(ticket + "\n");
                archivo.flush();
            }
            archivo.close();
            Log.i("Ficheros", "Se escribio historial de tickets");
        } catch(Exception ex) {
            Log.e("Ficheros", "Error al escribir historial de tickets");
        }
    }

    /**
     * Lee la lista de tickets.
     * @param context el contexto
     */
    public void readData(Context context) {
        try {
            File misDatos = new File(DATA);
            if (!misDatos.exists()) {
                //misDatos.createNewFile();
                Log.e("Ficheros", "No existe el historial de tickets");
                return;
            }
            InputStreamReader archivo = new InputStreamReader(context.openFileInput(DATA));
            BufferedReader br = new BufferedReader(archivo);
            String linea;
            while ((linea = br.readLine()) != null) {
                this.tickets.add(linea);
            }
            Log.i("Ficheros", "Se leyo el historial de tickets");
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al leer historial de tickets");
        }
    }
}