package co.com.ciudades.ciudades.repository;

import co.com.ciudades.ciudades.model.Ciudad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICiudad extends CrudRepository<Ciudad, Integer> {

    public List<Ciudad> findByNameIgnoreCaseOrderByIdCiudadDesc(String name);

}
