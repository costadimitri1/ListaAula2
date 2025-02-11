public class listaArray {
    private int numElementos;
    private Object[] arrayInterno;

    public listaArray(int tamanhoInicial) {
        this.arrayInterno = new Object[tamanhoInicial];
        this.numElementos = 0;
    }

    public boolean adicionar(Object elemento) {
        verificarNecessidadeDeCrescimento();
        this.arrayInterno[this.numElementos] = elemento;
        this.numElementos++;
        return true;
    }

    public boolean adicionar(Object elemento, int posicao) {
        if (posicao < 0 || posicao > this.numElementos) {
            return false;
        }
        verificarNecessidadeDeCrescimento();
        for (int i = this.numElementos; i > posicao; i--) {
            this.arrayInterno[i] = this.arrayInterno[i - 1];
        }
        this.arrayInterno[posicao] = elemento;
        this.numElementos++;
        return true;
    }

    public Object obter(int posicao) {
        if (posicao < 0 || posicao >= this.numElementos) {
            return null;
        }
        return this.arrayInterno[posicao];
    }

    public int posicaoDe(Object elemento) {
        for (int i = 0; i < this.numElementos; i++) {
            if (this.arrayInterno[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public boolean remover(int posicao) {
        if (posicao < 0 || posicao >= this.numElementos) {
            return false;
        }
        for (int i = posicao; i < this.numElementos - 1; i++) {
            this.arrayInterno[i] = this.arrayInterno[i + 1];
        }
        this.numElementos--;
        return true;
    }

    public boolean remover(Object elemento) {
        int posicao = posicaoDe(elemento);
        if (posicao == -1) {
            return false;
        }
        return remover(posicao);
    }

    private void verificarNecessidadeDeCrescimento() {
        if (this.numElementos == this.arrayInterno.length) {
            Object[] novoArray = new Object[this.arrayInterno.length * 2];
            for (int i = 0; i < this.arrayInterno.length; i++) {
                novoArray[i] = this.arrayInterno[i];
            }
            this.arrayInterno = novoArray;
        }
    }
}
