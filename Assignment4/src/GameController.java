import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

import javax.swing.*;


/**
 * The class <b>GameController</b> is the controller of the game. It has a method
 * <b>selectColor</b> which is called by the view when the player selects the next
 * color. It then computesthe next step of the game, and  updates model and view.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */


public class GameController implements ActionListener {

    /**
     * Reference to the view of the board
     */
    private GameView gameView;
    /**
     * Reference to the model of the game
     */
    private GameModel gameModel;
    private boolean orthogonal, diagonal, plane, torus;
    private GenericLinkedStack<GameModel> undoStack, redoStack;
    private GameModel oldModel;

    /**
     * Constructor used for initializing the controller. It creates the game's view 
     * and the game's model instances
     * 
     * @param size
     *            the size of the board on which the game will be played
     */
    public GameController(int size) {
        orthogonal=plane=true;
        diagonal=torus=false;

        gameModel = new GameModel(size);
        gameView = new GameView(gameModel, this);

        GameModel g = gameModel.readObject();

        if(g != null){
            copyValues(g);
            gameView.update();
        }

        undoStack = new GenericLinkedStack<>();

       // undoStack.push((GameModel)gameModel.clone());

        redoStack = new GenericLinkedStack<>();
        //flood();
        //gameView.update();
    }

    /**
     * resets the game
     */
    public void reset(){
        gameModel.reset();
        //flood();
        gameView.update();
        undoStack = new GenericLinkedStack<>();
        redoStack = new GenericLinkedStack<>();
    }

    /**
     * Callback used when the user clicks a button (reset or quit)
     *
     * @param e
     *            the ActionEvent
     */

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() instanceof DotButton) {

            DotButton a = (DotButton)e.getSource();

            if(e.getActionCommand().equals("boardButton")) {

                if(gameModel.getNumberOfSteps()==-1 ){
                    oldModel = (GameModel) gameModel.clone();
                    gameModel.capture(a.getRow(), a.getColumn());
                    gameModel.setCurrentSelectedColor(a.getColor());
                    flood();
                    gameModel.step();
                    gameView.update();
                    undoStack.push(oldModel);
                }
                else
                    selectColor(a.getColor());


            }
            else{
                if(gameModel.getNumberOfSteps()>=0)
                selectColor(a.getColor());
                System.out.println("select color\n");
            }

            //selectColor(a.getColor());
            //flood();
            //gameView.update();


        } else if (e.getSource() instanceof JButton) {
            JButton clicked = (JButton)(e.getSource());

            if (clicked.getText().equals("Quit")) {
                gameModel.writeObject();
                 System.exit(0);
             } else if (clicked.getText().equals("Reset")){
                reset();
             }
             else if(clicked.getText().equals("redo")){
                 if(!redoStack.isEmpty()) {
                     undoStack.push(redoStack.peek());
                     copyValues(redoStack.pop());
                     gameView.update();

                     if(redoStack.isEmpty()){
                         gameView.setRedo(false);
                     }
                 }

            }
            else if(clicked.getText().equals("undo")){

                 if(!undoStack.isEmpty()){
                     redoStack.push((GameModel) gameModel.clone());
                     copyValues(undoStack.pop());
                     gameView.update();
                     gameView.setRedo(true);

                     if(undoStack.isEmpty()){
                         gameView.setUndo(false);
                     }

                 }


            }
            else if(clicked.getText().equals("Settings")){
                openSettingsDialog();
            }
        }

        else if (e.getSource() instanceof JRadioButton){
            JRadioButton clicked = (JRadioButton)(e.getSource());

            if(clicked.getText().equals("Plane") && clicked.isSelected()){
                gameModel.setTorus(false);
            }
            else if(clicked.getText().equals("Torus")){
                gameModel.setTorus(true);
            }
            else if(clicked.getText().equals("Orthogonal") && clicked.isSelected()){
                gameModel.setDiagonal(false);
            }
            else if(clicked.getText().equals("Diagonal")){
                gameModel.setDiagonal(true);
            }


        }
    }

    /**
     * <b>selectColor</b> is the method called when the user selects a new color.
     * If that color is not the currently selected one, then it applies the logic
     * of the game to capture possible locations. It then checks if the game
     * is finished, and if so, congratulates the player, showing the number of
     * moves, and gives to options: start a new game, or exit
     * @param color
     *            the newly selected color
     */
    public void selectColor(int color){

        if(color != gameModel.getCurrentSelectedColor()) {
            oldModel = (GameModel) gameModel.clone();
            gameModel.setCurrentSelectedColor(color);
            flood();
            gameModel.step();

            gameView.update();


            if(gameModel.isFinished()) {
                deleteCache();
                      Object[] options = {"Play Again",
                                "Quit"};
                        int n = JOptionPane.showOptionDialog(gameView,
                                "Congratulations, you won in " + gameModel.getNumberOfSteps() 
                                    +" steps!\n Would you like to play again?",
                                "Won",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[0]);
                        if(n == 0){
                            reset();
                        } else{
                            System.exit(0);
                        }   
                }            
            }        
    }

   /**
     * <b>flood</b> is the method that computes which new dots should be ``captured'' 
     * when a new color has been selected. The Model is updated accordingly
     */
     private void flood() {

         boolean changed = false;
         DotInfo initial;
         DotInfo finalD = null;

         //Stack<DotInfo> stack = new GenericArrayStack<>(gameModel.getSize()*gameModel.getSize());
         Stack<DotInfo> stack = new GenericLinkedStack<>();
        for(int i =0; i < gameModel.getSize(); i++) {
           for(int j =0; j < gameModel.getSize(); j++) {
                if(gameModel.isCaptured(i,j)) {
                    stack.push(gameModel.get(i,j));
                }
           }
        }

        initial = stack.peek();

        while(!stack.isEmpty()){
            DotInfo DotInfo = stack.pop();
            //System.out.println("DOTINFO\n" + DotInfo+"\n");

            if((DotInfo.getX() > 0) && shouldBeCaptured (DotInfo.getX()-1, DotInfo.getY())) {
                gameModel.capture(DotInfo.getX()-1, DotInfo.getY());
                stack.push(gameModel.get(DotInfo.getX()-1, DotInfo.getY()));
            }  
            if((DotInfo.getX() < gameModel.getSize()-1) && shouldBeCaptured (DotInfo.getX()+1, DotInfo.getY())) {
                gameModel.capture(DotInfo.getX()+1, DotInfo.getY());
                stack.push(gameModel.get(DotInfo.getX()+1, DotInfo.getY()));
            }
            if((DotInfo.getY() > 0) && shouldBeCaptured (DotInfo.getX(), DotInfo.getY()-1)) {
                gameModel.capture(DotInfo.getX(), DotInfo.getY()-1);
                stack.push(gameModel.get(DotInfo.getX(), DotInfo.getY()-1));
            }  
            if((DotInfo.getY() < gameModel.getSize()-1) && shouldBeCaptured (DotInfo.getX(), DotInfo.getY()+1)) {
                gameModel.capture(DotInfo.getX(), DotInfo.getY()+1);
                stack.push(gameModel.get(DotInfo.getX(), DotInfo.getY()+1));
            }

            if(torus){
                torus(DotInfo,stack);

            }

            if(diagonal){
                diagonal(DotInfo, stack);
            }

            finalD = DotInfo;
        }

        if(!initial.equals(finalD)){
            changed = true;
        }

        if(changed){

            undoStack.push(oldModel);

            //System.out.println(oldModel+"\n~~~~~~~~~~~~\n");
        }


    }


    /**
     * <b>shouldBeCaptured</b> is a helper method that decides if the dot
     * located at position (i,j), which is next to a captured dot, should
     * itself be captured
     * @param i
     *            row of the dot
     * @param j
     *            column of the dot
     */
    
   private boolean shouldBeCaptured(int i, int j) {
        if(!gameModel.isCaptured(i, j) &&
           (gameModel.getColor(i,j) == gameModel.getCurrentSelectedColor())) {
            return true;
        } else {
            return false;
        }
    }


    private void openSettingsDialog(){
        JFrame frame = new JFrame();

        JPanel settingsPanel = new JPanel();

        JLabel play = new JLabel("Play on tortus or plane");

        JRadioButton plane = new JRadioButton("Plane");
        plane.setSelected(!gameModel.getTorus());
        plane.addActionListener(this);

        JRadioButton tortus = new JRadioButton("Torus");
        tortus.setSelected(gameModel.getTorus());
        tortus.addActionListener(this);

        JLabel moves = new JLabel("Diagonal moves?");

        JRadioButton orthogonal = new JRadioButton("Orthogonal");
        orthogonal.setSelected(!gameModel.getDiagonal());
        orthogonal.addActionListener(this);

        JRadioButton diagonal = new JRadioButton("Diagonal");
        diagonal.setSelected(gameModel.getDiagonal());
        diagonal.addActionListener(this);

        ButtonGroup playGroup = new ButtonGroup();
        playGroup.add(plane);
        playGroup.add(tortus);

        ButtonGroup movesGroup = new ButtonGroup();
        movesGroup.add(orthogonal);
        movesGroup.add(diagonal);

        JPanel top = new JPanel();
        top.add(play, BorderLayout.NORTH);
        top.add(plane, BorderLayout.CENTER);
        top.add(tortus, BorderLayout.SOUTH);

        JPanel bottom = new JPanel();
        bottom.add(moves, BorderLayout.NORTH);
        bottom.add(orthogonal, BorderLayout.CENTER);
        bottom.add(diagonal, BorderLayout.SOUTH);

        settingsPanel.add(top, BorderLayout.NORTH);
        settingsPanel.add(bottom, BorderLayout.SOUTH);
        /*settingsPanel.add(plane);
        settingsPanel.add(tortus);

        settingsPanel.add(moves);
        settingsPanel.add(orthogonal);
        settingsPanel.add(diagonal);*/

        JOptionPane.showMessageDialog(frame, settingsPanel);




    }

    public void torus(DotInfo DotInfo, Stack<DotInfo> stack){
        int s = gameModel.getSize();

        if((DotInfo.getX() == 0) && shouldBeCaptured (s-1, DotInfo.getY())) {
            gameModel.capture(s-1, DotInfo.getY());
            stack.push(gameModel.get(s-1, DotInfo.getY()));
        }

        if((DotInfo.getX() == s-1) && shouldBeCaptured (0, DotInfo.getY())) {
            gameModel.capture(0, DotInfo.getY());
            stack.push(gameModel.get(0, DotInfo.getY()));
        }
        if((DotInfo.getY()==0) && shouldBeCaptured (DotInfo.getX(), s-1)) {
            gameModel.capture(DotInfo.getX(), s-1);
            stack.push(gameModel.get(DotInfo.getX(), s-1));
        }
        if((DotInfo.getY() == s-1) && shouldBeCaptured (DotInfo.getX(), 0)) {
            gameModel.capture(DotInfo.getX(), 0);
            stack.push(gameModel.get(DotInfo.getX(), 0));
        }

    }

    public void diagonal(DotInfo DotInfo, Stack<DotInfo> stack){
        int s = gameModel.getSize();
        int x = DotInfo.getX();
        int y = DotInfo.getY();
        if((DotInfo.getX()>0 && DotInfo.getX()<s-1) && (DotInfo.getY()>0 && DotInfo.getY()<s-1)){


            if(shouldBeCaptured(x-1,y-1)){
                gameModel.capture(x-1,y-1);
                stack.push(gameModel.get(x-1,y-1));
            }

            if(shouldBeCaptured(x+1,y-1)){
                gameModel.capture(x+1,y-1);
                stack.push(gameModel.get(x+1,y-1));
            }

            if(shouldBeCaptured(x-1,y+1)){
                gameModel.capture(x-1,y+1);
                stack.push(gameModel.get(x-1,y+1));
            }

            if(shouldBeCaptured(x+1,y+1)){
                gameModel.capture(x+1,y+1);
                stack.push(gameModel.get(x+1,y+1));
            }
        }

        if (x==0 && (y>0 && y<s-1)){
            if(shouldBeCaptured(x+1,y+1)){
                gameModel.capture(x+1,y-1);
                stack.push(gameModel.get(x+1,y-1));
            }

            if(shouldBeCaptured(x+1,y-1)){
                gameModel.capture(x+1,y-1);
                stack.push(gameModel.get(x+1,y-1));
            }
        }

        if (x==s-1 && (y>0 && y<s-1)){
            if(shouldBeCaptured(x-1,y+1)){
                gameModel.capture(x-1,y+1);
                stack.push(gameModel.get(x-1,y+1));
            }

            if(shouldBeCaptured(x-1,y-1)){
                gameModel.capture(x-1,y-1);
                stack.push(gameModel.get(x-1,y-1));
            }
        }

        if (y==0 && (x>0 && x<s-1)){
            if(shouldBeCaptured(x+1,y+1)){
                gameModel.capture(x+1,y+1);
                stack.push(gameModel.get(x+1,y+1));
            }

            if(shouldBeCaptured(x-1,y+1)){
                gameModel.capture(x-1,y+1);
                stack.push(gameModel.get(x-1,y+1));
            }
        }

        if (y==s-1 && (x>0 && x<s-1)){
            if(shouldBeCaptured(x-1,y-1)){
                gameModel.capture(x-1,y-1);
                stack.push(gameModel.get(x-1,y-1));
            }

            if(shouldBeCaptured(x+1,y-1)){
                gameModel.capture(x+1,y-1);
                stack.push(gameModel.get(x+1,y-1));
            }
        }


    }

    private void copyValues(GameModel old){
        gameModel.setCurrentSelectedColor(old.getCurrentSelectedColor());
        for(int i = 0; i < gameModel.getSize(); i++){
            for(int j = 0; j < gameModel.getSize(); j++){

                gameModel.get(i,j).setCaptured(old.get(i,j).isCaptured());

            }
        }

        gameModel.setValues(old.getNumberOfSteps(), old.getNumberCaptured());
        gameModel.setDiagonal(old.getDiagonal());
        gameModel.setTorus(old.getTorus());

    }

    public void deleteCache(){
        File f = null;

        try {
            f = new File("savedGame.ser");
            f.delete();
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }


}
