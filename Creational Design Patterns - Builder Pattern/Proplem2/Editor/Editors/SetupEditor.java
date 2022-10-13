package Editor.Editors;

import Editor.Editors.Effects.Effect;
import Editor.Editors.Parsers.Parser;

public interface SetupEditor {
    public Parser getParser();
    public Effect getEffect();
}
