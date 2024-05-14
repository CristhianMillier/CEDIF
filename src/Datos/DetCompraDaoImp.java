package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DetCompraDaoImp implements DetCompraDao {

    private PreparedStatement pst;
    private Statement st;
    private Connection con;
    private ResultSet rs;
    private DetCompra objDC;

    public DetCompraDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objDC = (DetCompra) object;
        try {
            String sql = "insert into Detalle_Compra (precio, cantidad, idCompra, idProducto) values (?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setDouble(1, objDC.getPrecio());
            pst.setInt(2, objDC.getCantidad());
            pst.setInt(3, objDC.getObjC().getId());
            pst.setInt(4, objDC.getObjP().getId());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        int idCompra = (int) object;
        try {
            String sql = "delete from Detalle_Compra WHERE idCompra = " + idCompra;
            pst = con.prepareStatement(sql);
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean modificar(Object object) throws SQLException {
        objDC = (DetCompra) object;
        try {
            String sql = "UPDATE Detalle_Compra SET precio=?, cantidad=?, idCompra=?, idProducto=? WHERE id = " + objDC.getId();
            pst = con.prepareStatement(sql);
            pst.setDouble(1, objDC.getPrecio());
            pst.setInt(2, objDC.getCantidad());
            pst.setInt(3, objDC.getObjC().getId());
            pst.setInt(4, objDC.getObjP().getId());
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public ArrayList obtenerListaDetCompra(int IdCompra) throws SQLException {
        ArrayList<DetCompra> ltsDetCompra = new ArrayList();
        try {
            String sql = "select * FROM Detalle_Compra where idCompra = " + IdCompra;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                objDC = new DetCompra();
                objDC.setId(rs.getInt(1));
                objDC.setPrecio(rs.getDouble(2));
                objDC.setCantidad(rs.getInt(3));

                Compra objCom = null;
                CompraDao objCompra = new CompraDaoImp(this.con);
                ArrayList<Compra> ltsCompra = objCompra.obtenerLista();
                for (Compra C : ltsCompra) {
                    if (C.getId() == IdCompra) {
                        objCom = C;
                    }
                }
                objDC.setObjC(objCom);

                ProductoDao objP = new ProductoDaoImp(con);
                objDC.setObjP(objP.buscarProductoId(rs.getInt(5)));

                ltsDetCompra.add(objDC);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsDetCompra;
    }

    @Override
    public ArrayList obtenerLista() throws SQLException {
        ArrayList<DetCompra> ltsDetCompra = new ArrayList();
        try {
            String sql = "select * FROM Detalle_Compra ";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                objDC = new DetCompra();
                objDC.setId(rs.getInt(1));
                objDC.setPrecio(rs.getDouble(2));
                objDC.setCantidad(rs.getInt(3));

                Compra objCom = null;
                CompraDao objCompra = new CompraDaoImp(this.con);
                ArrayList<Compra> ltsCompra = objCompra.obtenerLista();
                for (Compra C : ltsCompra) {
                    if (C.getId() == rs.getInt(4)) {
                        objCom = C;
                    }
                }
                objDC.setObjC(objCom);

                ProductoDao objP = new ProductoDaoImp(con);
                objDC.setObjP(objP.buscarProductoId(rs.getInt(5)));

                ltsDetCompra.add(objDC);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsDetCompra;
    }

    @Override
    public DetCompra buscarDetCompra(DetCompra onjDet) throws SQLException {
        this.objDC = null;
        try {
            String sql = "select * from Detalle_Compra where idProducto = " + onjDet.getObjP().getId()
                    + " and idCompra = " + onjDet.getObjC().getId();
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                this.objDC = new DetCompra();
                this.objDC.setId(rs.getInt(1));
                this.objDC.setPrecio(rs.getDouble(2));
                this.objDC.setCantidad(rs.getInt(3));

                Compra objCom = null;
                CompraDao objCompra = new CompraDaoImp(this.con);
                ArrayList<Compra> ltsCompra = objCompra.obtenerLista();
                for (Compra C : ltsCompra) {
                    if (C.getId() == rs.getInt(4)) {
                        objCom = C;
                    }
                }
                this.objDC.setObjC(objCom);

                ProductoDao objP = new ProductoDaoImp(con);
                this.objDC.setObjP(objP.buscarProductoId(rs.getInt(5)));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return this.objDC;
    }
}
