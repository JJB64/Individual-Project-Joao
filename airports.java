/**
 *@author Joao Joseph Baeta
 */
import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;


public class airports {

    public static HashMap<String, ArrayList<airports>> Airport_Map = new HashMap<>();
    public static HashMap<String, airports> Select_Airport = new HashMap<>();

    private String Airport_ID;

    private String Airport_Name;
    private String City;
    private String Country;
    private String IATA;
    private String ICAO;




    public airports(String airport_ID, String airport_Name, String city, String country, String IATA, String ICAO) {
        this.Airport_ID = airport_ID;
        this.Airport_Name = airport_Name;
        this.City = city;
        this.Country = country;
        this.IATA = IATA;
        this.ICAO = ICAO;
    }

    @Override
    public String toString() {
        return "airports{" +
                "Airport_Name='" + Airport_Name + '\'' +
                ", IATA='" + IATA + '\'' +
                '}';
    }

    public String getAirport_ID() {
        return this.Airport_ID;
    }

    public String getAirport_Name() {
        return this.Airport_Name;
    }

    /**
     * returns the city the airport operates in
     *
     * @return this.City
     */
    public String getCity() {
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

    /**
     * returns the 4 letter ICAO code
     *
     * @return this.ICAO
     */
    public String getICAO() {
        return this.ICAO;
    }

    public static HashMap<String, ArrayList<airports>> getAirport_Map() {
        return Airport_Map;
    }


    public static void Data_retrieve() {
        BufferedReader br = null;

        try {
            // create file object
            Scanner reader = new Scanner(new File("C://Users//joaob//Desktop//Ashesi//Second Year Semester 2//Intermediate Programming for CS//Inividual Project//airports.csv"));
            reader.useDelimiter(",");              // Set the delimiter used in file.

            while (reader.hasNext()) {
                String[] info = reader.nextLine().split(",");
                    String Airport_ID = info[0];
                    String Airport_Name = info[1];
                    String City = info[2];
                    String Country = info[3];
                    String IATA = info[4];
                    String ICAO = info[5];


                    String key = City + Country;
                    airports Airport_instance = new airports(Airport_ID, Airport_Name, City, Country, IATA, ICAO);
                    if (!Airport_Map.containsKey(key)) {
                        Airport_Map.put(key, new ArrayList<airports>());
                        Airport_Map.get(key).add(Airport_instance);
                    } else {
                        Airport_Map.get(key).add(Airport_instance);
                    }
                    Select_Airport.putIfAbsent(IATA,Airport_instance);

                }
             reader.close();
        }catch (FileNotFoundException FNFE) {
            System.out.println("The specified file in the filepath was not found");
        }
    }





//    public static void main(String[] args) {
//        Data_retrieve();
//        //System.out.print(Data_retrieve());
//    }
}






