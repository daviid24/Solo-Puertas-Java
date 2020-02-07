package solopuertas;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class jfProveedor extends javax.swing.JFrame {

    ConexionSQL SQL;
    private String entrada;
    
    public jfProveedor() {
        initComponents();
        
        this.SQL = new ConexionSQL() {

            String tabla = "tproveedor";
            String columna = "ID_Proveedor";
            
            
            @Override
            public void insertarSQL() {
                
                try {
                    ps = conectar().prepareStatement("INSERT INTO " + tabla + " VALUES(?,?,?,?,?,?,?,?)");
                    
                    ps.setString(1,SQL.codigo(tabla, "PR"));                    
                    ps.setString(2,entrada);
                    ps.setString(3,tfNIT.getText());
                    ps.setString(4,tfTelefono.getText());
                    ps.setString(5,tfCelular.getText());
                    ps.setString(6,tfDireccion.getText());
                    ps.setString(7,tfEmail.getText());
                    ps.setString(8,tfDescripcion.getText());

                    
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Registro guardado con éxito","Éxito",2);
                    
                } catch (SQLException ex) {
                    System.err.println("Errooor: " + ex);
                    JOptionPane.showMessageDialog(null,"Error al guardar el registro","Error",1);
                }
            }
            
            @Override
            public void modificarSQL() {
                String valor = tfID.getText();
                try {
                    ps = conectar().prepareStatement("UPDATE " + tabla + " SET Nombre = ?, NIT = ?, Telefono = ?, Celular = ?, Direccion = ?, Email = ?, Descripcion = ? WHERE " + columna + " = '" + valor + "'");
                    
                    ps.setString(1,entrada);
                    ps.setString(2,tfNIT.getText());
                    ps.setString(3,tfTelefono.getText() );
                    ps.setString(4,tfCelular.getText());
                    ps.setString(5,tfDireccion.getText() );
                    ps.setString(6,tfEmail.getText() );
                    ps.setString(7,tfDescripcion.getText());
                    
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Registro modificado con éxito","Éxito",2);
                    
                } catch (SQLException ex) {
                    System.err.println("Errooor: " + ex);
                    JOptionPane.showMessageDialog(null,"Error al modificar el registro","Error",1);
                }
            }
            
            @Override
            public void eliminarSQL() {
                //String valor = tfID.getText();
                //try {
                //    ps = conectar().prepareStatement("DELETE FROM " + tabla + " WHERE " + columna + " = '" + valor + "'");
                //    ps.executeUpdate();
                //    JOptionPane.showMessageDialog(null,"Registro eliminado con éxito","Éxito",2);
                    
                //} catch (SQLException ex) {
                //    System.err.println("Errooor: " + ex);
                //    JOptionPane.showMessageDialog(null,"Error al eliminar el registro","Error",1);
                //}
            }
            
            @Override
            public void consultarSQL() {
                String valor = tfID.getText();
                try {
                    s = conectar().createStatement();
                    ResultSet r = s.executeQuery("SELECT * FROM " + tabla + " WHERE " + columna + " = '" + valor + "'");
                    
                    r.beforeFirst();
                    r.next();
                    
                    tfNIT.setText(r.getString(3));
                    tfTelefono.setText(r.getString(4));
                    tfCelular.setText(r.getString(5));
                    tfDireccion.setText(r.getString(6));
                    tfEmail.setText(r.getString(7));
                    tfDescripcion.setText(r.getString(8));
                    
                } catch (SQLException ex) {
                    System.err.println("Errooor: " + ex);
                
                }
            }
            
            @Override
            public void lista(){

                try {
                    s = conectar().createStatement();
                    ResultSet r = s.executeQuery("select * from " + tabla);

                    r.beforeFirst();
                    while(r.next()){
                        listNombre.addItem(r.getString(2));
                    }

                } catch (SQLException ex) {
                    System.err.println("Errooor: " + ex);
                }

            }
        };
        this.setLocationRelativeTo(null);
        
        SQL.lista();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfNIT = new javax.swing.JTextField();
        tfCelular = new javax.swing.JTextField();
        tfDireccion = new javax.swing.JTextField();
        tfTelefono = new javax.swing.JTextField();
        tfDescripcion = new javax.swing.JTextField();
        listNombre = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        bEditar = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        bVolver = new javax.swing.JButton();
        bAgregar = new javax.swing.JButton();
        bLimpiar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INFORMACIÓN PROVEEDORES");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setOpaque(true);

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 204, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel4.setText("NIT");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel5.setText("Teléfono");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel6.setText("Celular");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel7.setText("Dirección");

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel8.setText("Descripción");

        tfNIT.setEditable(false);
        tfNIT.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tfNIT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfNIT.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        tfCelular.setEditable(false);
        tfCelular.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tfCelular.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCelular.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        tfDireccion.setEditable(false);
        tfDireccion.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tfDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfDireccion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        tfTelefono.setEditable(false);
        tfTelefono.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tfTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfTelefono.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        tfDescripcion.setEditable(false);
        tfDescripcion.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tfDescripcion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfDescripcion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        listNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        listNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listNombreActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel2.setText("ID");

        tfID.setEditable(false);
        tfID.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tfID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));
        tfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIDActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel9.setText("Email");

        tfEmail.setEditable(false);
        tfEmail.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        tfEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(listNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDireccion)
                            .addComponent(tfCelular)
                            .addComponent(tfNIT)
                            .addComponent(tfTelefono)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfEmail)
                            .addComponent(tfDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(listNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        bEditar.setBackground(new java.awt.Color(255, 255, 255));
        bEditar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bEditar.setText("Editar");
        bEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarActionPerformed(evt);
            }
        });

        bModificar.setBackground(new java.awt.Color(255, 255, 255));
        bModificar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bModificar.setText("Modificar");
        bModificar.setEnabled(false);
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });

        bVolver.setBackground(new java.awt.Color(255, 255, 255));
        bVolver.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bVolver.setText("Volver");
        bVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverActionPerformed(evt);
            }
        });

        bAgregar.setBackground(new java.awt.Color(255, 255, 255));
        bAgregar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bAgregar.setText("Agregar");
        bAgregar.setEnabled(false);
        bAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarActionPerformed(evt);
            }
        });

        bLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        bLimpiar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bLimpiar.setText("Limpiar");
        bLimpiar.setEnabled(false);
        bLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(bVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(bAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(bLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bAgregar)
                .addGap(11, 11, 11)
                .addComponent(bModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bVolver)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listNombreActionPerformed
        tfID.setText(SQL.buscar("tproveedor", listNombre.getSelectedItem().toString(),"Nombre",1));
        SQL.consultarSQL();
    }//GEN-LAST:event_listNombreActionPerformed

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed
        Permisos objPermisos = new Permisos();
        if(JOptionPane.showInputDialog(null,"Ingrese la clave de administrador: ","Permiso administrador",3).equals(objPermisos.getClave())){
           tfTelefono.setEditable(true);
           tfCelular.setEditable(true);
           tfDireccion.setEditable(true);
           tfDescripcion.setEditable(true);
           tfEmail.setEditable(true);
           tfNIT.setEditable(true);
           
           bLimpiar.setEnabled(true);
           bAgregar.setEnabled(true);
           bModificar.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null,"Clave incorrecta","Permiso Denegado",1);
        }

    }//GEN-LAST:event_bEditarActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        entrada = JOptionPane.showInputDialog("Nombre del proveedor",listNombre.getSelectedItem().toString());
        SQL.modificarSQL();
        listNombre.removeItem(listNombre.getSelectedItem());
        listNombre.addItem(entrada);
    }//GEN-LAST:event_bModificarActionPerformed

    private void bVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVolverActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_bVolverActionPerformed

    private void bAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarActionPerformed
        entrada = JOptionPane.showInputDialog(null,"Nombre del proveedor");
        SQL.insertarSQL();
        listNombre.addItem(entrada);
    }//GEN-LAST:event_bAgregarActionPerformed

    private void bLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpiarActionPerformed
        tfID.setText(SQL.codigo("tproveedor", "PR"));
        tfNIT.setText("");
        tfCelular.setText("");
        tfTelefono.setText("");
        tfDireccion.setText("");
        tfEmail.setText(""); 
        tfDescripcion.setText(""); 
        
    }//GEN-LAST:event_bLimpiarActionPerformed

    private void tfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIDActionPerformed
        
    }//GEN-LAST:event_tfIDActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAgregar;
    private javax.swing.JButton bEditar;
    private javax.swing.JButton bLimpiar;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox listNombre;
    private javax.swing.JTextField tfCelular;
    private javax.swing.JTextField tfDescripcion;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfNIT;
    private javax.swing.JTextField tfTelefono;
    // End of variables declaration//GEN-END:variables
}
