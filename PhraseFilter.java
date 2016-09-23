
public class PhraseFilter implements Filter {
	private PhraseType typePhrase;
	private String searchPhrase;

	public PhraseFilter(PhraseType typePhrase, String searchPhrase) {
		this.typePhrase = typePhrase;
		this.searchPhrase = searchPhrase;

	}

	public boolean satisfies(QuakeEntry qe) {
		String quakeTitle = qe.getInfo();
		if (typePhrase == PhraseType.START) {
			return quakeTitle.startsWith(searchPhrase);
		} else if (typePhrase == PhraseType.END) {
			return quakeTitle.endsWith(searchPhrase);
		} else if (typePhrase == PhraseType.ANY){
			return quakeTitle.contains(searchPhrase);
		}
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName();
	}
}
