package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ScrollPaneConstants;

import controller.DragCtrl;
import controller.HorizontalFlipCtrl;
import controller.MouseMoveCtrl;
import controller.PieceInBullpenCtrl;
import controller.RotateClockwiseCtrl;
import controller.RotateCounterClockwiseCtrl;
import controller.VerticalFlipCtrl;
import entity.Bullpen;
import entity.Level;
import entity.Piece;
import entity.PieceTile;
import view.PieceView;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

public class BullpenView extends JPanel {
	/**
	 * Auto-generate by Eclipse to suppress a warning
	 */
	private static final long serialVersionUID = -8191499983721942807L;
	
	//bullpen that this view represents
	Bullpen bullpen;
	//Views of a piece contained by this Bullpen
	ArrayList<PieceView> pieces;
	//containers for the pieces in a bullpen(is this necessary to keep track of?)
	//ArrayList<JPanel> pieceContainers;
	
	//the current selected pieceview 
	PieceView selected;
	Piece p;
	JPanel level;
	
	JPanel scrollPanel;
	
	Boolean repaint = true;
	
	/**
	 * Create the panel.
	 * @param b The bullpen to use when creating this panel.
	 * @param l The level this panel will be used in.
	 */
	public BullpenView(Bullpen b, JPanel l) {
		level = l;
		pieces = new ArrayList<PieceView>();
		//pieceContainers = new ArrayList<JPanel>();
		selected = new PieceView(new Piece());
		//get bullpen and pieces
		this.bullpen = b;
		//ArrayList<Piece> p = b.getPieces();
		//possibly need to know the quantity of each piece left
		//HashMap<Piece, Integer> pleft = b.getPiecesInfo();
		setLayout(null);
		setBounds(0, 0, 600, 300);
		setBackground(new Color(255, 165, 0));

		scrollPanel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane(scrollPanel);
		scrollPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		scrollPane.setBounds(10, 10, 580, 240);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		for(int i = 0; i < b.getPieces().size(); i++){ 
			//JPanel pieceContainer = new JPanel(new GridLayout(1,0));
			
			//is it needed to keep track of this?
			//pieceContainers.add(pieceContainer);
			
			//not to sure on the math here, it just works
			//pieceContainer.setBounds(10 + i * 200, 10, 6 * KabasujiFrame.tileWidth, 6 * KabasujiFrame.tileHeight);
			
			PieceView p = new PieceView(b.getPieces().get(i));
			p.addMouseListener(new PieceInBullpenCtrl(this, p));
			pieces.add(p);
			pieces.get(i).setBounds(10 + i * 200, 10, 6 * KabasujiFrame.tileWidth, 6 * KabasujiFrame.tileHeight);
			//pieceContainer.add(pieces.get(i));
            //scrollPanel.add(pieceContainer); 
			scrollPanel.add(pieces.get(i));
            scrollPanel.setPreferredSize(new Dimension(200 * scrollPanel.getComponents().length, 0)); 
            scrollPanel.validate();
		}

		JPanel panel = new JPanel();
		panel.setBounds(10, 250, 580, 40);
		add(panel);
		panel.setLayout(new GridLayout(1, 4, 0, 0));
		
		JButton btnNewButton = new JButton("Rotate Clockwise");
		btnNewButton.addMouseListener(new RotateClockwiseCtrl(this));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rotate Counter-Clockwise");
		btnNewButton_1.addMouseListener(new RotateCounterClockwiseCtrl(this));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Flip Horizontally");
		btnNewButton_2.addMouseListener(new HorizontalFlipCtrl(this));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Flip Vertically");
		btnNewButton_3.addMouseListener(new VerticalFlipCtrl(this));
		panel.add(btnNewButton_3); 

	}
	
	
	
	/**
	 * Properly update the displayed info on this {@link Bullpen}
	 */
	@Override 
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		ArrayList<Piece> p = bullpen.getPieces();
		for(int i = 0; i < p.size(); i++){
			try{
				pieces.get(i).setPiece(p.get(i));
			}catch(IndexOutOfBoundsException e){
				//if the bullpen has extra pieces, then add it to the view
				this.addPiece(p.get(i));
			}				
		}
	}
	
	/**
	 * Removes a piece from this bullpen.
	 * @param p The piece to remove from the bullpen.
	 */
	public void removePiece(PieceView p){
		pieces.remove(p);
		scrollPanel.remove(p);
		bullpen.getPieces().remove(p.getPiece());
		scrollPanel.setPreferredSize(new Dimension(200 * scrollPanel.getComponents().length, 0)); 
	}
	
	/**
	 * Removes all pieces from the bullpen.
	 */
	public void removeAll(){
		int length = pieces.size();
		
		for(int i = length - 1; i >= 0; i--){
			this.removePiece(pieces.get(i));
		}
	}
	
	@Override
	public void repaint(){
		if(repaint != null && repaint){
			super.repaint();
			repaint = false;
		}
	}
	
	/**
	 * this is needed to prevent flickering when dragging inside the board.
	 */
	public void setRepaintValid(){
		repaint = true;
		for(PieceView p: pieces){
			p.setRepaintValid();
		}
		repaint();
	}
	
	/**
	 * @return the bullpen
	 */
	public Bullpen getBullpen() {
		return bullpen;
	}
	
	/**
	 * Get all of the pieceViews in this bullpenView.
	 * @return A list of the pieceViews contained in this bullpenView.
	 */
	public ArrayList<PieceView> getPieceViews(){
		return pieces;
	}
	
	/**
	 * Sets the currently selected piece.
	 * @param p The piece we want to select.
	 */
	public void setSelected(PieceView p){
		selected = p;
	}
	
	/**
	 * Returns the currently selected piece.
	 * @return The currently selected piece.
	 */
	public PieceView getSelected(){
		return selected;
	} 
	
	/**
	 * Adds a piece to this bullpenView.
	 * @param p The piece to be added.
	 */
	public void addPiece(Piece p) {
		PieceView pv = new PieceView(p);
		pv.addMouseListener(new PieceInBullpenCtrl(this, pv));
		pv.addMouseListener(new DragCtrl(pv, level));
		pv.addMouseMotionListener(new MouseMoveCtrl(level));
		pv.setBounds(10 + (bullpen.getNumPieces() - 1) * 200, 10, 6 * KabasujiFrame.tileWidth, 6 * KabasujiFrame.tileHeight);
		pieces.add(pv);
		scrollPanel.add(pv);
        scrollPanel.setPreferredSize(new Dimension(200 * scrollPanel.getComponents().length, 0)); 
        revalidate();
		setRepaintValid();
	}
	
}
