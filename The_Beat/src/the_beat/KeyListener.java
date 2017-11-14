package the_beat;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import the_beat.Music;

public class KeyListener extends KeyAdapter {

	@Override
	public void keyPressed(KeyEvent e) {
		if(Beat.game==null && e.getKeyCode()==KeyEvent.VK_SPACE) {
			Beat.enterMain();
		}
		
		if(e.getKeyCode()== KeyEvent.VK_S) {
			Beat.game.pressS();
		}
		else if(e.getKeyCode()== KeyEvent.VK_D) {
			Beat.game.pressD();

		}
		else if(e.getKeyCode()== KeyEvent.VK_F) {
			Beat.game.pressF();

		}
		else if(e.getKeyCode()== KeyEvent.VK_J) {
			Beat.game.pressJ();

		}
		else if(e.getKeyCode()== KeyEvent.VK_K) {
			Beat.game.pressK();

		}
		else if(e.getKeyCode()== KeyEvent.VK_L) {
			Beat.game.pressL();

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(Beat.game==null) {
			return;
		}
		if(e.getKeyCode()== KeyEvent.VK_S) {
			Beat.game.releaseS();
		}
		else if(e.getKeyCode()== KeyEvent.VK_D) {
			Beat.game.releaseD();

		}
		else if(e.getKeyCode()== KeyEvent.VK_F) {
			Beat.game.releaseF();

		}
		else if(e.getKeyCode()== KeyEvent.VK_J) {
			Beat.game.releaseJ();

		}
		else if(e.getKeyCode()== KeyEvent.VK_K) {
			Beat.game.releaseK();

		}
		else if(e.getKeyCode()== KeyEvent.VK_L) {
			Beat.game.releaseL();

		}
	}
}
