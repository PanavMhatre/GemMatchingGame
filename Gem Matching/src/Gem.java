import java.awt.Color;
import java.awt.Font;
import java.util.Random;

enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}

public class Gem 
{
	public static final Color WHITE = new Color(255,255,255);
	private final int[] numbers = {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
	private final GemType[] colors = {GemType.GREEN, GemType.BLUE, GemType.ORANGE};

	int points;
	GemType type;
	
	public Gem() {
		Random randNum = new Random();
		Random randColor = new Random();
		int c = randNum.nextInt(numbers.length);
        int i = randColor.nextInt(colors.length);
		points = numbers[c];
		type = colors[i];
	}
	public Gem(GemType type, int points) {
		this.type = type;
		this.points = points;
	}
	@Override
	public String toString() {
		return type + " : " + points; 
	}
	public GemType getType() {
		return type;
	}
	public int getPoints() {
		return points;
	}
	public void draw(double x, double y) {
		String fileName = "";
		switch(type) {
			case GREEN:
				fileName = "gem_green.png";
				break;
			case ORANGE:
				fileName = "gem_orange.png";
				break;
			case BLUE:
				fileName = "gem_blue.png";
				break;
		}
        StdDraw.point(x,y);
        StdDraw.picture( x, y, fileName);
        Font font = new Font("Arial", Font.BOLD, 15);
        StdDraw.setPenColor(WHITE);
        StdDraw.setFont(font);
        StdDraw.setPenRadius(.010);
        StdDraw.text(x, y, points + "");
        StdDraw.show();
	}
	
	/** Tester main method */
	public static void main(String [] args)
	{
		final int maxGems = 16;
		
		// Create a gem of each type
		Gem green  = new Gem(GemType.GREEN, 10);
		Gem blue   = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());		
		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);
		
		// A row of random gems
		for (int i = 0; i < maxGems; i++)
		{
			Gem g = new Gem();
			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
		}
	}
}
