/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static othello.view.OthelloUI.panelMain;

/**
 *
 * @author FRANCO
 */
public class panelPrincipalOld extends javax.swing.JPanel implements ActionListener{

    /**
     * Creates new form principal
     */
    public panelPrincipalOld() {
        initComponents();
        //jButton1.setIcon(setIcono("src/main/java/resources/barra.jpg",jButton1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perfilActionPerformed
        panelPerfil p1 = new panelPerfil();
        p1.setSize(537,425);
        p1.setLocation(5,5);
        
        
        panelMain.removeAll();
        panelMain.add(p1,BorderLayout.CENTER);
        panelMain.revalidate();
        panelMain.repaint();
    }//GEN-LAST:event_btn_perfilActionPerformed

    private void btn_estadisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_estadisticaActionPerformed
        panelRanking p1 = new panelRanking();
        p1.setSize(537,425);
        p1.setLocation(5,5);
        
        
        panelMain.removeAll();
        panelMain.add(p1,BorderLayout.CENTER);
        panelMain.revalidate();
        panelMain.repaint();
    }//GEN-LAST:event_btn_estadisticaActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exitActionPerformed

    
    /*public Icon setIcono(String url, JButton boton){
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        
        int ancho = boton.getWidth();
        int alto = boton.getHeight();
        
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto,Image.SCALE_DEFAULT));
        
        return icono;
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
