import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public class Bishop extends Pieces {

    @Override
    protected void customizeShape() {
        Rectangle2D body = base.getBounds2D();
        double x = body.getX();
        double y = body.getY();
        double w = body.getWidth();
        double h = body.getHeight();

        Area shape = new Area();

        // Teardrop body
        Ellipse2D top = new Ellipse2D.Double(x + w * 0.2, y + h * 0.1, w * 0.6, h * 0.6);
        shape.add(new Area(top));

        // Base
        Rectangle2D baseRect = new Rectangle2D.Double(x + w * 0.3, y + h * 0.65, w * 0.4, h * 0.2);
        shape.add(new Area(baseRect));

        // Slash
        Path2D slash = new Path2D.Double();
        slash.moveTo(x + w * 0.4, y + h * 0.15);
        slash.lineTo(x + w * 0.6, y + h * 0.55);
        slash.lineTo(x + w * 0.6 + 3, y + h * 0.55);
        slash.lineTo(x + w * 0.4 + 3, y + h * 0.15);
        slash.closePath();

        shape.subtract(new Area(slash));
        base.reset();
        base.add(shape);
    }
}
