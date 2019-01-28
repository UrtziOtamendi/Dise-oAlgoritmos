import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.Timer;

import BackTracking.OptimoaBT;
import BackTracking.OptimoaBT_1N;
import Dinamikoa.Optimoa;
import Domain.Bidaia;
import Domain.FitxategiaIrakurri;

public class Nagusia {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

		
		String path = "prueba.txt";

		Scanner sc = new Scanner(System.in);
		
		

		System.out.println("****************");
		System.out.println("*PROBA PROGRAMA*");
		System.out.println("****************");

		int modo=1;
		while(modo==1){
			
		System.out.println("----");
		System.out.println("| N |");
		System.out.println("----");
		System.out.println("Zenbat hautagai nahi dituzu (Maximoa 1011)?");
		int N=sc.nextInt();
		if(N>1011) N=1011;
		
		System.out.println("----");
		System.out.println("| T |");
		System.out.println("----");
		System.out.println("Zenbateko pisu Max nahi duzu?");
		int T=sc.nextInt();
		
		System.out.println("----");
		System.out.println("| P |");
		System.out.println("----");
		System.out.println("Zenbateko plaza Max nahi dituzu?");
		int P=sc.nextInt();
		
		
		FitxategiaIrakurri fitxategia = new FitxategiaIrakurri(path,N,P,T);
		Bidaia bidaia = fitxategia.sortuBidaia();
		System.out.println("Bidaia sortuta");
		
		
		System.out.println("++++++++++++++++++++++++++++++");
		System.out.println("+   Programazio Dinamikoa    +");
		System.out.println("++++++++++++++++++++++++++++++");
		
		Instant startPD = Instant.now();
		
		Optimoa optim= new Optimoa(bidaia);
		Instant endPD = Instant.now();
		
		System.out.println("Diru kant: "+ optim.dirua +"€");
		System.out.println("_____________________________");
		optim.bidaiariak.print();
		System.out.println("_____________________________");
		System.out.println("Denbora: "+ Duration.between(startPD, endPD));

		
		
		System.out.println("++++++++++++++++++++++++++++++");
		System.out.println("+       BackTrack 1N         +");
		System.out.println("++++++++++++++++++++++++++++++");
		
		Instant startBT1N = Instant.now();
		OptimoaBT_1N optimBT_1N= new OptimoaBT_1N(bidaia);
		Instant endBT1N = Instant.now();		
		System.out.println("Diru kant: "+ optimBT_1N.SOD +"€");
		System.out.println("_____________________________");
		optimBT_1N.bidaiariak.print();
		System.out.println("_____________________________");
		System.out.println("Denbora: "+ Duration.between(startBT1N, endBT1N));
		
		
		System.out.println("++++++++++++++++++++++++++++++");
		System.out.println("+       BackTrack 01         +");
		System.out.println("++++++++++++++++++++++++++++++");
		
		
		Instant startBT01 = Instant.now();
		OptimoaBT optimBT= new OptimoaBT(bidaia);	
		Instant endBT01 = Instant.now();
		System.out.println("Diru kant: "+ optimBT.SOD +"€");
		System.out.println("_____________________________");
		optimBT.bidaiariak.print();
		System.out.println("_____________________________");
		System.out.println("Denbora: "+ Duration.between(startBT01, endBT01));
		
		
		System.out.println("Proba amaitu da, idatzi 1 beste bat egiteko edo 0 irteteko");
		modo=sc.nextInt();
		
	}
		
		
	}
}


