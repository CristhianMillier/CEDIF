package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class MarcaDaoImp implements MarcaDao{
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Marca objM;

    public MarcaDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objM = (Marca) object;
        try {
            String sql = "insert into Marca (nombre, estado) values (?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objM.getNombre());
            pst.setInt(2, 1);
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        objM = (Marca) object;
        try {
            String sql = "UPDATE Marca SET estado=? where id = " + objM.getId();
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
        objM = (Marca) object;
        try {
            String sql = "UPDATE Marca SET nombre=?, estado=? "
                    + "where id = " + objM.getId();
            pst = con.prepareStatement(sql);
            pst.setString(1, objM.getNombre());
            pst.setInt(2, objM.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    @Override
    public void obtenerListaComboMarca(JComboBox<Marca> jComboBox) throws SQLException {
        try {
            String sql = "select * FROM Marca where estado = 1 order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objM = new Marca();
                objM.setId(rs.getInt(1));
                objM.setNombre(rs.getString(2));
                jComboBox.addItem(objM);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Marca buscarIdMarca(Object id) throws SQLException {
        try {
            String sql = "SELECT * FROM Marca where id = " + (Integer)id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objM = new Marca();
                objM.setId(rs.getInt(1));
                objM.setNombre(rs.getString(2));
                objM.setEstado(rs.getInt(3));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objM;
    }

    @Override
    public ArrayList obtenerListaMarca() throws SQLException {
        ArrayList<Marca> ltsMarca = new ArrayList();
        try {
            String sql = "SELECT * FROM Marca order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objM = new Marca();
                objM.setId(rs.getInt(1));
                objM.setNombre(rs.getString(2));
                objM.setEstado(rs.getInt(3));
                ltsMarca.add(objM);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMarca;
    }

    @Override
    public ArrayList buscarNombreMarca(Object nombre) throws SQLException {
        ArrayList<Marca> ltsMarca = new ArrayList();
        try {
            String sql = "SELECT * FROM Marca where nombre LIKE '" + (String) nombre + "%' order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objM = new Marca();
                objM.setId(rs.getInt(1));
                objM.setNombre(rs.getString(2));
                objM.setEstado(rs.getInt(3));
                ltsMarca.add(objM);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsMarca;
    }

    @Override
    public boolean existeMarca(Object nombre) throws SQLException {
        boolean estado = true;
        try {
            String sql = "SELECT * FROM Marca where nombre = '" + String.valueOf(nombre) + "'";
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
