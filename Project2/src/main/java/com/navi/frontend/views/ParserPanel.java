/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.navi.frontend.views;

import com.navi.backend.lexer.Analyzer;
import com.navi.backend.parser.*;
import com.navi.backend.reports.*;
import com.navi.backend.tokens.*;
import com.navi.backend.utils.*;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;

import static com.navi.frontend.ArraysForReports.*;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author dog
 */
public class ParserPanel extends javax.swing.JPanel {
    Analyzer analyzer;
    PDA pda;
    public StringBuilder errors = new StringBuilder();
    LineNumber lineNumber1, lineNumber2;

    public ParserPanel(ReportsPanel panelReports) {
        initComponents();
        initStyles();

    }
    
    private void initStyles(){
        textPaneParser.setForeground(Color.BLACK);
        textPaneError.setForeground(Color.BLACK);
        //Obscure Theme
        textPaneParser.setForeground(Color.WHITE);
        textPaneError.setForeground(Color.WHITE);

        textPaneError.setEditable(false);
        setTabs(textPaneParser,4);
        setTabs(textPaneError,4);

        errorLabel.putClientProperty("FlatLaf.style","font: bold $h3.regular.font");
        errorLabel.setForeground(Color.WHITE);
        parserButton.setForeground(Color.BLACK);

        lineNumber1 = new LineNumber(textPaneParser);
        lineNumber2 = new LineNumber(textPaneError);

        jScrollPaneParser.setRowHeaderView(lineNumber1);
        jScrollPaneError.setRowHeaderView(lineNumber2);

    }

    private void parserButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(!textPaneParser.getText().isEmpty()){
            //RESET ARRAYS
            tokens = new ArrayList<>();
            symbols = new ArrayList<>();
            blocks = new ArrayList<>();
            instructions = new ArrayList<>();
            functions = new ArrayList<>();

            //ANALYZE TEXT
            analyzer = new Analyzer(textPaneParser.getText());
            analyzer.analyze();

            tokens = analyzer.getTokens();
            pda = PDA.getAutomaton(tokens);
            //if(tokens!=null) pda.analyze(0);
            errors = new StringBuilder();

            //SHOE ERRORS
            ArrayList<Token> tokensError = LexerMethods.filterArrayList(TokenType.ERROR,tokens);
            if(tokensError.size()!=0) errors.append("Errores Léxicos:\n").append(tokensError).append("\n");
            if(!pda.getError().isEmpty()) errors.append("\nErrores Sintácticos\n").append(pda.getError());
            if(!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Error");
                textPaneError.setText(errors.toString());
            }
            else textPaneError.setText("");;

            //FILL ARRAYS
            symbols = ParserMethods.symbols(tokens,0, tokens.size());
            blocks = ParserMethods.blocks(tokens);
            instructions = ParserMethods.instructions(tokens,0,tokens.size());
            functions = ParserMethods.functions(tokens);

            //System.out.println(tokens.size());
            /*for(Token t : tokens){
                System.out.println(t);
            }*/

        }
        else{
            textPaneError.setText("");
            errors = new StringBuilder();
        }

    }

    public void setTabs(JTextPane textPane, int characterPerTab){
        FontMetrics fm = textPane.getFontMetrics(textPane.getFont());
        int charWidth = fm.charWidth(' ');
        int tabWidth = charWidth * characterPerTab;

        TabStop[] tabs = new TabStop[5];
        for (int i = 0; i < tabs.length; i++) {
            int tab = i+1;
            tabs[i] = new TabStop(tab * tabWidth);
        }

        TabSet tabSet = new TabSet(tabs);
        SimpleAttributeSet attributes = new SimpleAttributeSet();
        StyleConstants.setTabSet(attributes,tabSet);
        int length = textPane.getDocument().getLength();
        textPane.getStyledDocument().setParagraphAttributes(0,length,attributes,false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jScrollPaneParser = new javax.swing.JScrollPane();
        textPaneParser = new javax.swing.JTextPane();
        jScrollPaneError = new javax.swing.JScrollPane();
        textPaneError = new javax.swing.JTextPane();
        errorLabel = new javax.swing.JLabel();
        parserButton = new javax.swing.JButton();

        background.setBackground(new Color(0, 153, 153));

        jScrollPaneParser.setViewportView(textPaneParser);

        jScrollPaneError.setViewportView(textPaneError);

        errorLabel.setText("ERROR");

        parserButton.setBackground(new Color(0, 204, 204));
        parserButton.setFont(new Font("Liberation Sans", 0, 14)); // NOI18N
        parserButton.setText("Analizar");
        parserButton.setBorder(null);
        parserButton.setBorderPainted(false);
        parserButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        parserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parserButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneError)
                    .addComponent(jScrollPaneParser)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                        .addGap(471, 471, 471)))
                .addGap(18, 18, 18)
                .addComponent(parserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(parserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPaneParser, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
                .addGap(31, 31, 31)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneError, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JScrollPane jScrollPaneError;
    public javax.swing.JScrollPane jScrollPaneParser;
    private javax.swing.JButton parserButton;
    private javax.swing.JTextPane textPaneError;
    public javax.swing.JTextPane textPaneParser;
    // End of variables declaration//GEN-END:variables
}
