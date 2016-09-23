import java.util.ArrayList;

public class MatchMultipleFilters implements Filter {
	
	private  ArrayList<Filter> filters;
	
	public void addFilter(Filter newFilter){
		filters.add(newFilter);
	}

	@Override
	public boolean satisfies(QuakeEntry qe) {
		
		for(Filter f : filters){
			if(!f.satisfies(qe)){
				return false;
			}
		}
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		StringBuilder filterName = new StringBuilder();
		for(Filter f : filters){
			filterName.append(f.getClass().getSimpleName());
		}
		return filterName.toString();
	}

}
