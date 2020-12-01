package braveHero;

public class Hero {
 private Integer Viata, Putere, Aparare, Viteza,Noroc;
 Integer fortaDragonului;
 Integer scutulFermecat;
 boolean isGoodGuy;
 private String name;
 public static int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
public Hero(String name,int minViata, int maxViata,int minPutere,int maxPutere,int minAparare,int maxAparare,int minViteza,int maxViteza, int minNoroc,int maxNoroc,boolean isGoodGuy) {
	super();
	this.name=name;
	this.Viata = getRandomNumber(minViata, maxViata);
	this.Putere = getRandomNumber(minPutere, maxPutere);
	this.Aparare = getRandomNumber(minAparare, maxAparare);
	this.Viteza = getRandomNumber(minViteza, maxViteza);
	this.Noroc = getRandomNumber(minNoroc, maxNoroc);
	this.isGoodGuy= isGoodGuy;
	if(this.isGoodGuy) {
		this.fortaDragonului=10;
		this.scutulFermecat=20;
		
	}else {
		this.fortaDragonului=null;
		this.scutulFermecat=null;
		
	}
	
}

public boolean isGoodGuy() {
	return isGoodGuy;
}
public void setGoodGuy(boolean isGoodGuy) {
	this.isGoodGuy = isGoodGuy;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Hero [ name=");
	builder.append(name);
	builder.append(", Viata=");
	builder.append(Viata);
	builder.append(", Putere=");
	builder.append(Putere);
	builder.append(", Aparare=");
	builder.append(Aparare);
	builder.append(", Viteza=");
	builder.append(Viteza);
	builder.append(", Noroc=");
	builder.append(Noroc);
	builder.append(", fortaDragonului=");
	builder.append(fortaDragonului);
	builder.append(", scutulFermecat=");
	builder.append(scutulFermecat);
	builder.append(", isGoodGuy=");
	builder.append(isGoodGuy);
	
	builder.append("]");
	return builder.toString();
}
public Integer getViata() {
	return Viata;
}
public void setViata(Integer viata) {
	Viata = viata;
}
public Integer getPutere() {
	return Putere;
}
public void setPutere(Integer putere) {
	Putere = putere;
}
public Integer getAparare() {
	return Aparare;
}
public void setAparare(Integer aparare) {
	Aparare = aparare;
}
public Integer getViteza() {
	return Viteza;
}
public void setViteza(Integer viteza) {
	Viteza = viteza;
}
public Integer getNoroc() {
	return Noroc;
}
public void setNoroc(Integer noroc) {
	Noroc = noroc;
}
public Integer getFortaDragonului() {
	return fortaDragonului;
}
public void setFortaDragonului(Integer fortaDragonului) {
	this.fortaDragonului = fortaDragonului;
}
public Integer getScutulFermecat() {
	return scutulFermecat;
}
public void setScutulFermecat(Integer scutulFermecat) {
	this.scutulFermecat = scutulFermecat;
}
 
}
