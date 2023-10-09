package com.navi.frontend.views;

import com.navi.frontend.views.reports.*;

import javax.swing.*;

import java.awt.*;

/**
 *
 * @author dog
 */
public class ReportsPanel extends javax.swing.JPanel {

    public SymbolsReport symbolsReport = new SymbolsReport();
    InstructionReport instructionReport = new InstructionReport();
    FunctionReport functionReport = new FunctionReport();

    public ReportsPanel() {
        initComponents();
        contentReportsPanel.setLayout(new BorderLayout(0,0));
        showJPanel(symbolsReport);
        
    }

    private void showJPanel(JPanel p){
        p.setSize(800,399);
        p.setLocation(0,0);

        contentReportsPanel.removeAll();
        contentReportsPanel.add(p, BorderLayout.CENTER);
        contentReportsPanel.revalidate();
        contentReportsPanel.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        background = new javax.swing.JPanel();
        optionsPanel = new javax.swing.JPanel();
        symbolsReportButton = new javax.swing.JButton();
        instructionsReportButton = new javax.swing.JButton();
        functionsReportButton = new javax.swing.JButton();
        contentReportsPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 450));
        setRequestFocusEnabled(false);

        background.setBackground(new java.awt.Color(0, 153, 153));

        optionsPanel.setBackground(new java.awt.Color(0, 0, 0));

        symbolsReportButton.setBackground(new java.awt.Color(0, 0, 0));
        symbolsReportButton.setForeground(new java.awt.Color(255, 255, 255));
        symbolsReportButton.setText("Tabla de Simbolos");
        symbolsReportButton.setBorder(null);
        symbolsReportButton.setBorderPainted(false);
        symbolsReportButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        symbolsReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                symbolsReportButtonActionPerformed(evt);
            }
        });

        instructionsReportButton.setBackground(new java.awt.Color(0, 0, 0));
        instructionsReportButton.setForeground(new java.awt.Color(255, 255, 255));
        instructionsReportButton.setText("Instrucciones");
        instructionsReportButton.setBorder(null);
        instructionsReportButton.setBorderPainted(false);
        instructionsReportButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        instructionsReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructionsReportButtonActionPerformed(evt);
            }
        });

        functionsReportButton.setBackground(new java.awt.Color(0, 0, 0));
        functionsReportButton.setForeground(new java.awt.Color(255, 255, 255));
        functionsReportButton.setText("Funciones");
        functionsReportButton.setBorder(null);
        functionsReportButton.setBorderPainted(false);
        functionsReportButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        functionsReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                functionsReportButtonActionPerformed(evt);
            }
        });

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

        contentReportsPanel.setBackground(new java.awt.Color(0, 51, 210));
        contentReportsPanel.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout contentReportsPanelLayout = new javax.swing.GroupLayout(contentReportsPanel);

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
    }// </editor-fold>

    private void symbolsReportButtonActionPerformed(java.awt.event.ActionEvent evt) {
        showJPanel(symbolsReport);
        symbolsReport.initTable();
    }

    private void instructionsReportButtonActionPerformed(java.awt.event.ActionEvent evt) {
        showJPanel(instructionReport);
        instructionReport.initTable();
    }

    private void functionsReportButtonActionPerformed(java.awt.event.ActionEvent evt) {
        showJPanel(functionReport);
        functionReport.initTable();
    }


    private javax.swing.JPanel background;
    private javax.swing.JPanel contentReportsPanel;
    private javax.swing.JButton functionsReportButton;
    private javax.swing.JButton instructionsReportButton;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JButton symbolsReportButton;
}
