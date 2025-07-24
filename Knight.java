import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Ellipse2D;

public class Knight extends Pieces {

    @Override
    protected void customizeShape() {
        Rectangle2D body = base.getBounds2D();
        double x = body.getX(), y = body.getY();
        double w = body.getWidth(), h = body.getHeight();

        Area shape = new Area();

        // Main horse silhouette (head and neck)
        Path2D horse = new Path2D.Double();
        horse.moveTo(x + w * 0.3, y + h * 0.84);                            // base back of neck
        horse.curveTo(x + w * 0.2, y + h * 0.6,
                      x + w * 0.25, y + h * 0.3,
                      x + w * 0.45, y + h * 0.12);                         // top back of head

        // Ear
        horse.lineTo(x + w * 0.44, y + h * 0.035);                         // ear start
        horse.lineTo(x + w * 0.50, y + h * 0.08);                          // ear tip
        horse.lineTo(x + w * 0.48, y + h * 0.13);                          // ear end

        // Forehead and snout
        horse.lineTo(x + w * 0.63, y + h * 0.18);
        horse.lineTo(x + w * 0.72, y + h * 0.3);                           // snout tip
        horse.lineTo(x + w * 0.62, y + h * 0.38);                          // under snout

        // Jaw and neck
        horse.curveTo(x + w * 0.55, y + h * 0.48,
                      x + w * 0.5, y + h * 0.58,
                      x + w * 0.45, y + h * 0.65);

        horse.curveTo(x + w * 0.4, y + h * 0.75,
                      x + w * 0.35, y + h * 0.8,
                      x + w * 0.3, y + h * 0.84);                          // connect back

        horse.closePath();
        shape.add(new Area(horse));

        // Eye
        shape.add(new Area(new Ellipse2D.Double(x + w * 0.58, y + h * 0.25, w * 0.025, h * 0.025)));

        // Square pedestal block below horse neck with a small gap
        double pedestalY = y + h * 0.85;          // slightly below horse bottom
        double pedestalHeight = h * 0.06;
        double pedestalWidth = w * 0.5;
        double pedestalX = x + w * 0.25;

        shape.add(new Area(new Rectangle2D.Double(pedestalX, pedestalY, pedestalWidth, pedestalHeight)));

        // Square-ish base below pedestal
        shape.add(new Area(new RoundRectangle2D.Double(x + w * 0.22, y + h * 0.92, w * 0.56, h * 0.2, w * 0.05, h * 0.02)));

        shape.add(new Area(new Rectangle((int) (x + w * 0.23), (int) (y + h * 0.6), (int) (w * 0.3),(int) (h * 0.4))));


        base.reset();
        base.add(shape);
    }
}
