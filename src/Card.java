public class Card {
    private final String face;
    private final String suit;

    // two-argument constructor initializes card's face and suit
    public Card(String face, String suit) {
        this.face = face;
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public String getFace() {
        return face;
    }

    // return String representation of Card
    public String toString() {
        return face + " of " + suit;
    }
}
