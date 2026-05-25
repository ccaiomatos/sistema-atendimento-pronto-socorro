public class FilaEncadeada<T> {
  private No<T> primeiro; // Referência para o primeiro nó da fila
  private No<T> ultimo;   // Referência para o último nó da fila

  // Construtor: cria uma fila vazia
  public FilaEncadeada() {
      primeiro = null;
      ultimo = null;
  }

  // Insere um novo elemento no final da fila
  public void enfileirar(T elemento) {
      No<T> novo = new No<>(elemento);
      if (estaVazia()) { // Se a fila estiver vazia
          primeiro = novo;
      } else { // Caso contrário, liga o último ao novo nó
          ultimo.setProximo(novo);
      }
      ultimo = novo; // Atualiza o último nó
  }

  // Remove e retorna o primeiro elemento da fila
  public T desenfileirar() {
      if (estaVazia()) {
          return null; // Se estiver vazia, retorna null
      }
      T elemento = primeiro.getElemento(); // Guarda o elemento a ser retornado
      primeiro = primeiro.getProximo(); // Avança o ponteiro para o próximo
      if (primeiro == null) { // Se a fila ficou vazia, atualiza o último também
          ultimo = null;
      }
      return elemento;
  }

  // Retorna o elemento do início da fila sem remover
  public T getPrimeiro() {
      if (estaVazia()) {
          return null;
      }
      return primeiro.getElemento();
  }

  // Verifica se a fila está vazia
  public boolean estaVazia() {
      return primeiro == null;
  }

  // Esvazia a fila completamente
  public void fazVazia() {
      primeiro = null;
      ultimo = null;
  }

  // Retorna uma representação em String da fila
  @Override
  public String toString() {
      if (estaVazia()) {
          return "Vazia";
      }
      StringBuilder sb = new StringBuilder();
      No<T> atual = primeiro;
      while (atual != null) {
          sb.append(atual.getElemento().toString()).append(" -> ");
          atual = atual.getProximo();
      }
      sb.append("fim");
      return sb.toString();
  }
}
