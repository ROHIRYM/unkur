import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start of the app");
		
		List<Point> points1 = new ArrayList<>();
		points1.add(new Point(1, 1));
		points1.add(new Point(3, 1));
		points1.add(new Point(2, 1));
		
		for (Point point : points1) {
			System.out.println(point);
		}
		System.out.println();
		
		List<Point> points2 = new ArrayList<>();
		points2.add(new Point(3, 3));
		points2.add(new Point(1, 3));
		points2.add(new Point(1, 2));
		
		for (Point point : points2) {
			System.out.println(point);
		}
		System.out.println();
		
		points1.addAll(points2);
		for (Point point : points1) {
			System.out.println(point);
		}
		System.out.println();
		
		ArrayList<ArrayList<Point>> frogTest = frogTestSolution(new Point(1,1), new Point(4,5), new ArrayList<>());
		System.out.println(frogTest.size());
		for (ArrayList<Point> lvl : frogTest) {
			System.out.println(lvl);
		}
		
	}
	
	private static ArrayList<ArrayList<Point>> frogTestSolution(Point start, Point finish, List<Point> occupiedPoints) {
		ArrayList<ArrayList<Point>> resultTree = new ArrayList<>();
		ArrayList<Point> zeroLvl = new ArrayList<>();
		zeroLvl.add(start);
		resultTree.add(zeroLvl);
		if (!start.equals(finish)) {
			occupiedPoints.add(start);
			ArrayList<Point> firstLvl = makeAllSteps(start);
			buildResultTree(firstLvl, finish, occupiedPoints, resultTree);
		}
		return resultTree;
	}
	
	private static void buildResultTree(ArrayList<Point> curLvl, Point finish, List<Point> occupiedPoints, ArrayList<ArrayList<Point>> resultTree) {
		Iterator<Point> iter = curLvl.iterator();
		while (iter.hasNext()) {
			Point p = iter.next();
		    if (occupiedPoints.contains(p)) {
		    	iter.remove();
		    }
		    occupiedPoints.add(p);
		}
		if (!curLvl.isEmpty()) {
			resultTree.add(curLvl);
			if (!curLvl.contains(finish)) {
				buildResultTree(buildNewLvl(curLvl), finish, occupiedPoints, resultTree);
			}
		}
	}
	
	private static ArrayList<Point> buildNewLvl(ArrayList<Point> curLvl) {
		ArrayList<Point> result = new ArrayList<>();
		for (Point p : curLvl) {
			ArrayList<Point> temp = makeAllSteps(p);
			result.addAll(temp);
		}
		return result;
	}
	
	private static ArrayList<Point> makeAllSteps(Point start) {
		Point forward = start.stepForward();
		Point forwardLeft = start.stepForwardLeft();
		Point forwardRight = start.stepForwardRight();
		Point left = start.stepLeft();
		Point right = start.stepRight();
		ArrayList<Point> result = new ArrayList<>();
		addNotNullEl2List(forward, result);
		addNotNullEl2List(forwardLeft, result);
		addNotNullEl2List(forwardRight, result);
		addNotNullEl2List(left, result);
		addNotNullEl2List(right, result);
		return result;
	}
	
	private static <T> void addNotNullEl2List(T el, List<T> list) {
		if (el != null) {
			list.add(el);
		}
	}
}
