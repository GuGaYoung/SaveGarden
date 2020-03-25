package Stage1;


public class EnemyMove extends Thread{
 
	int speed = 0;
	int enemyNum = 0;
	boolean running = true;
	
	EnemyMove(int enemyNum, int speed){
		this.enemyNum = enemyNum;
		this.speed = speed;
	}
	
	@Override
	public void run() {
		while (running) {
			try {
				//적의 위치가 적의 대기장소가 아니라면 
				if(Vegetable_VS_Enemy.enemyImage[enemyNum].getX() != 2000 && Vegetable_VS_Enemy.enemyImage[enemyNum].getY() != 2000) {
					//적의 위치와 체력바의 위치를 왼쪽으로 옮긴다.
					Vegetable_VS_Enemy.enemyImage[enemyNum].setLocation(Vegetable_VS_Enemy.enemyImage[enemyNum].getX() - 5,Vegetable_VS_Enemy.enemyImage[enemyNum].getY());
					Vegetable_VS_Enemy.healthBarImage[enemyNum].setLocation(Vegetable_VS_Enemy.enemyImage[enemyNum].getX() - 5, Vegetable_VS_Enemy.enemyImage[enemyNum].getY() + 80);
					Vegetable_VS_Enemy.healthBarBackground[enemyNum].setLocation(Vegetable_VS_Enemy.enemyImage[enemyNum].getX() - 5,Vegetable_VS_Enemy.enemyImage[enemyNum].getY() + 80);
				}
				Thread.sleep(speed);

			} catch (InterruptedException e) {
				running = false;
			}
		}
	}
}
