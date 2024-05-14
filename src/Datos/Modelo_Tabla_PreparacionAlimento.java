package Datos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Modelo_Tabla_PreparacionAlimento extends AbstractTableModel {

    private List<PreparacionAlimento> listado_PreparacionAlimento;

    public void setListado_PreparacionAlimento(List<PreparacionAlimento> listado_PreparacionAlimento) {
        this.listado_PreparacionAlimento = listado_PreparacionAlimento;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantFilas = 0;
        if (this.listado_PreparacionAlimento != null) {
            cantFilas = this.listado_PreparacionAlimento.size();
        }
        return cantFilas;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PreparacionAlimento objPA;
        Object celda = "";
        if (this.listado_PreparacionAlimento != null) {
            objPA = this.listado_PreparacionAlimento.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    celda = convertDate(objPA.getFecha_hora().substring(0, 10));
                    break;
                case 1:
                    celda = objPA.getTipoAlmuerzo();
                    break;
                case 2:
                    celda = objPA.getDescripcionAlimento();
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
                nombreolumn = "FECHA";
                break;
            case 1:
                nombreolumn = "TIP: COMIDA";
                break;
            case 2:
                nombreolumn = "DESCRIPCIÓN";
                break;
        }
        return nombreolumn;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public PreparacionAlimento getPreparacionAlimento(int fila) {
        PreparacionAlimento objPA = null;
        if (this.listado_PreparacionAlimento != null) {
            objPA = this.listado_PreparacionAlimento.get(fila);
        }
        return objPA;
    }

    private String convertDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
