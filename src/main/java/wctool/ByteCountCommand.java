package wctool;

import java.io.File;

public class ByteCountCommand implements Command {

    @Override
    public long execute(String input) {
        return input.getBytes().length;
    }

    @Override
    public long execute(File file) {
        return file.length();
    }
}
