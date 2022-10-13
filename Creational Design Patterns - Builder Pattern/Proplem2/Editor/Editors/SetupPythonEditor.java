package Editor.Editors;

import Editor.Editors.Effects.Effect;
import Editor.Editors.Effects.PythonEffect;
import Editor.Editors.Parsers.Parser;
import Editor.Editors.Parsers.PythonParser;

public class SetupPythonEditor implements SetupEditor {

    @Override
    public Parser getParser() {
        return new PythonParser();
    }

    @Override
    public Effect getEffect() {
        return new PythonEffect();
    }
}
