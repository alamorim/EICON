package br.com.loja.teste.dao;

import java.util.Date;
import java.util.List;

import br.com.loja.teste.entity.Pedido;

public interface IPedidoDAO {

//	Pedido getPedidoById(int pedido.get);
	void addPedido(Pedido pedido);

	boolean pedidoExists(Integer controle);
	
	Pedido getPedidoByControle(Integer pedidoControle);

	List<Pedido> getPedidoByData(Date dataCadastro);
	
	List<Pedido> getAllPedido();
}
