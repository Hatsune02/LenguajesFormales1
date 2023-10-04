/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.navi.frontend.views;

import java.awt.*;

/**
 *
 * @author dog
 */
public class Reports extends javax.swing.JPanel {

    /**
     * Creates new form Reports
     */
    public Reports() {
        initComponents();
        initStyle();
        
    }
    private void initStyle(){
        jLabel1.putClientProperty("FlatLaf.style","font: 14 $semibold.font");
        jLabel1.setForeground(Color.WHITE);
        jComboBoxFilter.setForeground(Color.BLACK);
        filterButton.setForeground(Color.BLACK);

        //Obscure Theme
        jComboBoxFilter.setForeground(Color.WHITE);
        filterButton.setForeground(Color.WHITE);
        
    }
    private void initContent(){

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        optionsPanel = new javax.swing.JPanel();
        symbolsReportButton = new javax.swing.JButton();
        instructionsReportButton = new javax.swing.JButton();
        functionsReportButton = new javax.swing.JButton();
        contentReportsPanel = new javax.swing.JPanel();
        jComboBoxFilter = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        filterButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new Color(255, 255, 255));
        setPreferredSize(new Dimension(800, 450));
        setRequestFocusEnabled(false);

        background.setBackground(new Color(0, 51, 210));

        optionsPanel.setBackground(new Color(0, 0, 0));

        symbolsReportButton.setBackground(new Color(0, 0, 0));
        symbolsReportButton.setForeground(new Color(255, 255, 255));
        symbolsReportButton.setText("Tabla de Simbolos");
        symbolsReportButton.setBorder(null);
        symbolsReportButton.setBorderPainted(false);
        symbolsReportButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        symbolsReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                symbolsReportButtonActionPerformed(evt);
            }
        });

        instructionsReportButton.setBackground(new Color(0, 0, 0));
        instructionsReportButton.setForeground(new Color(255, 255, 255));
        instructionsReportButton.setText("Instrucciones");
        instructionsReportButton.setBorder(null);
        instructionsReportButton.setBorderPainted(false);
        instructionsReportButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        functionsReportButton.setBackground(new Color(0, 0, 0));
        functionsReportButton.setForeground(new Color(255, 255, 255));
        functionsReportButton.setText("Funciones");
        functionsReportButton.setBorder(null);
        functionsReportButton.setBorderPainted(false);
        functionsReportButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        javax.swing.GroupLayout optionsPanelLayout = new javax.swing.GroupLayout(optionsPanel);
        optionsPanel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addComponent(symbolsReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instructionsReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(functionsReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        optionsPanelLayout.setVerticalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(symbolsReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(instructionsReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(functionsReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        contentReportsPanel.setBackground(new Color(0, 51, 210));
        contentReportsPanel.setPreferredSize(new Dimension(0, 0));

        jComboBoxFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("SELECCIONE UN BLOQUE");

        filterButton.setText("FILTRAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contentReportsPanelLayout = new javax.swing.GroupLayout(contentReportsPanel);
        contentReportsPanel.setLayout(contentReportsPanelLayout);
        contentReportsPanelLayout.setHorizontalGroup(
            contentReportsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentReportsPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addComponent(jComboBoxFilter, 0, 384, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterButton, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addGap(23, 23, 23))
            .addGroup(contentReportsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        contentReportsPanelLayout.setVerticalGroup(
            contentReportsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentReportsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentReportsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentReportsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentReportsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void symbolsReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_symbolsReportButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_symbolsReportButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel contentReportsPanel;
    private javax.swing.JButton filterButton;
    private javax.swing.JButton functionsReportButton;
    private javax.swing.JButton instructionsReportButton;
    private javax.swing.JComboBox<String> jComboBoxFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JButton symbolsReportButton;
    // End of variables declaration//GEN-END:variables
}
