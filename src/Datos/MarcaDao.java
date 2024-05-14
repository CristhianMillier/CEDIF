package Datos;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public interface MarcaDao extends General{
    public void obtenerListaComboMarca(JComboBox<Marca> jComboBox) throws SQLException;
    public Marca buscarIdMarca(Object id) throws SQLException;
    public ArrayList obtenerListaMarca() throws SQLException;
    public ArrayList buscarNombreMarca(Object nombre) throws SQLException;
    public boolean existeMarca(Object nombre) throws SQLException;
}
