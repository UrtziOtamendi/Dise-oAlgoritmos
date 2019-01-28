package Domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FitxategiaIrakurri {

	public File file;
	public FileReader fReader;
	public BufferedReader bReader;
	public String fileName;
	public Bidaia bidaia;
	public int N,P,T=-1;
	
	public FitxategiaIrakurri(String filename) {
		fileName = filename;
		file = null;
		fReader = null;
		bReader = null;
		
	
	}
	
	public FitxategiaIrakurri(String filename, int n, int p, int t) {
		fileName = filename;
		file = null;
		fReader = null;
		bReader = null;
		P=p;
		T=t;
		N=n;
	
	}

	public Bidaia sortuBidaia() throws FileNotFoundException, IOException {
		try {

			
			
			file = new File (fileName);
			fReader = new FileReader (file);
			bReader = new BufferedReader(fReader);

			//Irakurriko den informazioa gordetzeko parametroak
			
			String lerro;
			
			lerro=bReader.readLine();
		
			String[] split  = lerro.split(" ");
			
			//Lehen hiru balioak
			if(P==-1)
				P=Integer.parseInt(split[0]);
			if(T==-1)
				T=Integer.parseInt(split[1]);
			if(N==-1)
				N=Integer.parseInt(split[2]);

			BidaiariLista lista = new BidaiariLista(); 
			
			

			for (int i = 1; i <= N; i++) {

				//Sortu bizilaguna
				lerro = bReader.readLine();
				String[] bidSplit  = lerro.split(" ");
				double dirua = Integer.parseInt(bidSplit[0]);
				int pisua = Integer.parseInt(bidSplit[1]);
				
				Bidaiaria bid= new Bidaiaria(i,dirua,pisua);
				lista.addBidaiari(bid);
			}
			
			bidaia= new Bidaia(P,T,N,lista);
			return bidaia;

		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{                    
				if( null != fReader ){   
					fReader.close();     
				}                  
			}catch (Exception e2){ 
				e2.printStackTrace();
			}
		}
		return bidaia;

	}
	
	
	
	
	
	
	
	
	

}
