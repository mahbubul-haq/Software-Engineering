package Editor.Editors.Effects;

public class CPPEffect implements Effect{
    @Override
    public void showColor() {
        System.out.println("Font Color: Blue");
    }
    @Override
    public void showFont() {
        System.out.println("Font: Monaco");
    }
    @Override
    public void showStyle() {
        System.out.println("Style: normal");
    }
}
