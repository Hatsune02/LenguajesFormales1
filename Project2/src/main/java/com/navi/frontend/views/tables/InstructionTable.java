package com.navi.frontend.views.tables;

import com.navi.backend.reports.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class InstructionTable {
    String [] head = {"Fila","Instrucción","Columna"};
    String [][] data;
    DefaultTableModel mod;
    JTable table;
    public InstructionTable(ArrayList<Instruction> instructions){
        this.data = fillData(instructions);
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

    private String[][] fillData(ArrayList<Instruction> instructions){
        String [][] info = new String[instructions.size()][head.length];

        for (int i = 0; i < info.length; i++) {
            Instruction instruction = instructions.get(i);
            info[i][0] = String.valueOf(instruction.getRow()+1);
            info[i][1] = instruction.getBody();
            info[i][2] = String.valueOf(instruction.getColumn()+1);
        }
        return info;
    }
}
