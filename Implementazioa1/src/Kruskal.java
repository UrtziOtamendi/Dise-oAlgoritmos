import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {


	public GrafoEraikitzaileak grafoak;
	public ArrayList<ArrayList<Bizilaguna>> grafoa;
	public int N;
	public double pisuBatura;
	public Boolean[] bisitak;
	
	public Kruskal(GrafoEraikitzaileak gf, String izena) throws FileNotFoundException, IOException {
		grafoak = gf;
		grafoak.SortuGEzPisuduna();
		grafoa= grafoak.list;
		N=grafoa.size();
		pisuBatura=0;
		ArrayList<ArrayList<Bizilaguna>> HZT= KruskalHZT();
		String name= izena + ".txt";
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name), "utf-8"))) {
			writer.write(HZT.size()+"\n");
			writer.write(pisuBatura+"\n");
			for(int i=0; i<HZT.size(); i++) {
				ArrayList<Bizilaguna> aux = HZT.get(i);
				for(int j=0; j<aux.size(); j++) {
					writer.write(i+" "+aux.get(j).nora+" "+aux.get(j).pisua+"\n");
				}
			}
			
		}
	}
	
	public ArrayList<ArrayList<Bizilaguna>>  KruskalHZT() {
		int kostua=0;
		ArrayList<ArrayList<Bizilaguna>> zuhaitza= new ArrayList<ArrayList<Bizilaguna>>(N);
		ArrayList<Integer> norena= new ArrayList<Integer>(N);
		
		for(int i=0; i<N; i++) {
			
			zuhaitza.add(i, (new ArrayList<Bizilaguna>()));
			norena.add(i,i);
			
		}
		
		int erpinA=0;
		int erpinB=0;
		int arkua=1;
		
		while(arkua<N) {
			double min=Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				
				for(int k=0; k< grafoa.get(i).size(); k++) {
					if((min > grafoa.get(i).get(k).pisua) && (norena.get(i) != norena.get(grafoa.get(i).get(k).nora)) ) {
						min= grafoa.get(i).get(k).pisua;
						
						erpinA=i;
						erpinB=grafoa.get(i).get(k).nora;
					}
				}
			}
			
			if(norena.get(erpinA) != norena.get(erpinB)) {
				
				//ArrayList<Bizilaguna> auxA= zuhaitza.get(erpinA);
				//auxA.add(new Bizilaguna(min,pisua));
				//zuhaitza.set(erpinA, auxA);
				
				ArrayList<Bizilaguna> auxB= zuhaitza.get(erpinA);
				auxB.add(new Bizilaguna(erpinB,min));
				zuhaitza.set(erpinA, auxB);
				
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
