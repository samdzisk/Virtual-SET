import java.util.ArrayList;

public class SetDeck {
   private static final int NUM_OPTIONS = 3;
   
   private static final Shape[] shapes = {Shape.OVAL, Shape.DIAMOND, Shape.SQUIGGLE};
   private static final Color[] colors = {Color.RED, Color.GREEN, Color.PURPLE};
   private static final Filling[] fillings = {Filling.SOLID, Filling.SHADED, Filling.EMPTY};
   private static final Number[] numbers = {Number.ONE, Number.TWO, Number.THREE};
   
   private static final int DECK_COUNT = 81;
   
   private ArrayList<SetCard> myDeck = new ArrayList<SetCard>(); 
      
   public SetDeck(){
      int cardCount = 0;
      //creates one card for each of the 81 possible combinations
      for(int shape = 0; shape < NUM_OPTIONS; shape++){
         for(int color = 0; color < NUM_OPTIONS; color++){
            for(int filling = 0; filling < NUM_OPTIONS; filling++){
               for(int number = 0; number < NUM_OPTIONS; number++){
                  //copies each card to the right index
                  myDeck.add(new SetCard(shapes[shape], colors[color], fillings[filling], numbers[number]));
                  cardCount++;
               }
            }
         }
      }
      this.shuffleThis();
   }//end constructor
   
   //copy constructor
   public SetDeck(SetDeck sd){
      myDeck = sd.getDeck();
   }  
   
   //get a copy of a card
   public SetCard getCard(int num){
      return new SetCard(myDeck.get(num));
   }
   
   //get a copy of the deck array
   public ArrayList<SetCard> getDeck(){
      /*SetCard[] deckCopy = new SetCard[DECK_COUNT];
      int ct = 0;
      //copies each card from myDeck into a new array of SetCards and returns it
      for(SetCard sc : myDeck){
         deckCopy[ct] = new SetCard(sc);
         ct++;*/
      return new ArrayList<SetCard>(myDeck);

      }
   
   
   //changes myDeck to a shuffled version
   public void shuffleThis(){
      //copies the current myDeck array for use
      ArrayList<SetCard> shuffled = new ArrayList<SetCard>(DECK_COUNT);
      //keep track of if we've done all 81 cards
      int cardsDone = 0;
      
      //store a random position
      int randPos = 0;
      
      //while there are still cards left:
      while(cardsDone < DECK_COUNT){
         //add a random card to the new ArrayList
         randPos = getRandPosition(DECK_COUNT-cardsDone);
         shuffled.add(myDeck.get(randPos));
         //System.out.print("Card " + cardsDone + " added to shuffled: " + " " + myDeck.get(randPos) + "\n");
         myDeck.remove(randPos);
         cardsDone++;
      }//end while
      
      //add shuffled ArrayList back to MyDeck
      for(int card = 0; card < DECK_COUNT; card++){
         myDeck.add(shuffled.get(0));
         shuffled.remove(0);
      }
   }//end method
   
   public SetCard draw(){
      SetCard drawn = new SetCard(myDeck.get(0));
      myDeck.remove(0);
      return drawn;
   }
   
   //generates a random index for an array of size currentSize
      private static int getRandPosition(int currentSize){
      return (int) (Math.random() * (currentSize-1));
   }
   
   @Override
   public String toString(){
   String deck = "";
      for(SetCard sc : myDeck){
         deck += sc + "\n";
      }
   return deck;
   }

}
