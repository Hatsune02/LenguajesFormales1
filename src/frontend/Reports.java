package frontend;

import backend.Analyzer;
import backend.Token;
import backend.TokenType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Reports {
    String [] head = {"Token","Patrón","Lexema","Línea","Columna"};
    String [][] data;
    DefaultTableModel mod;
    JTable table;
    public Reports(ArrayList<Token> tokens){
        this.data = fillData(tokens);
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
        table.getColumnModel().getColumn(3).setResizable(false);
        table.getColumnModel().getColumn(4).setResizable(false);
    }

    private String[][] fillData(ArrayList<Token> tokens){
        String [][] info = new String[tokens.size()][head.length];

        for (int i = 0; i < info.length; i++) {
            if(tokens.get(i).getType()==TokenType.KEYWORD||tokens.get(i).getType()==TokenType.LOGIC){
                info[i][0] = tokens.get(i).getType().getType()+"";
                info[i][1] = tokens.get(i).getLexem()+"";
                info[i][2] = tokens.get(i).getLexem()+"";
                info[i][3] = String.valueOf(tokens.get(i).getRow()+1+"");
                info[i][4] = String.valueOf(tokens.get(i).getColumn()+1+"");
            }
            else {
                info[i][0] = tokens.get(i).getType().getType()+"";
                info[i][1] = tokens.get(i).getRegEx().getRegEx()+"";
                info[i][2] = tokens.get(i).getLexem()+"";
                info[i][3] = String.valueOf(tokens.get(i).getRow()+1+"");
                info[i][4] = String.valueOf(tokens.get(i).getColumn()+1+"");
            }
        }
        return info;
    }
}
