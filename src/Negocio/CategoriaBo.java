package Negocio;

import Datos.ConexionDaoImp;
import Datos.Categoria;
import Datos.CategoriaDao;
import Datos.CategoriaDaoImp;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class CategoriaBo {
    public static boolean grabarCategoria(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CategoriaDao obj = new CategoriaDaoImp(con);
            obj.grabar(object);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
    }
    
    public static boolean modificarCategoria(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CategoriaDao obj = new CategoriaDaoImp(con);
            obj.modificar(object);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
    }
    
    public static boolean eliminarCategoria(Object object)throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CategoriaDao obj = new CategoriaDaoImp(con);
            obj.eliminar(object);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
    }
    
    public static void obtenerListaComboCategoria(JComboBox<Categoria> jComboBox) throws Exception{
        Connection con = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CategoriaDao obj = new CategoriaDaoImp(con);
            obj.obtenerListaComboCategoria(jComboBox);
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
    
    public static Categoria buscarIdCategoria(Object id) throws Exception{
        Connection con = null;
        Categoria objC = null;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CategoriaDao obj = new CategoriaDaoImp(con);
            objC = obj.buscarIdCategoria(id);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return objC;
    }
    
    public static ArrayList obtenerListaCategoria() throws Exception{
        Connection con = null;
        ArrayList<Categoria> ltsCategoria = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CategoriaDao obj = new CategoriaDaoImp(con);
            ltsCategoria = obj.obtenerListaCategoria();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsCategoria;
        
    }
    
    public static ArrayList buscarNombreCategoria(Object nombre) throws Exception{
        Connection con = null;
        ArrayList<Categoria> ltsCategoria = new ArrayList();
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CategoriaDao obj = new CategoriaDaoImp(con);
            ltsCategoria = obj.buscarNombreCategoria(nombre);
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }finally{
            if(con!=null)
                con.close();
        }
        return ltsCategoria;
    }
    
    public static boolean existeCategoria(Object nombre) throws Exception{
        Connection con = null;
        boolean estado = true;
        try {
            con = ConexionDaoImp.getConexion();
            con.setAutoCommit(false);
            CategoriaDao obj = new CategoriaDaoImp(con);
            estado = obj.existeCategoria(nombre);
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
