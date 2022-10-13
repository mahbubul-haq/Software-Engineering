import FileSum.NumericalFileSum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        NumericalFileSum numericalFileSum = new NumericalFileSum();

        if (args.length < 1) {
            System.out.println("Please provide filename");
            return;
        }

        File file = new File(args[0]);

        System.out.println("Sum: " + numericalFileSum.calculateSum(file));

    }
}