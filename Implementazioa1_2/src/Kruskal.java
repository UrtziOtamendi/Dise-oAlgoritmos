import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Kruskal {


	public GrafoEraikitzaileak grafoak;
	public Grafo grafoa;
	public int N;
	public double pisuBatura;
	public Boolean[] bisitak;
	
	public Kruskal(GrafoEraikitzaileak gf, String izena) throws FileNotFoundException, IOException {
		grafoak = gf;
	//	grafoak.SortuGEzPisuduna();
		grafoa= grafoak.grafo;
		N=grafoa.size();
		pisuBatura=0;
		Grafo HZT= KruskalHZT();
		String name= izena + ".txt";
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name), "utf-8"))) {
			writer.write(HZT.size()+"\n");
			writer.write(pisuBatura+"\n");
			for(int i=0; i<HZT.size(); i++) {
				Iterator<Bizilaguna> aux = HZT.getAuzokide(i);
				while(aux.hasNext()) {
					Bizilaguna biz= aux.next();
					writer.write(i+" "+biz.nora+" "+biz.pisua+"\n");
				}
			}
			
		}
	}
	
	public Grafo  KruskalHZT() {
		int kostua=0;
		Grafo zuhaitza= new Grafo(true);
		Vector<Integer> norena= new Vector<Integer>(N);
		
		for(int i=0; i<N; i++) {
			
			zuhaitza.addErpina(i);
			norena.add(i,i);
			
		}
		
		int erpinA=0;
		int erpinB=0;
		int arkua=1;
		
		while(arkua<N) {
			double min=Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				Iterator<Bizilaguna> auzokide = grafoa.getAuzokide(i);
				while(auzokide.hasNext()) {
					Bizilaguna biz=auzokide.next();
					if((min > biz.pisua) && (norena.get(i) != norena.get(biz.nora)) ) {
						min= biz.pisua;
						
						erpinA=i;
						erpinB=biz.nora;
					}
				}
			}
			
			if(norena.get(erpinA) != norena.get(erpinB)) {
				
				
				zuhaitza.addErtz(erpinA, erpinB, min);
				
				if(min!=Integer.MAX_VALUE) pisuBatura= pisuBatura +min;
				
				int aux= norena.get(erpinB);
				norena.set(erpinB, norena.get(erpinA));
				for(int t=0; t<N; t++) {
					if(norena.get(t) == aux) {
						norena.set(t, norena.get(erpinA));
					}
				}
				
				arkua++;
				
			}
		}
		return zuhaitza;
	}
	
	
	
}
