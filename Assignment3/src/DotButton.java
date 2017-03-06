// ADD YOUR IMPORTS HERE

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * In the application <b>FloodIt</b>, a <b>DotButton</b> is a specialized color of
 * <b>JButton</b> that represents a dot in the game. It can have one of six colors
 * 
 * The icon images are stored in a subdirectory ``data''. We have 3 sizes, ``normal'',
 * ``medium'' and ``small'', respectively in directory ``N'', ``M'' and ``S''.
 *
 * The images are 
 * ball-0.png => grey icon
 * ball-1.png => orange icon
 * ball-2.png => blue icon
 * ball-3.png => green icon
 * ball-4.png => purple icon
 * ball-5.png => red icon
 *
 *  <a href=
 * "http://developer.apple.com/library/safari/#samplecode/Puzzler/Introduction/Intro.html%23//apple_ref/doc/uid/DTS10004409"
 * >Based on Puzzler by Apple</a>.
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class DotButton extends JButton {


// ADD YOUR INSTANCE VARIABLES HERE
    private int row, column, color, iconSize;
    private String[] balls = {"data/S/ball-0.png", "data/S/ball-1.png", "data/S/ball-2.png", "data/S/ball-3.png", "data/S/ball-4.png", "data/S/ball-5.png"};


    /**
     * Constructor used for initializing a cell of a specified color.
     * 
     * @param row
     *            the row of this Cell
     * @param column
     *            the column of this Cell
     * @param color
     *            specifies the color of this cell
     * @param iconSize
     *            specifies the size to use, one of SMALL_SIZE, MEDIUM_SIZE or MEDIUM_SIZE
     */

    public DotButton(int row, int column, int color, int iconSize) {

// ADD YOUR CODE HERE
        this.row = row;
        this.column = column;
        this.color = color;
        this.iconSize = iconSize;

        setBackground(Color.WHITE);

        try {
            Image image = ImageIO.read(getClass().getResource(balls[color]));
            setIcon(new ImageIcon(image));
        } catch (IOException e) {
            e.printStackTrace();
        }



   }

 /**
     * Other constructor used for initializing a cell of a specified color.
     * no row or column info available. Uses "-1, -1" for row and column instead
     * 
     * @param color
     *            specifies the color of this cell
     * @param iconSize
     *            specifies the size to use, one of SMALL_SIZE, MEDIUM_SIZE or MEDIUM_SIZE
     */   
    public DotButton(int color, int iconSize) {

// ADD YOUR CODE HERE
        this.color = color;
        this.iconSize = iconSize;

        setBackground(Color.WHITE);

        try {
            Image image = ImageIO.read(getClass().getResource(balls[color]));
            setIcon(new ImageIcon(image));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
 


    /**
     * Changes the cell color of this cell. The image is updated accordingly.
     * 
     * @param color
     *            the color to set
     */

    public void setColor(int color) {

// ADD YOUR CODE HERE
        this.color = color;

   }

    /**
     * Getter for color
     *
     * @return color
     */
    public int getColor(){

// ADD YOUR CODE HERE
        return this.color;

    }
 
    /**
     * Getter method for the attribute row.
     * 
     * @return the value of the attribute row
     */

    public int getRow() {

// ADD YOUR CODE HERE
        return this.row;
    }

    /**
     * Getter method for the attribute column.
     * 
     * @return the value of the attribute column
     */

    public int getColumn() {

// ADD YOUR CODE HERE
        return this.column;

    }


// ADD YOUR PRIVATE METHODS HERE (IF USING ANY)


}
