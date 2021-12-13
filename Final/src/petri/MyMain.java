package petri;

public class MyMain {

	public static void main(String[] args) {

		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();

		// TASK 2: ADD A USER GAME OBJECT
		Type_A_GameObject a = new Type_A_GameObject(100, 100);
		Type_C_GameObject c = new Type_C_GameObject(200, 200);
		Type_D_GameObject d = new Type_D_GameObject(300, 300);
		Type_B_GameObject b = new Type_B_GameObject(d);
		
		canvas.addKeyListener(a);
		canvas.addGameObject(a);
		a.setVelocity(5);
		
		canvas.addKeyListener(b);
		canvas.addGameObject(b);
		b.setVelocity(5);

		canvas.addKeyListener(c);
		canvas.addGameObject(c);
		c.setVelocity(5);
		
		canvas.addKeyListener(d);
		canvas.addGameObject(d);
		d.setVelocity(5);
		
		

		
	}

}