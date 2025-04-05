package domain;

import java.util.Scanner;

public class Card {
    private String name;
    private int up, down; // eixo y
    private int left, right; // eixo X
    private Player owner;

    public Card(String name, int up, int down, int left, int right, Player owner) {
        this.name = name;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.owner = owner;
    }

    public String getName() {
        return name;
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
}
