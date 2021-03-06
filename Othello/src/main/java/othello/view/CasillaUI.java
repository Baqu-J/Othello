package othello.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @author Aleix Velasco Calvo
 */
public class CasillaUI extends JButton implements MouseListener {
    
    private CtrlView iCtrlView;
    private int from;
    private int x;
    private int y;
    private String ficha;

    private Border defaultBorder = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 1), BorderFactory.createEmptyBorder(1, 1, 1, 1));
    private Border hoverBorder = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE, 1), BorderFactory.createEmptyBorder(1, 1, 1, 1));
    private Border pressedBorder = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE, 2), BorderFactory.createEmptyBorder(1, 1, 1, 1));
    
    /**
     * Creates new form NewBeanForm
     */
    public CasillaUI(int from, String ficha, CtrlView pCtrlView, int x, int y) {
        iCtrlView = pCtrlView;
        initComponents();
        
        this.ficha = ficha;
        changeIcon();

        this.setBorder(this.defaultBorder);
        addMouseListener(this);
        this.setContentAreaFilled(false); 
        this.from = from;
        this.x = x;
        this.y = y;

        
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }
    
    public int getGridX() {
        return this.x;
    }

    public void setGridX(int x) {
        this.x = x;
    }

    public int getGridY() {
        return this.y;
    }

    public void setGridY(int y) {
        this.y = y;
    }
    
    public String getFicha() {
        return this.ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
        changeIcon();
    }
    
    private void changeIcon(){
        String imgFicha = "";
        if (ficha.equals("BLANCA")) {
            imgFicha = "src/main/java/resources/OthelloWhiteToken.png";
        } else if (ficha.equals("NEGRA")) {
            imgFicha = "src/main/java/resources/OthelloBlackToken.png";
        }

        try {
            Image imageResized = ImageIO.read(new File(imgFicha)).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            this.setIcon(new ImageIcon(imageResized));
            this.setDisabledIcon(new ImageIcon(imageResized));

        } catch (Exception ex) {
        }
        if (!ficha.equals("VACIA")) {
            this.setEnabled(false);
        }
        
        if (from == 2) {
            this.setEnabled(false);
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

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        setName(""); // NOI18N
        addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formActionPerformed(evt);
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void formActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formActionPerformed
        // TODO add your handling code here:
        if(from == 0){
            iCtrlView.commitPlayCurrentGame(x, y);
        } else if(from == 1){
            iCtrlView.commitPlayCurrentEscenario(x, y);
        }
    }//GEN-LAST:event_formActionPerformed

    @Override
    public void mouseClicked(MouseEvent e) {   
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this && this.isEnabled()) {
            this.setBorder(this.pressedBorder);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       if (e.getSource() == this && this.isEnabled()) {
            this.setBorder(this.defaultBorder);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this && this.isEnabled()) {
            this.setBorder(this.hoverBorder);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this && this.isEnabled()) {
            this.setBorder(this.defaultBorder);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
