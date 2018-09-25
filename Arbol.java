class Arbol{
	String valor;
	Arbol izq;
	Arbol der;

	public Arbol(String valor){
		this.valor = valor;
		izq = null;
		der = null;
	}

	public Arbol(String valor, Arbol izq, Arbol der){
		this.valor = valor;
		this.izq = izq;
		this.der = der;
	}

	public static boolean esNumero(String s){
		for(int i = 0; i<s.length(); i++){
			if(!Character.isDigit(s.charAt(i))){
				return false;
			}
		}
		return true;
	}

	public static boolean esVariable(String s){
		for(int i = 0; i<s.length(); i++){
			if(!Character.isLetter(s.charAt(i))){
				return false;
			}
		}
		return true;
	}

	public Arbol derivada(String variable) {

		if (valor.equals("+")) {
			return new Arbol("+", izq.derivada(variable), der.derivada(variable));
		}
		else if (valor.equals("-")) {
			return new Arbol("-", izq.derivada(variable), der.derivada(variable));
		}
		else if (valor.equals("*")) {
			return new Arbol("+", new Arbol("*", izq, der.derivada(variable)), new Arbol("*", der, izq.derivada(variable)));
		}
		else if (valor.equals("/")) {
			return new Arbol("/", new Arbol("-", new Arbol("*", der, izq.derivada(variable)), new Arbol("*", izq, der.derivada(variable))), new Arbol("*", der, der));
		}
		else if (der == null && izq == null){
			if (esNumero(valor) || !valor.equals(variable)){
				return new Arbol("0");
			}
			else if (valor.equals(variable)){
				return new Arbol("1");
			}
		}
		else {
				return null;
		}
		return null;
	}


}