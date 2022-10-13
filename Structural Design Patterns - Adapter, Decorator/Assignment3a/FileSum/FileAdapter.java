package FileSum;

import java.io.File;

public class FileAdapter implements FileSum{
    private CharacterFileSum characterFileSum = null;

    public FileAdapter() {
        characterFileSum = new CharacterFileSum();
    }

    @Override
    public int calculateSum(File file) {
        return characterFileSum.calculateSum(file);
    }
}
