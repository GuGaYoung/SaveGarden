package Stage2;

public class Piracy extends Enemy{
	
	@Override
	public void enemyInitialize() {
		
		strength = 13;
		speed = 100;
		attackPower = 1;
		attackInterval = 600;
		enemyKind = "piracy";
		ImageURL = "C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\animal VS enemy\\piracy.png";

	}
}
