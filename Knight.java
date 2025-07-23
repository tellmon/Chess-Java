import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

public class Knight extends Pieces {

    @Override
    protected void customizeShape() {
        Rectangle2D body = base.getBounds2D();
        double x = body.getX(), y = body.getY();
        double w = body.getWidth(), h = body.getHeight();

        Area shape = new Area();

        // Neck
        shape.add(new Area(new Rectangle2D.Double(x + w * 0.4, y + h * 0.45, w * 0.2, h * 0.4)));

        // Forehead curve (upper ellipse)
        shape.add(new Area(new Ellipse2D.Double(x + w * 0.35, y + h * 0.2, w * 0.3, h * 0.2)));

        // Snout + head extension (polygon)
        Path2D head = new Path2D.Double();
        head.moveTo(x + w * 0.45, y + h * 0.25);                 // forehead base
        head.lineTo(x + w * 0.65, y + h * 0.35);                 // snout tip
        head.lineTo(x + w * 0.55, y + h * 0.45);                 // lower jaw
        head.lineTo(x + w * 0.4, y + h * 0.4);                   // connect to neck
        head.closePath();
        shape.add(new Area(head));

        shape.add(new Area(new Ellipse2D.Double(x + w * 0.3, y + h * 0.75, w * 0.4, h * 0.15)));

        base.reset();
        base.add(shape);
    }

}
