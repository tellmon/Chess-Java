import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public class Queen extends Pieces {

    @Override
    protected void customizeShape() {
        Rectangle2D body = base.getBounds2D();
        double x = body.getX();
        double y = body.getY();
        double w = body.getWidth();
        double h = body.getHeight();

        Area shape = new Area();

        // Crown base
        shape.add(new Area(new Rectangle2D.Double(x + w * 0.2, y + h * 0.4, w * 0.6, h * 0.5)));

        //Crown spikes and orbs
        for (int i = 0; i < 3; i++) {
            double cx = x + w * (0.25 + i * 0.25);
            // Orb
            shape.add(new Area(new Ellipse2D.Double(cx - 3, y + h * 0.25, 6, 6)));
            // Spike
            Path2D spike = new Path2D.Double();
            spike.moveTo(cx, y + h * 0.4);
            spike.lineTo(cx - 5, y + h * 0.28);
            spike.lineTo(cx + 5, y + h * 0.28);
            spike.closePath();
            shape.add(new Area(spike));
        }

        // Larger base
        shape.add(new Area(new Ellipse2D.Double(x + w * 0.2, y + h * 0.6, w * 0.6, h * 0.15)));

        base.reset();
        base.add(shape);
    }
}
