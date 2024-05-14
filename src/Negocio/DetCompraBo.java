package Negocio;

import Datos.ConexionDaoImp;
import Datos.DetCompra;
import Datos.DetCompraDao;
import Datos.DetCompraDaoImp;
import java.sql.Connection;
import java.util.ArrayList;

public class DetCompraBo {

    public static boolean grabarDetCompraBo(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            DetCompraDao obj = new DetCompraDaoImp(con);
            obj.grabar(object);
            con.commit();
            return true;
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

    public static boolean modificarDetCompraBo(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            DetCompraDao obj = new DetCompraDaoImp(con);
            obj.modificar(object);
            con.commit();
            return true;
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

    public static boolean eliminarDetCompraBo(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            DetCompraDao obj = new DetCompraDaoImp(con);
            obj.eliminar(object);
            con.commit();
            return true;
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
    
    public static ArrayList obtenerListaDetCompra(int IdCompra) throws Exception{
        Connection con = null;
        ArrayList<DetCompra> ltsDetCompra = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            DetCompraDao obj = new DetCompraDaoImp(con);
            ltsDetCompra = obj.obtenerListaDetCompra(IdCompra);
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
        return ltsDetCompra;
    }
    
    public static ArrayList obtenerLista() throws Exception{
        Connection con = null;
        ArrayList<DetCompra> ltsDetCompra = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            DetCompraDao obj = new DetCompraDaoImp(con);
            ltsDetCompra = obj.obtenerLista();
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
        return ltsDetCompra;        
    }
    
    public static DetCompra buscarDetCompra(DetCompra onjDet) throws Exception{
        Connection con = null;
        DetCompra objDetCom = new DetCompra();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            DetCompraDao obj = new DetCompraDaoImp(con);
            objDetCom = obj.buscarDetCompra(onjDet);
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
        return objDetCom; 
    }
    
}
