public class SetDriver{
   public static void main(String[] args){
      SetDeck testDeck = new SetDeck();
      SetBoard testBoard = new SetBoard(testDeck);
            
      System.out.println(testBoard.checkForSets());
   }
}