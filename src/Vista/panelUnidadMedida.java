package Vista;

import Datos.UnidadMedida;
import Datos.Modelo_Tabla_UnidadMedida;
import Negocio.UnidadMedidaBo;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class panelUnidadMedida extends javax.swing.JPanel {

    /**
     * Creates new form panelUnidadMedida
     */
    
    private Modelo_Tabla_UnidadMedida MTUM = new Modelo_Tabla_UnidadMedida();
    private UnidadMedida objU = null;
    private int estado = 1;

    public panelUnidadMedida() {
        initComponents();
        this.botonos();
        this.activarControles(false);
        this.definir_tamaño_columna();
        this.cargarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnEstado = new javax.swing.JCheckBox();
        labelNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtAbreviatura = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUnidadMedida = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/documento.png"))); // NOI18N
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disco-flexible.png"))); // NOI18N
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/codigo-limpio.png"))); // NOI18N
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(666, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiar)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        btnEstado.setBackground(new java.awt.Color(255, 204, 204));
        btnEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEstado.setSelected(true);
        btnEstado.setText("ACTIVO");
        btnEstado.setToolTipText("");
        btnEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/seleccion.png"))); // NOI18N
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });

        labelNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelNombre.setText("NOMBRE:");

        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtAbreviatura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtAbreviatura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAbreviaturaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAbreviaturaKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ABREVIATURA:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelNombre)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAbreviatura)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnEstado)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAbreviatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnEstado)
                .addGap(27, 27, 27))
        );

        jPanel5.setBackground(new java.awt.Color(255, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "UNIDADES DE MEDIDAS REGISTRADAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        tablaUnidadMedida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaUnidadMedida.setModel(this.MTUM);
        tablaUnidadMedida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaUnidadMedida.getTableHeader().setResizingAllowed(false);
        tablaUnidadMedida.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaUnidadMedida);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar-informacion.png"))); // NOI18N
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addGap(23, 23, 23))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEditar)
                            .addComponent(btnEliminar)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.activarControles(true);
        this.limpiar();
        this.cargarTabla();
        this.txtBuscar.setText("");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.limpiar();
        this.activarControles(false);
        this.cargarTabla();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed
        this.clicButtonEstado();
    }//GEN-LAST:event_btnEstadoActionPerformed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            this.txtAbreviatura.requestFocus();
        }

        this.txtNombre.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (Character.isLowerCase(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
                }
            }
        });
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        this.validar_llenado(evt, 2);
        if (this.txtNombre.getText().trim().length() >= 50) {
            getToolkit().beep(); //sonido de alerta
            evt.consume();
        }
        txtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String texto = txtNombre.getText() + e.getKeyChar();
                if (texto.matches(".*(.)\\1{2,}.*")) {
                    e.consume(); // Ignora la tecla si tiene más de 2 caracteres iguales seguidos
                }
            }
        });
        char c = evt.getKeyChar();
        if (c == ',' || c == '.' || c == '-') {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtAbreviaturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbreviaturaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            this.btnGuardar.doClick();
        }

        this.txtAbreviatura.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (Character.isLowerCase(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
                }
            }
        });
    }//GEN-LAST:event_txtAbreviaturaKeyPressed

    private void txtAbreviaturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbreviaturaKeyTyped
        this.validar_llenado(evt, 2);
        if (this.txtAbreviatura.getText().trim().length() >= 10) {
            getToolkit().beep(); //sonido de alerta
            evt.consume();
        }
        txtAbreviatura.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String texto = txtNombre.getText() + e.getKeyChar();
                if (texto.matches(".*(.)\\1{2,}.*")) {
                    e.consume(); // Ignora la tecla si tiene más de 2 caracteres iguales seguidos
                }
            }
        });
        char c = evt.getKeyChar();
        if (c == ',' || c == '.' || c == '-') {
            evt.consume();
        }
    }//GEN-LAST:event_txtAbreviaturaKeyTyped

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        this.txtBuscar.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (Character.isLowerCase(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
                }
            }
        });
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        this.buscar();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        this.validar_llenado(evt, 2);
        if (this.txtBuscar.getText().trim().length() >= 50) {
            getToolkit().beep(); //sonido de alerta
            evt.consume();
        }
        txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String texto = txtBuscar.getText() + e.getKeyChar();
                if (texto.matches(".*(.)\\1{2,}.*")) {
                    e.consume(); // Ignora la tecla si tiene más de 2 caracteres iguales seguidos
                }
            }
        });
        char c = evt.getKeyChar();
        if (c == ',' || c == '.' || c == '-') {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.buttonEditar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        this.eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JCheckBox btnEstado;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JTable tablaUnidadMedida;
    private javax.swing.JTextField txtAbreviatura;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void validar_llenado(java.awt.event.KeyEvent evt, int opc) {
        //opc: 1 es para ingresar solo números
        //opc: 2 es para ingresar solo letras
        char validar = evt.getKeyChar();
        if (opc == 1) {
            if (Character.isLetter(validar) && validar != KeyEvent.VK_SPACE
                    && validar != KeyEvent.VK_ENTER) {
                getToolkit().beep(); //sonido de alerta
                evt.consume();
            }
        }
        if (opc == 2) {
            if (Character.isDigit(validar) && validar != KeyEvent.VK_SPACE
                    && validar != KeyEvent.VK_ENTER) {
                getToolkit().beep(); //sonido de alerta
                evt.consume();
            }
        }
    }

    private void clicButtonEstado() {
        if (this.btnEstado.isSelected()) {
            ImageIcon icono = new ImageIcon("src/Imagenes/seleccion.png");
            this.btnEstado.setIcon(icono);
            this.btnEstado.setText("ACTIVO");
            estado = 1;
        } else {
            ImageIcon icono = new ImageIcon("src/Imagenes/no-seleccion.png");
            this.btnEstado.setIcon(icono);
            this.btnEstado.setText("INACTIVO");
            estado = 0;
        }
    }

    private void botonos() {
        this.btnCancelar.setOpaque(false);
        this.btnCancelar.setContentAreaFilled(false);
        this.btnCancelar.setBorderPainted(false);
        this.btnCancelar.setToolTipText("CANCELAR");

        this.btnNuevo.setOpaque(false);
        this.btnNuevo.setContentAreaFilled(false);
        this.btnNuevo.setBorderPainted(false);
        this.btnNuevo.setToolTipText("NUEVO REGISTRO");

        this.btnGuardar.setOpaque(false);
        this.btnGuardar.setContentAreaFilled(false);
        this.btnGuardar.setBorderPainted(false);
        this.btnGuardar.setToolTipText("GUARDAR");

        this.btnLimpiar.setOpaque(false);
        this.btnLimpiar.setContentAreaFilled(false);
        this.btnLimpiar.setBorderPainted(false);
        this.btnLimpiar.setToolTipText("LIMPIAR");

        this.btnEliminar.setOpaque(false);
        this.btnEliminar.setContentAreaFilled(false);
        this.btnEliminar.setBorderPainted(false);
        this.btnEliminar.setToolTipText("ELIMINAR");

        this.btnEditar.setOpaque(false);
        this.btnEditar.setContentAreaFilled(false);
        this.btnEditar.setBorderPainted(false);
        this.btnEditar.setToolTipText("EDITAR");
    }

    private void activarControles(boolean estado) {
        this.txtNombre.setEnabled(estado);
        this.txtAbreviatura.setEnabled(estado);
        this.btnGuardar.setEnabled(estado);
        this.btnLimpiar.setEnabled(estado);
        this.btnCancelar.setEnabled(estado);
        this.btnEstado.setEnabled(estado);

        this.btnNuevo.setEnabled(!estado);
        this.btnEditar.setEnabled(!estado);
        this.txtBuscar.setEnabled(!estado);
        this.tablaUnidadMedida.setEnabled(!estado);
        this.btnEliminar.setEnabled(!estado);

        if (estado) {
            tablaUnidadMedida.setBackground(new java.awt.Color(255, 102, 102));
        } else {
            tablaUnidadMedida.setBackground(new java.awt.Color(255, 255, 255));
        }
    }

    private void limpiar() {
        this.txtNombre.setText("");
        this.txtAbreviatura.setText("");

        this.btnEstado.setSelected(true);
        ImageIcon icono = new ImageIcon("src/Imagenes/seleccion.png");
        this.btnEstado.setIcon(icono);
        this.btnEstado.setText("ACTIVO");

        objU = null;
        estado = 1;
    }

    private void cargarTabla() {
        try {
            ArrayList<UnidadMedida> ltsUnidadMedida = UnidadMedidaBo.obtenerListaUnidadMedida();
            MTUM.setListado_UnidadMedida(ltsUnidadMedida);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void definir_tamaño_columna() {
        TableColumnModel columnModel = this.tablaUnidadMedida.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(250);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(150);

        this.tablaUnidadMedida.getTableHeader().setFont(new Font("Tahoma", 1, 12));
        ((DefaultTableCellRenderer) this.tablaUnidadMedida.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void guardar() {
        if (this.general()) {
            UnidadMedida objUnidMed = new UnidadMedida(0, this.txtNombre.getText(), this.txtAbreviatura.getText(), this.estado);
            try {
                if (this.objU == null) {
                    if (UnidadMedidaBo.existeUnidadMedida(this.txtNombre.getText())) {
                        if (UnidadMedidaBo.grabarUnidadMedida(objUnidMed)) {
                            JOptionPane.showMessageDialog(this, "Se Registró Correctamente", "MENSAJE --> UNIDAD DE MEDIDA", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "No se pudo Registrar", "MENSAJE --> UNIDAD DE MEDIDA", JOptionPane.ERROR_MESSAGE);
                        }
                        this.limpiar();
                        this.activarControles(false);
                        this.cargarTabla();
                    } else {
                        JOptionPane.showMessageDialog(this, "El Nombre ya se encuentra registrado.", "MENSAJE --> UNIDAD DE MEDIDA", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    boolean existenombre = true;
                    objUnidMed.setId(this.objU.getId());

                    if (!objUnidMed.getNombre().equals(this.objU.getNombre())) {
                        existenombre = UnidadMedidaBo.existeUnidadMedida(objUnidMed.getNombre());
                    }

                    if (existenombre) {
                        if (UnidadMedidaBo.modificarUnidadMedida(objUnidMed)) {
                            JOptionPane.showMessageDialog(this, "Se Modificó Correctamente", "MENSAJE --> UNIDAD DE MEDIDA", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "No se pudo Modificar", "MENSAJE --> UNIDAD DE MEDIDA", JOptionPane.ERROR_MESSAGE);
                        }
                        this.limpiar();
                        this.activarControles(false);
                        this.cargarTabla();
                    } else {
                        JOptionPane.showMessageDialog(this, "El Nombre ya se encuentra registrado.", "MENSAJE --> UNIDAD DE MEDIDA", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Verifique que todos los campos hallan sido llenados.", "MENSAJE --> UNIDAD DE MEDIDA", JOptionPane.WARNING_MESSAGE);
        }
    }

    private boolean general() {
        if (this.txtNombre.getText().trim().equals("") || this.txtAbreviatura.getText().trim().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    private void buscar() {
        String buscar = this.txtBuscar.getText().trim();
        ArrayList<UnidadMedida> ltsUnidadMedida = new ArrayList();
        try {
            ltsUnidadMedida = UnidadMedidaBo.buscarNombreUnidadMedida(buscar);
            if (ltsUnidadMedida.isEmpty()) {
                ltsUnidadMedida = UnidadMedidaBo.buscarNombreUnidadMedidaCorto(buscar);
            }
            MTUM.setListado_UnidadMedida(ltsUnidadMedida);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void eliminar() {
        if (this.tablaUnidadMedida.getSelectedRow() != -1) {
            int fila = this.tablaUnidadMedida.getSelectedRow();
            UnidadMedida objUniMed = MTUM.getUnidadMedida(fila);
            if (objUniMed.getEstado() == 1) {
                int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar la unidad de medida "
                        + objUniMed.toString() + " ?", "ELIMINAR --> UNIDAD DE MEDIDA", JOptionPane.YES_NO_OPTION);
                if (confirm == 0) {
                    try {
                        if (UnidadMedidaBo.eliminarUnidadMedida(objUniMed)) {
                            this.cargarTabla();
                            this.limpiar();
                            this.activarControles(false);
                        } else {
                            JOptionPane.showMessageDialog(this, "No se pudo Eliminar", "MENSAJE --> UNIDAD DE MEDIDA", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "La marca selecionada ya se encuentra Inactiva.", "MENSAJE --> UNIDAD DE MEDIDA", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usted no a seleccionado un campo en la tabla.", "MENSAJE --> UNIDAD DE MEDIDA", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buttonEditar() {
        this.txtBuscar.setText("");
        int fila = this.tablaUnidadMedida.getSelectedRow();
        if (fila != -1) {
            this.objU = MTUM.getUnidadMedida(fila);
            this.activarControles(true);
            this.cargarDatos(objU);
            this.cargarTabla();
            this.btnLimpiar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Usted no a seleccionado un campo en la tabla.", "MENSAJE --> UNIDAD DE MEDIDA", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarDatos(UnidadMedida objU) {
        this.txtNombre.setText(objU.getNombre());
        this.txtAbreviatura.setText(objU.getAbreviacion());

        if (objU.getEstado() == 1) {
            this.btnEstado.setSelected(true);
            ImageIcon icono = new ImageIcon("src/Imagenes/seleccion.png");
            this.btnEstado.setIcon(icono);
            this.btnEstado.setText("ACTIVO");
            this.estado = 1;
        } else {
            this.btnEstado.setSelected(false);
            ImageIcon icono = new ImageIcon("src/Imagenes/no-seleccion.png");
            this.btnEstado.setIcon(icono);
            this.btnEstado.setText("INACTIVO");
            this.estado = 0;
        }
    }
}
