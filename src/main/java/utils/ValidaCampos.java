package utils;

import java.util.Date;

import br.com.loja.teste.entity.Pedido;

public class ValidaCampos {

	public ValidaCampos(Pedido pedido) throws Exception {
		String valid = null;
		if (pedido.getCodigoCliente() == null) {
			valid = "Informar codigo do cliente";
		}
		if (pedido.getNumeroControle() == null) {
			valid = "Informar numero de controle";
		}
		if (pedido.getNome() == null || pedido.getNome().isEmpty()) {
			valid += "Informar Nome do cliente";
		}
		if (pedido.getValor() == 0) {
			valid += "Informar valor do produto";
		}
		if (pedido.getData() == null) {
			pedido.setData(new Date());
		}
		if (pedido.getQuantidade() == null) {
			pedido.setQuantidade(1);
		}
		if (pedido.getQuantidade() > 10) {
			valid += "quantidade maxima é de até 10.";
		}
		if(valid != null) {
			throw new Exception(valid);
		}
	}

}
