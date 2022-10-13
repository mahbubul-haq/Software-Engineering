package Editor.Editors.Effects;

public class CEffect implements Effect{
    @Override
    public void showColor() {
        System.out.println("Font Color: Blue");
    }
    @Override
    public void showFont() {
        System.out.println("Font: Courier New");
    }
    @Override
    public void showStyle() {
        System.out.println("Style: normal");
    }
}
