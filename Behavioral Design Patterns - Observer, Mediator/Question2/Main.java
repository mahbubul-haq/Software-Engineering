import ServiceOrganizations.JCC;
import ServiceOrganizations.Organizations.*;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        JCC jcc;
        JPDC jpdc = new JPDC();
        JWSA jwsa = new JWSA();
        JRTA jrta = new JRTA();
        JTRC jtrc = new JTRC();

        String command;
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("Exit"))
            {
                break;
            }
            else if (command.equalsIgnoreCase("Init"))
            {
                jcc = new JCC(jpdc, jrta, jtrc, jwsa);
                System.out.println("All four services are initiated through mediator");
            }
            else
            {
                StringTokenizer st = new StringTokenizer(command);
                String org = st.nextToken();
                String commandType = st.nextToken();

                if (commandType.equalsIgnoreCase("Serve"))
                {
                    if (org.equalsIgnoreCase("JSWA"))
                    {
                        jwsa.proviceService();
                    }
                    else if (org.equalsIgnoreCase("JRTA"))
                    {
                        jrta.proviceService();
                    }
                    else if (org.equalsIgnoreCase("JPDC"))
                    {
                        jpdc.proviceService();
                    }
                    else if (org.equalsIgnoreCase("JTRC"))
                    {
                        jtrc.proviceService();
                    }
                }
                else
                {
                    if (org.equalsIgnoreCase("JWSA"))
                    {
                        jwsa.requestService(commandType);
                    }
                    else if (org.equalsIgnoreCase("JRTA"))
                    {
                        jrta.requestService(commandType);
                    }
                    else if (org.equalsIgnoreCase("JPDC"))
                    {
                        jpdc.requestService(commandType);
                    }
                    else if (org.equalsIgnoreCase("JTRC"))
                    {
                        jtrc.requestService(commandType);
                    }
                }
            }
        }


    }
}