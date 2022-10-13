import Editor.Editor;
import Editor.Editors.SetupCEditor;
import Editor.Editors.SetupCPPEditor;
import Editor.Editors.SetupPythonEditor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Editor editor = Editor.getEditor();

        while(true) {
            System.out.println("Please enter filename with proper extension(.c, .cpp, .py), 'q' to quit: ");
            String filename = scanner.nextLine();

            if (filename.endsWith(".c")) {
                editor.setupEditor(new SetupCEditor());
            }
            else if (filename.endsWith(".cpp")) {
                editor.setupEditor(new SetupCPPEditor());
            }
            else if (filename.endsWith(".py")) {
                editor.setupEditor(new SetupPythonEditor());
            }
            else if (filename.equalsIgnoreCase("q")) break;
            else {
                System.out.println("Wrong file name");
            }

            editor.showEditor();


        }

    }
}