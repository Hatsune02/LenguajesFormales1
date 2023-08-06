package frontend;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CreateHTML {
    private String content(){
        return "<html>\n" +
                "<body>\n" +
                "    <img src=\"token.png\">\n" +
                "</body>\n" +
                "</html>";
    }
    private void writeFile(String dir, String content){
        FileWriter file = null;
        PrintWriter pw = null;

        try{
            file = new FileWriter(dir);
            pw = new PrintWriter(file);
            pw.write(content);
            pw.close();
            file.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if(pw!=null) pw.close();
        }
    }

    public void createFile(){
        try{
            writeFile("file.html", content());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showHTML(JEditorPane panel){
        createFile();
        File rec = new File("file.html");
        panel.setEditable(false);
        try {
            panel.setPage(rec.toURI().toURL());
        }catch (Exception e){}
    }
}
