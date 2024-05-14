package Datos;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Modelo_Tabla_Proveedor extends AbstractTableModel {

    private List<Proveedor> listado_Proveedor;

    public void setListado_Proveedor(List<Proveedor> listado_Proveedor) {
        this.listado_Proveedor = listado_Proveedor;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantFilas = 0;
        if (this.listado_Proveedor != null) {
            cantFilas = this.listado_Proveedor.size();
        }
        return cantFilas;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Proveedor objP;
        Object celda = "";
        if (this.listado_Proveedor != null) {
            objP = this.listado_Proveedor.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    celda = objP.getRazonSocial();
                    break;
                case 1:
                    celda = objP.getNrodocumento();
                    break;
                case 2:
                    celda = objP.getObjD().getNombre();
                    break;
                case 3:
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
                nombreolumn = "RAZON SOCIAL";
                break;
            case 1:
                nombreolumn = "NRO. DOCUMENTO";
                break;
            case 2:
                nombreolumn = "TIP. DOCUMENTO";
                break;
            case 3:
                nombreolumn = "ESTADO";
                break;
        }
        return nombreolumn;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Proveedor getProveedor(int fila) {
        Proveedor objP = null;
        if (this.listado_Proveedor != null) {
            objP = this.listado_Proveedor.get(fila);
        }
        return objP;
    }
}
