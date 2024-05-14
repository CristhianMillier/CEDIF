package Datos;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Modelo_Tabla_Categoria extends AbstractTableModel {

    private List<Categoria> listado_Categoria;

    public void setListado_Categoria(List<Categoria> listado_Categoria) {
        this.listado_Categoria = listado_Categoria;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantFilas = 0;
        if (this.listado_Categoria != null) {
            cantFilas = this.listado_Categoria.size();
        }
        return cantFilas;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Categoria objc;
        Object celda = "";
        if (this.listado_Categoria != null) {
            objc = this.listado_Categoria.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    celda = objc.getNombre();
                    break;
                case 1:
                    if (objc.getEstado() == 1) {
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

    public Categoria getCaetegoria (int fila) {
        Categoria objC = null;
        if (this.listado_Categoria != null) {
            objC = this.listado_Categoria.get(fila);
        }
        return objC;
    }
}
