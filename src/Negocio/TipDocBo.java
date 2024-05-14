package Negocio;

import Datos.Documento;
import Datos.DocumentoDao;
import Datos.DocumentoDaoImp;
import Datos.ConexionDaoImp;
import javax.swing.JComboBox;
import java.sql.Connection;

public class TipDocBo {
    public static void obtenerListaComboTipDoc(JComboBox<Documento> jComboBox)throws Exception{
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
        }finally{
            if(con!=null)
                con.close();
        }
    }
}
