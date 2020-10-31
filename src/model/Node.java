package model;

public class Node {
    private int row;
    private int column;

    private Node next;
    private Node prev;
    private Node up;
    private Node down;


    public Node(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
      return row;
    }

    public int getColumn() {
        return column;
    }

    public char getNameCol() {
        return (char)('A'+ column);
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getUp() {
        return up;
    }

    public Node getDown() {
        return down;
    }

    public void setPrev(Node p) {
        prev = p;
    }

    public void setNext(Node n) {
        next = n;
    }

    public void setUp(Node u) {
        up = u;
    }

    public void setDown(Node d) {
        down = d;
    }

    public String toString() {
        return "[ ]";
    }
}
