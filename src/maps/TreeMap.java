package maps;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import domain.Vehicle;
import standard.ABB;

@SuppressWarnings("rawtypes")
public class TreeMap implements Map {

	private ABB tree[] = new ABB[10];
	private int nElements = 0;

	/**
	 * Cria um novo TreeMap com 10 árvores de busca binária.
	 */
	public TreeMap() {
		for (int i = 0; i < 10; i++) {
			tree[i] = new ABB();
		}
	}

	/**
	 * Retorna o valor de hash para a chave informada.
	 * @param key a chave para a qual o valor de hash será calculado
	 * @return o valor de hash
	 */
	public int hash(int key) {
		char[] v = String.valueOf(key).toCharArray();
		return Integer.parseInt(String.valueOf(v[4]));
	}

	/**
	 * Insere um valor no mapa.
	 * @param value o valor a ser inserido
	 */
	public void put(Vehicle value) {
		put(value.getChassis(), value);
	}

	/**
	 * Insere um par chave-valor no mapa.
	 * @param key a chave a ser inserida
	 * @param value o valor a ser inserido
	 */
	public void put(int key, Vehicle value) {
		int hash = hash(key);
		if (tree[hash].searchRec(value) == null) {
			tree[hash(key)].addRecursive(value);
		}
	}

	/**
	 * Remove um valor do mapa com base no veículo e na chave.
	 * @param car o veículo a ser removido
	 * @param key a chave do veículo a ser removido
	 */
	public void remove(Vehicle car, int key) {
		tree[hash(key)].delete(car);
	}

	/**
	 * Verifica se o mapa contém a chave informada.
	 * @param key a chave a ser verificada
	 * @return true se o mapa contém a chave, false caso contrário
	 */
	public boolean containsKey(int key) {
		return get(key) != null;
	}

	/**
	 * Verifica se o mapa contém o valor informado.
	 * @param value o valor a ser verificado
	 * @return true se o mapa contém o valor, false caso contrário
	 */
	public boolean containsValue(Vehicle value) {
		return get(value.getChassis()) != null;
	}

	@Override
	public int size() {
		return nElements;
	}

	@Override
	public boolean isEmpty() {
		return nElements == 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < 10; i++) {
			tree[i] = new ABB();
		}
	}

	/**
	 * Imprime os valores do mapa em ordem.
	 */
	public void printSorted() {
		for (int i = 0; i < tree.length; i++)
			if (tree[i] != null) {
				tree[i].inOrder();
			}
	}

	/**
	 * Retorna o número de veículos da marca Ford presentes no mapa.
	 * @return o número de veículos da marca Ford
	 */
	public int getNumberOfFordBrand() {
		int numFordBrand = 0;
		for (int i = 0; i < tree.length; i++)
			if (tree[i] != null) {
				numFordBrand += tree[i].numFordBrand();
			}

		return numFordBrand;
	}

	/**
	 * Remove os veículos do mapa cujo chassis é menor ou igual ao valor informado.
	 * @param value o valor de chassis máximo
	 */
	public void removeChassisLessOrEqual(int value) {
		for (int i = 0; i < tree.length; i++)
			if (tree[i] != null) {
				tree[i].removeChassisLess(value);
			}
	}

	@Override
	public boolean containsKey(Object key) {
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		return false;
	}

	@Override
	public Object get(Object key) {
		return null;
	}

	@Override
	public Object put(Object key, Object value) {
		return null;
	}

	@Override
	public Object remove(Object key) {
		return null;
	}

	@Override
	public void putAll(Map m) {

	}

	@Override
	public Set keySet() {
		return null;
	}

	@Override
	public Collection values() {
		return null;
	}

	@Override
	public Set entrySet() {
		return null;
	}

}
