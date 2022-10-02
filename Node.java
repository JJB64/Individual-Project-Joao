import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;

public class Node {

    airports state;
    Node parent;
    routes actions;
    int pathcost  ;



    public Node(airports state,Node parent, routes actions, int pathcost) {
        this.state = state;
        this.parent = parent;
        this.actions = actions;
        this.pathcost= pathcost;

    }

    public airports getState() {
        return this.state;
    }

    public routes getActions() {
        return this.actions;
    }

    public int getPathcost() {
        return this.pathcost;
    }

    public Node getParent() {
        return this.parent;
    }

    @Override
    public String toString() {
        return "Node{" +
                "state=" + state +
                ", parent=" + parent +
                ", actions=" + actions +
                ", pathcost=" + pathcost +
                '}';
    }

    public void Solution_Path(){
            ArrayList<String> Cummulative_States = new ArrayList<String>();
            String flightpath;
            Node var = this;
            int Tpath_cost=0;
            System.out.println(var);
            while(var.parent !=  null) {
                flightpath= var.actions.getAirline() + " from " + var.getParent().getState().getIATA() + " to "+ var.state.getIATA() + "is " + var.actions.getStops() + "stops" ;
                Cummulative_States.add(flightpath);
                var = var.parent;
                Tpath_cost +=1;
            }
            String TotalFlights= "Total flights to take" + Tpath_cost;
            Collections.reverse(Cummulative_States);

            try {
                FileWriter output = new FileWriter("FlightPath.txt");
                for(int i = 0; i < Cummulative_States.size(); i++){
                    String data=i+". "+ Cummulative_States.get(i);
                    output.write(data);
                }
                output.write(Tpath_cost);
                output.close();
                System.out.println("Successfully wrote to the file.");
             }catch (IOException IOE) {
                System.out.println("An error occurred whiles writing to the file.");
                IOE.printStackTrace();
            }
        }



}


