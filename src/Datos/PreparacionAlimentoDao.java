package Datos;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PreparacionAlimentoDao extends General{
    public int ultimoIdPreparacion() throws SQLException;
    public ArrayList obtenerListaPreparacion() throws SQLException;
    public ArrayList obtenerLista() throws SQLException;
    public ArrayList buscarPreparacion(String fecha, String tipoAlimento) throws SQLException;
}
