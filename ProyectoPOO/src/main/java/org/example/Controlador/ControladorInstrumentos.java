package org.example.Controlador;

import org.example.Modelo.InstrumentoMusical;
import org.example.Modelo.ModeloTablaInstrumento;
import org.example.Vista.Ventana;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorInstrumentos extends MouseAdapter {
    private Ventana view;
    private ModeloTablaInstrumento modelo;

    public ControladorInstrumentos(Ventana view) {
        this.view = view;
        modelo = new ModeloTablaInstrumento();

        this.view.getTblinstrumentos().addMouseListener(this);
        this.view.getTblinstrumentos().setModel(modelo);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnagregar().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
        this.view.getBtnBorrar().addMouseListener(this);


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == view.getTblinstrumentos()){
            System.out.println("Evento sobre la tabla");
            int index = this.view.getTblinstrumentos().getSelectedRow();
            InstrumentoMusical tmp= modelo.getinstrumentoatindex(index);
            try{
                this.view.getImagen().setIcon(tmp.getImagen());
                this.view.getImagen().setText("");
            }catch (MalformedURLException mfue){
                System.out.println(e.toString());
            }


        }
        if(e.getSource() == this.view.getBtnCargar()){

            modelo.cargardatos();
            this.view.getTblinstrumentos().setModel(modelo);
            this.view.getTblinstrumentos().updateUI();
        }
        if (e.getSource()==this.view.getBtnagregar()){
            InstrumentoMusical instrumento = new InstrumentoMusical();
            instrumento.setId(this.view.getTxtid().getColumns());
            instrumento.setNombre(this.view.getTxtnombre().getText());
            instrumento.setMaterial(this.view.getTxtmaterial().getText());
            instrumento.setTipo(this.view.getTxttipo().getText());
            instrumento.setDedosopua(this.view.getTxtformadetocar().getText());
            instrumento.setURL(this.view.getTxtURL().getText());
            if(modelo.agregarInstrumento(instrumento)){
                JOptionPane.showMessageDialog(view,"Se Agrego Correctamente","Aviso",JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblinstrumentos().updateUI();
            }else {
                JOptionPane.showMessageDialog(view,"No se pudo Agregar a la base de datos, Por favor revise su conexion","Error al Insertar",JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource() == view.getBtnActualizar()) {
            int a = this.view.getTblinstrumentos().getSelectedRow();
            int doble = JOptionPane.showConfirmDialog(view,"Desea Cambiar este Instrumento ?","Estas Seguro de Completar la Accion?",JOptionPane.YES_NO_OPTION);
            if (doble == JOptionPane.YES_OPTION) {
                if (a >= 0) {
                    InstrumentoMusical actualizacion = new InstrumentoMusical();
                    actualizacion.setNombre(this.view.getTxtnombre().getText());
                    actualizacion.setMaterial(this.view.getTxtmaterial().getText());
                    actualizacion.setTipo(this.view.getTxttipo().getText());
                    actualizacion.setDedosopua(this.view.getTxtformadetocar().getText());
                    actualizacion.setURL(this.view.getTxtURL().getText());
                    modelo.ActualizarDatos(a, actualizacion);
                    this.view.getTblinstrumentos().clearSelection();

                } else {
                    JOptionPane.showMessageDialog(view, "Seleccione el Instrumento para actualizarlo", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        }
        if (e.getSource()== this.view.getBtnBorrar()){
            int seleccion = view.getTblinstrumentos().getSelectedRow();
            if (seleccion != -1) {
                int doble = JOptionPane.showConfirmDialog(view,"Desea eliminar este Instrumento ?","Estas Seguro de Completar la Accion?",JOptionPane.YES_NO_OPTION);
                if (doble == JOptionPane.YES_OPTION) {
                    modelo.eliminarDatos(seleccion);
                    view.getTblinstrumentos().clearSelection();
                }
            } else {
                this.view.getTblinstrumentos().updateUI();
                JOptionPane.showMessageDialog(view, "Seleccione el Instrumento a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            }
            this.view.limpiar();
        }








    }
}






