import java.util.Random;

public class Dice {
    private static int dice1;
    private static int dice2;

    public Dice(){
        dice1 = 0;
        dice2 = 0;
    }

    public static int rollDice(){
        Random random = new Random();
        dice1 = random.nextInt(6)+1;
        dice2 = random.nextInt(6)+1;
        return dice1+dice2;
    }

    public static boolean isDoublet(){
        return dice1 == dice2;
    }

    public static int getDices(){
        return dice1+dice2;
    }
}