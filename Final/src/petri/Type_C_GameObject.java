package petri;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_C_GameObject extends GameObject implements KeyListener {

	// constructor

	public Type_C_GameObject(int x, int y) {
		super(x, y);
		

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_C_Left.png"));
		imageList.add(new ImageIcon("images/Type_C_Right.png"));
	}

	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		int iconWidth = icon.getIconHeight();
		int canvasWidth = (int) c.getSize().getHeight();
		if (getHighlight() == true) {
			// move the object
			switch (getDirection()) {
			case Direction.RIGHT:
				setImage();
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);
				}
				break;
			case Direction.LEFT:
				setImage();
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX((int) (canvasWidth - iconWidth));
				}
				break;
			}
		} else {
			if (getDirection() == Direction.LEFT) {
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);
					setDirection(Direction.RIGHT);
					setImage();
				}
			} else {
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX((int) (canvasWidth - iconWidth));
					setDirection(Direction.LEFT);
					setImage();
				}
			}
		}

	}

	@Override
	public void setImage() {
		switch (getDirection()) {
		case Direction.NONE:
			break;
		case Direction.LEFT:
			currentImage = 0;
			break;
		case Direction.RIGHT:
			currentImage = 1;
			break;

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (getHighlight() == true) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				setDirection(Direction.LEFT);
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				setDirection(Direction.RIGHT);
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (getHighlight() == true) {
			if (e.getKeyCode() != KeyEvent.VK_TAB) {
			setDirection(Direction.NONE);
			}
		}

	}
}