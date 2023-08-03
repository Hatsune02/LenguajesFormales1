package frontend;

public class Node {
    private Node next;
    private char character;

    public void setNext(Node next) {this.next = next;}
    public void setCharacter(char character) {this.character = character;}
    public char getCharacter() {return character;}
    public Node getNext() {return next;}
}
