package maps;

import dom.Veiculo;

public class LDE{
	private Noh inicio;
	private Noh fim;

	public LDE() {
		this.inicio = null;
		this.fim = null;
	}
	
	public Noh getEnd(){
		return fim;
	}
	
	public Noh getBegin(){
		return inicio;
	}

	public void insereInicio(Veiculo info) { 
		Noh novo = new Noh(info);
		if (inicio == null) {
			inicio = novo;
			fim = novo;
		} else {
			novo.setProx(inicio);
			inicio.setAnt(novo);
			inicio = novo;
		}
	}

	public boolean estahVazia() {
		return inicio == null;
	}

	public void insereFim(Veiculo info) { 
		Noh novo = new Noh(info);
		if (fim == null) {
			inicio = novo;
			fim = novo;
		} else {
			novo.setAnt(fim);
			fim.setProx(novo);
			fim = novo;
		}
	}

	public boolean remove(int info) { 
		return remove(buscaf(info));

	}
	
	private boolean remove(Noh info) {  
		if (info == null)
			return false;
		if (info.getAnt() == null) {
			inicio = info.getProx();
			if(inicio != null)
			inicio.setAnt(null);
		} else if (info.getProx() == null) {
			info.getAnt().setProx(null);
			fim = info.getAnt();
		} else {
			info.getAnt().setProx(info.getProx());
			info.getProx().setAnt(info.getAnt());
		}
		return true;
	}

	public Veiculo busca(int info) {
		Veiculo resultado = null;
		for (Noh i = inicio; i != null; i = i.getProx()) {
			if (i.getInfo().getChassi() == info) {
				resultado = i.getInfo();
				break;
			}
			
		}
		return resultado;
	}
	
	private Noh buscaf(int info) {
		Noh resultado = null;
		for (Noh i = inicio; i != null && i.getInfo().getChassi() != info; i = i.getProx()) {
			if (i.getInfo().getChassi() == info)
				resultado = i;
		}
		return resultado;
	}

	public int tamanho() {
		int cont = 0;
		for (Noh i = inicio; i != null; i = i.getProx())
			cont++;
		return cont;
	}
	
	public int imprimeInicioAFim() {
		return imprimeInicioAFim(0);
	}

	public int imprimeInicioAFim(int aux) {
		for (Noh i = inicio; i != null; i = i.getProx()) {
			System.out.println((aux + 1) + " -" + i.toString());
			aux ++;
		}
		return aux;
	}

	public void imprimeFimAInicio() {
		for (Noh i = fim; i != null; i = i.getAnt())
			System.out.println(i.toString() + "\n");
	}

	
	public void ordenar() {
		Noh todos = inicio;
		Noh menor = inicio;
		while (todos != null){
			for (Noh i = todos; i != null;i = i.getProx()) {
				if(menor.getInfo().getChassi() > i.getInfo().getChassi()) {
					menor = i;
				}
			}
			Veiculo info1 = todos.getInfo(); 
			Veiculo info2 = menor.getInfo(); 
			todos.setInfo(info2);
			menor.setInfo(info1);
			todos = todos.getProx();
			menor = todos;
		}
	}
	
	public void removeChassiMenorIgual(int valor) {
		for (Noh i = inicio; i != null;i = i.getProx()) {
			if(i.getInfo().getChassi() <= valor) {
				remove(i);
			}
		}
	}
	
	public int numeroMarcaFord() {
		int aux = 0;
		for (Noh i = inicio; i != null;i = i.getProx()) {
			if(i.getInfo().isMarcaFord()) {
				aux ++;
			}
		}
		return aux;
	}
}