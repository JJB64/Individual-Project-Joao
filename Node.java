import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException;

public class Node {

    String state;
    int pathcost  ;

    Node parent;

    public Node(String state) {
        this.state = state;
    }

    public Node(String state, int pathcost, Node parent) {
        this.state = state;
        this.pathcost = pathcost;
        this.parent = parent;
    }

    public void Solution_Path(){
            ArrayList<String> Cummulative_States = new ArrayList<String>();
            Node var=this;
            while(var.parent !=  null) {
                String flightpath= var.state + "from"+ var.parent + "to" + "is" + var.pathcost;
                Cummulative_States.add(flightpath);
                System.out.print("5");
            }
            Collections.reverse(Cummulative_States);
            System.out.print(Cummulative_States);
            try {
                FileWriter myWriter = new FileWriter("FlightPath.txt");
                myWriter.write(String.valueOf(Cummulative_States));
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
             }catch (IOException IOE) {
                System.out.println("An error occurred whiles writing to the file.");
                IOE.printStackTrace();
            }
        }


}


