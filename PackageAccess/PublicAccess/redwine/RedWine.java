// subclass RedWine in package redwine
package redwine;
import beverage.Wine;
public class RedWine extends Wine {

	String tannin;
	
	public RedWine(String col, int alc, String tan) {
		colour = col;
		alcohol = alc;
		tannin = tan;
	}

	public String getTannin() {
		return tannin;
	}
}