package Datos;

import java.sql.SQLException;
import javax.swing.JComboBox;

public interface ComprobanteDao extends General{
    public void obtenerListaComboTipComp(JComboBox<Comprobante> jComboBox) throws SQLException;
    public Comprobante buscarId(Object id) throws SQLException;
}
