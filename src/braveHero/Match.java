package braveHero;

public class Match {
private Hero hero;
private Hero antiHero;
private int nrTure;
public static int nrMaxTure= 20;
public Hero getHero() {
	return hero;
}
public void setHero(Hero hero) {
	this.hero = hero;
}
public Hero getAntiHero() {
	return antiHero;
}
public void setAntiHero(Hero antiHero) {
	this.antiHero = antiHero;
}
public Match(Hero hero, Hero antiHero) {
	super();
	this.hero = hero;
	this.antiHero = antiHero;
	this.nrTure=0;
}

public Hero whoGoesFirst(Hero h1,Hero h2) {
	
	if(h1.getViteza()>h2.getViteza()) {
		return h1;
	}else if(h1.getViteza()<h2.getViteza()) {
		return h2;
	}else if(h1.getViteza()==h2.getViteza()) {
		if(h1.getNoroc()>h2.getNoroc())
			return h1;
		else return h2;
	}
	return h2;
}
public void atacNormal(Hero attaker,Hero defender) {
	int damage= attaker.getPutere()-defender.getAparare();
	if(damage<=0)
		damage=0;
	if(damage>=100)
		damage=100;
	defender.setViata(defender.getViata()-damage);
	
}
public void atacFortaDragonului(Hero attaker,Hero defender) {
	attaker.setPutere(attaker.getPutere()*2);
	int damage= attaker.getPutere()-defender.getAparare();
	if(damage<=0)
		damage=0;
	if(damage>=100)
		damage=100;
	defender.setViata(defender.getViata()-damage);
	attaker.setPutere(attaker.getPutere()/2);
	
}
public void atacScutulFermecat(Hero attacker, Hero defender) {
	attacker.setPutere(attacker.getPutere()/2);
	int damage= attacker.getPutere()-defender.getAparare();
	if(damage<=0)
		damage=0;
	if(damage>=100)
		damage=100;
	defender.setViata(defender.getViata()-damage);
	
	attacker.setPutere(attacker.getPutere()*2);
	
}
public void round(Hero attaker,Hero defender) {
	if(attaker.getViata()>0 && defender.getViata()>0) {
		if(nrTure< nrMaxTure-1) {
			System.out.println("runda numarul:  "+ nrTure + " atacator : "+ attaker.getName()+ " aparator :" + defender.getName());
	//will the attacker miss?
			int x=Hero.getRandomNumber(0, 100);
			if(x<=defender.getNoroc()) {
		System.out.println(defender.getName()+ " a avut noroc de data asta !"+ attaker.getName() + " a ratat!");
		nrTure++;
		round(defender,attaker);
		
			
	}else {
		if(attaker.isGoodGuy) {//dublarea atcului aka forta dragonului 
			int fortaDragonului= Hero.getRandomNumber(0, 100);
			if(attaker.getFortaDragonului()!=null) {
				if(fortaDragonului<= attaker.getFortaDragonului()) {
					System.out.println( attaker.getName()+ " va folosi forta dragonului! ");
					atacFortaDragonului(attaker, defender);
					System.out.println(attaker.toString());
					System.out.println(defender.toString());
					if(defender.getViata()<=0) {
						System.out.println(attaker.getName() +" A INVINS!!!");
					}else {
					nrTure++;
					round(defender,attaker);
					}
				}else {
					//atac normal
					atacNormal(attaker, defender);
					System.out.println(attaker.toString());
					System.out.println(defender.toString());
					if(defender.getViata()<=0) {
						System.out.println(attaker.getName() +" A INVINS!!!");
					}else {
					nrTure++;
					round(defender,attaker);
					}
				}
			}
			
		}else {//daca ataca bestia eroul poate folosi scutul fermecat
			int scutulFermecat = Hero.getRandomNumber(0, 100);
			if(defender.getScutulFermecat()!=null) {
				if(scutulFermecat <= defender.getScutulFermecat()) {
					System.out.println( defender.getName()+ " va folosi scutul fermecat! ");
					atacScutulFermecat(attaker, defender);
					System.out.println(attaker.toString());
					System.out.println(defender.toString());
					if(defender.getViata()<=0) {
						System.out.println(attaker.getName() +" A INVINS!!!");
					}else {
					nrTure++;
					round(defender,attaker);
					}
				}else {
					//atac normal
					atacNormal(attaker, defender);
					System.out.println(attaker.toString());
					System.out.println(defender.toString());
					if(defender.getViata()<=0) {
						System.out.println(attaker.getName() +" A INVINS!!!");
					}else {
					nrTure++;
					round(defender,attaker);
						}
						}
		}
			}
		}
			}
	}
}
public void start() {
System.out.println("incepe confruntarea intre cele doua personaje : ");
System.out.println(hero.toString());
System.out.println(antiHero.toString());
Hero first = whoGoesFirst(hero, antiHero);
System.out.println( first.getName()+ " va ataca primul! ");
if(first.equals(hero)) {
	round(hero,antiHero);
	
}else {
	round(antiHero,hero);
}
}



}
