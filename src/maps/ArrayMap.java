package maps;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import domain.Vehicle;

@SuppressWarnings("rawtypes")
public class ArrayMap implements Map {

    private Vehicle array[] = new Vehicle[10];
    private int nElements = 0;

    /**
     * Retorna o valor de hash para a chave informada.
     * @param key a chave para a qual o valor de hash será calculado
     * @return o valor de hash
     */
    public int hash(int key) {
        return (int) (((key * 0.63274838) % 1) * array.length);
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
		int probe = 0;
		int hash;
		while (probe < array.length) {
			hash = (hash(key) + probe) % array.length;
			if (array[hash] == null) {
				nElements++;
				array[hash] = value;
				increase();
				return;
			} else if (array[hash].getChassis() == key) {
				array[hash] = value;
				increase();
				return;
			}
			probe++;
		}
		increase();
	}

    /**
     * Redimensiona o mapa se necessário.
     */
    private void increase() {
        if (nElements / array.length > 0.70) {
            reSize();
        }
    }

    /**
     * Remove um valor do mapa com base na chave.
     * @param key a chave do valor a ser removido
     */
    public void remove(int key) {
        int probe = 0;
        int hash;
        while (probe < array.length) {
            hash = (hash(key) + probe) % array.length;
            if (array[hash] == null) {
            } else if (array[hash].getChassis() == key) {
                array[hash] = null;
                return;
            }
            probe++;
        }
    }

    /**
     * Retorna o valor associado à chave informada.
     * @param key a chave do valor a ser retornado
     * @return o valor associado à chave, ou null se a chave não existir no mapa
     */
    public Vehicle get(int key) {
        int probe = 0;
        int hash;
        while (probe < array.length) {
            hash = (hash(key) + probe) % array.length;
            if (array[hash] == null) {
            } else if (array[hash].getChassis() == key) {
                return array[hash];
            }
            probe++;
        }
        return null;
    }

    /**
     * Redimensiona o mapa.
     */
    public void reSize() {
        Vehicle aux[] = array;
        Vehicle newV[] = new Vehicle[array.length * 2];
        this.array = newV;
        this.nElements = 0;
        for (Vehicle vehicle : aux) {
            put(vehicle.getChassis(), vehicle);
        }
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
        array = new Vehicle[10];
        nElements = 0;
    }

    /**
     * Ordena o mapa em ordem crescente dos chassis dos veículos.
     */
    public void selectionSort() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                int smallest = i;
                for (int j = i + 1; j < (array.length - 1); j++) {
                    if (array[j] != null) {
                        if (array[j].getChassis() < array[smallest].getChassis()) {
                            smallest = j;
                        }
                    }
                }
                Vehicle temp = array[i];
                array[i] = array[smallest];
                array[smallest] = temp;
            }
        }
    }

    /**
     * Imprime os valores do mapa ordenados pelo chassis dos veículos.
     */
    public void printSorted() {
        selectionSort();
        int index = 0;
        for (int i = index; i < array.length; i++) {
            if (array[i] != null) {
                index++;
                System.out.println(index + " - " + array[i].toString());
            }
        }
    }

    /**
     * Retorna o número de veículos da marca Ford presentes no mapa.
     * @return o número de veículos da marca Ford
     */
    public int getNumberOfFordBrand() {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (array[i].isFordBrand()) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Imprime todos os veículos da marca Ford presentes no mapa.
     */
    public void printAllFordBrand() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (array[i].isFordBrand()) {
                    System.out.println(array[i].toString());
                }
            }
        }
    }

    /**
     * Remove os veículos do mapa cujo chassis é menor ou igual ao valor informado.
     * @param value o valor de chassis máximo
     */
    public void removeChassisLessOrEqual(int value) {
        Vehicle[] temp = array;
        clear();
        for (Vehicle vehicle : temp) {
            if (vehicle != null) {
                if (vehicle.getChassis() > value) {
                    put(vehicle.getChassis(), vehicle);
                }
            }
        }
    }
    
    // Métodos não implementados (herdados da interface Map) foram omitidos na documentação.
    @Override
    public boolean containsKey(Object key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsKey'");
    }

    @Override
    public boolean containsValue(Object value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsValue'");
    }

    @Override
    public Object get(Object key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public Object put(Object key, Object value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'put'");
    }

    @Override
    public Object remove(Object key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void putAll(Map m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putAll'");
    }

    @Override
    public Set keySet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keySet'");
    }

    @Override
    public Collection values() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'values'");
    }

    @Override
    public Set entrySet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'entrySet'");
    }

}
