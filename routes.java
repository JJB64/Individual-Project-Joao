import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class routes {
    private String Airline;
    private String Airline_Id;

    private String Source_AirportCode;
    private String Source_AirportId;
    private String Destination_AirportCode;
    private String Destination_AirportId;
    private boolean Codeshare;
    private int Stops;
    private String Equipment;

    public routes(String airline, String airline_Id, String source_AirportCode, String source_AirportId, String destination_AirportCode, String destination_AirportId, boolean codeshare, int stops, String equipment) {
        this.Airline = airline;
        this.Airline_Id = airline_Id;
        this.Source_AirportCode = source_AirportCode;
        this.Source_AirportId = source_AirportId;
        this.Destination_AirportCode = destination_AirportCode;
        this.Destination_AirportId = destination_AirportId;
        this.Codeshare = codeshare;
        this.Stops = stops;
        this.Equipment = equipment;
    }

    @Override
    public String toString() {
        return "routes{" +
                "Airline='" + Airline + '\'' +
                ", Airline_Id='" + Airline_Id + '\'' +
                ", Source_AirportCode='" + Source_AirportCode + '\'' +
                ", Source_AirportId='" + Source_AirportId + '\'' +
                ", Destination_AirportCode='" + Destination_AirportCode + '\'' +
                ", Destination_AirportId='" + Destination_AirportId + '\'' +
                ", Codeshare=" + Codeshare +
                ", Stops=" + Stops +
                ", Equipment='" + Equipment + '\'' +
                '}';
    }

    /**
     *returns 2 letter IATA code or 3 letter ICAO code of airline
     *@return  this.Airline
     */
    public String getAirline() {
        return this.Airline;
    }

    public String getAirline_Id() {
        return this.Airline_Id;
    }

    /**
     *returns the 3 letter IATA code or 4 letter ICAO code of source airport
     *@return this.Source_Airport
     */
    public String getSource_AirportCode() {
        return this.Source_AirportCode;
    }

    public String getSource_AirportId() {
        return this.Source_AirportId;
    }

    /**
     *returns the 3 letter IATA code or 4 letter ICAO code of destination airport
     *@return this.Destination_Airport
     */
    public String getDestination_AirportCode() {
        return this.Destination_AirportCode;
    }

    public String getDestination_AirportId() {
        return this.Destination_AirportId;
    }

    public boolean isCodeshare() {
        return this.Codeshare;
    }

    /**
     * returns the number of stops
     *
     * @return this.Stops
     */
    public int getStops() {
        return this.Stops;
    }

    public String getEquipment() {
        return this.Equipment;
    }

    public static Map<String, ArrayList<routes>> routes_Map = new HashMap<String, ArrayList<routes>>();
    public static void  Data_retrieve(){

        BufferedReader br = null;

        try {
            // creating file object
            Scanner reader = new Scanner(new File("C://Users//joaob//Desktop//Ashesi//Second Year Semester 2//Intermediate Programming for CS//Inividual Project//routes.csv"));
            reader.useDelimiter(",");              // Setting the delimiter used in file.

            while (reader.hasNext()) {
                String[] info = reader.nextLine().split(",");
                if (info.length == 9) {
                    String Airline = info[0];
                    String Airline_Id = info[1];
                    String Source_AirportCode = info[2];
                    String Source_AirportId = info[3];
                    String Destination_AirportCode = info[4];
                    String Destination_AirportId = info[5];
                    boolean Codeshare = Boolean.parseBoolean(info[6]);
                    int Stops = Integer.parseInt(info[7]);
                    String Equipment = info[8];

                    routes routes_instance = new routes(Airline, Airline_Id, Source_AirportCode, Source_AirportId, Destination_AirportCode, Destination_AirportId, Codeshare, Stops, Equipment);
                    if (!routes_Map.containsKey(Source_AirportCode)) {
                        routes_Map.put(Source_AirportCode, new ArrayList<routes>());
                        routes_Map.get(Source_AirportCode).add(routes_instance);
                    } else {
                        routes_Map.get(Source_AirportCode).add(routes_instance);

                    }
                }
            }
            reader.close();
        } catch(FileNotFoundException FNFE) {
            System.out.println("The specified file in the filepath was not found");
        }
    }


}







