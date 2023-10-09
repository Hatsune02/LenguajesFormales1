
package com.navi.frontend.views.reports;

import com.navi.backend.reports.Block;
import com.navi.backend.reports.Symbol;
import com.navi.backend.utils.ParserMethods;
import com.navi.frontend.views.tables.SymbolTable;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import static com.navi.frontend.ArraysForReports.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author dog
 */
public class SymbolsReport extends javax.swing.JPanel {

    SymbolTable symbolTable;
    String comboBoxText = "";

    public SymbolsReport() {
        initComponents();
        initStyle();
    }

    private void initStyle(){
        jLabel1.putClientProperty("FlatLaf.style","font: 14 $semibold.font");
        jLabel1.setForeground(Color.WHITE);
        jLabel2.putClientProperty("FlatLaf.style","font: 14 $semibold.font");
        jLabel2.setForeground(Color.WHITE);

        AutoCompleteDecorator.decorate(jComboBoxFilter);
        jComboBoxFilter.setForeground(Color.BLACK);
        jComboBoxFilter.setForeground(Color.WHITE);

        tablePanel.removeAll();
        tablePanel.setLayout(new BorderLayout(0,0));
        tablePanel.setBackground(new Color(0,51,210));

        jComboBoxFilter.removeAllItems();

    }
    public void initTable(){
        fillComboBox();
        tablePanel.removeAll();
        tablePanel.setVisible(true);
        if(symbols.size() > 0){
            symbolTable = new SymbolTable(symbols);
            symbolTable.table(tablePanel);
        }
        else JOptionPane.showMessageDialog(null,"No hay ningun reporte");
        SwingUtilities.updateComponentTreeUI(tablePanel);
    }

    private void fillComboBox(){
        jComboBoxFilter.removeAllItems();
        jComboBoxFilter.addItem("Global");
        for (Block block:blocks) {
            String blockName = block.getName() + " (linea "+(block.getRow()+1)+")";

            jComboBoxFilter.addItem(blockName);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        background = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        jComboBoxFilter = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        background.setBackground(new java.awt.Color(0, 51, 210));

        jLabel1.setText("SÍMBOLOS");

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
                tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        tablePanelLayout.setVerticalGroup(
                tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 345, Short.MAX_VALUE)
        );

        jComboBoxFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFilterActionPerformed(evt);
            }
        });

        jLabel2.setText("BLOQUE: ");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(backgroundLayout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(118, 118, 118)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBoxFilter, 0, 416, Short.MAX_VALUE))
                                        .addGroup(backgroundLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>

    private void jComboBoxFilterActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            comboBoxText = jComboBoxFilter.getSelectedItem().toString();
        } catch (Exception e){
            comboBoxText = "";
        }
        changeReport();
    }

    private void changeReport(){
        if(comboBoxText.equals("Global")){
            symbolTable = new SymbolTable(symbols);
            tablePanel.removeAll();
            symbolTable.table(tablePanel);
            SwingUtilities.updateComponentTreeUI(tablePanel);
        }
        else{
            Block block = searchBlock();
            if(block != null) {
                ArrayList<Symbol> filterSymbols = ParserMethods.symbols(tokens,block.getIndex(),block.getIndexF());
                symbolTable = new SymbolTable(filterSymbols);
                tablePanel.removeAll();
                symbolTable.table(tablePanel);
                SwingUtilities.updateComponentTreeUI(tablePanel);
            }
        }
    }

    private Block searchBlock(){
        Block block = null;
        for(Block b: blocks){
            String blockName = b.getName() + " (linea "+(b.getRow()+1)+")";
            if(comboBoxText.equals(blockName)){
                block = b;
                break;
            }
        }
        return block;
    }


    private javax.swing.JPanel background;
    private javax.swing.JComboBox<String> jComboBoxFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel tablePanel;
}
