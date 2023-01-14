package comp2402a5;
// Thanks to Pat Morin for this file!

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class RoadTripGame {
	
	/**
	 * Your code goes here
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
    	//TODO: Your solution goes here.
		Graph g = new AdjacencyLists(0);
		ArrayList<Character> firstL = new ArrayList<>();
		ArrayList<Character> lastL = new ArrayList<>();
	//	ArrayList<String> places  = new ArrayList<>();

		for (String line = r.readLine(); line != null; line = r.readLine()) {
			if(firstL.size()==0){

				//places.add(line);
				g.addVertex();
				firstL.add(line.charAt(0));
				lastL.add(line.charAt(line.length()-1));

				for(int i=0; i<firstL.size(); i++){ //go into vertex
					if((lastL.get(i)).equals((firstL.get(firstL.size()-1)))){
						g.addEdge(i, firstL.size()-1);
					}

				//other edge goes into the edge (vice versa)
					else if((firstL.get(i)).equals((lastL.get(lastL.size()-1)))){
						g.addEdge(lastL.size()-1,i);
					}
				}
			
			}

			else{

				if(firstL.contains(line.charAt(0))==false || lastL.contains(line.charAt(line.length()-1))==false){
					//places.add(line);
					g.addVertex();
					firstL.add(line.charAt(0));
					lastL.add(line.charAt(line.length()-1));

					for(int i=0; i<firstL.size(); i++){ //go into vertex
						if((lastL.get(i)).equals((firstL.get(firstL.size()-1)))){
							g.addEdge(i, firstL.size()-1);
						}

						//other edge goes into the edge (vice versa)
						else if((firstL.get(i)).equals((lastL.get(lastL.size()-1)))){
							g.addEdge(lastL.size()-1,i);
						}
					}
				//	System.out.println(firstL);
				} 
			}	
		}


		
		/*w.println(firstL);
		w.println(lastL);
		w.println(places);*/

		w.println(Algorithms.bfs(g, 0, firstL.size()-1)+1);

			
			
			
		}

	

	/**
	 * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
	 * and System.out or from filenames specified on the command line, then call doIt.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader r;
			PrintWriter w;
			if (args.length == 0) {
				r = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
				w = new PrintWriter(System.out);
			} else if (args.length == 1) {
				r = new BufferedReader(new FileReader(args[0], StandardCharsets.UTF_8));
				w = new PrintWriter(System.out);				
			} else {
				r = new BufferedReader(new FileReader(args[0], StandardCharsets.UTF_8));
				w = new PrintWriter(new FileWriter(args[1]));
			}
			long start = System.nanoTime();
			doIt(r, w);
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 1e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}
