package Datos;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public interface ProductoDao extends General{
    public boolean actualizarCaducidad(Object caducidad, Object id) throws SQLException;
    public Producto buscarProductoId(Object id) throws SQLException;
    public ArrayList obtenerListaProducto() throws SQLException;
    public ArrayList obtenerListaProductoDescripcion(Object descripcion) throws SQLException;
    public ArrayList obtenerListaAlerta() throws SQLException;
    public void llenarComboProducto(JComboBox<Producto> jComboBox) throws SQLException;
    public boolean actualizarProductoVenta(Producto objP, int cantidad) throws SQLException;
    public boolean actualizarProductoCompra(Producto objP, int cantidad, double precio) throws SQLException;
    public boolean existeProducto(Object objP) throws SQLException;
}
