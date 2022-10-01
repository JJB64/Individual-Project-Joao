/**
 *@author Joao Joseph Baeta
 */
import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;


public class airports {

    public static Map<String, ArrayList<String>> Data_retrieve(){
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        BufferedReader br = null;

        try {
            // create file object
            Scanner reader = new Scanner(new File("C://Users//joaob//Desktop//Ashesi//Second Year Semester 2//Intermediate Programming for CS//Inividual Project//airports.csv"));
            reader.useDelimiter(",");              // Set the delimiter used in file.

            while(reader.hasNext()) {
                String[] info = reader.nextLine().split(",");
                String Destination = info[2] + "," + info[3]; //Combination of city and country
                map.putIfAbsent(Destination, new ArrayList<>());
                String id  = info[4];
                map.get(Destination).add(id);
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



    private String City;
    private String Country;
    private String IATA;


    /**
     *Constructor:
     */

    /**
     * @param City        the main city served by the airport
     * @param Country     the country/territory where the airport is located
     * @param IATA        3 letter IATA code
     */

    public airports(String City, String Country, String IATA) {
        this.City = City;
        this.Country = Country;
        this.IATA = IATA;
    }



    /**
     * returns the city the airport operates in
     *
     * @return this.City
     */
    public String getAirportCity() {
        return this.City;
    }

    /**
     * returns the country/territory where the airport is located
     *
     * @return this.Country
     */
    public String getCountry() {
        return this.Country;
    }

    /**
     * returns the 3 letter IATA code
     *
     * @return this.IATA
     */
    public String getIATA() {
        return this.IATA;
    }

}


