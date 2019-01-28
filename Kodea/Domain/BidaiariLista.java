package Domain;

import java.util.Iterator;
import java.util.Vector;

public class BidaiariLista {
	private Vector<Bidaiaria> lista;
	
	
	
	public BidaiariLista () {
		this.lista= new Vector<Bidaiaria>();
		
		//0. bidaiaria kendu, arazoak ekiditeko
		lista.add(new Bidaiaria(0,0,0));
	}
	
	public void addBidaiari(Bidaiaria bid) {
		if (!lista.contains(bid) )lista.add(bid);
	}
	public Bidaiaria getBid(int id) {
		return lista.get(id);		
	}
	
	public int size() {
		//0. bidaiaria hutsa delako
		return lista.size()-1;
	}
	
	public int bidPisua(int id) {
		return getBid(id).getPisua();
	}
	
	public double bidDirua(int id) {
		return getBid(id).getDirua();
	}
	
	public Vector<Bidaiaria> getLista(){
		return lista;
	}
	
	public void print() {
		System.out.println("BIDAIARI LISTA");
		System.out.println("");
		Iterator<Bidaiaria> it= lista.iterator();
		it.next();
		int pisua=0;
		while (it.hasNext()) {
			Bidaiaria bid= it.next();
			pisua= pisua+ bid.getPisua();
			System.out.println(bid.getID()+" "+bid.getDirua()+"€ "+ bid.getPisua()+"Kg ");
		}
		System.out.println("--------------");
		System.out.println("Pisua: "+pisua+"Kg ");
	}
}
