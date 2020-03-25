package Stage2;

public class Thief extends Enemy{

	@Override
	public void enemyInitialize() {
		
		strength = 12;
		speed = 30;
		attackPower = 1;
		attackInterval = 300;
		enemyKind = "thief";
		ImageURL = "C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\animal VS enemy\\thief.png";

	}
}
