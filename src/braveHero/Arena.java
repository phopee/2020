package braveHero;

public class Arena {

	public static void main(String[] args) {
		Hero Carl = new Hero("Carl",65,95,60,70,40,50,40,50,10,30,true);
		Hero bestie = new Hero("bestia",55,80,50,80,35,55,40,60,25,40,false);
		
		Match m1= new Match(Carl, bestie);

		m1.start();
	
	}
	
	}


