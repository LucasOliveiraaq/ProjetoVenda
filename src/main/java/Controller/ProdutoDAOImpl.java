package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Produto;

public class ProdutoDAOImpl implements ProdutoDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoVenda-jpa");
	EntityManager em = emf.createEntityManager();
	
	@Override
	public void save(Produto produto) {
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
		emf.close();
	}

}
