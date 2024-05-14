package Datos;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CompraDao extends General{
    public boolean grabarDocumento(byte[] pdf, Object idCompra) throws SQLException;
    public boolean modificarDocumento(byte[] pdf, Object idCompra) throws SQLException;
    public int ultimoIdCompra() throws SQLException;
    public ArrayList obtenerListaCompra() throws SQLException;
    public ArrayList obtenerLista() throws SQLException;
    public Compra buscarCrompra(Object object) throws SQLException;
    public ArrayList buscarCompra(int idComprobante, String nrmComp) throws SQLException;
}
