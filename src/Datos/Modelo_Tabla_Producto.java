package Datos;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Modelo_Tabla_Producto extends AbstractTableModel {

    private List<Producto> listado_Producto;

    public void setListado_Producto(List<Producto> listado_Producto) {
        this.listado_Producto = listado_Producto;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantFilas = 0;
        if (this.listado_Producto != null) {
            cantFilas = this.listado_Producto.size();
        }
        return cantFilas;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto objP;
        Object celda = "";
        if (this.listado_Producto != null) {
            objP = this.listado_Producto.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    celda = objP.getDescripcion();
                    break;
                case 1:
                    celda = objP.getObjUM().getAbreviacion();
                    break;
                case 2:
                    celda = objP.getCantidad();
                    break;
                case 3:
                    celda = objP.getObjC().getNombre();
                    break;
                case 4:
                    celda = objP.getObjM().getNombre();
                    break;
                case 5:
                    if (objP.getEstado() == 1) {
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
                nombreolumn = "DESCRIPCIÓN";
                break;
            case 1:
                nombreolumn = "UNIDAD";
                break;
            case 2:
                nombreolumn = "STOCK";
                break;
            case 3:
                nombreolumn = "CATEGORÍA";
                break;
            case 4:
                nombreolumn = "MARCA";
                break;
            case 5:
                nombreolumn = "ESTADO";
                break;
        }
        return nombreolumn;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Producto getProducto(int fila) {
        Producto objP = null;
        if (this.listado_Producto != null) {
            objP = this.listado_Producto.get(fila);
        }
        return objP;
    }
}
