package Stage1;

import java.util.ArrayList;

public class Redbeet extends Vegetable{
	
	// redbeet의 특징 - beet의 업그레이드 버전, 총알의 속도는 느리지만 발사 간격이 좁다.
	ArrayList<Bullets> redbeetbullets = new ArrayList<Bullets>();
	
	@Override
	public void plantiInitialize() {
		attackSpeed = 50;
		attackInterval = 1300;
		necessaryMana = 7;
		Plants = "redbeet";
		ImageURL = "C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\vegatable VS enemy\\redbeet.png";
	}
	
	@Override
	public void attack() {
		Bullets redbeetBullets = new Bullets(attackSpeed,attackInterval);
		redbeetbullets.add(redbeetBullets);
		redbeetBullets.start();
		Bullets.bulletsNum++;
		BulletMove.totalBulletsNum = BulletMove.totalBulletsNum + Bullets.NUM_OF_BULLETS;
	}
}  
