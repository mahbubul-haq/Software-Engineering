import TeaGasSys.NewSystem;
import TeaGasSys.SystemBuilder;
import com.sun.javafx.css.parser.LadderConverter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SystemBuilder systemBuilder = new SystemBuilder();
        Scanner scanner = new Scanner(System.in);

        NewSystem mySystem = systemBuilder.getNewSystem();
        if (mySystem != null) {
            while (true) {
                System.out.println("Please enter option number");
                System.out.println("1. showController, 2. showFramework, 3. showInternet, 4. measureWeight");
                System.out.println("5. showDisplay, 6. showIdentification, 7. showStorage");
                System.out.println("8. showMicroControllerType, 9.showServerInfo, 10. showSystem");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        mySystem.showController();
                        break;
                    case 2:
                        mySystem.showFramework();
                        break;
                    case 3:
                        mySystem.showInternet();
                        break;
                    case 4:
                        mySystem.measureWeight();
                        break;
                    case 5:
                        mySystem.showDisplay();
                        break;
                    case 6:
                        mySystem.showIdentification();
                        break;
                    case 7:
                        mySystem.showStorage();
                        break;
                    case 8:
                        mySystem.showMicroControllerType();
                        break;
                    case 9:
                        mySystem.showServerInfo();
                        break;
                    case 10:
                        mySystem.showSystem();
                        break;
                    default:
                        option = 100;
                        break;
                }
                if (option == 100) break;
            }

        }
    }
}