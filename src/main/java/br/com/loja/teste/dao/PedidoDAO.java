package br.com.loja.teste.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.loja.teste.entity.Pedido;

@Transactional
@Repository
public class PedidoDAO implements IPedidoDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public void addPedido(Pedido pedido) {
		entityManager.persist(pedido);
	}
	
	@Override
	public boolean pedidoExists( Integer controle) {
		String hql = "FROM Pedido WHERE numero_controle = :CONTROLE";
		Integer count = entityManager.createQuery(hql).setParameter("CONTROLE", controle).getResultList().size();
		return count > 0 ? true : false;
	}

	@Override
	public Pedido getPedidoByControle(Integer pedidoControle) {
		return entityManager.find(Pedido.class, pedidoControle);
	}
	@Override
	public List<Pedido> getPedidoByData(Date dataCadastro) {
		String hql = "FROM Pedido WHERE data_cadastro = :DATA";
		return (List<Pedido>) entityManager.createQuery(hql).setParameter("DATA", dataCadastro).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> getAllPedido() {
		String hql = "FROM Pedido";
		return (List<Pedido>) entityManager.createQuery(hql).getResultList();
	}
	
}
