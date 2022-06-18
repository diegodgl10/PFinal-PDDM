package com.example.pfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class PantallaRecibos extends AppCompatActivity {

    private TextView ticketsList;
    private ReadWriteOrder rwOrder;
    private String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_recibos);
        rwOrder = new ReadWriteOrder(this);
        List<String> tickets = rwOrder.getTickets();
        // Ticket pizza
        ticketsList = (TextView) findViewById(R.id.tickets_print);
        Intent intent = getIntent();
        for (String fileName : tickets) {
            OrdenPizza newPizza = new OrdenPizza();
            newPizza.toRescue(rwOrder.readTicket(this, fileName));
            text += newPizza.toString() + "\n\n";
            System.out.println("HOLA");
        }
        //text = intent.getStringExtra("Ticket");
        ticketsList.setText(text);
    }
}