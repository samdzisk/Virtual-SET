import java.util.ArrayList;

public class SetBoard{
   private ArrayList<SetCard> myBoard = new ArrayList<SetCard>();
   private ArrayList<SetCard> myDeck = new ArrayList<SetCard>();
   private ArrayList<SetCard> discards = new ArrayList<SetCard>();
   
   private static final int BOARD_SIZE = 12;
   
   public SetBoard(SetDeck sd) {
      //copy deck variable into local variable
      for(SetCard sc : sd.getDeck()){
         myDeck.add(new SetCard(sc));
      }
      //iterate over the board, taking a deck and filling the board with the first 12 cards from it
      for(int ct = 0; ct < BOARD_SIZE; ct++){
         myBoard.add(myDeck.get(0));
         discards.add(myDeck.get(0));
         myDeck.remove(0);
      }
   }//end constructor
   
   public ArrayList<SetCard> getBoard(){
      ArrayList<SetCard> boardCopy = new ArrayList<SetCard>();
      for(SetCard sc : myBoard){
         boardCopy.add(new SetCard(sc));
      }
      return boardCopy;
   }
   
   public SetCard getCard(int num){
      if(num < BOARD_SIZE){
         return new SetCard(myDeck.get(num));
      }
      else{
         return null;
      }
   }
   
   @Override
   public String toString(){
   String boardString = "";
   int ct = 0;
      for(int row = 0; row < 4; row++){
         for(int col = 0; col < 3; col++){
            boardString += myBoard.get(ct);
            ct++;
         }
         boardString += "\n";
      }
   return boardString;
   }
   
  /*How this works: checks every single combo of 3 to see if it's a set
  index is the index of the first card in the set of threeto be checked
  the outer loop moves the starting point
  the inner loop takes the starting point, the next card, and compares them
  to every card after them in the ArrayList*/
   public boolean checkForSets(){
      for(int index = 0; index < BOARD_SIZE - 2; index++){
         for(int third = index + 2; third < BOARD_SIZE; third++){
            if(SetGame.isSet(myBoard.get(index), myBoard.get(index + 1), myBoard.get(third))){
               System.out.println(myBoard.get(index) + "" + myBoard.get(index + 1) + myBoard.get(third));               
               return true;
            }
         }
      }
      System.out.println(myBoard);
      return false;
   }
}