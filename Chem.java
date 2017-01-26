import java.util.*;
import java.io.*;
class Chem{
   static final int max_elmts = 150000;
   static BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

   public static void main(String[] args) throws IOException{
      ArrayList<Reaction> rxns = new ArrayList<Reaction>();
      boolean[] have = new boolean[max_elmts];
      String[] start = bi.readLine().split(" ");
      for(String s : start){
         have[Integer.parseInt(s)] = true; 
      }

      rxns = parse_rxns();

      have = check_matches(have,rxns);

      for(int i = 0; i < max_elmts; i++){
         if(have[i]){
            System.out.print(i + " " );
         }
      }
      System.out.println();

   }

   public static boolean[] check_matches(boolean[] have, 
         ArrayList<Reaction> rxns){
      int start_pt = 0;
      int remove_index = 0;
      while(rxns.size() != start_pt){
         start_pt = rxns.size();
rxn_loop:
         for(Reaction rxn : rxns){
            for(int b : rxn.needs){
               System.out.println(b);
               if(have[b] == false){
                  continue rxn_loop;
               }
            }
            for(int y : rxn.yields){
               have[y] = true;
               remove_index = rxns.indexOf(rxn);
            }
         }

         if(rxns.size() > remove_index){
            rxns.remove(remove_index);
         }
      }
      return have;

   }
   public static ArrayList<Reaction> parse_rxns() throws IOException{
      String[] curr_line;
      ArrayList<Reaction> rxns = new ArrayList<Reaction>(); 
      int i = 0;
      int j = 0;
      while(bi.ready() == true){
         int[] need = new int[max_elmts/2];
         int[] yield = new int[max_elmts/2];

         String delim = "\\+";
         curr_line = bi.readLine().split("->");
         String[] react = curr_line[0].split(delim);
         String[] prod = curr_line[1].split(delim);

         for(String s : react){
            need[i] = Integer.parseInt(s);
            i++;
         }
         for(String s : prod){
            yield[j] = Integer.parseInt(s);
            j++;
         }
         Reaction r = new Reaction(need, yield);
         rxns.add(r);
      }

      return rxns;



   }

   private static class Reaction{
      int[] needs;
      int[] yields;
      public Reaction(int[] needs, int[] yields){
         this.needs = needs;
         this.yields = yields;
      }
      public Reaction(){
      }


   }


}


