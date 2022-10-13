package Editor;

import Editor.Editors.SetupEditor;

public class Editor {
    private static Editor editor = null;
    private SetupEditor editorSetup;

    private Editor(){
    }
    private Editor(SetupEditor editorSetup) {
        this.editorSetup = editorSetup;
    }

    public void setupEditor(SetupEditor editorSetup) {
        this.editorSetup = editorSetup;

    }

    public static Editor getEditor(SetupEditor neweditorSetup) {
        if (editor == null) {
            editor = new Editor(neweditorSetup);
        }
        return editor;
    }

    public static Editor getEditor() {
        if (editor == null) {
            editor = new Editor();
        }
        return editor;
    }

    public void showEditor() {
        if (editorSetup != null) {
            editorSetup.getParser().showParser();
            editorSetup.getEffect().showColor();
            editorSetup.getEffect().showFont();
            editorSetup.getEffect().showStyle();
        }
    }
}
