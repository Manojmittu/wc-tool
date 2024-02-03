package wctool;

import java.io.File;

public interface Command {

    long execute(String input);

    long execute(File file);
}
