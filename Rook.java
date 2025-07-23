import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

public class Rook extends Pieces {

    @Override
    protected void customizeShape() {
        Rectangle2D body = base.getBounds2D();
        double x = body.getX();
        double y = body.getY();
        double w = body.getWidth();
        double h = body.getHeight();

        Area shape = new Area();

        // Castle top blocks
        double notchW = w / 5;
        for (int i = 0; i < 3; i++) {
            Rectangle2D tower = new Rectangle2D.Double(x + i * 2 * notchW, y, notchW, h * 0.2);
            shape.add(new Area(tower));
        }

        // Body
        shape.add(new Area(new Rectangle2D.Double(x + w * 0.2, y + h * 0.2, w * 0.6, h * 0.6)));

        // Base
        shape.add(new Area(new Ellipse2D.Double(x + w * 0.2, y + h * 0.75, w * 0.6, h * 0.15)));

        base.reset();
        base.add(shape);
    }
}
