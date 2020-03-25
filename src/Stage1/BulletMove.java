package Stage1;

public class BulletMove extends Thread {

	// 총알 생성 및 움직이기 스피드와 공격력을 받는다.
	int attackSpeed = 0;
	int bulletNum = 0;
	public static int totalBulletsNum = 0;
	boolean running = true;
	boolean islive = true;
	
	BulletMove(int bulletNum,  int attackSpeed) {
		this.attackSpeed = attackSpeed;
		this.bulletNum = bulletNum + totalBulletsNum - Bullets.NUM_OF_BULLETS;
	}

	@Override
	public  void run() {
		
		Vegetable_VS_Enemy.bulletImage[bulletNum].setLocation(-500, -500);
		
		while (running) {
			try {
				if (islive == true) {

					if (Vegetable_VS_Enemy.bulletImage[bulletNum].getX() != -500) {
						// 총알이 맨 처음 초기화 시 좌표가 아닌 새로 지정된 좌표라면..(채소가 생성될 때 좌표가 새로 지정된다.)
						Vegetable_VS_Enemy.bulletImage[bulletNum].setLocation(Vegetable_VS_Enemy.bulletImage[bulletNum].getX() + 5,
								Vegetable_VS_Enemy.bulletImage[bulletNum].getY());

					}
					if (Vegetable_VS_Enemy.bulletImage[bulletNum].getX() >= 1000) {
						//총알이 화면 밖을 넘었다면 
						Vegetable_VS_Enemy.bulletImage[bulletNum].setLocation(1300, Vegetable_VS_Enemy.bulletImage[bulletNum].getY());
						
					}
				} 
				Thread.sleep(attackSpeed);
				//System.out.println("attackSpeed" + attackSpeed + " Y" + main.bulletImage[num].getY() + " num" +num);
			} catch (InterruptedException e) {
				running = false;
			}
		}
	}
}
