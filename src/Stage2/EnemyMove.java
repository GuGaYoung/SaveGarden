package Stage2;

public class EnemyMove extends Thread {

	int speed = 0;
	int enemyNum = 0;
	boolean running = true;
	String enemyKind = "";
	
	EnemyMove(int enemyNum, int speed, String enemyKind) {
		this.enemyNum = enemyNum;
		this.speed = speed;
		this.enemyKind = enemyKind;
	}

	@Override
	public void run() {
		Animal_VS_Enemy.enemyImage.get(enemyNum).setLocation(1000, 400);
		Animal_VS_Enemy.enemyhealthBarImage.get(enemyNum).setLocation(1000, 350);
		synchronized (this) {
			while (running) {
				try {
						
					
					// 앞으로 이동한다
					Animal_VS_Enemy.enemyImage.get(enemyNum).setLocation(Animal_VS_Enemy.enemyImage.get(enemyNum).getX() - 5, 400);
					Animal_VS_Enemy.enemyhealthBarImage.get(enemyNum).setLocation(Animal_VS_Enemy.enemyImage.get(enemyNum).getX() + 30, 350);

					// 동물기지 근처에 도착한 후
					if (Animal_VS_Enemy.enemyImage.get(enemyNum).getX() <= Animal_VS_Enemy.ANIMALBASE_X) {

						// 동물기지가 무너진 상태가 아니라면
						if (Animal_VS_Enemy.animalBaseImage.getX() != -500) {
							wait(10000);
						}
					}

					if(enemyKind == "jingjing" || enemyKind == "bandit" || enemyKind == "piracy") {
						
						for (int i = 0; i < Animal_VS_Enemy.animalImage.size(); i++) {
							// 동물이 범위 안에 들어왔을 때
							if (Animal_VS_Enemy.enemyImage.get(enemyNum).getX() <= Animal_VS_Enemy.animalImage.get(i).getX() + 15 && 
									Animal_VS_Enemy.enemyImage.get(enemyNum).getX() >= Animal_VS_Enemy.animalImage.get(i).getX() - 10) {
								wait(3000);
							}
						}
					}
					
					if (Animal_VS_Enemy.enemyImage.get(enemyNum).getX() == 1500 && Animal_VS_Enemy.enemyImage.get(enemyNum).getY() == 1500) {
						wait();
					}
					
					Thread.sleep(speed);

				} catch (InterruptedException e) {
					running = false;
				}
			}
		}
	}
}
