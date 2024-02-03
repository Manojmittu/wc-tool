package wctool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WordCountCommand implements Command {

    @Override
    public long execute(String input) {
        return input.length() - input.replaceAll(" ", "").length() + 1;
    }

    @Override
    public long execute(File file) {
        long wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file.getPath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordCount = wordCount + execute(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file " + e);
        }
        return wordCount;
    }
}
