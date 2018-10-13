/**
 * 
 */
import java.util.ArrayList;
import edu.princeton.cs.algs4.Draw;

/**
 * @author vladislavkargin
 *
 */
public class Meander {
	int n; //size of the meander (should be even)
	ArrayList<Integer> uPairing; //upper pairing of the meander. It should be a permutation of the numbers 
	                             // 0 to n - 1 which is a involution without fixed points and it should represent 
	                             // a non-crossing pairing. 
	                             // for example 
	                             // 3 2 1 0 means that 0 is paired with 3 and 1 is paired with 2, which is 
	                             // a non-crossing pairing. 
	ArrayList<Integer> dPairing; //down pairing of the meander 
	Draw dr;

	/**
	 * default constructor
	 */
	public Meander() {
		// TODO Auto-generated constructor stub
	}

	public Meander(	ArrayList<Integer> uPairing, ArrayList<Integer> dPairing) {
		this.uPairing = uPairing;
		this.dPairing = dPairing;
		this.n = uPairing.size();
	}
    
	public void draw() {
		dr = new Draw();
		dr.clear(Draw.LIGHT_GRAY);
		dr.setXscale(-0.5, n - 0.5);
		dr.setYscale(- n + 0.5,  n - 0.5);
		dr.setPenRadius(0.002);
		dr.line(-0.5, 0, n, 0);
		dr.setPenRadius(0.005);
		for (int i = 0; i < n; i++) {
			int dist = (uPairing.get(i) - i);
			if (dist < 0) {
				dist = - dist;
			}
			dr.line(i, 0, i, dist);
			dr.line(i, dist, uPairing.get(i), dist);
			dr.line(uPairing.get(i), dist , uPairing.get(i), 0);
		}
		for (int i = 0; i < n; i++) {
			int dist = (dPairing.get(i) - i);
			if (dist < 0) {
				dist = - dist;
			}
			dr.line(i, 0, i, -dist);
			dr.line(i, -dist, dPairing.get(i), -dist);
			dr.line(dPairing.get(i), -dist , dPairing.get(i), 0);
		}
	}
	
	public ArrayList<Integer> randDyckPath(int n) {
		//in order to generate a random non-crossing pairing, we will generate a random Dyck path
		// n is supposed to be even. 
		ArrayList<Integer> DyckPath = new ArrayList<Integer>(n);
		return DyckPath;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		ArrayList<Integer> uPairing = new 	ArrayList<Integer>(n);
		ArrayList<Integer> dPairing = new 	ArrayList<Integer>(n);
        uPairing.add(3);
        uPairing.add(2);
        uPairing.add(1);
        uPairing.add(0);
        dPairing.add(1);
        dPairing.add(0);
        dPairing.add(3);
        dPairing.add(2);
        Meander mndr = new Meander(uPairing, dPairing);
        mndr.draw();
	}

}
