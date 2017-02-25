// ADD YOUR IMPORTS HERE


import javax.swing.*;

/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out the actual game and 
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class GameView extends JFrame {

// ADD YOUR INSTANCE VARIABLES HERE
    private GameModel gameModel;
    private GameController gameController;
    private JButton reset, quit;

    /**
     * Constructor used for initializing the Frame
     * 
     * @param model
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */

    public GameView(GameModel model, GameController gameController) {

// ADD YOUR CODE HERE
        this.gameModel = model;
        this.gameController= gameController;

        reset = new JButton("RESET");
        quit = new JButton("QUIT");

    }

    /**
     * update the status of the board's DotButton instances based on the current game model
     */

    public void update(){

// ADD YOUR CODE HERE

    }

    public void addListenerForQuitAndReset(){
        reset.addActionListener(gameController);
        quit.addActionListener(gameController);
    }


}
