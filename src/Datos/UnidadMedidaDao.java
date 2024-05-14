package Datos;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public interface UnidadMedidaDao extends General{
    public void obtenerListaComboUnidadMedida(JComboBox<UnidadMedida> jComboBox) throws SQLException;
    public UnidadMedida buscarIdUnidadMedida(Object id) throws SQLException;
    public ArrayList obtenerListaUnidadMedida() throws SQLException;
    public ArrayList buscarNombreUnidadMedida(Object nombre) throws SQLException;
    public ArrayList buscarNombreUnidadMedidaCorto(Object abreviacion) throws SQLException;
    public boolean existeUnidadMedida(Object nombre) throws SQLException;
}
