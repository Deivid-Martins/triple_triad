package domain;

import java.util.Scanner;

public class Card {
    private String name;
    private String up, down; // eixo y
    private String left, right; // eixo X

    public Card(String name, String up, String down, String left, String right) {
        this.name = name;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public Card(String name, String[] power) {
        this.name = name;
        this.up = power[0];
        this.down = power[1];
        this.left = power[2];
        this.right = power[3];
    }

    public Card(Card card) {
        this.name = card.getName();
        this.up = card.getUp();
        this.down = card.getDown();
        this.left = card.getLeft();
        this.right = card.getRight();
    }

    public Card() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of the card: ");
        this.name = input.next();
        System.out.print("Up power: ");
        this.up = input.next();
        System.out.print("Down power: ");
        this.down = input.next();
        System.out.print("Left power: ");
        this.left = input.next();
        System.out.print("Right power: ");
        this.right = input.next();
    }

    public void printCard() {
        System.out.println(this.name);
        System.out.println("  " + this.up);
        System.out.println(this.left + "   " + this.right);
        System.out.println("  " + this.down);
    }

    public String getName() {
        return name;
    }

    public String getUp() {
        return up;
    }

    public String getDown() {
        return down;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }
}
