package othello.view;

/**
 *
 * @author Aleix
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CtrlView ctrlPresentacion = CtrlView.getInstance();
            }
        });
    }
}
