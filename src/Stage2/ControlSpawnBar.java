package Stage2;

import java.util.Random;
import javax.swing.ImageIcon;

public class ControlSpawnBar extends Thread {

	Random random = new Random();

	boolean running = true;
	int randomAnimal = 0;
	int MaxBlockNum = 5;
	static int NowBlockNum = 0;
	String whatAnimal[] = new String[MaxBlockNum];// 박스에 어떤 동물이 들어있는지

	String pigImage_box = "C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\animal VS enemy\\pig.png";
	String rabbitImage_box = "C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\animal VS enemy\\rabbit.png";
	String chickImage_box = "C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\animal VS enemy\\chick.png";
	String goatImage_box = "C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\animal VS enemy\\goat.png";

	@Override
	public void run() {

		while (running) {
			try {

				
				for (int i = 0; i < Animal_VS_Enemy.animalSpawnBlock.length; i++) {
					if (Animal_VS_Enemy.animalSpawnBlock[i].getIcon() == null) {
						try {

							if (whatAnimal[i + 1] == "pig") {
								Animal_VS_Enemy.animalSpawnBlock[i].setIcon(new ImageIcon(pigImage_box));

							} else if (whatAnimal[i + 1] == "rabbit") {
								Animal_VS_Enemy.animalSpawnBlock[i].setIcon(new ImageIcon(rabbitImage_box));

							} else if (whatAnimal[i + 1] == "chick") {
								Animal_VS_Enemy.animalSpawnBlock[i].setIcon(new ImageIcon(chickImage_box));

							} else if (whatAnimal[i + 1] == "goat") {
								Animal_VS_Enemy.animalSpawnBlock[i].setIcon(new ImageIcon(goatImage_box));
								
							}
							
							Animal_VS_Enemy.animalSpawnBlock[i + 1].setIcon(null);
							

							whatAnimal[i] = whatAnimal[i + 1];

						} catch (ArrayIndexOutOfBoundsException e) {
							// System.out.println("다음 박스에 동물이 없습니다.");
						}

					}
				}
				
				//동물이 랜덤으로 animalSpawnBlock에 들어간다.
				randomAnimal = random.nextInt(4);
				if (MaxBlockNum > NowBlockNum) {

					if (randomAnimal == 0) {
						Animal_VS_Enemy.animalSpawnBlock[NowBlockNum].setIcon(new ImageIcon(pigImage_box));
						whatAnimal[NowBlockNum] = "pig";

					} else if (randomAnimal == 1) {
						Animal_VS_Enemy.animalSpawnBlock[NowBlockNum].setIcon(new ImageIcon(rabbitImage_box));
						whatAnimal[NowBlockNum] = "rabbit";

					} else if (randomAnimal == 2) {
						Animal_VS_Enemy.animalSpawnBlock[NowBlockNum].setIcon(new ImageIcon(chickImage_box));
						whatAnimal[NowBlockNum] = "chick";

					} else if (randomAnimal == 3) {
						Animal_VS_Enemy.animalSpawnBlock[NowBlockNum].setIcon(new ImageIcon(goatImage_box));
						whatAnimal[NowBlockNum] = "goat";

					}
					//for (int i = 0; i < Animal_VS_Enemy.animalSpawnBlock.length; i++) {
						//System.out.print(i);
						//System.out.print(Animal_VS_Enemy.animalSpawnBlock[i].getIcon());
						//System.out.println(Animal_VS_Enemy.animalSpawnBlock[i].getX());
					//}
					NowBlockNum++;
				}

				

				Thread.sleep(2000);

			} catch (InterruptedException e) {
				running = false;
			}
		}
	}

}
