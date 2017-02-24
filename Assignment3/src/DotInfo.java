
/**
 * The class <b>DotInfo</b> is a simple helper class to store the initial color and state
 * (captured or not) at the dot position (x,y)
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class DotInfo {


// ADD YOUR INSTANCE VARIABLES HERE

    private static int x, y, color;
    private static boolean captured;



    /**
     * Constructor 
     * 
     * @param x
     *            the x coordinate
     * @param y
     *            the y coordinate
     * @param color
     *            the initial color
     */
    public DotInfo(int x, int y, int color){

// ADD YOUR CODE HERE
        this.x = x;
        this.y = y;
        this.color = color;

    }

    /**
     * Getter method for the attribute x.
     * 
     * @return the value of the attribute x
     */
    public int getX(){

// ADD YOUR CODE HERE
        return x;

    }
    
    /**
     * Getter method for the attribute y.
     * 
     * @return the value of the attribute y
     */
    public int getY(){

// ADD YOUR CODE HERE
        return y;

    }
    
 
    /**
     * Setter for captured
     * @param captured
     *            the new value for captured
     */
    public void setCaptured(boolean captured) {

// ADD YOUR CODE HERE
        this.captured = captured;

    }

    /**
     * Get for captured
     *
     * @return captured0000
     */
    public boolean isCaptured(){

// ADD YOUR CODE HERE
        return captured;

    }

    /**
     * Get for color
     *
     * @return color
     */
    public int getColor() {

// ADD YOUR CODE HERE
        return color;

    }

 }
