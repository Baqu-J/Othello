/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello.view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Foster
 */
public class SeleccionarEscenarioUI extends javax.swing.JFrame {
    private final CtrlView iCtrlView;
    
    /**
     * Creates new form SeleccionarEscenario
     */
     public SeleccionarEscenarioUI(CtrlView pCtrlView) {
        iCtrlView = pCtrlView;
        initComponents();
        Image image = null;
        try {
            image = ImageIO.read(new File("src/main/java/resources/OthelloWindowIcon.png"));
        } catch (IOException ex) {
            Logger.getLogger(CrearPartidaUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setIconImage(image);
        //setVisible(true);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelSeleccionarEscenario1 = new othello.view.panelSeleccionarEscenario();
        jPanel4 = new javax.swing.JPanel();
        btn_anterior = new javax.swing.JButton();
        btn_seleccionar = new javax.swing.JButton();
        btn_siguiente = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 750));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        panelSeleccionarEscenario1.setPreferredSize(new java.awt.Dimension(600, 750));
        jPanel2.add(panelSeleccionarEscenario1);

        jPanel1.add(jPanel2);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        btn_anterior.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_anterior.setText("Anterior");
        btn_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anteriorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        jPanel4.add(btn_anterior, gridBagConstraints);

        btn_seleccionar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_seleccionar.setText("Seleccionar");
        btn_seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seleccionarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        jPanel4.add(btn_seleccionar, gridBagConstraints);

        btn_siguiente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_siguiente.setText("Siguiente");
        btn_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_siguienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        jPanel4.add(btn_siguiente, gridBagConstraints);

        jPanel1.add(jPanel4);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel5.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        backButton.setText("Atras");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel5.add(backButton);

        jPanel3.add(jPanel5);

        jPanel1.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        iCtrlView.backToWindow("SeleccionarEscenario");
    }//GEN-LAST:event_backButtonActionPerformed

    private void btn_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anteriorActionPerformed
        if(!panelSeleccionarEscenario1.escenarios.isEmpty() && panelSeleccionarEscenario1.current > 0) {
            --panelSeleccionarEscenario1.current;
            String[] parts = panelSeleccionarEscenario1.escenarios.get(panelSeleccionarEscenario1.current).split(",");
            panelSeleccionarEscenario1.jLabel1.setText(parts[0]);
            String[] grid = new String[8*8];
            for (int i = 1; i < parts.length; i++) {
                grid[i-1] = parts[i];
            }
            panelSeleccionarEscenario1.reloadGrid(grid);
        }
    }//GEN-LAST:event_btn_anteriorActionPerformed

    private void btn_seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccionarActionPerformed
        // TODO add your handling code here:
        String name = panelSeleccionarEscenario1.jLabel1.getText();

        iCtrlView.editEscenario(name);
        
    }//GEN-LAST:event_btn_seleccionarActionPerformed

    private void btn_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_siguienteActionPerformed
        if(!panelSeleccionarEscenario1.escenarios.isEmpty() && panelSeleccionarEscenario1.current < panelSeleccionarEscenario1.escenarios.size()-1) {
            ++panelSeleccionarEscenario1.current;
            String[] parts = panelSeleccionarEscenario1.escenarios.get(panelSeleccionarEscenario1.current).split(",");
            panelSeleccionarEscenario1.jLabel1.setText(parts[0]);
            String[] grid = new String[8*8];
            for (int i = 1; i < parts.length; i++) {
                grid[i-1] = parts[i];
            }
            panelSeleccionarEscenario1.reloadGrid(grid);
        }
    }//GEN-LAST:event_btn_siguienteActionPerformed

    public void initEscenario(){
        panelSeleccionarEscenario1.setEscenarios(iCtrlView.getEscenarios());
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton btn_anterior;
    private javax.swing.JButton btn_seleccionar;
    private javax.swing.JButton btn_siguiente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private othello.view.panelSeleccionarEscenario panelSeleccionarEscenario1;
    // End of variables declaration//GEN-END:variables
}
