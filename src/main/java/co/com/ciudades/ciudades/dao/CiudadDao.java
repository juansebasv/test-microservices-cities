package co.com.ciudades.ciudades.dao;

import co.com.ciudades.ciudades.dto.Ciudad;

import java.util.List;

public interface CiudadDao {

    public List<Ciudad> listCiudades() throws Exception;

    public Ciudad findCiudadById(String id) throws Exception;

    public List<Ciudad> findCiudadByName(String name) throws Exception;

    public boolean createCiudad(Ciudad ciudad) throws Exception;

    public boolean updateCiudad(int idCiudad, Ciudad ciudad) throws Exception;

    public boolean deleteCiudad(int idCiudad) throws Exception;
}
