package pl.game;

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DiceGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of eyelets in your dice:");

        while (sc.hasNextLine()) {
            if (sc.next().matches("[\\d]{1,2}")) break;
            else System.out.println("Enter the number of eyelets in your dice:");
        }

        String value = sc.nextLine();

        int roll = roll("D" + value + "-2");
        System.out.println("Score: " + roll);
    }

    static int roll(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input, "D+-");
        int x = 1;
        if (!input.startsWith("D")) {
            x = Integer.parseInt(tokenizer.nextToken());
        }
        int y = Integer.parseInt(tokenizer.nextToken());
        int z = 0;
        if (tokenizer.hasMoreTokens()) {
            z = Integer.parseInt(tokenizer.nextToken());
            if (input.contains("-")) {
                z = -z;
            }
        }
        int sum = 0;
        Random random = new Random();
        for (int i = 0; i < x; i++) {
            sum += random.nextInt(y) + 1;
        }
        return Math.max(0, sum + z);
    }

}
