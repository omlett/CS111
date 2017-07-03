// This class represents the deck of cards from which cards are dealt to players.
public class Deck
{
	private int lastCard;
	private int numCards;
        Card[] deck = new Card[52];
	
	// This constructor builds a deck of 52 cards.
	public Deck()
	{
            numCards = 0;
            for (int x = 0; x < 4; x++){
                for (int y = 1; y < 14; y++){
                    deck[numCards] = new Card(x, y, 0);
                    numCards++;
                }
            }
            lastCard = 51;
	}

	
	// This method takes the top card off the deck and returns it.
	public Card deal()
	{
            lastCard--;
            if (lastCard >= -1){
                return (deck[lastCard+1]);
            }
            else{
                return null;
            }
	}
	
	
	// this method returns true if there are no more cards to deal, false otherwise
	public boolean isEmpty()
	{
            if (lastCard >= 0){
                return false;
            }
            else {
                return true;
            }
	}
	
	//this method puts the deck int some random order
	public void shuffle(){
            Card shuffleHolder;
            int shuffleIndex;
            for (int z = 0; z < 52; z++){
                shuffleIndex = (int) (Math.random()*52);
                shuffleHolder = deck[z];
                deck[z] = deck[shuffleIndex];
                deck[shuffleIndex] = shuffleHolder;
            }
            lastCard = 51;
	}
        
        // Debug Helpers
        public void printDeck(){
            for (int x = 0; x < 52; x++){
                System.out.println(deck[x].getSuit() + "..." + deck[x].getFace());
            }
            System.out.println();
        }
        
        public void printCurrent(){
            if (lastCard >=0){
                System.out.println(deck[lastCard].getSuit() + "," + deck[lastCard].getFace());
            }
            else {
                System.out.println("Null");
            }
        }
}

