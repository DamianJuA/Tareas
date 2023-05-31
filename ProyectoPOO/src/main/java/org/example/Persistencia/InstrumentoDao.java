package org.example.Persistencia;

import org.example.Modelo.InstrumentoMusical;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InstrumentoDao implements InterfazDao{
    public InstrumentoDao() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sql="INSERT INTO instrumentos(Nombre, Material, Tipo, Formadetocar, URL) VALUES(?,?,?,?,?)";
        int rowCount = 0;
        PreparedStatement pstm= ConexionSingleton.getInstance("InstrumentosMusicales.db").getConnection().prepareStatement(sql);
        pstm.setString(1, ((InstrumentoMusical)obj).getNombre());
        pstm.setString(2, ((InstrumentoMusical)obj).getMaterial());
        pstm.setString(3, ((InstrumentoMusical)obj).getTipo());
        pstm.setString(4, ((InstrumentoMusical)obj).getDedosopua());
        pstm.setString(5, ((InstrumentoMusical)obj).getURL());
        rowCount=pstm.executeUpdate();
        return rowCount>0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate="UPDATE instrumentos SET Nombre = ?, Material = ?, Tipo= ?, Formadetocar = ?, URL = ? WHERE id = ?;";
        int rowCount = 0;
        PreparedStatement pstm= ConexionSingleton.getInstance("InstrumentosMusicales.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((InstrumentoMusical)obj).getNombre());
        pstm.setString(2, ((InstrumentoMusical)obj).getMaterial());
        pstm.setString(3, ((InstrumentoMusical)obj).getTipo());
        pstm.setString(4, ((InstrumentoMusical)obj).getDedosopua());
        pstm.setString(5, ((InstrumentoMusical)obj).getURL());
        pstm.setInt(3,((InstrumentoMusical)obj).getId());
        rowCount=pstm.executeUpdate();
        return rowCount>0;    }

    @Override
    public boolean delet(String id) throws SQLException {
        String sqlDelete = "DELETE FROM instrumentos WHERE id = ? ;";
        int rowCount=0;
        PreparedStatement pstm = ConexionSingleton.getInstance("InstrumentosMusicales.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1,Integer.parseInt(id));
        rowCount= pstm.executeUpdate();
        return rowCount>0;
    }

    @Override
    public ArrayList obtenertodo() throws SQLException {
        String sql = "SELECT * FROM instrumentos";
        ArrayList<InstrumentoMusical>resultado= new ArrayList<>();

            Statement stm = ConexionSingleton.getInstance("InstrumentosMusicales.db").getConnection().createStatement();
            ResultSet rst= stm.executeQuery(sql);
            while (rst.next()){
                resultado.add(new InstrumentoMusical(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
            }



        return resultado;
    }

    @Override
    public Object BuscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM instrumentos WHERE id = ? ";
        InstrumentoMusical instrumento=null;
        try{
            PreparedStatement pstm = ConexionSingleton.getInstance("InstrumentosMusicales.db").getConnection().prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            ResultSet rst = pstm.executeQuery();
            if (rst.next()){
                instrumento = new InstrumentoMusical(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6));
            }
        }catch (SQLException sqle){
            System.out.println("Error al buscar");
        }
        return instrumento;
    }
}
