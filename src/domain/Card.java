package domain;

import java.util.Scanner;

public class Card {
    private String name;
    private Integer up, down; // eixo y
    private Integer left, right; // eixo X

    public Card(String name, int up, int down, int left, int right) {
        this.name = name;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public Card(String name, int[] power) {
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
        this.up = input.nextInt();
        System.out.print("Down power: ");
        this.down = input.nextInt();
        System.out.print("Left power: ");
        this.left = input.nextInt();
        System.out.print("Right power: ");
        this.right = input.nextInt();
    }

    public String getName() {
        return name;
    }

    public Integer getUp() {
        return up;
    }

    public Integer getDown() {
        return down;
    }

    public Integer getLeft() {
        return left;
    }

    public Integer getRight() {
        return right;
    }
}
