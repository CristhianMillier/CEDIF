package Datos;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Modelo_Tabla_UnidadMedida extends AbstractTableModel {

    private List<UnidadMedida> listado_UnidadMedida;

    public void setListado_UnidadMedida(List<UnidadMedida> listado_UnidadMedida) {
        this.listado_UnidadMedida = listado_UnidadMedida;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantFilas = 0;
        if (this.listado_UnidadMedida != null) {
            cantFilas = this.listado_UnidadMedida.size();
        }
        return cantFilas;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        UnidadMedida objU;
        Object celda = "";
        if (this.listado_UnidadMedida != null) {
            objU = this.listado_UnidadMedida.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    celda = objU.getNombre();
                    break;
                case 1:
                    celda = objU.getAbreviacion();
                    break;
                case 2:
                    if (objU.getEstado() == 1) {
                        celda = "ACTIVO";
                    } else {
                        celda = "INACTIVO";
                    }
                    break;
            }
        }
        return celda;
    }

    @Override
    public String getColumnName(int column) {
        String nombreolumn = "";
        switch (column) {
            case 0:
                nombreolumn = "NOMBRE";
                break;
            case 1:
                nombreolumn = "ABREVIATURA";
                break;
            case 2:
                nombreolumn = "ESTADO";
                break;
        }
        return nombreolumn;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public UnidadMedida getUnidadMedida(int fila) {
        UnidadMedida objU = null;
        if (this.listado_UnidadMedida != null) {
            objU = this.listado_UnidadMedida.get(fila);
        }
        return objU;
    }
}
