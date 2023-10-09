package com.navi.frontend.views.tables;

import com.navi.backend.reports.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class FunctionsTable {
    String [] head = {"Función","Parámetros","Referencias","Línea"};
    String [][] data;
    DefaultTableModel mod;
    JTable table;
    public FunctionsTable(ArrayList<Function> functions){
        this.data = fillData(functions);
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
    }

    private String[][] fillData(ArrayList<Function> functions){
        String [][] info = new String[functions.size()][head.length];

        for (int i = 0; i < info.length; i++) {
            Function function = functions.get(i);
            info[i][0] = function.getName();
            info[i][1] = function.getParams();
            if(String.valueOf(function.getReferences()).isEmpty()) info[i][2] = "--";
            else info[i][2] = String.valueOf(function.getReferences());
            info[i][3] = String.valueOf(function.getRow()+1);
        }
        return info;
    }
}
