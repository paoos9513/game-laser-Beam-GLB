package model;

public class Node {
    private int row;
    private int column;

    private Node next;
    private Node prev;
    private Node up;
    private Node down;

    private String mirror = "";
    private String mark = " ";
    public String direction = "";


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
    public String getId() {
        return ""+(getRow()+1)+getNameCol()+"";
    }

    public void setUp(Node u) {
        up = u;
    }

    public void setDown(Node d) {
        down = d;
    }

    public void addMirror(String content) {
        this.mirror = content;
    }

    public String getMirror() {
        return mirror;
    }

    public String getMark() {
        return mark;
    }

    public String getDirection() {
        return direction;
    }

    public void setMirror(String mirror) {
        this.mirror = mirror;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
    public String toString() {
        return "["+mark+direction+"]";
    }
    public String toStringTest() {
        return "["+(getRow()+1)+getNameCol()+"]";
    }
}
