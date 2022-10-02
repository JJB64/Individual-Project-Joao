import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Main {


    public static void main(String[] args) {
        try {

            airports.Data_retrieve();
            airlines.Data_retrieve();
            routes.Data_retrieve();
            Scanner reader = new Scanner(new File("C://Users//joaob//Desktop//Ashesi//Second Year Semester 2//Intermediate Programming for CS//Inividual Project//TestData.txt"));
            String Start_City = reader.nextLine();
            String End_City = reader.nextLine();

            String[] var1 = Start_City.split(",");
            String Scity=var1[0];
            String Scountry=var1[1];

            String[] var2 = End_City.split(",");
            String Ecity=var2[0];
            String Ecountry=var2[1];

            bfs(Scity, Scountry, Ecity, Ecountry);


        } catch (FileNotFoundException FNFE) {
            System.out.print("The specified file was not found");
            throw new RuntimeException();
        }

    }

    public static ArrayList<Node>  generateAirports(String Sdata){
        ArrayList<Node> Potential_Airports = new ArrayList<>();
        ArrayList<airports> AirData = airports.getAirport_Map().get(Sdata);
        for (airports datum : AirData) {
            Node node = new Node(datum, null, null, 0);
            Potential_Airports.add(node);
            //System.out.println(datum);
        }
        //System.out.println(Potential_Airports);
        return Potential_Airports;

    }

    public static boolean GoalTest(Node x, String endcity, String endcountry){
        if(x.getState().getCity().equals(endcity) && x.getState().getCountry().equals(endcountry)){
            return true;
        } else if (x.getState() == null) {
            return false;
        }else{
            return false;
        }


    }





    public static void bfs(String Scity, String Scountry, String Ecity, String Ecountry) {
        Queue<Node> Frontier = new LinkedList<>();
        HashSet<Node> Explored = new HashSet();
        ArrayList<Node> Potential_Airports = new ArrayList<>();
        String Sdata = Scity + Scountry;
        Potential_Airports= generateAirports(Sdata);


        //Adding all potential airports in the start city to the frontier
        for (int i = 0; i <  Potential_Airports.size(); i++) {
            Frontier.add(Potential_Airports.get(i));


        while (Frontier.size() > 0) {
                Node var= Frontier.poll();
                Explored.add(var);

                if(var.getState() != null){
                    ArrayList<routes> Actions = routes.routes_Map.get(var.getState().getIATA());
                    for (int k = 0; k <  Potential_Airports.size(); k++) {
                        airports cState= airports.Select_Airport.get(Actions.get(k).getDestination_AirportCode());
                        int cost= var.getPathcost() + 1;
                        Node child = new Node(cState,var,Actions.get(k), cost);
                        //System.out.println(child);
                        if(!Explored.contains(child) && !Frontier.contains(child.state)) {
                            if (GoalTest(child, Ecity, Ecountry)) {
                                child.Solution_Path();
                            }
                        }
                    }
                }else{
                    System.out.println("Error");
                }

        }


        }
    }








}
















