import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class routes {

    private String  Airline;
    private String Source_Airport;
    private String Destination_Airport;

    private int Stops;

    /**
     *Constructor:
     */

    /**
     @param Airline                  2 letter IATA code or 3 letter ICAO code of airline
     @param Source_Airport           3 letter IATA code or 4 letter ICAO code of source airport
     @param Destination_Airport      3 letter IATA code or 4 letter ICAO code of destination airport
     @param Stops                    Number of stops
     */
    public routes(String Airline, String Source_Airport, String Destination_Airport, int Stops){
        this.Airline= Airline;
        this.Source_Airport= Source_Airport;
        this.Destination_Airport = Destination_Airport;
        this.Stops = Stops;
    }




    public static Map<String, ArrayList<routes>> Data_retrieve(){
        Map<String, ArrayList<routes>> map = new HashMap<String, ArrayList<routes>>();
        BufferedReader br = null;

        try {
            // creating file object
            Scanner reader = new Scanner(new File("C://Users//joaob//Desktop//Ashesi//Second Year Semester 2//Intermediate Programming for CS//Inividual Project//routes.csv"));
            reader.useDelimiter(",");              // Setting the delimiter used in file.

            while(reader.hasNext()) {
                String[] info = reader.nextLine().split(",");
                String Id = info[0];
                String Src_Airport  = info[2];
                String Des_Airport = info[4];
                int Stops  = Integer.parseInt(info[7]);
                routes obj = new routes(Id,Src_Airport, Des_Airport,Stops);
                ArrayList<routes> data = new ArrayList<>();
                map.putIfAbsent(Id, new ArrayList<>());
                map.get(Id).add(obj);
            }

            System.out.print(map);
            reader.close();
        }

        catch (FileNotFoundException FNFE) {
            System.out.println("The specified file in the filepath was not found");
        }

        return map;
    }

    public static  void main(String[] args){
        Data_retrieve();
        //System.out.print(Data_retrieve());
    }







    /**
     *returns 2 letter IATA code or 3 letter ICAO code of airline
     *@return  this.Airline
     */
    public String getAirline(){
        return this.Airline;
    }


    /**
     *returns the 3 letter IATA code or 4 letter ICAO code of source airport
     *@return this.Source_Airport
     */
    public String getSource_Airport(){
        return this.Source_Airport;
    }

    /**
     *returns the 3 letter IATA code or 4 letter ICAO code of destination airport
     *@return this.Destination_Airport
     */
    public String getDestination_Airport(){
        return this.Destination_Airport;
    }


    /**
     * returns the number of stops
     *
     * @return this.Stops
     */
    public int getStops(){

        return this.Stops;
    }



}
