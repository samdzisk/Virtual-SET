public class SetGame{
   
   public static boolean isSet(SetCard a, SetCard b, SetCard c){
      if(isCandidate(a.getColor(), b.getColor(), c.getColor()) && isCandidate(a.getShape(), b.getShape(), c.getShape()) &&
      isCandidate(a.getFilling(), b.getFilling(), c.getFilling()) && isCandidate(a.getNumber(), b.getNumber(), c.getNumber())){
         return true;
      }
      else{
         return false;
      }
   }
   
   public static boolean isCandidate(Object a, Object b, Object c){
      if(a.equals(b) && a.equals(c)){
         return true;
      }
      else if(!a.equals(b) && !a.equals(c) && !b.equals(c)){
         return true;
      }
      else{
         return false;
      }
   }
}