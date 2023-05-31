package org.example.Modelo;

import org.example.Persistencia.InstrumentoDao;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaInstrumento implements TableModel {
    public static final int Columnas=6;
    private ArrayList<InstrumentoMusical>datos;
    private InstrumentoDao ldao;

    public ModeloTablaInstrumento() {
        ldao = new InstrumentoDao();
        datos = new ArrayList<>();
    }

    public ModeloTablaInstrumento(ArrayList<InstrumentoMusical> datos) {
        this.datos = datos;
        ldao = new InstrumentoDao();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return Columnas;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0:
                return "Id";
            case 1:
                return "Nombre";
            case 2:
                return "Material";
            case 3:
                return "Tipo";
            case 4:
                return "Forma de Tocar";
            case 5:
                return "Imagen";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InstrumentoMusical tmp = datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getNombre();
            case 2:
                return tmp.getMaterial();
            case 3:
                return tmp.getTipo();
            case 4:
                return tmp.getDedosopua();
            case 5:
                return tmp.getURL();
        }
        return null;
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 :
                datos.get(rowIndex).setId((Integer) o);
                break;
            case 1 :
                datos.get(rowIndex).setNombre((String) o);
                break;
            case 2 :
                datos.get(rowIndex).setMaterial((String) o);
                break;
            case 3 :
                datos.get(rowIndex).setTipo((String) o);
                break;
            case 4 :
                datos.get(rowIndex).setDedosopua((String) o);
                break;
            case 5 :
                datos.get(rowIndex).setURL((String) o);
                break;
            default:
                System.out.println("No se Modifica Nada");

        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
    public void cargardatos(){
        try {
            ArrayList<InstrumentoMusical> tirar = ldao.obtenertodo();
            System.out.println(tirar);
            datos = ldao.obtenertodo();
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }


    }
    public boolean agregarInstrumento(InstrumentoMusical instrumento){
        boolean resultado = false;
        try {
            if(ldao.insertar(instrumento)){
                datos.add(instrumento);
                resultado=true;

            }else{
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
       return resultado;
    }
    public InstrumentoMusical getinstrumentoatindex(int idx){
        return datos.get(idx);
    }
}
