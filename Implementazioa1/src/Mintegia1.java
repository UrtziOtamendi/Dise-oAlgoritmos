import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Mintegia1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub





		//Fitxategiak
		String path1 = "mst7n21a.txt";
		String path2 = "mst100n1000a.txt";
		String path3 = "sendokiKonektatutakoOsagaiakGZ8n13a.txt";
		String path4 = "prueba.txt";
		String path = "kruskal"; 

		GrafoEraikitzaileak grafoak = null;
		EragiketakGrafoekin eragiketak;
		Kruskal kruskal;

		Scanner sn = new Scanner(System.in);
		boolean atera = false;
		int aukera;
		int egoera = 1;

		while(!atera) {
			if(egoera == 1) {
				System.out.println("--Fitxategia--");
				System.out.println("1. mst7n21a.txt");
				System.out.println("2. mst100n1000a.txt");
				System.out.println("3. sendokiKonektatutakoOsagaiakGZ8n13a.txt");
				System.out.println("0. Atera");
				System.out.println("Aukeratu bat");
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
				System.out.println("-Grafo Zuzenduekin Eragiketak-");
				System.out.println(" ");
				System.out.println("5. Zikloa du?");
				System.out.println("6. Ordenazio topologikoa");
				System.out.println(" ");
				System.out.println("-Grafo Zuzendugabekin Eragiketak-");
				System.out.println(" ");
				System.out.println("7. Zikloa du?");
				System.out.println("8. Osagai konexuak");
				System.out.println(" ");
				System.out.println("-Ariketa Garatuak-");
				System.out.println(" ");
				System.out.println("9. Grafo Zuzendu baten sendoki konektatutako osagaiak.");
				System.out.println("10. Grafo EZ Zuzendu pisudunean kruskal.");
				System.out.println(" ");
				System.out.println("11. Atzera");
				System.out.println("0. Atera");

				System.out.println(" ");
				System.out.println(" ");

				System.out.println("Aukeratu:");
				System.out.println(" ");
			}



			aukera = sn.nextInt();

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
					grafoak= new GrafoEraikitzaileak(path4);
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
					break;
				case 2:
					grafoak.SortuGEzZ();
					System.out.println(" Grafo Ez Zuzendu Pisugabea ondo sortu da");
					System.out.println("_________________________________________");
					break;
				case 3:
					grafoak.SortuGZPisuduna();
					System.out.println(" Grafo Zuzendu Pisuduna ondo sortu da");
					System.out.println("_____________________________________");

					break;
				case 4:
					grafoak.SortuGEzPisuduna();
					System.out.println(" Grafo Ez Zuzendu Pisuduna ondo sortu da");
					System.out.println("________________________________________");
					break;
				case 5:
					System.out.println( "Zikloa du: " +eragiketak.ZikloaDuG());
					System.out.println("________________________________________");

					break;
				case 6:
					Stack<Integer> pila= eragiketak.ordenaketaTopologikoa();
					int i=1;
					System.out.println("");
					System.out.println(" Ordenaketa Topologiko Lista ");
					System.out.println("______________________________");
					while (pila.empty()==false) {
						System.out.println( "1.- " + pila.pop() );
					}
					System.out.println("________________________________________");

					break;
				case 7:
					System.out.println( "Zikloa du: " +eragiketak.ZikloaDuGEzZ());
					break;
				case 8:
					LinkedList<LinkedList<Integer>> osagaiak= eragiketak.osagaiKonexuak();
					System.out.println("");
					System.out.println("    Osagai Konexkuen Lista   ");
					System.out.println("_____________________________");
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
				case 9:
					LinkedList<LinkedList<Integer>> sendokiOsagaiak= eragiketak.sendokiKonektatutakoOsagaiak();
					System.out.println("");
					System.out.println(" Sendoki konektatutako osagaiak ");
					System.out.println("________________________________");
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
				case 10:
					System.out.println(" ");
					System.out.println("            Kruskal             ");
					System.out.println("________________________________");
					System.out.println("Sartu Fitxategiaren izena:");
					path= sn.next();
					kruskal= new Kruskal(grafoak, path);
					System.out.println("Fitxategia sortu da.");
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
				
				if(egoera!=1 && !atera ) {
					System.out.println("Idatzi 0 irteteko edo beste zerbait jarraitzeko...");
					if(sn.nextInt()==0) atera=true;
				}
				
				
			}




		}
	}

}
