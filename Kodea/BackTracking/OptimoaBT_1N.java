package BackTracking;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

import Domain.Bidaia;
import Domain.BidaiariLista;
import Domain.Bidaiaria;

public class OptimoaBT_1N {


	public Bidaia bidaia;
	public BidaiariLista bidaiariak;

	public double SOD;
	public int[] SOL;

	public double[] diruLista;

	public int N;
	public int P;
	public int T;


	public OptimoaBT_1N( Bidaia bidai) {
		bidaia= bidai;
		bidaiariak= new BidaiariLista();

		SOD=0.0;
		N=bidaia.getN();
		P=bidaia.getP();
		T=bidaia.getT();

		diruLista= new double[N+1];

		int[] SPL= new int[N+1];
		Arrays.fill(SPL, 0);


		SOL=new int[N+1];

		if(P==0 || N==0) {
			SOL=SPL;
		}
		else if(bidaia.getT()==0) {

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
				SOD= SOD + bid.getDirua();
				bidaiariak.addBidaiari(bid);
			}

		}
		else {
			gehienez();
			antartida(1,P,0,0,SPL);
			for(int i=0; i<=N; i++) {
				if(SOL[i]==1) {
					bidaiariak.addBidaiari(bidaia.getBid(i));
				}
			}
		}



	}

	public void antartida(int i, int SPxP, int SPxT, double SPB, int[] SPL) {

		
		if( i>N || SPxP==0) {
			if(SPB>=SOD) {
				SOD=SPB;
				SOL=SPL.clone();
			}
		}
		else {
			for(int t=i; t<=N; t++) {
				if((bidaia.bidPisua(t)+SPxT)<=T) {
					if(SPB+diruLista[t]>SOD) {
						SPL[t]=1;
						antartida(t+1, SPxP-1, SPxT+bidaia.bidPisua(t), SPB+bidaia.bidDirua(t), SPL);
						SPL[t]=0;
					}
				}
				
			}
			if(SPB>=SOD) {
				SOD=SPB;
				SOL=SPL.clone();
			}
			
		}
	}


	public void gehienez() {
		diruLista[N]=bidaia.bidDirua(N);
		for(int n=(N-1); n>=1; n--) diruLista[n]=diruLista[n+1]+bidaia.bidDirua(n);

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




