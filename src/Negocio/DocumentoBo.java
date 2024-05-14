package Negocio;

import Datos.ConexionDaoImp;
import Datos.Documento;
import Datos.DocumentoDao;
import Datos.DocumentoDaoImp;
import java.sql.Connection;
import javax.swing.JComboBox;

public class DocumentoBo {
    public static void obtenerListaComboTipDoc(JComboBox<Documento> jComboBox) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            DocumentoDao obj = new DocumentoDaoImp(con);
            obj.obtenerListaComboTipDoc(jComboBox);
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
    
    public static Documento buscarId(Object id) throws Exception{
        Connection con = null;
        Documento objD = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            DocumentoDao obj = new DocumentoDaoImp(con);
            objD = obj.buscarId(id);
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
        return objD;
    }
}
