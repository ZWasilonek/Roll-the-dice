package pl.game;

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DiceGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of dices:");
        int numberOfDice = getDiceNumbers(sc);

        System.out.println("Enter the number of eyelets in your dice: 3, 4, 6, 8, 10, 12, 20 or 100");
        String eyeletsOfDice = getEyeletsOfDice(sc);

        System.out.println("Enter the number of points to subtract, e.g. \"-2\" or added, e.g. \"+2\"");
        String points = getPoints(sc);

        String scoreFragment = "D" + eyeletsOfDice + points;
        String scoreCode = numberOfDice == 1 ? scoreFragment : numberOfDice + scoreFragment;
        int roll = roll(scoreCode);
        System.out.println("Score: " + roll);
    }

    private static String getPoints(Scanner sc) {
        String points = null;
        while (sc.hasNextLine()) {
            points = sc.next();
            if (points.matches("^[+-]\\d+$")) break;
            else System.out.println("Enter the number of points to subtract, e.g. \"-2\" or added, e.g. \"+2\"");
        }
        return points;
    }

    private static String getEyeletsOfDice(Scanner sc) {
        String value = null;
        while (sc.hasNextLine()) {
            value = sc.next();
            if (value.matches("^(3|4|6|8|10|12|20|100)$")) break;
            else
                System.out.println("The number of eyelets in the dice allowed is 3, 4, 6, 8, 10, 12, 20 or 100");
        }
        return value;
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
            if (input.contains("-"))
                z = -z;
        }
        int sum = 0;
        Random random = new Random();
        for (int i = 0; i < x; i++) {
            sum += random.nextInt(y) + 1;
        }
        return Math.max(0, sum + z);
    }

    static int getDiceNumbers(Scanner sc) {
        int dices = 0;
        while (sc.hasNextLine()) {
            String dicesNum = sc.next();
            if (dicesNum.matches("\\d+")) {
                dices = Integer.parseInt(dicesNum);
                if (dices > 4 || dices < 1)
                    System.out.println("The allowed number of dice is 1 - 4");
                else break;
            } else
                System.out.println("It's not a number. Enter the number of dice");
        }
        return dices;
    }

}