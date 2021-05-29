package othello.view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Aleix
 */
public class PartidaUI extends javax.swing.JFrame {

    private CtrlView iCtrlView;
    private String typeGame;
    private String turnGame;
    
    private String [] letras = {"A","B","C","D","E","F","G","H"};
    private String [] numeros = {"8","7","6","5","4","3","2","1"};

    private Timer timerToIAMove = new Timer(1000,null);

    /**
     * Creates new form PartidaUI
     */
    public PartidaUI(CtrlView pCtrlView) {
        iCtrlView = pCtrlView;
        this.setTitle("Othello App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        btn_Pausa.setEnabled(false);
        btn_Pausa.setVisible(false);
        try {
            Image image = ImageIO.read(new File("src/main/java/resources/OthelloWindowIcon.png"));
            this.setIconImage(image);

        } catch (Exception ex) {
        }
        
        timerToIAMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timerToIAMove.stop();
                iCtrlView.commitPlayCurrentGame(0, 0); 
            }
        });
    }

    public void initGame() {
        jTextArea1.setText("");
        iCtrlView.printTypeGame();
        iCtrlView.redrawTablero();
        iCtrlView.printTurn();
        iCtrlView.printColorTurn();
        iCtrlView.printPlayers();
        iCtrlView.printFichas();
        btn_Pausa.setEnabled(true);
        btn_Pausa.setText("Pausar");

        if (this.typeGame.equals("IAvsIA")) {
            
            btn_Pausa.setEnabled(true);
            btn_Pausa.setVisible(true);
            
            jButtonGuardar.setEnabled(false);
            jButtonGuardar.setVisible(false);
            timerToIAMove.start();
        }
    }

    public void fillGrid(String[] grid) {
        if (grid.length > 0) {
            int x = 0, y = 0;
            for (int i = 0; i < grid.length; i++) {
                if(this.typeGame.equals("IAvsIA")) {
                    tableroUI1.add(new CasillaUI(2, grid[i], iCtrlView, x, y));
                } else if (this.typeGame.equals("PLAYERvsIA")) {
                    if(iCtrlView.turnPlayer().equals("IA")){
                        tableroUI1.add(new CasillaUI(2, grid[i], iCtrlView, x, y));
                    }else {
                        tableroUI1.add(new CasillaUI(0, grid[i], iCtrlView, x, y));
                    }
                } else if (this.typeGame.equals("PLAYERvsPLAYER")) {
                    tableroUI1.add(new CasillaUI(0, grid[i], iCtrlView, x, y));
                }
                if (y == 7) {
                    y = 0;
                    x++;
                } else {
                    y++;
                }
            }
        }
        tableroUI1.revalidate();
    }
    
    public void restartIATimer() {
        timerToIAMove.restart();
    }

    protected void reloadGrid(String[] grid) {
        tableroUI1.clearGrid();
        fillGrid(grid);
    }

    public void printColorTurn(String color) {
        jLabelTurnoColor.setText(color);
    }
    
    public void setFichas(int n, int b) {
        FichasN.setText("x"+String.valueOf(n));
        FichasB.setText("x"+String.valueOf(b));
    }
    
    public void setPlayerIcons(String N, String B) {
            Image imageResized;
        try {
            imageResized = ImageIO.read(new File("src/main/java/resources/OthelloBlackToken.png")).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            jLabelIcon1.setIcon(new ImageIcon(imageResized));
            imageResized = ImageIO.read(new File("src/main/java/resources/OthelloWhiteToken.png")).getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            jLabelIcon2.setIcon(new ImageIcon(imageResized));
        } catch (IOException ex) {
            Logger.getLogger(PartidaUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void printPlayers(String[] players) {
        jLabel3.setText(players[0]);
        jLabel5.setText(players[1]);
        setPlayerIcons(players[2], players[3]);
    }

    public void popUpMessage(String ret) {
        JOptionPane.showMessageDialog(null, ret, "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    public void addLog(int x, int y) {
        if(x != -1 && y != -1) {
            int auxX = x;
            int auxY = y;
            jTextArea1.append("Turno: " + turnGame + " - Ficha colocada en la posición " + letras[auxY] + numeros[auxX] + "\n");
        }
    }

    public String getTypeGame() {
        return typeGame;
    }

    public void setTypeGame(String typeGame) {
        this.typeGame = typeGame;
        jLabel1.setText("Partida de Tipo: " + typeGame);
    }

    public String getTurnGame() {
        return turnGame;
    }

    public void setTurnGame(String turnGame) {
        this.turnGame = turnGame;
        jLabelTurno.setText("Turno: " + turnGame);
    }
    
    public void printGameFinished(int[] scores) {
       String res;
       res = "Partida terminada!\n";
       if(scores[0] > scores[1]) {
           res += "WINNER - Negro!\n";
       }
       else if(scores[1] > scores[0]) {
           res += "WINNER - Blanco!\n";
       }
       else {
           res += "EMPATE!\n";
       }
       
       res += "Scores: \n"
               + "\tBlanco : " + scores[1]+"\n"
               + "\tNegro : " + scores[0] + "\n";
       JOptionPane.showMessageDialog(null, res);
       
       
       
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
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabelTurno = new javax.swing.JLabel();
        jLabelTurnoColor = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabelIcon1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        FichasN = new javax.swing.JLabel();
        tableroUI1 = new othello.view.TableroUI();
        jPanel3 = new javax.swing.JPanel();
        jLabelIcon2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        FichasB = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButtonGuardar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        btn_Pausa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(720, 720));
        setPreferredSize(new java.awt.Dimension(720, 720));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("jLabel2");
        jPanel1.add(jLabel1);

        jLabelTurno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTurno.setText("Turno");
        jPanel6.add(jLabelTurno);

        jLabelTurnoColor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTurnoColor.setText("jLabel7");
        jPanel6.add(jLabelTurnoColor);

        jPanel1.add(jPanel6);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(23, 113, 43));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel2.add(jLabel7, gridBagConstraints);

        jLabelIcon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIcon1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel2.add(jLabelIcon1, gridBagConstraints);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel2.add(jLabel3, gridBagConstraints);

        FichasN.setForeground(new java.awt.Color(255, 255, 255));
        FichasN.setText("jLabel8");
        jPanel2.add(FichasN, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(100, 5, 100, 5);
        getContentPane().add(jPanel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        getContentPane().add(tableroUI1, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(23, 113, 43));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabelIcon2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIcon2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel3.add(jLabelIcon2, gridBagConstraints);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("jLabel4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel3.add(jLabel5, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel3.add(jLabel2, gridBagConstraints);

        FichasB.setForeground(new java.awt.Color(255, 255, 255));
        FichasB.setText("jLabel8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel3.add(FichasB, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(100, 5, 100, 5);
        getContentPane().add(jPanel3, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        jPanel5.add(jButtonGuardar, gridBagConstraints);

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel5.add(jButtonSalir, gridBagConstraints);

        btn_Pausa.setText("Pausar");
        btn_Pausa.setPreferredSize(new java.awt.Dimension(71, 23));
        btn_Pausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PausaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel5.add(btn_Pausa, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jPanel5, gridBagConstraints);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(275, 100));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(275, 100));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setFocusable(false);
        jTextArea1.setMinimumSize(new java.awt.Dimension(250, 100));
        jScrollPane1.setViewportView(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel4.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(jPanel4, gridBagConstraints);

        jPanel7.setLayout(new java.awt.GridLayout(1, 8));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("A");
        jPanel7.add(jLabel4);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("B");
        jPanel7.add(jLabel6);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("C");
        jPanel7.add(jLabel8);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("D");
        jPanel7.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("E");
        jPanel7.add(jLabel10);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("F");
        jPanel7.add(jLabel11);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("G");
        jPanel7.add(jLabel12);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("H");
        jPanel7.add(jLabel13);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jPanel7, gridBagConstraints);

        jPanel8.setLayout(new java.awt.GridLayout(8, 1));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText(" ");
        jPanel8.add(jLabel14);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText(" ");
        jPanel8.add(jLabel15);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText(" ");
        jPanel8.add(jLabel16);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText(" ");
        jPanel8.add(jLabel17);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText(" ");
        jPanel8.add(jLabel18);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText(" ");
        jPanel8.add(jLabel19);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText(" ");
        jPanel8.add(jLabel20);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText(" ");
        jPanel8.add(jLabel21);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 7);
        getContentPane().add(jPanel8, gridBagConstraints);

        jPanel10.setLayout(new java.awt.GridLayout(8, 1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("8");
        jPanel10.add(jLabel22);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("7");
        jPanel10.add(jLabel23);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("6");
        jPanel10.add(jLabel24);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("5");
        jPanel10.add(jLabel25);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("4");
        jPanel10.add(jLabel26);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("3");
        jPanel10.add(jLabel27);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("2");
        jPanel10.add(jLabel28);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("1");
        jPanel10.add(jLabel29);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        getContentPane().add(jPanel10, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    protected void guardarPartida() {
        String ret = iCtrlView.guardarPartida();
        if (ret.equals("Error al guardar Partida")) {
            JOptionPane.showMessageDialog(null, ret, "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, ret, "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
        if(!typeGame.equals("IAvsIA"))guardarPartida();
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        PauseExit();
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Quieres guardar la partida?",
                "Salir",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null, 3);
        if(seleccion != 3) {
            if (seleccion == 0) {
                guardarPartida();
            }
            this.setVisible(false);
            iCtrlView.backToMainWindow("Partida");
        }
        
    }//GEN-LAST:event_jButtonSalirActionPerformed
    
    public void disablePausa() {
        btn_Pausa.setEnabled(false);
    }
    
    public void stopIATimer() {
        timerToIAMove.stop();
    }
    
    private void Pause() {
        
        if(btn_Pausa.getText().equals("Pausar")) {
            btn_Pausa.setText("Reanudar");
            timerToIAMove.stop();
        }
        else{
            btn_Pausa.setText("Pausar");
            timerToIAMove.restart();
        }
    }
    
    public void PauseExit() {
        if(timerToIAMove.isRunning()) {
            Pause();
        }
    }
    
    private void btn_PausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PausaActionPerformed
        // TODO add your handling code here:
           Pause();
    }//GEN-LAST:event_btn_PausaActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FichasB;
    private javax.swing.JLabel FichasN;
    private javax.swing.JButton btn_Pausa;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelIcon1;
    private javax.swing.JLabel jLabelIcon2;
    private javax.swing.JLabel jLabelTurno;
    private javax.swing.JLabel jLabelTurnoColor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private othello.view.TableroUI tableroUI1;
    // End of variables declaration//GEN-END:variables
}
