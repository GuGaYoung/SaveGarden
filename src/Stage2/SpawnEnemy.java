package Stage2;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SpawnEnemy extends Thread {

	Random random = new Random();
	
	boolean running = true;
	int randomEnemy = 0;
	int randomSpawnTime = 0;
	int minTime = 6000;
	int maxTime = 10000;
	static int enemyNum = 0;
	String enemyImageURL = "";
	
	@Override
	synchronized public void run() {

		while (running) {
			try {

				randomEnemy = random.nextInt(4);
				randomSpawnTime = random.nextInt(maxTime - minTime + 1) + minTime;
								
				Thread.sleep(randomSpawnTime);

				
				Animal_VS_Enemy.enemyImage.add(new JLabel());
				Animal_VS_Enemy.enemyhealthBarImage.add(new JLabel());
				
				if (randomEnemy == 0) {
					Bandit bandit = new Bandit();
					bandit.enemyInitialize();
					Animal_VS_Enemy.enemyList.add(bandit);
					Animal_VS_Enemy.banditList.add(bandit);
					enemyImageURL = bandit.ImageURL;
					EnemyMove enemyMove = new EnemyMove(enemyNum, bandit.speed, bandit.enemyKind);
					enemyMove.start();
					EnemyAttack enemyAttack = new EnemyAttack(enemyNum, bandit.attackPower, bandit.attackInterval, bandit.enemyKind, enemyMove);
					enemyAttack.start();
					
				} else if (randomEnemy == 1) {
					Piracy piracy = new Piracy();
					piracy.enemyInitialize();
					Animal_VS_Enemy.enemyList.add(piracy);
					Animal_VS_Enemy.piracyList.add(piracy)
;					enemyImageURL = piracy.ImageURL;
					EnemyMove enemyMove = new EnemyMove(enemyNum, piracy.speed, piracy.enemyKind);
					enemyMove.start();
					EnemyAttack enemyAttack = new EnemyAttack(enemyNum, piracy.attackPower, piracy.attackInterval, piracy.enemyKind,enemyMove);
					enemyAttack.start();
					
				} else if (randomEnemy == 2) {
					Jingjing jingjing = new Jingjing();
					jingjing.enemyInitialize();
					Animal_VS_Enemy.enemyList.add(jingjing);
					Animal_VS_Enemy.jingjingList.add(jingjing);
					enemyImageURL = jingjing.ImageURL;
					EnemyMove enemyMove = new EnemyMove(enemyNum, jingjing.speed, jingjing.enemyKind);
					enemyMove.start();
					EnemyAttack enemyAttack = new EnemyAttack(enemyNum, jingjing.attackPower, jingjing.attackInterval, jingjing.enemyKind, enemyMove);
					enemyAttack.start();
					
				} else if (randomEnemy == 3) {
					Thief thief = new Thief();
					thief.enemyInitialize();
					Animal_VS_Enemy.enemyList.add(thief);
					Animal_VS_Enemy.thiefList.add(thief);
					enemyImageURL = thief.ImageURL;
					EnemyMove enemyMove = new EnemyMove(enemyNum, thief.speed, thief.enemyKind);
					enemyMove.start();
					EnemyAttack enemyAttack = new EnemyAttack(enemyNum, thief.attackPower, thief.attackInterval, thief.enemyKind, enemyMove);
					enemyAttack.start();
				}
				
				Animal_VS_Enemy.Stage2GameScene.add(Animal_VS_Enemy.enemyImage.get(enemyNum));
				Animal_VS_Enemy.enemyImage.get(enemyNum).setBounds(1200, 400, 70, 80);
				Animal_VS_Enemy.enemyImage.get(enemyNum).setIcon(new ImageIcon(enemyImageURL));
				
				Animal_VS_Enemy.Stage2GameScene.add(Animal_VS_Enemy.enemyhealthBarImage.get(enemyNum));
				Animal_VS_Enemy.enemyhealthBarImage.get(enemyNum).setBounds(1200, 350, 36, 4);
				Animal_VS_Enemy.enemyhealthBarImage.get(enemyNum).setIcon(new ImageIcon("C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\vegatable VS enemy\\healthbar_red.png"));
				
				enemyNum++;
				
				//만약 적기지가 무너졌으면 생성을 그만한다.
				if(Animal_VS_Enemy.enemyBaseImage.getX() == 1500) {
					wait();
				}

			} catch (InterruptedException e) {
				running = false;
			}
		}
	}
}
