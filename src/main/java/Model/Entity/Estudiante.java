package Model.Entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("U_Estudiante")
public class Estudiante extends Usuario {

    private static final long serialVersionUID = 1L;

    public Estudiante() {
    }


}
