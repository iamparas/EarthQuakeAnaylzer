import java.util.Comparator;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry>{

	public int compare(QuakeEntry q1, QuakeEntry q2){
		String[] q1Array = q1.getInfo().split(" ");
		String[] q2Array = q2.getInfo().split(" ");
		
		String q1LastTitle = q1Array[q1Array.length - 1];
		String q2LastTitle = q2Array[q2Array.length - 1];
		
		int q1LastTitleCompVal = q1LastTitle.compareTo(q2LastTitle);
		if(q1LastTitleCompVal == 0){
			return Double.compare(q1.getMagnitude(), q2.getMagnitude());
		}
		return q1LastTitleCompVal;
	}
}
