package gui;

import static gui.viewGame.shuffleArray;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;

public class viewGameMCQ extends javax.swing.JFrame {

    int score=0;
    String gamename="";
    String gamecat="";
    String desc = "";
    ArrayList<Question> questions ;
    ArrayList<String> results = new ArrayList<String>();
    String type=""; 
    int idx = 0;
    String uname = "";
    String upass = "";
    
    viewGameMCQ(String u , String p , String c , String a , String b , String t) throws IOException{
        gamename=a;
        gamecat=b;
        desc = c;
        type = t;
        uname = u;
        upass = p;
        
        initComponents();
        groupButton();
        init();
    }
    

    public void init() throws FileNotFoundException, IOException{
        setLocation(450 ,100);
        setVisible(true);
        jLabel2.setText(gamename);
        jLabel1.setText(desc);
        //
        Game g = new Game();  
        g.gamename=gamename;
        Server s2 = new Server();
        s2.gameobject=g;
        String desc = s2.getGameDisc();
        System2 s = new System2(s2);
        questions = s.playGame();
    
        //
        ArrayList <String> ans = shuffleArray(questions.get(0).results);

        jLabel3.setText(questions.get(0).question);
        jRadioButton1.setText(ans.get(0));
        jRadioButton2.setText(ans.get(1));
        jRadioButton3.setText(ans.get(2));
        jRadioButton4.setText(ans.get(3));
        
    }
    static ArrayList<String> shuffleArray(ArrayList<String> ar)
    {
        ArrayList <String>ar2 = (ArrayList <String>) ar.clone();
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar2.size() - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = ar2.get(index);
            ar2.set(index, ar2.get(i));
            ar2.set(i, a);
        }
        return ar2;
    }
    private void groupButton(){
        ButtonGroup group = new ButtonGroup();
        group.add(jRadioButton1);
        group.add(jRadioButton2);
        group.add(jRadioButton3);
        group.add(jRadioButton4);
    }
    public viewGameMCQ() throws IOException {
        initComponents();
        groupButton();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 20, -1, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 63, 337, 43));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 63, 139, 43));

        jButton3.setText("nextQ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 12, -1, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 155, 246, 46));
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));
        getContentPane().add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, -1));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 22, -1, -1));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 0, 91, 37));

        jButton5.setText("Show Comments");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 358, -1, -1));

        jButton4.setText("Add Comment");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 358, -1, -1));

        jButton2.setText("Add Rate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 358, -1, -1));

        jPanel1.setBackground(new java.awt.Color(206, 197, 248));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText("Click on Show Comments");
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton4)
                .addGap(274, 274, 274))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addComponent(jRadioButton4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new playGame(uname , upass , type);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed


        
    if (idx == questions.size()-1){
      if(jRadioButton1.isSelected() || jRadioButton2.isSelected() || jRadioButton3.isSelected() || jRadioButton4.isSelected()){
            if(jRadioButton1.isSelected()){
                
                
            if(jRadioButton1.getText().equals(questions.get(idx).results.get(0))){
               score+= 10; 
            }
            
            }else if(jRadioButton2.isSelected()){
               
            if(jRadioButton2.getText().equals(questions.get(idx).results.get(0))){
               score+= 10; 
            }
            
            }
            else if(jRadioButton3.isSelected()){
               
            if(jRadioButton3.getText().equals(questions.get(idx).results.get(0))){
               score+= 10; 
            }
            
            }else{
               
            if(jRadioButton4.getText().equals(questions.get(idx).results.get(0))){
               score+= 10; 
            }
            
            }
        
          try {
              Score sc = new Score(score , type,gamename,uname);
              this.dispose();
          } catch (IOException ex) {
              Logger.getLogger(viewGameMCQ.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        
      }  
     }else{
        if(jRadioButton1.isSelected() || jRadioButton2.isSelected() || jRadioButton3.isSelected() || jRadioButton4.isSelected()){
            if(jRadioButton1.isSelected()){
                
                
            if(jRadioButton1.getText().equals(questions.get(idx).results.get(0))){
               score+= 10; 
            }
            
            }else if(jRadioButton2.isSelected()){
               
            if(jRadioButton2.getText().equals(questions.get(idx).results.get(0))){
               score+= 10; 
            }
            
            }
            else if(jRadioButton3.isSelected()){
               
            if(jRadioButton3.getText().equals(questions.get(idx).results.get(0))){
               score+= 10; 
            }
            
            }else{
               
            if(jRadioButton4.getText().equals(questions.get(idx).results.get(0))){
               score+= 10; 
            }
            
            }
        }
            idx = idx+1;

            ArrayList <String> ans = shuffleArray(questions.get(idx).results);

            jLabel3.setText(questions.get(idx).question);
            jRadioButton1.setText(ans.get(0));
            jRadioButton2.setText(ans.get(1));
            jRadioButton1.setText(ans.get(2));
            jRadioButton2.setText(ans.get(3));
        
    } 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Game g=new Game();
        g.gamename=gamename;
        g.category=gamecat;
        g.description=desc;
        Server st=new Server(g);
        ArrayList<Comments>arr=null;
        try {
            arr = st.commOnGame();
        } catch (IOException ex) {
            Logger.getLogger(viewGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> record=new ArrayList<String>();
        String temp="";

        if(arr==null){
            jTextArea1.setText("");
        }
        else{
            for(int i=0;i<arr.size();i++){
                try {
                    if(st.getRate(arr.get(i).sname).equals("")){
                        if(st.isTeacher(arr.get(i).sname)==true){
                            temp=arr.get(i).sname+"* :"+ "\n"+arr.get(i).comment;
                        }
                        else{
                        temp=arr.get(i).sname+" :"+ "\n"+arr.get(i).comment;
                        }
                        record.add(temp);
                    
                    }
                    else{
                        try {
                            if(st.isTeacher(arr.get(i).sname)==true){
                            temp=arr.get(i).sname+"* :"+"  "+ st.getRate(arr.get(i).sname) +"\n"+arr.get(i).comment;
                            }
                            else{
                             temp=arr.get(i).sname+" :"+"  "+ st.getRate(arr.get(i).sname) +"\n"+arr.get(i).comment;
                            }
                             record.add(temp);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(viewGame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(viewGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            jTextArea1.setBackground(Color.white);
            jTextArea1.setForeground(Color.black);
            jTextArea1.setText("");
            jTextArea1.setEditable(false);
            for(int i=0;i<record.size();i++){
                jTextArea1.append(record.get(i));
                jTextArea1.append("\n");
                jTextArea1.append("----------------------------------------------");
                jTextArea1.append("\n");
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Game g=new Game();
        g.gamename=gamename;
        g.category=gamecat;
        g.description=desc;
        Server s1=new Server(g);
        try {
            s1.addRate(uname, jSpinner1.getValue().toString());
        } catch (IOException ex) {
            Logger.getLogger(viewGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Game g=new Game();
        g.gamename=gamename;
        g.category=gamecat;
        g.description=desc;
        Comments cr=new Comments();
        cr.gname=gamename;
        cr.sname=uname;
        cr.comment=jTextField2.getText();
        String temp="";
        Server s1=new Server(g);
        try {
            s1.addcomment(cr);
        } catch (IOException ex) {
            Logger.getLogger(viewGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(s1.getRate(uname).equals("")){
                temp=uname+" :"+ "\n"+jTextField2.getText();

            }
            else{

                try {
                    temp=uname+" :"+"  "+ s1.getRate(uname) +"\n"+jTextField2.getText();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(viewGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(viewGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextArea1.append(temp);
        jTextArea1.append("\n");
        jTextArea1.append("----------------------------------------");
        jTextArea1.append("\n");
    }//GEN-LAST:event_jButton4ActionPerformed
    
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
            java.util.logging.Logger.getLogger(viewGameMCQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewGameMCQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewGameMCQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewGameMCQ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new viewGameMCQ().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(viewGameMCQ.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
