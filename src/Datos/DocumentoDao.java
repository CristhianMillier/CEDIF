package Datos;

import java.sql.SQLException;
import javax.swing.JComboBox;

public interface DocumentoDao extends General{
    public void obtenerListaComboTipDoc(JComboBox<Documento> jComboBox) throws SQLException;
    public Documento buscarId(Object id) throws SQLException;
}
