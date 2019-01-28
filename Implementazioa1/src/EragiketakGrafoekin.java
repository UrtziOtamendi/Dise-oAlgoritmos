import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class EragiketakGrafoekin {

	public GrafoEraikitzaileak grafoak;
	public Boolean[] bisitak;
	
	public EragiketakGrafoekin(GrafoEraikitzaileak gf) {
		grafoak = gf;

	}


	///////////////////////////////////////////////////
	//5. Zikloa Du Grafo    Zuzendu Pisugabean       //
	///////////////////////////////////////////////////
	public boolean ZikloaDuG() throws FileNotFoundException, IOException {
		//Grafo zuzendu pisugabea sortu
		grafoak.SortuGZ();
		//Grafoa lortu
		ArrayList<ArrayList<BizilagunaPisuGabe>> list=grafoak.list_pisu_gabe;

		//N
		int N= list.size();

		//Bisitak hasieratu
		bisitak= new Boolean[N];
		Arrays.fill(bisitak, false);



		Set<Integer> bisTabla = new HashSet<>();

		for(int erpina=0; erpina<N; erpina++) {
			if(Sk_ZikloaDuG(list,erpina,bisTabla)) {
				return true;
			}
		}
		return false;


	}




	public boolean Sk_ZikloaDuG(ArrayList<ArrayList<BizilagunaPisuGabe>> grafoa, int erpina, Set<Integer> bisTabla) {
		if(!bisitak[erpina]) {
			bisitak[erpina]=true;
			bisTabla.add(erpina);
			ArrayList<BizilagunaPisuGabe> auzokideak= grafoa.get(erpina);
			for(int i=0; i<auzokideak.size(); i++) {
				BizilagunaPisuGabe lehena=auzokideak.get(i);
				if(!bisitak[lehena.nora]) {	
					if (Sk_ZikloaDuG(grafoa, lehena.nora, bisTabla))
						return true;
				}
				else if(bisTabla.contains(lehena.nora))
					return true;

			}

		}
		bisTabla.remove(erpina);
		return false;

	}


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	///////////////////////////////////////////////////
	//7. Zikloa Du Grafo Ez Zuzendu Pisugabean       //
	///////////////////////////////////////////////////
	public boolean ZikloaDuGEzZ() throws FileNotFoundException, IOException {
		//Grafo ez zuzendu pisugabea sortu

		grafoak.SortuGEzZ();
		//Grafoa lortu
		ArrayList<ArrayList<BizilagunaPisuGabe>> list=grafoak.list_pisu_gabe;

		//N
		int N= list.size();

		//Bisitak hasieratu
		bisitak= new Boolean[N];
		Arrays.fill(bisitak, false);


		for(int erpina=0; erpina<N; erpina++) {
			if(!bisitak[erpina]) {
				if(Sk_ZikloaDuGEzZ(list,erpina, -1)) {
					return true;
				}
			}
		}
		return false;


	}

	public boolean Sk_ZikloaDuGEzZ(ArrayList<ArrayList<BizilagunaPisuGabe>> grafoa, int erpina, int gurasoa) {

		bisitak[erpina]=true;
		ArrayList<BizilagunaPisuGabe> auzokideak= grafoa.get(erpina);
		for(int i=0; i<auzokideak.size(); i++) {
			BizilagunaPisuGabe lehena=auzokideak.get(i);
			if(!bisitak[lehena.nora]) {
				if( Sk_ZikloaDuGEzZ(grafoa, lehena.nora, erpina)) 
					return true;
			}
			else if(gurasoa != lehena.nora)
				return true;


		}
		return false;

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	///////////////////////////////////////////////////
	//6. Ordenazio Topologikoa Grafo Zuzendu Pisugabe//
	///////////////////////////////////////////////////
	public Stack<Integer> ordenaketaTopologikoa() throws FileNotFoundException, IOException {
		//Pila sortu		
		Stack<Integer> pila = new Stack<Integer>();

		//Grafoa sortu eta zikloa duen aztertu
		if(ZikloaDuG()) {
			System.out.println("Grafoa ziklikoa da, beraz ezin da ordenaketa topologikoa egin.");
			return pila;
		}


		//Grafoa lortu
		ArrayList<ArrayList<BizilagunaPisuGabe>> list=grafoak.list_pisu_gabe;	

		//N
		int N= list.size();

		//Bisitak hasieratu
		bisitak= new Boolean[N];
		Arrays.fill(bisitak, false);



		for(int erpina=0; erpina<N; erpina++) {
			if(!bisitak[erpina]) {
				ordenaketaAux(list,erpina,pila);
			}
		}

		return pila;
	}

	public void ordenaketaAux(ArrayList<ArrayList<BizilagunaPisuGabe>> grafoa, int erpina, Stack<Integer>  pila) {

		bisitak[erpina]=true;
		ArrayList<BizilagunaPisuGabe> auzokideak= grafoa.get(erpina);
		for(int i=0; i<auzokideak.size(); i++) {
			BizilagunaPisuGabe lehena=auzokideak.get(i);
			if(!bisitak[lehena.nora]) {
				ordenaketaAux(grafoa,lehena.nora,pila);
			}
		}
		pila.push(erpina);

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	///////////////////////////////////////////////////
	//8. Osagai Konexuak Grafo Ez Zuzenduarekin      //
	///////////////////////////////////////////////////

	public LinkedList<LinkedList<Integer>> osagaiKonexuak() throws FileNotFoundException, IOException {

		//Grafo Ez zuzendu pisugabea sortu
		grafoak.SortuGEzZ();
		//Grafoa lortu
		ArrayList<ArrayList<BizilagunaPisuGabe>> list=grafoak.list_pisu_gabe;	

		LinkedList<LinkedList<Integer>> osagaiak = new LinkedList<LinkedList<Integer>>();
		//N
		int N= list.size();

		//Bisitak hasieratu
		bisitak= new Boolean[N];
		Arrays.fill(bisitak, false);

		for(int erpina=0; erpina<N; erpina++) {
			if(!bisitak[erpina]) {
				LinkedList<Integer> osagai= new LinkedList<Integer>();
				osagaiKonexuakAux(list,erpina,osagai);
				osagaiak.add(osagai);
			}
		}
		return osagaiak;

	}

	public void osagaiKonexuakAux(ArrayList<ArrayList<BizilagunaPisuGabe>> grafoa, int erpina, LinkedList<Integer> osagaiak) {
		bisitak[erpina]=true;
		ArrayList<BizilagunaPisuGabe> auzokideak= grafoa.get(erpina);
		osagaiak.add(erpina);

		for(int i=0; i<auzokideak.size(); i++) {
			BizilagunaPisuGabe lehena=auzokideak.get(i);
			if(!bisitak[lehena.nora]) {
				osagaiKonexuakAux(grafoa,lehena.nora,osagaiak);
			}
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	//////////////////////////////////////////////////////
	//9. Sendoki Konektatutako Osagaiak Grafo Zuzendua  //
	//////////////////////////////////////////////////////

	public LinkedList<LinkedList<Integer>> sendokiKonektatutakoOsagaiak() throws FileNotFoundException, IOException {

		//Itzuli Behar dena
		LinkedList<LinkedList<Integer>> osagaiak = new LinkedList<LinkedList<Integer>>();


		//Grafo  zuzendu pisugabea sortu
		grafoak.SortuGZ();
		//Grafoa lortu
		ArrayList<ArrayList<BizilagunaPisuGabe>> list=grafoak.list_pisu_gabe;	

		//N
		int N= list.size();

		//Alderantzizkoa lortu
		ArrayList<ArrayList<BizilagunaPisuGabe>> alderantzizkoa=alderantzizkoaSortu(list,N);	



		//Bisitak hasieratu
		bisitak= new Boolean[N];
		Arrays.fill(bisitak, false);

		//Ordenaketa amaiera denboraren arabera
		Stack<Integer> pila = new Stack<Integer>();
		for(int erpina=0; erpina<N; erpina++) {
			if(!bisitak[erpina]) {
				beteOrdenean(list,erpina,pila);
			}
		}
		
		//Bisitak berriz hasieratu
		Arrays.fill(bisitak, false);
		
		
		 while (pila.empty()==false) {
			int erpina=pila.pop();
			if(!bisitak[erpina]) {
				LinkedList<Integer> osagai= new LinkedList<Integer>();
				SKaux(alderantzizkoa,erpina,osagai);
				osagaiak.add(osagai);
			}
		 }

		
		return osagaiak;

	}

	public void SKaux(ArrayList<ArrayList<BizilagunaPisuGabe>> grafoa, int erpina, LinkedList<Integer> osagaiak) {
		bisitak[erpina]=true;
		ArrayList<BizilagunaPisuGabe> auzokideak= grafoa.get(erpina);
		osagaiak.add(erpina);

		for(int i=0; i<auzokideak.size(); i++) {
			BizilagunaPisuGabe lehena=auzokideak.get(i);
			if(!bisitak[lehena.nora]) {
				SKaux(grafoa,lehena.nora,osagaiak);
			}
		}
	}

	public void auxSKO(ArrayList<ArrayList<BizilagunaPisuGabe>> grafoa, int erpina, LinkedList<Integer> osagaiak) {
		bisitak[erpina]=true;
		ArrayList<BizilagunaPisuGabe> auzokideak= grafoa.get(erpina);
		osagaiak.add(erpina);

		for(int i=0; i<auzokideak.size(); i++) {
			BizilagunaPisuGabe lehena=auzokideak.get(i);
			if(!bisitak[lehena.nora]) {
				osagaiKonexuakAux(grafoa,lehena.nora,osagaiak);
			}
		}
	}




	public void beteOrdenean( ArrayList<ArrayList<BizilagunaPisuGabe>> grafoa, int erpina, Stack<Integer> pila) {
		bisitak[erpina]=true;
		ArrayList<BizilagunaPisuGabe> auzokideak= grafoa.get(erpina);
		for(int i=0; i<auzokideak.size(); i++) {
			BizilagunaPisuGabe lehena=auzokideak.get(i);
			if(!bisitak[lehena.nora]) {
				beteOrdenean(grafoa,lehena.nora,pila);
			}
		}
		pila.push(erpina);

	}


	public ArrayList<ArrayList<BizilagunaPisuGabe>> alderantzizkoaSortu( ArrayList<ArrayList<BizilagunaPisuGabe>> grafoa, int N){

		ArrayList<BizilagunaPisuGabe> aux;
		//Hasieratu
		ArrayList<ArrayList<BizilagunaPisuGabe>> alderantzizkoa= new  ArrayList<ArrayList<BizilagunaPisuGabe>>();
		for (int i = 0; i < N; i++) {

			alderantzizkoa.add(new ArrayList<BizilagunaPisuGabe>());
		}

		for(int erpina=0; erpina<N; erpina++) {
			ArrayList<BizilagunaPisuGabe> auzokideak= grafoa.get(erpina);
			BizilagunaPisuGabe berria=new BizilagunaPisuGabe(erpina);
			for(int i=0; i<auzokideak.size(); i++) {
				BizilagunaPisuGabe lehena=auzokideak.get(i);

				aux= alderantzizkoa.get(lehena.nora);
				aux.add(berria);
				alderantzizkoa.set(lehena.nora, aux );

			}
		}

		return alderantzizkoa;

	}

}
