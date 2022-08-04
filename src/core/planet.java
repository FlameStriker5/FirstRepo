package core;

public class planet {
	public int positionFromSun;
	String name;
	String colour;
	boolean hasMoon;
	
	public planet(int positionFromSun, String name, String colour, boolean hasMoon) {
		super();
		this.positionFromSun = positionFromSun;
		this.name = name;
		this.colour = colour;
		this.hasMoon = hasMoon;
	}

	@Override
	public String toString() {
		Object m;
		if(hasMoon) {
			m = "has a moon";}
		else {
		m = "doesnt have a moon";}
		
		return "Planet is "+name+" at position "+positionFromSun+" having colour "+colour+" and "+m;
	}
}
