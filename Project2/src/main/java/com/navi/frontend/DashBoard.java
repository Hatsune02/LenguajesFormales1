package com.navi.frontend;

import com.navi.backend.read.ReaderText;
import com.navi.frontend.views.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.*;

import java.awt.*;
import javax.swing.*;


/**
 *
 * @author dog
 */
public class DashBoard extends javax.swing.JFrame {
    PrincipalPanel principalPanel = new PrincipalPanel();
    ParserPanel parserPanel;
    ReportsPanel reportsPanel = new ReportsPanel();

    public DashBoard() {
        parserPanel = new ParserPanel(reportsPanel);
        initComponents();
        initStyles();
        showJPanel(principalPanel);

    }

    private void initStyles(){
        setTitle("Parser-Py");
        nameLabel.putClientProperty("FlatLaf.style","font: 34 $semibold.font");
        nameLabel.setForeground(Color.WHITE);
        menuLabel.putClientProperty("FlatLaf.style","font: bold $h1.regular.font");
        menuLabel.setForeground(Color.WHITE);
        separator.setForeground(Color.WHITE);
        jMenuBar1.setForeground(Color.BLACK);
        //Obscure Theme
        jMenuBar1.setForeground(Color.WHITE);


        panelHead.setBackground(new Color(25,118,210));
        panelMenu.setBackground(new Color(13,71,161));
        background.setBackground(new Color(0,153,153));
        
    }
    
    private void showJPanel(JPanel p){
        p.setSize(800,450);
        p.setLocation(0,0);
        
        contentPanel.removeAll();
        contentPanel.add(p, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new JPanel();
        panelMenu = new JPanel();
        menuLabel = new javax.swing.JLabel();
        separator = new javax.swing.JLabel();
        principalButtonMenu = new javax.swing.JButton();
        parserButtonMenu = new javax.swing.JButton();
        reportButtonMenu = new javax.swing.JButton();
        panelHead = new JPanel();
        nameLabel = new javax.swing.JLabel();
        contentPanel = new JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        uploadFile = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new Color(0, 0, 0));

        panelMenu.setBackground(new Color(13, 71, 161));
        panelMenu.setForeground(new Color(255, 255, 255));

        menuLabel.setBackground(new Color(255, 255, 255));
        menuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuLabel.setText("Menu");

        separator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        separator.setText("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        separator.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        principalButtonMenu.setBackground(new Color(13, 71, 161));
        principalButtonMenu.setFont(new Font("Liberation Sans", 1, 18)); // NOI18N
        principalButtonMenu.setForeground(new Color(255, 255, 255));
        principalButtonMenu.setText("Principal");
        principalButtonMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 20, 1, 1, new Color(0, 0, 0)));
        principalButtonMenu.setBorderPainted(false);
        principalButtonMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        principalButtonMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        principalButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                principalButtonMenuActionPerformed(evt);
            }
        });

        parserButtonMenu.setBackground(new Color(13, 71, 161));
        parserButtonMenu.setFont(new Font("Liberation Sans", 1, 18)); // NOI18N
        parserButtonMenu.setForeground(new Color(255, 255, 255));
        parserButtonMenu.setText("Analizador");
        parserButtonMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 20, 1, 1, new Color(0, 0, 0)));
        parserButtonMenu.setBorderPainted(false);
        parserButtonMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        parserButtonMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        parserButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parserButtonMenuActionPerformed(evt);
            }
        });

        reportButtonMenu.setBackground(new Color(13, 71, 161));
        reportButtonMenu.setFont(new Font("Liberation Sans", 1, 18)); // NOI18N
        reportButtonMenu.setForeground(new Color(255, 255, 255));
        reportButtonMenu.setText("Reportes");
        reportButtonMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 20, 1, 1, new Color(0, 0, 0)));
        reportButtonMenu.setBorderPainted(false);
        reportButtonMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reportButtonMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reportButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportButtonMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(menuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(parserButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(principalButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(reportButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(menuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(separator)
                .addGap(39, 39, 39)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(parserButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(principalButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(reportButtonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelHead.setBackground(new Color(0, 255, 204));

        nameLabel.setBackground(new Color(255, 255, 255));
        nameLabel.setText("PARSER-PY");

        javax.swing.GroupLayout panelHeadLayout = new javax.swing.GroupLayout(panelHead);
        panelHead.setLayout(panelHeadLayout);
        panelHeadLayout.setHorizontalGroup(
            panelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeadLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(550, Short.MAX_VALUE))
        );
        panelHeadLayout.setVerticalGroup(
            panelHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeadLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        contentPanel.setBackground(new Color(255, 255, 255));
        contentPanel.setLayout(new BorderLayout());

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(panelHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setMaximumSize(new Dimension(90, 32768));
        jMenuBar1.setMinimumSize(new Dimension(90, 25));
        jMenuBar1.setPreferredSize(new Dimension(90, 25));

        jMenu1.setText("Archivo");

        uploadFile.setText("Cargar Archivos");
        uploadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadFileActionPerformed(evt);
            }
        });
        jMenu1.add(uploadFile);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void principalButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_principalButtonMenuActionPerformed
        showJPanel(principalPanel);
    }

    private void parserButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parserButtonMenuActionPerformed
        showJPanel(parserPanel);
    }

    private void reportButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportButtonMenuActionPerformed
        if(!parserPanel.errors.isEmpty()){
            String alert = """
                                SE ENCONTRARON ERRORES AL ANALIZAR EL TEXTO
                    SE RECOMIENDA QUE PARA VER LOS REPORTES NO EXISTA NINGUN ERROR.
                    
                    LOS REPORTES QUE SE MUESTRA A CONTINUACIÓN PUEDEN LLEGAR A NO
                    TENER SENTIDO.
                                            """;
            JOptionPane err = new JOptionPane(alert,JOptionPane.WARNING_MESSAGE);
            JDialog dialog = err.createDialog("ADVERTENCIA");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
        showJPanel(reportsPanel);
        reportsPanel.symbolsReport.initTable();
    }
    private void uploadFileActionPerformed(java.awt.event.ActionEvent evt) {
        parserPanel.textPaneParser.setText(ReaderText.Read());
    }

    public static void initUI() {
        //FlatMaterialLighterIJTheme.setup();
        FlatMaterialDarkerIJTheme.setup();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    private JPanel background;
    private JPanel contentPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel menuLabel;
    private javax.swing.JLabel nameLabel;
    private JPanel panelHead;
    private JPanel panelMenu;
    private javax.swing.JButton parserButtonMenu;
    private javax.swing.JButton principalButtonMenu;
    private javax.swing.JButton reportButtonMenu;
    private javax.swing.JLabel separator;
    private javax.swing.JMenuItem uploadFile;
}
