package Utils;

import java.util.Random;

public class RandomGenerator {
    public static String generateRandomUsername() {
        Random randoUsername = new Random();
        return randoUsername.nextInt(1000)+ "Violeta";
    }

}
