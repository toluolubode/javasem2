import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The class <b>GameController</b> is the controller of the game. It has a method
 * <b>selectColor</b> which is called by the view when the player selects the next
 * color. It then computesthe next step of the game, and  updates model and view.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */


public class GameController implements ActionListener {

 // ADD YOUR INSTANCE VARIABLES HERE
    private GameView gameView;
    private GameModel gameModel;
    private MyStack stack;
    private static final int defaultSize = 12;
    private static int size;


    /**
     * Constructor used for initializing the controller. It creates the game's view 
     * and the game's model instances
     * 
     * @param size
     *            the size of the board on which the game will be played
     */
    public GameController(int size) {

// ADD YOUR CODE HERE
        this.size = size;
        stack = new MyStack();
        gameModel = new GameModel(size);
        gameView = new GameView(gameModel, GameController.this);

        gameView.addListenerForQuitAndReset();

    }
    public GameController(){
        stack = new MyStack();
        gameModel = new GameModel(defaultSize);
        gameView = new GameView(gameModel, GameController.this);

        gameView.addListenerForQuitAndReset();
    }

    /**
     * resets the game
     */
    public void reset(){

// ADD YOUR CODE HERE
        gameModel.reset();

    }

    /**
     * Callback used when the user clicks a button (reset or quit)
     *
     * @param e
     *            the ActionEvent
     */

    public void actionPerformed(ActionEvent e) {

// ADD YOUR CODE HERE

        String action = e.getActionCommand();

        if(action.equals("RESET")){
            reset();
        }
        else if(action.equals("QUIT")){
            System.exit(0);
        }

    }

    /**
     * <b>selectColor</b> is the method called when the user selects a new color.
     * If that color is not the currently selected one, then it applies the logic
     * of the game to capture possible locations. It then checks if the game
     * is finished, and if so, congratulates the player, showing the number of
     * moves, and gives two options: start a new game, or exit
     * @param color
     *            the newly selected color
     */
    public void selectColor(int color){

// ADD YOUR CODE HERE
        if(gameModel.getCurrentSelectedColor() != color){
            gameModel.setCurrentSelectedColor(color);
            gameModel.step();
        }
       
    }




// ADD YOUR PRIVATE METHODS HERE
    private void captureDots(DotInfo dot){
        MyStack stack = new MyStack();

        DotInfo[][] dots = gameModel.getDots();

        for (int i = 0; i < size; i++){
            for (int j = 0; j< size; j++){
                DotInfo o = dots[i][j];

                if (o.isCaptured()){
                    stack.push(o);
                }
            }
        }

        while (!stack.isEmpty()){
            DotInfo d = (DotInfo) stack.pop();


        }
    }



}
