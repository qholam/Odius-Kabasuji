package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import entity.Piece;
import entity.PieceTile;
import view.PieceView;
import view.TileView;

/**
 * A container for dragged pieces
 * @author Quoc HoLam
 *
 */
public class PieceContainer extends JPanel{
	//The piece being dragged, if applicable
	PieceView draggedPiece;
	//the tile that the mouse is hovering over during a drag
	TileView anchorTile;
	//source of the drag
	JPanel source;
	
	/**
	 * Constructor to create the Piece Container which will
	 * hold pieces being dragged.
	 */
	public PieceContainer() {
		super();
		
		source = null;
		draggedPiece = new PieceView(new Piece());
		setLayout(new GridLayout(1,0));
		setBounds(0,0,144,144);
		add(draggedPiece);
		
		//The panel holding the piece should not be visible.
		setOpaque(false);
	}
	
	/**
	 * Set the source of the drag.
	 * @param source JPanel in which this piece was dragged from.
	 */
	public void setSource(JPanel source){
		this.source = source;
	}
	
	/**
	 * Get the source.
	 * @return The source from which the dragged piece was dragged from.
	 */
	public JPanel getSource(){
		return source;
	}
	
	/**
	 * Set the dragging piece.
	 * @param p Piece now being dragged.
	 */
	public void setDraggingPiece(Piece p){
		draggedPiece.setPiece(p);
	}
	
	/**
	 * Get the piece being dragged.
	 * @return The piece currently being dragged.
	 */
	public PieceView getDraggingPiece(){
		return draggedPiece;
	}
	
	/**
	 * Set the anchor tile for which the mouse will be hovering over during the duration of the drag.
	 * @param t TileView to be hovered over. 
	 */
	public void setAnchortile(TileView t){
		anchorTile = t; 
	}
	
	/**
	 * Get the tile that the mouse is hovering over during a drag.
	 * @return The anchor tile.
	 */
	public TileView getAnchorTile(){
		return anchorTile;
	}
	
}
