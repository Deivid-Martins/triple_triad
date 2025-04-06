package utils;

import java.util.Scanner;

public abstract class Tool {
    public static int nextIntLim(Scanner input, int min, int max) {
        int x = input.nextInt();
        while(x < min || x > max) {
            System.err.println("Valor incorreto! Digite um numero entre " + min + " e " + max);
            x = input.nextInt();
        }

        return x;
    }
}
