public class No<T> {
  private T elemento; // Elemento armazenado no nó
  private No<T> proximo; // Referência para o próximo nó

  // Construtor: cria um nó com o elemento e sem próximo
  public No(T elemento) {
      this.elemento = elemento;
      this.proximo = null;
  }

  // Retorna o elemento armazenado no nó
  public T getElemento() {
      return elemento;
  }

  // Define ou altera o elemento armazenado no nó
  public void setElemento(T elemento) {
      this.elemento = elemento;
  }

  // Retorna o próximo nó da lista
  public No<T> getProximo() {
      return proximo;
  }

  // Define ou altera o próximo nó da lista
  public void setProximo(No<T> proximo) {
      this.proximo = proximo;
  }
}
