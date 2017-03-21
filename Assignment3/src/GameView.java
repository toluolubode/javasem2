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
    private JButton reset, quit, redButton, blueButton, yellowButton, purpleButton, greyButton, greenButton;
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

        greenButton = new DotButton(3,0);
        greenButton.setActionCommand("3");

        yellowButton = new DotButton(1,0);
        yellowButton.setActionCommand("1");

        blueButton = new DotButton(2,0);
        blueButton.setActionCommand("2");

        purpleButton = new DotButton(4,0);;
        purpleButton.setActionCommand("4");

        greyButton = new DotButton(0,0);
        greyButton.setActionCommand("0");

        redButton = new DotButton(5,0);
        redButton.setActionCommand("5");



        settingsPanel = new JPanel();

        settingsPanel.add(redButton);
        settingsPanel.add(blueButton);
        settingsPanel.add(purpleButton);
        settingsPanel.add(greyButton);
        settingsPanel.add(yellowButton);
        settingsPanel.add(greenButton);


        settingsPanel.add(steps, WEST);
        settingsPanel.add(reset, CENTER);
        settingsPanel.add(quit,EAST);

        update();


        setSize(1000,1000);


        //add(boardPanel, NORTH);
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
        int size = gameModel.getSize();



        boardPanel = new JPanel(new GridLayout(size,size));

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                DotButton a = new DotButton(i,j, gameModel.getColor(i,j), 1);
                //System.out.println("called");

                boardPanel.add(a);

            }
        }


        add(boardPanel, NORTH);
        revalidate();

        steps.setText("Number of steps: " + gameModel.getNumberOfSteps());

    }

    public void addListenerForQuitAndReset(){
        reset.addActionListener(gameController);
        quit.addActionListener(gameController);
        greenButton.addActionListener(gameController);
        yellowButton.addActionListener(gameController);
        blueButton.addActionListener(gameController);
        redButton.addActionListener(gameController);
        purpleButton.addActionListener(gameController);
        greyButton.addActionListener(gameController);

    }




}
