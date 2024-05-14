package Negocio;

import Datos.ConexionDaoImp;
import Datos.Marca;
import Datos.MarcaDao;
import Datos.MarcaDaoImp;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class MarcaBo {

    public static boolean grabarMarca(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MarcaDao obj = new MarcaDaoImp(con);
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

    public static boolean modificarMarca(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MarcaDao obj = new MarcaDaoImp(con);
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

    public static boolean eliminarMarca(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MarcaDao obj = new MarcaDaoImp(con);
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

    public static void obtenerListaComboMarca(JComboBox<Marca> jComboBox) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MarcaDao obj = new MarcaDaoImp(con);
            obj.obtenerListaComboMarca(jComboBox);
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

    public static Marca buscarIdMarca(Object id) throws Exception {
        Connection con = null;
        Marca objM = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MarcaDao obj = new MarcaDaoImp(con);
            objM = obj.buscarIdMarca(id);
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
        return objM;
    }

    public static ArrayList obtenerListaMarca() throws Exception {
        Connection con = null;
        ArrayList<Marca> ltsMarca = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MarcaDao obj = new MarcaDaoImp(con);
            ltsMarca = obj.obtenerListaMarca();
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
        return ltsMarca;

    }

    public static ArrayList buscarNombreMarca(Object nombre) throws Exception {
        Connection con = null;
        ArrayList<Marca> ltsMarca = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MarcaDao obj = new MarcaDaoImp(con);
            ltsMarca = obj.buscarNombreMarca(nombre);
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
        return ltsMarca;
    }

    public static boolean existeMarca(Object nombre) throws Exception {
        Connection con = null;
        boolean estado = true;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            MarcaDao obj = new MarcaDaoImp(con);
            estado = obj.existeMarca(nombre);
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
