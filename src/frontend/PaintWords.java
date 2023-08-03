package frontend;

import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;

public class PaintWords {
    public JTextPane textPane;
    private StyleContext sc;
    private DefaultStyledDocument doc;

    public PaintWords(){
        textPane=new JTextPane();
        this.sc = new StyleContext();
        this.doc = new DefaultStyledDocument(sc);
    }
    public void setStyle(String text){
        textPane.setDocument(doc);
        try{
            doc.insertString(0,text,null);
        } catch (Exception e){
            System.out.println("No se pudo pintar");
        }
    }
    public void paintBlue(int initialPos, int finalPos){
        Style blue = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(blue, Color.BLUE);
        doc.setCharacterAttributes(initialPos,finalPos,blue,false);
    }
    public void paintRed(int initialPos, int finalPos){
        Style red = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(red, Color.RED);
        doc.setCharacterAttributes(initialPos,finalPos,red,false);
    }
    public void paintYellow(int initialPos, int finalPos){
        Style yellow = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(yellow, Color.YELLOW);
        doc.setCharacterAttributes(initialPos,finalPos,yellow,false);
    }
    public void paintSkyBlue(int initialPos, int finalPos){
        Style skyBlue = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(skyBlue, Color.decode("#2ECCFA"));
        doc.setCharacterAttributes(initialPos,finalPos,skyBlue,false);
    }
    public void paintCyan(int initialPos, int finalPos){
        Style cyan = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(cyan, Color.CYAN);
        doc.setCharacterAttributes(initialPos,finalPos,cyan,false);
    }
    public void paintMagenta(int initialPos, int finalPos){
        Style magenta = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(magenta, Color.MAGENTA);
        doc.setCharacterAttributes(initialPos,finalPos,magenta,false);
    }
    public void paintGray(int initialPos, int finalPos){
        Style gray = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(gray, Color.GRAY);
        doc.setCharacterAttributes(initialPos,finalPos,gray,false);
    }
    public void paintGreen(int initialPos, int finalPos){
        Style green = sc.addStyle("ConstantWidth", null); //#088A29
        StyleConstants.setForeground(green, Color.GREEN);
        doc.setCharacterAttributes(initialPos,finalPos,green,false);
    }
    public void paintLightGreen(int initialPos, int finalPos){
        Style lightGreen = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(lightGreen, Color.decode("#86B404 "));
        doc.setCharacterAttributes(initialPos,finalPos,lightGreen,false);
    }
    public void paintOrange(int initialPos, int finalPos){
        Style orange = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(orange, Color.ORANGE);
        doc.setCharacterAttributes(initialPos,finalPos,orange,false);
    }
    public void paintPurple(int initialPos, int finalPos){
        Style purple = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(purple, Color.decode("#9400D3"));
        doc.setCharacterAttributes(initialPos,finalPos,purple,false);
    }
    //YYCHAR YYLENGTH
}
