package springboot.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.springboot.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository< Usuario, Integer>{
	


}