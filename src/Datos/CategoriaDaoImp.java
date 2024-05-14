package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class CategoriaDaoImp implements CategoriaDao{
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Categoria objC;

    public CategoriaDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objC = (Categoria) object;
        try {
            String sql = "insert into Categoria (nombre, estado) values (?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objC.getNombre());
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
        objC = (Categoria) object;
        try {
            String sql = "UPDATE Categoria SET estado=? where id = " + objC.getId();
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
        objC = (Categoria) object;
        try {
            String sql = "UPDATE Categoria SET nombre=?, estado=? "
                    + "where id = " + objC.getId();
            pst = con.prepareStatement(sql);
            pst.setString(1, objC.getNombre());
            pst.setInt(2, objC.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    @Override
    public void obtenerListaComboCategoria(JComboBox<Categoria> jComboBox) throws SQLException {
        try {
            String sql = "select * FROM Categoria where estado = 1 order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Categoria();
                objC.setId(rs.getInt(1));
                objC.setNombre(rs.getString(2));
                jComboBox.addItem(objC);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Categoria buscarIdCategoria(Object id) throws SQLException {
        try {
            String sql = "SELECT * FROM Categoria where id = " + (Integer)id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Categoria();
                objC.setId(rs.getInt(1));
                objC.setNombre(rs.getString(2));
                objC.setEstado(rs.getInt(3));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objC;
    }

    @Override
    public ArrayList obtenerListaCategoria() throws SQLException {
        ArrayList<Categoria> ltsCategoria = new ArrayList();
        try {
            String sql = "SELECT * FROM Categoria order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Categoria();
                objC.setId(rs.getInt(1));
                objC.setNombre(rs.getString(2));
                objC.setEstado(rs.getInt(3));
                ltsCategoria.add(objC);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsCategoria;
    }

    @Override
    public ArrayList buscarNombreCategoria(Object nombre) throws SQLException {
        ArrayList<Categoria> ltsCategoria = new ArrayList();
        try {
            String sql = "SELECT * FROM Categoria where nombre LIKE '" + (String) nombre + "%' order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Categoria();
                objC.setId(rs.getInt(1));
                objC.setNombre(rs.getString(2));
                objC.setEstado(rs.getInt(3));
                ltsCategoria.add(objC);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsCategoria;
    }

    @Override
    public boolean existeCategoria(Object nombre) throws SQLException {
        boolean estado = true;
        try {
            String sql = "SELECT * FROM Categoria where nombre = '" + String.valueOf(nombre) + "'";
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
