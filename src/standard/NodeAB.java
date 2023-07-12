package standard;

import domain.Vehicle;

public class NodeAB {
    Vehicle value; // Valor armazenado no nó
    NodeAB left; // Referência para o nó à esquerda
    NodeAB right; // Referência para o nó à direita
    NodeAB father; // Referência para o nó pai

    public NodeAB(Vehicle value) {
        this.value = value;
        this.right = null;
        this.left = null;
        this.father = null;
    }

    public Vehicle getValue() {
        return this.value;
    }

    public void setValue(Vehicle value) {
        this.value = value;
    }

    public NodeAB getLeft() {
        return this.left;
    }

    public void setLeft(NodeAB left) {
        this.left = left;
    }

    public NodeAB getRight() {
        return this.right;
    }

    public void setRight(NodeAB right) {
        this.right = right;
    }

    public NodeAB getFather() {
        return this.father;
    }

    public void setFather(NodeAB father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
