
public class MagnitudeFilter implements Filter{
	private double minMagnitude;
	
	public MagnitudeFilter(double minMag){
		this.minMagnitude = minMag;
	}
	
	public boolean satisfies(QuakeEntry qe){
		return Double.compare(qe.getMagnitude(), minMagnitude) >= 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName();
	}
	
	
}
