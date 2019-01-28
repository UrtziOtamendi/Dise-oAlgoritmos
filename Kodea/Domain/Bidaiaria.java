package Domain;

public class Bidaiaria {

	private int ID;
	private double Dirua;
	private int Pisua;
	
	public Bidaiaria(int id, double Diru, int Pisu) {
		this.setID(id);
		this.setDirua(Diru);
		this.setPisua(Pisu);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getDirua() {
		return Dirua;
	}

	public void setDirua(double dirua) {
		Dirua = dirua;
	}

	public int getPisua() {
		return Pisua;
	}

	public void setPisua(int pisua) {
		Pisua = pisua;
	}

	
}
