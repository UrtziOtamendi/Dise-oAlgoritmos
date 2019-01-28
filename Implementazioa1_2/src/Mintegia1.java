import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Mintegia1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub




		int GZ=3;
		int GeZ=4;
		int GZP=5;
		int GeZP=6;

		//Fitxategiak
		String path1 = "mst7n21a.txt";
		String path2 = "mst100n1000a.txt";
		String path3 = "sendokiKonektatutakoOsagaiakGZ8n13a.txt";
		String path4 = "prueba.txt";
		String path = "kruskal"; 

		GrafoEraikitzaileak grafoak = null;
		EragiketakGrafoekin eragiketak = null;
		Kruskal kruskal=null;

		Scanner sn = new Scanner(System.in);
		boolean atera = false;
		int aukera;
		int egoera = 1;

		while(!atera) {
			if(egoera == 1) {
				System.out.println("--Fitxategiak--");
				System.out.println("1. mst7n21a.txt");
				System.out.println("2. mst100n1000a.txt");
				System.out.println("3. sendokiKonektatutakoOsagaiakGZ8n13a.txt");
				System.out.println("0. Atera");
				System.out.println("Aukeratu bat");
				 path = sn.nextLine();
			}

			if (egoera == 2) {
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("MENUA");
				System.out.println("----------------------------------------------------------------------------");

				System.out.println(" ");
				System.out.println("-Grafo generadoreak-");
				System.out.println(" ");
				System.out.println("1. Grafo Zuzendua sortu");
				System.out.println("2. Grafo Zuzendugabea sortu");
				System.out.println("3. Grafo Zuzendu Pisuduna sortu");
				System.out.println("4. Grafo Zuzendugabea Pisuduna sortu");
				System.out.println(" ");			
				System.out.println("11. Atzera");
				System.out.println("0. Atera");

				System.out.println(" ");

				System.out.println("Aukeratu:");
				System.out.println(" ");
			}

			if (egoera == GZ) {
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("MENUA");
				System.out.println("----------------------------------------------------------------------------");


				System.out.println("-Grafo Zuzenduekin Eragiketak-");
				System.out.println(" ");
				System.out.println("5. Zikloa du?");
				System.out.println("6. Ordenazio topologikoa");
				System.out.println(" ");
				System.out.println("9. Grafo Zuzendu baten sendoki konektatutako osagaiak.");
				System.out.println(" ");
				System.out.println("11. Atzera");
				System.out.println("0. Atera");

				System.out.println(" ");

				System.out.println("Aukeratu:");
				System.out.println(" ");
			}
			
			if (egoera == GeZ) {
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("MENUA");
				System.out.println("----------------------------------------------------------------------------");


				System.out.println("-Grafo Zuzendugabeekin Eragiketak-");
				System.out.println(" ");
				System.out.println("7. Zikloa du?");
				System.out.println("8. OsagaiKonexuak");
				System.out.println(" ");
				System.out.println(" ");
				System.out.println("11. Atzera");
				System.out.println("0. Atera");

				System.out.println(" ");

				System.out.println("Aukeratu:");
				System.out.println(" ");
			}

			if (egoera == GeZP) {
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("MENUA");
				System.out.println("----------------------------------------------------------------------------");

				System.out.println(" ");

				System.out.println("10. Grafo EZ Zuzendu pisudunean kruskal.");
				System.out.println(" ");
				System.out.println("12. Dijkstra lehentasun-ilara erabiliz. M3 C4.");
				
				System.out.println("11. Atzera");
				System.out.println("0. Atera");

				System.out.println(" ");

				System.out.println("Aukeratu:");
				System.out.println(" ");
			}

			if (egoera == GZP) {
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("MENUA");
				System.out.println("----------------------------------------------------------------------------");

				


				System.out.println(" ");
				System.out.println("11. Atzera");
				System.out.println("0. Atera");
				System.out.println(" ");
				System.out.println("Aukeratu:");
				System.out.println(" ");
			}

			
			aukera= sn.nextInt();

			if (egoera==1) {

				switch (aukera) {
				case 1:
					grafoak= new GrafoEraikitzaileak(path1);

					egoera = 2;
					break;
				case 2:
					grafoak= new GrafoEraikitzaileak(path2);
					egoera = 2;
					break;
				case 3:
					grafoak= new GrafoEraikitzaileak(path3);
					egoera = 2;
					break;	
				case 4:
					grafoak= new GrafoEraikitzaileak(path);
					egoera = 2;
					break;
				case 0: 
					atera = true;
					break;

				default:
					System.out.println("!!!!!!!!!!!!!!!!!");
					System.out.println("! Aukera Okerra !");
					System.out.println("!!!!!!!!!!!!!!!!!");
					break;
				}
			}

			else if(egoera==2) {

				eragiketak= new EragiketakGrafoekin(grafoak);
				switch (aukera) {
				case 1:
					grafoak.SortuGZ();
					System.out.println(" Grafo Zuzendu Pisugabea ondo sortu da");
					System.out.println("______________________________________");
					egoera=GZ;
					break;
				case 2:
					grafoak.SortuGEzZ();
					System.out.println(" Grafo Ez Zuzendu Pisugabea ondo sortu da");
					System.out.println("_________________________________________");
					egoera=GeZ;
					break;
				case 3:
					grafoak.SortuGZPisuduna();
					System.out.println(" Grafo Zuzendu Pisuduna ondo sortu da");
					System.out.println("_____________________________________");
					egoera=GZP;

					break;
				case 4:
					grafoak.SortuGEzPisuduna();
					System.out.println(" Grafo Ez Zuzendu Pisuduna ondo sortu da");
					System.out.println("________________________________________");
					egoera=GeZP;
					break;
				case 11:
					egoera = 1;
					break;
				case 0:
					atera=true;
					break;						

				default:
					System.out.println("!!!!!!!!!!!!!!!!!");
					System.out.println("! Aukera Okerra !");
					System.out.println("!!!!!!!!!!!!!!!!!");
					break;
				}

				
			}
			else if(egoera==GZ) {
				switch (aukera) {
				case 5:
					System.out.println( "Zikloa du: " +eragiketak.ZikloaDuG());
					System.out.println("________________________________________");

					break;
				case 6:

					int i=1;
					System.out.println("");
					System.out.println(" Ordenaketa Topologiko Lista ");
					System.out.println("______________________________");
					Stack<Integer> pila= eragiketak.ordenaketaTopologikoa();
					while (pila.empty()==false) {
						System.out.println( "1.- " + pila.pop() );
					}
					System.out.println("________________________________________");

					break;

				case 9:
					System.out.println("");
					System.out.println(" Sendoki konektatutako osagaiak ");
					System.out.println("________________________________");

					LinkedList<LinkedList<Integer>> sendokiOsagaiak= eragiketak.sendokiKonektatutakoOsagaiak();
					Iterator<LinkedList<Integer>> sendokiIt= sendokiOsagaiak.iterator();
					while(sendokiIt.hasNext()) {
						LinkedList<Integer> sendokiAux= sendokiIt.next();
						System.out.print("---> ");
						Iterator<Integer> it2= sendokiAux.iterator();
						while(it2.hasNext()) {
							System.out.print(" "+ it2.next());

						}
						System.out.println(".");
					}
					break;
				case 11:
					egoera = 2;
					break;
				case 0:
					atera=true;
					break;						

				default:
					System.out.println("!!!!!!!!!!!!!!!!!");
					System.out.println("! Aukera Okerra !");
					System.out.println("!!!!!!!!!!!!!!!!!");
					break;
				}

				if(egoera!=2 && !atera ) {
					System.out.println("Idatzi 0 irteteko edo beste zerbait jarraitzeko...");
					if(sn.nextInt()==0) atera=true;
				}


			}
			else if(egoera==GeZ) {
				switch (aukera) {
				case 7:
					System.out.println( "Zikloa du: " +eragiketak.ZikloaDuGEzZ());
					break;
				case 8:

					System.out.println("");
					System.out.println("    Osagai Konexkuen Lista   ");
					System.out.println("_____________________________");
					LinkedList<LinkedList<Integer>> osagaiak= eragiketak.osagaiKonexuak();
					Iterator<LinkedList<Integer>> osagaiIt= osagaiak.iterator();
					while(osagaiIt.hasNext()) {
						LinkedList<Integer> aux= osagaiIt.next();
						System.out.print("---> ");
						Iterator<Integer> it= aux.iterator();
						while(it.hasNext()) {
							System.out.print(" "+ it.next());

						}
						System.out.println(".");

					}
					break;
				case 11:
					egoera = 2;
					break;
				case 0:
					atera=true;
					break;						

				default:
					System.out.println("!!!!!!!!!!!!!!!!!");
					System.out.println("! Aukera Okerra !");
					System.out.println("!!!!!!!!!!!!!!!!!");
					break;
				}

				if(egoera!=2 && !atera ) {
					System.out.println("Idatzi 0 irteteko edo beste zerbait jarraitzeko...");
					if(sn.nextInt()==0) atera=true;
				}



			}
			else if(egoera==GZP) {
				switch (aukera) {

				
					
				case 11:
					egoera = 2;
					break;
				case 0:
					atera=true;
					break;						

				default:
					System.out.println("!!!!!!!!!!!!!!!!!");
					System.out.println("! Aukera Okerra !");
					System.out.println("!!!!!!!!!!!!!!!!!");
					break;
				}

				if(egoera!=2 && !atera ) {
					System.out.println("Idatzi 0 irteteko edo beste zerbait, jarraitzeko...");
					if(sn.nextInt()==0) atera=true;
				}


			}
			else if(egoera==GeZP) {
				switch (aukera) {
				case 10:
					System.out.println(" ");
					System.out.println("            Kruskal             ");
					System.out.println("________________________________");
					System.out.println("Sartu Fitxategiaren izena:");
					path= sn.next();
					kruskal= new Kruskal(grafoak, path);
					System.out.println("Fitxategia sortu da.");
					break;
				case 12:
					System.out.println("");
					System.out.println("    Dijkstra Meta erabiliz   ");
					System.out.println("_____________________________");
					
					Grafo g= new Grafo(grafoak.grafo);
					Dijkstra obj = new Dijkstra(g,g.size());
				
					ArrayList<LinkedList<Nodo>> bideak =obj.calculate(g.getErpina(0));	

					
					Iterator<LinkedList<Nodo>> bideakIt= bideak.iterator();
					int e=0;
					while(bideakIt.hasNext() && e<g.size()) {
						LinkedList<Nodo> bidea= bideakIt.next();
						System.out.print("Erpina - "+e+" , Distantzia - "+ g.getErpina(e).pisua+" , Bidea - ");
						Iterator<Nodo> bideaIt= bidea.iterator();
						while(bideaIt.hasNext()) {
							System.out.print(bideaIt.next().ID+" ");

						}
						System.out.println(""+e);
						e++;
					}

					break;
				case 13:
					System.out.println("");
					System.out.println("    Dijkstra Meta erabiliz   ");
					System.out.println("_____________________________");
					
					Grafo g1= new Grafo(grafoak.grafo);
					Dijkstra_Min Dijkstra_Min = new Dijkstra_Min(g1);
				
					Distantzia[] dist =Dijkstra_Min.kalkulatu();	

					for(int i=0; i<dist.length; i++) {
						System.out.print("Erpina - "+ dist[i].ID+" , Distantzia - "+ dist[i].distantzia);
						System.out.println("");
					}
					

					break;
				case 11:
					egoera = 2;
					break;
				case 0:
					atera=true;
					break;						

				default:
					System.out.println("!!!!!!!!!!!!!!!!!");
					System.out.println("! Aukera Okerra !");
					System.out.println("!!!!!!!!!!!!!!!!!");
					break;
				}

				if(egoera!=2 && !atera ) {
					System.out.println("Idatzi 0 irteteko edo beste zerbait jarraitzeko...");
					if(sn.nextInt()==0) atera=true;
				}

			}
		}




	}
}


