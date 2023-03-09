
public class City {
String name;
int population;
Person livein;

public City() {
	// TODO Auto-generated constructor stub
}

public City(String name, int population, Person livein) {
	super();
	this.name = name;
	this.population = population;
	this.livein = livein;
}

public void printCity() {
	System.out.println(name);
	System.out.println(population);
	if(livein!=null) {
		livein.printInfo();
	}
}
}
