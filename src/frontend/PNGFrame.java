package frontend;

import javax.swing.*;
import java.awt.*;

public class PNGFrame {
    JFrame frame;
    JScrollPane scroll;

    public void init(JEditorPane png){
        frame = new JFrame();

        frame.setLayout(new BorderLayout());
        frame.setSize(500,300);
        frame.setLocationRelativeTo(null);

        scroll = new JScrollPane(png);
        frame.add(BorderLayout.CENTER, scroll);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
