package br.com.senac.siscomee.model.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.siscomee.model.entidades.Categorias;

@Repository
public interface CategoriaRepository extends JpaRepository<Categorias, Integer> {

        Page<Categorias> findAll(Pageable pageable);
        
        List<Categorias> findByNmCategoria(String nmCategoria);

       
        Page<Categorias> findByInAtivo(short inAtivo, Pageable paging);

       
        Page<Categorias> findByInAtivoAndNmCategoriaContaining(short inAtivo, String nmCategoria, Pageable paging);

        
        Page<Categorias> findByNmCategoriaContaining(String nmCategoria, Pageable paging);


}
