public class ForwardCommand implements Command {
    public void execute(Pen pen) {
        pen.moveForward();
    }
}