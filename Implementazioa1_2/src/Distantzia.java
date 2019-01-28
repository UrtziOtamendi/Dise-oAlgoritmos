import java.util.Collections;

public class Distantzia  implements Comparable<Distantzia>{

		public int ID;
		
		public double distantzia=Integer.MAX_VALUE;
	
		
		public Distantzia() {
			
		}
		public Distantzia(int id) {
			ID=id;
		}
		
		public Distantzia(int id, double dis) {
			ID=id;
			distantzia=dis;
		}

		public double getPisua() {
			return distantzia;
		}
		public void setPisua( double p) {
			distantzia=p;

		}
		
		
		@Override
		public int compareTo(Distantzia e){
			return Double.compare(e.distantzia,distantzia);		
		}

	

}
