import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class King extends Pieces {

    @Override
    protected void customizeShape() {
        Rectangle2D body = base.getBounds2D();
        double cx = body.getCenterX();
        double y = body.getY();
        double h = body.getHeight();
        double w = body.getWidth();

        Area shape = new Area();

        // Base body
        shape.add(new Area(new Rectangle2D.Double(cx - w * 0.2, y + h * 0.3, w * 0.4, h * 0.5)));

        // Cross
        shape.add(new Area(new Rectangle2D.Double(cx - 2, y + h * 0.05, 4, h * 0.1)));
        shape.add(new Area(new Rectangle2D.Double(cx - 5, y + h * 0.1, 10, 4)));

        // Base ellipse
        shape.add(new Area(new Ellipse2D.Double(cx - w * 0.3, y + h * 0.75, w * 0.6, h * 0.15)));

        base.reset();
        base.add(shape);
    }
}
