
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

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

		System.out.println("\n deck");
		printDeck(deck);
		System.out.println("");
	}

	/**
     * Waits for user input
     */
	private static void waitForUserInput(){
		sc.nextLine();
	}

	private static void printDeck(String[] data){
			System.out.println(Arrays.toString(data));
	}

	/**
	*  Deals the cards, taking sizeDeck cards out of deck, and deals them
	*  into playerDeck and computerDeck, starting with playerDeck
	*/
	private static String[][] dealCards(String[] cards){


// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
			int half = cards.length/2;
			String[] dealer = new String[half];
			String[] other = new String[half];

			for(int i = 0; i < half; i++){
				dealer[i] = cards[i];
			}

			for(int i = 0; i < half; i++){
				other[i] = cards[half+i];
			}

			return(new String[][]{dealer, other});


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
	private static String[] removePairs(String[] deckOfCards, int currentSize){

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
		String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		int[] places = {-1,-1};
		for(String k : ranks){
			Boolean x = true;

			while (x){


				for (int i = 0; i< currentSize; i++) {
					if(k.equals(deckOfCards[i].charAt(0))){
						if(places[0] != -1){
							places[1] = i;
							i = currentSize;
							deckOfCards = popIt(deckOfCards, places);
						}
						else{
							places[0] = i;
						}
					}
				}
				x = false;
			}


		}


		System.out.println("");
	System.out.println(Arrays.toString(deckOfCards));
	return (deckOfCards);


	}

	public static String[] popIt(String[] deck, int[] places){
		int currentSize = deck.length;
		for (int i = 0; i<currentSize; i++) {
			if((i == places[0] || i == places[1]) && ++i < currentSize){
				deck = popFromArray(deck, i);
				currentSize--;
			}
		}

		return deck;
	}

	/**
	*  Get a valid index of a card to be removed from computerDeck.
	*	Note: this method does not check that the input is indeed an integer and
	*	will crash if something else is provided.
	*  @return the valid input.
	*/
	private static int getValidInput(){

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
		int pos = sc.nextInt();
		return pos;
	}


	/**
	*  The actual game, as per the Python implementation
	*/
	public static void playGame(){

 // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

 			Random rand = new Random();

			String[][] tmp = dealCards(deck);

			String[] dealer=tmp[0];
	    String[] human=tmp[1];

			System.out.println("Hello. My name is Robot and I am the dealer.");
			System.out.println("Welcome to my card game!");
			System.out.println("Your current deck of cards is:");
			printDeck(human);
			System.out.println("Do not worry. I cannot see the order of your cards");
			System.out.println("Now discard all the pairs from your deck. I will do the same.");
			System.out.print("Press enter to continue: ");
			waitForUserInput();

			dealer = removePairs(dealer, dealer.length);
	    human=removePairs(human, human.length);

			int turn = 0;
			int cardIndex;

			while(dealer.length > 0 && human.length > 0){
				if(turn == 0){
				System.out.println("***********************************************************");
				System.out.println("Your turn: \n");
				System.out.println("your current deck of cards is: ");
				printDeck(human);

				System.out.println("Enter card position:");

				int pos =getValidInput();
				String item = dealer[pos-1];
				dealer = popFromArray(dealer, pos-1);

				System.out.println("");

				System.out.println("I took your "+String.valueOf(pos)+" card.");

				System.out.println("Here it is, " + item);

				human = pushToArray(human, item);

				System.out.println("");

				printDeck(human);

				waitForUserInput();

				turn = 1;
			}
			else{
				System.out.println("***********************************************************");
				System.out.println("My turn\n");
				cardIndex = rand.nextInt(human.length-1);

				String item = human[cardIndex];

				dealer = pushToArray(dealer, item);
				human = popFromArray(human, cardIndex);

				System.out.println("I took your "+String.valueOf(cardIndex+1)+" card.");
				System.out.println("");

				turn = 0;

			}

			if(dealer.length == 0){
				System.out.println("Ups. I do not have any more cards");
				System.out.println("You lost! I, Robot, win");
			}
			else if(human.length == 0){
				System.out.println("***********************************************************");
				System.out.println("Ups. You do not have any more cards");
				System.out.println("Congratulations! You, Human, win");
			}
			}

	}

	public String[] removeItem(String[] deckOfCards, int index){
		int currentSize = deckOfCards.length;
		deckOfCards[index] = null;

		for (int i = index; i<currentSize; i++) {
			if(deckOfCards[i] == null && ++i < currentSize){
				deckOfCards[i] = deckOfCards[i+1];
				deckOfCards[i+1] = null;
				currentSize--;
			}
		}

		return deckOfCards;
	}

	private static String[] pushToArray(String[] oldArray, String pushData){
		int length = oldArray.length;
		String[] newArray = new String[length+1];

		int index = -1;

		for (String val : oldArray){
			index++;
			newArray[index] = val;
		}

		newArray[length] = pushData;

		System.out.println("");
		System.out.println("Old: " + Arrays.toString(oldArray));
		System.out.println("New: " + Arrays.toString(newArray));
		System.out.println("");

		return newArray;
	}

	private static String[] popFromArray(String[] oldArray, int index){
		int length = oldArray.length;
		String[] newArray = new String[oldArray.length - 1];
		int k = -1;

		for(int i = 0; i < newArray.length; i++){
			if(i == index){
				k++;
				newArray[i] = oldArray[k++];
			}
			else{
				k++;
				newArray[i] = oldArray[k];
			}
		}

		System.out.println("");
		System.out.println("Old: " + Arrays.toString(oldArray));
		System.out.println("New: " + Arrays.toString(newArray));
		System.out.println("");

		return newArray;
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
