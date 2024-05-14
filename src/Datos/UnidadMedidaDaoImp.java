package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class UnidadMedidaDaoImp implements UnidadMedidaDao{
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private UnidadMedida objU;

    public UnidadMedidaDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        objU = (UnidadMedida) object;
        try {
            String sql = "insert into Unidades_Medidas (nombre, abreviacion, estado) values (?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, objU.getNombre());
            pst.setString(2, objU.getAbreviacion());
            pst.setInt(3, 1);
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
       objU = (UnidadMedida) object;
        try {
            String sql = "UPDATE Unidades_Medidas SET estado=? where id = " + objU.getId();
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
        objU = (UnidadMedida) object;
        try {
            String sql = "UPDATE Unidades_Medidas SET nombre=?, abreviacion=?, estado=? "
                    + "where id = " + objU.getId();
            pst = con.prepareStatement(sql);
            pst.setString(1, objU.getNombre());
            pst.setString(2, objU.getAbreviacion());
            pst.setInt(3, objU.getEstado());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void obtenerListaComboUnidadMedida(JComboBox<UnidadMedida> jComboBox) throws SQLException {
        try {
            String sql = "select * FROM Unidades_Medidas where estado = 1 order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objU = new UnidadMedida();
                objU.setId(rs.getInt(1));
                objU.setNombre(rs.getString(2));
                objU.setAbreviacion(rs.getString(3));
                jComboBox.addItem(objU);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public UnidadMedida buscarIdUnidadMedida(Object id) throws SQLException {
        try {
            String sql = "SELECT * FROM Unidades_Medidas where id = " + (Integer)id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objU = new UnidadMedida();
                objU.setId(rs.getInt(1));
                objU.setNombre(rs.getString(2));
                objU.setAbreviacion(rs.getString(3));
                objU.setEstado(rs.getInt(4));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objU;
    }

    @Override
    public ArrayList obtenerListaUnidadMedida() throws SQLException {
        ArrayList<UnidadMedida> ltsUnidadMedida = new ArrayList();
        try {
            String sql = "SELECT * FROM Unidades_Medidas order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objU = new UnidadMedida();
                objU.setId(rs.getInt(1));
                objU.setNombre(rs.getString(2));
                objU.setAbreviacion(rs.getString(3));
                objU.setEstado(rs.getInt(4));
                ltsUnidadMedida.add(objU);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsUnidadMedida;
    }

    @Override
    public ArrayList buscarNombreUnidadMedida(Object nombre) throws SQLException {
        ArrayList<UnidadMedida> ltsUnidadMedida = new ArrayList();
        try {
            String sql = "SELECT * FROM Unidades_Medidas where nombre LIKE '" + (String) nombre + "%' order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objU = new UnidadMedida();
                objU.setId(rs.getInt(1));
                objU.setNombre(rs.getString(2));
                objU.setAbreviacion(rs.getString(3));
                objU.setEstado(rs.getInt(4));
                ltsUnidadMedida.add(objU);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsUnidadMedida;
    }

    @Override
    public ArrayList buscarNombreUnidadMedidaCorto(Object abreviacion) throws SQLException {
        ArrayList<UnidadMedida> ltsUnidadMedida = new ArrayList();
        try {
            String sql = "SELECT * FROM Unidades_Medidas where abreviacion LIKE '" + (String) abreviacion + "%' order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objU = new UnidadMedida();
                objU.setId(rs.getInt(1));
                objU.setNombre(rs.getString(2));
                objU.setAbreviacion(rs.getString(3));
                objU.setEstado(rs.getInt(4));
                ltsUnidadMedida.add(objU);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsUnidadMedida;
    }

    @Override
    public boolean existeUnidadMedida(Object nombre) throws SQLException {
        boolean estado = true;
        try {
            String sql = "SELECT * FROM Unidades_Medidas where nombre = '" + String.valueOf(nombre) + "'";
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
