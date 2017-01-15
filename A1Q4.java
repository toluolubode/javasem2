
import java.util.Scanner;
import java.util.Random;

/**
 * The class <b>A1Q4</b> is an implementation of the
 * ``Old Maid'' card game, based on the Python implementation
 * given in ITI1020
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class A1Q4{

	/**
	* Array used to store the full deck of cards,
	*/
	private static String[] deck;

	/**
	* The current number of cards in the full deck of cards
	*/
	private static int sizeDeck;

	/**
	* Array used to store the player's deck of cards
	*/
	private static String[] playerDeck;

	/**
	* The current number of cards in the player's deck of cards
	*/
	private static int sizePlayerDeck;

	/**
	* Array used to store the computer's deck of cards
	*/
	private static String[] computerDeck;

	/**
	* The current number of cards in the computer's deck of cards
	*/
	private static int sizeComputerDeck;


	/**
	* An instance of java.util.Scanner, which will get input from the
	* standard input
	*/
 	private static Scanner sc;

	/**
	* An instance of java.util.Random, to generate random numbers
	*/
 	private static Random generator;

	/** 
     * Constructor of the class. Creates the full deck of cards
     */
 
 	public  A1Q4(){
		
		sc = new Scanner(System.in);
		generator = new Random();

		String[] suits = {"\u2660", "\u2661", "\u2662", "\u2663"};
		String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		sizeDeck = suits.length*ranks.length - 1;
		deck = new String[sizeDeck];
		int index = 0;
		for(int i =0 ; i < ranks.length; i++){
			for(int j =0 ; j < suits.length; j++){
				if(!(ranks[i]=="Q" && suits[j]=="\u2663")){
					deck[index++]= ranks[i] + " of " + suits[j];
				}
			}
		}
	}

	/** 
     * Waits for user input
     */
	private static void waitForUserInput(){
		sc.nextLine();
	}

	/**
	*  Deals the cards, taking sizeDeck cards out of deck, and deals them
	*  into playerDeck and computerDeck, starting with playerDeck
	*/
	private static void dealCards(){


// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

	}

	/**
	*  Removes all the pairs of cards from the array deckOfCards, that currently
	* contains currentSize cards. deckOfCards is unsorted. It should also not
	* be sorted once the method terminates. 
	*
    *   @param deckOfCards the array of Strings representing the deck of cards
    *   @param currentSize the number of strings in the arrayOfStrings,
    *			stored from arrayOfStrings[0] to arrayOfStrings[currentSize-1] 
    *   @return the number of cards in deckOfCards once the pair are removed
    */
	private static int removePairs(String[] deckOfCards, int currentSize){
	
// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION


	}

	/**
	*  Get a valid index of a card to be removed from computerDeck.
	*	Note: this method does not check that the input is indeed an integer and
	*	will crash if something else is provided.
	*  @return the valid input.
	*/
	private static int getValidInput(){

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
	
	}


	/**
	*  The actual game, as per the Python implementation
	*/
	public static void playGame(){

 // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
		
	}


	/**
     * The main method of this program. Creates the game object
     * and calls the playGame method on it.
     * @param args ignored
	 */    

 
	public static void main(String[] args){
	
		A1Q4 game = new A1Q4();		

		game.playGame();
	
		
	}
}