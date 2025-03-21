package Vista;

import Datos.Categoria;
import Negocio.CategoriaBo;
import Reportes.MensualReport;
import java.time.Year;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class panelReportMensual extends javax.swing.JPanel {

    /**
     * Creates new form panelReportDiario
     */
    private Categoria objC = null;

    public panelReportMensual() {
        initComponents();
        this.cargarMes();
        this.cargarCombo();
        this.comboMes.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnGenerar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        comboMes = new javax.swing.JComboBox<>();
        comboCategoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("REPROTE MENSUAL");

        btnGenerar.setBackground(new java.awt.Color(255, 102, 102));
        btnGenerar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnReporte.png"))); // NOI18N
        btnGenerar.setText("GENERAR REPORTE");
        btnGenerar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("MES:");

        comboMes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        comboCategoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        comboCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboCategoriaKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("CATEGORÍA:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(btnGenerar)
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(109, 109, 109))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel5)
                    .addGap(18, 18, 18)
                    .addComponent(comboCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(btnGenerar)
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(125, 125, 125)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(125, Short.MAX_VALUE)))
        );

        AutoCompleteDecorator.decorate(comboMes);
        AutoCompleteDecorator.decorate(comboCategoria);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        this.generarReporte();
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void comboCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboCategoriaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            this.btnGenerar.doClick();
        }
    }//GEN-LAST:event_comboCategoriaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JComboBox<Categoria> comboCategoria;
    private javax.swing.JComboBox<String> comboMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void cargarMes() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);

        DefaultComboBoxModel<String> monthModel = new DefaultComboBoxModel<>();
        String[] months = new String[]{"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO",
            "AGOSTO", "SETIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
        for (int i = 0; i < months.length; i++) {
            monthModel.addElement(months[i]);
        }

        this.comboMes.setModel(monthModel);
        this.comboMes.setSelectedItem(month);
    }

    private void generarReporte() {
        int mes = this.comboMes.getSelectedIndex() + 1;
        obtenerCombo();
        if (this.objC != null) {
            try {
                MensualReport reporte = new MensualReport();
                reporte.verReporte(mes, this.objC.getNombre(), Year.now().getValue());

                this.comboCategoria.setSelectedIndex(0);
                this.comboMes.setSelectedIndex(0);
                this.objC = null;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar una categoría.", "GENERAR --> REPORTE", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void cargarCombo() {
        this.comboCategoria.removeAllItems();
        Categoria objCat = new Categoria();
        objCat.setNombre("--Seleccione--");
        this.comboCategoria.addItem(objCat);

        try {
            CategoriaBo.obtenerListaComboCategoria(comboCategoria);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void obtenerCombo() {
        if (this.comboCategoria.getItemAt(this.comboCategoria.getSelectedIndex()) != null) {
            this.objC = this.comboCategoria.getItemAt(this.comboCategoria.getSelectedIndex());
        }
    }
}
