Taking the public access example, when you add the 'final' keyword to the Wine class declaration you get a compile error:


	Exception in thread "main" java.lang.Error: Unresolved compilation problems: 

	The method getColour() is undefined for the type RedWine
	
	The method getAlcohol() is undefined for the type RedWine
	
	at Main.main(Main.java:6)

A final class obliterates a key benefit of OO - extensibility. Always assume that someday another programmer will need to extend your class (unless there are safety or security issues).
