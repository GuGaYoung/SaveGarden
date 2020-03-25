package Stage2;
import java.util.Random;

public class AnimalMove extends Thread {

	Random random = new Random();
	
	int speed = 0;
	int animalNum = 0;
	String animalKind = "";
	boolean running = true;
	boolean isMoveOnce = false;//염소를 움직일 때 사용
	
	AnimalMove(int animalNum, int speed, String animalKind) {
		this.animalNum = animalNum;
		this.speed = speed;
		this.animalKind = animalKind;
	}

	@Override
	public void run() {
		Animal_VS_Enemy.animalImage.get(animalNum).setLocation(60, 400);
		Animal_VS_Enemy.animalhealthBarImage.get(animalNum).setLocation(60, 380);
		synchronized (this) {
			while (running) {
				try {
					if(animalKind == "rabbit" || animalKind == "pig" || animalKind == "chick") {
					
						Animal_VS_Enemy.animalImage.get(animalNum).setLocation(Animal_VS_Enemy.animalImage.get(animalNum).getX() + 5, 400);
						Animal_VS_Enemy.animalhealthBarImage.get(animalNum).setLocation(Animal_VS_Enemy.animalImage.get(animalNum).getX() + 10, 380);
						
						//적기지 근처에 도착한 후 
						if (Animal_VS_Enemy.animalImage.get(animalNum).getX() >= Animal_VS_Enemy.ENEMYBASE_X) {

							//적기지가 무너진 상태가 아니라면 
							if(Animal_VS_Enemy.enemyBaseImage.getX() != 1500) {
								//쓰레드를 일정시간동안 멈춘다
								wait(10000);
							}
						}
					}
					
					if(animalKind == "pig" || animalKind == "chick") {
						
						for (int i = 0; i < Animal_VS_Enemy.enemyImage.size(); i++) {
							// 적이 범위 안에 들어왔을 때
							if (Animal_VS_Enemy.animalImage.get(animalNum).getX() >= Animal_VS_Enemy.enemyImage.get(i).getX() - 15
									&& Animal_VS_Enemy.animalImage.get(animalNum).getX() <= Animal_VS_Enemy.enemyImage.get(i).getX() + 5) {
								wait(3000);
							}
						}
						
					}

					if(animalKind == "goat") {
						if (isMoveOnce == false) {
							Animal_VS_Enemy.animalImage.get(animalNum).setLocation(Animal_VS_Enemy.animalImage.get(animalNum).getX() + random.nextInt(50), 400);
							Animal_VS_Enemy.animalhealthBarImage.get(animalNum).setLocation(Animal_VS_Enemy.animalImage.get(animalNum).getX(), 380);
							isMoveOnce = true;
						}
					}
					
					//동물이 죽은 장소에 있었을 때
					if (Animal_VS_Enemy.animalImage.get(animalNum).getX() == -500 && Animal_VS_Enemy.animalImage.get(animalNum).getY() == -500) {
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
