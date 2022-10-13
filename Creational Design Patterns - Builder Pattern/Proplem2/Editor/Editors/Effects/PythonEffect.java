package Editor.Editors.Effects;

public class PythonEffect implements Effect{
    @Override
    public void showColor() {
        System.out.println("Font Color: Blue");
    }
    @Override
    public void showFont() {
        System.out.println("Font: Consolas");
    }
    @Override
    public void showStyle() {
        System.out.println("Style: normal");
    }
}
