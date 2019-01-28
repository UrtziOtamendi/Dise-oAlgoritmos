import java.util.Comparator;
import java.util.LinkedList;

public class Nodo implements Comparable<Nodo>{

	public int ID;
	public LinkedList bizilagunak;
	public double pisua=Integer.MAX_VALUE;

	public Nodo() {

	}


	public Nodo(int id, boolean pisua) {
		ID=id;
		if(pisua) {
			bizilagunak=new LinkedList<Bizilaguna>();
		}else {
			bizilagunak=new LinkedList<BizilagunaPisuGabe>();
		}
	}

	public void addErtz(int auzokide, double pisua) {
		Bizilaguna biz= new Bizilaguna(auzokide,pisua);
		bizilagunak.add(biz);
	}

	public void addErtz(int auzokide) {
		BizilagunaPisuGabe biz= new BizilagunaPisuGabe(auzokide);
		bizilagunak.add(biz);
	}

	public void setPisua( double p) {
		pisua=p;

	}
	@Override
	public int compareTo(Nodo e){
		return Double.compare(e.pisua,pisua);		
	}

}
