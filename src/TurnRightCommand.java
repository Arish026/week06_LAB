public class TurnRightCommand implements Command {
    public void execute(Pen pen) {
        pen.turnRight();
    }
}