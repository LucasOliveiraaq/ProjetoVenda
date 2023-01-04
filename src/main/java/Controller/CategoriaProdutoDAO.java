package Controller;

import Model.CategoriaProduto;

public interface CategoriaProdutoDAO {

	public void save(CategoriaProduto categoriaProduto);
	public void remover(int id);
	public CategoriaProduto load(int id);
}
