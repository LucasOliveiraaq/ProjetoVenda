package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.CategoriaProduto;

public class CategoriaProdutoController {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoVenda-jpa");
	EntityManager em = emf.createEntityManager();
	
	public void save(CategoriaProduto categoriaProduto) {
		em.getTransaction().begin();
		em.merge(categoriaProduto);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(CategoriaProduto categoriaProduto) {
		em.getTransaction().begin();
		javax.persistence.Query q = em
				.createNativeQuery("delete from categoriaproduto where nome = '" + categoriaProduto.getNome() + "'");
		q.executeUpdate();
		em.getTransaction().commit();
		emf.close();
	}
}
