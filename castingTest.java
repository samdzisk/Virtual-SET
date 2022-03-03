public class castingTest{
   public static void main(String[] args){
      Color color1 = Color.RED;
      Color color2 = Color.RED;
      Color color3 = Color.GREEN;
      
      System.out.println(objectCompare(color1, color2));
      
      
   }
   public static boolean objectCompare(Object a, Object b){
         return(a.equals(b));
      }
}