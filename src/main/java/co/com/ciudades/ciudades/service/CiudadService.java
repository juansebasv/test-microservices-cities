package co.com.ciudades.ciudades.service;

import co.com.ciudades.ciudades.dao.CiudadDao;
import co.com.ciudades.ciudades.dto.Ciudad;
import co.com.ciudades.ciudades.repository.ICiudad;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CiudadService implements CiudadDao {

    private ICiudad repo;

    @Autowired
    public CiudadService(ICiudad repo) {
        this.repo = repo;
    }

    @Override
    public List<Ciudad> listCiudades() throws Exception {
        ModelMapper model = new ModelMapper();
        List<Ciudad> result = ((List<co.com.ciudades.ciudades.model.Ciudad>) repo.findAll()).stream().map(var -> {
            Ciudad aux = new Ciudad();
            model.map(var, aux);
            return aux;
        }).collect(Collectors.toList());
        return result;
    }

    @Override
    public Ciudad findCiudadById(String id) throws Exception {
        ModelMapper model = new ModelMapper();
        Optional<co.com.ciudades.ciudades.model.Ciudad> result = repo.findById(Integer.parseInt(id));

        Ciudad aux = new Ciudad();
        model.map(result.get(), aux);
        return aux;
    }

    @Override
    public List<Ciudad> findCiudadByName(String name) throws Exception {
        ModelMapper model = new ModelMapper();
        List<Ciudad> result = ((List<co.com.ciudades.ciudades.model.Ciudad>) repo.findByNameIgnoreCaseOrderByIdCiudadDesc(name)).stream().map(var -> {
            Ciudad aux = new Ciudad();
            model.map(var, aux);
            return aux;
        }).collect(Collectors.toList());
        return result;
    }

    @Override
    public boolean createCiudad(Ciudad ciudad) throws Exception {
        ModelMapper model = new ModelMapper();
        co.com.ciudades.ciudades.model.Ciudad aux = new co.com.ciudades.ciudades.model.Ciudad();
        model.map(ciudad, aux);
        repo.save(aux);
        return true;
    }

    @Override
    public boolean updateCiudad(int idCiudad, Ciudad ciudad) throws Exception {
        Optional<co.com.ciudades.ciudades.model.Ciudad> aux = repo.findById(idCiudad);

        if (!aux.isPresent()) return false;

        aux.get().setName(ciudad.getName());
        aux.get().setCapital(ciudad.getCapital());
        aux.get().setFechaFundacion(ciudad.getFechaFundacion());
        repo.save(aux.get());
        return true;
    }

    @Override
    public boolean deleteCiudad(int idCiudad) throws Exception {
        Optional<co.com.ciudades.ciudades.model.Ciudad> aux = repo.findById(idCiudad);

        if (!aux.isPresent()) return false;

        repo.deleteById(idCiudad);
        return true;
    }
}
