package Stage2;


public class AnimalAttack extends Thread {
	
	boolean running = true;
	int animalNum = 0;
	int attackPower = 0;
	int attackInterval = 0;
	int whatNum = 0;
	int maxStrengthTarget = 0;
	String animalKind = "";
	String enemyKind = "";
	Thread animalMove;
	AnimalAttackInterval animalAttackInterval;
	Bullets bullets;
	Minimis minimis;
	
	AnimalAttack(int animalNum, int attackPower, int attackInterval, String animalKind, Thread animalMove) {
		this.animalNum = animalNum;
		this.attackPower = attackPower;
		this.attackInterval = attackInterval;
		this.animalKind = animalKind;
		this.animalMove = animalMove;
	}

	@Override
	public void run() {
		while (running) {
			try {

				if(animalKind == "rabbit" || animalKind == "pig" || animalKind == "chick") {
					// 적의 범위안에 들어갔을 때 기지의 체력을 깍는다.
					if (Animal_VS_Enemy.animalImage.get(animalNum).getX() >= Animal_VS_Enemy.ENEMYBASE_X) {

						// 기지는 동물번호나 적의 번호가 필요없기 때문에 0을 넣어두었다.
						if (animalAttackInterval == null) {
							animalAttackInterval = new AnimalAttackInterval(animalNum, 0, attackPower,
									Animal_VS_Enemy.enemyBase.strength, attackInterval, "적기지");
							animalAttackInterval.start();
							// System.out.println(Animal_VS_Enemy.enemyBase.strength);
						}
						
					}
				}
				
				if(animalKind == "pig" || animalKind == "chick") {
					
					for (int i = 0; i < Animal_VS_Enemy.enemyImage.size(); i++) {

						try {
							// 적이 범위 안에 들어왔을 때
							if (Animal_VS_Enemy.animalImage.get(animalNum).getX() >= Animal_VS_Enemy.enemyImage.get(i).getX() - 15
									&& Animal_VS_Enemy.animalImage.get(animalNum)
											.getX() <= Animal_VS_Enemy.enemyImage.get(i).getX() + 5) {

								// System.out.println("적이 범위 안에 들어옴");
								// 해당 적을 찾은 후 
								whatNum = 0;

								if ((Animal_VS_Enemy.enemyList.get(i).getClass()).toString()
										.equals("class Stage2.Bandit")) {
									for (int j = 0; j < i; j++) {
										if (Animal_VS_Enemy.enemyList.get(j).getClass().toString()
												.equals("class Stage2.Bandit")) {
											whatNum++;
										}
									}
									enemyKind = Animal_VS_Enemy.banditList.get(whatNum).enemyKind;

								} else if ((Animal_VS_Enemy.enemyList.get(i).getClass()).toString()
										.equals("class Stage2.Thief")) {

									for (int j = 0; j < i; j++) {
										if (Animal_VS_Enemy.enemyList.get(j).getClass().toString()
												.equals("class Stage2.Thief")) {
											whatNum++;
										}
									}
									enemyKind = Animal_VS_Enemy.thiefList.get(whatNum).enemyKind;

								} else if ((Animal_VS_Enemy.enemyList.get(i).getClass()).toString()
										.equals("class Stage2.Jingjing")) {
									for (int j = 0; j < i; j++) {
										if (Animal_VS_Enemy.enemyList.get(j).getClass().toString()
												.equals("class Stage2.Jingjing")) {
											whatNum++;
										}
									}
									enemyKind = Animal_VS_Enemy.jingjingList.get(whatNum).enemyKind;

								} else if ((Animal_VS_Enemy.enemyList.get(i).getClass()).toString()
										.equals("class Stage2.Piracy")) {

									for (int j = 0; j < i; j++) {
										if (Animal_VS_Enemy.enemyList.get(j).getClass().toString()
												.equals("class Stage2.Piracy")) {
											whatNum++;
										}
									}
									enemyKind = Animal_VS_Enemy.piracyList.get(whatNum).enemyKind;
								}
								
								//공격쓰레드 animalAttackInterval를 실행시켜 체력을 깍는다.
								if (animalAttackInterval == null) {
									animalAttackInterval = new AnimalAttackInterval(animalNum, i,
											attackPower, whatNum, attackInterval, enemyKind);
									animalAttackInterval.start();
								}
							} else if(animalAttackInterval != null){
								animalAttackInterval = null;
								sleep(800);
							}
						} catch (IndexOutOfBoundsException f) {
							// System.out.println("범위내에 동물이 없습니다.");
						}
					}
					
				}
	
				if(animalKind == "goat") {
					if(bullets == null) {
					 bullets = new Bullets(Animal_VS_Enemy.goatList.get(0).attackSpeed, Animal_VS_Enemy.goatList.get(0).attackInterval, animalNum);
					 bullets.start();
					 
					}else {
					
					for (int i = 0; i < Animal_VS_Enemy.bulletImage.length; i++) {
						for (int j = 0; j < Animal_VS_Enemy.enemyImage.size(); j++) {

							// 총알의과 적이 같은 타일일 때 총알의 x값이 적의 x값보다 크다면 (총알이 적에게 닿았다면)
							if ((Animal_VS_Enemy.bulletImage[i].getX() >= Animal_VS_Enemy.enemyImage.get(j).getX())) {

									// 적에게 닿은 총알은 대기위치로 이동
									Animal_VS_Enemy.bulletImage[i].setLocation(-500, Animal_VS_Enemy.bulletImage[i].getY());

									//총알을 맞은 적을 찾고 그 적의 체력을 깍는다.
									whatNum = 0;

									if ((Animal_VS_Enemy.enemyList.get(j).getClass()).toString()
											.equals("class Stage2.Bandit")) {
										for (int k = 0; k < j; k++) {
											if (Animal_VS_Enemy.enemyList.get(k).getClass().toString().equals("class Stage2.Bandit")) {
												whatNum++;
											}
										}
										maxStrengthTarget = 23;
										
										if (Animal_VS_Enemy.banditList.get(whatNum).strength > 0) {
											Animal_VS_Enemy.banditList.get(whatNum).strength = Animal_VS_Enemy.banditList.get(whatNum).strength - attackPower;

											if (Animal_VS_Enemy.enemyhealthBarImage.get(j).getWidth() < 0) {
												if (Animal_VS_Enemy.banditList.get(whatNum).strength > 0) {
													Animal_VS_Enemy.enemyhealthBarImage.get(j).setSize(5, 4);
												}
											}

										}else {
											Animal_VS_Enemy.enemyImage.get(j).setLocation(1500, 1500);
											Animal_VS_Enemy.enemyhealthBarImage.get(j).setLocation(1500, 1500);

										}
										
									} else if ((Animal_VS_Enemy.enemyList.get(j).getClass()).toString()
											.equals("class Stage2.Thief")) {

										for (int k = 0; k < j; k++) {
											if (Animal_VS_Enemy.enemyList.get(k).getClass().toString()
													.equals("class Stage2.Thief")) {
												whatNum++;
											}
										}
										maxStrengthTarget = 12;
										
										if (Animal_VS_Enemy.thiefList.get(whatNum).strength > 0) {
											Animal_VS_Enemy.thiefList.get(whatNum).strength = Animal_VS_Enemy.thiefList.get(whatNum).strength - attackPower;

											if (Animal_VS_Enemy.enemyhealthBarImage.get(j).getWidth() < 0) {
												if (Animal_VS_Enemy.thiefList.get(whatNum).strength > 0) {
													Animal_VS_Enemy.enemyhealthBarImage.get(j).setSize(5, 4);
												}
											}
											
										}else {
											Animal_VS_Enemy.enemyImage.get(j).setLocation(1500, 1500);
											Animal_VS_Enemy.enemyhealthBarImage.get(j).setLocation(1500, 1500);

										}

									} else if ((Animal_VS_Enemy.enemyList.get(j).getClass()).toString()
											.equals("class Stage2.Jingjing")) {
										for (int k = 0; k < j; k++) {
											if (Animal_VS_Enemy.enemyList.get(k).getClass().toString()
													.equals("class Stage2.Jingjing")) {
												whatNum++;
											}
										}

										if (Animal_VS_Enemy.jingjingList.get(whatNum).strength > 0) {
											Animal_VS_Enemy.jingjingList.get(whatNum).strength = Animal_VS_Enemy.jingjingList.get(whatNum).strength - attackPower;

											maxStrengthTarget = 7;
											
											if (Animal_VS_Enemy.enemyhealthBarImage.get(j).getWidth() < 0) {
												if (Animal_VS_Enemy.jingjingList.get(whatNum).strength > 0) {
													Animal_VS_Enemy.enemyhealthBarImage.get(j).setSize(5, 4);
												}
											}
											
										}else {
											Animal_VS_Enemy.enemyImage.get(j).setLocation(1500, 1500);
											Animal_VS_Enemy.enemyhealthBarImage.get(j).setLocation(1500, 1500);

										}
										
									} else if ((Animal_VS_Enemy.enemyList.get(j).getClass()).toString()
											.equals("class Stage2.Piracy")) {

										for (int k = 0; k < j; k++) {
											if (Animal_VS_Enemy.enemyList.get(k).getClass().toString()
													.equals("class Stage2.Piracy")) {
												whatNum++;
											}
										}
										
										if (Animal_VS_Enemy.piracyList.get(whatNum).strength > 0) {
											Animal_VS_Enemy.piracyList.get(whatNum).strength = Animal_VS_Enemy.piracyList.get(whatNum).strength - attackPower;

											maxStrengthTarget = 13;
											
											if (Animal_VS_Enemy.enemyhealthBarImage.get(j).getWidth() < 0) {
												if (Animal_VS_Enemy.piracyList.get(whatNum).strength > 0) {
													Animal_VS_Enemy.enemyhealthBarImage.get(j).setSize(5, 4);
												}
											}
											
										}else {
											Animal_VS_Enemy.enemyImage.get(j).setLocation(1500, 1500);
											Animal_VS_Enemy.enemyhealthBarImage.get(j).setLocation(1500, 1500);

										}
									}
									
									int barWidth =  maxStrengthTarget / attackPower;
									
									Animal_VS_Enemy.enemyhealthBarImage.get(j).setSize(
											Animal_VS_Enemy.enemyhealthBarImage.get(j).getWidth() - barWidth,
											Animal_VS_Enemy.enemyhealthBarImage.get(j).getHeight());

								}
							}
						}
					}
				}

				synchronized (this) {
					//동물이 죽었을 때 쓰레드를 멈춘다
					if (Animal_VS_Enemy.animalImage.get(animalNum).getX() == 1500
							&& Animal_VS_Enemy.animalImage.get(animalNum).getY() == 1500) {
						//System.out.println("쓰레드 종료 동물 죽음");
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
