/**
 *@author Joao Joseph Baeta
 */
import java.io.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class airlines {

    public static Map<String, ArrayList<String>> Data_retrieve(){
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        BufferedReader br = null;

        try {
            // create file object
            Scanner reader = new Scanner(new File("C://Users//joaob//Desktop//Ashesi//Second Year Semester 2//Intermediate Programming for CS//Inividual Project//airlines.csv"));
            reader.useDelimiter(",");              // Set the delimiter used in file.

            while(reader.hasNext()) {
                String[] info = reader.nextLine().split(",");
                String Id = info[0];
                map.putIfAbsent(Id, new ArrayList<>());
                String Name  = info[1];
                map.get(Id).add(Name);
                String Country  = info[6];
                map.get(Id).add(Country);
                String Active_Status = info[7];
                map.get(Id).add(Active_Status);
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
        private int AirlineId;
        private String Name;
        private String Alias;
        private String IATA;
        private String ICAO;
        private String Callsign;
        private String Country;
        private boolean Active;




        /**
         *Constructor:
         */

        /**
         @param AirlineId                the unique OpenFlights identifiers for the airline
         @param Name                     the name of the Airline
         @param Alias                    the alias if the airline
         @param IATA                     2 letter IATA code
         @param ICAO                     3 letter ICAO code
         @param Callsign                 the callsign of the airline
         @param Country                  the country/territory where the airport is located
         @param Active                   If the airline is active or not
         */

        public airlines(int AirlineId , String Name, String Alias , String IATA, String ICAO,String Callsign,String Country,boolean Active){
            this.AirlineId  = AirlineId ;
            this.Name= Name;
            this.Alias = Alias ;
            this.IATA = IATA;
            this.ICAO = ICAO;
            this.Callsign = Callsign;
            this.Country = Country;
            this.Active = Active;
        }

        /**
         *returns the unique OpenFlights identifiers for airline
         *@return  this.AirlineId
         */
        public int getId(){
            return this.AirlineId;
        }

        /**
         *returns the name of the airline
         *@return this.Name
         */
        public String getAirlineName(){
            return this.Name;
        }

        /**
         *returns the alias of an airline
         *@return this.Alias
         */
        public String getAirlineAlias(){
            return this.Alias;
        }

        /**
         *returns the 2 letter IATA code
         *@return this.IATA
         */
        public String getIATA(){
            return this.IATA;
        }

        /**
         *returns the 3 letter ICAO code
         *@return this.ICAO
         */
        public String getICAO(){
            return this.ICAO;
        }

        /**
         *returns the country/territory where the airline is located
         *@return this.Country
         */
        public String getCountry(){
            return this.Country;
        }

        /**
         *returns whether airline is active or not
         *@return this.Active
         */
        public boolean getActive(){
            return this.Active;
        }

}
