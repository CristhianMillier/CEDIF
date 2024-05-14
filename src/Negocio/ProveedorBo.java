package Negocio;

import Datos.ConexionDaoImp;
import Datos.Proveedor;
import Datos.ProveedorDao;
import Datos.ProveedorDaoImp;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class ProveedorBo {

    public static boolean grabarProveedor(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProveedorDao obj = new ProveedorDaoImp(con);
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

    public static boolean modificarProveedor(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProveedorDao obj = new ProveedorDaoImp(con);
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

    public static boolean eliminarProveedor(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProveedorDao obj = new ProveedorDaoImp(con);
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

    public static ArrayList obtenerListaProveedor() throws Exception {
        Connection con = null;
        ArrayList<Proveedor> ltsProveedor = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProveedorDao obj = new ProveedorDaoImp(con);
            ltsProveedor = obj.obtenerListaProveedor();
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
        return ltsProveedor;
    }

    public static void obtenerListaCombProveedor(JComboBox<Proveedor> jComboBox) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProveedorDao obj = new ProveedorDaoImp(con);
            obj.obtenerListaCombProveedor(jComboBox);
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

    public static Proveedor buscarIdProveedor(Object id) throws Exception {
        Connection con = null;
        Proveedor objP = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProveedorDao obj = new ProveedorDaoImp(con);
            objP = obj.buscarIdProveedor(id);
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
        return objP;
    }

    public static ArrayList buscarDNIProveedor(Object dni) throws Exception {
        Connection con = null;
        ArrayList<Proveedor> ltsProveedor = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProveedorDao obj = new ProveedorDaoImp(con);
            ltsProveedor = obj.buscarDNIProveedor(dni);
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
        return ltsProveedor;
    }

    public static ArrayList buscarRazonSocialProveedor(Object razonSocial) throws Exception {
        Connection con = null;
        ArrayList<Proveedor> ltsProveedor = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProveedorDao obj = new ProveedorDaoImp(con);
            ltsProveedor = obj.buscarRazonSocialProveedor(razonSocial);
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
        return ltsProveedor;
    }

    public static boolean buscarDNI(Object DNI) throws Exception {
        Connection con = null;
        boolean estado = true;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProveedorDao obj = new ProveedorDaoImp(con);
            estado = obj.buscarDNI(DNI);
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

    public static boolean buscarRazonSocial(Object razonSocial) throws Exception {
        Connection con = null;
        boolean estado = true;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProveedorDao obj = new ProveedorDaoImp(con);
            estado = obj.buscarRazonSocial(razonSocial);
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
