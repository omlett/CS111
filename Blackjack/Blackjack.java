public class Blackjack {
    public static void main (String [] args){
        
    
        int nPlayers;
        int hose;
        Player dealer = new Player(16);
        Deck deck = new Deck();
        deck.shuffle(); deck.shuffle(); deck.shuffle();
        
        // Identify # of players
        do{
        System.out.println("How many players?");
        nPlayers = IO.readInt();
        } while((nPlayers > 6) || (nPlayers <= 0));
        
        // Create Player Array
        Player[] players = new Player[nPlayers];
        for (int z = 0; z < players.length; z++){
            players[z] = new Player(z);
        }
        
        // Get Initial Wagers
        for (int wcount = 0; wcount < nPlayers; wcount++){
            do{
            System.out.println("Player " + (wcount+1) + ", you have " + players[wcount].getMoney() + "\n" + "What is your wager?");
            players[wcount].placeBet(IO.readDouble());
            } while((players[wcount].getMoney() < players[wcount].getBet()) || (players[wcount].getBet() <= 0));
        }
        
        
        // Deal Initial 2 Cards to Players
        for (int x = 0; x < nPlayers; x++){
            players[x].addCard(deck.deal());
            players[x].addCard(deck.deal());
        }
        
        // Deal Initial 2 Cards to Dealer, Print Face-Up Card
        dealer.addCard(deck.deal());
        System.out.println("\n Dealer's Hand");
        dealer.printHand();
        System.out.println();
        dealer.addCard(deck.deal());
        
        // Provide Insurance Option to Players, if Dealer's Face-Up card is ACE
        if (dealer.getFirstValue() == 1){
            for (int insure = 0; insure < nPlayers; insure++){
                do{
                System.out.println("Player " + (insure+1) + ": Enter insurance amount upto half of Initial Wager(0 - No Insurance)");
                players[insure].setInsurance(IO.readDouble());
                } while(((players[insure].getInsurance()) > (0.5*players[insure].getBet())) || (players[insure].getInsurance() < 0));
            }
        }
        
        
        
        // Hit-or-Stand Loop
        // Identify Busted Players
        for (int y = 0; y < nPlayers; y++){

            if ((players[y].getBusted() == false) && (players[y].getBlackjack() == false)){

                System.out.println("Player " + (y+1) + "'s Hand");
                players[y].printHand();
                players[y].printValues();
                    // Hint Engine
                    if (players[y].getValues() <= 21){
                        if (players[y].getValues() == 21){
                            System.out.println("HINT: You should Stand, because you have the best possible card total.");
                        }
                        else if (players[y].getValues() > 17){
                            System.out.println("HINT: You should Stand, because you have a pretty high card total.");
                        }
                        else if (players[y].getValues() > 11){
                            System.out.println("HINT: You should Hit, but it's a little risky.");
                        }
                        else if (players[y].getValues() > 0){
                            System.out.println("HINT: You should Hit, because you can't lose.");
                        }
                    }
                    System.out.println();
                System.out.println("Player " + (y+1) + ": Press 1 for Hit or 0 for Stand");
                hose = IO.readInt();

                while ((hose == 1)&&(players[y].getBusted()==false)&&(players[y].getBlackjack()==false)){
                    players[y].addCard(deck.deal());
                    System.out.println("Player " + (y+1) + "'s Hand");
                    players[y].printHand();
                    players[y].printValues();
                    
                        // Hint Engine
                        if (players[y].getValues() <= 21){
                            if (players[y].getValues() == 21){
                                System.out.println("HINT: You should Stand, because you have the best possible card total.");
                            }
                            else if (players[y].getValues() > 17){
                                System.out.println("HINT: You should Stand, because you have a pretty high card total.");
                            }
                            else if (players[y].getValues() > 11){
                                System.out.println("HINT: You should Hit, but it's a little risky.");
                            }
                            else if (players[y].getValues() > 0){
                                System.out.println("HINT: You should Hit, because you can't lose.");
                            }
                        }
                        System.out.println();

                    if (players[y].getBusted() == false){
                        System.out.println("Player " + (y+1) + ": Press 1 for Hit or 0 for Stand?");
                        hose = IO.readInt();
                    }
                    else{
                        System.out.println("Busted!");
                    }

                }


            }

        }
        
        // Dealer's Hit-or-Stand Loop
        while ((dealer.getBusted() == false) && (dealer.getBlackjack() == false) && (dealer.getValues() <= 17)){
            dealer.addCard(deck.deal());

        }
        
        
        System.out.println();
        System.out.println("Dealer:");
        dealer.printHand();
        dealer.printValues();
        System.out.println();
       
        // Insurance Payout
        if (dealer.getBlackjack() == true){
            for (int insure2 = 0; insure2 < nPlayers; insure2++){
                if (players[insure2].getInsurance() > 0){
                    players[insure2].addMoney(players[insure2].getInsurance()*2);
                }
            }
        }
        
            
            else {
                // Regular Payout + Bank Display   
                for (int pay = 0; pay < nPlayers; pay++){

                    if (dealer.getBusted() == false){
                        if (players[pay].getBusted() == false){
                            if (dealer.getValues() > players[pay].getValues()){
                                players[pay].removeMoney(players[pay].getBet());
                            }
                            else if (dealer.getValues() < players[pay].getValues()){
                                players[pay].addMoney(players[pay].getBet());
                            }
                        }
                    }         
                    if (dealer.getBusted() == true){
                        if (players[pay].getBusted() == false){
                            players[pay].addMoney(players[pay].getBet());
                        }
                        else if (players[pay].getBusted() == true){
                            players[pay].removeMoney(players[pay].getBet());
                        }
                    }

                    // Display Player Ending Sums
                    System.out.println("Player " + (pay+1) + " bank: " + players[pay].getMoney());
                }
            }
    }
}
