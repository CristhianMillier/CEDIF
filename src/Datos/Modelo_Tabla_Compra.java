package Datos;

import java.awt.Image;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

public class Modelo_Tabla_Compra extends AbstractTableModel {

    private List<Compra> listado_Compra;

    public void setListado_Compra(List<Compra> listado_Compra) {
        this.listado_Compra = listado_Compra;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantFilas = 0;
        if (this.listado_Compra != null) {
            cantFilas = this.listado_Compra.size();
        }
        return cantFilas;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Compra objDC;
        Object celda = "";
        if (this.listado_Compra != null) {
            objDC = this.listado_Compra.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    celda = objDC.getObjComp().getNombre();
                    break;
                case 1:
                    celda = objDC.getNroComprobante();
                    break;
                case 2:
                    celda = this.convertDate(objDC.getFecha());
                    break;
                case 3:
                    celda = objDC.getPago();
                    break;
                case 4:
                    celda = objDC.getObjProvee().getRazonSocial();
                    break;
                case 5:
                    if (objDC.getDocumentoPDF()!= null) {
                        celda = agregarBoton(1);
                    } else {
                        celda = agregarBoton(2);
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
                nombreolumn = "COMP.";
                break;
            case 1:
                nombreolumn = "NUM.";
                break;
            case 2:
                nombreolumn = "FECHA";
                break;
            case 3:
                nombreolumn = "IMPORTE";
                break;
            case 4:
                nombreolumn = "PROVEEDOR";
                break;
            case 5:
                nombreolumn = "PDF";
                break;
        }
        return nombreolumn;
    }

    public Compra getCompra(int fila) {
        Compra objC = null;
        if (this.listado_Compra != null) {
            objC = this.listado_Compra.get(fila);
        }
        return objC;
    }

    private Image get_Image(String ruta) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(ruta));
            Image mainIcon = imageIcon.getImage();
            return mainIcon;
        } catch (Exception e) {
        }
        return null;
    }

    private JButton agregarBoton(int valor) {
        JButton boton;
        ImageIcon icono = null;
        if (get_Image("/Imagenes/expediente.png") != null) {
            icono = new ImageIcon(get_Image("/Imagenes/expediente.png"));
        }

        if (valor == 1) {
            boton = new JButton(icono);
        } else {
            boton = new JButton("VACÍO");
        }

        return boton;
    }

    private String convertDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
