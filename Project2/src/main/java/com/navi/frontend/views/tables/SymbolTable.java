package com.navi.frontend.views.tables;

import com.navi.backend.reports.Symbol;
import com.navi.backend.tokens.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class SymbolTable {
    String [] head = {"Símbolo","Tipo","Valor","Línea","Columna"};
    String [][] data;
    DefaultTableModel mod;
    JTable table;
    public SymbolTable(ArrayList<Symbol> symbols){
        this.data = fillData(symbols);
    }

    public void table(JPanel panelTable){
        mod = new DefaultTableModel(data, head);
        table = new JTable(mod);
        JScrollPane scrollTable = new JScrollPane(table);
        panelTable.add(scrollTable);

        table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(32, 136, 203));
        table.getTableHeader().setForeground(new Color(255,255,255));
        table.setRowHeight(25);
        table.getColumnModel().getColumn(3).setPreferredWidth(10);
        table.getColumnModel().getColumn(4).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setResizable(false);
        table.getColumnModel().getColumn(4).setResizable(false);
    }

    private String[][] fillData(ArrayList<Symbol> symbols){
        String [][] info = new String[symbols.size()][head.length];

        for (int i = 0; i < info.length; i++) {
            Symbol symbol = symbols.get(i);
            info[i][0] = symbol.getName();
            info[i][1] = symbol.getType();
            info[i][2] = symbol.getValue();
            info[i][3] = String.valueOf(symbol.getRow()+1);
            info[i][4] = String.valueOf(symbol.getColumn()+1);
        }
        return info;
    }
}
