package org.example;

import org.example.Controlador.ControladorInstrumentos;
import org.example.Vista.Ventana;

public class Main {
    public static void main(String[] args) {
        Ventana ventanains = new Ventana("Instrumentos Musicales");
        ControladorInstrumentos controler = new ControladorInstrumentos(ventanains);

    }

}