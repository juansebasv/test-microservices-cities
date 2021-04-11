package co.com.ciudades.ciudades.controller;

import co.com.ciudades.ciudades.dto.Ciudad;
import co.com.ciudades.ciudades.service.CiudadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/juan")
public class CiudadController {

    @Autowired
    private final CiudadService service;

    @GetMapping("/ciudades")
    public ResponseEntity<List<Ciudad>> listCiudades() {
        try {
            List<Ciudad> result = service.listCiudades();

            if (result.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ciudades/{id}")
    public ResponseEntity<Ciudad> findCiudadById(@PathVariable("id") String id) {
        try {
            Ciudad result = service.findCiudadById(id);

            if (result == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ciudadesName/{name}")
    public ResponseEntity<List<Ciudad>> findCiudadByname(@PathVariable("name") String name) {
        try {
            List<Ciudad> result = service.findCiudadByName(name);

            if (result.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<String> createCiudad(@RequestBody(required = true) Ciudad ciudad) {
        try {
            boolean result = service.createCiudad(ciudad);
            return new ResponseEntity<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/ciudades/{id}")
    public ResponseEntity<String> updateCiudad(@PathVariable("id") int id, @RequestBody(required = true) Ciudad ciudad) {
        try {
            boolean result = service.updateCiudad(id, ciudad);
            if (!result) return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/ciudades/{id}")
    public ResponseEntity<String> deleteCiudad(@PathVariable("id") int idCiudad) {
        try {
            boolean result = service.deleteCiudad(idCiudad);

            if (!result) return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(),HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
