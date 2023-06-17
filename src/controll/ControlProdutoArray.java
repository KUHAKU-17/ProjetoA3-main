package controll;


import entidade.Produto;

public class ControlProdutoArray {
	
    
    private Produto[] Produtos;

	public Produto[] getProdutos() {
		return Produtos;
	}

	public void setProdutos(Produto[] Produtos) {
		this.Produtos = Produtos;
	}

	public Boolean vetorVazio() {
		if (this.Produtos.length == 0) { 
			System.out.println("Cadastro Vazio!!!");
			return true;
		} else {
			return false;
		}

	}
    
	public void adicionarProdutoVazio(Integer n, Produto... p) {
		if (n == 0) {
			System.out.println("Usuário invalido!!!");
		} else {
			this.Produtos = new Produto[n];
			int i = 0;
			for (Produto x : p) {
				if (i > (this.Produtos.length - 1)) {
					throw new ArrayIndexOutOfBoundsException("Número de registros excede o tamanho de cadastros!!!");
				} else {
					this.Produtos[i] = new Produto(x.getId(), x.getNome(), x.getQtde());
					i++;
				}
			} 
		}
	}

	public void adicionarProduto(Integer n, Produto... p) {
	if (this.Produtos.length == 0) {
			System.out.println("Necessário criar o cadastro primeiro!!!");
		} else {
			int i = 0;
			while ((i < this.Produtos.length) && (this.Produtos[i] != null)) {
				i++;
			}
			if (i > (this.Produtos.length - 1)) {
				System.out.println("limite de cadastros!!!");
			} else {
				if ((this.Produtos.length - i) < n) {
					System.out.println("Número de registros excede o tamanho dos cadastros!!!");
				} else {
					for (Produto x : p) {
						this.Produtos[i] = new Produto(x.getId(), x.getNome(), x.getQtde());
						i++;
					}
				}
			}
		}	
		
	}
	

	public void listarProduto() {

		if (!vetorVazio()) {
			for (int i = 0; i < this.Produtos.length; i++) {
				if (Produtos[i] != null) {
				System.out.println(i + " : " + Produtos[i]);
				} else {
				System.out.println(i + " : espaço sobrando em seu carrinho");
				}
			}
		}
	}

	public void atualizarProduto(Produto p) {
		int achado = 0;
		if (!vetorVazio()) {
			for (int i = 0; i < this.Produtos.length; i++) {
				if ((this.Produtos[i] != null) && (this.Produtos[i].getId().equals(p.getId()))) {
					this.Produtos[i] = p;
					achado++;
				}
			}
		}
		if (achado == 0) {
			System.out.println("Produto não encontrado!!!");
		}
	}

	public void removerProduto(Produto p) {
		int achado = 0;
		if (!vetorVazio()) {
			for (int i = 0; i < this.Produtos.length; i++) {
				if ((this.Produtos[i] != null) && (this.Produtos[i].getId().equals(p.getId()))) {
					achado++;
					for (int j = i; j < this.Produtos.length; j++) {
						if (this.Produtos[j] != null)
						Produtos[j] = Produtos[j + 1];
					}
				}
			}
		}
		if (achado == 0) {
			System.out.println("Código não encontrada!!!");
		}
	}

	public static void main(String[] args) {
		System.out.println("|-----------------------------------------|");
		System.out.println("<BEM VINDO AO SEU CARRINHO DE COMPRAS!>");
		System.out.println("essa é sua lista de itens em seu carrinho");
		System.out.println("|----------------------------------------------------|");
		Produto p1 = new Produto(10, "mouse", 1);
		Produto p2 = new Produto(11, "teclado", 2);
		Produto p3 = new Produto(12, "caneta", 3);
		Produto p4 = new Produto(13, "processador", 2);
		//lembrar de adicionar um choose para o usuario declarar qual ação irá fazer
		ControlProdutoArray cp = new ControlProdutoArray();
		cp.adicionarProdutoVazio(10, p1, p2, p3, p4);
		//cp.adicionarProduto(2, p1, p2);
		//cp.removerProduto(new Produto(12, null, null));
		//cp.atualizarProduto(new Produto(12, "lapis", 50));
		cp.listarProduto();
		System.out.println("|----------------------------------------------------|");
	}
    
}
