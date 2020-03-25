package Stage2;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.UIManager;

import Stage1.Vegetable_VS_Enemy;

import javax.swing.JLabel;
import java.util.ArrayList;

public class main {
	
	public JFrame frame;

	JButton startButton = new JButton();


	JPanel GameExplainScene = new JPanel();

	JLabel stageBackground = new JLabel();
	JLabel GameExplainImage = new JLabel();
	JButton nextStageButton = new JButton();
	JButton beforeStageButton = new JButton();
	JButton StartButton = new JButton();
	JButton explainButton = new JButton();
	JButton previousButton = new JButton();
	
	int whatStage = 0; //어떤 스테이지인지 
	
	
	JPanel lobbyScene = new JPanel();
	JPanel StartScene = new JPanel() {
		public void paintComponent(Graphics g) {
			Dimension d = getSize();
			ImageIcon image = new ImageIcon("./image/robbyImage.jpg");
			g.drawImage(image.getImage(), 0, 0, d.width, d.height, this);
		}
	};

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// main animal_VS_Enemy = new main();
					// animal_VS_Enemy.animal_VS_Enemy();
					// animal_VS_Enemy.frame.setVisible(true);
					main lobby = new main();
					lobby.lobby();
					lobby.StartScene.setVisible(true);
					lobby.lobbyScene.setVisible(false);
					lobby.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @wbp.parser.entryPoint
	 */

	public void lobby() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Robby");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		lobbyScene.setBackground(SystemColor.window);
		lobbyScene.setBounds(0, 0, 1196, 672);
		frame.getContentPane().add(lobbyScene);
		lobbyScene.setLayout(null);
		
		StartScene.setBounds(0, 0, 1196, 672);
		frame.getContentPane().add(StartScene);
		StartScene.setLayout(null);
		
		startButton.setText("게임 시작");
		startButton.setBounds(259, 420, 692, 84);
		startButton.setFont(new Font("굴림", Font.BOLD, 25));
		startButton.setBackground(Color.WHITE);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartScene.setVisible(false);
				lobbyScene.setVisible(true);
			}
		});
		StartScene.add(startButton);


		stageBackground.setIcon(new ImageIcon("C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\lobby\\Stage1.png"));
		stageBackground.setBounds(219, 78, 780, 438);
		lobbyScene.add(stageBackground);

		nextStageButton.setIcon(new ImageIcon("C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\lobby\\nextButton.png"));
		nextStageButton.setFocusPainted(false);
		nextStageButton.setContentAreaFilled(false);
		nextStageButton.setBorderPainted(false);
		nextStageButton.setBounds(1010, 240, 150, 110);
		nextStageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(whatStage != 1) {
					whatStage++;
					System.out.println(whatStage);
				}
				
				if(whatStage == 0) {
					stageBackground.setIcon(new ImageIcon("C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\lobby\\Stage1.png"));
					
				}else if(whatStage == 1) {
					stageBackground.setIcon(new ImageIcon("C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\lobby\\Stage2.jpg"));
				}
			}
		});
		lobbyScene.add(nextStageButton);

		beforeStageButton.setIcon(new ImageIcon("C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\lobby\\beforeButton.png"));
		beforeStageButton.setFocusPainted(false);
		beforeStageButton.setContentAreaFilled(false);
		beforeStageButton.setBorderPainted(false);
		beforeStageButton.setBounds(50, 240, 150, 110);
		beforeStageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(whatStage != 0) {
					whatStage--;
					System.out.println(whatStage);
				}
				
				if(whatStage == 0) {
					stageBackground.setIcon(new ImageIcon("C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\lobby\\Stage1.png"));
					
				}else if(whatStage == 1) {
					stageBackground.setIcon(new ImageIcon("C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\lobby\\Stage2.jpg"));
				}
			}
		});
		lobbyScene.add(beforeStageButton);

		StartButton.setText("게임 시작");
		StartButton.setBackground(Color.LIGHT_GRAY);
		StartButton.setForeground(UIManager.getColor("InternalFrame.inactiveTitleForeground"));
		StartButton.setFont(new Font("굴림", Font.BOLD, 20));
		StartButton.setBounds(219, 550, 381, 84);
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (whatStage == 0) {
					Vegetable_VS_Enemy Stage1 = new Vegetable_VS_Enemy();
					Stage1.vegetableVSenemy();
					Stage1.frame.setVisible(true);
					frame.setVisible(false);
					
				} else if (whatStage == 1) {
					Animal_VS_Enemy stage2 = new Animal_VS_Enemy();
					stage2.animal_VS_Enemy();
					stage2.frame.setVisible(true);
					frame.setVisible(false);
				}
			}
		});
		lobbyScene.add(StartButton);

		explainButton.setText("게임 설명");
		explainButton.setBackground(Color.LIGHT_GRAY);
		explainButton.setForeground(UIManager.getColor("InternalFrame.inactiveTitleForeground"));
		explainButton.setFont(new Font("굴림", Font.BOLD, 20));
		explainButton.setBounds(630, 550, 372, 84);
		explainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(whatStage == 0) {
					GameExplainImage.setIcon(new ImageIcon("C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\lobby\\round_1explanation.jpg"));
					
				}else if(whatStage == 1) {
					GameExplainImage.setIcon(new ImageIcon("C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\lobby\\round_2explanation.jpg"));
				}
				
				GameExplainScene.setVisible(true);
				lobbyScene.setVisible(false);
			}
		});
		lobbyScene.add(explainButton);
		

		// 게임 설명 씬 
		GameExplainScene.setBounds(0, 0, 1196, 672);
		frame.getContentPane().add(GameExplainScene);
		GameExplainScene.setLayout(null);

		previousButton.setIcon(new ImageIcon("C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\lobby\\beforeButton.png"));
		previousButton.setFocusPainted(false);
		previousButton.setContentAreaFilled(false);
		previousButton.setBorderPainted(false);
		previousButton.setBounds(25, 10, 141, 102);
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lobbyScene.setVisible(true);
				GameExplainScene.setVisible(false);
			}
		});
		GameExplainScene.add(previousButton);

		GameExplainImage.setIcon(new ImageIcon("C:\\Users\\dayou\\OneDrive\\바탕 화면\\팀노바\\자바gui게임\\lobby\\round_1explanation.jpg"));
		GameExplainImage.setBounds(0, 0, 1196, 672);
		GameExplainScene.add(GameExplainImage);

		// 시작 화면 
		lobbyScene.setVisible(true); 
		StartScene.setVisible(false);
		GameExplainScene.setVisible(false);
	}

}
