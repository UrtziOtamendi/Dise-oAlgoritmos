import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GrafoEraikitzaileak {

	public File file;
	public FileReader fReader;
	public BufferedReader bReader;
	public String fileName;
	public Grafo grafo;
	
	public GrafoEraikitzaileak(String filename) {
		fileName = filename;
		file = null;
		fReader = null;
		bReader = null;
	
	}

	public void SortuGZ() throws FileNotFoundException, IOException {
		try {
			grafo= new Grafo(false);
			//Irakurleak
			
			file = new File (fileName);
			fReader = new FileReader (file);
			bReader = new BufferedReader(fReader);

			//Irakurriko den informazioa gordetzeko parametroak
			String lerro;
			String erpinKop;
			String arkuKop;
			
			int nondik;
			int nora;
		
			
			

			erpinKop = bReader.readLine();
			arkuKop = bReader.readLine();
			
			int erpinak = Integer.parseInt(erpinKop); 
			int arkuak = Integer.parseInt(arkuKop);

			for (int i = 0; i < erpinak; i++) {
				
				grafo.addErpina(i);
				
			}

			for (int n = 0; n < arkuak; n++) {

				//Sortu bizilaguna
				lerro = bReader.readLine();
				String[] split  = lerro.split(" ");
				nondik = Integer.parseInt(split[0]);
				nora = Integer.parseInt(split[1]);
				
				grafo.addErtz(nondik, nora, 0.0);
						
			}

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

	}
	
	
	public void SortuGEzZ() throws FileNotFoundException, IOException {
		try {
			grafo= new Grafo(false);
			//Irakurleak
			
			file = new File (fileName);
			fReader = new FileReader (file);
			bReader = new BufferedReader(fReader);

			//Irakurriko den informazioa gordetzeko parametroak
			String lerro;
			String erpinKop;
			String arkuKop;
			
			int nondik;
			int nora;
		
			
			

			erpinKop = bReader.readLine();
			arkuKop = bReader.readLine();
			
			int erpinak = Integer.parseInt(erpinKop); 
			int arkuak = Integer.parseInt(arkuKop);

			for (int i = 0; i < erpinak; i++) {
				
				grafo.addErpina(i);
				
			}

			for (int n = 0; n < arkuak; n++) {

				//Sortu bizilaguna
				lerro = bReader.readLine();
				String[] split  = lerro.split(" ");
				nondik = Integer.parseInt(split[0]);
				nora = Integer.parseInt(split[1]);
				
				grafo.addErtz(nondik, nora, 0.0);
				grafo.addErtz(nora, nondik, 0.0);		
			}

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

	}
	
	
	public void SortuGZPisuduna() throws FileNotFoundException, IOException {
		try {
			grafo= new Grafo(true);
			//Irakurleak
			
			file = new File (fileName);
			fReader = new FileReader (file);
			bReader = new BufferedReader(fReader);

			//Irakurriko den informazioa gordetzeko parametroak
			String lerro;
			String erpinKop;
			String arkuKop;
			
			int nondik;
			int nora;
			double pisua;
			
			

			erpinKop = bReader.readLine();
			arkuKop = bReader.readLine();
			
			int erpinak = Integer.parseInt(erpinKop); 
			int arkuak = Integer.parseInt(arkuKop);

			for (int i = 0; i < erpinak; i++) {
				
				grafo.addErpina(i);
				
			}

			for (int n = 0; n < arkuak; n++) {

				
				lerro = bReader.readLine();
				String[] split  = lerro.split(" ");
				nondik = Integer.parseInt(split[0]);
				nora = Integer.parseInt(split[1]);
				pisua = Double.parseDouble(split[2]);
				
				grafo.addErtz(nondik, nora, pisua);
						
			}

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

	}
	
	public void SortuGEzPisuduna() throws FileNotFoundException, IOException {
		try {
			grafo= new Grafo(true);
			//Irakurleak
			
			file = new File (fileName);
			fReader = new FileReader (file);
			bReader = new BufferedReader(fReader);

			//Irakurriko den informazioa gordetzeko parametroak
			String lerro;
			String erpinKop;
			String arkuKop;
			
			int nondik;
			int nora;
			double pisua;
			
			

			erpinKop = bReader.readLine();
			arkuKop = bReader.readLine();
			
			int erpinak = Integer.parseInt(erpinKop); 
			int arkuak = Integer.parseInt(arkuKop);

			for (int i = 0; i < erpinak; i++) {
				
				grafo.addErpina(i);
				
			}

			for (int n = 0; n < arkuak; n++) {

				
				lerro = bReader.readLine();
				String[] split  = lerro.split(" ");
				nondik = Integer.parseInt(split[0]);
				nora = Integer.parseInt(split[1]);
				pisua = Double.parseDouble(split[2]);
				
				grafo.addErtz(nondik, nora, pisua);
				grafo.addErtz(nora, nondik, pisua);
						
			}

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

	}
}
