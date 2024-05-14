package Negocio;

import Datos.ConexionDaoImp;
import Datos.PreparacionAlimento;
import Datos.PreparacionAlimentoDao;
import Datos.PreparacionAlimentoDaoImp;
import java.sql.Connection;
import java.util.ArrayList;

public class PreparacionAlimentoBo {

    public static boolean grabarPreparacionAlimento(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            PreparacionAlimentoDao obj = new PreparacionAlimentoDaoImp(con);
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

    public static boolean modificarPreparacionAlimento(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            PreparacionAlimentoDao obj = new PreparacionAlimentoDaoImp(con);
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

    public static boolean eliminarPreparacionAlimento(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            PreparacionAlimentoDao obj = new PreparacionAlimentoDaoImp(con);
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

    public static int ultimoIdPreparacion() throws Exception{
        Connection con = null;
        int id = 0;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            PreparacionAlimentoDao obj = new PreparacionAlimentoDaoImp(con);
            id = obj.ultimoIdPreparacion();
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

    public static ArrayList obtenerListaPreparacion() throws Exception{
        Connection con = null;
        ArrayList<PreparacionAlimento> ltsPreparacionAlimento = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            PreparacionAlimentoDao obj = new PreparacionAlimentoDaoImp(con);
            ltsPreparacionAlimento = obj.obtenerListaPreparacion();
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
        return ltsPreparacionAlimento;
    }

    public static ArrayList obtenerLista() throws Exception{
        Connection con = null;
        ArrayList<PreparacionAlimento> ltsPreparacionAlimento = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            PreparacionAlimentoDao obj = new PreparacionAlimentoDaoImp(con);
            ltsPreparacionAlimento = obj.obtenerLista();
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
        return ltsPreparacionAlimento;
    }

    public static ArrayList buscarPreparacion(String fecha, String tipoAlimento) throws Exception{
        Connection con = null;
        ArrayList<PreparacionAlimento> ltsPreparacionAlimento = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            PreparacionAlimentoDao obj = new PreparacionAlimentoDaoImp(con);
            ltsPreparacionAlimento = obj.buscarPreparacion(fecha, tipoAlimento);
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
        return ltsPreparacionAlimento;
    }
}
