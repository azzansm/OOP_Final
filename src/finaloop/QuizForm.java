package finaloop;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Timer;

public class QuizForm extends javax.swing.JFrame {
    
    // array of questions
    String[] questions = {
        "9 + 3 = ?",
        "Solve the equation: 2x + 5 = 7", 
        "What is the value of 3! (3 factorial) ?", 
        "What is the square root of 81",
        "Simplify the expression: 3 + 2 x 4 - 6 / 3",
        "2, 6, 12, 20, 30, __ ?",
        "1 + 1 = ?",
        "13 x 9 = ?"};
    
    // array of options fot each questions (last item is the correct asnwer)
    String[][] options = {
        {"15", "12", "13", "10","12"}, 
        {"x = 6", "x = 9", "x = 1", "x = 8", "x = 1"}, 
        {"3", "12", "6", "9", "6"}, 
        {"10", "9", "7", "8", "9"}, 
        {"9", "11", "13", "12", "9"},
        {"36", "40", "42", "45", "40"},
        {"3", "2", "5", "4","2"},
        {"99", "117", "127", "115","117"}};
    
    // setting the initial index and score to 0
    int index, score = 0;
    Player player;
    String playerName;
    
    // ButtonGroup to handle radio buttons
    ButtonGroup bg = new ButtonGroup();
    private int timeRemaining = 7;
    private Timer timer;
    

    public QuizForm() {
        shuffleQuestionsAndOptions();        
        initComponents();
        bg.add(jRadioButton1_);
        bg.add(jRadioButton2_);
        bg.add(jRadioButton3_);
        bg.add(jRadioButton4_);
        jNext_ActionPerformed(null);
        
        initializePlayer();
    }
    
    // shuffle the questions and options randomly
    private void shuffleQuestionsAndOptions() {
        Random rnd = new Random();
        for (int i = questions.length - 1; i > 0; i--) {
            int index1 = rnd.nextInt(i + 1);

            // shuffle questions
            String tempQuestion = questions[index1];
            questions[index1] = questions[i];
            questions[i] = tempQuestion;

            // shuffle options
            String[] tempOptions = options[index1];
            options[index1] = options[i];
            options[i] = tempOptions;
        }
    }    
    
    private void initializePlayer(){
        // initialize the player by getting the player name and score
        playerName = getPlayerName();
        player = new Player(playerName,score);
    }
    
    private String getPlayerName(){
       // prompt the user to enter their name and return the name as a string
       // if no name is entered, the name will be set as "Anonymous"
       String name = JOptionPane.showInputDialog(null, "Enter your name: ");
       if (name == null || name.trim().isEmpty()){
           name = "Anonymous";
       }
       return name;
    }
    
    public void getSelectedOption(JRadioButton rbtn){
        // get the selected value from the radiobutton
        // if the selected answer is correct, increment the score
        // disable the radiobuttons after selection is made
   
        System.out.println(rbtn.getText());
        System.out.println(options[index][4]);
        
        if(rbtn.getText().equals(options[index][4])){
          score++;
          player.setScore(score);
        }
        
        enableRbuttons(false);
        index++;
    }
    
    public void enableRbuttons(boolean yes_or_no){
        // enable/disable radiobuttons based on the input parameter
        jRadioButton1_.setEnabled(yes_or_no);
        jRadioButton2_.setEnabled(yes_or_no);
        jRadioButton3_.setEnabled(yes_or_no);
        jRadioButton4_.setEnabled(yes_or_no);
    }
    
    private void startTimer() {
        // start the timer for each question with a countdown of 7 seconds
        // update the timer label every second
        // when the timer runs out, stop the timer, disable the radio buttons, and move to the next question
        timeRemaining = 7;
        jTimer.setText(formatTime(timeRemaining));

        if (timer != null && timer.isRunning()) {
            timer.stop();
        }

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimer();
            }
        });
        timer.start();
    }

    private void updateTimer() {
        // update the timer label every second
        // when the timer runs out, stop the timer, disable the radio buttons, and move to the next question
        timeRemaining--;

        if (timeRemaining >= 0) {
            jTimer.setText(formatTime(timeRemaining));
        } else {
            jTimer.setText("Time's up!");
            timer.stop();
            jRadioButton1_.setEnabled(false);
            jRadioButton2_.setEnabled(false);
            jRadioButton3_.setEnabled(false);
            jRadioButton4_.setEnabled(false);
            index++;
        }
    }

    private String formatTime(int seconds) {
        // format the time in hh:mm:ss format and return as a string
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int remainingSeconds = seconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);
    }
            
    public void showLeaderboard() {
        // create a new leaderboard form
        // add a player to the leaderboard
        // ser the leaderboard form visible
        LeaderboardForm leaderboardForm = new LeaderboardForm();
        leaderboardForm.addPlayer(player); // Assuming "player" is the Player object from QuizForm
        leaderboardForm.setVisible(true); // Set the leaderboard form visible
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelQ = new javax.swing.JPanel();
        jQuestion = new javax.swing.JLabel();
        jTimer = new javax.swing.JLabel();
        jRadioButton1_ = new javax.swing.JRadioButton();
        jRadioButton2_ = new javax.swing.JRadioButton();
        jRadioButton3_ = new javax.swing.JRadioButton();
        jNext_ = new javax.swing.JButton();
        jRadioButton4_ = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanelQ.setBackground(new java.awt.Color(204, 204, 204));

        jQuestion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jQuestion.setText("Question");
        jQuestion.setToolTipText("");

        jTimer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTimer.setForeground(java.awt.Color.red);
        jTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTimer.setText("00:00:00");

        javax.swing.GroupLayout jPanelQLayout = new javax.swing.GroupLayout(jPanelQ);
        jPanelQ.setLayout(jPanelQLayout);
        jPanelQLayout.setHorizontalGroup(
            jPanelQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTimer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelQLayout.setVerticalGroup(
            jPanelQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelQLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jRadioButton1_.setBackground(java.awt.SystemColor.controlHighlight);
        jRadioButton1_.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton1_.setText("jRadioButton1");
        jRadioButton1_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1_ActionPerformed(evt);
            }
        });

        jRadioButton2_.setBackground(java.awt.SystemColor.controlHighlight);
        jRadioButton2_.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton2_.setText("jRadioButton2");
        jRadioButton2_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2_ActionPerformed(evt);
            }
        });

        jRadioButton3_.setBackground(java.awt.SystemColor.controlHighlight);
        jRadioButton3_.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton3_.setText("jRadioButton3");
        jRadioButton3_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3_ActionPerformed(evt);
            }
        });

        jNext_.setBackground(java.awt.Color.gray);
        jNext_.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jNext_.setForeground(new java.awt.Color(255, 255, 255));
        jNext_.setText("Next");
        jNext_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNext_ActionPerformed(evt);
            }
        });

        jRadioButton4_.setBackground(java.awt.SystemColor.controlHighlight);
        jRadioButton4_.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton4_.setText("jRadioButton4");
        jRadioButton4_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jNext_, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelQ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButton1_, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton2_, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton3_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton4_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jRadioButton1_, jRadioButton2_, jRadioButton3_});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1_, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4_)
                .addGap(18, 18, 18)
                .addComponent(jNext_, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jRadioButton2_, jRadioButton3_});

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

    private void jNext_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNext_ActionPerformed
        // start the timer for the next question
        startTimer();
        
        // if the button is clicked, show the leaderboard
        if(jNext_.getText().equals("Check Leaderboard!"))
        {
            showLeaderboard();
            dispose();
        }
        
        // check if all questions have been answered
        if(index == questions.length)
        {           
            String scoreGreen = "Congrats, " + playerName + ". You got " + score + "/" + questions.length + "!" ;
            String scoreRed = "Oh no, " + playerName + ". You got " + score + "/" + questions.length + "!";
            
            // display the user score
            if(score >= (float) questions.length/2)
            {
                jPanelQ.setBackground(Color.green);
                jQuestion.setText(scoreGreen);
            }else{
                jPanelQ.setBackground(Color.red);
                jQuestion.setText(scoreRed);
            }
            
            jNext_.setText("Check Leaderboard!");
            // hide the timer
            jTimer.setVisible(false);
                                
        }
        
        // if there are more questions to display
        else{
            
            // enable the radio buttons
            enableRbuttons(true);
            
            // display the question and the options
            jQuestion.setText(questions[index]);
            jRadioButton1_.setText(options[index][0]);
            jRadioButton2_.setText(options[index][1]);
            jRadioButton3_.setText(options[index][2]);
            jRadioButton4_.setText(options[index][3]);
            
            // if its the last question, set the text button to "End Quiz"
            if(index == questions.length-1){
               jNext_.setText("End Quiz");
            }
        }
        
        // clear the selection
        bg.clearSelection();
    }//GEN-LAST:event_jNext_ActionPerformed

    private void jRadioButton1_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1_ActionPerformed
        getSelectedOption(jRadioButton1_);
    }//GEN-LAST:event_jRadioButton1_ActionPerformed

    private void jRadioButton2_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2_ActionPerformed
        getSelectedOption(jRadioButton2_);
    }//GEN-LAST:event_jRadioButton2_ActionPerformed
    
    private void jRadioButton3_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3_ActionPerformed
        getSelectedOption(jRadioButton3_);
    }//GEN-LAST:event_jRadioButton3_ActionPerformed

    private void jRadioButton4_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4_ActionPerformed
        getSelectedOption(jRadioButton4_);
    }//GEN-LAST:event_jRadioButton4_ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jNext_;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelQ;
    private javax.swing.JLabel jQuestion;
    private javax.swing.JRadioButton jRadioButton1_;
    private javax.swing.JRadioButton jRadioButton2_;
    private javax.swing.JRadioButton jRadioButton3_;
    private javax.swing.JRadioButton jRadioButton4_;
    private javax.swing.JLabel jTimer;
    // End of variables declaration//GEN-END:variables
}

