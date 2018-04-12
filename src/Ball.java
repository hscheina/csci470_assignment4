import java.awt.*;

public class Ball {
    private Color color; //color of the ball
    private int radius; //radius of the ball in int
    private int x,y; // coordinates of the ball's center point(integer)
    private int dx, dy; //amount of change in the ball's x/y coordinate each time a ball moves
                        // negative val means ball is moving left/up.
                        // positive val means ball is moving right/down
    //default constructor
    public Ball(){

    }

    public Ball(Color c, int r, int x, int y, int dx, int dy){
        color = c;
        radius = r;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public void move(Dimension d){
        if( x <= radius || d.width <= x )   //change direction of the ball if x is bigger than panel width or its radius
            dx *= -1;

        if( y <= radius || d.height <= y)
            dy *= -1;
        x += dx;
        y += dy;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x,y,radius * 2, radius * 2);
    }
}
