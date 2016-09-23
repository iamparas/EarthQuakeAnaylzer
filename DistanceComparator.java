import java.util.Comparator;

public class DistanceComparator implements Comparator<QuakeEntry>{
	Location fromWhere;
	
	public DistanceComparator(Location where){
		this.fromWhere = where;
	}
	
	public int compare(QuakeEntry q1, QuakeEntry q2){
		return Double.compare(fromWhere.distanceTo(q1.getLocation()), fromWhere.distanceTo(q2.getLocation()));
	}

}
