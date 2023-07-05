package maps;

import dom.Veiculo;

public class Noh {
	private Veiculo info;
	private Noh prox;
	private Noh ant;

	public Noh(Veiculo info2) {
		this.info = info2;
		this.prox = null;
		this.ant = null;
	}

	public void setInfo(Veiculo info) {
		this.info = info;
	}
	
	public Veiculo getInfo() {
		return info;
	}

	public Noh getProx() { 
		return prox;
	}

	public void setAnt(Noh n) {
		this.ant = n;
	}
	
	public Noh getAnt() { 
		return ant;
	}

	public void setProx(Noh n) {
		this.prox = n;
	}
	
	public String toString() {
		return String.valueOf(info);
	}

}