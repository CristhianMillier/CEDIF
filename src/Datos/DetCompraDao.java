package Datos;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DetCompraDao extends General{
    public ArrayList obtenerListaDetCompra(int IdCompra) throws SQLException;
    public ArrayList obtenerLista() throws SQLException;
    public DetCompra buscarDetCompra(DetCompra onjDet) throws SQLException;
}
