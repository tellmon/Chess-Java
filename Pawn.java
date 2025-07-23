import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Pawn extends Pieces {

    @Override
    protected void customizeShape() {
        Rectangle2D body = base.getBounds2D();
        double cx = body.getCenterX();
        double topY = body.getMinY();
        double h = body.getHeight();
        double w = body.getWidth();

        Area shape = new Area();

        // Head (circle)
        double headRadius = w * 0.2;
        shape.add(new Area(new Ellipse2D.Double(
            cx - headRadius,
            topY + h * 0.1,
            headRadius * 2,
            headRadius * 2
        )));

        // Neck
        shape.add(new Area(new Rectangle2D.Double(
            cx - headRadius * 0.3,
            topY + h * 0.25,
            headRadius * 0.6,
            h * 0.05
        )));

        // Body (dome shape)
        shape.add(new Area(new Ellipse2D.Double(
            cx - w * 0.25,
            topY + h * 0.3,
            w * 0.5,
            h * 0.3
        )));

        // Base
        shape.add(new Area(new Rectangle2D.Double(
            cx - w * 0.2,
            topY + h * 0.6,
            w * 0.4,
            h * 0.3
        )));

        base.reset();
        base.add(shape);
    }
}
