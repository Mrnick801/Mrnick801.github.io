package ca.qc.bdeb.baldr.ihm;

import ca.qc.bdeb.baldr.noyau.GestionnairePreferences;
import ca.qc.bdeb.baldr.noyau.Projet;
import ca.qc.bdeb.baldr.utils.Observation;
import ca.qc.bdeb.baldr.noyau.Task;
import ca.qc.bdeb.baldr.utils.Observateur;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.*;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 * Zone de texte éditable par l'utilisateur pour prendre des notes.
 *
 * @author 1344927
 */
public class JReport extends javax.swing.JPanel implements Observateur, Observer {

    private ResourceBundle messages;
    private GestionnaireI18N gestionnaireI18N;
    private GestionnairePreferences prefs;
    private WindowBaldr win;
    private double[] valLin;
    public Task analyse = null;
    private PanelTab parentTab;

    /**
     * Creates new form JReport
     */
    public JReport(PanelTab parentTab, Task analyse, GestionnaireI18N gestI18N, WindowBaldr win) {
        messages = ResourceBundle.getBundle("i18n/Baldr");
        this.win = win;
        this.analyse = analyse;
        this.analyse.ajouterObservateur(this);
        this.parentTab = parentTab;
        this.prefs = win.getPreferences();

        gestionnaireI18N = gestI18N;
        gestionnaireI18N.addObserver(this);
        initComponents();
        
        if (prefs.prefExists("COMMENTAIRES")) {
            checkBoxCommentaires.setSelected(
                    (Boolean) prefs.readPref("COMMENTAIRES", false));
        } else {
            checkBoxCommentaires.setSelected(true);
        }
        
        if (prefs.prefExists("PREVIEW")) {
            jCheckBoxPreviewFiles.setSelected(
                    (Boolean) prefs.readPref("PREVIEW", false));
        } else {
            jCheckBoxPreviewFiles.setSelected(true);
        }
        
        if (prefs.prefExists("CONCATENATION")) {
            jCheckBoxAnalyseConcatenation.setSelected(
                    (Boolean) prefs.readPref("CONCATENATION", false));
        }else {
            jCheckBoxAnalyseConcatenation.setSelected(true);
        }
        
        if (prefs.prefExists("WHITESPACES")) {
            checkBoxWhitepsaces.setSelected(
                    (Boolean) prefs.readPref("WHITESPACES", false));
        }else {
            checkBoxWhitepsaces.setSelected(true);
        }
        
        if (prefs.prefExists("EXTRACT_PDF")) {
            pdfExtractor.setSelected((Boolean) prefs.readPref("EXTRACT_PDF", false));
        } else {
            pdfExtractor.setSelected(true);
        }
        
        if (prefs.prefExists("EXTRACT_IMG")) {
            pdfImages.setSelected((Boolean) prefs.readPref("EXTRACT_IMG", false));
        } else {
            pdfImages.setSelected(true);
        }
        
        if (prefs.prefExists("PROGRESSIVE")) {
            if ((Boolean) prefs.readPref("PROGRESSIVE", false)) {
                if ((double) prefs.readPref("RED_VALUE", 0.0) != 0
                        || (double) prefs.readPref("YELLOW_VALUE", 0.0) != 0) {
                    jTextField1.setText(prefs.readPref("RED_VALUE"));
                    jTextField4.setText(prefs.readPref("YELLOW_VALUE"));
                    deactiverTextFiel();
                }
            } else {
                jRadioButton4.setSelected(true);
                
                activerTextFile();
                
                jTextField1.setText(prefs.readPref("RED_VALUE"));
                jTextField4.setText(prefs.readPref("YELLOW_VALUE"));
            }
            }
        
        
        
        // Placer les icônes du menu contextuel
        URL urlCopier = getClass().getResource("/Images/page_copy.png");
        URL urlColler = getClass().getResource("/Images/page_paste.png");
        URL urlCouper = getClass().getResource("/Images/cut_red.png");

        copier.setIcon(new javax.swing.ImageIcon(urlCopier));
        coller.setIcon(new javax.swing.ImageIcon(urlColler));
        couper.setIcon(new javax.swing.ImageIcon(urlCouper));
        
        
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("")); //pour enlever le "Panel_Title" qui est au mauvias endroit.
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(messages.getString("Panel_Title"))); //le "Panel_Title" doit aller ici.
        jLabel5.setText(messages.getString("Description_Analyses"));



    }

    public Task getAnalyse() {
        return analyse;
    }

    public void setAnalyse(Task tache) {
        analyse = tache;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        couper = new javax.swing.JMenuItem();
        copier = new javax.swing.JMenuItem();
        coller = new javax.swing.JMenuItem();
        selectAll = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jCheckBoxPreviewFiles = new javax.swing.JCheckBox();
        jCheckBoxAnalyseConcatenation = new javax.swing.JCheckBox();
        pdfExtractor = new javax.swing.JCheckBox();
        pdfImages = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        checkBoxCommentaires = new javax.swing.JCheckBox();
        checkBoxWhitepsaces = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        zoneTexte = new javax.swing.JTextPane();

        couper.setText(messages.getString("Cut"));
        couper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                couperActionPerformed(evt);
            }
        });
        jPopupMenu1.add(couper);

        copier.setText(messages.getString("Copy"));
        copier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copierActionPerformed(evt);
            }
        });
        jPopupMenu1.add(copier);

        coller.setText(messages.getString("Paste"));
        coller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collerActionPerformed(evt);
            }
        });
        jPopupMenu1.add(coller);

        selectAll.setText(messages.getString("Select_All"));
        selectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllActionPerformed(evt);
            }
        });
        jPopupMenu1.add(selectAll);

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jCheckBoxPreviewFiles.setSelected(true);
        jCheckBoxPreviewFiles.setText(messages.getString("Preview_files")); // NOI18N
        jCheckBoxPreviewFiles.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBoxPreviewFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPreviewFilesActionPerformed(evt);
            }
        });

        jCheckBoxAnalyseConcatenation.setSelected(true);
        jCheckBoxAnalyseConcatenation.setText(messages.getString("Analysis_concatenation")); // NOI18N
        jCheckBoxAnalyseConcatenation.setActionCommand("");
        jCheckBoxAnalyseConcatenation.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBoxAnalyseConcatenation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAnalyseConcatenationActionPerformed(evt);
            }
        });

        pdfExtractor.setText(messages.getString("extract_pdf"));
        pdfExtractor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pdfExtractor.setMaximumSize(new java.awt.Dimension(83, 15));
        pdfExtractor.setMinimumSize(new java.awt.Dimension(83, 15));
        pdfExtractor.setPreferredSize(new java.awt.Dimension(83, 15));
        pdfExtractor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfExtractorActionPerformed(evt);
            }
        });

        pdfImages.setSelected(true);
        pdfImages.setText(messages.getString("extract_img"));
        pdfImages.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pdfImages.setMaximumSize(new java.awt.Dimension(83, 15));
        pdfImages.setMinimumSize(new java.awt.Dimension(83, 15));
        pdfImages.setPreferredSize(new java.awt.Dimension(83, 15));
        pdfImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfImagesActionPerformed(evt);
            }
        });

        jLabel5.setText("Select one of the following options for analysis :");

        checkBoxCommentaires.setSelected(true);
        checkBoxCommentaires.setText(messages.getString("Analyse_Sans_Commentaires"));
        checkBoxCommentaires.setActionCommand("");
        checkBoxCommentaires.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        checkBoxCommentaires.setName(""); // NOI18N
        checkBoxCommentaires.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxCommentairesActionPerformed(evt);
            }
        });

        checkBoxWhitepsaces.setSelected(true);
        checkBoxWhitepsaces.setText(messages.getString("Analyse_Sans_Whitespaces"));
        checkBoxWhitepsaces.setActionCommand("");
        checkBoxWhitepsaces.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        checkBoxWhitepsaces.setName(""); // NOI18N
        checkBoxWhitepsaces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxWhitepsacesActionPerformed(evt);
            }
        });

        jRadioButton3.setText(messages.getString("Progres_Mod"));
        jRadioButton3.setSelected(true);
        jRadioButton3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton3ItemStateChanged(evt);
            }
        });
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setText(messages.getString("Fix_Color"));
        jRadioButton4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton4ItemStateChanged(evt);
            }
        });
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTextField1.setMinimumSize(new java.awt.Dimension(55, 19));
        jTextField1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField1InputMethodTextChanged(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel6.setText("Red");
        jLabel6.setText(messages.getString("Red_Color"));

        jTextField4.setMinimumSize(new java.awt.Dimension(67, 19));
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });

        jLabel10.setText("Yellow");
        jLabel10.setText(messages.getString("Yellow_Color"));

        jTextField6.setText("1.0");
        jTextField6.setEnabled(false);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
        });

        jLabel8.setText("Green");
        jLabel8.setText(messages.getString("Green_Color"));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(messages.getString("Panel_Title")));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(86, 86, 86))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxWhitepsaces, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkBoxCommentaires, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pdfExtractor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pdfImages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBoxAnalyseConcatenation, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                    .addComponent(jCheckBoxPreviewFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBoxPreviewFiles)
                .addGap(18, 18, 18)
                .addComponent(jCheckBoxAnalyseConcatenation)
                .addGap(18, 18, 18)
                .addComponent(pdfExtractor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pdfImages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(checkBoxCommentaires)
                .addGap(18, 18, 18)
                .addComponent(checkBoxWhitepsaces)
                .addContainerGap(170, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(235, 235, 235)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Options", jPanel2);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.setMinimumSize(new java.awt.Dimension(200, 50));

        zoneTexte.setBorder(null);
        zoneTexte.setAutoscrolls(false);
        zoneTexte.setMinimumSize(new java.awt.Dimension(200, 50));
        zoneTexte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zoneTexteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(zoneTexte);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(messages.getString("Notes"), jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Note");
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Renvoie le contenu actuel du JTextPane.
     *
     * @return texte du JTextPane
     */
    public String getText() {
        return zoneTexte.getText();
    }

    /**
     * Change le texte du JTextPane.
     *
     * @param txt
     */
    public void setText(String txt) {
        zoneTexte.setText(txt);
    }

    private void couperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_couperActionPerformed
        zoneTexte.cut();
    }//GEN-LAST:event_couperActionPerformed

    private void copierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copierActionPerformed
        zoneTexte.copy();
    }//GEN-LAST:event_copierActionPerformed

    private void collerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collerActionPerformed
        zoneTexte.paste();
    }//GEN-LAST:event_collerActionPerformed

    private void selectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllActionPerformed
        zoneTexte.selectAll();
    }//GEN-LAST:event_selectAllActionPerformed

    private void zoneTexteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zoneTexteMouseClicked
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON2 || evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_zoneTexteMouseClicked

    private void jCheckBoxAnalyseConcatenationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAnalyseConcatenationActionPerformed
        analyse.setJCheckBoxAnalyseConcatenation(jCheckBoxAnalyseConcatenation.isSelected());
        if (jCheckBoxAnalyseConcatenation.isSelected()) {
            analyse.getPrefs().writePref("CONCATENATION", true);
        } else {
            analyse.getPrefs().writePref("CONCATENATION", false);
        }
        this.parentTab.getPanelFile().SetBtnAnalyseEnabled(true);
    }//GEN-LAST:event_jCheckBoxAnalyseConcatenationActionPerformed

    private void checkBoxCommentairesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxCommentairesActionPerformed
        analyse.setCheckBoxCommentaires(checkBoxCommentaires.isSelected());
        this.parentTab.getPanelFile().SetBtnAnalyseEnabled(true);
    }//GEN-LAST:event_checkBoxCommentairesActionPerformed

    private void checkBoxWhitepsacesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxWhitepsacesActionPerformed
        analyse.setCheckBoxWhitepsaces(checkBoxWhitepsaces.isSelected());
        this.parentTab.getPanelFile().SetBtnAnalyseEnabled(true);
    }//GEN-LAST:event_checkBoxWhitepsacesActionPerformed

    private void jRadioButton3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton3ItemStateChanged
        // TODO add your handling code here:
        deactiverTextFiel();

        if (jRadioButton3.isSelected()) {
            jRadioButton4.setSelected(false);
            deactiverTextFiel();
        } else {
            jRadioButton4.setSelected(true);
            activerTextFile();
        }
        this.parentTab.getPanelFile().SetBtnAnalyseEnabled(true);
    }//GEN-LAST:event_jRadioButton3ItemStateChanged
    private void deactiverTextFiel() {
//        jPanel3.setVisible(false);
        Component myComps[] = jPanel4.getComponents();
        for (int i = 0; i < myComps.length; i++) {
            if (myComps[i] instanceof JTextField) {
                JTextField myTextField = (JTextField) myComps[i];
                myTextField.enable(false);
                myTextField.setBackground(Color.LIGHT_GRAY);
            }
        }
    }

    private void activerTextFile() {
        Component myComps[] = jPanel4.getComponents();
        for (int i = 0; i < myComps.length; i++) {
            if (myComps[i] instanceof JTextField) {
                JTextField myTextField = (JTextField) myComps[i];
                if (myTextField != jTextField6) {
                    myTextField.enable(true);
                    myTextField.setBackground(Color.white);
                }
            }
        }
    }
    private void jRadioButton4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton4ItemStateChanged
        // TODO add your handling code here:
        //        jPanel3.setVisible(true);
        activerTextFile();

        if (jRadioButton4.isSelected()) {
            jRadioButton3.setSelected(false);
            analyse.setIsProgressive(false);
            activerTextFile();
        } else {
            jRadioButton3.setSelected(true);
            analyse.setIsProgressive(true);
            deactiverTextFiel();
        }
        this.parentTab.getPanelFile().SetBtnAnalyseEnabled(true);
    }//GEN-LAST:event_jRadioButton4ItemStateChanged

    private void jCheckBoxPreviewFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPreviewFilesActionPerformed
        analyse.setJCheckBoxPreviewFiles(jCheckBoxPreviewFiles.isSelected());
        this.parentTab.getPanelFile().SetBtnAnalyseEnabled(true);
    }//GEN-LAST:event_jCheckBoxPreviewFilesActionPerformed

    private void pdfExtractorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfExtractorActionPerformed
        analyse.setPdfExtractor(pdfExtractor.isSelected());
        this.parentTab.getPanelFile().SetBtnAnalyseEnabled(true);
    }//GEN-LAST:event_pdfExtractorActionPerformed

    private void pdfImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfImagesActionPerformed
        analyse.setPdfImages(pdfImages.isSelected());
        this.parentTab.getPanelFile().SetBtnAnalyseEnabled(true);
    }//GEN-LAST:event_pdfImagesActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        try {
            analyse.setRedLimitTxt(jTextField1.getText(), evt.getKeyChar());
            analyse.setRedLimit(Double.parseDouble(jTextField1.getText() + evt.getKeyChar()));
        } catch (NumberFormatException e) {
        }
        this.parentTab.getPanelFile().SetBtnAnalyseEnabled(true);
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        try {
            analyse.setYellowLimitTxt(jTextField4.getText(), evt.getKeyChar());
            analyse.setYellowLimit(Double.parseDouble(jTextField4.getText() + evt.getKeyChar()));
        } catch (NumberFormatException e) {
        }
        this.parentTab.getPanelFile().SetBtnAnalyseEnabled(true);
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        boolean egal = false;
        List<Task> listeTasks = win.getProjetCourant().getTasks();
        for (int i = 0; i < listeTasks.size(); i++) {
            if (analyse.equals(listeTasks.get(i))) {
                egal = true;
            }
        }
        if (!egal) {
            analyse = listeTasks.get(0);
        }
//        if (analyse.getJCheckBoxPreviewFiles()) {
//            jCheckBoxPreviewFiles.setSelected(true);
//        } else {
//            jCheckBoxPreviewFiles.setSelected(false);
//        }
//        if (analyse.getJCheckBoxAnalyseConcatenation()) {
//            jCheckBoxAnalyseConcatenation.setSelected(true);
//        } else {
//            jCheckBoxAnalyseConcatenation.setSelected(false);
//        }
//        if (analyse.getPdfExtractor()) {
//            pdfExtractor.setSelected(true);
//        } else {
//            pdfExtractor.setSelected(false);
//        }
//        if (analyse.getPdfImages()) {
//            pdfImages.setSelected(true);
//        } else {
//            pdfImages.setSelected(false);
//        }
//        if (analyse.getCheckBoxCommentaires()) {
//            checkBoxCommentaires.setSelected(true);
//        } else {
//            checkBoxCommentaires.setSelected(false);
//        }
//        if (analyse.getCheckBoxWhitepsaces()) {
//            checkBoxWhitepsaces.setSelected(true);
//        } else {
//            checkBoxWhitepsaces.setSelected(false);
//        }
//        if (analyse.getIsProgressive()) {
//            jRadioButton3.setSelected(true);
//            jRadioButton4.setSelected(false);
//        } else {
//            jRadioButton3.setSelected(false);
//            jRadioButton4.setSelected(true);
//        }
//        jTextField1.setText(analyse.getRedLimitTxt());
//        jTextField4.setText(analyse.getYellowLimitTxt());
//        jTextField6.setText(analyse.getGreenLimitTxt());
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        try {
            analyse.setGreenLimitTxt(jTextField6.getText(), evt.getKeyChar());
            analyse.setGreenLimit(Double.parseDouble(jTextField6.getText() + evt.getKeyChar()));
        } catch (NumberFormatException e) {
        }
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jTextField1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField1InputMethodTextChanged

    }//GEN-LAST:event_jTextField1InputMethodTextChanged

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
                

    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBoxCommentaires;
    private javax.swing.JCheckBox checkBoxWhitepsaces;
    private javax.swing.JMenuItem coller;
    private javax.swing.JMenuItem copier;
    private javax.swing.JMenuItem couper;
    private javax.swing.JCheckBox jCheckBoxAnalyseConcatenation;
    private javax.swing.JCheckBox jCheckBoxPreviewFiles;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JCheckBox pdfExtractor;
    private javax.swing.JCheckBox pdfImages;
    private javax.swing.JMenuItem selectAll;
    private javax.swing.JTextPane zoneTexte;
    // End of variables declaration//GEN-END:variables

    private boolean allValuesAreEqual(double[] values) {
        boolean allEqual = true;

        if (values == null) {
            return true;
        }

        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                allEqual = values[i] == values[i - 1] && allEqual;
            }
        }

        return allEqual;
    }

    public void DispatchResult() {
        if (analyse != null) {
            //number of analysis
            int nb = analyse.getResults().getNumAnalyse();
            List<File> fichiers;
            //files analysed
            fichiers = analyse.getFichiersResultats();
            int i, j;
            //linearized res matrix (used for renderers)
            double[] val = new double[nb];
            int a = 0;
            for (i = 0; i < fichiers.size(); i++) {
                for (j = 0; j < fichiers.size(); j++) {
                    if (j < i) {
                        val[a++] = analyse.getResults().getRes(i, j);
                    } else {
                        break;
                    }
                }
            }
            valLin = val;
        }
    }

    @Override
    public void changementEtat() {
        changementEtat(null, null);
    }

    @Override
    public void changementEtat(Enum<?> property, Object o) {
        if (property == Observation.ANALYSE_TERMINEE) {
            DispatchResult();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        messages = (ResourceBundle) arg;
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(messages.getString("Panel_Title")));

        jTabbedPane1.setTitleAt(0, messages.getString("Options"));
        jCheckBoxPreviewFiles.setText(messages.getString("Preview_files"));
        jCheckBoxAnalyseConcatenation.setText(messages.getString("Analysis_concatenation"));
        pdfExtractor.setText(messages.getString("extract_pdf"));
        pdfImages.setText(messages.getString("extract_img"));
        jLabel5.setText(messages.getString("Description_Analyses"));
        checkBoxCommentaires.setText(messages.getString("Analyse_Sans_Commentaires"));
        checkBoxWhitepsaces.setText(messages.getString("Analyse_Sans_Whitespaces"));
        jRadioButton3.setText(messages.getString("Progres_Mod"));
        jRadioButton4.setText(messages.getString("Fix_Color"));
        jLabel6.setText(messages.getString("Red_Color"));
        jLabel8.setText(messages.getString("Green_Color"));
        jLabel10.setText(messages.getString("Yellow_Color"));

    }
}