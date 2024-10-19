package Model.Entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("U_Administrador")
public class Administrador extends Usuario {

    private static final long serialVersionUID = 1L;
    public Administrador() {
        super();
    }


}
