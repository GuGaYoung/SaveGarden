package Stage2;

public class AnimalAttackInterval extends Thread {

	int attackPower = 0;
	int strengthOfTarget = 0;
	int attackInterval = 0;
	int barWidth = 0;
	int animalNum = 0; // 공격하는 대상의 번호
	int targetNum = 0; // 공격받는 대상의 번호
	int maxStrengthTarget = 0;
	int whatNum = 0;
	String underAttackTarget = "";// 공격받는 대상의 종류
	boolean running = true;

	AnimalAttackInterval(int animalNum, int targetNum, int attackPower, int whatNum, int attackInterval,
			String underAttackTarget) {
		this.animalNum = animalNum;
		this.targetNum = targetNum;
		this.attackPower = attackPower;
		this.whatNum = whatNum;
		this.attackInterval = attackInterval;
		this.underAttackTarget = underAttackTarget;
	}

	@Override
	public void run() {
		while (running) {
			try {

				if (underAttackTarget.equals("bandit")) {
					maxStrengthTarget = 23;

					if (Animal_VS_Enemy.banditList.get(whatNum).strength > 0) {
						Animal_VS_Enemy.banditList.get(whatNum).strength = Animal_VS_Enemy.banditList.get(whatNum).strength - attackPower;

						if (Animal_VS_Enemy.enemyhealthBarImage.get(targetNum).getWidth() < 0) {
							if (Animal_VS_Enemy.banditList.get(whatNum).strength > 0) {
								Animal_VS_Enemy.enemyhealthBarImage.get(targetNum).setSize(5, 4);
							}
						}

					}else {
						Animal_VS_Enemy.enemyImage.get(targetNum).setLocation(1500, 1500);
						Animal_VS_Enemy.enemyhealthBarImage.get(targetNum).setLocation(1500, 1500);

					}
					//System.out.println("Animal_VS_Enemy.banditList.get(whatNum).strength"+ Animal_VS_Enemy.banditList.get(whatNum).strength);

				} else if (underAttackTarget.equals("thief")) {
					maxStrengthTarget = 12;
					
					if (Animal_VS_Enemy.thiefList.get(whatNum).strength > 0) {
						Animal_VS_Enemy.thiefList.get(whatNum).strength = Animal_VS_Enemy.thiefList.get(whatNum).strength - attackPower;

						if (Animal_VS_Enemy.enemyhealthBarImage.get(targetNum).getWidth() < 0) {
							if (Animal_VS_Enemy.thiefList.get(whatNum).strength > 0) {
								Animal_VS_Enemy.enemyhealthBarImage.get(targetNum).setSize(5, 4);
							}
						}
						
					}else {
						Animal_VS_Enemy.enemyImage.get(targetNum).setLocation(1500, 1500);
						Animal_VS_Enemy.enemyhealthBarImage.get(targetNum).setLocation(1500, 1500);

					}
					//System.out.println("Animal_VS_Enemy.thiefList.get(whatNum).strength"+ Animal_VS_Enemy.thiefList.get(whatNum).strength);

				} else if (underAttackTarget.equals("jingjing")) {
					maxStrengthTarget = 7;
					
					if (Animal_VS_Enemy.jingjingList.get(whatNum).strength > 0) {
						Animal_VS_Enemy.jingjingList.get(whatNum).strength = Animal_VS_Enemy.jingjingList.get(whatNum).strength - attackPower;

						if (Animal_VS_Enemy.enemyhealthBarImage.get(targetNum).getWidth() < 0) {
							if (Animal_VS_Enemy.jingjingList.get(whatNum).strength > 0) {
								Animal_VS_Enemy.enemyhealthBarImage.get(targetNum).setSize(5, 4);
							}
						}
						
					}else {
						Animal_VS_Enemy.enemyImage.get(targetNum).setLocation(1500, 1500);
						Animal_VS_Enemy.enemyhealthBarImage.get(targetNum).setLocation(1500, 1500);

					}
					//System.out.println("Animal_VS_Enemy.jingjingList.get(whatNum).strength"+ Animal_VS_Enemy.jingjingList.get(whatNum).strength);

				} else if (underAttackTarget.equals("piracy")) {
					maxStrengthTarget = 13;
					
					if (Animal_VS_Enemy.piracyList.get(whatNum).strength > 0) {
						Animal_VS_Enemy.piracyList.get(whatNum).strength = Animal_VS_Enemy.piracyList.get(whatNum).strength - attackPower;

						if (Animal_VS_Enemy.enemyhealthBarImage.get(targetNum).getWidth() < 0) {
							if (Animal_VS_Enemy.piracyList.get(whatNum).strength > 0) {
								Animal_VS_Enemy.enemyhealthBarImage.get(targetNum).setSize(5, 4);
							}
						}
						
					}else {
						Animal_VS_Enemy.enemyImage.get(targetNum).setLocation(1500, 1500);
						Animal_VS_Enemy.enemyhealthBarImage.get(targetNum).setLocation(1500, 1500);

					}
					//System.out.println("Animal_VS_Enemy.piracyList.get(whatNum).strength"+ Animal_VS_Enemy.piracyList.get(whatNum).strength);
					
				}else if (underAttackTarget.equals("적기지")) {
					maxStrengthTarget = 100;
					
					if (Animal_VS_Enemy.enemyBase.strength > 0) {
						Animal_VS_Enemy.enemyBase.strength = Animal_VS_Enemy.enemyBase.strength - attackPower;
						Animal_VS_Enemy.enemyBaseStrengthText.setText("적기지 체력 : " + Animal_VS_Enemy.enemyBase.strength);
						
					}else {
						Animal_VS_Enemy.enemyBaseImage.setLocation(1500, 1500);
						Animal_VS_Enemy.gameVictoryScene.setVisible(true);
						Animal_VS_Enemy.Stage2GameScene.setVisible(false);
					}
					//System.out.println("Animal_VS_Enemy.enemyBase.strength"+ Animal_VS_Enemy.enemyBase.strength);
				}

				if(!underAttackTarget.equals("적기지")){
					
					//barWidth = 36*(attackPower / maxStrengthTarget); <- 원래 공식인데 계산 값이 0으로 나옴
					barWidth =  maxStrengthTarget / attackPower;
					
					Animal_VS_Enemy.enemyhealthBarImage.get(targetNum).setSize(
							Animal_VS_Enemy.enemyhealthBarImage.get(targetNum).getWidth() - barWidth,
							Animal_VS_Enemy.enemyhealthBarImage.get(targetNum).getHeight());
				}
				
				
				
				
				synchronized (this) {
					if (Animal_VS_Enemy.animalImage.get(animalNum).getX() == 1500
							&& Animal_VS_Enemy.animalImage.get(animalNum).getY() == 1500) {
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
