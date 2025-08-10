import java.util.ArrayList;
import java.util.List;

public class CommandParser {
    public static List<Command> parse(String instructions) {
        List<Command> commands = new ArrayList<>();

        for (char ch : instructions.toCharArray()) {
            switch (ch) {
                case 'F':
                    commands.add(new ForwardCommand());
                    break;
                case '+':
                    commands.add(new TurnRightCommand());
                    break;
                case '-':
                    commands.add(new TurnLeftCommand());
                    break;
                default:
                    System.out.println("Unknown command: " + ch);
            }
        }

        return commands;
    }
}