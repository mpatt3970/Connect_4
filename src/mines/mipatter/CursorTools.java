package mines.mipatter;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.RootPaneContainer;

// Thanks to http://www.javaspecialists.eu/archive/Issue065.html
public class CursorTools {

	private static Cursor WAIT_CURSOR = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
	private static Cursor DEFAULT_CURSOR = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);  

	private MouseListener deafMouse;
	
	public CursorTools() {
		this.deafMouse = new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		};
	}

	/** Sets cursor for specified component to Wait cursor */
	public void startWaitCursor(JComponent component) { 
		RootPaneContainer root =
				((RootPaneContainer) component.getTopLevelAncestor()); 
		root.getGlassPane().setCursor(WAIT_CURSOR);
		root.getGlassPane().addMouseListener(this.deafMouse);
		root.getGlassPane().setVisible(true);
	}

	/** Sets cursor for specified component to normal cursor */
	public void stopWaitCursor(JComponent component) {
		RootPaneContainer root =
				((RootPaneContainer) component.getTopLevelAncestor()); 
		root.getGlassPane().setCursor(DEFAULT_CURSOR);
		root.getGlassPane().removeMouseListener(this.deafMouse);
		root.getGlassPane().setVisible(false);
	}
}
