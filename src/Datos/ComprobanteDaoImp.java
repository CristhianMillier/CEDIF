package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

public class ComprobanteDaoImp implements ComprobanteDao{

    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private Comprobante objC;

    public ComprobanteDaoImp(Connection con) {
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
    public void obtenerListaComboTipComp(JComboBox<Comprobante> jComboBox) throws SQLException {
        try {
            String sql = "select * FROM Tipo_Comprobante where estado = 1 order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Comprobante();
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
    public Comprobante buscarId(Object id) throws SQLException {
        try {
            String sql = "SELECT * FROM Tipo_Comprobante where id = " + (Integer)id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objC = new Comprobante();
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
}
