package othello.view;

import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Aleix
 */
public class MenuEscenarioUI extends javax.swing.JFrame {

    private CtrlView iCtrlView;
    
    /**
     * Creates new form MenuEscenarioUI
     */
    public MenuEscenarioUI(CtrlView pCtrlView) {
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
        btn_crearEscenario = new javax.swing.JButton();
        btn_modificarEscenario = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_atras = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(537, 425));
        setPreferredSize(new java.awt.Dimension(537, 425));

        jPanel1.setMinimumSize(new java.awt.Dimension(537, 325));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btn_crearEscenario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_crearEscenario.setText("Crear Escenario");
        btn_crearEscenario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearEscenarioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 7, 0);
        jPanel1.add(btn_crearEscenario, gridBagConstraints);

        btn_modificarEscenario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_modificarEscenario.setText("Modificar Escenario");
        btn_modificarEscenario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarEscenarioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 7, 0);
        jPanel1.add(btn_modificarEscenario, gridBagConstraints);

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

        btn_exit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_exit.setText("EXIT");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        jPanel2.add(btn_exit, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_crearEscenarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearEscenarioActionPerformed
        /*JOptionPane.showInputDialog("ingresa nombre");
        JOptionPane.showInputDialog("ingresa contraseña");
        JOptionPane.showMessageDialog(null, "usuario creado");
        JOptionPane.showMessageDialog(null, "usuario existente", "ERROR", 0);*/
        iCtrlView.changeWindow("CrearEscenario");
    }//GEN-LAST:event_btn_crearEscenarioActionPerformed

    private void btn_modificarEscenarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarEscenarioActionPerformed
        iCtrlView.changeWindow("SeleccionarEscenario");
    }//GEN-LAST:event_btn_modificarEscenarioActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        iCtrlView.backToMainWindow("MenuEscenario");
    }//GEN-LAST:event_btn_atrasActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_crearEscenario;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_modificarEscenario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
