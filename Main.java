import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Main {
    String Start_City="";
    String End_City="";

    public static  void main(String[] args){
        try {
            Scanner sc = new Scanner(System.in);
            Scanner reader = new Scanner(new File("C://Users//joaob//Desktop//Ashesi//Second Year Semester 2//Intermediate Programming for CS//Inividual Project//TestData.txt"));
            String Start_City = reader.nextLine();
            String End_City = reader.nextLine();
            bfs(Start_City,End_City);

        }

        catch(FileNotFoundException FNFE){
            System.out.print("The specified file was not found");
            throw new RuntimeException();
        }

    }



    public static void bfs(String start_City, String end_City) {
        ArrayList<String> FLightPath= new ArrayList<String>();
        Queue<Node> Frontier = new LinkedList<>();
        HashSet<String> Explored =new HashSet();
        ArrayList<String> data = airports.Data_retrieve().get(start_City);
        String a= data.get(2);
        Frontier.add(new Node(a));

         while(Frontier.size()>0){
             Node CA = Frontier.remove();
             Explored.add(CA.state);


             ArrayList<routes> Rdatas = routes.Data_retrieve().get(CA.state);
             if(String.valueOf(Rdatas.get(2)) == CA.state){
                 CA.Solution_Path();
             }else{
                 for(int i=0; i < Rdatas.size(); i++){
                     String EndAirportCode = String.valueOf(Rdatas.get(2));
                     int cost= Rdatas.get(3).getStops();
                     Node child = new Node(EndAirportCode,cost,CA);


                     if(Explored.contains(child.state) && Frontier.contains(child.state)) {
                             child.Solution_Path();
                             Frontier.add(child);
                         }

                     }

            }

        }
    }
}













