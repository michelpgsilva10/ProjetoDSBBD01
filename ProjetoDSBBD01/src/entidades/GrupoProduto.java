package entidades;

public class GrupoProduto {
	
	private int codigo;
	private String nome;
	private double promocao;
	private double margemLucro;
	
	public GrupoProduto() {
		
	}
	
	public GrupoProduto(int codigo, String nome, double promocao, double margemLucro) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.promocao = promocao;
		this.margemLucro = margemLucro;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPromocao() {
		return promocao;
	}
	public void setPromocao(double promocao) {
		this.promocao = promocao;
	}
	public double getMargemLucro() {
		return margemLucro;
	}
	public void setMargemLucro(double margemLucro) {
		this.margemLucro = margemLucro;
	}
	
}
