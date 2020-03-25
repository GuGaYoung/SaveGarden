package Stage2;

public class Goat extends Animal{

	int attackSpeed = 0;
	
	@Override
	public void animalInitialize() {
		strength = 5;
		speed = 100;
		attackInterval = 5000;
		attackPower = 1;
		attackSpeed = 80;
		animalKind = "goat";
		ImageURL = "C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\animal VS enemy\\goat.png";
		Bullets.bulletsNum++;
		BulletMove.totalBulletsNum = BulletMove.totalBulletsNum + Bullets.NUM_OF_BULLETS;
	}
}
