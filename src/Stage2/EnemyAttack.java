package Stage2;

public class EnemyAttack extends Thread {

	boolean running = true;
	int enemyNum = 0;
	int attackPower = 0;
	int attackInterval = 0;
	int whatNum = 0;
	Thread enemyMove;
	String animalKind = "";
	String enemyKind = "";
	EnemyAttackInterval enemyAttackInterval;

	EnemyAttack(int enemyNum, int attackPower, int attackInterval, String enemyKind, Thread enemyMove) {
		this.enemyNum = enemyNum;
		this.attackPower = attackPower;
		this.attackInterval = attackInterval;
		this.enemyKind = enemyKind;
		this.enemyMove = enemyMove;
	}

	@Override
	public void run() {
		while (running) {
			try {

				if (Animal_VS_Enemy.enemyImage.get(enemyNum).getX() <= Animal_VS_Enemy.ANIMALBASE_X) {
					// 해적의 x이 0이 아닌데 0으로 출력되고 적의 기지쪽에서 해적이 멈추는 오류가 있어 예외처리하기 위한 코드
					if (Animal_VS_Enemy.enemyImage.get(enemyNum).getX() != 0) {

						// 동물 기지의 체력을 깍는다. 기지는 동물번호나 적의 번호가 필요없기 때문에 0을 넣어두었다.
						if (enemyAttackInterval == null) {
							enemyAttackInterval = new EnemyAttackInterval(enemyNum, 0, attackPower, Animal_VS_Enemy.animalBase.strength,
									attackInterval, "동물기지");
							enemyAttackInterval.start();
						}
					}
				}

				if(enemyKind == "jingjing" || enemyKind == "bandit" || enemyKind == "piracy") {
				for (int i = 0; i < Animal_VS_Enemy.animalImage.size(); i++) {

					try {
						// 동물이 범위 안에 들어왔을 때
						if (Animal_VS_Enemy.enemyImage.get(enemyNum).getX() <= Animal_VS_Enemy.animalImage.get(i).getX() + 15
								&& Animal_VS_Enemy.enemyImage.get(enemyNum).getX() >= Animal_VS_Enemy.animalImage.get(i).getX() - 10) {

							// System.out.println("동물이 범위 안에 들어옴");

							// 해당 동물의 체력을 깍는다.
							// i의 클래스가 돼지라면 몇번째 돼지인지 찾고 그 돼지의 체력을 감소시킨다
							whatNum = 0;

							if ((Animal_VS_Enemy.animalList.get(i).getClass()).toString()
									.equals("class Stage2.Pig")) {
								for (int j = 0; j < i; j++) {
									if (Animal_VS_Enemy.animalList.get(j).getClass().toString()
											.equals("class Stage2.Pig")) {
										whatNum++;
									}
								}
								animalKind = Animal_VS_Enemy.pigList.get(whatNum).animalKind;

							} else if ((Animal_VS_Enemy.animalList.get(i).getClass()).toString()
									.equals("class Stage2.Rabbit")) {

								for (int j = 0; j < i; j++) {
									if (Animal_VS_Enemy.animalList.get(j).getClass().toString()
											.equals("class Stage2.Rabbit")) {
										whatNum++;
									}
								}
								animalKind = Animal_VS_Enemy.rabbitList.get(whatNum).animalKind;

							} else if ((Animal_VS_Enemy.animalList.get(i).getClass()).toString()
									.equals("class Stage2.Chick")) {
								for (int j = 0; j < i; j++) {
									if (Animal_VS_Enemy.animalList.get(j).getClass().toString()
											.equals("class Stage2.Chick")) {
										whatNum++;
									}
								}
								animalKind = Animal_VS_Enemy.chickList.get(whatNum).animalKind;

							} else if ((Animal_VS_Enemy.animalList.get(i).getClass()).toString()
									.equals("class Stage2.Goat")) {

								for (int j = 0; j < i; j++) {
									if (Animal_VS_Enemy.animalList.get(j).getClass().toString()
											.equals("class Stage2.Goat")) {
										whatNum++;
									}
								}
								animalKind = Animal_VS_Enemy.goatList.get(whatNum).animalKind;
							}
							if (enemyAttackInterval == null) {
								enemyAttackInterval = new EnemyAttackInterval(enemyNum, i, attackPower, whatNum, attackInterval, animalKind);
								enemyAttackInterval.start();
							}
						}else if(enemyAttackInterval != null){
							enemyAttackInterval = null;
							sleep(800);
						}
						
					} catch (IndexOutOfBoundsException f) {
						// System.out.println("범위내에 동물이 없습니다.");
					}
					
					
					if (Animal_VS_Enemy.enemyImage.get(enemyNum).getX() <= Animal_VS_Enemy.minimiImage[i].getX() + 10
							&& Animal_VS_Enemy.enemyImage.get(enemyNum).getX() >= Animal_VS_Enemy.minimiImage[i].getX() - 10) {
						Animal_VS_Enemy.minimiImage[i].setLocation(-500, -500);
					}
				}
			}
				synchronized (this) {
					if (Animal_VS_Enemy.enemyImage.get(enemyNum).getX() == 1500
							&& Animal_VS_Enemy.enemyImage.get(enemyNum).getY() == 1500) {
						//System.out.println("쓰레드 종료 적 죽음");
						wait();
					}
				}
				
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				running = false;
			}
		}

	}
}
