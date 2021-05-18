package othello.view;

import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Aleix
 */
public class CasillaUI extends JButton {
    private CtrlView iCtrlView;
    /**
     * Creates new form NewBeanForm
     */
    public CasillaUI(String ficha, CtrlView pCtrlView) {
        iCtrlView = pCtrlView;
        initComponents();
        
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

        //this.setOpaque(false);
        this.setContentAreaFilled(false);        
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
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
