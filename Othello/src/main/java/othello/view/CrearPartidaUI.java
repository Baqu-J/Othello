/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello.view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import othello.domain.Partida;

/**
 *
 * @author Foster
 */
public class CrearPartidaUI extends javax.swing.JFrame {
    private final CtrlView iCtrlView;
    /**
     * Creates new form CrearPartidaUI
     * @param pCtrlView
     */
    public CrearPartidaUI(CtrlView pCtrlView) {
        iCtrlView = pCtrlView;
        initComponents();
        actualiza_boxs();
        Image image = null;
        try {
            image = ImageIO.read(new File("src/main/java/resources/OthelloWindowIcon.png"));
        } catch (IOException ex) {
            Logger.getLogger(CrearPartidaUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setIconImage(image);
        //setVisible(true);
    }
    
    
    public void actualiza_boxs(){
        Combo1.setModel(new DefaultComboBoxModel(iCtrlView.getProfileModel()));
        
        DefaultComboBoxModel model = new DefaultComboBoxModel(iCtrlView.getProfileModel());
        if(!Combo1.getSelectedItem().equals("Guest")){
            model.removeElement(Combo1.getSelectedItem());
        }
        Object o = Combo2.getSelectedItem();
        Combo2.setModel(model);
        Combo2.setEditable(false);
        Combo2.setSelectedItem(o);
        Combo2.setEditable(true);
        
        model = new DefaultComboBoxModel(iCtrlView.getProfileModel());
        if(!Combo2.getSelectedItem().equals("Guest")){
            model.removeElement(Combo2.getSelectedItem());
        }
        o = Combo1.getSelectedItem();
        Combo1.setModel(model);
        Combo1.setEditable(false);
        Combo1.setSelectedItem(o);
        Combo1.setEditable(true);
        
    }
    
    public void setEscenario(String s) {
        LabelEscenario.setText(s);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        Jugador1 = new javax.swing.JRadioButton();
        IA1 = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        labelJ1 = new javax.swing.JLabel();
        Combo1 = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        RadioBlanco1 = new javax.swing.JRadioButton();
        RadioNegro1 = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        Jugador2 = new javax.swing.JRadioButton();
        IA2 = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        labelJ2 = new javax.swing.JLabel();
        Combo2 = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        RadioBlanco2 = new javax.swing.JRadioButton();
        RadioNegro2 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        LabelEscenario = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        startGameButton = new javax.swing.JButton();
        loadGameButton = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crear Partida");

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jugador 1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel4.setLayout(new java.awt.GridLayout(2, 2));

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.PAGE_AXIS));

        buttonGroup1.add(Jugador1);
        Jugador1.setSelected(true);
        Jugador1.setText("Jugador");
        Jugador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jugador1ActionPerformed(evt);
            }
        });
        jPanel6.add(Jugador1);

        buttonGroup1.add(IA1);
        IA1.setText("IA");
        IA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IA1ActionPerformed(evt);
            }
        });
        jPanel6.add(IA1);

        jPanel4.add(jPanel6);

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.PAGE_AXIS));

        labelJ1.setText("Escoge perfil:");
        labelJ1.setAlignmentX(0.5F);
        jPanel7.add(labelJ1);

        Combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Combo1.setMaximumSize(new java.awt.Dimension(60, 20));
        Combo1.setMinimumSize(new java.awt.Dimension(60, 20));
        Combo1.setPreferredSize(new java.awt.Dimension(60, 20));
        Combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo1ActionPerformed(evt);
            }
        });
        jPanel7.add(Combo1);

        jPanel4.add(jPanel7);

        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel3.setText("Selecciona Color:");
        jPanel8.add(jLabel3);

        buttonGroup2.add(RadioBlanco1);
        RadioBlanco1.setSelected(true);
        RadioBlanco1.setText("Blanco");
        RadioBlanco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioBlanco1ActionPerformed(evt);
            }
        });
        jPanel8.add(RadioBlanco1);

        buttonGroup2.add(RadioNegro1);
        RadioNegro1.setText("Negro");
        RadioNegro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioNegro1ActionPerformed(evt);
            }
        });
        jPanel8.add(RadioNegro1);

        jPanel4.add(jPanel8);

        jPanel2.add(jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jugador 2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel5.setLayout(new java.awt.GridLayout(2, 2));

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.PAGE_AXIS));

        buttonGroup3.add(Jugador2);
        Jugador2.setSelected(true);
        Jugador2.setText("Jugador");
        Jugador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jugador2ActionPerformed(evt);
            }
        });
        jPanel9.add(Jugador2);

        buttonGroup3.add(IA2);
        IA2.setText("IA");
        IA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IA2ActionPerformed(evt);
            }
        });
        jPanel9.add(IA2);

        jPanel5.add(jPanel9);

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.PAGE_AXIS));

        labelJ2.setText("Escoge perfil:");
        labelJ2.setAlignmentX(0.5F);
        jPanel10.add(labelJ2);

        Combo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Combo2.setMaximumSize(new java.awt.Dimension(60, 20));
        Combo2.setMinimumSize(new java.awt.Dimension(60, 20));
        Combo2.setPreferredSize(new java.awt.Dimension(60, 20));
        Combo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo2ActionPerformed(evt);
            }
        });
        jPanel10.add(Combo2);

        jPanel5.add(jPanel10);

        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel4.setText("Selecciona Color:");
        jPanel11.add(jLabel4);

        buttonGroup4.add(RadioBlanco2);
        RadioBlanco2.setText("Blanco");
        RadioBlanco2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioBlanco2ActionPerformed(evt);
            }
        });
        jPanel11.add(RadioBlanco2);

        buttonGroup4.add(RadioNegro2);
        RadioNegro2.setSelected(true);
        RadioNegro2.setText("Negro");
        RadioNegro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioNegro2ActionPerformed(evt);
            }
        });
        jPanel11.add(RadioNegro2);

        jPanel5.add(jPanel11);

        jPanel2.add(jPanel5);

        jPanel1.add(jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Escenario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel13.setLayout(new java.awt.GridLayout(1, 0));

        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.PAGE_AXIS));

        LabelEscenario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LabelEscenario.setText("Tablero standard");
        jPanel16.add(LabelEscenario);

        jPanel15.add(jPanel16);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton1);

        ResetButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ResetButton.setText("Reset");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });
        jPanel17.add(ResetButton);

        jPanel15.add(jPanel17);

        jPanel13.add(jPanel15);

        jPanel3.add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3);

        jPanel14.setLayout(new java.awt.GridBagLayout());

        startGameButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        startGameButton.setText("Comenzar");
        startGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        jPanel14.add(startGameButton, gridBagConstraints);

        loadGameButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loadGameButton.setText("Cargar");
        loadGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadGameButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        jPanel14.add(loadGameButton, gridBagConstraints);

        jPanel1.add(jPanel14);

        jPanel12.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel12.setMinimumSize(new java.awt.Dimension(0, 30));
        jPanel12.setPreferredSize(new java.awt.Dimension(650, 30));
        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        backButton.setText("Atras");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel12.add(backButton);

        jPanel1.add(jPanel12);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void IA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IA1ActionPerformed
        // TODO add your handling code here:
        labelJ1.setText("Escoge dificultad:");
        Combo1.setModel(new DefaultComboBoxModel(new String[]{"Facil", "Normal", "Dificil"}));
    }//GEN-LAST:event_IA1ActionPerformed

    private void RadioNegro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioNegro1ActionPerformed
        // TODO add your handling code here:
        RadioBlanco2.setSelected(true);
    }//GEN-LAST:event_RadioNegro1ActionPerformed

    private void Jugador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jugador1ActionPerformed
        // TODO add your handling code here:
        labelJ1.setText("Escoge perfil:");
        Combo1.setModel(new DefaultComboBoxModel(iCtrlView.getProfileModel()));
    }//GEN-LAST:event_Jugador1ActionPerformed

    private void Jugador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jugador2ActionPerformed
        // TODO add your handling code here:
         labelJ2.setText("Escoge perfil:");
         Combo2.setModel(new DefaultComboBoxModel(iCtrlView.getProfileModel()));
    }//GEN-LAST:event_Jugador2ActionPerformed

    private void IA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IA2ActionPerformed
        // TODO add your handling code here:
        labelJ2.setText("Escoge dificultad:");
        Combo2.setModel(new DefaultComboBoxModel(new String[]{"Facil", "Normal", "Dificil"}));
    }//GEN-LAST:event_IA2ActionPerformed

    private void RadioBlanco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioBlanco1ActionPerformed
        // TODO add your handling code here:
        RadioNegro2.setSelected(true);
    }//GEN-LAST:event_RadioBlanco1ActionPerformed

    private void RadioBlanco2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioBlanco2ActionPerformed
        // TODO add your handling code here:
        RadioNegro1.setSelected(true);
    }//GEN-LAST:event_RadioBlanco2ActionPerformed

    private void RadioNegro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioNegro2ActionPerformed
        // TODO add your handling code here:
        RadioBlanco1.setSelected(true);
    }//GEN-LAST:event_RadioNegro2ActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.setLocationRelativeTo(null);
        iCtrlView.backToMainWindow("CrearPartida");
    }//GEN-LAST:event_backButtonActionPerformed

    private void startGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameButtonActionPerformed
        // TODO add your handling code here:
        iCtrlView.changeWindow("Partida");
        iCtrlView.setupGame(Jugador1.isSelected(), Jugador2.isSelected(), IA1.isSelected(), IA2.isSelected(),
                            (String)Combo1.getSelectedItem(), (String)Combo2.getSelectedItem(), RadioBlanco1.isSelected(), LabelEscenario.getText());
    }//GEN-LAST:event_startGameButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        iCtrlView.changeWindow("SeleccionarEscenarioPartida");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void loadGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadGameButtonActionPerformed
        // TODO add your handling code here:
        iCtrlView.loadGame();
    }//GEN-LAST:event_loadGameButtonActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        // TODO add your handling code here:
        LabelEscenario.setText("Tablero standard");
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void Combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo1ActionPerformed
        // TODO add your handling code here:
        DefaultComboBoxModel model = new DefaultComboBoxModel(iCtrlView.getProfileModel());
        if(!Combo1.getSelectedItem().equals("Guest")){
            model.removeElement(Combo1.getSelectedItem());
        }
        Object o = Combo2.getSelectedItem();
        Combo2.setModel(model);
        Combo2.setEditable(false);
        Combo2.setSelectedItem(o);
        Combo2.setEditable(true);
    }//GEN-LAST:event_Combo1ActionPerformed

    private void Combo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo2ActionPerformed
        // TODO add your handling code here:
        DefaultComboBoxModel model = new DefaultComboBoxModel(iCtrlView.getProfileModel());
        if(!Combo2.getSelectedItem().equals("Guest")){
            model.removeElement(Combo2.getSelectedItem());
        }
        Object o = Combo1.getSelectedItem();
        Combo1.setModel(model);
        Combo1.setEditable(false);
        Combo1.setSelectedItem(o);
        Combo1.setEditable(true);
    }//GEN-LAST:event_Combo2ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combo1;
    private javax.swing.JComboBox<String> Combo2;
    private javax.swing.JRadioButton IA1;
    private javax.swing.JRadioButton IA2;
    private javax.swing.JRadioButton Jugador1;
    private javax.swing.JRadioButton Jugador2;
    private javax.swing.JLabel LabelEscenario;
    private javax.swing.JRadioButton RadioBlanco1;
    private javax.swing.JRadioButton RadioBlanco2;
    private javax.swing.JRadioButton RadioNegro1;
    private javax.swing.JRadioButton RadioNegro2;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton backButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel labelJ1;
    private javax.swing.JLabel labelJ2;
    private javax.swing.JButton loadGameButton;
    private javax.swing.JButton startGameButton;
    // End of variables declaration//GEN-END:variables
    
}

