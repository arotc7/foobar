import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Answer {
	private static Set<Node> nodesChecked;
	public static int answer(int[][] maze) {
		nodesChecked = new HashSet<>();
		return solve(maze);
	}

	/**
	 * Solve performs a breadth-first search that allows for 2 different
	 * things to happen. It allows for all paths to be searched (including hitting the same
	 * node twice) but it does not allow hitting the same node twice without at least
	 * hitting a 1. For instance I could hit a node twice through basically the same path, but
	 * it won't let me hit it both of those times unless a 1 has been hit in between.
	 * @param maze
	 * @return
	 */
	public static int solve(int[][] maze) {
		Queue<Node> nodesToCheck = new LinkedList<>();
		
		// Add the root
		nodesToCheck.add(new Node(0, 0, 0, 0, 1));
		while(nodesToCheck.size() != 0) {
			Node currentNode = nodesToCheck.remove();
			// We have a solution
			if(currentNode.getRow() == maze.length - 1 && currentNode.getCol() == maze[0].length - 1) {
				return currentNode.getMoves();
			}
			
			// If any of the current node's children haven't
			// already been checked
			for(Node child : currentNode.getChildren(maze)) {
				if(!nodesChecked.contains(child)) {
					nodesChecked.add(child);
					nodesToCheck.add(child);
				}
			}
		}
		return -1;
	}
}

class Node {
	private int value;
	private int row;
	private int col;
	private int threshold;
	private int moves;

	/**
	 * Nodes represent a position in the matrix of the maze. It stores
	 * information about that position so that we can keep track of our BFS
	 * @param row the row of maze that the node is in
	 * @param col the column of the maze that the node is in
	 * @param value the value at that position
	 * @param threshold how many 1's we have passed through to get to this node
	 */
	public Node(int row, int col, int value, int threshold, int moves) {
		this.value = value;
		this.row = row;
		this.col = col;
		this.threshold = threshold;
		this.moves = moves;
	}

	public int getValue() {
		return value;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	public int getMoves() {
		return moves;
	}
	
	public int getThreshold() {
		return threshold;
	}
	
	/**
	 * Override equals so that we can check if something
	 * has been hit already. It doesn't count if the thresholds
	 * are different, though.
	 */
	@Override
	public boolean equals(Object o) {
		if(o == this) return true;
		if(!(o instanceof Node)) {
			return false;
		}
		
		Node node = (Node) o;
		return node.getRow() == row && node.getCol() == col
				&& node.getThreshold() == threshold;
	}
	
	/**
	 * If you override equals, you need to override hashcode
	 */
	@Override
	public int hashCode() {
		int ret = 17;
		ret += 31 * row;
		ret += 31 * col;
		ret += 31 * threshold;
		return ret;
	}
	
	/**
	 * Returns all of the valid children of this node.
	 * It is invalid if the next value is 1 and we have
	 * already hit the threshold. 
	 * @param maze the maze that we are looking at
	 * @return the list of the valid children
	 */
	public List<Node> getChildren(int[][] maze) {
		List<Node> children = new ArrayList<>();
		if(row + 1 < maze.length) {
			boolean wall = maze[row + 1][col] == 1;
			if(wall && threshold != 1) {
				children.add(new Node(row + 1, col, 1, threshold + 1, moves + 1));
			} else if(!wall) {
				children.add(new Node(row + 1, col, 0, threshold, moves + 1));
			}
		}
		
		if(col + 1 < maze[row].length) {
			boolean wall = maze[row][col + 1] == 1;
			if(wall && threshold != 1) {
				children.add(new Node(row, col + 1, 1, threshold + 1, moves + 1));
			} else if(!wall) {
				children.add(new Node(row, col + 1, 0, threshold, moves + 1));
			}
		}
		
		if(row - 1 >= 0) {
			boolean wall = maze[row - 1][col] == 1;
			if(wall && threshold != 1) {
				children.add(new Node(row - 1, col, 1, threshold + 1, moves + 1));
			} else if(!wall) {
				children.add(new Node(row - 1, col, 0, threshold, moves + 1));
			}
		}
		
		if(col - 1 >= 0) {
			boolean wall = maze[row][col - 1] == 1;
			if(wall && threshold != 1) {
				children.add(new Node(row, col - 1, 1, threshold + 1, moves + 1));
			} else if(!wall) {
				children.add(new Node(row, col - 1, 0, threshold, moves + 1));
			}
		}
		
		return children;
	}
}
