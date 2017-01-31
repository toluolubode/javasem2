
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

 //Name: Ogunsanya Toluwani Damilola
 //Student-No: 8677256
 //Section: ITI1121-C
 //ASSIGNMENT 1 Q4

 //Name: Olubode Toluwanimi
 //Student-No: 8696226
 //Section: ITI1121-A
 //ASSIGNMENT 1 Q4

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
        deck = shuffle(deck);

        System.out.println("\n");
    }

    /**
     * Waits for user input
     */
    private static void waitForUserInput(){
        sc.nextLine();
    }

    private static void printDeck(String[] data){
        ArrayStringsTools a = new ArrayStringsTools();
        a.printArray(data, data.length);
        //System.out.println(Arrays.toString(data));
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

        System.out.println("            aaaaaaa           ");
        printDeck(deckOfCards);

        Boolean x = true;
        String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

        while(x){
            Boolean found = false;
            for(String k : ranks){

                int count = 0;
                int[] indexes = new int[2];
                for (int i = 0; i < deckOfCards.length; i++){
                    if(count ==2){
                        count = 0;

                        deckOfCards = popFromArray(deckOfCards, indexes[0]);
                        deckOfCards = popFromArray(deckOfCards, indexes[1]-1);
                        indexes = new int[2];
                        found = true;
                    }
                    else if(k.equals(String.valueOf(deckOfCards[i].charAt(0)))){
                        indexes[count] = i;
                        count++;
                    }

                }
                x = found;
            }
        }

        System.out.println("            llllllllll           ");
        printDeck(deckOfCards);

        deckOfCards = shuffle(deckOfCards);

        System.out.println("            shuffle           ");
        printDeck(deckOfCards);

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
    private static int getValidInput(int n){
        String num = String.valueOf(n);

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        System.out.println("I have "+ num+ " cards. If 1 stands for my first card and");
        System.out.println(num+ " for my last card, which of my cards would you like?");
        int position= 0;

        try{
            position=Integer.parseInt(sc.nextLine().trim());

            while (!(position>=1 && position <=n)){
                System.out.println("Invalid number. Please enter integer between 1 and "+num+": ");
                position=Integer.parseInt(sc.nextLine().trim());}
        }
        catch (NumberFormatException e){
            position = getValidInput(n);
        }

        return position;
    }


    /**
     *  The actual game, as per the Python implementation
     */
    public static void playGame(){

        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

        Random rand = new Random();

        String[] ordinals={"st", "nd", "rd", "th"};

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

        System.out.println("ready");

        dealer = removePairs(dealer);
        human=removePairs(human);

        int turn = 0;
        int cardIndex;

        while(dealer.length > 0 && human.length > 0){
            if(turn == 0){
                System.out.println("***********************************************************");
                System.out.println("Your turn: \n");
                System.out.println("your current deck of cards is: ");
                printDeck(human);

                System.out.println("Enter card position:");

                int pos =getValidInput(dealer.length);
                String item = dealer[pos-1];
                dealer = popFromArray(dealer, pos-1);

                System.out.println("");

                int ord = 3;

                if(pos == 3) {
                  ord = 2;
                }
                else if(pos == 2){
                  ord = 1;
                }
                else if(pos == 1){
                  ord = 0;
                }

                System.out.println("You asked for my "+String.valueOf(pos)+ ordinals[ord] + " card.");

                System.out.println("Here it is, " + item);

                human = pushToArray(human, item);

                System.out.println("With " + item + " taken out, your deck of cards is: ");
                printDeck(human);

                System.out.println("");
                System.out.println("After discarding and shuffling, your deck of cards is: ");
                human = removePairs(human);

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

                dealer = removePairs(dealer);

                int ord = 3;
                int pos = cardIndex +1;

                if(pos == 3) {
                  ord = 2;
                }
                else if(pos == 2){
                  ord = 1;
                }
                else if(pos == 1){
                  ord = 0;
                }

                System.out.println("I took your "+String.valueOf(pos) + ordinals[ord]+" card.");
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

    public static String[] shuffle(String[] deck)
    {
        int length = deck.length;
        for(int i = 0; i < deck.length; i++){
            Random r = new Random();
            int a = r.nextInt(length-1);
            String temp = deck[i];
            deck[i] = deck[a];
            deck[a] = temp;
        }

        return deck;
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

		/*System.out.println("");
		System.out.println("Old: " + Arrays.toString(oldArray));
		System.out.println("New: " + Arrays.toString(newArray));
		System.out.println("");*/

        return newArray;
    }

    public static  String[] popLast(String[] deck){
        String[] newArray = new String[deck.length-1];

        for(int i = 0; i<deck.length-1;i++){
            newArray[i] = deck[i];
        }

        return newArray;

    }

    public static String[] removePairs(String[] deck) {


        int len = deck.length;
        deck = sort(deck);
        String[] noPairs = new String[deck.length];
        int i = 0;
        int k = 0;

        while (i < len-1) {
            String card1 = deck[i];
            String card2 = deck[i + 1];
            if (card1.charAt(0) == card2.charAt(0) && card1.charAt(1) == card2.charAt(1)) {
                i++;
            } else if (card1.charAt(0) == card2.charAt(0)) {
                i++;
            } else {
                noPairs[k] = deck[i];
                k++;}

            i++;
            }


        if (i == len - 1){
            noPairs[k] = deck[i];
            }
        k = noPairs.length-1;
        while(k>=0 && noPairs[k] == null){
            noPairs = popLast(noPairs);
            k--;
        }

        if(noPairs.length > 1) {
            noPairs = shuffle(noPairs);
        }

        return noPairs;

    }

    public static String[] sort(String[] deck){


        for(int i = 0; i < deck.length-1; i++){
            for (int j = i+1; j<deck.length; j++){
                if(deck[i].compareTo(deck[j]) > 0){
                    String a = deck[i];
                    String b = deck[j];

                    deck[i] = b;
                    deck[j] = a;
                }
            }
        }

        return deck;
    }


    /**
     * The main method of this program. Creates the game object
     * and calls the playGame method on it.
     * @param args ignored
     */


    public static void main(String[] args){

        StudentInfo studentInfo = new StudentInfo();
        studentInfo.display();
        A1Q4 game = new A1Q4();

        game.playGame();


    }
}
