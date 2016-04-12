package GUI;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class LevelSelector extends JPanel {
	KabasujiFrame kFrame;

	/**
	 * Create the panel.
	 */
	public LevelSelector(KabasujiFrame frame) {
		kFrame = frame;
		setLayout(null);
		setBackground(new Color(176, 224, 230));
		setBounds(100, 100, 900, 900);
		
		JButton puzzleLevel1 = new JButton("1");
		puzzleLevel1.setBounds(180, 200, 60, 50);
		puzzleLevel1.setForeground(new Color(255, 165, 0));
		puzzleLevel1.setBackground(new Color(255, 165, 0));
		puzzleLevel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.Puzzle1);
			}
		});
		add(puzzleLevel1);
		
		JLabel lblKabasuji = new JLabel("Kabasuji");
		lblKabasuji.setBounds(6, 0, 900, 34);
		add(lblKabasuji);
		
		JButton puzzleLevel2 = new JButton("2");
		puzzleLevel2.setBounds(300, 200, 60, 50);
		puzzleLevel2.setForeground(new Color(255, 165, 0));
		puzzleLevel2.setBackground(new Color(255, 165, 0));
		add(puzzleLevel2);
		
		JButton puzzleLevel3 = new JButton("3");
		puzzleLevel3.setBounds(420, 200, 60, 50);
		puzzleLevel3.setForeground(new Color(255, 165, 0));
		puzzleLevel3.setBackground(new Color(255, 165, 0));
		add(puzzleLevel3);
		
		JButton puzzleLevel4 = new JButton("4");
		puzzleLevel4.setBounds(540, 200, 60, 50);
		puzzleLevel4.setForeground(new Color(255, 165, 0));
		puzzleLevel4.setBackground(new Color(255, 165, 0));
		add(puzzleLevel4);
		
		JButton puzzleLevel5 = new JButton("5");
		puzzleLevel5.setBounds(660, 200, 60, 50);
		puzzleLevel5.setForeground(new Color(255, 165, 0));
		puzzleLevel5.setBackground(new Color(255, 165, 0));
		add(puzzleLevel5);
		
		JButton releaseLevel1 = new JButton("1");
		releaseLevel1.setBounds(180, 364, 60, 50);
		releaseLevel1.setForeground(new Color(255, 165, 0));
		releaseLevel1.setBackground(new Color(255, 165, 0));
		add(releaseLevel1);
		
		JButton releaseLevel2 = new JButton("2");
		releaseLevel2.setBounds(300, 364, 60, 50);
		releaseLevel2.setForeground(new Color(255, 165, 0));
		releaseLevel2.setBackground(new Color(255, 165, 0));
		add(releaseLevel2);
		
		JButton releaseLevel3 = new JButton("3");
		releaseLevel3.setBounds(420, 364, 60, 50);
		releaseLevel3.setForeground(new Color(255, 165, 0));
		releaseLevel3.setBackground(new Color(255, 165, 0));
		add(releaseLevel3);
		
		JButton releaseLevel4 = new JButton("4");
		releaseLevel4.setBounds(540, 364, 60, 50);
		releaseLevel4.setForeground(new Color(255, 165, 0));
		releaseLevel4.setBackground(new Color(255, 165, 0));
		add(releaseLevel4);
		
		JButton releaseLevel5 = new JButton("5");
		releaseLevel5.setBounds(660, 364, 60, 50);
		releaseLevel5.setForeground(new Color(255, 165, 0));
		releaseLevel5.setBackground(new Color(255, 165, 0));
		add(releaseLevel5);
		
		JButton lightningLevel1 = new JButton("1");
		lightningLevel1.setBounds(180, 528, 60, 50);
		lightningLevel1.setForeground(new Color(255, 165, 0));
		lightningLevel1.setBackground(new Color(255, 165, 0));
		add(lightningLevel1);
		
		JButton lightningLevel2 = new JButton("2");
		lightningLevel2.setBounds(300, 528, 60, 50);
		lightningLevel2.setForeground(new Color(255, 165, 0));
		lightningLevel2.setBackground(new Color(255, 165, 0));
		add(lightningLevel2);
		
		JButton lightningLevel3 = new JButton("3");
		lightningLevel3.setBounds(420, 528, 60, 50);
		lightningLevel3.setForeground(new Color(255, 165, 0));
		lightningLevel3.setBackground(new Color(255, 165, 0));
		add(lightningLevel3);
		
		JButton lightningLevel4 = new JButton("4");
		lightningLevel4.setBounds(540, 528, 60, 50);
		lightningLevel4.setForeground(new Color(255, 165, 0));
		lightningLevel4.setBackground(new Color(255, 165, 0));
		add(lightningLevel4);
		
		JButton lightningLevel5 = new JButton("5");
		lightningLevel5.setBounds(660, 528, 60, 50);
		lightningLevel5.setForeground(new Color(255, 165, 0));
		lightningLevel5.setBackground(new Color(255, 165, 0));
		add(lightningLevel5);
		
		JLabel puzzleLabel = new JLabel("Puzzle");
		puzzleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		puzzleLabel.setBounds(417, 140, 66, 25);
		add(puzzleLabel);
		
		JLabel releaseLabel = new JLabel("Release");
		releaseLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		releaseLabel.setBounds(414, 304, 72, 25);
		add(releaseLabel);
		
		JLabel lblLightning = new JLabel("Lightning");
		lblLightning.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblLightning.setBounds(405, 468, 90, 25);
		add(lblLightning);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(30, 60, 117, 29);
		btnMainMenu.setForeground(new Color(255, 165, 0));
		btnMainMenu.setBackground(new Color(255, 165, 0));
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				kFrame.getCardLayout().show(kFrame.getContentPane(), kFrame.MainMenu);
			}
		});
		add(btnMainMenu);
		
		JLabel lblSelectLevel = new JLabel("Select Level");
		lblSelectLevel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblSelectLevel.setBounds(391, 60, 117, 29);
		add(lblSelectLevel);
		
		JLabel lblPuzzleStars1 = new JLabel("Stars");
		lblPuzzleStars1.setBounds(180, 260, 61, 16);
		add(lblPuzzleStars1);
		
		JLabel lblPuzzleStars2 = new JLabel("Stars");
		lblPuzzleStars2.setBounds(300, 260, 61, 16);
		add(lblPuzzleStars2);
		
		JLabel lblPuzzleStars3 = new JLabel("Stars");
		lblPuzzleStars3.setBounds(420, 260, 61, 16);
		add(lblPuzzleStars3);
		
		JLabel lblPuzzleStars4 = new JLabel("Stars");
		lblPuzzleStars4.setBounds(540, 260, 61, 16);
		add(lblPuzzleStars4);
		
		JLabel lblPuzzleStars5 = new JLabel("Stars");
		lblPuzzleStars5.setBounds(660, 260, 61, 16);
		add(lblPuzzleStars5);
		
		JLabel lblReleaseStars1 = new JLabel("Stars");
		lblReleaseStars1.setBounds(180, 426, 61, 16);
		add(lblReleaseStars1);
		
		JLabel lblReleaseStars2 = new JLabel("Stars");
		lblReleaseStars2.setBounds(300, 426, 61, 16);
		add(lblReleaseStars2);
		
		JLabel lblReleaseStars3 = new JLabel("Stars");
		lblReleaseStars3.setBounds(417, 426, 61, 16);
		add(lblReleaseStars3);
		
		JLabel lblReleaseStars4 = new JLabel("Stars");
		lblReleaseStars4.setBounds(540, 426, 61, 16);
		add(lblReleaseStars4);
		
		JLabel lblReleaseStars5 = new JLabel("Stars");
		lblReleaseStars5.setBounds(660, 426, 61, 16);
		add(lblReleaseStars5);
		
		JLabel lblLightningStars1 = new JLabel("Stars");
		lblLightningStars1.setBounds(180, 590, 61, 16);
		add(lblLightningStars1);
		
		JLabel lblLightningStars2 = new JLabel("Stars");
		lblLightningStars2.setBounds(300, 590, 61, 16);
		add(lblLightningStars2);
		
		JLabel lblLightningStars3 = new JLabel("Stars");
		lblLightningStars3.setBounds(420, 590, 61, 16);
		add(lblLightningStars3);
		
		JLabel lblLightningStars4 = new JLabel("Stars");
		lblLightningStars4.setBounds(540, 590, 61, 16);
		add(lblLightningStars4);
		
		JLabel lblLightningStars5 = new JLabel("Stars");
		lblLightningStars5.setBounds(660, 590, 61, 16);
		add(lblLightningStars5);
	}

}
