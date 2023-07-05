package maps;

import dom.Veiculo;

public class NohAB {
    Veiculo valor;
	NohAB esq;
	NohAB dir;
    NohAB pai;

    NohAB(Veiculo valor){
        this.valor = valor;
        dir = null;
        esq = null;
        pai = null;
    }

    public Veiculo getValor() {
        return this.valor;
    }

    public void setValor(Veiculo valor) {
        this.valor = valor;
    }

    public NohAB getEsq() {
        return this.esq;
    }

    public void setEsq(NohAB esq) {
        this.esq = esq;
    }

    public NohAB getDir() {
        return this.dir;
    }

    public void setDir(NohAB dir) {
        this.dir = dir;
    }

    public NohAB getPai() {
        return this.pai;
    }

    public void setPai(NohAB pai) {
        this.pai = pai;
    }

    public String toString() {
		return String.valueOf(valor);
	}
}