import javax.swing.*;
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
    private static final int defaultSize = 12;
    private static int size;
    private int counter = 0;


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
        gameModel = new GameModel(size);
        gameView = new GameView(gameModel, GameController.this);

        gameView.addListenerForQuitAndReset();

        captureDots(gameModel.getColor(0,0));

    }
    public GameController(){
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
        gameView.update();
        captureDots(gameModel.getColor(0,0));


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
        else if(action.equals("0")){
            captureDots(0);
        }
        else if(action.equals("1")){
            captureDots(1);
        }
        else if(action.equals("2")){
            captureDots(2);

        }
        else if(action.equals("3")){
            captureDots(3);
        }
        else if(action.equals("4")){
            captureDots(4);
        }
        else if(action.equals("5")){
            captureDots(5);
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

            if(counter > 0) {
                gameModel.step();
            }
            else{
                counter++;
            }

        }


       
    }




// ADD YOUR PRIVATE METHODS HERE
    private void captureDots(int newColor){
        MyStack stack = new MyStack();

        for (int i = 0; i < size; i++){
            for (int j = 0; j< size; j++){


                if (gameModel.get(i,j).isCaptured()){
                    stack.push(gameModel.get(i,j));
                }
            }
        }

        while (!stack.isEmpty()){
            DotInfo d = (DotInfo) stack.pop();
            int x = d.getX();
            int y = d.getY();

            for(int i = 0; i < 4; i++){
                if(x<size-1){
                    isSame(x+1,y, newColor, stack);

                }

                if(x>0){
                    isSame(x-1,y, newColor, stack);
                }

                if(y < size-1){
                    isSame(x,y+1, newColor, stack);
                }

                if(y>0){
                    isSame(x, y-1, newColor, stack);
                }
            }

        }

        if(gameModel.isFinished()){
            //System.out.println("end");
            end();
        }
        else {
                selectColor(newColor);
                gameView.update();

        }

    }

    private void isSame(int x, int y,int newColor, MyStack stack){
        if(gameModel.get(x,y).isCaptured()){
            //gameModel.get(x,y).setColor(newColor);
        }
        else if(newColor == gameModel.getColor(x,y)){

            gameModel.get(x,y).setCaptured(true);
            stack.push(gameModel.get(x,y));

        }
    }

    private void end() {
        JFrame options = new JFrame();

        JOptionPane.showMessageDialog(options,"Game Over! Do you want to continue?");

    }

}
