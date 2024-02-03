package wctool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CharCountCommand implements Command {

    @Override
    public long execute(String input) {
        return input.length();
    }

    @Override
    public long execute(File file) {
        long charCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file.getPath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                charCount = charCount + execute(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file " + e);
        }
        return charCount;
    }
}
