



import java.util.InputMismatchException;
import java.util.Set;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;



 

public class Dijkstra

{

    private int distantzia[];
    private ArrayList<LinkedList<Nodo>> bideak;
  	private int N;

    private Grafo grafo;

 

    public  Dijkstra(Grafo grafo, int n)

    {

        this.N = n;

        distantzia = new int[N + 1];

        LinkedList<Nodo> aux= new LinkedList<Nodo>();
        bideak = new ArrayList<LinkedList<Nodo>>(N);
        for(int i=0; i<N; i++)
        	bideak.add(aux);
        		


        this.grafo =grafo;

    }

 


   

    public ArrayList<LinkedList<Nodo>> calculate(Nodo erpina){
		
		erpina.pisua = 0;
		 PriorityQueue<Nodo>   lehentasunIlara = new PriorityQueue<Nodo>();
		lehentasunIlara.add(erpina);
		
		while(!lehentasunIlara.isEmpty()){
			
			Nodo aux = lehentasunIlara.poll();
		
			Iterator<Bizilaguna> auzokideak= aux.bizilagunak.iterator();
			while(auzokideak.hasNext()) {
				Bizilaguna auzokide= auzokideak.next();
				
				Double pisuBerria = aux.pisua+auzokide.pisua;
				Nodo erpinAux= grafo.getErpina(auzokide.nora);
						
				if(erpinAux.pisua>pisuBerria){
					
					lehentasunIlara.remove(erpinAux);
					erpinAux.pisua = pisuBerria;
					
					
					LinkedList<Nodo> bideBerria= new LinkedList<Nodo>(bideak.get(aux.ID));
					bideBerria.add(aux);
					bideak.add(erpinAux.ID, bideBerria);
					
					
					lehentasunIlara.add(erpinAux);					
				}
			}
		}
		
		return bideak;
	}

	

}
