package Dinamikoa;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

import Domain.Bidaia;
import Domain.BidaiariLista;
import Domain.Bidaiaria;

public class Optimoa {

	public Bidaia bidaia;
	public double dirua;
	public BidaiariLista bidaiariak;
	public int N;
	public int P;
	public int T;
	public double[][][] M ;
	public double[][][] ME ;
	public Optimoa( Bidaia bidai) {
		bidaia= bidai;
		bidaiariak= new BidaiariLista();
		dirua=0.0;
		N=bidaia.getN();
		P=bidaia.getP();
		T=bidaia.getT();
		//Matrizea [0...T][0...N][0...P] -> Baina N=0 eta P=0 kendu
		M= new double[T+1][N+1][P+1];
		ME= new double[T+1][N+1][P+1];
		kalkulatu();

	}

	public void kalkulatu() {

		dirua=0;
		bidaiariak= new BidaiariLista();
		if (N==0 || P==0) {
			return;
		}

		else if(T==0) {

			Vector<Bidaiaria> pisuGabe= new Vector<Bidaiaria>();
			Iterator<Bidaiaria> it=  bidaia.getLista().iterator();
			//0. kendu
			it.next();
			while(it.hasNext()) {
				Bidaiaria bid= it.next();
				if(bid.getPisua()==0) {
					pisuGabe.add(bid);
				}
			}
			Bidaiaria[] bidaiariOrd= pisuGabe.toArray(new Bidaiaria[pisuGabe.size()]);


			merge_sort(bidaiariOrd, 0 , bidaiariOrd.length-1);
			int kant= bidaiariOrd.length ;
			if((kant>=P)) {
				kant=P;
			}
			for(int i=0; i<kant; i++) {
				Bidaiaria bid= bidaiariOrd[i];
				dirua= dirua + bid.getDirua();
				bidaiariak.addBidaiari(bid);
			}

		}
		else {

			// balioak hasieratu
			// Defektuz balioak -1
			  for(int t=0; t<=T;t++) {
			 
				for(int n=0; n<=N;n++) {
					for(int p=0; p<=P;p++) {
						M[t][n][p]=-1;
						ME[t][n][p]=0;
					}
				}
			}
			
			
			
			// balioa lehenetsiak
			// antartida(p,t,0)=0
			for(int t=0; t<=T;t++) {
				for(int p=0; p<=P;p++) {
					M[t][0][p]=0;
				}
			}
			//antartida(0,t,n)=0
			for(int t=0; t<=T;t++) {
				for(int n=0; n<=N;n++) {
					M[t][n][0]=0;
				}
			}

			if(M[T][N][P]==-1) bete(T,N,P);
			
			dirua=M[T][N][P];
			errekuperazioa();


		}
	}

	public void bete(int t, int n, int p ) {
		double sol_partz;
		
	
		
		if(bidaia.bidPisua(n)<=t) {
			if(M[ (int) (t-bidaia.bidPisua(n))][n-1][p-1]==-1) {
				
				bete((int) (t-bidaia.bidPisua(n)), n-1, p-1);
				
			}
			if(M[t][n-1][p]==-1) bete(t, n-1, p);	

			double aux1=bidaia.bidDirua(n)+M[(int) (t-bidaia.bidPisua(n))][n-1][p-1];
			
			double aux2=M[t][n-1][p]; 
			
			if(aux1>aux2) {
				sol_partz=aux1;
				ME[t][n][p]=1;
				
			}else {
				sol_partz=aux2;
			}


		}else {
			if(M[t][n-1][p]==-1) bete(t, n-1, p);
			sol_partz=M[t][n-1][p]; 
			
		}

		M[t][n][p]=sol_partz;
	
	}
	
	//O(n) ordena linealean egiten da errekuperazioa
	public void errekuperazioa() {
		int p=P;
		int t=T;
		for(int n=N; n>=1; n--) {
			if(ME[t][n][p]==1) {
					p--;
					t= t-bidaia.bidPisua(n);
					bidaiariak.addBidaiari(bidaia.getBid(n));
				}
			}
			
		}
		
		
		
	

	//O(lg n) ordenan egiten da ordenaketa.
	public  void merge(Bidaiaria bid[], int h, int m, int b)
	{

		int n1 = m - h + 1;
		int n2 = b - m;


		Bidaiaria L[] = new Bidaiaria [n1];
		Bidaiaria R[] = new Bidaiaria [n2];

		/*Copy data to temp arrays*/
		for (int i=0; i<n1; ++i)
			L[i] = bid[h + i];
		for (int j=0; j<n2; ++j)
			R[j] = bid[m + 1+ j];



		int i = 0, j = 0;


		int k = h;
		while (i < n1 && j < n2)
		{
			if (L[i].getDirua() <= R[j].getDirua() )
			{
				bid[k] = L[i];
				i++;
			}
			else
			{
				bid[k] = R[j];
				j++;
			}
			k++;
		}


		while (i < n1)
		{
			bid[k] = L[i];
			i++;
			k++;
		}


		while (j < n2)
		{
			bid[k] = R[j];
			j++;
			k++;
		}
	}


	public void merge_sort(Bidaiaria bid[], int h, int b)
	{
		if (h < b)
		{

			int m = (h+b)/2;

			merge_sort(bid, h, m);
			merge_sort(bid , m+1, b);


			merge(bid, h, m, b);
		}
	}
}
