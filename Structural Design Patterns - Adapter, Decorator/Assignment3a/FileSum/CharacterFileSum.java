package FileSum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharacterFileSum {

    private int currentValue, sum = 0;

    public int calculateSum(File file) {

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String data = scanner.next();

                try {
                    currentValue = (int) data.charAt(0);
                    sum += currentValue;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        return sum;
    }
}
