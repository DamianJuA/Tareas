package org.example.Persistencia;

import java.sql.SQLException;
import  java.util.ArrayList;
public interface InterfazDao {
    public abstract  boolean insertar(Object obj)throws SQLException;
    public abstract  boolean update(Object obj)throws SQLException;
    public abstract  boolean delet(String id)throws SQLException;
    public abstract  ArrayList obtenertodo()throws SQLException;
    public abstract  Object BuscarPorId(String id)throws SQLException;
}
