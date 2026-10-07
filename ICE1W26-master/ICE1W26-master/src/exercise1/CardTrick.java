package exercise1;

import java.util.Scanner;
import java.util.Random;

/**
 * A class that fills a hand of 7 cards with random Card Objects and then asks the user to pick a card.
 * It then searches the array of cards for the match to the user's card. 
 * To be used as starting code in Exercise
 *
 * @author dancye
 * @author Paul Bonenfant Jan 25, 2022 
 */
public class CardTrick {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Card[] hand = new Card[7];

        for (int i = 0; i < hand.length; i++) {
            Card card = new Card();
            //card.setValue(insert call to random number generator here)
            // 
            card.setValue((int)(Math.random()*13)+1);
            //card.setSuit(Card.SUITS[insert call to random number between 0-3 here])
            // Hint: You can use Random -> random.nextInt(n) to get a random number between 0 and n-1 (inclusive)
            //       Don't worry about duplicates at this point
            card.setSuit(Card.SUITS[(int)(Math.random()*3)+1]);   
            
            hand[i] = card;

			// Testing purposes of printing the cards in the hand.
			System.out.println("Card " + (i+1) + " " + jkqaConv(hand[i].getValue()) + " of " + hand[i].getSuit() + " has been pulled into the hand.");
			
        }
        // insert code to ask the user for Card value and suit, create their card
        // and search the hand here. 
        // Hint: You can ask for values 1 to 10, and then
        //       11 for jack, 12 for queen, etc. (remember arrays are 0-based though)
        //       1 for Hearts, 2 for Diamonds, etc. (remember arrays are 0-based though)
        // 
        // Then loop through the cards in the array to see if there's a match.
        System.out.print("Please select a card value from 1 to 13 (1 - Ace, 11 - Jack, 12 - Queen, 13 - King): ");
        int cardVal = scanner.nextInt();
        System.out.print("Now please select a suit for this card (1 - Hearts, 2 - Diamonds, 3 - Spades, 4 - Clubs): ");
        int suitVal = scanner.nextInt();
        
        suitVal = suitVal - 1;
        
        Card guessedCard = new Card();
        
        guessedCard.setValue(cardVal);
        guessedCard.setSuit(Card.SUITS[suitVal]);
        
        for (int i = 0; i < hand.length; i++) {
            boolean guessFlag = false;
            if (hand[i].getSuit().equals(guessedCard.getSuit())){
                if (hand[i].getValue() == guessedCard.getValue()) {
                    printInfo();
                    guessFlag = true;
                    break;
                }
            }
            if (i == hand.length-1 && guessFlag==false){
                System.out.println("Sorry, your guess of card: \"" + jkqaConv(guessedCard.getValue()) + "\" of \"" + guessedCard.getSuit() + "\" was not present in the hand.");
            }
        }
        
        // If the guess is successful, invoke the printInfo() method below.
        
    }

    /**
     * A simple method to print out personal information. Follow the instructions to 
     * replace this information with your own.
     * @author Paul Bonenfant Jan 2022
     */
    private static void printInfo() {
    
        System.out.println("Congratulations, you guessed right!");
        System.out.println();
        
        System.out.println("My name is Paul, but you can call me prof, Paul or sir");
        System.out.println();
        
        System.out.println("My career ambitions:");
        System.out.println("-- Be more active on LinkedIn");
        System.out.println("-- Have a semester with no violations of academic integrity!");
	System.out.println();	

        System.out.println("My hobbies:");
        System.out.println("-- Investing");
        System.out.println("-- Cooking");
        System.out.println("-- Reading/Watching TV");
        System.out.println("-- Riding my motorcycle");

        System.out.println();
        
    
    }
    
       public static String jkqaConv (int val){
       String str;
       switch (val) {      
           case 1:
               str = "Ace";
               break;
           case 11:
               str = "Jack";
               break;
           case 12:
               str = "Queen";
               break;
           case 13:
               str = "King";
               break;
           default:
               str = String.valueOf(val);
               break;     
       }
       return str;
   }

}
