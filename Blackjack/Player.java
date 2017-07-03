public class Player {
    private int name;
    private int values;
    private int nCards;
    private double earnings;
    private boolean bust;
    private boolean bJack;
    private double bet;
    private double money;
    private double insurance;
    private Card hand[] = new Card[10];
    
    public Player(int n1){
        this.name = n1;
        this.values = 0;
        this.nCards = 0;
        this.earnings = 0;
        this.bust = false;
        this.bJack = false;
        this.money = 100;
    }
    
    
    public void addCard (Card c1){
        hand[nCards] = c1;
        if (c1.getValue() == 1){
            if ((21 -(values + 1)) <= (21 - (values + 11))){
                values += 1;
            }
            else {
                values += 11;
            }
        }
        else {
            values += c1.getValue();
        }
        nCards++;
        
        if (nCards == 2){
            if (values == 21){
                this.blackjack(true);
            }
        }
        if (nCards >= 2){
            if (values > 21){
                this.busted(true);
            }
        }
    }
    
    public int getFirstValue(){
        return hand[0].getFace();
    }
    
    public void flipSecond(){
        
    }
    public void printHand(){
        for (int x = 0; x < nCards; x++){
            System.out.println("Suit: " + hand[x].getSuit() + " / Face: " + hand[x].getFace());
        }
    }
    
    public void printValues(){
        System.out.println("Total Value: " + values);
    }
    
    public void placeBet(double b1){
        this.bet = b1;
    }
    
    public double getBet(){
        return bet;
    }
    
    public int getValues(){
        return values;
    }
    
    public double getMoney(){
        return money;
    }
    
    public void addMoney(double p1temp){
        this.money += p1temp;
    }
    
    public void removeMoney(double p2temp){
        this.money -= p2temp;
    }
    
    public void blackjack (boolean bj1){
        bJack = bj1;
    }
    
    public boolean getBlackjack (){
        return bJack;
    }
    
    public void busted (boolean b1){
        bust = b1;
    }
    
    public boolean getBusted (){
        return bust;
    }
    
    public void setInsurance(double ins1){
        this.insurance = ins1;
    }
    
    public double getInsurance(){
        return insurance;
    }
}
