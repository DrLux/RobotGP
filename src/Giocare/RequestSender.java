package Giocare;

import connection.Connection;
import connection.Message;
import connection.MessageObserver;
import connection.PartnerShutDownException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import robogp.matchmanager.Match;
import robogp.matchmanager.RobotMarker;

/**
 *
 * @author Sorrentino & Vair
 */
public class RequestSender extends javax.swing.JFrame implements MessageObserver {
    
    private static final String[] ERROR_TYPE = {"Errore sconosciuto", "Inserita una Key errata", "Il nickname scelto non è disponibile", "Connessione rifiutata"};
    private Connection conn;
    private String nickname;
    private String keyword;
    private int port;
    private String address;
    
    /**
     * Creates new form RequestSender
     */
    public RequestSender() {
        initComponents();
        conn = null;
        nickname = "";
        keyword = "";
        port = 0;
        address = "";
        requestInProgress(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_principale = new javax.swing.JPanel();
        button_request = new javax.swing.JButton();
        pannello_dati_utente = new javax.swing.JPanel();
        rs_keyword = new javax.swing.JLabel();
        rs_nickname = new javax.swing.JLabel();
        input_keyword = new javax.swing.JTextField();
        input_nickname = new javax.swing.JTextField();
        label_utenti = new javax.swing.JLabel();
        pannello_dati_server = new javax.swing.JPanel();
        rs_indirizzo = new javax.swing.JLabel();
        rs_porta = new javax.swing.JLabel();
        input_indirizzo = new javax.swing.JTextField();
        input_porta = new javax.swing.JTextField();
        label_dettagli_server = new javax.swing.JLabel();
        label_elaborazione = new javax.swing.JLabel();
        back_menu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        button_request.setText("Connetti al server");
        button_request.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_requestActionPerformed(evt);
            }
        });

        pannello_dati_utente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        rs_keyword.setText("Parola chiave:");

        rs_nickname.setText("Nickname:");

        label_utenti.setText("Dati utente");

        javax.swing.GroupLayout pannello_dati_utenteLayout = new javax.swing.GroupLayout(pannello_dati_utente);
        pannello_dati_utente.setLayout(pannello_dati_utenteLayout);
        pannello_dati_utenteLayout.setHorizontalGroup(
            pannello_dati_utenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannello_dati_utenteLayout.createSequentialGroup()
                .addGroup(pannello_dati_utenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pannello_dati_utenteLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(pannello_dati_utenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pannello_dati_utenteLayout.createSequentialGroup()
                                .addComponent(rs_nickname)
                                .addGap(42, 42, 42)
                                .addComponent(input_nickname, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pannello_dati_utenteLayout.createSequentialGroup()
                                .addComponent(rs_keyword)
                                .addGap(18, 18, 18)
                                .addComponent(input_keyword, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pannello_dati_utenteLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(label_utenti, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pannello_dati_utenteLayout.setVerticalGroup(
            pannello_dati_utenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannello_dati_utenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_utenti)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannello_dati_utenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rs_keyword)
                    .addComponent(input_keyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pannello_dati_utenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rs_nickname)
                    .addComponent(input_nickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pannello_dati_server.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        rs_indirizzo.setText("Indirizzo server:");

        rs_porta.setText("Porta server:");

        input_indirizzo.setText("localhost");

        input_porta.setText("2222");

        label_dettagli_server.setText("Configurazioni server di default");

        javax.swing.GroupLayout pannello_dati_serverLayout = new javax.swing.GroupLayout(pannello_dati_server);
        pannello_dati_server.setLayout(pannello_dati_serverLayout);
        pannello_dati_serverLayout.setHorizontalGroup(
            pannello_dati_serverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannello_dati_serverLayout.createSequentialGroup()
                .addGroup(pannello_dati_serverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pannello_dati_serverLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(pannello_dati_serverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pannello_dati_serverLayout.createSequentialGroup()
                                .addComponent(rs_porta)
                                .addGap(39, 39, 39)
                                .addComponent(input_porta, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pannello_dati_serverLayout.createSequentialGroup()
                                .addComponent(rs_indirizzo)
                                .addGap(18, 18, 18)
                                .addComponent(input_indirizzo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pannello_dati_serverLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(label_dettagli_server)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pannello_dati_serverLayout.setVerticalGroup(
            pannello_dati_serverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannello_dati_serverLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(label_dettagli_server)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pannello_dati_serverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rs_indirizzo)
                    .addComponent(input_indirizzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pannello_dati_serverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rs_porta)
                    .addComponent(input_porta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        label_elaborazione.setText("RICHIESTA IN ELABORAZIONE");
        label_elaborazione.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        back_menu.setText("Menu Principale");
        back_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_menuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_principaleLayout = new javax.swing.GroupLayout(Panel_principale);
        Panel_principale.setLayout(Panel_principaleLayout);
        Panel_principaleLayout.setHorizontalGroup(
            Panel_principaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_principaleLayout.createSequentialGroup()
                .addGroup(Panel_principaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_principaleLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(label_elaborazione))
                    .addGroup(Panel_principaleLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(Panel_principaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(Panel_principaleLayout.createSequentialGroup()
                                .addComponent(back_menu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_request, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_principaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pannello_dati_utente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pannello_dati_server, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        Panel_principaleLayout.setVerticalGroup(
            Panel_principaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_principaleLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pannello_dati_utente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pannello_dati_server, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(label_elaborazione, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_principaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_request, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(back_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_principale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_principale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_requestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_requestActionPerformed
        boolean ok = true;
        try {
            address = this.input_indirizzo.getText().trim();
            port = Integer.parseInt(this.input_porta.getText().trim());
            keyword = this.input_keyword.getText().trim();
            nickname = this.input_nickname.getText().trim();
            
            if (ok && (port < 1024 || port > 65535)) {
                ok = false;
                JOptionPane.showMessageDialog(this, "La porta deve essere un numero\ncompreso fra 1024 e 65535");
            }
            
            if (ok && address.isEmpty()){
                ok = false;
                JOptionPane.showMessageDialog(this, "L inidirizzo del server non può essere vuoto");
            }
            
            if (ok && nickname.isEmpty()){
                ok = false;
                JOptionPane.showMessageDialog(this, "Inserire un nickname");
            }
            
            if (ok){
                requestInProgress(true);                
                InetAddress address_server = InetAddress.getByName(address);
                open_connection(address_server, port);
                Message msg = new Message(Match.MatchJoinRequestMsg);
                Object[] pars = new Object[2];
                pars[0] = nickname;
                pars[1] = keyword;
                msg.setParameters(pars);
                conn.sendMessage(msg);
            }
        } catch (IOException|PartnerShutDownException ex) {
            close_connection();
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(RequestSender.class.getName()).log(Level.SEVERE, null, ex);
            requestInProgress(false);
        }
    }//GEN-LAST:event_button_requestActionPerformed

    private void back_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_menuActionPerformed
        close_connection();
        this.dispose();
        new RoboGP_Client.Client().setVisible(true);
    }//GEN-LAST:event_back_menuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RequestSender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RequestSender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RequestSender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RequestSender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RequestSender rs = new RequestSender();
                rs.setVisible(true);
                rs.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {                            
                        rs.close_connection();
                        //System.exit(0);
                    }
                });
            }
        });
    }
    
    @Override
    public void notifyMessageReceived(Message msg) {
        requestInProgress(false);
        System.out.println("***NEW Messaggio ricevuto:" + msg.getName());
        if (msg.getName().equals(Match.MatchJoinReplyMsg)) {
            boolean reply = (Boolean)msg.getParameter(0);
            System.out.println("\tRisposta: " + (reply ? "Accettato" : "Rifiutato"));
            if (reply) {
                String robodrome = (String)msg.getParameter(1);
                RobotMarker[] robots = (RobotMarker[])msg.getParameter(2);
                for (RobotMarker r: robots) {
                    JOptionPane.showMessageDialog(this, "\tRobot assegnato: " + r.getName() + " \n Dock di partenza: " + r.getDock());
                    System.out.println("\tRobot assegnato: " + r.getName() + " al dock " + r.getDock());
                }
                avvia_giocare(robodrome, robots);
            } else {
                close_connection();
                JOptionPane.showMessageDialog(this, ERROR_TYPE[(Integer) msg.getParameter(1)], "Errore Richieste", JOptionPane.ERROR_MESSAGE);

            }
        }
    }
    
    public void avvia_giocare(String robodrome, RobotMarker[] robots){
        this.dispose();
        conn.removeMessageObserver(this);
        new GiocareApp(conn,robodrome,robots).setVisible(true);
    }  
    
    public void close_connection(){
        if (conn != null){
            conn.removeMessageObserver(this);
            if (!conn.isClosed())
                conn.disconnect();
            conn = null;
        }
    }
    
    public void open_connection(InetAddress address_server, int port_server) throws IOException{
        close_connection();
        conn = Connection.connectToHost(address_server, port_server);
        conn.addMessageObserver(this);
    }
    
    public void requestInProgress(Boolean sended){
        label_elaborazione.setVisible(sended);
        input_keyword.setEnabled(!sended);
        input_indirizzo.setEnabled(!sended);
        input_nickname.setEnabled(!sended);
        input_porta.setEnabled(!sended);
        button_request.setEnabled(!sended);
        back_menu.setEnabled(!sended);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_principale;
    private javax.swing.JButton back_menu;
    private javax.swing.JButton button_request;
    private javax.swing.JTextField input_indirizzo;
    private javax.swing.JTextField input_keyword;
    private javax.swing.JTextField input_nickname;
    private javax.swing.JTextField input_porta;
    private javax.swing.JLabel label_dettagli_server;
    private javax.swing.JLabel label_elaborazione;
    private javax.swing.JLabel label_utenti;
    private javax.swing.JPanel pannello_dati_server;
    private javax.swing.JPanel pannello_dati_utente;
    private javax.swing.JLabel rs_indirizzo;
    private javax.swing.JLabel rs_keyword;
    private javax.swing.JLabel rs_nickname;
    private javax.swing.JLabel rs_porta;
    // End of variables declaration//GEN-END:variables
}