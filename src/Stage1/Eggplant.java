package Stage1;

import java.util.ArrayList;

public class Eggplant extends Vegetable{

	// eggplant의 특징 - carrot의 업그레이드 버전, 공격속도가 빠르지만 공격 간격이 넓다
	ArrayList<Bullets> eggplantbullets = new ArrayList<Bullets>();
	
	@Override
	public void plantiInitialize() {
		attackSpeed = 10;
		attackInterval = 2000;
		necessaryMana = 7;
		Plants = "eggplant";
		ImageURL = "C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\vegatable VS enemy\\eggplant.png";
	}
	
	@Override
	public void attack() {
		Bullets eggplantBullets = new Bullets(attackSpeed,attackInterval);
		eggplantbullets.add(eggplantBullets);
		eggplantBullets.start();
		Bullets.bulletsNum++;
		BulletMove.totalBulletsNum = BulletMove.totalBulletsNum + Bullets.NUM_OF_BULLETS;
	}
} 
