package finaloop;

import javax.swing.JOptionPane;

public class MenuForm extends javax.swing.JFrame {
        public MenuForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jStart_ = new javax.swing.JButton();
        jLeaderboard_ = new javax.swing.JButton();
        jExit_ = new javax.swing.JButton();
        jHTP_ = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MATH QUIZ");

        jStart_.setText("Start Game");
        jStart_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStart_ActionPerformed(evt);
            }
        });

        jLeaderboard_.setText("Leaderboard");
        jLeaderboard_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLeaderboard_ActionPerformed(evt);
            }
        });

        jExit_.setText("Exit");
        jExit_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExit_ActionPerformed(evt);
            }
        });

        jHTP_.setText("How To Play");
        jHTP_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHTP_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jHTP_, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jExit_, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLeaderboard_, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStart_, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jStart_)
                .addGap(18, 18, 18)
                .addComponent(jHTP_)
                .addGap(18, 18, 18)
                .addComponent(jLeaderboard_)
                .addGap(18, 18, 18)
                .addComponent(jExit_)
                .addContainerGap(48, Short.MAX_VALUE))
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

    private void jStart_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStart_ActionPerformed
        // to start the game
        QuizForm qf = new QuizForm();
        qf.show();

        dispose(); // close current frame 
    }//GEN-LAST:event_jStart_ActionPerformed

    private void jLeaderboard_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLeaderboard_ActionPerformed
        // to show the LeaderboardForm
        LeaderboardForm lf = new LeaderboardForm();
        lf.show(); // display 
        dispose(); // close current frame 
    }//GEN-LAST:event_jLeaderboard_ActionPerformed

    private void jExit_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExit_ActionPerformed
        // to quit the game
        int quit = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if(quit == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_jExit_ActionPerformed

    private void jHTP_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHTP_ActionPerformed
        // to show the How To Play Form
        HTPForm hf = new HTPForm();
        hf.show();
        dispose();  
    }//GEN-LAST:event_jHTP_ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jExit_;
    private javax.swing.JButton jHTP_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jLeaderboard_;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jStart_;
    // End of variables declaration//GEN-END:variables
}