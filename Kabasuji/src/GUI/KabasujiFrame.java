package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Board;
import entity.Bullpen;
import entity.Level;
import entity.LightningLevel;
import entity.Piece;
import entity.PieceTile;
import entity.PuzzleLevel;
import serializers.Deserializer;

import java.awt.CardLayout;

public class KabasujiFrame extends JFrame {
	final String SplashScreen = "SplashScreen";
	final String MainMenu = "MainMenu";
	final String Puzzle1 = "Puzzle1";
	final String LevelSelect = "LevelSelect";

	private JPanel contentPane;
	PieceContainer container;
	Piece[] pieces = new Piece[35];

	/**
	 * Create the frame.
	 */
	public KabasujiFrame() {
		
		/** Create all 35 Kabasuji Hexominos */
		pieces[1] = createPiece(new int[]{
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0
				});
		pieces[2] = createPiece(new int[]{
				1, 1, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[3] = createPiece(new int[]{
				0, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				1, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[4] = createPiece(new int[]{
				0, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 1, 1, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		pieces[5] = createPiece(new int[]{
				0, 0, 1, 1, 0, 0,
				1, 1, 1, 0, 0, 0,
				1, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0
				});
		
		Deserializer deserializer =  new Deserializer();
		container = new PieceContainer(); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CardLayout cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
		
		SplashScreen splash = new SplashScreen(this);
		
		MainMenuPanel mainMenu = new MainMenuPanel(this);
		mainMenu.setBounds(0, 0, 800, 800);
		contentPane.add(mainMenu, MainMenu);
		
		//to be remove this bullpen was made for testing
		Bullpen bp = new Bullpen();
		for (int i = 1; i <= 5; i++) {
			bp.addPiece(pieces[i]);
		}
		Level l = new PuzzleLevel(10, new Board(null, 10, 10), bp, true, 1, 0);
		//LevelPanel puzzle1 = new LevelPanel(this, deserializer.deserialzePuzzleLevel(1));
		LevelPanel puzzle1 = new LevelPanel(this, l);
		mainMenu.setBounds(0, 0, 800, 800);
		contentPane.add(puzzle1, Puzzle1);
		
		LevelSelector levelSelect = new LevelSelector(this);
		levelSelect.setBounds(0, 0, 800, 800);
		contentPane.add(levelSelect, LevelSelect);
		
		splash.displaySplashScreen();
	}
	
	public CardLayout getCardLayout() {
		return (CardLayout)contentPane.getLayout();
	}
	
	public PieceContainer getPieceContainer(){
		return container;
	}
	
	Piece createPiece(int[] tileIntArray) {
		Piece p = new Piece();
		int num = 0;
		for (int a = 0; a < 6; a++) {
			for (int b = 0; b < 6; b++) {
				if (tileIntArray[num] == 1) {
					p.addTile(new PieceTile(), b, a);
					System.out.print(1);
				}
				else {
					System.out.print(" ");
				}
				
				num++;
			}
			System.out.println("");
		}
		System.out.println("------");
		return p;
	}
}
