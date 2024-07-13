package springboot.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.springboot.entities.Usuario;
import springboot.springboot.exceptions.NaoEncontradoException;
import springboot.springboot.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	
	public List<Usuario> procuraTodos(){
		return repository.findAll();
	}
	
	public Usuario procuraPorId (Integer id) {
		
			return repository.findById(id)
					.orElseThrow(() -> new NaoEncontradoException ("Id invalidado! Usuario não encontrado"));
			
		
	}
	
	public String adicionarUsuario(Usuario usuario) {
		repository.save(usuario);
		return "usuario adicionado com sucesso";
	}
	
	public String editarUsuario(Integer id, Usuario usuario) {
		Usuario response = repository.findById(id).get();
		
		response.setNome(usuario.getNome());
		response.setEmail(usuario.getEmail());
		response.setSenha(usuario.getSenha());
		
		repository.save(response);
		return "usuario editado com sucesso";
	}
	
	public void excluirUsuario(Integer id) {
		Usuario response = repository.findById(id).get();
		repository.delete(response);
		
	}

}