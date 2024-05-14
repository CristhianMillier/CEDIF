package Negocio;

import Datos.Compra;
import Datos.CompraDao;
import Datos.CompraDaoImp;
import Datos.ConexionDaoImp;
import java.sql.Connection;
import java.util.ArrayList;

public class CompraBo {

    public static boolean grabarCompra(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CompraDao obj = new CompraDaoImp(con);
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

    public static boolean modificarCompra(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CompraDao obj = new CompraDaoImp(con);
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

    public static boolean eliminarCompra(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CompraDao obj = new CompraDaoImp(con);
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
    
    public static boolean grabarDocumento(byte[] pdf, Object idCompra) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CompraDao obj = new CompraDaoImp(con);
            obj.grabarDocumento(pdf, idCompra);
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
    
    public static boolean modificarDocumento(byte[] pdf, Object idCompra) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CompraDao obj = new CompraDaoImp(con);
            obj.modificarDocumento(pdf, idCompra);
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
    
    public static int ultimoIdCompra() throws Exception{
        Connection con = null;
        int id = 0;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CompraDao obj = new CompraDaoImp(con);
            id = obj.ultimoIdCompra();
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
        return id;
    }
    
    public static ArrayList obtenerListaCompra() throws Exception{
        Connection con = null;
        ArrayList<Compra> ltsCompra = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CompraDao obj = new CompraDaoImp(con);
            ltsCompra = obj.obtenerListaCompra();
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
        return ltsCompra;
    }
    
    public static ArrayList obtenerLista() throws Exception{
        Connection con = null;
        ArrayList<Compra> ltsCompra = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CompraDao obj = new CompraDaoImp(con);
            ltsCompra = obj.obtenerLista();
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
        return ltsCompra;
    }
    
    public static Compra buscarCrompra(Object object) throws Exception{
        Connection con = null;
        Compra objC = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CompraDao obj = new CompraDaoImp(con);
            objC = obj.buscarCrompra(object);
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
    
    public static ArrayList buscarCompra(int idComprobante, String nrmComp) throws Exception{
        Connection con = null;
        ArrayList<Compra> ltsCompra = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CompraDao obj = new CompraDaoImp(con);
            ltsCompra = obj.buscarCompra(idComprobante, nrmComp);
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
        return ltsCompra;
    }
}
