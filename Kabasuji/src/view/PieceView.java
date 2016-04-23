package view;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import entity.Piece;
import entity.Tile;
/**
 * View for a piece
 * @author Quoc HoLam
 *
 */
public class PieceView extends JPanel {
	/**
	 * Auto-generate by Eclipse to suppress a warning
	 */
	private static final long serialVersionUID = 7304415273821237640L;
	
	//Piece that this view represents
	Piece piece;
	//Tileviews contained by this pieceview
	TileView[][] tilesView;
	
	public PieceView(Piece p) {
		super();
		
		piece = p;
		Tile[][] g = p.getShapeGrid(); 
		
		setLayout(new GridLayout(p.getMaxHeight(), p.getMaxWidth(), 0, 0));
		tilesView = new TileView[p.getMaxHeight()][p.getMaxWidth()];
		for(int i = 0; i < p.getMaxHeight(); i++){
			for(int j = 0; j < p.getMaxWidth(); j++){
				tilesView[i][j] = new TileView(g[i][j]);
				add(tilesView[i][j]);
			}
		}	 
	} 
	
	/**
	 * Properly update the displayed info on this {@link Piece}
	 */
	@Override 
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Tile[][] grid = piece.getShapeGrid();
		
		for(int i = 0; i < tilesView.length; i++){
			for(int j = 0; j < tilesView[i].length; j++){
				tilesView[i][j].setTile(grid[i][j]);
			}
		}	
	}

	/**
	 * @return the piece
	 */
	public Piece getPiece() {
		return piece;
	}

	public void setPiecce(Piece p){
		piece = p;
		repaint();
	}
}
