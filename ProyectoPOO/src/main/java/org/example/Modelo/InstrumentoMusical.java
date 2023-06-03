package org.example.Modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class InstrumentoMusical {
    private int id;
    private String nombre;
    private String material;
    private String dedosopua;
    private String tipo;
    private String URL;

    public InstrumentoMusical() {
    }

    public InstrumentoMusical(int id, String nombre, String material, String dedosopua, String tipo, String URL) {
        this.id = id;
        this.nombre = nombre;
        this.material = material;
        this.dedosopua = dedosopua;
        this.tipo = tipo;
        this.URL = URL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDedosopua() {
        return dedosopua;
    }

    public void setDedosopua(String dedosopua) {
        this.dedosopua = dedosopua;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "InstrumentoMusical{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", material='" + material + '\'' +
                ", dedosopua='" + dedosopua + '\'' +
                ", tipo='" + tipo + '\'' +
                ", URL='" + URL + '\'' +
                '}';
    }
    public ImageIcon getImagen() throws MalformedURLException {
        URL urlimagen = new URL(this.URL);
        return new ImageIcon(urlimagen);
    }
}
