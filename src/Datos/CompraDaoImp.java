package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CompraDaoImp implements CompraDao {

    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Compra objC;

    public CompraDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objC = (Compra) object;
        try {
            String sql = "insert into Compra (pago, fecha, estado, num_comprobante, idComprobante, idProveedor, idPersonal) "
                    + "values (?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setDouble(1, objC.getPago());
            pst.setString(2, objC.getFecha());
            pst.setInt(3, 1);
            pst.setString(4, objC.getNroComprobante());
            pst.setInt(5, objC.getObjComp().getId());
            pst.setInt(6, objC.getObjProvee().getId());
            pst.setInt(7, objC.getObjPer().getId());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        objC = (Compra) object;
        try {
            String sql = "UPDATE Compra SET estado=? WHERE id = " + objC.getId();
            pst = con.prepareStatement(sql);
            pst.setInt(1, 2);
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean modificar(Object object) throws SQLException {
        objC = (Compra) object;
        try {
            String sql = "UPDATE Compra SET pago=?, fecha=?, estado=?, num_comprobante=?, idComprobante=?, idProveedor=?, "
                    + "idPersonal=? WHERE id = " + objC.getId();
            pst = con.prepareStatement(sql);
            pst.setDouble(1, objC.getPago());
            pst.setString(2, objC.getFecha());
            pst.setInt(3, 1);
            pst.setString(4, objC.getNroComprobante());
            pst.setInt(5, objC.getObjComp().getId());
            pst.setInt(6, objC.getObjProvee().getId());
            pst.setInt(7, objC.getObjPer().getId());
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public ArrayList obtenerListaCompra() throws SQLException {
        ArrayList<Compra> ltsCompra = new ArrayList();
        try {
            String sql = "select * FROM Compra where estado = 1";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Compra();
                objC.setId(rs.getInt(1));
                objC.setPago(rs.getDouble(2));
                objC.setFecha(rs.getString(3));
                objC.setEstado(rs.getInt(4));
                objC.setNroComprobante(rs.getString(5));
                objC.setDocumentoPDF(rs.getBytes(6));

                ComprobanteDao objComp = new ComprobanteDaoImp(con);
                objC.setObjComp(objComp.buscarId(rs.getInt(7)));

                ProveedorDao objProv = new ProveedorDaoImp(con);
                objC.setObjProd(objProv.buscarIdProveedor(rs.getInt(8)));

                PersonalDao objPer = new PersonalDaoImp(con);
                objC.setObjPer(objPer.buscarIdPersonal(rs.getInt(9)));
                ltsCompra.add(objC);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsCompra;
    }

    @Override
    public ArrayList obtenerLista() throws SQLException {
        ArrayList<Compra> ltsCompra = new ArrayList();
        try {
            String sql = "select * FROM Compra";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Compra();
                objC.setId(rs.getInt(1));
                objC.setPago(rs.getDouble(2));
                objC.setFecha(rs.getString(3));
                objC.setEstado(rs.getInt(4));
                objC.setNroComprobante(rs.getString(5));
                objC.setDocumentoPDF(rs.getBytes(6));

                ComprobanteDao objComp = new ComprobanteDaoImp(con);
                objC.setObjComp(objComp.buscarId(rs.getInt(7)));

                ProveedorDao objProv = new ProveedorDaoImp(con);
                objC.setObjProd(objProv.buscarIdProveedor(rs.getInt(8)));

                PersonalDao objPer = new PersonalDaoImp(con);
                objC.setObjPer(objPer.buscarIdPersonal(rs.getInt(9)));
                ltsCompra.add(objC);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsCompra;
    }

    @Override
    public Compra buscarCrompra(Object object) throws SQLException {
        objC = (Compra) object;
        try {
            String sql = "select * from Compra where Num_Comprobante LIKE '" + objC.getNroComprobante()
                    + "%' and idComprobante = " + objC.getObjComp().getId();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Compra();
                objC.setId(rs.getInt(1));
                objC.setPago(rs.getDouble(2));
                objC.setFecha(rs.getString(3));
                objC.setEstado(rs.getInt(4));
                objC.setNroComprobante(rs.getString(5));
                objC.setDocumentoPDF(rs.getBytes(6));

                ComprobanteDao objComp = new ComprobanteDaoImp(con);
                objC.setObjComp(objComp.buscarId(rs.getInt(7)));

                ProveedorDao objProv = new ProveedorDaoImp(con);
                objC.setObjProd(objProv.buscarIdProveedor(rs.getInt(8)));

                PersonalDao objPer = new PersonalDaoImp(con);
                objC.setObjPer(objPer.buscarIdPersonal(rs.getInt(9)));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objC;
    }

    @Override
    public boolean grabarDocumento(byte[] pdf, Object idCompra) throws SQLException {
        try {
            String sql = "UPDATE Compra set comprobantePDF=? "
                    + "where  id = " + (Integer) idCompra;
            pst = con.prepareStatement(sql);
            pst.setBytes(1, pdf);
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean modificarDocumento(byte[] pdf, Object idCompra) throws SQLException {
        try {
            String sql = "UPDATE Compra set comprobantePDF=? "
                    + "where  id = " + (Integer) idCompra;
            pst = con.prepareStatement(sql);
            pst.setBytes(1, pdf);
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public int ultimoIdCompra() throws SQLException {
        int id = 0;
        try {
            String sql = "select max(id) from Compra";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt(1);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return id;
    }

    @Override
    public ArrayList buscarCompra(int idComprobante, String nrmComp) throws SQLException {
        ArrayList<Compra> ltsCompra = new ArrayList();
        try {
            String sql = "select * from Compra where Num_Comprobante LIKE '" + nrmComp
                    + "%' and estado = 1 and idComprobante = " + idComprobante;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Compra();
                objC.setId(rs.getInt(1));
                objC.setPago(rs.getDouble(2));
                objC.setFecha(rs.getString(3));
                objC.setEstado(rs.getInt(4));
                objC.setNroComprobante(rs.getString(5));
                objC.setDocumentoPDF(rs.getBytes(6));

                ComprobanteDao objComp = new ComprobanteDaoImp(con);
                objC.setObjComp(objComp.buscarId(rs.getInt(7)));

                ProveedorDao objProv = new ProveedorDaoImp(con);
                objC.setObjProd(objProv.buscarIdProveedor(rs.getInt(8)));

                PersonalDao objPer = new PersonalDaoImp(con);
                objC.setObjPer(objPer.buscarIdPersonal(rs.getInt(9)));
                ltsCompra.add(objC);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsCompra;
    }
}
