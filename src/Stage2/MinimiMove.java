package Stage2;

import java.util.Random;

public class MinimiMove extends Thread{
	
	Random random = new Random();
	
	int speed = 100;
	int minimiNum = 0;
	int animalNum = 0;
	static int totalMinimiNum = 0;
	boolean running = true;
	
	MinimiMove(int minimiNum, int animalNum) {
		this.minimiNum = minimiNum + totalMinimiNum - Minimis.NUM_OF_MINIMIS;
		this.animalNum = animalNum;
	}
	
	@Override
	synchronized public void run() {

		Animal_VS_Enemy.minimiImage[minimiNum].setLocation(Animal_VS_Enemy.animalImage.get(animalNum).getX() + random.nextInt(20), 460);
		
		while (running) {
			try {
				Animal_VS_Enemy.minimiImage[minimiNum].setLocation(Animal_VS_Enemy.minimiImage[minimiNum].getX() + 1,
						Animal_VS_Enemy.minimiImage[minimiNum].getY());

				// 적기지 근처에 도착한 후
				if (Animal_VS_Enemy.minimiImage[minimiNum].getX() >= Animal_VS_Enemy.ENEMYBASE_X) {

					// 적기지가 무너진 상태가 아니라면
					if (Animal_VS_Enemy.enemyBaseImage.getX() != 1500) {
						// 쓰레드를  멈춘다
						wait();
					}
				}
				
				if(Animal_VS_Enemy.minimiImage[minimiNum].getX() == -500) {
					wait();
				}
				
				Thread.sleep(speed);
				
			} catch (InterruptedException e) {
				running = false;
			}
		}
	}
}
