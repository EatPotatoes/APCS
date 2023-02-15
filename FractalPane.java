import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class FractalPane extends Pane
{
    public final static double SQ = Math.sqrt(3) / 6;
    
    //--------------------------------------------------------------------
    //  Makes an initial fractal of order 1 (a triangle) when the pane
    //  is first created.
    //--------------------------------------------------------------------
    public FractalPane()
    {
        makeFractal(1);
    }
    
    //--------------------------------------------------------------------
    //  Draws the fractal by clearing the pane and then adding three
    //  lines of the specified order between three predetermined points.
    //--------------------------------------------------------------------
    public void makeFractal(int order)
    {
        getChildren().clear();
        addLine(order, 500, 150, 500, 300);
    }
    
    //--------------------------------------------------------------------
    //  Recursively adds a line of the specified order to the fractal.
    //  The base case is a straight line between the given points.
    //  Otherwise, three intermediate points are computed and four line
    //  segments are added as a fractal of decremented order.
    //--------------------------------------------------------------------
    public void addLine(int order, double x1, double y1, double x5,
        double y5)
    {
        double x2, y2;
        
        if (order == 1)
        {
            getChildren().add(new Line(x1, y1, x5, y5));
        }
        else
        {
        	x2 = (x1 + x5 + y1 - y5) / 2;
        	y2 = (x5 + y1 + y5 - x1) / 2;
        	
        	addLine(order - 1, x1, y1, x2, y2);
        	addLine(order - 1, x2, y2, x5, y5);
        }
    }
}
