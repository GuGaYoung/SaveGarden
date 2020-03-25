package Stage1;

import java.util.ArrayList;

public class Cabbage extends Vegetable{

	//cabbage의 특징 - 가장 기본적인 야채
	ArrayList<Bullets> cabbagebullets = new ArrayList<Bullets>();
	
	@Override
	public void plantiInitialize() {
		attackSpeed = 30;
		attackInterval = 2000;
		necessaryMana = 3;
		Plants = "cabbage";
		ImageURL = "C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\vegatable VS enemy\\cabbage.png";
	}
	
	@Override
	public void attack() {
		Bullets cabbageBullets = new Bullets(attackSpeed,attackInterval);
		cabbagebullets.add(cabbageBullets);
		cabbageBullets.start();
		Bullets.bulletsNum++;
		BulletMove.totalBulletsNum = BulletMove.totalBulletsNum + Bullets.NUM_OF_BULLETS;
	}

}
