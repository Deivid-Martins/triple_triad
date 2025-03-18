package domain;

import java.util.Scanner;

public class Card {
    private String name;
    private final Integer up, down; // eixo y
    private final Integer left, right; // eixo X

    public Card(String name, int up, int down, int left, int right) {
        this.name = name;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public Card(int[] power) {
        this.name = name;
        this.up = power[0];
        this.down = power[1];
        this.left = power[2];
        this.right = power[3];
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
}
