package Negocio;

import Datos.ConexionDaoImp;
import Datos.Producto;
import Datos.ProductoDao;
import Datos.ProductoDaoImp;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class ProductoBo {

    public static boolean grabarProducto(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProductoDao obj = new ProductoDaoImp(con);
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

    public static boolean modificarProducto(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProductoDao obj = new ProductoDaoImp(con);
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

    public static boolean eliminarProducto(Object object) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProductoDao obj = new ProductoDaoImp(con);
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

    public static boolean actualizarCaducidad(Object caducidad, Object id) throws Exception {
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProductoDao obj = new ProductoDaoImp(con);
            obj.actualizarCaducidad(caducidad, id);
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

    public static Producto buscarProductoId(Object id) throws Exception {
        Connection con = null;
        Producto objP = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProductoDao obj = new ProductoDaoImp(con);
            objP = obj.buscarProductoId(id);
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

    public static ArrayList obtenerListaProducto() throws Exception{
        Connection con = null;
        ArrayList<Producto> ltsProducto = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProductoDao obj = new ProductoDaoImp(con);
            ltsProducto = obj.obtenerListaProducto();
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
        return ltsProducto;
    }

    public static ArrayList obtenerListaProductoDescripcion(Object descripcion) throws Exception{
        Connection con = null;
        ArrayList<Producto> ltsProducto = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProductoDao obj = new ProductoDaoImp(con);
            ltsProducto = obj.obtenerListaProductoDescripcion(descripcion);
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
        return ltsProducto;
    }

    public static ArrayList obtenerListaAlerta() throws Exception{
        Connection con = null;
        ArrayList<Producto> ltsProducto = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProductoDao obj = new ProductoDaoImp(con);
            ltsProducto = obj.obtenerListaAlerta();
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
        return ltsProducto;
    }

    public static void llenarComboProducto(JComboBox<Producto> jComboBox) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProductoDao obj = new ProductoDaoImp(con);
            obj.llenarComboProducto(jComboBox);
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

    public static boolean actualizarProductoVenta(Producto objP, int cantidad) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProductoDao obj = new ProductoDaoImp(con);
            obj.actualizarProductoVenta(objP, cantidad);
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
    
    public static boolean actualizarProductoCompra(Producto objP, int cantidad, double precio) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProductoDao obj = new ProductoDaoImp(con);
            obj.actualizarProductoCompra(objP, cantidad, precio);
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
    
    public static boolean existeProducto(Object objP) throws Exception{
        Connection con = null;
        boolean estado = true;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            ProductoDao obj = new ProductoDaoImp(con);
            estado = obj.existeProducto(objP);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return estado;
    }
}
