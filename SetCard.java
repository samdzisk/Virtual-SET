public class SetCard{
   
   public Shape myShape;
   public Filling myFilling;
   public Number myNumber;
   public Color myColor;
   
   //defaut constructor
   public SetCard(){
      myShape = Shape.OVAL;
      myFilling = Filling.SHADED;
      myNumber = Number.THREE;
      myColor = Color.PURPLE;
   }
   
   public SetCard(Shape s, Color c, Filling f, Number n){
      myShape = s;
      myFilling = f;
      myNumber = n;
      myColor = c;
   }
   
   public SetCard(SetCard sc){
      myShape = sc.getShape();
      myFilling = sc.getFilling();
      myNumber = sc.getNumber();
      myColor = sc.getColor();
   }
   
   public Shape getShape(){
      return myShape;
   }
   
   public Filling getFilling(){
      return myFilling;
   }
   
   public Number getNumber(){
      return myNumber;
   }
   
   public Color getColor(){
      return myColor;
   }
   
   @Override
   public String toString(){
      String card = "(";
      card += myShape + " ";
      card += myFilling + " ";
      card += myNumber + " ";
      card += myColor + ")";
      return card;
   }
}