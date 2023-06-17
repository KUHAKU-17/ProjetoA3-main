package entidade;

public class Produto {
	
	private Integer id;
	private String nome;
	private Integer qtde;

	public Produto() {
	}

	public Produto(Integer id, String nome, Integer qtde) {
		this.id = id;
		this.nome = nome;
		this.qtde = qtde;
	}

	@Override
	public String toString() {
		return "Produto [id= " + id + ", nome= " + nome + ", quantidade= " + qtde + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setIdade(Integer qtde) {
		this.qtde = qtde;
	}
}