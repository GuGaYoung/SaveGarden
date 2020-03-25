package Stage1;


public class GameOver extends Thread {

	//게임 오버를 체크하는 쓰레드
	
	boolean running = true;

	@Override
	public synchronized void run() {
		while (running) {
			try {
				
				for (int i = 0; i < Vegetable_VS_Enemy.enemyImage.length; i++) {
					//적이 집에 도착했다면 
					if (Vegetable_VS_Enemy.enemyImage[i].getX() < 100) {
						//게임오버가 된다
						Vegetable_VS_Enemy.Stage1GameScene.setVisible(false);
						Vegetable_VS_Enemy.gameOverScene.setVisible(true);
					}
				}

				Thread.sleep(100);

			} catch (InterruptedException e) {
				running = false;
			}
		}
	}
}
