package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

public class PreparacionAlimentoDaoImp implements PreparacionAlimentoDao{

    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private Connection con;
    private PreparacionAlimento objPA;

    public PreparacionAlimentoDaoImp(Connection con) {
        this.con = con;
    }

    @Override
    public boolean grabar(Object object) throws SQLException {
        Calendar cal = Calendar.getInstance();
        Timestamp fecha_hora = new Timestamp(cal.getTimeInMillis());
        String fechaSistema = String.valueOf(fecha_hora);
        
        objPA = (PreparacionAlimento) object;
        try {
            String sql = "insert into Preparacion_Alimento (fecha, alimento, tipo_comida, estado, idPersonal) "
                    + "values (?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, fechaSistema);
            pst.setString(2, objPA.getDescripcionAlimento());
            pst.setString(3, objPA.getTipoAlmuerzo());
            pst.setInt(4, 1);
            pst.setInt(5, objPA.getObjP().getId());
            pst.execute();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean eliminar(Object object) throws SQLException {
        objPA = (PreparacionAlimento) object;
        try {
            String sql = "UPDATE Preparacion_Alimento SET estado=? WHERE id = " + objPA.getId();
            pst = con.prepareStatement(sql);
            pst.setInt(1, 2);
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean modificar(Object object) throws SQLException {
        objPA = (PreparacionAlimento) object;
        try {
            String sql = "UPDATE Preparacion_Alimento SET alimento=?, tipo_comida=?, estado=?, idPersonal=? "
                    + " WHERE id = " + objPA.getId();
            pst = con.prepareStatement(sql);
            pst.setString(1, objPA.getDescripcionAlimento());
            pst.setString(2, objPA.getTipoAlmuerzo());
            pst.setInt(3, 1);
            pst.setInt(4, objPA.getObjP().getId());
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public int ultimoIdPreparacion() throws SQLException {
        int id = 0;
        try {
            String sql = "select max(id) from Preparacion_Alimento";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt(1);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return id;
    }

    @Override
    public ArrayList obtenerListaPreparacion() throws SQLException {
        ArrayList<PreparacionAlimento> ltsPreparacionAlimento = new ArrayList();
        try {
            String sql = "select * FROM Preparacion_Alimento where estado = 1";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objPA = new PreparacionAlimento();
                objPA.setId(rs.getInt(1));
                objPA.setFecha_hora(rs.getString(2));
                objPA.setDescripcionAlimento(rs.getString(3));
                objPA.setTipoAlmuerzo(rs.getString(4));
                objPA.setEtado(rs.getInt(5));
                
                PersonalDao objP = new PersonalDaoImp(con);
                objPA.setObjP(objP.buscarIdPersonal(rs.getInt(6)));
                ltsPreparacionAlimento.add(objPA);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsPreparacionAlimento;
    }

    @Override
    public ArrayList obtenerLista() throws SQLException {
        ArrayList<PreparacionAlimento> ltsPreparacionAlimento = new ArrayList();
        try {
            String sql = "select * FROM Preparacion_Alimento";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objPA = new PreparacionAlimento();
                objPA.setId(rs.getInt(1));
                objPA.setFecha_hora(rs.getString(2));
                objPA.setDescripcionAlimento(rs.getString(3));
                objPA.setTipoAlmuerzo(rs.getString(4));
                objPA.setEtado(rs.getInt(5));
                
                PersonalDao objP = new PersonalDaoImp(con);
                objPA.setObjP(objP.buscarIdPersonal(rs.getInt(6)));
                ltsPreparacionAlimento.add(objPA);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsPreparacionAlimento;
    }

    @Override
    public ArrayList buscarPreparacion(String fecha, String tipoAlimento) throws SQLException {
        ArrayList<PreparacionAlimento> ltsPreparacionAlimento = new ArrayList();
        try {
            String sql = "select * from Preparacion_Alimento where tipo_comida = '" + tipoAlimento
                    + "' and estado = 1 and CONVERT(date, fecha) = " + fecha;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                objPA = new PreparacionAlimento();
                objPA.setId(rs.getInt(1));
                objPA.setFecha_hora(rs.getString(2));
                objPA.setDescripcionAlimento(rs.getString(3));
                objPA.setTipoAlmuerzo(rs.getString(4));
                objPA.setEtado(rs.getInt(5));
                
                PersonalDao objP = new PersonalDaoImp(con);
                objPA.setObjP(objP.buscarIdPersonal(rs.getInt(6)));
                ltsPreparacionAlimento.add(objPA);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        }
        return ltsPreparacionAlimento;
    }
}
