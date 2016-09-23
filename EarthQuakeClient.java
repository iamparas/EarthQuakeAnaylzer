
import java.util.*;
//import edu.duke.*;

public class EarthQuakeClient {
    
   public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData, double mag){
	   ArrayList<QuakeEntry> results = new ArrayList<QuakeEntry>();
	   for(QuakeEntry qe : quakeData){
		   if(Double.compare(qe.getMagnitude(), mag) == 0){
			   results.add(qe);
		   }
	   }
	   return results;
   }
   
   public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData, double dist, Location city){
	   ArrayList<QuakeEntry> results = new ArrayList<QuakeEntry>();
	   for(QuakeEntry qe : quakeData){
		   if(Double.compare(qe.getLocation().distanceTo(city), dist) >= 0){
			   results.add(qe);
		   }
	   }
	   return results;
   }
   public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f){
	   ArrayList<QuakeEntry> results = new ArrayList<QuakeEntry>();
	   for(QuakeEntry qe : quakeData){
		   if(f.satisfies(qe)){
			   results.add(qe);
		   }
	   }
	   return results;
   }
    public void dumpCSV(ArrayList<QuakeEntry> list){
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for(QuakeEntry qe : list){
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
			                  qe.getLocation().getLatitude(),
			                  qe.getLocation().getLongitude(),
			                  qe.getMagnitude(),
			                  qe.getInfo());
	    }
		
	}
	
	public void bigQuakes() {
	    EarthQuakeParser parser = new EarthQuakeParser();
        String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
       // String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");
        
        Filter f = new MagnitudeFilter(4.0);
        ArrayList<QuakeEntry> bigQuake = filter(list, f);
        System.out.println(bigQuake);
        Collections.sort(bigQuake);
        System.out.println(bigQuake);
        
	}
	
    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void findEarthQuakeTitle(){
    	EarthQuakeParser parser = new EarthQuakeParser();
    	String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("# quakes read: " + list.size());
        
        Filter f = new PhraseFilter(PhraseType.ANY, "earth");
        ArrayList<QuakeEntry> myQuake = filter(list, f);
        System.out.println(myQuake);
    }
    public void closeToMe() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("# quakes read: " + list.size());
        
        //Durham, NC
        //Location city = new Location(35.988, -78.907);
        //Bridgeport, CA
        Location city = new Location(38.17, -118.82);
        ArrayList<QuakeEntry> close = filterByDistanceFrom(list, 1000*1000, city);
        
        Collections.sort(close, new DistanceComparator(city));
        for (int k=0; k< close.size(); k++) {
            QuakeEntry entry = close.get(k);
            double distanceInMeters = city.distanceTo(entry.getLocation());
            System.out.println(distanceInMeters/1000 + " " + entry.getInfo());
        }
        
        // EarthQuake that is close to me
        
    }
    
    public static void main(String[] args){
    	EarthQuakeClient ec = new EarthQuakeClient();
    	ec.closeToMe();
    }
}
