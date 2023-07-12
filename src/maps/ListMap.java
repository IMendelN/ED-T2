package maps;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import domain.Vehicle;
import standard.LDE;

@SuppressWarnings("rawtypes")
public class ListMap implements Map {

	private LDE[] array = new LDE[10];
	private int nElements = 0;

	/**
	 * Cria um novo ListMap com 10 listas duplamente encadeadas.
	 */
	public ListMap() {
		for (int i = 0; i < 10; i++) {
			array[i] = new LDE();
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
		if (array[hash].search(value.getChassis()) == null)
			array[hash(key)].insertAtBeginning(value);
	}

	/**
	 * Remove um valor do mapa com base na chave.
	 * @param key a chave do valor a ser removido
	 */
	public void remove(int key) {
		array[hash(key)].remove(key);
	}

	/**
	 * Retorna o valor associado à chave informada.
	 * @param key a chave do valor a ser retornado
	 * @return o valor associado à chave, ou null se a chave não existir no mapa
	 */
	public Vehicle get(int key) {
		return array[hash(key)].search(key);
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

	/**
	 * Imprime os valores do mapa em ordem.
	 */
	public void printSorted() {
		int aux = 0;
		for (int i = 0; i < array.length; i++) {
			if (!array[i].isEmpty()) {
				array[i].order();
				aux = array[i].printFromStartToEnd(aux);
			}
		}
	}

	/**
	 * Remove os valores do mapa cujo chassis é menor ou igual ao valor padrão (202050000).
	 */
	public void removeChassisLessOrEqual() {
		removeChassisLessOrEqual(202050000);
	}

	/**
	 * Remove os valores do mapa cujo chassis é menor ou igual ao valor informado.
	 * @param value o valor de chassis máximo
	 */
	public void removeChassisLessOrEqual(int value) {
		for (int i = 0; i < array.length; i++) {
			array[i].removeSmallerOrEqualChassis(value);
		}
	}

	/**
	 * Retorna o número de veículos da marca Ford presentes no mapa.
	 * @return o número de veículos da marca Ford
	 */
	public int getNumberOfFordBrand() {
		int aux = 0;
		for (int i = 0; i < array.length; i++) {
			aux = aux + array[i].countFordBrand();
		}
		return aux;
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
			array[i] = new LDE();
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
