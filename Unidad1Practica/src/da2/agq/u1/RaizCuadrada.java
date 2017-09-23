package da2.agq.u1;

import java.io.Serializable;

public class RaizCuadrada implements Serializable {
	private double y;
	private double x;

	@Override
	public String toString() {
		return "RaizCuadrada [y=" + y + ", x=" + x + "]";
	}
	
	
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}


	
	
	public double getResult() {
		return  (2* (Math.sqrt(x))+Math.sqrt((2*y)))-(Math.sqrt(x)-(2*(Math.sqrt(2*y))));
	}
	

	
}
