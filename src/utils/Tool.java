package utils;

import java.util.Scanner;

/**
 * Tool class is a general use class. It's very useful to store a lor of methods that could be used without a specific case.
 */
public abstract class Tool {
    /**
     * Method to limit the input of and integer
     * @param input Scanner that will be used
     * @param min int minimun number
     * @param max int maximun number
     * @return an int beetwen min and max
     */
    public static int nextIntLim(Scanner input, int min, int max) {
        int x = input.nextInt();

        while(x < min || x > max) {
            System.err.println("Valor incorreto! Tente um numero entre " + min + " e " + max + ": ");
            x = input.nextInt();
        }

        return x;
    }
}
