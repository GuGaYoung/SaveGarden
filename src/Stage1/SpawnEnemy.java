package Stage1;

import java.util.Random;
import javax.swing.ImageIcon;

public class SpawnEnemy extends Thread{

	//랜덤으로 나오는 적을 랜덤 위치에 스폰하는 쓰레드
	
	EnemyMove[] enemyMove = new EnemyMove[10];
	EnemyHealthBar[] enemyHealthBar = new EnemyHealthBar[10];
	Random random = new Random();
	
	int randomEnemy = 0;
	int randomSeat = 0;
	int randomTime = 0;
	int locationX = 0;
	int locationY = 0;
	static int enemyNum = 0;
	static int enemyMaxNum = 10;
	
	boolean running = true;
	
	@Override
	public void run() {
		
		while (running) {
			try {
				if (enemyNum < enemyMaxNum) {
					
					randomEnemy = random.nextInt(3);
					randomSeat = random.nextInt(5);
					randomTime = random.nextInt(5000);
					
					// 적의 위치 선정
					locationX = 870;
					if (randomSeat == 0) {
						locationY = 59;

					} else if (randomSeat == 1) {
						locationY = 150;

					} else if (randomSeat == 2) {
						locationY = 234;

					} else if (randomSeat == 3) {
						locationY = 322;

					} else if (randomSeat == 4) {
						locationY = 410;
					}

					//적의 종류 선정
					if (randomEnemy == 0) { 
						SkeletonHead skeletonHead = new SkeletonHead();
						skeletonHead.enemyInitialize();
						Vegetable_VS_Enemy.enemyImage[enemyNum].setIcon(new ImageIcon(skeletonHead.ImageURL));
						enemyMove[enemyNum] = new EnemyMove(enemyNum, skeletonHead.speed);
						enemyHealthBar[enemyNum] = new EnemyHealthBar(skeletonHead.strength, enemyNum);
						
					} else if (randomEnemy == 1) {
						BlueGhost blueGhost = new BlueGhost();
						blueGhost.enemyInitialize();
						Vegetable_VS_Enemy.enemyImage[enemyNum].setIcon(new ImageIcon(blueGhost.ImageURL));
						enemyMove[enemyNum] = new EnemyMove(enemyNum, blueGhost.speed);
						enemyHealthBar[enemyNum] = new EnemyHealthBar(blueGhost.strength, enemyNum);
						
					} else if (randomEnemy == 2) {
						OrangeGhost orangeGhost = new OrangeGhost();
						orangeGhost.enemyInitialize();
						Vegetable_VS_Enemy.enemyImage[enemyNum].setIcon(new ImageIcon(orangeGhost.ImageURL));
						enemyMove[enemyNum] = new EnemyMove(enemyNum, orangeGhost.speed);
						enemyHealthBar[enemyNum] = new EnemyHealthBar(orangeGhost.strength, enemyNum);
						
					}

					Vegetable_VS_Enemy.enemyImage[enemyNum].setLocation(locationX, locationY);
					enemyMove[enemyNum].start();
					enemyHealthBar[enemyNum].start();

					enemyNum++;
				}
				
				Thread.sleep(randomTime);
				
			} catch (InterruptedException e) {
				running = false;
			}
		}
	}
}
