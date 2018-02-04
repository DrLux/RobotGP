package Giocare;

import Allenamento.*;
import connection.Connection;
import connection.Message;
import connection.MessageObserver;
import connection.PartnerShutDownException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import robogp.matchmanager.Match;
import robogp.matchmanager.RobotMarker;
import robogp.robodrome.Robodrome;
import robogp.robodrome.view.RobodromeView;


/**
 *
 * @author Sorrentino & Vair
 */
public class GiocareApp extends JFrame implements MessageObserver{
    
    private RobodromeView rv;
    private RobotMarker[] miei_robot;
    public ArrayList<RobotMarker> all_robot;
    private GestoreProgrammazione gp;
    private EseguiGiocare esecutor;
    private Connection conn;
    private Match.EndGame endGameCondition;
    private boolean animationReady = false;
    
                                
    /**
     * Creates new form AllenarsiApp
     */
    public GiocareApp(Connection connessione,String type_robodrome, RobotMarker[] new_robot) {
        miei_robot = new_robot;
        conn = connessione;
        conn.addMessageObserver(this);
        initComponents(); //inizializza le componenti della finestra grafica
        initElements(type_robodrome); //inizializza gli elementi del gioco (robot-robodromo)
        setBounds(0, 0, 1200, 800); //Stabilisce le dimensioni della finestra quando non è fullscreen
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setTitle("RoboGP Partita Multiplayer");
        if (miei_robot.length > 1)
            this.submit.setText("Invia programmi");
    };
    
     private void initElements(String type_robodrome) {
        this.label_feedback.setText("***Invio richiesta del pool di schede***");
        this.submit.setEnabled(false);
        rv = new RobodromeView(new Robodrome(type_robodrome), 60);
        for (RobotMarker robot : miei_robot) {
            rv.put_robot_in_dock(robot);
        }
        get_pool();
        gp = new GestoreProgrammazione(miei_robot, pannello_robot);
        PanelRoboview.setViewportView(rv); //aggiunge robodromeView alla finestra
     }
     
     public void get_pool(){
        Message reply = new Message(Match.PoolRequest);
        try {
            conn.sendMessage(reply);
        } catch (PartnerShutDownException ex) {
            Logger.getLogger(GiocareApp.class.getName()).log(Level.SEVERE, null, ex);
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

        jFrame1 = new javax.swing.JFrame();
        PanelRoboview = new javax.swing.JScrollPane();
        pannello_robot = new javax.swing.JPanel();
        panel_label = new javax.swing.JPanel();
        label_feedback = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        stop = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        PanelRoboview.setAutoscrolls(true);

        pannello_robot.setLayout(new java.awt.GridLayout(4, 1));

        label_feedback.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        label_feedback.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_feedback.setText("Feedback utente");
        label_feedback.setToolTipText("");
        label_feedback.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panel_labelLayout = new javax.swing.GroupLayout(panel_label);
        panel_label.setLayout(panel_labelLayout);
        panel_labelLayout.setHorizontalGroup(
            panel_labelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_labelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_feedback, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE))
        );
        panel_labelLayout.setVerticalGroup(
            panel_labelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_labelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label_feedback, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        submit.setText("Invia Programma");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        stop.setText("Esci");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelRoboview))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pannello_robot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stop, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(submit)
                        .addComponent(stop)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelRoboview, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addComponent(pannello_robot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        PanelRoboview.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        this.label_feedback.setText("*** In attesa di altri giocatori ***");
        this.submit.setEnabled(false);
        gp.chiudi_finestre();
        send_program();                
    }//GEN-LAST:event_submitActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        if (conn != null){
            conn.removeMessageObserver(this);
            if (!conn.isClosed())
                conn.disconnect();
            conn = null;
        }
        this.dispose();
        new RoboGP_Client.Client().setVisible(true);
    }//GEN-LAST:event_stopActionPerformed

    @Override
    @SuppressWarnings("unchecked")
    public void notifyMessageReceived(Message msg) {
        
        switch(msg.getName()){
            case Match.MancheInitResponse:{ // ad ogni Inizio manche
                this.label_feedback.setText("*** Esecuzione Programmi in corso ***");
                this.all_robot = (ArrayList<RobotMarker>)(msg.getParameter(1)); //array list di robot robot                 
                if (!rv.isPlayingAnimation()){
                    esecutor = new EseguiGiocare(this.all_robot,rv,gp, label_feedback,conn);
                    esecutor.setNumRobotToWin(getNumRobToWin()); 
                    esecutor.start();    
                }
                
                this.submit.setEnabled(true);
                ArrayList<List<SchedaIstruzione>> pools = (ArrayList<List<SchedaIstruzione>>) msg.getParameter(0);
                int i = 0;
                for (List<SchedaIstruzione> pool : pools){ //associo i vari pool personali ai miei robot
                    gp.addPool(miei_robot[i].getName(), pool);
                    i++;
                }
            break;
            }
            case Match.MatchResponseStart:{
                this.submit.setEnabled(true);
                this.all_robot = (ArrayList<RobotMarker>)(msg.getParameter(0)); //array list di robot robot                 
                gp.other_panel(all_robot);
                for (RobotMarker robot : all_robot){ //posiziono tutti i robot
                   rv.put_robot_in_dock(robot);
                }
                endGameCondition = (Match.EndGame)msg.getParameter(1);
                break;
            }
            case Match.PoolResponse:{
                this.submit.setEnabled(false);
                ArrayList<List<SchedaIstruzione>> pools = (ArrayList<List<SchedaIstruzione>>) msg.getParameter(0);
                for (int i = 0; i < miei_robot.length; i++){
                   gp.addPool(miei_robot[i].getName(), pools.get(i));
                }
                if (miei_robot.length > 1)
                    this.label_feedback.setText("***Programma i tuoi robot***");
                else    
                    this.label_feedback.setText("***Programma il tuo robot***");
                break;
            }
        }            
    }
    
    public void send_program(){
        Message reply = new Message(Match.MancheInit);
        try {
            this.miei_robot = gp.get_programmed_robot();
            Object[] parameters = new Object[1];
            parameters[0] = this.miei_robot; 
            reply.setParameters(parameters);
            conn.sendMessage(reply);
        } catch (PartnerShutDownException ex) {
            Logger.getLogger(GiocareApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getNumRobToWin(){
        int ret = 1;
        switch(endGameCondition.ordinal()){
            case 0:
                ret = 1;
            break;
            case 1:
                ret = 3;
            break;
            case 2:
                ret = all_robot.size()-1;
            break;
        }
        return ret;
    }
          
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane PanelRoboview;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel label_feedback;
    private javax.swing.JPanel panel_label;
    private javax.swing.JPanel pannello_robot;
    private javax.swing.JButton stop;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables

}
