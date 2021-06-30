package vcon_final;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.FileDialog;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import model.ModelMeetings;
import model.ModelUser;


public class CreateMeeting extends javax.swing.JFrame {

    BufferedImage bi;
    String fn;
    boolean click;
    String passCode;
    ModelUser user;
    ModelMeetings modelMeeting;
    PreparedStatement ps;
    ResultSet rs;


    public CreateMeeting() {
        initComponents();
        this.panel_info.setVisible(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.edt_judul_meet.setVisible(false);
    }

    public void initMeeting(ModelUser user, String passCode) {
        this.passCode = passCode;
        this.user = user;
        this.txt_judul_meet.setText(user.getFull_name() + " Meet");
        this.txt_passcode.setText(passCode);
        this.txt_host.setText(user.getFull_name());

        String registerUserQuery = "INSERT INTO `meetings`(`judul_meeting`, `nama_host`, `passcode`, `nim`)VALUES(?,?,?,?)";

        String updateQuery = "UPDATE meetings SET passcode = '" + passCode + "' WHERE `nim` =" + user.getNim();
        updatePassCodeUser(user.getNim(), passCode);
        getMeeting(user.getNim());
        if (modelMeeting == null) {
            try {
                ps = DBconnection.getConnection().prepareStatement(registerUserQuery);
                ps.setString(1, user.getFull_name() + " Meet");
                ps.setString(2, user.getFull_name());
                ps.setString(3, passCode);
                ps.setInt(4, user.getNim());
                ps.execute();
            } catch (SQLException ex) {
                Logger.getLogger(CreateMeeting.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                ps = DBconnection.getConnection().prepareStatement(updateQuery);
                ps.execute();
            } catch (SQLException ex) {
                Logger.getLogger(CreateMeeting.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void getMeeting(int nim) {
        String query = "SELECT * FROM `meetings` WHERE `nim` = ?";

        PreparedStatement st;
        ResultSet rs;
        try {
            st = DBconnection.getConnection().prepareStatement(query);
            st.setInt(1, nim);
            rs = st.executeQuery();

            if (rs.next()) {
                modelMeeting = new ModelMeetings();
                modelMeeting.setId_meet(rs.getInt("id_meeting"));
                modelMeeting.setNim(rs.getInt("nim"));
                modelMeeting.setHost(rs.getString("nama_host"));
                modelMeeting.setJudul(rs.getString("judul_meeting"));
                modelMeeting.setSchedule(rs.getDate("jadwal"));
                modelMeeting.setPasscode(rs.getString("passcode"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateMeeting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void joinMeeting(ModelUser user, ModelMeetings model) {
        modelMeeting = model;
        this.passCode = model.getPasscode();
        this.user = user;
        this.txt_judul_meet.setText(model.getJudul() + " Meet");
        this.txt_passcode.setText(model.getPasscode());
        this.txt_host.setText(model.getHost());
        updatePassCodeUser(user.getNim(), model.getPasscode());
    }

    private void updatePassCodeUser(int nim, String passCode) {
        String updateQuery = "UPDATE users SET pass_code = '" + passCode + "' WHERE `nim` =" + nim;
        try {
            ps = DBconnection.getConnection().prepareStatement(updateQuery);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CreateMeeting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_chat = new javax.swing.JButton();
        btn_info = new javax.swing.JLabel();
        btn_invit_participant = new javax.swing.JButton();
        btn_info1 = new javax.swing.JLabel();
        panel_info = new javax.swing.JPanel();
        txt_judul_meet = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_host = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_passcode = new javax.swing.JLabel();
        edt_judul_meet = new javax.swing.JTextField();
        btn_edit = new javax.swing.JLabel();
        btn_endmeets = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WebCam");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/person.jpeg"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btn_chat.setText("Chat");
        btn_chat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chatActionPerformed(evt);
            }
        });

        btn_info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/microphone.png"))); // NOI18N

        btn_invit_participant.setText("Participant");
        btn_invit_participant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_invit_participantActionPerformed(evt);
            }
        });

        btn_info1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/information.png"))); // NOI18N
        btn_info1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_info1MouseClicked(evt);
            }
        });

        panel_info.setBackground(new java.awt.Color(255, 255, 255));

        txt_judul_meet.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txt_judul_meet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_judul_meet.setText("Jabar Meet ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Host");

        txt_host.setText("Jabar Reza (You)");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("PassCode");

        txt_passcode.setText("Kewj193");

        edt_judul_meet.setText("Judul");
        edt_judul_meet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edt_judul_meetActionPerformed(evt);
            }
        });
        edt_judul_meet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edt_judul_meetKeyPressed(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(255, 255, 255));
        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_infoLayout = new javax.swing.GroupLayout(panel_info);
        panel_info.setLayout(panel_infoLayout);
        panel_infoLayout.setHorizontalGroup(
            panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_infoLayout.createSequentialGroup()
                        .addGroup(panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_infoLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_host, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_infoLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                                .addComponent(txt_passcode, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 42, Short.MAX_VALUE))
                    .addGroup(panel_infoLayout.createSequentialGroup()
                        .addComponent(txt_judul_meet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_edit))
                    .addComponent(edt_judul_meet))
                .addContainerGap())
        );
        panel_infoLayout.setVerticalGroup(
            panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(edt_judul_meet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_judul_meet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_host)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_passcode))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_endmeets.setText("End Meetings");
        btn_endmeets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_endmeetsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(panel_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_invit_participant, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(btn_info)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_chat, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_endmeets)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(btn_info1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btn_endmeets)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_chat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_invit_participant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(btn_info))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panel_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(btn_info1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_chatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chatActionPerformed
        RoomChat RoomChat = new RoomChat();
        RoomChat.initRoomChat(this.user, this.passCode);
        RoomChat.setVisible(true);
        RoomChat.pack();
        RoomChat.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_chatActionPerformed

    private void btn_invit_participantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_invit_participantActionPerformed
        Participant participant = new Participant();

        participant.loadParticipant(modelMeeting.getHost(), this.user, this.passCode);
        participant.setVisible(true);
        participant.pack();
        participant.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_invit_participantActionPerformed

    private void btn_info1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_info1MouseClicked
        if (!click) {
            click = true;
            this.panel_info.setVisible(true);
        } else {
            click = false;
            this.panel_info.setVisible(false);
        }
    }//GEN-LAST:event_btn_info1MouseClicked

    private void edt_judul_meetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edt_judul_meetKeyPressed

    }//GEN-LAST:event_edt_judul_meetKeyPressed

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
        this.edt_judul_meet.setText(txt_judul_meet.getText().toString());
        this.edt_judul_meet.setVisible(true);
        this.txt_judul_meet.setVisible(false);
        this.btn_edit.setVisible(false);
    }//GEN-LAST:event_btn_editMouseClicked

    private void edt_judul_meetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edt_judul_meetActionPerformed

        String judul_meet = edt_judul_meet.getText().toString();
        this.txt_judul_meet.setText(judul_meet);
        this.edt_judul_meet.setVisible(false);
        this.txt_judul_meet.setVisible(true);
        this.btn_edit.setVisible(true);
        String updateQuery = "UPDATE meetings SET judul_meeting = '" + judul_meet + "' WHERE `nim` =" + user.getNim();
        try {
            ps = DBconnection.getConnection().prepareStatement(updateQuery);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CreateMeeting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_edt_judul_meetActionPerformed

    private void btn_endmeetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_endmeetsActionPerformed

        this.dispose();
    }//GEN-LAST:event_btn_endmeetsActionPerformed


    public static void main(String args[]) {
        CreateMeeting form = new CreateMeeting();
        form.setVisible(true);
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateMeeting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateMeeting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateMeeting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateMeeting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_chat;
    private javax.swing.JLabel btn_edit;
    private javax.swing.JButton btn_endmeets;
    private javax.swing.JLabel btn_info;
    private javax.swing.JLabel btn_info1;
    private javax.swing.JButton btn_invit_participant;
    private javax.swing.JTextField edt_judul_meet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel_info;
    private javax.swing.JLabel txt_host;
    private javax.swing.JLabel txt_judul_meet;
    private javax.swing.JLabel txt_passcode;
    // End of variables declaration//GEN-END:variables
}