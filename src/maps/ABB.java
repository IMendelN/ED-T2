package maps;

import dom.Veiculo;

public class ABB {
    private NohAB raiz;

    public ABB() {
        this.raiz = null;
    }

    public boolean isEmpty(){
        return this.raiz == null;
    }

    public void addRecursive(Veiculo element) {
        if (isEmpty())
        {
            this.raiz = new NohAB(element);
        }
        else {
            addRecursive(this.raiz, element);
        }
    }

    private void addRecursive(NohAB current, Veiculo valor) {
        if (valor.getChassi() < current.valor.getChassi()) {
            if (current.esq == null) {
                NohAB newNoh = new NohAB(valor);
                current.esq = newNoh;
                newNoh.pai = current;
                return;
            }
            addRecursive(current.esq, valor);
        }
        else {
            if (current.dir == null) {
                NohAB newNoh = new NohAB(valor);
                current.dir = newNoh;
                newNoh.pai = current;
                return;
            }
            addRecursive(current.dir, valor);
        }
    }

    public NohAB buscaRec(Veiculo element) {
        return buscaRec(this.raiz, element);
    }
    
    private NohAB buscaRec(NohAB current, Veiculo valor) {
        if (current == null) 
        {   
            return null;
        }
        if (valor.getChassi() == current.valor.getChassi()) 
        {
            return current;
        }
        if (valor.getChassi() < current.valor.getChassi()){
            return buscaRec(current.esq, valor);
        }
        else{
            return buscaRec(current.dir, valor);
        }
    }

    public NohAB raiz(){
        return this.raiz;
    }

    public int tamanho(NohAB raiz){
		if(raiz==null){
			return 0;
		}
		return 1 + tamanho(raiz.esq) + tamanho(raiz.dir);
	}

    public NohAB delete(Veiculo value) {
        NohAB curr = this.raiz;
        NohAB pai = null;

        while (curr != null && curr.valor != value)
        {
            pai = curr;
            if (value.getChassi() < curr.valor.getChassi()) {
                curr = curr.esq;
            }
            else {
                curr = curr.dir;
            }
        }

        if (curr == null) {
            return this.raiz;
        }

        if (curr.esq == null && curr.dir == null)
        {
            if (curr != raiz)
            {
                if (pai.esq == curr) {
                    pai.esq = null;
                }
                else {
                    pai.dir = null;
                }
            }
            else {
                raiz = null;
            }
        }
        else if (curr.esq != null && curr.dir != null)
        {
            NohAB successor = getMinimumKey(curr.dir);

            Veiculo val = successor.valor;
 
            delete(successor.valor);

            curr.valor = val;
        }
        else {
            NohAB child = (curr.esq != null)? curr.esq: curr.dir;
 
            if (curr != raiz)
            {
                if (curr == pai.esq) {
                    pai.esq = child;
                }
                else {
                    pai.dir = child;
                }
            }
            else {
                raiz = child;
            }
        }
        return raiz;
    }

        
    public static NohAB getMinimumKey(NohAB current)
        {
            while (current.esq != null) {
                current = current.esq;
            }
            return current;
        }

    public void inorder()
    {
        if (this.raiz == null) {
            return;
        }
 
        inorder(raiz.esq);
        System.out.print(raiz.toString() + "\n");
        inorder(raiz.dir);
    }

    private static void inorder(NohAB current){
        if (current == null) {
            return;
        }
        inorder(current.esq);
        System.out.print(current.toString() + "\n");
        inorder(current.dir);
    }

    public int numMarcaFord = 0;

    public void countMarcaFord(NohAB root) { 
        if (root == null) 
            return; 
        if (root.getValor().getMarca().equals("Ford")){
            this.numMarcaFord++;
        }
        countMarcaFord(root.esq); 
        countMarcaFord(root.dir); 
    } 

    public int numMarcaFord(){
        countMarcaFord(this.raiz);
        return this.numMarcaFord;
    }

    public void removeChassi(NohAB root, int valueChassi) { 
        if (root == null) 
            return; 
        removeChassi(root.esq, valueChassi); 
        removeChassi(root.dir, valueChassi); 
        if (root.getValor().getChassi() <= valueChassi){
            delete(root.getValor());
        }
    } 

    public void removeChassiMenor(int value){
        removeChassi(this.raiz, value); 
    }

}