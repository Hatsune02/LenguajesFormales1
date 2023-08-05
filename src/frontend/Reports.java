package frontend;

import backend.Token;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Reports {
    String [] head = {"Lexema","Tipo","Línea","Columna"};
    String [][] data;
    DefaultTableModel mod;
    JTable table;
    JComponent jComponent = null;
    JFrame frame = new JFrame();
    public Reports(ArrayList<Token> tokens){
        this.data = fillData(tokens);
    }

    public void table(JPanel panelTable){
        mod = new DefaultTableModel(data, head);
        table = new JTable(mod);
        JScrollPane scrollTable = new JScrollPane(table);
        panelTable.add(scrollTable);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        /*jComponent.setBorder(BorderFactory.createMatteBorder(0,0,1,1, Color.CYAN));
        jComponent.setOpaque(true);
        jComponent.setBackground(new Color(236,234,219));
        jComponent.setForeground(Color.white);
        table.add(jComponent);*/

    }


    private String[][] fillData(ArrayList<Token> tokens){
        String [][] info = new String[tokens.size()][head.length];

        for (int i = 0; i < info.length; i++) {
            info[i][0] = tokens.get(i).getLexem()+"";
            info[i][1] = tokens.get(i).getType().getType()+"";
            info[i][2] = String.valueOf(tokens.get(i).getRow()+1+"");
            info[i][3] = String.valueOf(tokens.get(i).getColumn()+1+"");
        }

        return info;
    }
}
