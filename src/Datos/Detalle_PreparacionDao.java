package Datos;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Detalle_PreparacionDao extends General{
    public ArrayList obtenerListaDetPreparacion(int IdPreparacion) throws SQLException;
    public ArrayList obtenerLista() throws SQLException;
    public Detalle_Preparacion buscarDetPreparacion(Detalle_Preparacion onjDet) throws SQLException;
}
