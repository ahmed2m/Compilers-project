/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import compiler.Char_array_util;
import java.io.File;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultStyledDocument;
import compiler.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 *
 * @author omarf
 */
public class Frame extends javax.swing.JFrame {

    /**
     * Creates new form Frame
     */
    DefaultStyledDocument document = new DefaultStyledDocument();
    Char_array_util CharHelper = new Char_array_util();
    compiler.Compiler comp = new compiler.Compiler();
    int currentIndexOfSpace = 0;
    int currentCaret = 0;
    DefaultListModel listModel;
    int ErrorCount = 0;


    public Frame() {

        initComponents();
        code.setDocument(document);
        code.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        code.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                codeCaretUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(code);
        TextLineNumber tln = new TextLineNumber(code);
        jScrollPane1.setRowHeaderView( tln );
        listModel = new DefaultListModel();
        autoc = new JList(listModel);


//        ArrayList<String> words = new ArrayList<>();
//        words.add("Law");
//        words.add("Else");
//        words.add("Iow");
//        words.add("SIow");
//        words.add("Chlo");
//        words.add("Chain");
//        words.add("Iowf");
//        words.add("SIowf");
//        words.add("Worthless");
//        words.add("Loopwhen");
//        words.add("Iteratewhen");
//        words.add("Turnback");
//        words.add("Stop");
//        words.add("Loli");
//        words.add("Include");
//        Point f = this.getLocation();
//        AutoComplete autoSuggestor = new AutoComplete(
//                code, this, words, Color.WHITE.brighter(), Color.BLUE, Color.RED,f.x,f.y) {
//                @Override
//                boolean wordTyped(String typedWord) {
//                    System.out.println(typedWord);
//                    return super.wordTyped(typedWord);//checks for a match in dictionary and returns true or false if found or not
//                }
//        };
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        code = new GUI.XmlTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        autoc = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        console = new javax.swing.JTextPane();
        ScanButton = new javax.swing.JButton();
        ParseButton = new javax.swing.JButton();
        BrowseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 131, 226));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Compiler Project");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        code.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                codeCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codeKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(code);

        autoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                autocKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(autoc);

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        console.setEditable(false);
        console.setBackground(java.awt.Color.black);
        console.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        console.setForeground(java.awt.Color.white);
        jScrollPane2.setViewportView(console);

        ScanButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ScanButton.setText("Scanning");
        ScanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScanButtonActionPerformed(evt);
            }
        });

        ParseButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ParseButton.setText("Parsing");
        ParseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParseButtonActionPerformed(evt);
            }
        });

        BrowseButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BrowseButton.setText("Browse");
        BrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ParseButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ScanButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BrowseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(785, 785, 785)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(254, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(ScanButton)
                .addGap(64, 64, 64)
                .addComponent(ParseButton)
                .addGap(59, 59, 59)
                .addComponent(BrowseButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(284, 284, 284)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(171, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Compiler Scanner
    
    //Compiler_scanner scan= new Compiler_scanner();
    
    
    private void ParseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParseButtonActionPerformed
        // TODO add your handling code here:

        String codetext=code.getText();     //get code from GUI
        int len= codetext.length();         // know the lenght of the string 
                                            //to intialize the char array
        
        char[] codeChar= new char[len];     // intialize array of char
        int i = 0;
        for(char c: codetext.toCharArray()){
            codeChar[i]=c;                  //assign the string to the char array
            i++;
        }
        //String str_token = scanner.scan_code(codeChar);     //pass the char array to the scan_code function
        
        //console.setText(str_token);

    }//GEN-LAST:event_ParseButtonActionPerformed


    
    
    
    
    private void BrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseButtonActionPerformed
        // TODO add your handling code here:
        console.setEditable(true);
        console.setText("");
        console.setEditable(false);
        JFileChooser fileChooser = new JFileChooser();
        FileManger file =new FileManger();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            char[] patha = path.toCharArray();
            char[] code = file.readfromText(patha);
            comp.PreprocessAndScan(code,this);
        }
    }//GEN-LAST:event_BrowseButtonActionPerformed

    private void ScanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScanButtonActionPerformed
        // TODO add your handling code here:
        ErrorCount = 0;
        console.setEditable(true);
        console.setText("");
        console.setEditable(false);
        char[] ourcode = code.getText().toCharArray();
        comp.PreprocessAndScan(ourcode,this);
    }//GEN-LAST:event_ScanButtonActionPerformed

    private void codeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_codeCaretUpdate
        // TODO add your handling code here:
        int i;
        i=code.getText().split("\n").length;
        System.out.println("LINEE");

    }//GEN-LAST:event_codeCaretUpdate

    private void codeCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_codeCaretPositionChanged
        // TODO add your handling code here:
                

    }//GEN-LAST:event_codeCaretPositionChanged
    
    public String getCurrentlyTypedWord() {//get newest word after last white spaceif any or the first word if no white spaces
        String text = code.getText();
        String wordBeingTyped = "";
        if (text.contains(" ")) {
            int tmp = text.lastIndexOf(" ");
            if (tmp >= currentIndexOfSpace) {
                currentIndexOfSpace = tmp;
                wordBeingTyped = text.substring(text.lastIndexOf(" "));
            }
        } else {
            wordBeingTyped = text;
        }
        return wordBeingTyped.trim();
    }
    
    private void replaceWithSuggestedText(String suggestedWord,String typedWord) {
        System.out.println(suggestedWord + typedWord);
            String text = code.getText();
            String t = text.substring(0, text.lastIndexOf(typedWord));
            String tmp = t + text.substring(text.lastIndexOf(typedWord)).replace(typedWord, suggestedWord);
            code.setText(tmp + " ");
        }
    
    private void codeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_DOWN){
            evt.consume();
            autoc.requestFocus(); 
            autoc.setSelectedIndex(0);
            currentCaret = code.getCaretPosition();
        }
//        autoc.add
//        listModel.addElement("Law");
//        listModel.addElement("Else");
//        listModel.addElement("Iow");
//        listModel.addElement("SIow");
//        listModel.addElement("Chlo");
//        listModel.addElement("Chain");
//        listModel.addElement("Iowf");
//        listModel.addElement("SIowf");
//        listModel.addElement("Worthless");
//        listModel.addElement("Loopwhen");
//        listModel.addElement("Iteratewhen");
//        listModel.addElement("Turnback");
//        listModel.addElement("Stop");
//        words.add("Loli");
//        words.add("Include");
    }//GEN-LAST:event_codeKeyPressed

    private void autocKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_autocKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            evt.consume();
            code.requestFocus();
            code.setCaretPosition(this.currentCaret);
        }else if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String suggest = autoc.getSelectedValue().toString() ;
            String toReplace = getCurrentlyTypedWord();
            replaceWithSuggestedText(suggest,toReplace);
            evt.consume();
            code.requestFocus();
//            code.setCaretPosition(this.currentCaret);
        }
    }//GEN-LAST:event_autocKeyPressed
    

    public  void PrintInLog(Object x){
        StyledDocument doc = console.getStyledDocument();

        //  Define a keyword attribute
        String string = " ";
        if(x instanceof char[]){
            char[] xs=(char[])x;
            string = new String(xs);
        }else{
            string = String.valueOf(x);
        }
            
        SimpleAttributeSet ErrorWord = new SimpleAttributeSet();
        SimpleAttributeSet NormalWord = new SimpleAttributeSet();
        SimpleAttributeSet TemplateWord = new SimpleAttributeSet();
        SimpleAttributeSet CountWord = new SimpleAttributeSet();
        

        StyleConstants.setForeground(ErrorWord, Color.WHITE);
        StyleConstants.setBackground(ErrorWord, Color.RED);
        
        StyleConstants.setForeground(CountWord, Color.RED);
        StyleConstants.setBackground(CountWord, Color.WHITE);
        
        StyleConstants.setForeground(NormalWord, Color.YELLOW);
        StyleConstants.setForeground(TemplateWord, Color.WHITE);
        
        StyleConstants.setBold(ErrorWord, true);
        try {
            if(string.contains("error")){
                ErrorCount++;
                doc.insertString(console.getCaretPosition(), string, ErrorWord);
            }else if(string.contains("count")){
                String string1 ="Total NO of errors:" + ErrorCount ;
                doc.insertString(console.getCaretPosition(), string1, CountWord);     
            }else if(string.contains("Line")||string.contains("Token Text")||string.contains("Token Type")){
                doc.insertString(console.getCaretPosition(), string, TemplateWord);                
            }else{
                doc.insertString(console.getCaretPosition(), string, NormalWord);
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.println(string);
//        System.out.println(code.getText());


    }
    /**
     * @param args the command line arguments
     */
    public static void maidn(String args[]) {
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
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Frame().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BrowseButton;
    private javax.swing.JButton ParseButton;
    private javax.swing.JButton ScanButton;
    private javax.swing.JList autoc;
    private GUI.XmlTextPane code;
    private javax.swing.JTextPane console;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
