/**Flip class takes in two QueueReferenceBased objects and compares the top card*/

public class Flip
{
   QueueReferenceBased q1 = new QueueReferenceBased();
   
   
   public Flip(QueueReferenceBased q1)
   {
      this.q1 = q1;
   }
   
   public Object flip()
   {
       return q1.peek();
   }
}