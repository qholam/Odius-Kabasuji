package entity;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import GUI.BoardPanel;
import GUI.BullpenView;
import GUI.KabasujiBuilderFrame;
import GUI.KabasujiFrame;
import GUI.LevelPanel;
import GUI.SpecifyBoardPropertiesView;
import controller.BoardCtrl;
import controller.DragCtrl;
import controller.HorizontalFlipCtrl;
import controller.MouseMoveCtrl;
import controller.PieceInBullpenCtrl;
import controller.RotateClockwiseCtrl;
import controller.RotateCounterClockwiseCtrl;
import controller.SpecifyBoardCtrl;
import controller.VerticalFlipCtrl;
import junit.framework.TestCase;
import view.PieceView;

public class TestControllers extends TestMouse {
	
	KabasujiGame game;
	KabasujiFrame kFrame;
	KabasujiBuilderFrame bFrame;
	Piece piece, p, piece2;
	PieceView pv;
	PieceTile[] pieceTiles = new PieceTile[6];
	Bullpen bp, bp2;
	BullpenView bpv;
	PieceInBullpenCtrl bpc;
	ArrayList<Piece> bpArray;
	Board board;
	BoardPanel boardPanel;
	BoardCtrl bc;
	MouseEvent pr, re;
	PuzzleLevel pl;
	LevelPanel lp;

	
	public void setUp(){
		
	piece = new Piece();
	for (int i = 0; i < 6; i++){
		pieceTiles[i] = new PieceTile();
		piece.addTile(pieceTiles[i], i, 0);
		}
	pv = new PieceView(piece);
	piece2 = piece;
	bp2 = new Bullpen();
	bp2.addPiece(piece, 1);
	board = new Board(pl, 12, 12);
	boardPanel = new BoardPanel(board);
	pl = new PuzzleLevel(5, board, bp2, true, 1, 1);
	kFrame = new KabasujiFrame();
	lp = new LevelPanel(kFrame, pl);
	bc = new BoardCtrl(boardPanel, lp);
	}
	
	public void testVerticalFlip(){
		bpArray = new ArrayList<Piece>();
		bpArray.add(piece);
		bp = new Bullpen(bpArray);
		bpv = new BullpenView(bp, lp);
		bpc = new PieceInBullpenCtrl(bpv, pv);
		VerticalFlipCtrl VFC = new VerticalFlipCtrl(bpv);
		pr = createRightClick(bpv, 18, 132);
		bpc.mousePressed(pr);
		pr = createClicked(bpv, 102, 29);
		VFC.mousePressed(pr);
		VFC.mouseReleased(pr);
		p = bpc.getPieceView().getPiece();
		assertEquals(piece, p);
		
	}
	
	public void testHorizantalFlip(){
		bpArray = new ArrayList<Piece>();
		bpArray.add(piece);
		bp = new Bullpen(bpArray);
		bpc = new PieceInBullpenCtrl(bpv, pv);
		bpv = new BullpenView(bp, lp);
		HorizontalFlipCtrl HFC = new HorizontalFlipCtrl(bpv);
		pr = createRightClick(bpv, 18, 132);
		bpc.mousePressed(pr);
		pr = createClicked(bpv, 90, 12);
		HFC.mousePressed(pr);
		HFC.mouseReleased(pr);
		p = bpc.getPieceView().getPiece();
		piece.horizontalFlip();
		assertEquals(piece, p);
	}
	
	public void testRotateCounterClockwise(){
		bpArray = new ArrayList<Piece>();
		bpArray.add(piece);
		bp = new Bullpen(bpArray);
		bpc = new PieceInBullpenCtrl(bpv, pv);
		bpv = new BullpenView(bp, lp);
		RotateCounterClockwiseCtrl RCC = new RotateCounterClockwiseCtrl(bpv);
		pr = createRightClick(bpv, 18, 132);
		bpc.mousePressed(pr);
		pr = createPressed(bpv, 45, 32);
		RCC.mousePressed(pr);
		RCC.mouseReleased(pr);
		p = bpc.getPieceView().getPiece();
		piece.rotateCounterclockwise();
		assertEquals(piece, p);
		
	}
	
	public void testRotateClockwise(){
		bpArray = new ArrayList<Piece>();
		bpArray.add(piece);
		bp = new Bullpen(bpArray);
		bpv = new BullpenView(bp, lp);
		bpc = new PieceInBullpenCtrl(bpv, pv);
		RotateClockwiseCtrl RC = new RotateClockwiseCtrl(bpv);
		pr = createRightClick(bpv, 18, 132);
		bpc.mousePressed(pr);;
		pr = createPressed(bpv, 102, 19);
		RC.mousePressed(pr);
		RC.mouseReleased(pr);
		p = bpc.getPieceView().getPiece();
		piece.rotateClockwise();
		assertEquals(piece, p);
	}
	
	public void testMoveMouseCtrl(){
		bpv = new BullpenView(bp2, lp);
		bpc = new PieceInBullpenCtrl(bpv, pv);
		MouseMoveCtrl MMC = new MouseMoveCtrl(lp);
		pr = createClicked(bpv, 18, 132);
		bpc.mousePressed(pr);
		pr = mouseMoved(bpv, 643, 148);
		MMC.mouseMoved(pr);
		pr = createClicked(bpv, 643, 132);
		MMC.mousePressed(pr);
		p = bpc.getPieceView().getPiece();
		assertTrue(p != null);
	}

	public void testDragCtrl(){
		bpv = new BullpenView(bp2, lp);
		bpc = new PieceInBullpenCtrl(bpv, pv);
		DragCtrl dc = new DragCtrl(pv, lp);
		pr = createClicked(bpv, 18, 132);
		dc.mousePressed(pr);
		re = createClicked(boardPanel, 15, 21);
		dc.mouseReleased(re);
		//bc.mouseReleased(re);
		p = bc.getBoardView().getBoard().getPieceAt(0, 0);
		//assertEquals(lp.getPieceContainer().getDraggingPiece(), pv);
	}
	
	public void testSpecifyBoardCtrl(){
		bFrame = new KabasujiBuilderFrame();
		SpecifyBoardPropertiesView properties = new SpecifyBoardPropertiesView(bFrame);
		SpecifyBoardCtrl sbc = new SpecifyBoardCtrl(properties, boardPanel);
		bpv = new BullpenView(bp2, lp);
		bpc = new PieceInBullpenCtrl(bpv, pv);
		pr = createClicked(bpv, 18, 132);
		sbc.mouseClicked(pr);
		//sbc.mousePressed(pr);
		re = createClicked(boardPanel, 15, 21);
		sbc.mousePressed(re);
	}
	
}
