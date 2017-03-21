import java.util.Scanner;
class Main {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String full = scanner.next();
      String sub = scanner.next(); 

      int from = 0; 
      
      while(from < full.length()){
         int a = full.indexOf(sub,from);
         if(a == -1){
            break;
         }
         System.out.println(a);
         from = a+1;
      }
   }
}
