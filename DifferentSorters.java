import java.util.ArrayList;
import java.util.Collections;

public class DifferentSorters {
	public void sortWithCompareTo(){
		EarthQuakeParser parser = new EarthQuakeParser();
    	String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        
        Collections.sort(list);
        System.out.println(list);
	}
	
	public void sortWithTitleAndDepth(){
		EarthQuakeParser parser = new EarthQuakeParser();
    	String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        
        Collections.sort(list, new TitleAndDepthComparator());
        System.out.println(list);
	}
	
	public void sortWithTitleLastAndMagnitude(){
		EarthQuakeParser parser = new EarthQuakeParser();
    	String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        
        Collections.sort(list, new TitleLastAndMagnitudeComparator());
        System.out.println(list);
	}
	public static void main(String[] args){
		DifferentSorters sorter = new DifferentSorters();
		sorter.sortWithTitleAndDepth();
	}
}
