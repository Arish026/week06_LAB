import javafx.scene.canvas.GraphicsContext;

public class Pen {
    private double x, y;
    private double angle;
    private GraphicsContext gc;

    public Pen(double x, double y, GraphicsContext gc) {
        this.x = x;
        this.y = y;
        this.angle = 0; // Facing right
        this.gc = gc;
    }

    public void moveForward() {
        double rad = Math.toRadians(angle);
        double newX = x + Math.cos(rad) * 50;
        double newY = y + Math.sin(rad) * 50;

        gc.strokeLine(x, y, newX, newY);
        x = newX;
        y = newY;
    }

    public void turnRight() {
        angle -= 90;
    }

    public void turnLeft() {
        angle += 90;
    }
}