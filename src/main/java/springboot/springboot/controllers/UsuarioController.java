package springboot.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.springboot.entities.Usuario;
import springboot.springboot.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity <List<Usuario>> procuraTodos() {
		List <Usuario> listaDeUsuario = service.procuraTodos();
		return ResponseEntity.status(HttpStatus.OK).body(listaDeUsuario);

	}
	
	@GetMapping (value = "/{id}")
	public Usuario procuraPorId(@PathVariable Integer id) {
		return service.procuraPorId(id);
		
	}
	
	@PostMapping
	public ResponseEntity <String> adicionarusuario (@RequestBody Usuario usuario) {
		String response = service.adicionarUsuario(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
	
	@PutMapping(value = "/{id}")
	public String  editarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
		return service.editarUsuario(id, usuario);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity <Void> excluirUsuario(@PathVariable Integer id) {
		service.excluirUsuario(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}