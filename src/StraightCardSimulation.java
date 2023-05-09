import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StraightCardSimulation {
    private static final int CARDS_DRAW = 13;
    private static final int NUMBER_OF_CASES = 1000_000_000;

    private static final ArrayList<Card> STRAIGHT = new ArrayList<>(Arrays.asList(new Card("1,2,3,4,5", "Hearts"),
            new Card("2,3,4,5,6", "Hearts"),
            new Card("3,4,5,6,7", "Hearts"),
            new Card("4,5,6,7,8", "Hearts"),
            new Card("5,6,7,8,9", "Hearts"),
            new Card("6,7,8,9,10", "Hearts"),
            new Card("7,8,9,10,J", "Hearts"),
            new Card("8,9,10,J,Q", "Hearts"),
            new Card("8,9,10,J,Q", "Hearts"),
            new Card("9,10,11,12,13", "Hearts"),
            new Card("10,11,12,13,1", "Hearts")));


    public static void main(String[] args) {
        CardsDeck cardsDeck = new CardsDeck();
        Boolean[] RESULTS = new Boolean[NUMBER_OF_CASES];
        ArrayList<Card> drawnCards;

        for (int index = 0; index < NUMBER_OF_CASES; index++) {
            cardsDeck.shuffle();
            drawnCards = new ArrayList<>();

            for (int draw = 0; draw < CARDS_DRAW; draw++) {
                drawnCards.add(cardsDeck.dealCard());
            }

            RESULTS[index] = checkIfStraightExists(drawnCards);
            System.out.println(index + " with result: " + RESULTS[index]);
        }
        System.out.println(Stream.of(RESULTS).filter(Boolean.TRUE::equals).count());
    }

    private static Boolean checkIfStraightExists(ArrayList<Card> cards) {
        String drawn = cards.stream().map(Card::getFace).distinct().map(Integer::valueOf).sorted().map(String::valueOf).collect(Collectors.joining(","));

        for (Card card : STRAIGHT) {
            if (drawn.contains(card.getFace())) return true;
        }
        return false;
    }


}
