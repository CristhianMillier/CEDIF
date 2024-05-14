package Negocio;

import Datos.Comprobante;
import Datos.ComprobanteDao;
import Datos.ComprobanteDaoImp;
import Datos.ConexionDaoImp;
import java.sql.Connection;
import javax.swing.JComboBox;

public class ComprobanteBo {
    public static void obtenerListaComboTipComp(JComboBox<Comprobante> jComboBox) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ComprobanteDao obj = new ComprobanteDaoImp(con);
            obj.obtenerListaComboTipComp(jComboBox);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    
    public static Comprobante buscarId(Object id) throws Exception{
        Connection con = null;
        Comprobante objC = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ComprobanteDao obj = new ComprobanteDaoImp(con);
            objC = obj.buscarId(id);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return objC;
    }
}
