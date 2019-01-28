import java.util.Iterator;
import java.util.Vector;

public class Grafo {

	public Vector<Nodo> erpinak;
	public boolean pisua;
	
	public Grafo(boolean pisu) {
		erpinak = new Vector<Nodo>();
		pisua=pisu;
	}
	
	public Grafo(Grafo grafo) {
		erpinak=grafo.erpinak;
		pisua=grafo.pisua;
	}

	public void addErpina(int id) {
		Nodo erpin= new Nodo(id,pisua);
		erpinak.add(id, erpin);
	}
	
	public void addErtz(int id, int ertz_id, double pisu) {
		if(pisua) {
			erpinak.get(id).addErtz(ertz_id, pisu);
		}else {
			erpinak.get(id).addErtz(ertz_id);
		}
	}
	
	public Nodo getErpina(int id) {
		return erpinak.get(id);
	}
	
	public Iterator getAuzokide(int id) {
		return erpinak.get(id).bizilagunak.iterator();
	}
	
	public int getAuzokideKop(int id) {
		return erpinak.get(id).bizilagunak.size();
	}
	
	public int size() {
		return erpinak.size();
	}
}
