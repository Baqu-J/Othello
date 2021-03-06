package othello.view;

import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author FRANCO
 */
public class MenuPerfilUI extends javax.swing.JFrame {

    private CtrlView iCtrlView;
    
    /**
     * Creates new form MenuPerfilUI
     */
    public MenuPerfilUI(CtrlView pCtrlView) {
        iCtrlView = pCtrlView;
        this.setTitle("Othello App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComponents();
        try {
            Image image = ImageIO.read(new File("src/main/java/resources/OthelloWindowIcon.png"));
            this.setIconImage(image);
            
        } catch (Exception ex) {
        }
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
        btn_crearPerfil = new javax.swing.JButton();
        btn_consultarEstadistica = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_atras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(537, 425));
        setPreferredSize(new java.awt.Dimension(537, 425));
        setSize(new java.awt.Dimension(537, 425));

        jPanel1.setMinimumSize(new java.awt.Dimension(537, 325));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btn_crearPerfil.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_crearPerfil.setText("Crear Perfil");
        btn_crearPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearPerfilActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 7, 0);
        jPanel1.add(btn_crearPerfil, gridBagConstraints);

        btn_consultarEstadistica.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_consultarEstadistica.setText("Consultar Estadistica");
        btn_consultarEstadistica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultarEstadisticaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 7, 0);
        jPanel1.add(btn_consultarEstadistica, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        btn_atras.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_atras.setText("ATRAS");
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        jPanel2.add(btn_atras, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        this.setLocationRelativeTo(null);
        iCtrlView.backToMainWindow("MenuPerfil");
    }//GEN-LAST:event_btn_atrasActionPerformed

    private void btn_crearPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearPerfilActionPerformed
        this.setLocationRelativeTo(null);
        iCtrlView.changeWindow("CrearPerfil");
    }//GEN-LAST:event_btn_crearPerfilActionPerformed

    private void btn_consultarEstadisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultarEstadisticaActionPerformed
        this.setLocationRelativeTo(null);
        iCtrlView.changeWindow("Perfil");
    }//GEN-LAST:event_btn_consultarEstadisticaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_consultarEstadistica;
    private javax.swing.JButton btn_crearPerfil;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
