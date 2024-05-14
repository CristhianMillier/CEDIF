package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class ProductoDaoImp implements ProductoDao {

    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Producto objP;

    public ProductoDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objP = (Producto) object;
        try {
            String sql = "INSERT INTO Producto(descripcion, cantidad, precio, estado, idUnidadMedida, idCategoria, idMarca)"
                    + " VALUES (?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objP.getDescripcion());
            pst.setInt(2, objP.getCantidad());
            pst.setDouble(3, objP.getPrecio());
            pst.setInt(4, 1);
            pst.setInt(5, objP.getObjUM().getId());
            pst.setInt(6, objP.getObjC().getId());
            pst.setInt(7, objP.getObjM().getId());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        objP = (Producto) object;
        try {
            String sql = "UPDATE Producto SET estado=? where id = " + objP.getId();
            pst = con.prepareStatement(sql);
            pst.setInt(1, 0);
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean modificar(Object object) throws SQLException {
        objP = (Producto) object;
        try {
            String sql = "UPDATE Producto SET descripcion=?, estado=?, idUnidadMedida=?, idCategoria=?, "
                    + "idMarca=? where id = " + objP.getId();
            pst = con.prepareStatement(sql);
            pst.setString(1, objP.getDescripcion());
            pst.setInt(2, objP.getEstado());
            pst.setInt(3, objP.getObjUM().getId());
            pst.setInt(4, objP.getObjC().getId());
            pst.setInt(5, objP.getObjM().getId());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public ArrayList obtenerListaProducto() throws SQLException {
        ArrayList<Producto> ltsProducto = new ArrayList();
        try {
            String sql = "SELECT * FROM Producto order by descripcion";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Producto();
                objP.setId(rs.getInt(1));
                objP.setDescripcion(rs.getString(2));
                objP.setCantidad(rs.getInt(3));
                objP.setPrecio(rs.getDouble(4));
                objP.setFecha_caduca(rs.getString(5));
                objP.setEstado(rs.getInt(6));

                UnidadMedidaDao objUM = new UnidadMedidaDaoImp(con);
                objP.setObjUM(objUM.buscarIdUnidadMedida(rs.getInt(7)));

                CategoriaDao objC = new CategoriaDaoImp(con);
                objP.setObjC(objC.buscarIdCategoria(rs.getInt(8)));

                MarcaDao objM = new MarcaDaoImp(con);
                objP.setObjM(objM.buscarIdMarca(rs.getInt(9)));

                ltsProducto.add(objP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsProducto;
    }

    @Override
    public ArrayList obtenerListaProductoDescripcion(Object descripcion) throws SQLException {
        ArrayList<Producto> ltsProducto = new ArrayList();
        try {
            String sql = "SELECT * FROM Producto where descripcion LIKE '" + String.valueOf(descripcion) + "%' order by descripcion";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Producto();
                objP.setId(rs.getInt(1));
                objP.setDescripcion(rs.getString(2));
                objP.setCantidad(rs.getInt(3));
                objP.setPrecio(rs.getDouble(4));
                objP.setFecha_caduca(rs.getString(5));
                objP.setEstado(rs.getInt(6));

                UnidadMedidaDao objUM = new UnidadMedidaDaoImp(con);
                objP.setObjUM(objUM.buscarIdUnidadMedida(rs.getInt(7)));

                CategoriaDao objC = new CategoriaDaoImp(con);
                objP.setObjC(objC.buscarIdCategoria(rs.getInt(8)));

                MarcaDao objM = new MarcaDaoImp(con);
                objP.setObjM(objM.buscarIdMarca(rs.getInt(9)));

                ltsProducto.add(objP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsProducto;
    }

    @Override
    public ArrayList obtenerListaAlerta() throws SQLException {
        ArrayList<Producto> ltsProducto = new ArrayList();
        try {
            String sql = "SELECT * FROM Producto where fecha_caducidad IS NOT NULL and fecha_caducidad >= "
                    + "DATEADD(DAY, -7, CAST(GETDATE() AS DATE)) and cantidad > 0 order by descripcion";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Producto();
                objP.setId(rs.getInt(1));
                objP.setDescripcion(rs.getString(2));
                objP.setCantidad(rs.getInt(3));
                objP.setPrecio(rs.getDouble(4));
                objP.setFecha_caduca(rs.getString(5));
                objP.setEstado(rs.getInt(6));

                UnidadMedidaDao objUM = new UnidadMedidaDaoImp(con);
                objP.setObjUM(objUM.buscarIdUnidadMedida(rs.getInt(7)));

                CategoriaDao objC = new CategoriaDaoImp(con);
                objP.setObjC(objC.buscarIdCategoria(rs.getInt(8)));

                MarcaDao objM = new MarcaDaoImp(con);
                objP.setObjM(objM.buscarIdMarca(rs.getInt(9)));

                ltsProducto.add(objP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsProducto;
    }

    @Override
    public void llenarComboProducto(JComboBox<Producto> jComboBox) throws SQLException {
        try {
            String sql = "SELECT * FROM Producto where estado = 1 order by descripcion";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Producto();
                objP.setId(rs.getInt(1));
                objP.setDescripcion(rs.getString(2));
                objP.setCantidad(rs.getInt(3));
                objP.setPrecio(rs.getDouble(4));
                objP.setFecha_caduca(rs.getString(5));
                objP.setEstado(rs.getInt(6));

                UnidadMedidaDao objUM = new UnidadMedidaDaoImp(con);
                objP.setObjUM(objUM.buscarIdUnidadMedida(rs.getInt(7)));

                CategoriaDao objC = new CategoriaDaoImp(con);
                objP.setObjC(objC.buscarIdCategoria(rs.getInt(8)));

                MarcaDao objM = new MarcaDaoImp(con);
                objP.setObjM(objM.buscarIdMarca(rs.getInt(9)));
                jComboBox.addItem(objP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean actualizarProductoVenta(Producto objP, int cantidad) throws SQLException {
        int stock = 0;
        try {
            String modificar = "SELECT cantidad FROM Producto where id = " + objP.getId();
            st = con.createStatement();
            rs = st.executeQuery(modificar);
            while (rs.next()) {
                stock = rs.getInt(1);
            }
            stock = stock - cantidad;
            String sql = "UPDATE  Producto SET cantidad=? WHERE id = " + objP.getId();
            pst = con.prepareStatement(sql);
            pst.setInt(1, stock);
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean actualizarCaducidad(Object caducidad, Object id) throws SQLException {
        try {
            String sql = "UPDATE Producto SET fecha_caducidad=? where id = " + (Integer) id;
            pst = con.prepareStatement(sql);
            if (String.valueOf(caducidad).trim().equals("")) {
                pst.setString(1, null);
            } else {
                pst.setString(1, String.valueOf(caducidad));
            }
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Producto buscarProductoId(Object id) throws SQLException {
        objP = null;
        try {
            String sql = "SELECT * FROM Producto where id = " + (Integer) id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Producto();
                objP.setId(rs.getInt(1));
                objP.setDescripcion(rs.getString(2));
                objP.setCantidad(rs.getInt(3));
                objP.setPrecio(rs.getDouble(4));
                objP.setFecha_caduca(rs.getString(5));
                objP.setEstado(rs.getInt(6));

                UnidadMedidaDao objUM = new UnidadMedidaDaoImp(con);
                objP.setObjUM(objUM.buscarIdUnidadMedida(rs.getInt(7)));

                CategoriaDao objC = new CategoriaDaoImp(con);
                objP.setObjC(objC.buscarIdCategoria(rs.getInt(8)));

                MarcaDao objM = new MarcaDaoImp(con);
                objP.setObjM(objM.buscarIdMarca(rs.getInt(9)));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objP;
    }

    @Override
    public boolean existeProducto(Object objP) throws SQLException {
        this.objP = (Producto) objP;
        boolean estado = true;
        try {
            String sql = "SELECT * FROM Producto where descripcion = '" + this.objP.getDescripcion() + "' and idUnidadMedida = " 
                    + this.objP.getObjUM().getId() + " and idCategoria = " + this.objP.getObjC().getId() + " and idMarca = " 
                    + this.objP.getObjM().getId();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                estado = false;
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return estado;
    }

    @Override
    public boolean actualizarProductoCompra(Producto objP, int cantidad, double precio) throws SQLException {
        int stock = 0;
        try {
            String modificar = "SELECT cantidad FROM Producto where id = " + objP.getId();
            st = con.createStatement();
            rs = st.executeQuery(modificar);
            while (rs.next()) {
                stock = rs.getInt(1);
            }
            stock = stock + cantidad;
            String sql = "UPDATE  Producto SET cantidad=?, precio=? WHERE id = " + objP.getId();
            pst = con.prepareStatement(sql);
            pst.setInt(1, stock);
            pst.setDouble(2, precio);
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

}
