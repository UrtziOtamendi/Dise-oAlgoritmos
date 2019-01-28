package Domain;

import java.util.Vector;

public class Bidaia {

	private int P;
	private int T;
	private int N;
	private BidaiariLista bid;
	
	
	public Bidaia( int p, int t, int n, BidaiariLista l) {
		P=p;
		T=t;
		N=n;
		bid=l;
	}
	
	public void printLista() {
		bid.print();
	}
	
	public Vector<Bidaiaria> getLista(){
		return bid.getLista();
	}
	public Bidaiaria getBid(int id) {
		return bid.getBid(id);		
	}
	
	public int size() {
		return bid.size();
	}
	
	public int bidPisua(int id) {
		return bid.bidPisua(id);
	}
	
	public double bidDirua(int id) {
		return bid.bidDirua(id);
	}

	public int getP() {
		return P;
	}

	public void setP(int p) {
		P = p;
	}

	public int getT() {
		return T;
	}

	public void setT(int t) {
		T = t;
	}

	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}
	
	
}
