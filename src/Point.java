
public class Point {

	private int x;
	
	private int y;
	
	private Point previous;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, Point previous) {
		this(x, y);
		this.previous = previous;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Point getPrevious() {
		return previous;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Point))
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	public Point stepForward() {
		return step(0, 3);
	}
	
	public Point stepLeft() {
		return step(-2, 1);
	}
	
	public Point stepRight() {
		return step(2, 1);
	}
	
	public Point stepForwardLeft() {
		return step(-1, 2);
	}
	
	public Point stepForwardRight() {
		return step(1, 2);
	}
	
	private Point step(int dX, int dY) {
		final int maxX = 10;
		final int maxY = 16;
		int x = this.x + dX;
		int y = this.y + dY;	
		if (x > maxX || x < 1) {
			return null;
		}		
		if (y > maxY) {
			y -= maxY;
		}		
		return new Point(x, y, this);
	}
}
