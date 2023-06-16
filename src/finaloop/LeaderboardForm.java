package finaloop;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class LeaderboardForm extends javax.swing.JFrame implements BackMenu {
    
    @Override
    public void showMenu(){
        // display MenuForm
        MenuForm menuForm = new MenuForm();
        menuForm.setVisible(true);
        
        dispose();
    }
    
    // define instance variables
    private DefaultTableModel tm;
    private String leaderboardFile = "leaderboard";
    private TableRowSorter<TableModel> sorter;
    private ArrayList<ArrayList<Object>> playersData;
    
    public LeaderboardForm() {
        initComponents();
        initTableData();
        initTableSorter();
    }
    
    // initializes the table data by reading it from a file
    private void initTableData(){
        // connect the DefaultTableModel with the jleaderboard table
        tm = (DefaultTableModel) jLeaderboard.getModel();
        // create an ArrayList to store the player data
        playersData = new ArrayList<>();
        
        try{
            // read the player data from the leaderboardFile
            FileInputStream fs = new FileInputStream(leaderboardFile);       
            ObjectInputStream os = new ObjectInputStream(fs);        
            playersData = (ArrayList<ArrayList<Object>>) os.readObject();
            
            os.close();
            fs.close();
        }
        catch(IOException | ClassNotFoundException e){}
        
        // add the data from playersData to the DefaultTableModel
        for (ArrayList<Object> rowData : playersData) {
            tm.addRow(rowData.toArray());
        }
    }
    
    // initializes the table sorter to allow sorting based on the column
    private void initTableSorter(){
        // create a TableRowSorter using the DefaultTableModel
        sorter = new TableRowSorter<>(tm);
        // set the sorter for the jleaderboard table
        jLeaderboard.setRowSorter(sorter);
        
        // create an ArrayList to specify the sorting order
        ArrayList<SortKey> keys = new ArrayList<>();
        // add a Sortkey for the second column (score) in descending order
        keys.add(new SortKey(1, SortOrder.DESCENDING));
        
        // set the sort keys for the sorter
        sorter.setSortKeys(keys);
    }
    
    // saves the leaderboard data to a txt
    private void saveLeaderboard(){
        try{
            // write the playerData to the leaderboardFile
            FileOutputStream fs = new FileOutputStream(leaderboardFile);
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject(playersData);

            os.close();
            fs.close();
        }catch(IOException e){}

    }  
    
    // adds a player to the leaderboard by updating the table and saving the data
    public void addPlayer(Player player) {
        // get the player name and score
        String playerName = player.getPlayerName();
        int score = player.getScore();
        
        // create a new row of data for the player
        ArrayList<Object> rowData = new ArrayList<>();
        rowData.add(playerName);
        rowData.add(score);
        
        // add the row to the DefaultTableModel and playersData
        tm.addRow(rowData.toArray());
        playersData.add(rowData);
        
        // sort the table based on the sort keys
        sorter.sort();
        // save the updated leaderboard data
        saveLeaderboard();
        // make the LeaderboardForm visible
        this.setVisible(true);
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenu_ = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLeaderboard = new javax.swing.JTable();
        jReset_ = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu_.setText("Back");
        jMenu_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LEADERBOARD");

        jLeaderboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Player", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jLeaderboard);

        jReset_.setText("Reset");
        jReset_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jReset_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jReset_, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jMenu_)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jMenu_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jReset_)
                .addContainerGap(15, Short.MAX_VALUE))
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

    private void jMenu_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_ActionPerformed
        // call the showMenu method to display the MenuForm
        showMenu();
    }//GEN-LAST:event_jMenu_ActionPerformed

    private void jReset_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jReset_ActionPerformed
        // clear hte table and playersData
        tm.setRowCount(0);
        playersData.clear();
        
        // save the empty leaderboard
        saveLeaderboard();
    }//GEN-LAST:event_jReset_ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable jLeaderboard;
    private javax.swing.JButton jMenu_;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jReset_;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}