package Model;

public enum CategoriaProdutoEnum {
	Eletronico(1, "Eletronico"),
	Comida(2, "Comida");
	
	private final int value;
	private final String description;
	
	private CategoriaProdutoEnum(Integer value, String description) {
	    this.value = value;
		this.description = description;
	}

	public Integer getValue() {
		return value;
	}
	
	public String getDescription() {
		 return description;
	}
	
	public static CategoriaProdutoEnum valueOf(int value) {
		for (CategoriaProdutoEnum categoriaProdutoEnum : values()) {
			if (categoriaProdutoEnum.value == value) {
				return categoriaProdutoEnum;
			}
		}
		return null;
	}	
}

