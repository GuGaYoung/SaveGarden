package Stage2;

public class Bandit extends Enemy{

	@Override
	public void enemyInitialize() {
		
		strength = 23;
		speed = 150;
		attackInterval = 900;
		attackPower = 5;
		enemyKind = "bandit";
		ImageURL = "C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\animal VS enemy\\bandit.png";

	}
}
