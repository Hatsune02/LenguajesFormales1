package frontend;

import backend.Analyzer;

import java.io.FileWriter;
import java.io.PrintWriter;

public class SimpleList {
    Node first;

    public void instert(char character){
        Node newNode = new Node();
        newNode.setCharacter(character);
        if(first==null){
            first=newNode;
        }
        else{
            Node aux = first;
            while(aux.getNext()!=null){
                aux = aux.getNext();
            }
            aux.setNext(newNode);
        }
    }
    public void print(){
        Node aux = first;
        while (aux!=null){
            System.out.println();
            aux = aux.getNext();
        }

    }
    public void delete(char character){
        if(first != null){
            if(first.getCharacter()==character){
                first = first.getNext();
            }
            else{
                Node delete = first.getNext();
                Node previous = first;
                while(delete!=null){
                    if(delete.getCharacter()==character)break;
                    previous = delete;
                    delete = delete.getNext();
                }
                if(delete!=null){
                    previous.setNext(delete.getNext());
                }
            }
        }
    }
    private String graphvizList(){
        StringBuilder text = new StringBuilder("digraph G\n" +
                "{\n" +
                "\tnode [shape = circle]\n" +
                "\tnode [style = filled]\n" +
                "\tnode [fillcolor = \"#66E3D3\"]\n" +
                "\tnode [color = \"#66E3D3\"]\n" +
                "\tedge [color = \"#31CEF0\"] \n");

        Node aux = first;
        while(aux!=null){
            if(Analyzer.possibleString(aux.getCharacter()));
            else if(Analyzer.isDelimiter(aux.getCharacter())){
                text.append("\"").append(aux.getCharacter()).append("\"").append("->");
            }
            else if(Analyzer.isSpaceTab(aux.getCharacter()) || Analyzer.isLineBreak(aux.getCharacter())){
                text.append("\" \"").append("->");
            }
            else {
                text.append(aux.getCharacter()).append("->");
            }
            aux = aux.getNext();
        }
        text.deleteCharAt(text.length()-1);
        text.deleteCharAt(text.length()-1);
        String text1 = text.toString();
        text1 += "\trankdir = LR;\n" +
                "}";
        return text1;
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
    public void drawGraphviz(){

        try{
            writeFile("file.dot", graphvizList());
            ProcessBuilder process;
            process = new ProcessBuilder("dot","-Tpng","-o","token.png","file.dot");

            process.redirectErrorStream(true);
            process.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setNodes(String lexeme){
        for (int i = 0; i < lexeme.length(); i++) {
            if(lexeme.charAt(i) == (char)9 ){
                instert(lexeme.charAt((char)9));
            }
            instert(lexeme.charAt(i));
        }
    }
}