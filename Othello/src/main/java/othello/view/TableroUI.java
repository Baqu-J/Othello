package othello.view;

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Aleix
 */
public class TableroUI extends JPanel {
    private CtrlView iCtrlView;
    /**
     * Creates new form TableroUI
     */
    public TableroUI() {
        initComponents();
        iCtrlView = null;
    }
    public TableroUI(CtrlView pCtrlView) {
        iCtrlView = pCtrlView;
        initComponents();
        
    }

    /**
     * 
     * @param grid 
     */
    public void fillGrid(String[] grid) {
        if(grid.length > 0){
            for (int i = 0; i < grid.length; i++) {
                    this.add(new CasillaUI(grid[i], iCtrlView));
            }
        }
    }
    
    public void clearGrid() {
        this.removeAll();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(23, 113, 43));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        setLayout(new java.awt.GridLayout(8, 8));
    }// </editor-fold>//GEN-END:initComponents
    
    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        Container c = getParent();
        if (c != null) {
            d = c.getSize();
        } else {
            return new Dimension(80, 80);
        }
        int w = (int) d.getWidth();
        int h = (int) d.getHeight();
        int s = (w < h ? w : h);
        return new Dimension(s, s);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
