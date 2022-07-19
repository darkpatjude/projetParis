package fiveFoot;

import fivefoot.entities.Article;
import fivefoot.entities.Ballon;

public class AppTest {

	public static void main(String[] args) {
		
		Article b=new Ballon("s", "blanc");
		b.setPrix(5);
		System.out.println("le prix " +b.getPrix());
	}

}
