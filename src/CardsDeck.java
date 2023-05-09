import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class CardsDeck {
    public ArrayList<Card> deck; // array of Card objects
    private int currentCard; // index of next Card to be dealt (0-51)
    private static final int NUMBER_OF_CARDS = 52; // constant # of Cards
    // random number generator
    private static final SecureRandom randomNumbers = new SecureRandom();

    // constructor fills deck of Cards
    public CardsDeck() {
        String[] faces = {"1", "2", "3", "4", "5", "6",
                "7", "8", "9", "10", "11", "12", "13"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        deck = new ArrayList<>(); // create array of Card objects
        currentCard = 0; // first Card dealt will be deck[0]

        // populate deck with Card objects
        for (int i = 0; i < NUMBER_OF_CARDS; i++)
            deck.add(new Card(faces[i % 13], suits[i / 13]));
    }

    // shuffle deck of Cards with one-pass algorithm
    public void shuffle() {
        Collections.shuffle(deck);
        currentCard = 0;
    }

    public void displayAllCards() {
        for (Card card : deck) {
            String face = card.getFace();
            String suit = card.getSuit();
            System.out.println(face + " of " + suit);
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    // deal one Card
    public Card dealCard() {
        // determine whether Cards remain to be dealt
        if (currentCard < deck.size())
            return deck.get(currentCard++); // return current Card in array
        else
            return null; // return null to indicate that all Cards were dealt
    }
}
