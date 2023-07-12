package standard;

import domain.Vehicle;

public class LDE {

    private Node start; // Nó inicial da lista duplamente encadeada
    private Node end; // Nó final da lista duplamente encadeada

    public LDE() {
        this.start = null;
        this.end = null;
    }

    public Node getEnd() {
        return end;
    }

    public Node getBegin() {
        return start;
    }

    // Insere um novo nó no início da lista
    public void insertAtBeginning(Vehicle info) {
        Node newest = new Node(info);
        if (start == null) {
            start = newest;
            end = newest;
        } else {
            newest.setNext(start);
            start.setPrev(newest);
            start = newest;
        }
    }

    // Insere um novo nó no final da lista
    public void insertEnd(Vehicle info) {
        Node newest = new Node(info);
        if (end == null) {
            start = newest;
            end = newest;
        } else {
            newest.setPrev(end);
            end.setNext(newest);
            end = newest;
        }
    }

    // Retorna o tamanho da lista
    public int size() {
        int count = 0;
        for (Node i = start; i != null; i = i.getNext()) {
            count++;
        }
        return count;
    }

    // Busca um veículo na lista pelo número do chassi
    public Vehicle search(int info) {
        Vehicle result = null;
        for (Node i = start; i != null; i = i.getNext()) {
            if (i.getInfo().getChassis() == info) {
                result = i.getInfo();
                break;
            }
        }
        return result;
    }

    // Busca um nó na lista pelo número do chassi de forma recursiva
    public Node searchR(int info) {
        Node result = null;
        for (Node i = start; i != null && i.getInfo().getChassis() != info; i = i.getNext()) {
            if (i.getInfo().getChassis() == info) {
                result = i;
            }
        }
        return result;
    }

    // Remove um nó da lista pelo número do chassi
    public boolean remove(int info) {
        return remove(searchR(info));
    }

    // Remove um nó específico da lista
    public boolean remove(Node info) {
        if (info == null) {
            return false;
        }
        if (info.getPrev() == null) {
            start = info.getNext();
            if (start != null)
                start.setPrev(null);
        } else if (info.getNext() == null) {
            info.getPrev().setNext(null);
            end = info.getPrev();
        } else {
            info.getPrev().setNext(info.getNext());
            info.getNext().setPrev(info.getPrev());
        }
        return true;
    }

    // Verifica se a lista está vazia
    public boolean isEmpty() {
        return start == null;
    }

    // Imprime os veículos da lista a partir do início até o fim, com um número de linha
    public int printFromStartToEnd(int row) {
        for (Node i = start; i != null; i = i.getNext()) {
            System.out.println((row + 1) + " - " + i.toString());
            row++;
        }
        return row;
    }

    // Imprime os veículos da lista a partir do início até o fim, iniciando na linha 0
    public int printFromStartToEnd() {
        return printFromStartToEnd(0);
    }

    // Imprime os veículos da lista a partir do fim até o início
    public void printEndToStart() {
        for (Node i = end; i != null; i = i.getPrev()) {
            System.out.println(i.toString() + "\n");
        }
    }

    // Ordena os veículos na lista pelo número do chassi (do menor para o maior)
    public void order() {
        Node all = start;
        Node smaller = start;
        while (all != null) {
            smaller = all;
            for (Node i = all; i != null; i = i.getNext()) {
                if (i.getInfo().getChassis() < smaller.getInfo().getChassis()) {
                    smaller = i;
                }
            }
            Vehicle info1 = all.getInfo();
            Vehicle info2 = smaller.getInfo();
            all.setInfo(info2);
            smaller.setInfo(info1);
            all = all.getNext();
        }
    }

    // Remove os veículos da lista que possuem número do chassi menor ou igual a um determinado valor
    public void removeSmallerOrEqualChassis(int chassis) {
        for (Node i = start; i != null; i = i.getNext()) {
            if (i.getInfo().getChassis() <= chassis) {
                remove(i);
            }
        }
    }

    // Remove os veículos da lista que possuem número do chassi maior ou igual a um determinado valor
    public void removeBiggerOrEqualChassis(int chassis) {
        for (Node i = start; i != null; i = i.getNext()) {
            if (i.getInfo().getChassis() >= chassis) {
                remove(i);
            }
        }
    }

    // Remove os veículos da lista que possuem número do chassi igual a um determinado valor
    public void removeEqualChassis(int chassis) {
        for (Node i = start; i != null; i = i.getNext()) {
            if (i.getInfo().getChassis() == chassis) {
                remove(i);
            }
        }
    }

    // Conta quantos veículos da marca Ford estão na lista
    public int countFordBrand() {
        int count = 0;
        for (Node i = start; i != null; i = i.getNext()) {
            if (i.getInfo().isFordBrand()) {
                count++;
            }
        }
        return count;
    }
}
