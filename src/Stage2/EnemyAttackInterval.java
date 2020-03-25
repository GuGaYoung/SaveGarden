package Stage2;

public class EnemyAttackInterval extends Thread {

	int attackPower = 0;
	int strengthOfTarget = 0;
	int attackInterval = 0;
	int barWidth = 0;
	int enemyNum = 0; //공격하는 대상의 번호 
	int targetNum = 0; //공격받는 대상의 번호
	int maxStrengthTarget = 0;
	int whatNum = 0;
	String underAttackTarget = "";// 공격받는 대상의 종류 
	boolean running = true;
	Minimis minimis;
	
	EnemyAttackInterval(int enemyNum, int targetNum, int attackPower, int whatNum, int attackInterval,
			String underAttackTarget) {
		this.enemyNum = enemyNum;
		this.targetNum = targetNum;
		this.attackPower = attackPower;
		this.whatNum = whatNum;
		this.maxStrengthTarget = strengthOfTarget;
		this.attackInterval = attackInterval;
		this.underAttackTarget = underAttackTarget;
	}

	@Override
	public void run() {
		running = true;
		while (running) {
			try {
					
				if (underAttackTarget.equals("rabbit")) {
					maxStrengthTarget = 15;
					
					if (Animal_VS_Enemy.rabbitList.get(whatNum).strength > 0) {
						
						Animal_VS_Enemy.rabbitList.get(whatNum).strength = Animal_VS_Enemy.rabbitList.get(whatNum).strength - attackPower;

						if (Animal_VS_Enemy.animalhealthBarImage.get(targetNum).getWidth() < 0) {
							if (Animal_VS_Enemy.rabbitList.get(whatNum).strength > 0) {
								Animal_VS_Enemy.animalhealthBarImage.get(targetNum).setSize(5, 4);
							}
						}

					}else {
						Animal_VS_Enemy.animalImage.get(targetNum).setLocation(1500, 1500);
						Animal_VS_Enemy.animalhealthBarImage.get(targetNum).setLocation(1500, 1500);
					}
					//System.out.println("Animal_VS_Enemy.rabbitList.get(whatNum).strength"+ Animal_VS_Enemy.rabbitList.get(whatNum).strength);
					
					// 공격 받는 대상이 적일 경우
					}else if (underAttackTarget.equals("pig")) {
						maxStrengthTarget = 20;
						
						if (Animal_VS_Enemy.pigList.get(whatNum).strength > 0) {
							
							Animal_VS_Enemy.pigList.get(whatNum).strength = Animal_VS_Enemy.pigList.get(whatNum).strength - attackPower;

							if (Animal_VS_Enemy.animalhealthBarImage.get(targetNum).getWidth() < 0) {
								if (Animal_VS_Enemy.pigList.get(whatNum).strength > 0) {
									Animal_VS_Enemy.animalhealthBarImage.get(targetNum).setSize(5, 4);
								}
							}

						}else {
							Animal_VS_Enemy.animalImage.get(targetNum).setLocation(1500, 1500);
							Animal_VS_Enemy.animalhealthBarImage.get(targetNum).setLocation(1500, 1500);
						}
						//System.out.println("Animal_VS_Enemy.pigList.get(whatNum).strength"+ Animal_VS_Enemy.pigList.get(whatNum).strength);
						
						// 공격 받는 대상이 적일 경우
						}if (underAttackTarget.equals("chick")) {
							maxStrengthTarget = 6;
							
							if (Animal_VS_Enemy.chickList.get(whatNum).strength > 0) {
								
								Animal_VS_Enemy.chickList.get(whatNum).strength = Animal_VS_Enemy.chickList.get(whatNum).strength - attackPower;

								if (Animal_VS_Enemy.animalhealthBarImage.get(targetNum).getWidth() < 0) {
									if (Animal_VS_Enemy.chickList.get(whatNum).strength > 0) {
										Animal_VS_Enemy.animalhealthBarImage.get(targetNum).setSize(5, 4);
									}
								}
								
								if(Animal_VS_Enemy.chickList.get(whatNum).strength < 3) {
									if (minimis == null) {
										minimis = new Minimis(targetNum);
										minimis.start();
									}
								}

							}else {
								Animal_VS_Enemy.animalImage.get(targetNum).setLocation(1500, 1500);
								Animal_VS_Enemy.animalhealthBarImage.get(targetNum).setLocation(1500, 1500);
							}
							//System.out.println("Animal_VS_Enemy.chickList.get(whatNum).strength"+ Animal_VS_Enemy.chickList.get(whatNum).strength);
							
							// 공격 받는 대상이 적일 경우
							}if (underAttackTarget.equals("goat")) {
								maxStrengthTarget = 12;
								
								if (Animal_VS_Enemy.goatList.get(whatNum).strength > 0) {
									
									Animal_VS_Enemy.goatList.get(whatNum).strength = Animal_VS_Enemy.goatList.get(whatNum).strength - attackPower;

									if (Animal_VS_Enemy.animalhealthBarImage.get(targetNum).getWidth() < 0) {
										if (Animal_VS_Enemy.goatList.get(whatNum).strength > 0) {
											Animal_VS_Enemy.animalhealthBarImage.get(targetNum).setSize(5, 4);
										}
									}

								}else {
									Animal_VS_Enemy.animalImage.get(targetNum).setLocation(1500, 1500);
									Animal_VS_Enemy.animalhealthBarImage.get(targetNum).setLocation(1500, 1500);
								}
								//System.out.println("Animal_VS_Enemy.goatList.get(whatNum).strength"+ Animal_VS_Enemy.goatList.get(whatNum).strength);

							}else if (underAttackTarget.equals("동물기지")) {
								maxStrengthTarget = 100;
								
								if (Animal_VS_Enemy.animalBase.strength > 0) {
									Animal_VS_Enemy.animalBase.strength = Animal_VS_Enemy.animalBase.strength - attackPower;
									Animal_VS_Enemy.animalBaseStrengthText.setText("동물기지 체력 : " + Animal_VS_Enemy.animalBase.strength);
									
								}else {
									Animal_VS_Enemy.animalBaseImage.setLocation(-500, -500);
									Animal_VS_Enemy.gameOverScene.setVisible(true);
									Animal_VS_Enemy.Stage2GameScene.setVisible(false);
									break;
								}
								//System.out.println("Animal_VS_Enemy.animalBase.strength"+ Animal_VS_Enemy.animalBase.strength);
							}
							
							//barWidth = 36*(attackPower / maxStrengthTarget); <- 원래 공식인데 계산 값이 0으로 나옴
							barWidth =  maxStrengthTarget / attackPower;
							
							if (!underAttackTarget.equals("동물기지")) {
								
								Animal_VS_Enemy.animalhealthBarImage.get(targetNum).setSize(
										Animal_VS_Enemy.animalhealthBarImage.get(targetNum).getWidth() - barWidth,
										Animal_VS_Enemy.animalhealthBarImage.get(targetNum).getHeight());
								
								// 만약 체력이 -가 아니지만 체력바가 사라질때 처리
								if (Animal_VS_Enemy.animalhealthBarImage.get(targetNum).getWidth() < 0) {
									if (strengthOfTarget > 0) {
										Animal_VS_Enemy.animalhealthBarImage.get(targetNum).setSize(5, 4);
									}
								}
								
							}
							
							synchronized (this) {
								if (Animal_VS_Enemy.enemyImage.get(enemyNum).getX() == 1500
										&& Animal_VS_Enemy.enemyImage.get(enemyNum).getY() == 1500) {
									wait();
								}
							}
							
				Thread.sleep(attackInterval);

			} catch (InterruptedException e) {
				running = false;
			}
		}
	}
}
