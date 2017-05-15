//Create large input for testing

import java.util.Random;
class Big{

   public static void main(String[] args){
      Random rand = new Random();
      System.out.println("1 2 3 4 6 10");
      for(int i = 0; i < 10000; i++){
         System.out.print(rand.nextInt(500));
         System.out.print("+");
         System.out.print(rand.nextInt(500));
         System.out.print("->");
         System.out.print(rand.nextInt(500));
         System.out.print("+");
         System.out.println(rand.nextInt(500));
      }
   }

}

