package Editor.Editors;

import Editor.Editors.Effects.CEffect;
import Editor.Editors.Effects.Effect;
import Editor.Editors.Parsers.Cparser;
import Editor.Editors.Parsers.Parser;

public class SetupCEditor implements SetupEditor {

    @Override
    public Parser getParser() {
        return new Cparser();
    }

    @Override
    public Effect getEffect() {
        return new CEffect();
    }
}
