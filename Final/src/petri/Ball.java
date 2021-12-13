package petri;
import javax.swing.ImageIcon;

public class Ball extends GameObject{
	
	
	// data members: 
	private int imageWidth;
	
	// constructor
	public Ball(int x, int y) {
		super(x,y);
		setVelocity(3);

	}
	
	// implement abstract method move
	public void move(Canvas c) {
		// move the ball and check for collision
		if (getDirection() == Direction.LEFT) {
			setX(getX() + getVelocity());
			if(getX() + imageWidth > c.getSize().getWidth()) {
				setX((int)(c.getSize().getWidth() - imageWidth));
				setDirection(Direction.RIGHT);
			}
		}
		else {
			setX(getX() - getVelocity());
			if(getX() < 0) {
				setX(0);
				setDirection(Direction.LEFT);
			}
			
		}
		
		
		
	}

	@Override
	public void setImage() {
		// TODO Auto-generated method stub
		
	}

	
}