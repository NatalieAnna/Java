// Main class in default package
import redwine.RedWine;
class Main {
	public static void main(String[] args) {
		RedWine shiraz = new RedWine("red", 15, "high");
		System.out.println("Shiraz is a " + shiraz.getColour() + " wine with " +
											shiraz.getAlcohol() + "% alcohol and " + 
											shiraz.getTannin() + " tannins.");	
	}
}
