package Controller;

public interface InterfaceDao <T>{
	
	 void save(T objeto);
	 void remover(T objeto);
	 void alterar(T objeto);
     void buscar(T objeto);
}
