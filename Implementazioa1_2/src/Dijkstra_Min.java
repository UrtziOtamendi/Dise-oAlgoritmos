



import java.util.InputMismatchException;
import java.util.Set;

import java.util.Iterator;
import java.util.LinkedList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.PriorityQueue;





public class Dijkstra_Min

{

    private Grafo grafo;

    private Distantzia[] distantziak;
    
    public  Dijkstra_Min(Grafo grafo)

    {
    	
        
        this.grafo =grafo;
        
        
        // Distantzia lista sortu, defektuz distantzia infinitu izango da. Hau da, balio maximoa.
        
        distantziak= new Distantzia[grafo.erpinak.size()];
        for(int i=0; i<distantziak.length; i++) {
        	distantziak[i]=new Distantzia(i);
        }
        

    }

  
    public Distantzia[] kalkulatu(){
		
    	 Nodo jatorria= grafo.getErpina(0);
		 PriorityQueue<Distantzia>   lehentasunIlara = new PriorityQueue<Distantzia>();
		 
		 //Jatorriaren distantzia 0.
		 distantziak[jatorria.ID].setPisua(0);
		 Iterator<Bizilaguna> auzokideak= jatorria.bizilagunak.iterator();
		 
		 //Jatorriaren auzokideen balioa gorde
		 while(!auzokideak.hasNext()) {
			 Bizilaguna auzokide= auzokideak.next();
			 distantziak[auzokide.nora].setPisua(auzokide.pisua);
		 }
		 
		 //Metan elementu guztiak sartu
		 for(int i=0; i<distantziak.length; i++) {
			 lehentasunIlara.add(distantziak[i]);
	      }
		 
		
		 
		
		//Hutsa ez dagoen bitartean
		while(!lehentasunIlara.isEmpty()){
			
			
			//Distantzia txikiena duena hartu eta ezabatu
			Distantzia aux = lehentasunIlara.poll();
			
			auzokideak= grafo.getAuzokide(aux.ID);
			 
			while(auzokideak.hasNext()) {
				Bizilaguna auzokide= auzokideak.next();
				
				Double pisuBerria = aux.distantzia+auzokide.pisua;
				
				if(distantziak[auzokide.nora].getPisua()>pisuBerria){
					
				
					lehentasunIlara.remove(distantziak[auzokide.nora]);
					distantziak[auzokide.nora].setPisua(pisuBerria);
					lehentasunIlara.add(distantziak[auzokide.nora]);		
					
								
				}
			}
		}
		
		return distantziak;
	}

	

}

