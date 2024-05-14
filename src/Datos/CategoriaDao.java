package Datos;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public interface CategoriaDao extends General{
    public void obtenerListaComboCategoria(JComboBox<Categoria> jComboBox) throws SQLException;
    public Categoria buscarIdCategoria(Object id) throws SQLException;
    public ArrayList obtenerListaCategoria() throws SQLException;
    public ArrayList buscarNombreCategoria(Object nombre) throws SQLException;
    public boolean existeCategoria(Object nombre) throws SQLException;
}
