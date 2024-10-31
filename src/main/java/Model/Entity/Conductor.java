package Model.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("U_Conductor")
public class Conductor extends  Usuario{

    private static final long serialVersionUID = 1L;


    public Conductor(int id, String nombre, String apellido, String email, String phone, String contrasena) {
        super(id, nombre, apellido, email, phone, contrasena);
    }

    public Conductor() {
        super();
    }
}
