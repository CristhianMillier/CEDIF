package Negocio;

import Datos.ConexionDaoImp;
import Datos.Detalle_Preparacion;
import Datos.Detalle_PreparacionDao;
import Datos.Detalle_PreparacionDaoImp;
import java.sql.Connection;
import java.util.ArrayList;

public class Detalle_PreparacionBo {

    public static boolean grabarDetPreparacionAlim(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            Detalle_PreparacionDao obj = new Detalle_PreparacionDaoImp(con);
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

    public static boolean modificarDetPreparacionAlim(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            Detalle_PreparacionDao obj = new Detalle_PreparacionDaoImp(con);
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

    public static boolean eliminarDetPreparacionAlim(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            Detalle_PreparacionDao obj = new Detalle_PreparacionDaoImp(con);
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

    public static ArrayList obtenerListaDetPreparacion(int IdPreparacion) throws Exception{
        Connection con = null;
        ArrayList<Detalle_Preparacion> ltsDetalle_Preparacion = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            Detalle_PreparacionDao obj = new Detalle_PreparacionDaoImp(con);
            ltsDetalle_Preparacion = obj.obtenerListaDetPreparacion(IdPreparacion);
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
        return ltsDetalle_Preparacion;
    }

    public static ArrayList obtenerLista() throws Exception{
        Connection con = null;
        ArrayList<Detalle_Preparacion> ltsDetalle_Preparacion = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            Detalle_PreparacionDao obj = new Detalle_PreparacionDaoImp(con);
            ltsDetalle_Preparacion = obj.obtenerLista();
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
        return ltsDetalle_Preparacion;
    }

    public static Detalle_Preparacion buscarDetPreparacion(Detalle_Preparacion onjDet) throws Exception{
        Connection con = null;
        Detalle_Preparacion objPA = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            Detalle_PreparacionDao obj = new Detalle_PreparacionDaoImp(con);
            objPA = obj.buscarDetPreparacion(onjDet);
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
        return objPA;
    }
}
