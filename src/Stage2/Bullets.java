package Stage2;


public class Bullets extends Thread {

	BulletMove[] bulletMove = new BulletMove[NUM_OF_BULLETS];
	
	final static int NUM_OF_BULLETS = 15; //염소 한마리가 생성될 때  생성되는 총알의 수 
	static int bulletsNum = 0; //bullets클래스의 수 
	int attackSpeed = 0;
	int attackInterval = 0;
	int animalNum = 0;
	boolean running = true;
	
	Bullets( int attackSpeed, int attackInterval, int animalNum) {

		this.attackSpeed = attackSpeed;
		this.attackInterval = attackInterval;
		this.animalNum = animalNum;
	}

	@Override
	public void run() {

		for(int i = 0; i < bulletMove.length; i++) {
			bulletMove[i] = new BulletMove(i, attackSpeed);
			bulletMove[i].start();
		}
		
		final int whatNumBullets = bulletsNum; //몇번째 총알 클래스인지  - 몇번째 클래스인가에 따라 담당하는  bulletImage[]가 달라진다. 
		
		while (running) {
			try {
				
				//염소를 생성할 때 마다 bullets 객체를 생성하는데 모든 bullets가 같은 bulletImage를 제어하면 안되기 때문에 담당 구역을 나눠서 제어했다.
				//i(총알 담당 구역) = bullets객체를 생성할 때 생성되는 bullets의 수(15) * bullet클래스의 수 - bullets객체를 생성할 때 생성되는 bullets의 수(빼지 않으면 bullets의 수인 15부터 시작한다)
				for (int i = bulletMove.length * whatNumBullets - Bullets.NUM_OF_BULLETS ; i < bulletMove.length* whatNumBullets ; i++) {
					if (Animal_VS_Enemy.bulletImage[i].getY() == -500) {
						//만약 자신이 담당한 총알이 -500이 되었다면 (총알 대기 장소에 있을 때)
						
						Animal_VS_Enemy.bulletImage[i].setLocation(Animal_VS_Enemy.animalImage.get(animalNum).getX() + 15 , Animal_VS_Enemy.animalImage.get(animalNum).getY() + 35);
						break;
					}
				}

				Thread.sleep(attackInterval);

			} catch (InterruptedException e) {
				running = false;
			}

		}
	}
}
