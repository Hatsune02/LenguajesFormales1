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
    public void paintBlue(int position, int length){
        Style blue = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(blue, Color.BLUE);
        doc.setCharacterAttributes(position,length,blue,false);
    }
    public void paintRed(int position, int length){
        Style red = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(red, Color.RED);
        doc.setCharacterAttributes(position,length,red,false);
    }
    public void paintYellow(int position, int length){
        Style yellow = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(yellow, Color.YELLOW);
        doc.setCharacterAttributes(position,length,yellow,false);
    }
    public void paintSkyBlue(int position, int length){
        Style skyBlue = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(skyBlue, Color.decode("0x2ECCFA"));
        doc.setCharacterAttributes(position,length,skyBlue,false);
    }
    public void paintCyan(int position, int length){
        Style cyan = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(cyan, Color.CYAN);
        doc.setCharacterAttributes(position,length,cyan,false);
    }
    public void paintMagenta(int position, int length){
        Style magenta = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(magenta, Color.MAGENTA);
        doc.setCharacterAttributes(position,length,magenta,false);
    }
    public void paintGray(int position, int length){
        Style gray = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(gray, Color.GRAY);
        doc.setCharacterAttributes(position,length,gray,false);
    }
    public void paintGreen(int position, int length){
        Style green = sc.addStyle("ConstantWidth", null); //#088A29
        StyleConstants.setForeground(green, Color.GREEN);
        doc.setCharacterAttributes(position,length,green,false);
    }
    public void paintLightGreen(int position, int length){
        Style lightGreen = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(lightGreen, Color.decode("0x86B404"));
        doc.setCharacterAttributes(position,length,lightGreen,false);
    }
    public void paintOrange(int position, int length){
        Style orange = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(orange, Color.ORANGE);
        doc.setCharacterAttributes(position,length,orange,false);
    }
    public void paintPurple(int position, int length){
        Style purple = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(purple, Color.decode("0x9400D3"));
        doc.setCharacterAttributes(position,length,purple,false);
    }
    //YYCHAR YYLENGTH
}
