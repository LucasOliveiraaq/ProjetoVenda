package Model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private int quantidade;
	@Column
	private BigDecimal valor;
	@Column
	private BigDecimal custo;
	@Column
	private String descricao;
	@Column
	private String nome;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "Id_CategoriaProduto",nullable=false)
	private CategoriaProduto categoriaProduto;
	
	public Produto() {
	}

	public Produto(int id, int quantidade, BigDecimal valor, BigDecimal custo, String descricao, String nome,
			CategoriaProduto categoriaProduto) {
		this.id = id;
		this.quantidade = quantidade;
		this.valor = valor;
		this.custo = custo;
		this.descricao = descricao;
		this.nome = nome;
		this.categoriaProduto = categoriaProduto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CategoriaProduto getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
