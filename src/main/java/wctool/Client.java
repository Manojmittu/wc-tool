package wctool;

// >ccwc -c test.txt
//  342190 test.txt
// >ccwc -l test.txt
//    7145 test.txt
// >ccwc -w test.txt
//   58164 test.txt
// >wc -m test.txt
//  339292 test.txt
//
//>ccwc -m test.txt
//  339292 test.txt
// >ccwc test.txt
//    7145   58164  34  2190 test.txt
// >cat test.txt | ccwc -l
//    7145

import java.io.File;
import java.util.Collection;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        System.out.println("Welcome to ccwc playground..");
        System.out.println("ccwc -c filname.extension, provides no of bytes");
        System.out.println("ccwc -l filname.extension, provides no of lines");
        System.out.println("ccwc -w filname.extension, provides no of words");
        System.out.println("ccwc -m filname.extension, provides no of chars");
        System.out.println("ccwc filname.extension, provides all the above details");
        System.out.println("cat filname.extension | ccwc -l, provides no of lines");
        System.out.println("Press 0 to exit..");

        CommandFactory commandFactory = new CommandFactory();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();

            if (command.startsWith("cat")) {
            } else if (command.startsWith("ccwc")) {
                // File Mode
                String[] arguments = command.split(" ");

                if (arguments.length > 2) {
                    String fileName = arguments[2].trim();
                    String instruction = arguments[1].trim();
                    File input = new File(fileName);
                    Command commandObj;
                    switch (instruction) {
                        case "-c":
                            commandObj = new ByteCountCommand();
                            break;
                        case "-l":
                            commandObj = new LineCountCommand();
                            break;
                        case "-w":
                            commandObj = new WordCountCommand();
                            break;
                        case "-m":
                            commandObj = new CharCountCommand();
                            break;
                        default:
                            System.out.println("Invalid Instruction");
                            commandObj = null;
                    }
                    long count = commandObj.execute(input);
                    System.out.println(count);
                } else if (arguments.length == 2) {
                    String fileName = arguments[1];
                    File input = new File(fileName);
                    Collection<Command> commands = commandFactory.getCommands();
                    for (Command commandObj : commands) {
                        System.out.print(commandObj.execute(input) + " ");
                    }
                    System.out.println();
                }

            } else if (command.equals("0")) {
                break;
            } else {
                System.out.println("Invalid command");
            }
        }
    }
}
