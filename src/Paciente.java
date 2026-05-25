public class Paciente {
  private String nome;
  private String prioridade; // Prioridade: "vermelha", "amarela" ou "verde"

  // Construtor: cria um paciente com nome e prioridade
  public Paciente(String nome, String prioridade) {
      this.nome = nome;
      this.prioridade = prioridade;
  }

  // Retorna o nome do paciente
  public String getNome() {
      return nome;
  }

  // Retorna a prioridade do paciente
  public String getPrioridade() {
      return prioridade;
  }

  // Retorna uma representação em texto do paciente
  @Override
  public String toString() {
      return nome + " (" + prioridade + ")";
  }

}
