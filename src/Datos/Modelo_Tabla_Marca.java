package Datos;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Modelo_Tabla_Marca extends AbstractTableModel {

    private List<Marca> listado_Marca;

    public void setListado_Marca(List<Marca> listado_Marca) {
        this.listado_Marca = listado_Marca;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantFilas = 0;
        if (this.listado_Marca != null) {
            cantFilas = this.listado_Marca.size();
        }
        return cantFilas;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Marca objM;
        Object celda = "";
        if (this.listado_Marca != null) {
            objM = this.listado_Marca.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    celda = objM.getNombre();
                    break;
                case 1:
                    if (objM.getEstado() == 1) {
                        celda = "ACTIVO";
                    } else{
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
                nombreolumn = "ESTADO";
                break;
        }
        return nombreolumn;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Marca getMarca (int fila) {
        Marca objM = null;
        if (this.listado_Marca != null) {
            objM = this.listado_Marca.get(fila);
        }
        return objM;
    }
}
