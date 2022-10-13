package Editor.Editors;

import Editor.Editors.Effects.CPPEffect;
import Editor.Editors.Effects.Effect;
import Editor.Editors.Parsers.CPPparser;
import Editor.Editors.Parsers.Parser;

public class SetupCPPEditor implements SetupEditor {

    @Override
    public Parser getParser() {
        return new CPPparser();
    }

    @Override
    public Effect getEffect() {
        return new CPPEffect();
    }
}
