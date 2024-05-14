package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

public class DocumentoDaoImp implements DocumentoDao{
    
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Documento objT;

    public DocumentoDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void obtenerListaComboTipDoc(JComboBox<Documento> jComboBox) throws SQLException {
        try {
            String sql = "select * FROM Tipo_Documento where estado = 1 order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objT = new Documento();
                objT.setId(rs.getInt(1));
                objT.setNombre(rs.getString(2));
                jComboBox.addItem(objT);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Documento buscarId(Object id) throws SQLException {
        try {
            String sql = "SELECT * FROM Tipo_Documento where id = " + (Integer)id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objT = new Documento();
                objT.setId(rs.getInt(1));
                objT.setNombre(rs.getString(2));
                objT.setEstado(rs.getInt(3));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return objT;
    }
}
