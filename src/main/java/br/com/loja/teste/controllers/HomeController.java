package br.com.loja.teste.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.teste.entity.Pedido;
import br.com.loja.teste.service.IPedidoService;
import utils.ValidaCampos;

@RestController
public class HomeController {

	@Autowired
	private IPedidoService pedidoService;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}


//	@RequestMapping(method=RequestMethod.POST, value="/post", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML}, produces = {"application/json",  MediaType.APPLICATION_XML})
	@RequestMapping(method=RequestMethod.POST, value="/post")
	public ResponseEntity<String> create(@RequestBody Pedido pedido) {
		final HttpHeaders httpHeaders= new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.setContentType(MediaType.APPLICATION_XML);

		try {
			new ValidaCampos(pedido);
			double soma = (pedido.getValor() * pedido.getQuantidade());
			if(pedido.getQuantidade() > 5 && pedido.getQuantidade() < 10) {
				soma = soma-(soma*0.05);
			}else if(pedido.getQuantidade() >= 10) {
				soma = soma-(soma*0.10);
			}
			pedido.setTotal(String.format("%.2f", soma) );

			boolean flag = pedidoService.addPedido(pedido);
			if(flag) {
				return new ResponseEntity<String>("{\"Pedido\": \" "+pedido.getNumeroControle()+ " cadastrado com sucesso\"}", httpHeaders, HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("{\"Pedido\": \" "+pedido.getNumeroControle()+ " ja existe\" }", httpHeaders, HttpStatus.OK);
			}
		}
		catch (Exception ex) {
			return new ResponseEntity<String>("{\"Erro para o Pedido\": \" "+pedido.getNumeroControle()+ " erro:"+ex.getMessage()+ "\"}", httpHeaders, HttpStatus.OK);
		}
	}


	@RequestMapping(method = RequestMethod.GET, value="/getAll")
	@ResponseBody
	public ResponseEntity<List<Pedido>> getAllPedido() {
		List<Pedido> list = pedidoService.getAllPedido();
		return new ResponseEntity<List<Pedido>>(list, HttpStatus.OK);
	}

	@GetMapping("get/numeroControle/{id}")
	public ResponseEntity<Pedido> getControle(@PathVariable("id") Integer id) {
		Pedido pedido = pedidoService.getPedidoByControle(id);
		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
	}

	@RequestMapping(value="get/dataCadastro/{data}" , method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Pedido>> getDataCadastro(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date data) {
		System.out.println("data:"+data);
		List<Pedido> list = pedidoService.getPedidoByData(data);
		return new ResponseEntity<List<Pedido>>(list, HttpStatus.OK);
	}
}
