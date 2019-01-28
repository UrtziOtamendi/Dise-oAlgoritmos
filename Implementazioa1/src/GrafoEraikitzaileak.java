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
	public ArrayList<ArrayList<Bizilaguna>> list;
	public ArrayList<ArrayList<BizilagunaPisuGabe>> list_pisu_gabe;
	
	public GrafoEraikitzaileak(String filename) {
		fileName = filename;
		file = null;
		fReader = null;
		bReader = null;
		list = new ArrayList<ArrayList<Bizilaguna>>();
		list_pisu_gabe = new ArrayList<ArrayList<BizilagunaPisuGabe>>();
	}

	public void SortuGZ() throws FileNotFoundException, IOException {
		try {
			list_pisu_gabe = new ArrayList<ArrayList<BizilagunaPisuGabe>>();
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
				
				list_pisu_gabe.add(i,  new ArrayList<BizilagunaPisuGabe>());
			}


			ArrayList<BizilagunaPisuGabe> bizilagunak;
			BizilagunaPisuGabe bizilagun;
			for (int n = 0; n < arkuak; n++) {

				//Sortu bizilaguna
				lerro = bReader.readLine();
				String[] split  = lerro.split(" ");
				nondik = Integer.parseInt(split[0]);
				nora = Integer.parseInt(split[1]);
				bizilagun = new BizilagunaPisuGabe(nora);
				
				//Erpinaren bizilagunak hartu
				bizilagunak = list_pisu_gabe.get(nondik);
				
				//Gorde listan
				
				bizilagunak.add(bizilagun);				
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
			list_pisu_gabe = new ArrayList<ArrayList<BizilagunaPisuGabe>>();
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
				
				list_pisu_gabe.add(i,  new ArrayList<BizilagunaPisuGabe>());
			}


			ArrayList<BizilagunaPisuGabe> bizilagunak1;
			ArrayList<BizilagunaPisuGabe> bizilagunak2;
			BizilagunaPisuGabe bizilagun1;
			BizilagunaPisuGabe bizilagun2;
			for (int n = 0; n < arkuak; n++) {

				//Sortu bizilaguna
				lerro = bReader.readLine();
				String[] split  = lerro.split(" ");
				nondik = Integer.parseInt(split[0]);
				nora = Integer.parseInt(split[1]);
				
				//Lotura Bat
				bizilagun1 = new BizilagunaPisuGabe(nora);
				bizilagunak1 = list_pisu_gabe.get(nondik);
				bizilagunak1.add(bizilagun1);	
				
				//Lotura Bi
				bizilagun2 = new BizilagunaPisuGabe(nondik);
				bizilagunak2 = list_pisu_gabe.get(nora);
				bizilagunak2.add(bizilagun2);	
				
				
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
			list = new ArrayList<ArrayList<Bizilaguna>>();
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
				
				list.add(i,  new ArrayList<Bizilaguna>());
			}


			ArrayList<Bizilaguna> bizilagunak;
			Bizilaguna bizilagun;
			for (int n = 0; n < arkuak; n++) {

				//Sortu bizilaguna
				lerro = bReader.readLine();
				String[] split  = lerro.split(" ");
				nondik = Integer.parseInt(split[0]);
				nora = Integer.parseInt(split[1]);
				pisua= Double.parseDouble(split[2]);
				bizilagun = new Bizilaguna(nora,pisua);
				
				//Erpinaren bizilagunak hartu
				bizilagunak = list.get(nondik);
				
				//Gorde listan
				
				bizilagunak.add(bizilagun);				
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
			list = new ArrayList<ArrayList<Bizilaguna>>();
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
				
				list.add(i,  new ArrayList<Bizilaguna>());
			}


			ArrayList<Bizilaguna> bizilagunak1;
			ArrayList<Bizilaguna> bizilagunak2;
			Bizilaguna bizilagun1;
			Bizilaguna bizilagun2;
			for (int n = 0; n < arkuak; n++) {

				//Sortu bizilaguna
				lerro = bReader.readLine();
				String[] split  = lerro.split(" ");
				nondik = Integer.parseInt(split[0]);
				nora = Integer.parseInt(split[1]);
				pisua = Double.parseDouble(split[2]);
				//Lotura Bat
				bizilagun1 = new Bizilaguna(nora,pisua);
				bizilagunak1 = list.get(nondik);
				bizilagunak1.add(bizilagun1);	
				
				//Lotura Bi
				bizilagun2 = new Bizilaguna(nondik,pisua);
				bizilagunak2 = list.get(nora);
				bizilagunak2.add(bizilagun2);	
				
				
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
