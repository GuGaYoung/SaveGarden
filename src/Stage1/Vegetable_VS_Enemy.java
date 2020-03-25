package Stage1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Stage2.main;

public class Vegetable_VS_Enemy {

	GameVictory gameVictory = new GameVictory(10);// 적의 수를 인수로 두었다.
	GameOver gameOver = new GameOver();
	IncreaseMana IncreaseMana = new IncreaseMana();
	static SpawnEnemy SpawnEnemy = new SpawnEnemy();

	static int[] vegetableX = new int[100];
	static int[] vegetableY = new int[100];
	final int TILE_WIDTH = 67;
	final int TILE_HEIGHT = 84; 
	int tileHorizontalLength = 223;
	int tileVerticalLength = 79;
	int tileInterval = 70; // 타일 간격
	static int mana = 30;
	String selectedVegetables = "";
	String vegetableImageURL = "";

	public JFrame frame;
	
	static JPanel Stage1GameScene = new JPanel() {
		public void paintComponent(Graphics g) {
			Dimension d = getSize();
			ImageIcon image = new ImageIcon("./image/vegetableVSenemyBackGround.PNG");
			g.drawImage(image.getImage(), 0, 0, d.width, d.height, this);
		}
	};
	static JPanel gameVictoryScene = new JPanel();
	static JPanel gameOverScene = new JPanel();

	JButton[] tile = new JButton[45];
	JButton cabbageButton = new JButton();
	JButton carrotButton = new JButton();
	JButton eggplantButton = new JButton();
	JButton beetButton = new JButton();
	JButton redbeetButton = new JButton();
	JButton gameStartButton = new JButton();
	JButton NextRoundButton = new JButton();
	JButton robbyButton = new JButton();
	JButton exitText = new JButton();

	static JLabel manaText = new JLabel();
	static JLabel[] bulletImage = new JLabel[500];
	static JLabel[] enemyImage = new JLabel[10];
	static JLabel[] healthBarBackground = new JLabel[10];
	static JLabel[] healthBarImage = new JLabel[10];
	JLabel stageText = new JLabel();
	JLabel gameVictoryImage = new JLabel();
	JLabel victoryText = new JLabel();
	JLabel gameOverImage = new JLabel();
	JLabel reasonLosingText = new JLabel();

	public void vegetableVSenemy() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Save Garden");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		Stage1GameScene.setBounds(0, 0, 1196, 672);
		frame.getContentPane().add(Stage1GameScene);
		Stage1GameScene.setLayout(null);

		stageText.setText("Stage 1");
		stageText.setFont(new Font("굴림", Font.BOLD, 30));
		stageText.setHorizontalAlignment(SwingConstants.CENTER);
		stageText.setBounds(811, 10, 223, 68);
		Stage1GameScene.add(stageText);

		manaText.setText("마나 : " + mana);
		manaText.setHorizontalAlignment(SwingConstants.CENTER);
		manaText.setFont(new Font("굴림", Font.BOLD, 20));
		manaText.setBounds(993, 25, 179, 44);
		Stage1GameScene.add(manaText);

		// 적 이미지 초기화
		for (int i = 0; i < enemyImage.length; i++) {
			Stage1GameScene.add(enemyImage[i] = new JLabel());
			enemyImage[i].setBounds(870, 1000, 100, 100);
		}

		// 체력바 초기화
		for (int i = 0; i < healthBarBackground.length; i++) {

			Stage1GameScene.add(healthBarImage[i] = new JLabel());
			healthBarImage[i].setIcon(new ImageIcon(
					"C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\vegatable VS enemy\\healthbar_red.png"));
			healthBarImage[i].setBounds(2000, 2000, 36, 4);

			Stage1GameScene.add(healthBarBackground[i] = new JLabel());
			healthBarBackground[i].setIcon(new ImageIcon(
					"C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\vegatable VS enemy\\healthbar_white.png"));
			healthBarBackground[i].setBounds(2000, 2000, 36, 4);
		}

		// 총알 초기화
		for (int i = 0; i < bulletImage.length; i++) {
			Stage1GameScene.add(bulletImage[i] = new JLabel());
			bulletImage[i].setIcon(new ImageIcon(
					"C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\vegatable VS enemy\\cabbageBullet.png"));
			bulletImage[i].setBounds(-500, -500, 12, 12);
		}

		// 타일 초기화
		for (int i = 0; i < tile.length; i++) {

			Stage1GameScene.add(tile[i] = new JButton());

			if (i < 9) {
				tileVerticalLength = 79;
				tile[i].setBounds(tileHorizontalLength, tileVerticalLength, TILE_WIDTH, TILE_HEIGHT);

			} else if ((i >= 9) && (i < 18)) {
				tileVerticalLength = 170;
				tile[i].setBounds(tileHorizontalLength, tileVerticalLength, TILE_WIDTH, TILE_HEIGHT);

			} else if ((i >= 18) && (i < 27)) {
				tileVerticalLength = 254;
				tile[i].setBounds(tileHorizontalLength, tileVerticalLength, TILE_WIDTH, TILE_HEIGHT);

			} else if ((i >= 27) && (i < 36)) {
				tileVerticalLength = 342;
				tile[i].setBounds(tileHorizontalLength, tileVerticalLength, TILE_WIDTH, TILE_HEIGHT);

			} else if ((i >= 36) && (i < 45)) {
				tileVerticalLength = 430;
				tile[i].setBounds(tileHorizontalLength, tileVerticalLength, TILE_WIDTH, TILE_HEIGHT);

			}
			tileHorizontalLength = tileInterval + tileHorizontalLength;
			tile[i].setFocusPainted(false);
			tile[i].setContentAreaFilled(false);
			tile[i].setBorderPainted(false);

			if ((i + 1) % 9 == 0) {
				tileHorizontalLength = 223;
			}
		}

		// 채소 생성버튼
		cabbageButton.setIcon(new ImageIcon(
				"C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\vegatable VS enemy\\cabbage.png"));
		cabbageButton.setBounds(12, 588, 103, 58);
		cabbageButton.setFocusPainted(false);
		cabbageButton.setContentAreaFilled(false);
		cabbageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedVegetables = "cabbage";
			}
		});
		Stage1GameScene.add(cabbageButton);

		carrotButton.setIcon(new ImageIcon(
				"C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\vegatable VS enemy\\carrot.png"));
		carrotButton.setBounds(137, 588, 103, 58);
		carrotButton.setFocusPainted(false);
		carrotButton.setContentAreaFilled(false);
		carrotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedVegetables = "carrot";
			}
		});
		Stage1GameScene.add(carrotButton);

		beetButton.setIcon(
				new ImageIcon("C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\vegatable VS enemy\\beat.png"));
		beetButton.setBounds(265, 588, 103, 58);
		beetButton.setFocusPainted(false);
		beetButton.setContentAreaFilled(false);
		beetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedVegetables = "beet";
			}
		});
		Stage1GameScene.add(beetButton);

		redbeetButton.setIcon(new ImageIcon(
				"C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\vegatable VS enemy\\redbeet.png"));
		redbeetButton.setBounds(395, 588, 103, 58);
		redbeetButton.setFocusPainted(false);
		redbeetButton.setContentAreaFilled(false);
		redbeetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedVegetables = "redbeet";
			}
		});
		Stage1GameScene.add(redbeetButton);

		eggplantButton.setIcon(new ImageIcon(
				"C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\vegatable VS enemy\\eggplant.png"));
		eggplantButton.setBounds(528, 588, 103, 58);
		eggplantButton.setFocusPainted(false);
		eggplantButton.setContentAreaFilled(false);
		eggplantButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedVegetables = "eggplant";
			}
		});
		Stage1GameScene.add(eggplantButton);

		// 채소 선택 버튼을 누른 후 타일을 선택하면 선택한 타일에 해당 채소가 생성된다.
		for (int i = 0; i < tile.length; i++) {
			tile[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					// 현재 마나의 수가 채소 생성에 필요한 최소 마나의 수보다 적으면 생성하지 못한다.
					if (mana >= 7) {
						if (selectedVegetables == "cabbage") {
							Cabbage cabbage = new Cabbage();
							cabbage.plantiInitialize();
							vegetableImageURL = cabbage.ImageURL;

							cabbage.attack();
							cabbage.instalPlants();

						} else if (selectedVegetables == "carrot") {
							Carrot carrot = new Carrot();
							carrot.plantiInitialize();
							vegetableImageURL = carrot.ImageURL;

							carrot.attack();
							carrot.instalPlants();

						} else if (selectedVegetables == "beet") {
							Beet beet = new Beet();
							beet.plantiInitialize();
							vegetableImageURL = beet.ImageURL;

							beet.attack();
							beet.instalPlants();

						} else if (selectedVegetables == "redbeet") {
							Redbeet redbeet = new Redbeet();
							redbeet.plantiInitialize();
							vegetableImageURL = redbeet.ImageURL;

							redbeet.attack();
							redbeet.instalPlants();

						} else if (selectedVegetables == "eggplant") {
							Eggplant eggplant = new Eggplant();
							eggplant.plantiInitialize();
							vegetableImageURL = eggplant.ImageURL;

							eggplant.attack();
							eggplant.instalPlants();
						}

						for (int i = 0; i < tile.length; i++) {
							if (e.getSource() == tile[i]) {
								if (tile[i].getIcon() == null) {
									// 선택한 타일에 채소 이미지가 들어간다
									tile[i].setIcon(new ImageIcon(vegetableImageURL));

									// 타일의 좌표값을 구한다 (총알의 위치를 선정하기 위해).
									vegetableX[Bullets.bulletsNum] = tile[i].getX();
									vegetableY[Bullets.bulletsNum] = tile[i].getY();

									manaText.setText("마나 : " + mana);

								} else {
									// System.out.println("이미 채소가 있습니다");
								}
							}
						}
					}
				}

			});
		}

		gameStartButton.setText("게임 준비 완료");
		gameStartButton.setFont(new Font("굴림", Font.BOLD, 15));
		gameStartButton.setBounds(12, 10, 138, 42);
		gameStartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameStartButton.setVisible(false);
				SpawnEnemy.start();
				IncreaseMana.start();
				gameVictory.start();
				gameOver.start();
			}
		});
		Stage1GameScene.add(gameStartButton);

		// 게임 승리 씬
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

		reasonLosingText.setText("당신은 집을 지키지 못했습니다.");
		reasonLosingText.setFont(new Font("굴림", Font.BOLD, 20));
		reasonLosingText.setHorizontalAlignment(SwingConstants.CENTER);
		reasonLosingText.setBounds(0, 424, 1196, 83);
		gameOverScene.add(reasonLosingText);

		// 게임 시작시 화면
		Stage1GameScene.setVisible(true);
		gameVictoryScene.setVisible(false);
		gameOverScene.setVisible(false);
	}
}
