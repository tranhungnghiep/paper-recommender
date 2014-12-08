/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.pr.gui;

import java.awt.event.KeyEvent;
import uit.tkorg.utility.general.NumericUtility;

/**
 *
 * @author Vinh
 */
public class DialogConfigTrustBased extends javax.swing.JDialog {

    /**
     * Creates new form dialogConfigTrustBased
     */
    int combinationScheme = 0;
    float alpha = 0f;
    int howToTrustAuthor = 1;
    int howToTrustPaper = 1;

    public DialogConfigTrustBased(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combineScheme_jTextField = new javax.swing.JTextField();
        alpha_jTextField = new javax.swing.JTextField();
        howToTrustAuthor_jTextField = new javax.swing.JTextField();
        howToTrustPaper_jTextField = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        CMAuthorTextPane = new javax.swing.JTextPane();
        ok_Button = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("combinationScheme");

        jLabel2.setText("alpha");

        jLabel3.setText("howToTrustAuthor");

        jLabel4.setText("howToTrustPaper");

        combineScheme_jTextField.setText("1");
        combineScheme_jTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combineScheme_jTextFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                combineScheme_jTextFieldKeyTyped(evt);
            }
        });

        alpha_jTextField.setText("0.0");
        alpha_jTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                alpha_jTextFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                alpha_jTextFieldKeyTyped(evt);
            }
        });

        howToTrustAuthor_jTextField.setText("1");
        howToTrustAuthor_jTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                howToTrustAuthor_jTextFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                howToTrustAuthor_jTextFieldKeyTyped(evt);
            }
        });

        howToTrustPaper_jTextField.setText("2");
        howToTrustPaper_jTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                howToTrustPaper_jTextFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                howToTrustPaper_jTextFieldKeyTyped(evt);
            }
        });

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder("Description Algorithm"));

        CMAuthorTextPane.setEditable(false);
        CMAuthorTextPane.setText("Trust based is a new proposed method. This method bases on the trust between an author and anothers authors. The trust is depended on citations of an author with other authors. If an author cites many papers of other author, it will prove that this author trust other author more. It is the assumption of this method. Beside that, the trust of coauthor affects the trust of the author. From the trust from authors, we infer to the trust of author and paper.\n*****Parameter of method*****\n1. combineScheme: 1: linear, 2: basedOnConfidence, 3: basedOnConfidence and linear.\n2. alpha is weighting of combineScheme.\n3. howToTrustAuthor is ways to author who trusts another author. howToTrustAuthor is from 1 to 3.\n4. howToTrustPaper: 1: average trusted author, 2: max trusted author.");
        jScrollPane6.setViewportView(CMAuthorTextPane);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        ok_Button.setText("OK");
        ok_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(howToTrustAuthor_jTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ok_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(15, 15, 15)
                        .addComponent(howToTrustPaper_jTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combineScheme_jTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                            .addComponent(alpha_jTextField))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combineScheme_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(alpha_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(howToTrustAuthor_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(howToTrustPaper_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(ok_Button)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ok_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ok_ButtonActionPerformed
        combinationScheme = Integer.parseInt(combineScheme_jTextField.getText());
        alpha = Float.parseFloat(alpha_jTextField.getText());
        howToTrustAuthor = Integer.parseInt(howToTrustAuthor_jTextField.getText());
        howToTrustPaper = Integer.parseInt(howToTrustPaper_jTextField.getText());
        this.hide();
    }//GEN-LAST:event_ok_ButtonActionPerformed

    private void combineScheme_jTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combineScheme_jTextFieldKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyCode() != KeyEvent.VK_BACK_SPACE
                && evt.getKeyCode() != KeyEvent.VK_ENTER) {
            evt.consume();
        }
    }//GEN-LAST:event_combineScheme_jTextFieldKeyTyped

    private void alpha_jTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alpha_jTextFieldKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyCode() != KeyEvent.VK_BACK_SPACE
                && evt.getKeyCode() != KeyEvent.VK_ENTER && evt.getKeyCode() != KeyEvent.VK_PERIOD) {
            evt.consume();
        }
    }//GEN-LAST:event_alpha_jTextFieldKeyTyped

    private void howToTrustAuthor_jTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_howToTrustAuthor_jTextFieldKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyCode() != KeyEvent.VK_BACK_SPACE
                && evt.getKeyCode() != KeyEvent.VK_ENTER) {
            evt.consume();
        }
    }//GEN-LAST:event_howToTrustAuthor_jTextFieldKeyTyped

    private void howToTrustPaper_jTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_howToTrustPaper_jTextFieldKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyCode() != KeyEvent.VK_BACK_SPACE
                && evt.getKeyCode() != KeyEvent.VK_ENTER) {
            evt.consume();
        }
    }//GEN-LAST:event_howToTrustPaper_jTextFieldKeyTyped

    private void combineScheme_jTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combineScheme_jTextFieldKeyReleased
        if (!NumericUtility.isNum(combineScheme_jTextField.getText())) {
            if(!"".equals(combineScheme_jTextField.getText())){
                combineScheme_jTextField.setText("1");
            }
        } else if (NumericUtility.isNum(combineScheme_jTextField.getText())) {
            double tmp = Double.parseDouble(combineScheme_jTextField.getText());
            if (tmp < 1 || tmp > 3) {
                combineScheme_jTextField.setText("1");
            }
        }
    }//GEN-LAST:event_combineScheme_jTextFieldKeyReleased

    private void alpha_jTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alpha_jTextFieldKeyReleased
        if (!NumericUtility.isNum(alpha_jTextField.getText())) {
            if(!"".equals(alpha_jTextField.getText())){
                alpha_jTextField.setText("0.0");
            }
        } else if (NumericUtility.isNum(alpha_jTextField.getText())) {
            double tmp = Double.parseDouble(alpha_jTextField.getText());
            if (tmp < 1 || tmp > 3) {
                alpha_jTextField.setText("0.0");
            }
        }
        
    }//GEN-LAST:event_alpha_jTextFieldKeyReleased

    private void howToTrustAuthor_jTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_howToTrustAuthor_jTextFieldKeyReleased
       if (!NumericUtility.isNum(howToTrustAuthor_jTextField.getText())) {
           if(!"".equals(howToTrustAuthor_jTextField.getText())){
                howToTrustAuthor_jTextField.setText("1");
           }
        } else if (NumericUtility.isNum(howToTrustAuthor_jTextField.getText())) {
            double tmp = Double.parseDouble(howToTrustAuthor_jTextField.getText());
            if (tmp < 1 || tmp > 3) {
                howToTrustAuthor_jTextField.setText("1");
            }
        }
    }//GEN-LAST:event_howToTrustAuthor_jTextFieldKeyReleased

    private void howToTrustPaper_jTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_howToTrustPaper_jTextFieldKeyReleased
        if (!NumericUtility.isNum(howToTrustPaper_jTextField.getText())) {
            if(!"".equals(alpha_jTextField.getText())){
                alpha_jTextField.setText("1");
            }
        } else if (NumericUtility.isNum(howToTrustPaper_jTextField.getText())) {
            double tmp = Double.parseDouble(howToTrustPaper_jTextField.getText());
            if (tmp < 1 || tmp > 2) {
                howToTrustPaper_jTextField.setText("1");
            }
        }
    }//GEN-LAST:event_howToTrustPaper_jTextFieldKeyReleased

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
            java.util.logging.Logger.getLogger(DialogConfigTrustBased.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogConfigTrustBased.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogConfigTrustBased.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogConfigTrustBased.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogConfigTrustBased dialog = new DialogConfigTrustBased(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane CMAuthorTextPane;
    private javax.swing.JTextField alpha_jTextField;
    private javax.swing.JTextField combineScheme_jTextField;
    private javax.swing.JTextField howToTrustAuthor_jTextField;
    private javax.swing.JTextField howToTrustPaper_jTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton ok_Button;
    // End of variables declaration//GEN-END:variables
}
