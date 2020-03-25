package Stage1;

import java.util.ArrayList;

public class Beet extends Vegetable{
	
	// Beet의 특징 - 총알의 속도는 느리지만 발사 간격이 좁다.
	ArrayList<Bullets> beetbullets = new ArrayList<Bullets>();
	
	@Override
	public void plantiInitialize() {
		attackSpeed = 80;
		attackInterval = 1300;
		necessaryMana = 5;
		Plants = "beet";
		ImageURL = "C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\vegatable VS enemy\\beat.png";
	}
	
	@Override
	public void attack() {
		Bullets beetBullets = new Bullets(attackSpeed,attackInterval);
		beetbullets.add(beetBullets);
		beetBullets.start();
		Bullets.bulletsNum++;
		BulletMove.totalBulletsNum = BulletMove.totalBulletsNum + Bullets.NUM_OF_BULLETS;
	}
} 
