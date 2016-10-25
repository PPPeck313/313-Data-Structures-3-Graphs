import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Colors a graph given its adjacency table so that no two neighbors are the same color
 * 
 * @author Preston Peck 313
 * @version 1.0 August 11, 2016
 */

public class Project3 {
	public static void main(String[] args) {
		FileReader theFile;
		BufferedReader inFile;
		String oneLine;
		String colors[] = {"Red", "Green", "Blue", "Yellow"};
		int counter = 1;
		
		try {
			theFile = new FileReader(args[0]);
			inFile = new BufferedReader(theFile);
			while ((oneLine = inFile.readLine()) != null) {
				int count = Integer.parseInt(oneLine);
				String vertices[] = new String[count];
				int edges[][] = new int[count][count];
				for (int i = 0; i < count; i++) {
					oneLine = inFile.readLine();
					String numbers[] = oneLine.split(" ");
					for (int j = 0; j < count; j++) {
						edges[i][j] = Integer.parseInt(numbers[j]);
					}
				}
				Graph g = new Graph(colors,vertices,edges,false);
				System.out.println("Problem #" + counter);
				g.colorGraph();
				counter++;
			}	
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}