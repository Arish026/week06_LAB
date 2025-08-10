public class TurnLeftCommand implements Command {
    public void execute(Pen pen) {
        pen.turnLeft();
    }
}