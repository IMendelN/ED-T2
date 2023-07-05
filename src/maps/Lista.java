package maps;

import dom.Veiculo;

public interface Lista {
	public void insereInicio(Veiculo info);

	public void insereFim(Veiculo info);

	public boolean estahVazia();

	public boolean remove(int chassi);

	public int tamanho();
	
	public void imprime();
}