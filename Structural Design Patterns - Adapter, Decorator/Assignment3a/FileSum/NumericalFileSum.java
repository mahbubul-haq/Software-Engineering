package FileSum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumericalFileSum implements FileSum{
    private FileAdapter fileAdapter;

    @Override
    public int calculateSum(File file) {

        int currentValue, sum = 0;

        if (isNumericalContent(file)) {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    String data = scanner.next();

                    try {
                        currentValue = Integer.parseInt(data);
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
        else {
            fileAdapter = new FileAdapter();
            return fileAdapter.calculateSum(file);
        }

    }

    private boolean isNumericalContent(File file) {
        int temp;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String data = scanner.next();

                try {
                    temp = Integer.parseInt(data);
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            return true;

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
            return false;
        }

    }
}
