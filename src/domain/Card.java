package domain;

import java.util.Scanner;

/**
 * Card class. The Card is used to play.
 */
public class Card {
    // class declarations
    private Player owner; // who is the owner of this card (player 1 or 2)

    //primitive declarations
    private int up, down; // Y axis
    private int left, right; // X axis

    /**
     * Regular constructor to the card
     * @param up up valor
     * @param down down valor
     * @param left left valor
     * @param right right valor
     * @param owner owner of this card
     */
    public Card(int up, int down, int left, int right, Player owner) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.owner = owner;
    }

    /**
     * Constructor to the card without the presence of the owner. Means that this card has no owner yet
     * @param up up valor
     * @param down down valor
     * @param left left valor
     * @param right right valor
     */
    public Card(int up, int down, int left, int right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    /**
     * Print the card object in terminal
     */
    public void print() {
        System.out.println("+-----+\n" +
                             "|  "+ (up == 10 ? "A" : up) +"  |\n" +
                             "| "+ (left == 10 ? "A" : left) +" "+ (right == 10 ? "A" : right) +" |\n" +
                             "|  "+ (down == 10 ? "A" : down) +"  |\n" +
                             "+-----+");
    }

    /**
     * Gives the card information
     * @return return card parameters
     */
    @Override
    public String toString() {
        return "Card{" +
                "owner=" + owner.getName() +
                ", up=" + up +
                ", down=" + down +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    //General Setters
    public void setOwner(Player owner) {
        if(owner!=null)
            this.owner = owner;
        else
            throw new NullPointerException("Owner is null");
    }

    //General Getters
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

    public Player getOwner() { return owner;}
}
