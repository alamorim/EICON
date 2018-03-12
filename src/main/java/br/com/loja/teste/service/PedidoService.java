package br.com.loja.teste.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.teste.dao.IPedidoDAO;
import br.com.loja.teste.entity.Pedido;

@Service
public class PedidoService implements IPedidoService{
	@Autowired
	private IPedidoDAO pedidoDAO;
	
	@Override
	public synchronized boolean addPedido(Pedido pedido){
                if (pedidoDAO.pedidoExists(pedido.getNumeroControle())) {
                	System.out.println("false Idao");
    	            return false;
                } else {
                	System.out.println("true Idao");
                	pedidoDAO.addPedido(pedido);
    	            return true; 
                }
	}
	
	@Override
	public Pedido getPedidoByControle(Integer pedidoControle) {
		Pedido obj = pedidoDAO.getPedidoByControle(pedidoControle);
		return obj;
	}	
	@Override
	public List<Pedido> getPedidoByData(Date dataCadastro) {
		return  pedidoDAO.getPedidoByData(dataCadastro);
		
	}	
	
	@Override
	public List<Pedido> getAllPedido(){
		return pedidoDAO.getAllPedido();
	}
}
