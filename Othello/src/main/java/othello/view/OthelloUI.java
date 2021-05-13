package othello.view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Aleix
 */
public class OthelloUI extends JFrame {

    private CtrlView iCtrlView;
    
    /**
     * Creates new form OthelloUI
     * @param pCtrlView
     */
    public OthelloUI(CtrlView pCtrlView) {
        iCtrlView = pCtrlView;
        this.setTitle("Othello App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
            Image imageResized = ImageIO.read(new File("src/main/java/resources/ranking.png")).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            btn_ranking.setIcon(new ImageIcon(imageResized));
            Image image = ImageIO.read(new File("src/main/java/resources/OthelloWindowIcon.png"));
            this.setIconImage(image);
        } catch (Exception ex) {
        }
        
        
        initComponents();
        setVisible(true);
    }
    
   /** public void agregar_paneles(){
        panelPrincipal p1 = new panelPrincipal();
       // p1.setSize(537,425);
       // p1.setLocation(5,5);
        this.setContentPane(p1);
        
        panelMain.removeAll();
        panelMain.add(p1,BorderLayout.CENTER);
        panelMain.revalidate();
        panelMain.repaint();
    } 
    */

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
        panelMain = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_perfil = new javax.swing.JButton();
        btn_jugar = new javax.swing.JButton();
        btn_escenario = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_exit = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btn_ranking = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMain.setMinimumSize(new java.awt.Dimension(537, 425));

        jPanel7.setMinimumSize(new java.awt.Dimension(537, 425));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        btn_perfil.setText("PERFIL");
        btn_perfil.setMaximumSize(new java.awt.Dimension(200, 60));
        btn_perfil.setMinimumSize(new java.awt.Dimension(200, 60));
        btn_perfil.setPreferredSize(new java.awt.Dimension(200, 60));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel2.add(btn_perfil, gridBagConstraints);

        btn_jugar.setText("JUGAR");
        btn_jugar.setMaximumSize(new java.awt.Dimension(180, 60));
        btn_jugar.setMinimumSize(new java.awt.Dimension(180, 60));
        btn_jugar.setPreferredSize(new java.awt.Dimension(180, 60));
        btn_jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jugarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        jPanel2.add(btn_jugar, gridBagConstraints);

        btn_escenario.setText("ESCENARIO");
        btn_escenario.setMaximumSize(new java.awt.Dimension(180, 60));
        btn_escenario.setMinimumSize(new java.awt.Dimension(180, 60));
        btn_escenario.setPreferredSize(new java.awt.Dimension(180, 60));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(btn_escenario, gridBagConstraints);

        jPanel7.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btn_exit.setText("EXIT");
        jPanel3.add(btn_exit);

        jPanel7.add(jPanel3, java.awt.BorderLayout.SOUTH);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        jPanel4.add(btn_ranking);

        jPanel7.add(jPanel4, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
            .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelMainLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelMainLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jugarActionPerformed
        // TODO add your handling code here:
        CtrlView.crearPartida();
        setVisible(false);
    }//GEN-LAST:event_btn_jugarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_escenario;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_jugar;
    private javax.swing.JButton btn_perfil;
    private javax.swing.JButton btn_ranking;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel panelMain;
    // End of variables declaration//GEN-END:variables
}
