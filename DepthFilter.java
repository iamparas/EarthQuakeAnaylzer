
public class DepthFilter implements Filter{
	private double depth;
	
	public DepthFilter(double depth){
		this.depth = depth;
	}
	
	public boolean satisfies(QuakeEntry qe){
		return Double.compare(qe.getDepth(), this.depth) >= 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName();
	}
}
