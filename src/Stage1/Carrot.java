package Stage1;

import java.util.ArrayList;

public class Carrot extends Vegetable{

	//carrot의 특징 - 공격속도가 빠르지만 공격 간격이 넓다
	ArrayList<Bullets> carrotbullets = new ArrayList<Bullets>();
	
	public void plantiInitialize() {
		attackSpeed = 10;
		attackInterval = 3000;
		necessaryMana = 5;
		Plants = "carrot";
		ImageURL = "C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\vegatable VS enemy\\carrot.png";
	}
	

	public void attack() {
		Bullets carrotBullets = new Bullets(attackSpeed,attackInterval);
		carrotbullets.add(carrotBullets);
		carrotBullets.start();
		Bullets.bulletsNum++;
		BulletMove.totalBulletsNum = BulletMove.totalBulletsNum + Bullets.NUM_OF_BULLETS;
	}
	
} 
