/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.paperrecommender.view.gui;

import javax.swing.JFileChooser;
import uit.tkorg.paperrecommender.controller.central.PaperRecommender;

/**
 *
 * @author THNghiep
 */
public class PaperRecommenderGUI extends javax.swing.JFrame {
    
    // Controller handles all request from gui:
    private PaperRecommender paperRecommender;
    
    private String[] response;

    /**
     * Creates new form PaperRecommenderGUI
     */
    public PaperRecommenderGUI() {
        initComponents();
        paperRecommender = new PaperRecommender();
        jTextFieldStatus.setText("Ready.");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonReadPaper = new javax.swing.JButton();
        jButtonSavePaper = new javax.swing.JButton();
        jButtonLoadPaper = new javax.swing.JButton();
        jButtonReadAuthor = new javax.swing.JButton();
        jButtonSaveAuthor = new javax.swing.JButton();
        jButtonLoadAuthor = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonComputePaperFVLinear = new javax.swing.JButton();
        jButtonComputePaperFVCosine = new javax.swing.JButton();
        jButtonComputePaperFVRPY = new javax.swing.JButton();
        jButtonComputeAuthorFVLinear = new javax.swing.JButton();
        jButtonComputeAuthorFVCosine = new javax.swing.JButton();
        jButtonComputeAuthorFVRPY = new javax.swing.JButton();
        jButtonRecommendAllAuthor = new javax.swing.JButton();
        jButtonComputeNDCG5 = new javax.swing.JButton();
        jButtonComputeNDCG10 = new javax.swing.JButton();
        jButtonComputeMRR = new javax.swing.JButton();
        jTextFieldNDCG5 = new javax.swing.JTextField();
        jTextFieldNDCG10 = new javax.swing.JTextField();
        jTextFieldMRR = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldDataset = new javax.swing.JTextField();
        jTextFieldSaveData = new javax.swing.JTextField();
        jButtonDatasetFolder = new javax.swing.JButton();
        jButtonSaveDataFolder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paper Recommender");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Import"));

        jLabel1.setText("Papers:");

        jLabel2.setText("Authors:");

        jButtonReadPaper.setText("Read from DS1");
        jButtonReadPaper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReadPaperActionPerformed(evt);
            }
        });

        jButtonSavePaper.setText("Save");
        jButtonSavePaper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSavePaperActionPerformed(evt);
            }
        });

        jButtonLoadPaper.setText("Load");
        jButtonLoadPaper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadPaperActionPerformed(evt);
            }
        });

        jButtonReadAuthor.setText("Read from DS1");
        jButtonReadAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReadAuthorActionPerformed(evt);
            }
        });

        jButtonSaveAuthor.setText("Save");
        jButtonSaveAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveAuthorActionPerformed(evt);
            }
        });

        jButtonLoadAuthor.setText("Load");
        jButtonLoadAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadAuthorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(jButtonReadPaper))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonReadAuthor)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonSavePaper)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLoadPaper))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonSaveAuthor)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLoadAuthor)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonReadPaper)
                    .addComponent(jButtonSavePaper)
                    .addComponent(jButtonLoadPaper))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButtonReadAuthor)
                    .addComponent(jButtonSaveAuthor)
                    .addComponent(jButtonLoadAuthor)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Preparation"));

        jLabel3.setText("Paper Feature Vector:");

        jLabel4.setText("Author Feature Vector:");

        jButtonComputePaperFVLinear.setText("Linear");
        jButtonComputePaperFVLinear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComputePaperFVLinearActionPerformed(evt);
            }
        });

        jButtonComputePaperFVCosine.setText("Cosine");
        jButtonComputePaperFVCosine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComputePaperFVCosineActionPerformed(evt);
            }
        });

        jButtonComputePaperFVRPY.setText("RPY");
        jButtonComputePaperFVRPY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComputePaperFVRPYActionPerformed(evt);
            }
        });

        jButtonComputeAuthorFVLinear.setText("Linear");
        jButtonComputeAuthorFVLinear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComputeAuthorFVLinearActionPerformed(evt);
            }
        });

        jButtonComputeAuthorFVCosine.setText("Cosine");
        jButtonComputeAuthorFVCosine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComputeAuthorFVCosineActionPerformed(evt);
            }
        });

        jButtonComputeAuthorFVRPY.setText("RPY");
        jButtonComputeAuthorFVRPY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComputeAuthorFVRPYActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonComputePaperFVLinear, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(jButtonComputeAuthorFVLinear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonComputeAuthorFVCosine)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonComputeAuthorFVRPY, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonComputePaperFVCosine, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonComputePaperFVRPY, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonComputeAuthorFVCosine, jButtonComputeAuthorFVRPY, jButtonComputePaperFVCosine, jButtonComputePaperFVLinear, jButtonComputePaperFVRPY});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButtonComputePaperFVLinear)
                    .addComponent(jButtonComputePaperFVCosine)
                    .addComponent(jButtonComputePaperFVRPY))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButtonComputeAuthorFVLinear)
                    .addComponent(jButtonComputeAuthorFVCosine)
                    .addComponent(jButtonComputeAuthorFVRPY))
                .addGap(4, 4, 4))
        );

        jButtonRecommendAllAuthor.setText("Recommend");
        jButtonRecommendAllAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecommendAllAuthorActionPerformed(evt);
            }
        });

        jButtonComputeNDCG5.setText("NDCG@5");
        jButtonComputeNDCG5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComputeNDCG5ActionPerformed(evt);
            }
        });

        jButtonComputeNDCG10.setText("NDCG@10");
        jButtonComputeNDCG10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComputeNDCG10ActionPerformed(evt);
            }
        });

        jButtonComputeMRR.setText("MRR");
        jButtonComputeMRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComputeMRRActionPerformed(evt);
            }
        });

        jLabel5.setText("Status:");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuration"));

        jLabel8.setText("Dateset Folder:");

        jLabel9.setText("Save Data Folder:");

        jButtonDatasetFolder.setText("Browse");
        jButtonDatasetFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDatasetFolderActionPerformed(evt);
            }
        });

        jButtonSaveDataFolder.setText("Browse");
        jButtonSaveDataFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveDataFolderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldSaveData)
                    .addComponent(jTextFieldDataset, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSaveDataFolder)
                    .addComponent(jButtonDatasetFolder))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldDataset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDatasetFolder))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldSaveData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSaveDataFolder)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonComputeMRR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonComputeNDCG5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonComputeNDCG10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNDCG5)
                            .addComponent(jTextFieldNDCG10)
                            .addComponent(jTextFieldMRR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldStatus))
                        .addComponent(jButtonRecommendAllAuthor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonRecommendAllAuthor)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonComputeNDCG5)
                    .addComponent(jTextFieldNDCG5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonComputeNDCG10)
                    .addComponent(jTextFieldNDCG10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonComputeMRR)
                    .addComponent(jTextFieldMRR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Data Import");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReadPaperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReadPaperActionPerformed
        // TODO add your handling code here:
        jTextFieldStatus.setText("Reading papers... ");
        response = paperRecommender.centralController("Read paper", jTextFieldDataset.getText());
        jTextFieldStatus.setText(jTextFieldStatus.getText() + response[0]);
    }//GEN-LAST:event_jButtonReadPaperActionPerformed

    private void jButtonSavePaperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSavePaperActionPerformed
        // TODO add your handling code here:
        jTextFieldStatus.setText("Saving papers... ");
        response = paperRecommender.centralController("Save paper", jTextFieldSaveData.getText());
        jTextFieldStatus.setText(jTextFieldStatus.getText() + response[0]);
    }//GEN-LAST:event_jButtonSavePaperActionPerformed

    private void jButtonComputePaperFVLinearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComputePaperFVLinearActionPerformed
        // TODO add your handling code here:
        jTextFieldStatus.setText("Computing paper feature vector with linear weight... ");
        response = paperRecommender.centralController("Paper FV linear", null);
        jTextFieldStatus.setText(jTextFieldStatus.getText() + response[0]);
    }//GEN-LAST:event_jButtonComputePaperFVLinearActionPerformed

    private void jButtonComputePaperFVCosineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComputePaperFVCosineActionPerformed
        // TODO add your handling code here:
        jTextFieldStatus.setText("Computing paper feature vector with cosine weight... ");
        response = paperRecommender.centralController("Paper FV cosine", null);
        jTextFieldStatus.setText(jTextFieldStatus.getText() + response[0]);
    }//GEN-LAST:event_jButtonComputePaperFVCosineActionPerformed

    private void jButtonRecommendAllAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecommendAllAuthorActionPerformed
        // TODO add your handling code here:
        jTextFieldStatus.setText("Generating recommendation list for all authors... ");
        response = paperRecommender.centralController("Recommend", null);
        jTextFieldStatus.setText(jTextFieldStatus.getText() + response[0]);
    }//GEN-LAST:event_jButtonRecommendAllAuthorActionPerformed

    private void jButtonComputeNDCG5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComputeNDCG5ActionPerformed
        // TODO add your handling code here:
        jTextFieldStatus.setText("Computing NDCG@5... ");
        response = paperRecommender.centralController("NDCG5", null);
        jTextFieldNDCG5.setText(response[1]);
        jTextFieldStatus.setText(jTextFieldStatus.getText() + response[0]);
    }//GEN-LAST:event_jButtonComputeNDCG5ActionPerformed

    private void jButtonLoadPaperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadPaperActionPerformed
        // TODO add your handling code here:
        jTextFieldStatus.setText("Loading papers... ");
        response = paperRecommender.centralController("Load paper", jTextFieldSaveData.getText());
        jTextFieldStatus.setText(jTextFieldStatus.getText() + response[0]);
    }//GEN-LAST:event_jButtonLoadPaperActionPerformed

    private void jButtonReadAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReadAuthorActionPerformed
        // TODO add your handling code here:
        jTextFieldStatus.setText("Reading authors... ");
        response = paperRecommender.centralController("Read author", jTextFieldDataset.getText());
        jTextFieldStatus.setText(jTextFieldStatus.getText() + response[0]);
    }//GEN-LAST:event_jButtonReadAuthorActionPerformed

    private void jButtonSaveAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveAuthorActionPerformed
        // TODO add your handling code here:
        jTextFieldStatus.setText("Saving authors... ");
        response = paperRecommender.centralController("Save author", jTextFieldSaveData.getText());
        jTextFieldStatus.setText(jTextFieldStatus.getText() + response[0]);
    }//GEN-LAST:event_jButtonSaveAuthorActionPerformed

    private void jButtonLoadAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadAuthorActionPerformed
        // TODO add your handling code here:
        jTextFieldStatus.setText("Loading authors... ");
        response = paperRecommender.centralController("Load author", jTextFieldSaveData.getText());
        jTextFieldStatus.setText(jTextFieldStatus.getText() + response[0]);
    }//GEN-LAST:event_jButtonLoadAuthorActionPerformed

    private void jButtonComputePaperFVRPYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComputePaperFVRPYActionPerformed
        // TODO add your handling code here:
        jTextFieldStatus.setText("Computing paper feature vector with RPY weight... ");
        response = paperRecommender.centralController("Paper FV RPY", null);
        jTextFieldStatus.setText(jTextFieldStatus.getText() + response[0]);
    }//GEN-LAST:event_jButtonComputePaperFVRPYActionPerformed

    private void jButtonComputeAuthorFVLinearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComputeAuthorFVLinearActionPerformed
        // TODO add your handling code here:
        jTextFieldStatus.setText("Computing author feature vector with linear weight... ");
        response = paperRecommender.centralController("Author FV linear", null);
        jTextFieldStatus.setText(jTextFieldStatus.getText() + response[0]);
    }//GEN-LAST:event_jButtonComputeAuthorFVLinearActionPerformed

    private void jButtonComputeAuthorFVCosineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComputeAuthorFVCosineActionPerformed
        // TODO add your handling code here:
        jTextFieldStatus.setText("Computing author feature vector with cosine weight... ");
        response = paperRecommender.centralController("Author FV cosine", null);
        jTextFieldStatus.setText(jTextFieldStatus.getText() + response[0]);
    }//GEN-LAST:event_jButtonComputeAuthorFVCosineActionPerformed

    private void jButtonComputeAuthorFVRPYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComputeAuthorFVRPYActionPerformed
        // TODO add your handling code here:
        jTextFieldStatus.setText("Computing author feature vector with RPY weight... ");
        response = paperRecommender.centralController("Author FV RPY", null);
        jTextFieldStatus.setText(jTextFieldStatus.getText() + response[0]);
    }//GEN-LAST:event_jButtonComputeAuthorFVRPYActionPerformed

    private void jButtonComputeNDCG10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComputeNDCG10ActionPerformed
        // TODO add your handling code here:
        jTextFieldStatus.setText("Computing NDCG@10... ");
        response = paperRecommender.centralController("NDCG10", null);
        jTextFieldNDCG10.setText(response[1]);
        jTextFieldStatus.setText(jTextFieldStatus.getText() + response[0]);
    }//GEN-LAST:event_jButtonComputeNDCG10ActionPerformed

    private void jButtonComputeMRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComputeMRRActionPerformed
        // TODO add your handling code here:
        jTextFieldStatus.setText("Computing MRR... ");
        response = paperRecommender.centralController("MRR", null);
        jTextFieldMRR.setText(response[1]);
        jTextFieldStatus.setText(jTextFieldStatus.getText() + response[0]);
    }//GEN-LAST:event_jButtonComputeMRRActionPerformed

    private void jButtonDatasetFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDatasetFolderActionPerformed

        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.showOpenDialog(this);
        // Show open dialog; this method does not return until the dialog is closed
        jTextFieldDataset.setText(fc.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_jButtonDatasetFolderActionPerformed

    private void jButtonSaveDataFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveDataFolderActionPerformed

        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.showOpenDialog(this);
        // Show open dialog; this method does not return until the dialog is closed
        jTextFieldSaveData.setText(fc.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_jButtonSaveDataFolderActionPerformed

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
            java.util.logging.Logger.getLogger(PaperRecommenderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaperRecommenderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaperRecommenderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaperRecommenderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaperRecommenderGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonComputeAuthorFVCosine;
    private javax.swing.JButton jButtonComputeAuthorFVLinear;
    private javax.swing.JButton jButtonComputeAuthorFVRPY;
    private javax.swing.JButton jButtonComputeMRR;
    private javax.swing.JButton jButtonComputeNDCG10;
    private javax.swing.JButton jButtonComputeNDCG5;
    private javax.swing.JButton jButtonComputePaperFVCosine;
    private javax.swing.JButton jButtonComputePaperFVLinear;
    private javax.swing.JButton jButtonComputePaperFVRPY;
    private javax.swing.JButton jButtonDatasetFolder;
    private javax.swing.JButton jButtonLoadAuthor;
    private javax.swing.JButton jButtonLoadPaper;
    private javax.swing.JButton jButtonReadAuthor;
    private javax.swing.JButton jButtonReadPaper;
    private javax.swing.JButton jButtonRecommendAllAuthor;
    private javax.swing.JButton jButtonSaveAuthor;
    private javax.swing.JButton jButtonSaveDataFolder;
    private javax.swing.JButton jButtonSavePaper;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextFieldDataset;
    private javax.swing.JTextField jTextFieldMRR;
    private javax.swing.JTextField jTextFieldNDCG10;
    private javax.swing.JTextField jTextFieldNDCG5;
    private javax.swing.JTextField jTextFieldSaveData;
    private javax.swing.JTextField jTextFieldStatus;
    // End of variables declaration//GEN-END:variables
}
