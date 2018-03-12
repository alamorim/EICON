package br.com.loja.teste.service;

import java.util.Date;
import java.util.List;

import br.com.loja.teste.entity.Pedido;

public interface IPedidoService {
	
	boolean addPedido(Pedido pedido);
	
	Pedido getPedidoByControle(Integer pedidoControle);
	
	List<Pedido> getPedidoByData(Date dataCadastro);

	List<Pedido> getAllPedido();
}
