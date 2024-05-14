package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class ProveedorDaoImp implements ProveedorDao {

    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Proveedor objP;

    public ProveedorDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objP = (Proveedor) object;
        try {
            String sql = "insert into Proveedor (razon_social, nro_documento, idDocumento, estado) values (?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objP.getRazonSocial());
            pst.setString(2, objP.getNrodocumento());
            pst.setInt(3, objP.getObjD().getId());
            pst.setInt(4, 1);
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        objP = (Proveedor) object;
        try {
            String sql = "UPDATE Proveedor SET estado=? where id = " + objP.getId();
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
        objP = (Proveedor) object;
        try {
            String sql = "UPDATE Proveedor SET razon_social=?, nro_documento=?, idDocumento=?, "
                    + "estado=? where id = " + objP.getId();
            pst = con.prepareStatement(sql);
            pst.setString(1, objP.getRazonSocial());
            pst.setString(2, objP.getNrodocumento());
            pst.setInt(3, objP.getObjD().getId());
            pst.setInt(4, objP.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public ArrayList obtenerListaProveedor() throws SQLException {
        ArrayList<Proveedor> ltsProveedor = new ArrayList();
        try {
            String sql = "SELECT * FROM Proveedor order by razon_social";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Proveedor();
                objP.setId(rs.getInt(1));
                objP.setRazonSocial(rs.getString(2));
                objP.setNrodocumento(rs.getString(3));

                DocumentoDao objD = new DocumentoDaoImp(con);
                objP.setObjD(objD.buscarId(rs.getInt(4)));

                objP.setEstado(rs.getInt(5));
                ltsProveedor.add(objP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsProveedor;
    }

    @Override
    public void obtenerListaCombProveedor(JComboBox<Proveedor> jComboBox) throws SQLException {
        try {
            String sql = "select * FROM Proveedor where estado = 1 order by razon_social";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Proveedor();
                objP.setId(rs.getInt(1));
                objP.setRazonSocial(rs.getString(2));
                objP.setNrodocumento(rs.getString(3));

                DocumentoDao objD = new DocumentoDaoImp(con);
                objP.setObjD(objD.buscarId(rs.getInt(4)));

                objP.setEstado(rs.getInt(5));
                jComboBox.addItem(objP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Proveedor buscarIdProveedor(Object id) throws SQLException {
        objP = null;
        try {
            String sql = "SELECT * FROM Proveedor where id = " + (Integer) id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Proveedor();
                objP.setId(rs.getInt(1));
                objP.setRazonSocial(rs.getString(2));
                objP.setNrodocumento(rs.getString(3));

                DocumentoDao objD = new DocumentoDaoImp(con);
                objP.setObjD(objD.buscarId(rs.getInt(4)));

                objP.setEstado(rs.getInt(5));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objP;
    }

    @Override
    public ArrayList buscarDNIProveedor(Object dni) throws SQLException {
        ArrayList<Proveedor> ltsProveedor = new ArrayList();
        try {
            String sql = "SELECT * FROM Proveedor where nro_documento LIKE '" + (String) dni + "%' order by razon_social";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Proveedor();
                objP.setId(rs.getInt(1));
                objP.setRazonSocial(rs.getString(2));
                objP.setNrodocumento(rs.getString(3));

                DocumentoDao objD = new DocumentoDaoImp(con);
                objP.setObjD(objD.buscarId(rs.getInt(4)));

                objP.setEstado(rs.getInt(5));
                ltsProveedor.add(objP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsProveedor;
    }

    @Override
    public ArrayList buscarRazonSocialProveedor(Object razonSocial) throws SQLException {
        ArrayList<Proveedor> ltsProveedor = new ArrayList();
        try {
            String sql = "SELECT * FROM Proveedor where razon_social LIKE '" + (String) razonSocial + "%' order by razon_social";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Proveedor();
                objP.setId(rs.getInt(1));
                objP.setRazonSocial(rs.getString(2));
                objP.setNrodocumento(rs.getString(3));

                DocumentoDao objD = new DocumentoDaoImp(con);
                objP.setObjD(objD.buscarId(rs.getInt(4)));

                objP.setEstado(rs.getInt(5));
                ltsProveedor.add(objP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsProveedor;
    }

    @Override
    public boolean buscarDNI(Object DNI) throws SQLException {
        boolean estado = true;
        try {
            String sql = "SELECT * FROM Proveedor where nro_documento = '" + String.valueOf(DNI) + "'";
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
    public boolean buscarRazonSocial(Object razonSocial) throws SQLException {
        boolean estado = true;
        try {
            String sql = "SELECT * FROM Proveedor where razon_social = '" + String.valueOf(razonSocial) + "'";
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
}
