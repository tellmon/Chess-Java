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

    // Base body (vertical rectangle in center)
    shape.add(new Area(new Rectangle2D.Double(cx - w * 0.2, y + h * 0.3, w * 0.4, h * 0.5)));

    // Cross - vertical part
    double crossHeight = h * 0.18;
    double crossWidth = w * 0.08;
    double crossY = y + h * 0.08;

    shape.add(new Area(new Rectangle2D.Double(cx - crossWidth / 2, crossY, crossWidth, crossHeight)));

    // Cross - horizontal part
    double horizWidth = w * 0.18;
    double horizHeight = h * 0.05;
    double horizY = crossY + crossHeight / 2 - horizHeight / 2;

    shape.add(new Area(new Rectangle2D.Double(cx - horizWidth / 2, horizY, horizWidth, horizHeight)));

    // Base ellipse (at bottom)
    shape.add(new Area(new Ellipse2D.Double(cx - w * 0.3, y + h * 0.75, w * 0.6, h * 0.15)));

    base.reset();
    base.add(shape);
}

}
