package Datos;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public interface ProveedorDao extends General{
    public ArrayList obtenerListaProveedor() throws SQLException;
    public void obtenerListaCombProveedor(JComboBox<Proveedor> jComboBox) throws SQLException;
    public Proveedor buscarIdProveedor(Object id) throws SQLException;
    public ArrayList buscarDNIProveedor(Object dni) throws SQLException;
    public ArrayList buscarRazonSocialProveedor(Object razonSocial) throws SQLException;
    public boolean buscarDNI(Object DNI)throws SQLException;
    public boolean buscarRazonSocial(Object razonSocial) throws SQLException;
}
