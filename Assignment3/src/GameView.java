// ADD YOUR IMPORTS HERE


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import static java.awt.BorderLayout.*;

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
    private JLabel steps;
    private DotButton[][] dotButtons;
    private JPanel boardPanel, selectBoard, settingsPanel;

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

        dotButtons = new DotButton[model.getSize()][model.getSize()];


        reset = new JButton("RESET");
        quit = new JButton("QUIT");
        steps = new JLabel("Number of steps: 0");

        boardPanel = new JPanel(new GridLayout(gameModel.getSize(), gameModel.getSize()));

        selectBoard = new JPanel(new GridLayout(1, gameModel.getSize()));
        selectBoard.setBorder(BorderFactory.createLineBorder(Color.black));
        selectBoard.setBorder(new EmptyBorder(10,10,10,10));

        settingsPanel = new JPanel();

        for(int i = 0; i < 6; i++){
            selectBoard.add(new DotButton(i,1));
        }

        settingsPanel.add(steps, WEST);
        settingsPanel.add(reset, CENTER);
        settingsPanel.add(quit,EAST);

        update();


        setSize(300,300);


        add(boardPanel, NORTH);
        add(selectBoard, CENTER);
        //add(quit);
        add(settingsPanel, SOUTH);

        pack();

        setVisible(true);

    }

    /**
     * update the status of the board's DotButton instances based on the current game model
     */

    public void update(){

// ADD YOUR CODE HERE
        for(int i = 0; i < gameModel.getSize(); i++){
            for(int j = 0; j < gameModel.getSize(); j++){
                DotButton a = new DotButton(i,j, gameModel.getColor(i,j), 1);
                //System.out.println(i + " " + j + " COLR: " +gameModel.getColor(i,j));
                boardPanel.add(a);

            }
        }



    }

    public void addListenerForQuitAndReset(){
        reset.addActionListener(gameController);
        quit.addActionListener(gameController);
    }




}
