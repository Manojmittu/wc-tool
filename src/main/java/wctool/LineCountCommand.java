package wctool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LineCountCommand implements Command {

    @Override
    public long execute(String input) {
        return input.length() - input.replaceAll("\n", "").length() + 1;
    }

    @Override
    public long execute(File file) {
        long lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file.getPath()))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file " + e);
        }
        return lineCount;
    }
}
