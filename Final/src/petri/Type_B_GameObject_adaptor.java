package petri;



public abstract class Type_B_GameObject_adaptor extends GameObject{
	GameObject gObj;
	
	public Type_B_GameObject_adaptor(GameObject gObj) 
	{
		super(gObj.getX(), gObj.getY());
	}
	
	public abstract void move(Canvas c);
}