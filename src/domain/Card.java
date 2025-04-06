package domain;

import java.util.Scanner;

public class Card {
    private int up, down; // eixo y
    private int left, right; // eixo X
    private Player owner;

    public Card(int up, int down, int left, int right, Player owner) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.owner = owner;
    }

    public Card(int up, int down, int left, int right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public int getUp() {
        return up;
    }

    public int getDown() {
        return down;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void print() {
        System.out.println("+-----+\n" +
                             "|  "+ (up == 10 ? "A" : up) +"  |\n" +
                             "| "+ (left == 10 ? "A" : left) +" "+ (right == 10 ? "A" : right) +" |\n" +
                             "|  "+ (down == 10 ? "A" : down) +"  |\n" +
                             "+-----+");
    }

    @Override
    public String toString() {
        return "Card{" +
                "owner=" + owner.getName() +
                '}';
    }
}
