package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class PersonalDaoImp implements PersonalDao {

    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Personal objP;

    public PersonalDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objP = (Personal) object;
        try {
            String sql = "insert into Personal (nombre, apellido, nro_documento, estado, idDocumento, idCargo) values (?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objP.getNombre());
            pst.setString(2, objP.getApellido());
            pst.setString(3, objP.getNro_documento());
            pst.setInt(4, 1);
            pst.setInt(5, objP.getIdDocumento().getId());
            pst.setInt(6, objP.getIdCargo().getIdCargo());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        objP = (Personal) object;
        try {
            String sql = "UPDATE Personal SET estado=? where id = " + objP.getId();
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
        objP = (Personal) object;
        try {
            String sql = "UPDATE Personal SET nombre=?, apellido=?, nro_documento=?, estado=?, "
                    + "idDocumento=?, idCargo=? where id = " + objP.getId();
            pst = con.prepareStatement(sql);
            pst.setString(1, objP.getNombre());
            pst.setString(2, objP.getApellido());
            pst.setString(3, objP.getNro_documento());
            pst.setInt(4, objP.getEstado());
            pst.setInt(5, objP.getIdDocumento().getId());
            pst.setInt(6, objP.getIdCargo().getIdCargo());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public ArrayList obtenerListaPersonal() throws SQLException {
        ArrayList<Personal> ltsPersonal = new ArrayList();
        try {
            String sql = "SELECT * FROM Personal order by apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Personal();
                objP.setId(rs.getInt(1));
                objP.setNombre(rs.getString(2));
                objP.setApellido(rs.getString(3));
                objP.setNro_documento(rs.getString(4));
                objP.setEstado(rs.getInt(5));
                DocumentoDao objD = new DocumentoDaoImp(con);
                objP.setIdDocumento(objD.buscarId(rs.getInt(6)));
                CargoDao objC = new CargoDaoImp(con);
                objP.setIdCargo(objC.buscarIdCargo(rs.getInt(7)));
                ltsPersonal.add(objP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsPersonal;
    }

    @Override
    public int obtenerUltimoId() throws SQLException {
        int id = 0;
        try {
            String sql = "select max(id) from Personal";
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
    public void obtenerListaCombPersonal(JComboBox<Personal> jComboBox) throws SQLException {
        try {
            String sql = "select * FROM Personal where estado = 1 order by apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Personal();
                objP.setId(rs.getInt(1));
                objP.setNombre(rs.getString(2));
                objP.setApellido(rs.getString(3));
                objP.setNro_documento(rs.getString(4));
                objP.setEstado(rs.getInt(5));
                DocumentoDao objD = new DocumentoDaoImp(con);
                objP.setIdDocumento(objD.buscarId(rs.getInt(6)));
                CargoDao objC = new CargoDaoImp(con);
                objP.setIdCargo(objC.buscarIdCargo(rs.getInt(7)));
                jComboBox.addItem(objP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Personal buscarIdPersonal(Object id) throws SQLException {
        objP = null;
        try {
            String sql = "SELECT * FROM Personal where id = " + (Integer) id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Personal();
                objP.setId(rs.getInt(1));
                objP.setNombre(rs.getString(2));
                objP.setApellido(rs.getString(3));
                objP.setNro_documento(rs.getString(4));
                objP.setEstado(rs.getInt(5));
                DocumentoDao objD = new DocumentoDaoImp(con);
                objP.setIdDocumento(objD.buscarId(rs.getInt(6)));
                CargoDao objC = new CargoDaoImp(con);
                objP.setIdCargo(objC.buscarIdCargo(rs.getInt(7)));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objP;
    }

    @Override
    public ArrayList buscarDNIPersonal(Object dni) throws SQLException {
        ArrayList<Personal> ltsPersonal = new ArrayList();
        try {
            String sql = "SELECT * FROM Personal where nro_documento LIKE '" + (String) dni + "%' order by apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Personal();
                objP.setId(rs.getInt(1));
                objP.setNombre(rs.getString(2));
                objP.setApellido(rs.getString(3));
                objP.setNro_documento(rs.getString(4));
                objP.setEstado(rs.getInt(5));
                DocumentoDao objD = new DocumentoDaoImp(con);
                objP.setIdDocumento(objD.buscarId(rs.getInt(6)));
                CargoDao objC = new CargoDaoImp(con);
                objP.setIdCargo(objC.buscarIdCargo(rs.getInt(7)));
                ltsPersonal.add(objP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsPersonal;
    }

    @Override
    public ArrayList buscarApellidoPersonal(Object apellido) throws SQLException {
        ArrayList<Personal> ltsPersonal = new ArrayList();
        try {
            String sql = "SELECT * FROM Personal where apellido LIKE '" + (String) apellido + "%' order by apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Personal();
                objP.setId(rs.getInt(1));
                objP.setNombre(rs.getString(2));
                objP.setApellido(rs.getString(3));
                objP.setNro_documento(rs.getString(4));
                objP.setEstado(rs.getInt(5));
                DocumentoDao objD = new DocumentoDaoImp(con);
                objP.setIdDocumento(objD.buscarId(rs.getInt(6)));
                CargoDao objC = new CargoDaoImp(con);
                objP.setIdCargo(objC.buscarIdCargo(rs.getInt(7)));
                ltsPersonal.add(objP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsPersonal;
    }

    @Override
    public ArrayList buscarNombrePersonal(Object nombre) throws SQLException {
        ArrayList<Personal> ltsPersonal = new ArrayList();
        try {
            String sql = "SELECT * FROM Personal where nombre LIKE '" + (String) nombre + "%' order by apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objP = new Personal();
                objP.setId(rs.getInt(1));
                objP.setNombre(rs.getString(2));
                objP.setApellido(rs.getString(3));
                objP.setNro_documento(rs.getString(4));
                objP.setEstado(rs.getInt(5));
                DocumentoDao objD = new DocumentoDaoImp(con);
                objP.setIdDocumento(objD.buscarId(rs.getInt(6)));
                CargoDao objC = new CargoDaoImp(con);
                objP.setIdCargo(objC.buscarIdCargo(rs.getInt(7)));
                ltsPersonal.add(objP);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsPersonal;
    }

    @Override
    public boolean buscarDNI(Object DNI) throws SQLException {
        boolean estado = true;
        try {
            String sql = "SELECT * FROM Personal where nro_documento = '" + String.valueOf(DNI) + "'";
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
    public boolean buscarUser(Object user) throws SQLException {
        boolean estado = true;
        try {
            String sql = "SELECT * FROM Users where usuario = '" + String.valueOf(user) + "'";
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
    public boolean buscarNombreApellido(Object nombre, Object apellido) throws SQLException {
        boolean estado = true;
        try {
            String sql = "SELECT * FROM Personal where apellido = '" + String.valueOf(apellido) + "' and nombre = '" + nombre + "'";
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
