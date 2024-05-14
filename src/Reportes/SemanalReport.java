package Reportes;

import Datos.ConexionDaoImp;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class SemanalReport {
   
    public void verReporte(int mes, int anio, int semana) throws Exception {
        JasperReport repor;
        JasperPrint re;
        JasperViewer view;
        
        String[] months = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
            "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"};
        
        String[] semanas = new String[]{"primera semana", "segunda semana", "tercera semana" , "segunda semana"};
        
        try {
            String path = "src\\Reportes\\ReportSemanal.jasper";
            repor = (JasperReport) JRLoader.loadObjectFromFile(path);

            Map parametros = new HashMap();
            parametros.clear();
            parametros.put("mes", mes);
            parametros.put("anio", anio);
            parametros.put("semana", semana);
            
            re = JasperFillManager.fillReport(repor, parametros, ConexionDaoImp.getConexion());
            view = new JasperViewer(re, false);
            view.setTitle("Reporte Semanal de Alimentos de la " + semanas[semana - 1] + " del año " + anio + " del mes " + months[mes - 1]);
            view.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/logo.png")));
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException  e) {
            System.out.println(e.getMessage());
        }
    }

}
