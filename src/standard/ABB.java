package standard;

import domain.Vehicle;

public class ABB {
    private NodeAB root;

    /**
     * Cria uma nova árvore binária de busca vazia.
     */
    public ABB() {
        this.root = null;
    }

    /**
     * Verifica se a árvore está vazia.
     * 
     * @return true se a árvore estiver vazia, false caso contrário
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * Adiciona um veículo à árvore de forma recursiva.
     * 
     * @param element o veículo a ser adicionado
     */
    public void addRecursive(Vehicle element) {
        if (isEmpty()) {
            this.root = new NodeAB(element);
        } else {
            addRecursive(this.root, element);
        }
    }

    /**
     * Adiciona um veículo à subárvore atual de forma recursiva.
     * 
     * @param current o nó atual da subárvore
     * @param value   o veículo a ser adicionado
     */
    public void addRecursive(NodeAB current, Vehicle value) {
        if (value.getChassis() < current.value.getChassis()) {
            if (current.left == null) {
                NodeAB newNode = new NodeAB(value);
                current.left = newNode;
                newNode.father = current;
                return;
            }
            addRecursive(current.left, value);
        } else {
            if (current.right == null) {
                NodeAB newNode = new NodeAB(value);
                current.right = newNode;
                newNode.father = current;
                return;
            }
            addRecursive(current.right, value);
        }
    }

    /**
     * Busca um veículo na árvore de forma recursiva.
     * 
     * @param element o veículo a ser buscado
     * @return o nó que contém o veículo, ou null se o veículo não for encontrado
     */
    public NodeAB searchRec(Vehicle element) {
        return searchRec(this.root, element);
    }

    /**
     * Busca um veículo na subárvore atual de forma recursiva.
     * 
     * @param current o nó atual da subárvore
     * @param value   o veículo a ser buscado
     * @return o nó que contém o veículo, ou null se o veículo não for encontrado
     */
    private NodeAB searchRec(NodeAB current, Vehicle value) {
        if (current == null) {
            return null;
        }
        if (value.getChassis() == current.value.getChassis()) {
            return current;
        }
        if (value.getChassis() < current.value.getChassis()) {
            return searchRec(current.left, value);
        } else {
            return searchRec(current.right, value);
        }
    }

    /**
     * Retorna a root da árvore.
     * 
     * @return o nó root
     */
    public NodeAB getRoot() {
        return this.root;
    }

    /**
     * Retorna o tamanho da subárvore atual.
     * 
     * @param node o nó root da subárvore atual
     * @return o tamanho da subárvore
     */
    public int size(NodeAB node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.left) + size(node.right);
        }
    }

    /**
     * Remove um veículo da árvore.
     * 
     * @param value o veículo a ser removido
     * @return o nó root atualizado
     */
    public NodeAB delete(Vehicle value) {
        NodeAB current = this.root;
        NodeAB father = null;

        while (current != null && current.value != value) {
            father = current;
            if (value.getChassis() < current.value.getChassis()) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (current == null) {
            return this.root;
        }

        if (current.left == null && current.right == null) {
            if (current != root) {
                if (father.left == current) {
                    father.left = null;
                } else {
                    father.right = null;
                }
            } else {
                root = null;
            }
        } else if (current.left != null && current.right != null) {

            NodeAB sucessor = getMinimumKey(current.right);

            Vehicle temp = sucessor.value;

            delete(sucessor.value);

            current.value = temp;
        } else {
            NodeAB child = (current.left != null) ? current.left : current.right;

            if (current != root) {
                if (current == father.left) {
                    father.left = child;
                } else {
                    father.right = child;
                }
            } else {
                root = child;
            }
        }
        return root;
    }

    /**
     * Retorna o nó com a chave mínima a partir do nó atual.
     * 
     * @param current o nó atual
     * @return o nó com a chave mínima
     */
    public NodeAB getMinimumKey(NodeAB current) {
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    /**
     * Imprime os veículos da árvore em ordem.
     */
    public void inOrder() {
        if (this.root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.toString() + "\n");
        inOrder(root.right);
    }

    /**
     * Imprime os veículos de um nó em ordem.
     * 
     * @param current o nó atual
     */
    private static void inOrder(NodeAB current) {
        if (current == null) {
            return;
        }

        inOrder(current.left);
        System.out.print(current.toString() + "\n");
        inOrder(current.right);
    }

    /**
     * Conta o número de veículos da marca Ford na árvore.
     * 
     * @param root o nó root da subárvore atual
     */

    public int numFordBrand = 0;

    public void countFordBrand(NodeAB root) {
        if (root == null) {
            return;
        }
        if (root.getValue().getBrand().equals("Ford")) {
            numFordBrand++;
        }
        countFordBrand(root.left);
        countFordBrand(root.right);
    }

    /**
     * Retorna o número de veículos da marca Ford na árvore.
     * 
     * @return o número de veículos da marca Ford
     */
    public int numFordBrand() {
        countFordBrand(this.root);
        return this.numFordBrand;
    }

    /**
     * Remove os veículos com chassis menores ou iguais ao número informado.
     * 
     * @param root          o nó root da subárvore atual
     * @param chassisNumber o número máximo de chassis a serem removidos
     */
    public void removeChassis(NodeAB root, int chassisNumber) {
        if (root == null)
            return;
        removeChassis(root.left, chassisNumber);
        removeChassis(root.right, chassisNumber);
        if (root.getValue().getChassis() <= chassisNumber) {
            delete(root.getValue());
        }
    }

    /**
     * Remove os veículos com chassis menores ou iguais ao número informado.
     * 
     * @param chassisNumber o número máximo de chassis a serem removidos
     */
    public void removeChassisLess(int chassisNumber) {
        removeChassis(this.root, chassisNumber);
    }
}
