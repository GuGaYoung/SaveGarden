package Stage2;

public class Minimis extends Thread {

	MinimiMove[] minimiMove = new MinimiMove[NUM_OF_MINIMIS];

	final static int NUM_OF_MINIMIS = 3; // 염소 한마리가 생성될 때 생성되는 총알의 수
	static int minimisNum = 0; // minimis클래스의 수
	int attackInterval = 300;
	int attackPower = 1;
	int animalNum = 0;
	int whatNum = 0;
	int maxStrengthTarget = 0;
	boolean running = true;

	Minimis(int animalNum) {
		this.animalNum = animalNum;
	}

	@Override
	public void run() {

		for (int i = 0; i < minimiMove.length; i++) {
			minimiMove[i] = new MinimiMove(i, animalNum);
			minimiMove[i].start();
		}

		final int whatNumMinimis = minimisNum; // 몇번째 미니미 클래스인지 - 몇번째 클래스인가에 따라 담당하는 minimiImage[]가 달라진다.

		while (running) {
			try {
				for (int i = minimiMove.length * whatNumMinimis - NUM_OF_MINIMIS; i < minimiMove.length * whatNumMinimis; i++) {
					for (int j = 0; j < Animal_VS_Enemy.enemyImage.size(); j++) {

						// 미니미의 주의에 적이 있다면 
						if (Animal_VS_Enemy.minimiImage[i].getX() >= Animal_VS_Enemy.enemyImage.get(j).getX() - 10
								&& Animal_VS_Enemy.minimiImage[i].getX() <= Animal_VS_Enemy.enemyImage.get(j).getX() + 10) {

							// 적에게 닿은 미니미는 대기 장소로 이동
							Animal_VS_Enemy.minimiImage[i].setLocation(-500, Animal_VS_Enemy.minimiImage[i].getY());

							// 미니미의 공격을 맞은 적을 찾고 그 적의 체력을 깍는다.
							whatNum = 0;

							if ((Animal_VS_Enemy.enemyList.get(j).getClass()).toString()
									.equals("class Stage2.Bandit")) {
								for (int k = 0; k < j; k++) {
									if (Animal_VS_Enemy.enemyList.get(k).getClass().toString()
											.equals("class Stage2.Bandit")) {
										whatNum++;
									}
								}
								maxStrengthTarget = 23;

								if (Animal_VS_Enemy.banditList.get(whatNum).strength > 0) {
									Animal_VS_Enemy.banditList.get(whatNum).strength = Animal_VS_Enemy.banditList
											.get(whatNum).strength - attackPower;

									if (Animal_VS_Enemy.enemyhealthBarImage.get(j).getWidth() < 0) {
										if (Animal_VS_Enemy.banditList.get(whatNum).strength > 0) {
											Animal_VS_Enemy.enemyhealthBarImage.get(j).setSize(5, 4);
										}
									}

								} else {
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
									Animal_VS_Enemy.thiefList.get(whatNum).strength = Animal_VS_Enemy.thiefList
											.get(whatNum).strength - attackPower;

									if (Animal_VS_Enemy.enemyhealthBarImage.get(j).getWidth() < 0) {
										if (Animal_VS_Enemy.thiefList.get(whatNum).strength > 0) {
											Animal_VS_Enemy.enemyhealthBarImage.get(j).setSize(5, 4);
										}
									}

								} else {
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
									Animal_VS_Enemy.jingjingList.get(whatNum).strength = Animal_VS_Enemy.jingjingList
											.get(whatNum).strength - attackPower;

									maxStrengthTarget = 7;

									if (Animal_VS_Enemy.enemyhealthBarImage.get(j).getWidth() < 0) {
										if (Animal_VS_Enemy.jingjingList.get(whatNum).strength > 0) {
											Animal_VS_Enemy.enemyhealthBarImage.get(j).setSize(5, 4);
										}
									}

								} else {
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
									Animal_VS_Enemy.piracyList.get(whatNum).strength = Animal_VS_Enemy.piracyList
											.get(whatNum).strength - attackPower;

									maxStrengthTarget = 13;

									if (Animal_VS_Enemy.enemyhealthBarImage.get(j).getWidth() < 0) {
										if (Animal_VS_Enemy.piracyList.get(whatNum).strength > 0) {
											Animal_VS_Enemy.enemyhealthBarImage.get(j).setSize(5, 4);
										}
									}

								} else {
									Animal_VS_Enemy.enemyImage.get(j).setLocation(1500, 1500);
									Animal_VS_Enemy.enemyhealthBarImage.get(j).setLocation(1500, 1500);

								}
							}

							int barWidth = maxStrengthTarget / attackPower;

							Animal_VS_Enemy.enemyhealthBarImage.get(j).setSize(
									Animal_VS_Enemy.enemyhealthBarImage.get(j).getWidth() - barWidth,
									Animal_VS_Enemy.enemyhealthBarImage.get(j).getHeight());
						}
					}
				}
				
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
