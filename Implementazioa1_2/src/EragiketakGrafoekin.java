import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class EragiketakGrafoekin {

	public GrafoEraikitzaileak grafoak;
	public Boolean[] bisitak;
	public Grafo grafo;

	public EragiketakGrafoekin(GrafoEraikitzaileak gf) {
		grafoak = gf;

	}


	///////////////////////////////////////////////////
	//5. Zikloa Du Grafo    Zuzendu Pisugabean       //
	///////////////////////////////////////////////////
	public boolean ZikloaDuG() throws FileNotFoundException, IOException {
		//Grafo zuzendu pisugabea sortu
		//grafoak.SortuGZ();
		//Grafoa lortu
		grafo= grafoak.grafo;

		//N
		int N= grafo.size();

		//Bisitak hasieratu
		bisitak= new Boolean[N];
		Arrays.fill(bisitak, false);



		Set<Integer> bisTabla = new HashSet<>();

		for(int erpina=0; erpina<N; erpina++) {
			if(Sk_ZikloaDuG(grafo,erpina,bisTabla)) {
				return true;
			}
		}
		return false;


	}




	public boolean Sk_ZikloaDuG(Grafo grafoa, int erpina, Set<Integer> bisTabla) {
		if(!bisitak[erpina]) {
			bisitak[erpina]=true;
			bisTabla.add(erpina);
			Iterator<BizilagunaPisuGabe> auzokideak= grafoa.getAuzokide(erpina);
			while(auzokideak.hasNext()) {
				BizilagunaPisuGabe lehena=auzokideak.next();
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

		//grafoak.SortuGEzZ();
		//Grafoa lortu
		grafo= grafoak.grafo;


		//N
		int N= grafo.size();

		//Bisitak hasieratu
		bisitak= new Boolean[N];
		Arrays.fill(bisitak, false);


		for(int erpina=0; erpina<N; erpina++) {
			if(!bisitak[erpina]) {
				if(Sk_ZikloaDuGEzZ(grafo,erpina, -1)) {
					return true;
				}
			}
		}
		return false;


	}

	public boolean Sk_ZikloaDuGEzZ(Grafo grafoa, int erpina, int gurasoa) {

		bisitak[erpina]=true;
		Iterator<BizilagunaPisuGabe> auzokideak= grafoa.getAuzokide(erpina);
		while(auzokideak.hasNext()) {
			BizilagunaPisuGabe lehena=auzokideak.next();
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
		grafo= grafoak.grafo;

		//N
		int N= grafo.size();

		//Bisitak hasieratu
		bisitak= new Boolean[N];
		Arrays.fill(bisitak, false);



		for(int erpina=0; erpina<N; erpina++) {
			if(!bisitak[erpina]) {
				ordenaketaAux(grafo,erpina,pila);
			}
		}

		return pila;
	}

	public void ordenaketaAux(Grafo grafoa, int erpina, Stack<Integer>  pila) {

		bisitak[erpina]=true;
		Iterator<BizilagunaPisuGabe> auzokideak= grafoa.getAuzokide(erpina);
		while(auzokideak.hasNext()) {
			BizilagunaPisuGabe lehena=auzokideak.next();
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
	//	grafoak.SortuGEzZ();
		//Grafoa lortu
		grafo=grafoak.grafo;

		LinkedList<LinkedList<Integer>> osagaiak = new LinkedList<LinkedList<Integer>>();
		//N
		int N= grafo.size();

		//Bisitak hasieratu
		bisitak= new Boolean[N];
		Arrays.fill(bisitak, false);

		for(int erpina=0; erpina<N; erpina++) {
			if(!bisitak[erpina]) {
				LinkedList<Integer> osagai= new LinkedList<Integer>();
				osagaiKonexuakAux(grafo,erpina,osagai);
				osagaiak.add(osagai);
			}
		}
		return osagaiak;

	}

	public void osagaiKonexuakAux(Grafo grafoa, int erpina, LinkedList<Integer> osagaiak) {
		bisitak[erpina]=true;
		Iterator<BizilagunaPisuGabe> auzokideak= grafoa.getAuzokide(erpina);
		osagaiak.add(erpina);

		while(auzokideak.hasNext()) {
			BizilagunaPisuGabe lehena=auzokideak.next();
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
	//	grafoak.SortuGZ();
		//Grafoa lortu
		grafo= grafoak.grafo;	

		//N
		int N= grafo.size();

		//Alderantzizkoa lortu
		Grafo alderantzizkoa=alderantzizkoaSortu(grafo,N);	



		//Bisitak hasieratu
		bisitak= new Boolean[N];
		Arrays.fill(bisitak, false);

		//Ordenaketa amaiera denboraren arabera
		Stack<Integer> pila = new Stack<Integer>();
		for(int erpina=0; erpina<N; erpina++) {
			if(!bisitak[erpina]) {
				beteOrdenean(grafo,erpina,pila);
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

	public void SKaux(Grafo grafoa, int erpina, LinkedList<Integer> osagaiak) {
		bisitak[erpina]=true;
		Iterator<BizilagunaPisuGabe> auzokideak= grafoa.getAuzokide(erpina);
		osagaiak.add(erpina);
		while (auzokideak.hasNext()) {
			BizilagunaPisuGabe lehena=auzokideak.next();
			if(!bisitak[lehena.nora]) {
				SKaux(grafoa,lehena.nora,osagaiak);
			}
		}
	}

	public void auxSKO(Grafo grafoa, int erpina, LinkedList<Integer> osagaiak) {
		bisitak[erpina]=true;
		Iterator<BizilagunaPisuGabe> auzokideak= grafoa.getAuzokide(erpina);
		osagaiak.add(erpina);

		while (auzokideak.hasNext()) {
			BizilagunaPisuGabe lehena=auzokideak.next();
			if(!bisitak[lehena.nora]) {
				osagaiKonexuakAux(grafoa,lehena.nora,osagaiak);
			}
		}
	}




	public void beteOrdenean(Grafo grafoa, int erpina, Stack<Integer> pila) {
		bisitak[erpina]=true;
		Iterator<BizilagunaPisuGabe> auzokideak= grafoa.getAuzokide(erpina);
		while(auzokideak.hasNext()) {
			BizilagunaPisuGabe lehena=auzokideak.next();
			if(!bisitak[lehena.nora]) {
				beteOrdenean(grafoa,lehena.nora,pila);
			}
		}
		pila.push(erpina);

	}


	public Grafo alderantzizkoaSortu( Grafo grafoa, int N){



		ArrayList<BizilagunaPisuGabe> aux;

		//Hasieratu
		Grafo alderantzizkoa= new Grafo(false);
		for (int i = 0; i < N; i++) {

			alderantzizkoa.addErpina(i);
		}

		for(int erpina=0; erpina<N; erpina++) {
			Iterator<BizilagunaPisuGabe> auzokideak= grafoa.getAuzokide(erpina);

			while (auzokideak.hasNext()) {
				BizilagunaPisuGabe lehena=auzokideak.next();

				alderantzizkoa.addErtz(lehena.nora, erpina, 0.0);


			}
		}

		return alderantzizkoa;

	}

}
