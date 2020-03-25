package Stage2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Animal_VS_Enemy {
	
	ControlSpawnBar controlSpawnBar = new ControlSpawnBar();
	SpawnEnemy SpawnEnemy = new SpawnEnemy();
	static EnemyBase enemyBase = new EnemyBase();
	static AnimalBase animalBase = new AnimalBase();
	
	public JFrame frame;
	
	static JPanel Stage2GameScene = new JPanel() {
		public void paintComponent(Graphics g) {
			Dimension d = getSize();
			ImageIcon image = new ImageIcon("./image/animalVSenemyBackGround.jpg");
			g.drawImage(image.getImage(), 0, 0, d.width, d.height, this);
		}
	};
	static JPanel gameVictoryScene = new JPanel();
	static JPanel gameOverScene = new JPanel();

	static JButton[] animalSpawnBlock = new JButton[5];
	JButton NextRoundButton = new JButton();
	JButton robbyButton = new JButton();
	JButton exitText = new JButton();

	static JLabel animalBaseImage = new JLabel();
	static JLabel enemyBaseImage = new JLabel();
	static JLabel animalBaseStrengthText = new JLabel();
	static JLabel enemyBaseStrengthText = new JLabel();
	JLabel gameVictoryImage = new JLabel();
	JLabel victoryText = new JLabel();
	JLabel gameOverImage = new JLabel();
	JLabel reasonLosingText = new JLabel();
	JLabel stageText = new JLabel();
	static JLabel[] bulletImage = new JLabel[100];
	static JLabel[] minimiImage = new JLabel[50];
	
	static ArrayList<JLabel> animalImage = new ArrayList<>();
	static ArrayList<JLabel> enemyImage = new ArrayList<>();
	static ArrayList<JLabel> animalhealthBarImage = new ArrayList<>();
	static ArrayList<JLabel> enemyhealthBarImage = new ArrayList<>();
	static ArrayList<Object> animalList = new ArrayList<>();
	static ArrayList<Object> enemyList = new ArrayList<>();
	static ArrayList<Pig> pigList = new ArrayList<>();
	static ArrayList<Chick> chickList = new ArrayList<>();
	static ArrayList<Rabbit> rabbitList = new ArrayList<>();
	static ArrayList<Goat> goatList = new ArrayList<>();
	static ArrayList<Bandit> banditList = new ArrayList<>();
	static ArrayList<Thief> thiefList = new ArrayList<>();
	static ArrayList<Piracy> piracyList = new ArrayList<>();
	static ArrayList<Jingjing> jingjingList = new ArrayList<>();

	int boxHorizontalLength = 50;
	int boxInterval = 75;
	int boxVerticalLength = 570;
	int box_WIDTH = 70;
	int box_HEIGHT = 80;
	final static int ENEMYBASE_X = 950;
	final static int ANIMALBASE_X = 100;
	static int animalNum = 0;
	String AnimalImageURL = "";

	public void animal_VS_Enemy() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Stage 2");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		Stage2GameScene.setBounds(0, 0, 1196, 672);
		frame.getContentPane().add(Stage2GameScene);
		Stage2GameScene.setLayout(null);

		stageText.setText("Stage 2");
		stageText.setFont(new Font("굴림", Font.BOLD, 30));
		stageText.setHorizontalAlignment(SwingConstants.CENTER);
		stageText.setBounds(900, 10, 223, 68);
		Stage2GameScene.add(stageText);
			
		animalBaseStrengthText.setText("동물기지 체력 : 100");
		animalBaseStrengthText.setFont(new Font("굴림", Font.BOLD, 15));
		animalBaseStrengthText.setHorizontalAlignment(SwingConstants.CENTER);
		animalBaseStrengthText.setBounds(-30, 290, 223, 100);
		Stage2GameScene.add(animalBaseStrengthText);
		
		enemyBaseStrengthText.setText("적기지 체력 : 100");
		enemyBaseStrengthText.setFont(new Font("굴림", Font.BOLD, 15));
		enemyBaseStrengthText.setHorizontalAlignment(SwingConstants.CENTER);
		enemyBaseStrengthText.setBounds(1000, 290, 223, 100);
		Stage2GameScene.add(enemyBaseStrengthText);
		
		// 동물의 기지
		animalBaseImage.setIcon(new ImageIcon(
				"C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\animal VS enemy\\AnimalBase.png"));
		animalBaseImage.setBounds(30, 350, 60, 120);
		Stage2GameScene.add(animalBaseImage);

		// 적의 기지
		enemyBaseImage.setIcon(new ImageIcon(
				"C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\animal VS enemy\\enemyBase.png"));
		enemyBaseImage.setBounds(1050, 350, 120, 110);
		Stage2GameScene.add(enemyBaseImage);

		for (int i = 0; i < animalSpawnBlock.length; i++) {
			Stage2GameScene.add(animalSpawnBlock[i] = new JButton());

			animalSpawnBlock[i].setBounds(boxHorizontalLength, boxVerticalLength, box_WIDTH, box_HEIGHT);

			boxHorizontalLength = boxInterval + boxHorizontalLength;
			animalSpawnBlock[i].setFocusPainted(false);
			animalSpawnBlock[i].setContentAreaFilled(false);
		}
		
		// 총알 초기화
		for (int i = 0; i < bulletImage.length; i++) {
			Stage2GameScene.add(bulletImage[i] = new JLabel());
			bulletImage[i].setIcon(new ImageIcon(
					"C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\animal VS enemy\\bullet.png"));
			bulletImage[i].setBounds(-500, -500, 12, 12);
		}
		
		
		// 미니병아리 초기화
		for (int i = 0; i < minimiImage.length; i++) {
			Stage2GameScene.add(minimiImage[i] = new JLabel());
			minimiImage[i].setIcon(new ImageIcon(
					"C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\animal VS enemy\\minimiChick.png"));
			minimiImage[i].setBounds(-500, -500, 20, 20);
		}

		// 동물 버튼을 누르면 해당 캐릭터가 스폰
		for (int i = 0; i < animalSpawnBlock.length; i++) {
			animalSpawnBlock[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					for (int i = 0; i < animalSpawnBlock.length; i++) {
						if (e.getSource() == animalSpawnBlock[i]) {

							try {

								animalImage.add(new JLabel());
								animalhealthBarImage.add(new JLabel());
								animalhealthBarImage.add(new JLabel());

								if ((animalSpawnBlock[i].getIcon())
										.toString() == controlSpawnBar.pigImage_box) {
									Pig pig = new Pig();
									pig.animalInitialize();
									animalList.add(pig);
									pigList.add(pig);
									AnimalImageURL = pig.ImageURL;
									AnimalMove animalMove = new AnimalMove(animalNum, pig.speed,
											pig.animalKind);
									animalMove.start();
									AnimalAttack animalAttack = new AnimalAttack(animalNum,
											pig.attackPower, pig.attackInterval, pig.animalKind, animalMove);
									animalAttack.start();
									

								} else if ((animalSpawnBlock[i].getIcon())
										.toString() == controlSpawnBar.rabbitImage_box) {
									Rabbit rabbit = new Rabbit();
									rabbit.animalInitialize();
									animalList.add(rabbit);
									rabbitList.add(rabbit);
									AnimalImageURL = rabbit.ImageURL;
									AnimalMove animalMove = new AnimalMove(animalNum, rabbit.speed,
											rabbit.animalKind);
									animalMove.start();
									AnimalAttack animalAttack = new AnimalAttack(animalNum,
											rabbit.attackPower, rabbit.attackInterval, rabbit.animalKind,
											animalMove);
									animalAttack.start();
									
								} else if ((animalSpawnBlock[i].getIcon())
										.toString() == controlSpawnBar.chickImage_box) {
									Chick chick = new Chick();
									chick.animalInitialize();
									animalList.add(chick);
									chickList.add(chick);
									AnimalImageURL = chick.ImageURL;
									AnimalMove animalMove = new AnimalMove(animalNum, chick.speed,
											chick.animalKind);
									animalMove.start();
									AnimalAttack animalAttack = new AnimalAttack(animalNum,
											chick.attackPower, chick.attackInterval, chick.animalKind, animalMove);
									animalAttack.start();

								} else if ((animalSpawnBlock[i].getIcon())
										.toString() == controlSpawnBar.goatImage_box) {
									Goat goat = new Goat();
									goat.animalInitialize();
									animalList.add(goat);
									goatList.add(goat);
									AnimalImageURL = goat.ImageURL;
									AnimalMove animalMove = new AnimalMove(animalNum, goat.speed,
											goat.animalKind);
									animalMove.start();
									AnimalAttack animalAttack = new AnimalAttack(animalNum,
											goat.attackPower, goat.attackInterval, goat.animalKind, animalMove);
									animalAttack.start();

								}
								animalSpawnBlock[i].setIcon(null);

								Stage2GameScene.add(animalImage.get(animalNum));
								animalImage.get(animalNum).setBounds(60, 400, 70, 80);
								animalImage.get(animalNum).setIcon(new ImageIcon(AnimalImageURL));

								Stage2GameScene.add(animalhealthBarImage.get(animalNum));
								animalhealthBarImage.get(animalNum).setBounds(60, 380, 36, 4);
								animalhealthBarImage.get(animalNum).setIcon(new ImageIcon(
										"C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\vegatable VS enemy\\healthbar_red.png"));

								animalNum++;
								ControlSpawnBar.NowBlockNum--;

							} catch (NullPointerException p) {
								//System.out.println("상자가 비어있습니다.");
							}
						}
					}
				}
			});
		}

		gameVictoryScene.setBounds(0, 0, 1196, 672);
		frame.getContentPane().add(gameVictoryScene);
		gameVictoryScene.setLayout(null);

		NextRoundButton.setText("다음 라운드로 가기");
		NextRoundButton.setFont(new Font("굴림", Font.BOLD, 20));
		NextRoundButton.setBounds(300, 500, 300, 60);
		gameVictoryScene.add(NextRoundButton);

		robbyButton.setText("로비로 가기");
		robbyButton.setFont(new Font("굴림", Font.BOLD, 20));
		robbyButton.setBounds(650, 500, 300, 60);
		robbyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 main lobby = new main();
				 lobby.lobby();
				 lobby.frame.setVisible(true);
			}
		});
		gameVictoryScene.add(robbyButton);

		gameVictoryImage.setIcon(new ImageIcon(
				"C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\vegatable VS enemy\\GameSuccess.png"));
		gameVictoryImage.setHorizontalAlignment(SwingConstants.CENTER);
		gameVictoryImage.setBounds(22, 129, 1162, 230);
		gameVictoryScene.add(gameVictoryImage);

		victoryText.setText("당신은 집을 무사히 지켰습니다");
		victoryText.setFont(new Font("굴림", Font.BOLD, 20));
		victoryText.setHorizontalAlignment(SwingConstants.CENTER);
		victoryText.setBounds(0, 369, 1196, 121);
		gameVictoryScene.add(victoryText);

		// 게임 오버 씬
		gameOverScene.setBounds(0, 0, 1196, 672);
		frame.getContentPane().add(gameOverScene);
		gameOverScene.setLayout(null);

		gameOverImage.setIcon(new ImageIcon(
				"C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\vegatable VS enemy\\game_over.png"));
		gameOverImage.setHorizontalAlignment(SwingConstants.CENTER);
		gameOverImage.setBounds(373, 5, 450, 368);
		gameOverScene.add(gameOverImage);

		exitText.setText("게임종료");
		exitText.setForeground(Color.GRAY);
		exitText.setFont(new Font("굴림", Font.BOLD, 20));
		exitText.setBounds(385, 569, 426, 68);
		exitText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		gameOverScene.add(exitText);

		reasonLosingText.setText("당신은 기지을 부시지 못했습니다.");
		reasonLosingText.setFont(new Font("굴림", Font.BOLD, 20));
		reasonLosingText.setHorizontalAlignment(SwingConstants.CENTER);
		reasonLosingText.setBounds(0, 424, 1196, 83);
		gameOverScene.add(reasonLosingText);

		// 게임시작 시 화면
		Stage2GameScene.setVisible(true);
		gameVictoryScene.setVisible(false);
		gameOverScene.setVisible(false);

		controlSpawnBar.start();
		SpawnEnemy.start();
	}
}
