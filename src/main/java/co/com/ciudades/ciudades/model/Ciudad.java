package co.com.ciudades.ciudades.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Ciudad", schema = "public")
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCiudad;
    @NotNull
    @Size(min = 1, max = 60)
    private String name;
    @NotNull
    @Size(min = 1, max = 60)
    private String capital;
    @Column(name = "fecha")
    private Date fechaFundacion;
}
