package Giocare;

import Allenamento.SchedaIstruzione;
import robogp.matchmanager.RobotMarker;

/**
 *
 * @author Sorrenitno & Vair
 */
public class RobotPalette extends javax.swing.JPanel {
    private FinestraDiProgrammazione finestra_associata;
    private int puntiSalute;
    private int punti_vite;
    private int checkpoint;
    private int respCol = 0;
    private int respRow = 0;
    
    /**
     * Creates new form RobotPalette
     */
    public RobotPalette(RobotMarker robot, FinestraDiProgrammazione finestra) {
        initComponents();
        icona_robot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/"+robot.getName()+".png")));
        puntiSalute = 10;
        punti_vite = 3;
        checkpoint = 0;
        updateInfo();
        finestra_associata = finestra;
        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        this.label_owner.setText("Robot di "+robot.getOwner());
    }
    
    public RobotPalette(RobotMarker robot) {
        initComponents();
        icona_robot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/"+robot.getName()+".png")));
        puntiSalute = 10;
        punti_vite = 3;
        checkpoint = 0;
        updateInfo();
        finestra_associata = null;
        btn_prog.setEnabled(false);
        btn_prog.setVisible(false);
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        this.label_owner.setText("Robot di "+robot.getOwner());
    }
    
    public void updateInfo(){
        punti_salute.setText(Integer.toString(puntiSalute));
        vite.setText(Integer.toString(punti_vite));
        this.check.setText(Integer.toString(checkpoint));
    }
    

    public int getPuntiSalute(){
        return this.puntiSalute;
    }
    
    public int getVite(){
        return this.punti_vite;
    }
    
    public int getCheck(){
        return checkpoint;
    }
    
    public boolean perdiSalute (int n){
        boolean sopravvive = puntiSalute > n; 
        if (sopravvive)
            puntiSalute -= n;
        else
            puntiSalute = 0;
        updateInfo();
        return sopravvive;
    }
    
    public void perdiVita(){
        if (punti_vite > 0){
            this.punti_vite--;
            puntiSalute = 10;
            updateInfo();
        } else {
            robot_morto(); 
        }
    }
    
    public void incSalute(){
        if (puntiSalute < 10)
            puntiSalute++;
        updateInfo();
    }
    
    public void incVite(){
        if (punti_vite < 3)
            punti_vite++;
    }
    
    public void putCheckPoint(int check){
        if ( check == checkpoint+1)
            this.checkpoint = check;
        updateInfo();        
    }
    
    public void updateRespawn(int col,int row){
        respCol = col;
        respRow = row;
    }
    public void robot_morto(){
        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        btn_prog.setEnabled(false);
        btn_prog.setVisible(false);
    }
    
    public void robot_vittoria(){
        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        btn_prog.setEnabled(false);
        btn_prog.setVisible(false);
    }
    
    public int getRowResp(){
        return this.respRow;
    }
    
    public int getColResp(){
        return this.respCol;
    }
    
    public void showScheda(SchedaIstruzione scheda){
        label_scheda.setScheda(scheda);
    }
    
    public void hideScheda(){
        label_scheda.getScheda();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        icona_robot = new javax.swing.JLabel();
        label_punti = new javax.swing.JLabel();
        punti_salute = new javax.swing.JLabel();
        label_vite = new javax.swing.JLabel();
        vite = new javax.swing.JLabel();
        btn_prog = new javax.swing.JButton();
        label_check = new javax.swing.JLabel();
        check = new javax.swing.JLabel();
        label_scheda = new Giocare.CustomLabelScheda();
        label_owner = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        icona_robot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/robot-emerald.png"))); // NOI18N

        label_punti.setText("Punti Salute:");

        label_vite.setText("Vite: ");

        btn_prog.setText("Programma");
        btn_prog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_progActionPerformed(evt);
            }
        });

        label_check.setText("CheckPoint: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(icona_robot)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_check)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(check))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_punti)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(punti_salute))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_vite)
                                        .addGap(18, 18, 18)
                                        .addComponent(vite)))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_prog)
                                .addGap(43, 43, 43))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(label_owner)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(label_scheda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(label_owner)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_punti)
                                    .addComponent(punti_salute))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_vite)
                                    .addComponent(vite)))
                            .addComponent(icona_robot, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(check)
                            .addComponent(label_check))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_prog))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_scheda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_progActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_progActionPerformed
        this.finestra_associata.setVisible(true);
    }//GEN-LAST:event_btn_progActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_prog;
    private javax.swing.JLabel check;
    private javax.swing.JLabel icona_robot;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_check;
    private javax.swing.JLabel label_owner;
    private javax.swing.JLabel label_punti;
    private Giocare.CustomLabelScheda label_scheda;
    private javax.swing.JLabel label_vite;
    private javax.swing.JLabel punti_salute;
    private javax.swing.JLabel vite;
    // End of variables declaration//GEN-END:variables
}
