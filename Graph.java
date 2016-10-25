/**
 * A graph that stores its vertices, the relationships between those vertices, and a selection
 * of colors with which to perform color mapping
 *
 * @author Preston Peck 313
 * @version 1.0 August 11, 2016
 */

public class Graph {
	private String[] colors;
	private String[] vertices;
	private int[][] edges;
	private boolean solved;
	private boolean direction;//in order to only print when progress is again made 
	//instead of every node involved in a series of unsuccessful attempts
	
	/**
	 * Default constructor 
	 * @param colors array of testable colors
	 * @param vertices array representing vertices of a graph
	 * @param edges 2D array that stores edge relationships between vertices
	 * @param solved determines whether the vertices are in a final, valid colored state
	 * @param direction the current direction through vertices being traveled to find solution
	 */
	Graph() {
		colors = null;
		vertices = null;
		edges = null;
		solved = false;
		direction = true;
	}

	Graph(String[] cs, String[] vs, int[][] es, boolean s) {
		colors = cs;
		vertices = vs;
		edges = es;
		solved = s;
		direction = true;
	}
	
	/**
	 * Iterates through each vertex of a graph according to whether or not coloring attempts
	 * cause it to conflict with those it shares an edge with. When color options for a vertex have run 
	 * out, backtracking occurs and the vertex before it is changed to its next available, valid 
	 * color to see whether or not this changes anything for the one that was unable to be colored. 
	 * If all vertices exist in a state that does not cause conflict with its neighbors, this final
	 * state is printed and the graph is marked as completely colored and solved.
	 */
	public void colorGraph() {
		if (!solved) {
			int vertex = 0;
			while(vertex != vertices.length) {
				if (colorVertex(vertex) == false) {
					vertex--;
					direction = false;
				}
				else{
					vertex++;
					direction = true;
				}
			}
		}
		solved = true;
		System.out.println("SOLUTION:");
		for (int i = 0; i < vertices.length; i++) {
			System.out.println(i + ": " + vertices[i]);
		}
		System.out.println();
	}
	
	/**
	 * Cycles through the available colors sequentially and colors each vertex accordingly.
	 * After a vertex has been colored, comparisons are made to those vertices it shares edges
	 * with. If any of them share the same color, the next color in the sequence is selected
	 * and it is rechecked against its neighbors. If the color list has been exhausted and
	 * no color can be selected at this time, the function returns false for this vertex.
	 * @param v vertex
	 */
	private boolean colorVertex(int v) {
		int counter = 0;
		while (v != vertices.length) {
			if (vertices[v] == null) {
				vertices[v] = colors[0];
			}
			else {		
				for (int i = counter; i < colors.length; i++) {
					if (i == colors.length - 1) {
						vertices[v] = null;
						if (direction) {
							System.out.println("Backtracking from node " + v + "...");
							System.out.println("Progress: ");
							for (int j = 0; j < v; j++) {
								System.out.println(j + ": " + vertices[j]);
							}
							System.out.println();
						}
						return false;
					}
				
					else if (vertices[v] == colors[i]) {
						vertices[v] = colors[i+1];
						counter = i+1;
						break;
					}
				}
			}
			
			for (int i = 0; i < edges.length; i++) {
				if (edges[v][i] == 1 && vertices[v] == vertices[i]) {
					break;
				}
				else if (i == edges.length - 1) {
					return true;
				}
			}
		}
		return true;
	}
}