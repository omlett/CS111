// This class represents one playing card.
/*
	// Card suits (provided for your convenience - use is optional)
	public static final int SPADES   = 0;
	public static final int HEARTS   = 1;
	public static final int CLUBS    = 2;
	public static final int DIAMONDS = 3;

	// Card faces (provided for your convenience - use is optional)
	public static final int ACE      = 1;
	public static final int TWO      = 2;
	public static final int THREE    = 3;
	public static final int FOUR     = 4;
	public static final int FIVE     = 5;
	public static final int SIX      = 6;
	public static final int SEVEN    = 7;
	public static final int EIGHT    = 8;
	public static final int NINE     = 9;
	public static final int TEN      = 10;
	public static final int JACK     = 11;
	public static final int QUEEN    = 12;
	public static final int KING     = 13;
*/
public class Card
{
	int suit;
	int face;
        int status;
	
	// This constructor builds a card with the given suit and face, turned face down.
	public Card(int cardSuit, int cardFace, int cardStatus)
	{
            if (((cardSuit >=0) && (cardSuit < 4)) && ((cardFace >=1) && (cardFace < 14)) && ((cardStatus == 1) || (cardStatus == 0))){
                suit = cardSuit;
                face = cardFace;
                status = cardStatus;
            }
            else{
                IO.reportBadInput();
                suit = 0;
                face = 0;
                status = 0;
            }
	}
        
	// This method retrieves the suit (spades, hearts, etc.) of this card.
	public int getSuit()
	{
            return suit;
	}
	
	// This method retrieves the face (ace through king) of this card.
	public int getFace()
	{
            return face;
	}
	
	// This method retrieves the numerical value of this card
	// (usually same as card face, except 1 for ace and 10 for jack/queen/king)
	public int getValue()
	{
            if (face>10){
                return 10;
            }
            else{
                return face;
            }
	}

	public void flip(){
            if (status == 0){
                status = 1;
            }
            else{
                status = 0;
            }
        }
        
        public void print(){
            System.out.println("Suit: " + suit + " / Face: " + face);
        }
}
