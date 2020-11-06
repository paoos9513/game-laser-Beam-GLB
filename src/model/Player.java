package model;

public class Player {

    private Player left;
    private Player right;
    private String nickname;
    private int points;

    public Player(String nickname, int points) {
        this.nickname = nickname;
        this.points = points;
    }

    public Player getLeft() {
        return left;
    }

    public void setLeft(Player left) {
        this.left = left;
    }

    public Player getRight() {
        return right;
    }

    public void setRight(Player right) {
        this.right = right;
    }

    public String getNickname() {
        return nickname;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

