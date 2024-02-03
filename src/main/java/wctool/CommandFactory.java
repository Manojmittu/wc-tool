package wctool;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private final Map<String, Command> commandMap;

    public CommandFactory() {
        this.commandMap = new HashMap<>(4);
        this.commandMap.put("-c", new ByteCountCommand());
        this.commandMap.put("-l", new LineCountCommand());
        this.commandMap.put("-w", new WordCountCommand());
        this.commandMap.put("-m", new CharCountCommand());
    }

    public Collection<Command> getCommands() {
        return this.commandMap.values();
    }
}
