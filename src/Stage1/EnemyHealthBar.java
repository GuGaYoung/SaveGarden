package Stage1;


public class EnemyHealthBar extends Thread {
	
	//적의 체력관리와 체력바 업데이트 
	//적마다 하나씩 가지고 있는 멀티 쓰레드.
	
	boolean running = true;
	
	int strength = 0;
	int DamagedNum = 0;
	int enemyNum = 0;
	int barWidth  = 0;
	
	EnemyHealthBar(int strength, int enemyNum){
		this.strength = strength;
		this.enemyNum = enemyNum;
	}

	public void run() {
		while (running) {
			try {
				
				for (int i = 0; i < Vegetable_VS_Enemy.bulletImage.length; i++) {
					
					// 총알의과 적이 같은 타일일 때  총알의 x값이 적의 x값보다 크다면 (총알이 적에게 닿았다면)
					if ((Vegetable_VS_Enemy.bulletImage[i].getX() >= Vegetable_VS_Enemy.enemyImage[enemyNum].getX())
							&& (Vegetable_VS_Enemy.bulletImage[i].getY() == Vegetable_VS_Enemy.enemyImage[enemyNum].getY() + 60)) {

						// 총알x값이 적의 좌표 아주 뒤에 있지 않을 때 (적 뒤에 있는 총알로 인해 체력이 깍이지 않도록)
						if (Vegetable_VS_Enemy.bulletImage[i].getX() <= Vegetable_VS_Enemy.enemyImage[enemyNum].getX() + 50) {
							
							// 적에게 닿은 총알은 대기위치로 이동
							Vegetable_VS_Enemy.bulletImage[i].setLocation(1300, Vegetable_VS_Enemy.bulletImage[i].getY());

							// 밭은 데미지를 더한다
							//System.out.println(DamagedNum);
							DamagedNum++;
							
							// 적의 체력바의 길이를 체력바의 길이/전체체력 + 1 만큼 줄인다. (반올림 문제로 피가 덜 깍일 때가 있어 +1을 했다.)
							barWidth = (Vegetable_VS_Enemy.healthBarImage[enemyNum].getWidth() / strength) +1;
							Vegetable_VS_Enemy.healthBarImage[enemyNum].setSize(
									Vegetable_VS_Enemy.healthBarImage[enemyNum].getWidth() - barWidth,
									Vegetable_VS_Enemy.healthBarImage[enemyNum].getHeight());

							// 밭은 데미지가 체력과 같다면
							if (strength < DamagedNum) {
								// 받은 데미지를 초기화하고
								DamagedNum = 0;
								// 적 이미지와 체력이미지를 대기장소로 이동시킨다.
								Vegetable_VS_Enemy.enemyImage[enemyNum].setLocation(2000, 2000);
								Vegetable_VS_Enemy.healthBarImage[enemyNum].setLocation(2000, 2000);
								Vegetable_VS_Enemy.healthBarBackground[enemyNum].setLocation(2000, 2000);
							}
						}
					}
				}
				Thread.sleep(100);

			} catch (InterruptedException e) {

			}
		}
	}
}
