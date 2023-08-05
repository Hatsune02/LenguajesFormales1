package frontend;

import backend.Token;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Reports {
    String [] head = {"Lexema","Tipo","Línea","Columna"};
    String [][] data;
    DefaultTableModel mod;
    JTable table;
    JFrame frame = new JFrame();
    public Reports(ArrayList<Token> tokens){
        this.data = fillData(tokens);
    }

    public void table(JPanel panelTable){
        mod = new DefaultTableModel(data, head);
        table = new JTable(mod);
        JScrollPane scrollTable = new JScrollPane(table);
        panelTable.add(scrollTable);
        scrollTable.setBounds(40,40,1000,500);

        //xd
       /* frame.setLayout(null);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(scrollTable);
        frame.setVisible(true);*/
    }


    private String[][] fillData(ArrayList<Token> tokens){
        String [][] info = new String[tokens.size()][head.length];

        for (int i = 0; i < info.length; i++) {
            info[i][0] = tokens.get(i).getLexem();
            info[i][1] = tokens.get(i).getType().getType();
            info[i][2] = String.valueOf(tokens.get(i).getRow()+1);
            info[i][3] = String.valueOf(tokens.get(i).getColumn()+1);
        }

        return info;
    }
}
