package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Detalle_PreparacionDaoImp implements Detalle_PreparacionDao {

    private PreparedStatement pst;
    private Statement st;
    private Connection con;
    private ResultSet rs;
    private Detalle_Preparacion objDP;

    public Detalle_PreparacionDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objDP = (Detalle_Preparacion) object;
        try {
            String sql = "insert into Detalle_Preparacion (cantidad, idPreparacionAlimento, idProducto) values (?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setDouble(1, objDP.getCantidad());
            pst.setInt(2, objDP.getObjPA().getId());
            pst.setInt(3, objDP.getObjP().getId());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        int idPreparacion = (int) object;
        try {
            String sql = "delete from Detalle_Preparacion WHERE idPreparacionAlimento = " + idPreparacion;
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
        objDP = (Detalle_Preparacion) object;
        try {
            String sql = "UPDATE Detalle_Preparacion SET cantidad=?, idPreparacionAlimento=?, idProducto=? WHERE id = " + objDP.getId();
            pst = con.prepareStatement(sql);
            pst.setDouble(1, objDP.getCantidad());
            pst.setInt(2, objDP.getObjPA().getId());
            pst.setInt(3, objDP.getObjP().getId());
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public ArrayList obtenerListaDetPreparacion(int IdPreparacion) throws SQLException {
        ArrayList<Detalle_Preparacion> ltsDetalle_Preparacion = new ArrayList();
        try {
            String sql = "select * FROM Detalle_Preparacion where idPreparacionAlimento = " + IdPreparacion;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                objDP = new Detalle_Preparacion();
                objDP.setId(rs.getInt(1));
                objDP.setCantidad(rs.getInt(2));

                PreparacionAlimento objPreA = null;
                PreparacionAlimentoDao objPreAlimento = new PreparacionAlimentoDaoImp(this.con);
                ArrayList<PreparacionAlimento> ltsPreparacionAlimento = objPreAlimento.obtenerLista();
                for (PreparacionAlimento P : ltsPreparacionAlimento) {
                    if (P.getId() == IdPreparacion) {
                        objPreA = P;
                    }
                }
                objDP.setObjPA(objPreA);

                ProductoDao objP = new ProductoDaoImp(con);
                objDP.setObjP(objP.buscarProductoId(rs.getInt(4)));

                ltsDetalle_Preparacion.add(objDP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsDetalle_Preparacion;
    }

    @Override
    public ArrayList obtenerLista() throws SQLException {
        ArrayList<Detalle_Preparacion> ltsDetalle_Preparacion = new ArrayList();
        try {
            String sql = "select * FROM Detalle_Preparacion ";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                objDP = new Detalle_Preparacion();
                objDP.setId(rs.getInt(1));
                objDP.setCantidad(rs.getInt(2));

                PreparacionAlimento objPreA = null;
                PreparacionAlimentoDao objPreAlimento = new PreparacionAlimentoDaoImp(this.con);
                ArrayList<PreparacionAlimento> ltsPreparacionAlimento = objPreAlimento.obtenerLista();
                for (PreparacionAlimento P : ltsPreparacionAlimento) {
                    if (P.getId() == rs.getInt(3)) {
                        objPreA = P;
                    }
                }
                objDP.setObjPA(objPreA);

                ProductoDao objP = new ProductoDaoImp(con);
                objDP.setObjP(objP.buscarProductoId(rs.getInt(4)));

                ltsDetalle_Preparacion.add(objDP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsDetalle_Preparacion;
    }

    @Override
    public Detalle_Preparacion buscarDetPreparacion(Detalle_Preparacion onjDet) throws SQLException {
        this.objDP = null;
        try {
            String sql = "select * from Detalle_Preparacion where idProducto = " + onjDet.getObjP().getId()
                    + " and idPreparacionAlimento = " + onjDet.getObjPA().getId();
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                objDP = new Detalle_Preparacion();
                objDP.setId(rs.getInt(1));
                objDP.setCantidad(rs.getInt(2));

                PreparacionAlimento objPreA = null;
                PreparacionAlimentoDao objPreAlimento = new PreparacionAlimentoDaoImp(this.con);
                ArrayList<PreparacionAlimento> ltsPreparacionAlimento = objPreAlimento.obtenerLista();
                for (PreparacionAlimento P : ltsPreparacionAlimento) {
                    if (P.getId() == rs.getInt(3)) {
                        objPreA = P;
                    }
                }
                objDP.setObjPA(objPreA);

                ProductoDao objP = new ProductoDaoImp(con);
                objDP.setObjP(objP.buscarProductoId(rs.getInt(4)));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return this.objDP;
    }
}
