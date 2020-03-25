package Stage1;


public class GameVictory extends Thread{

	int totalEnemyNum = 0;
	boolean running = true;

	GameVictory(int totalEnemyNum){
		this.totalEnemyNum = totalEnemyNum;
	}

	
	@Override
	public synchronized void run() {
		while (running) {
			try {
				
				if (Vegetable_VS_Enemy.enemyImage[totalEnemyNum - 1].getX() == 2000 && Vegetable_VS_Enemy.enemyImage[totalEnemyNum - 1].getY() == 2000) {
					//마지막으로 생성된 적이 죽고 5초 후  게임을 승리한다.
					Thread.sleep(5000);
					Vegetable_VS_Enemy.Stage1GameScene.setVisible(false);
					Vegetable_VS_Enemy.gameVictoryScene.setVisible(true);

				}

				Thread.sleep(1000);

			} catch (InterruptedException e) {
				running = false;
			}
		}
	}
}
