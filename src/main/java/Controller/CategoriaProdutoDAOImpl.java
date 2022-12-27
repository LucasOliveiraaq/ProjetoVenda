package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.CategoriaProduto;

public class CategoriaProdutoDAOImpl implements CategoriaProdutoDAO{

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoVenda-jpa");
	EntityManager em = emf.createEntityManager();
	
	@Override
	public void save(CategoriaProduto categoriaProduto) {
		em.getTransaction().begin();
		em.merge(categoriaProduto);
		em.getTransaction().commit();
		emf.close();
	}

	@Override
	public void remover(int id) {
		em.getTransaction().begin();
		javax.persistence.Query q = em
				.createNativeQuery("delete from categoriaproduto where id = '" + id + "'");
		q.executeUpdate();
		em.getTransaction().commit();
		emf.close();
	}

}
