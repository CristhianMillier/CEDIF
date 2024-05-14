package Negocio;

import Datos.ConexionDaoImp;
import Datos.UnidadMedida;
import Datos.UnidadMedidaDao;
import Datos.UnidadMedidaDaoImp;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class UnidadMedidaBo {

    public static boolean grabarUnidadMedida(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            UnidadMedidaDao obj = new UnidadMedidaDaoImp(con);
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

    public static boolean modificarUnidadMedida(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            UnidadMedidaDao obj = new UnidadMedidaDaoImp(con);
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

    public static boolean eliminarUnidadMedida(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            UnidadMedidaDao obj = new UnidadMedidaDaoImp(con);
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

    public static void obtenerListaComboUnidadMedida(JComboBox<UnidadMedida> jComboBox) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            UnidadMedidaDao obj = new UnidadMedidaDaoImp(con);
            obj.obtenerListaComboUnidadMedida(jComboBox);
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

    public static UnidadMedida buscarIdUnidadMedida(Object id) throws Exception{
        Connection con = null;
        UnidadMedida objU = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            UnidadMedidaDao obj = new UnidadMedidaDaoImp(con);
            objU = obj.buscarIdUnidadMedida(id);
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
        return objU;
    }

    public static ArrayList obtenerListaUnidadMedida() throws Exception{
        Connection con = null;
        ArrayList<UnidadMedida> ltsUnidadMedida = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            UnidadMedidaDao obj = new UnidadMedidaDaoImp(con);
            ltsUnidadMedida = obj.obtenerListaUnidadMedida();
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
        return ltsUnidadMedida;
    }

    public static ArrayList buscarNombreUnidadMedida(Object nombre) throws Exception{
        Connection con = null;
        ArrayList<UnidadMedida> ltsUnidadMedida = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            UnidadMedidaDao obj = new UnidadMedidaDaoImp(con);
            ltsUnidadMedida = obj.buscarNombreUnidadMedida(nombre);
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
        return ltsUnidadMedida;
    }

    public static ArrayList buscarNombreUnidadMedidaCorto(Object abreviacion) throws Exception{
        Connection con = null;
        ArrayList<UnidadMedida> ltsUnidadMedida = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            UnidadMedidaDao obj = new UnidadMedidaDaoImp(con);
            ltsUnidadMedida = obj.buscarNombreUnidadMedidaCorto(abreviacion);
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
        return ltsUnidadMedida;
    }

    public static boolean existeUnidadMedida(Object nombre) throws Exception{
        Connection con = null;
        boolean estado = true;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            UnidadMedidaDao obj = new UnidadMedidaDaoImp(con);
            estado = obj.existeUnidadMedida(nombre);
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
        return estado;
    }

}
