package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDaoImp implements LoginDao {

    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Login objL;

    public LoginDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objL = (Login) object;
        try {
            String sql = "insert into Users (usuario, password, estado, idPersonal) values (?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objL.getUsuario());
            pst.setString(2, objL.getPassword());
            pst.setInt(3, 1);
            pst.setInt(4, objL.getIdPersonal());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        objL = (Login) object;
        try {
            String sql = "UPDATE Users SET estado=? where idPersonal = " + objL.getIdPersonal();
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
        objL = (Login) object;
        try {
            String sql = "UPDATE Users SET usuario=?, password=?, estado=? where idPersonal = " + objL.getIdPersonal();
            pst = con.prepareStatement(sql);
            pst.setString(1, objL.getUsuario());
            pst.setString(2, objL.getPassword());
            pst.setInt(3, objL.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Login buscarIdLogin(Object id) throws SQLException {
        try {
            String sql = "SELECT * FROM Users where id = " + (Integer) id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objL = new Login();
                objL.setId(rs.getInt(1));
                objL.setUsuario(rs.getString(2));
                objL.setPassword(rs.getString(3));
                objL.setEstado(rs.getInt(4));
                objL.setIdPersonal(rs.getInt(5));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objL;
    }

    @Override
    public int Logeo(Object user, Object password) throws SQLException {
        int idP = 0;
        try {
            String sql = "SELECT idPersonal FROM Users "
                    + "where usuario = '" + (String) user + "' and password = '" + (String) password + "' and estado = 1";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                idP = rs.getInt(1);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return idP;
    }
    
    @Override
    public Login buscarPersonal(Object id) throws SQLException {
        try {
            String sql = "SELECT usuario, password FROM Users where idPersonal = " + (Integer) id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objL = new Login();
                objL.setUsuario(rs.getString(1));
                objL.setPassword(rs.getString(2));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objL;
    }
}
