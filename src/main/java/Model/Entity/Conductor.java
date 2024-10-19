package Model.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("U_Conductor")
public class Conductor extends  Usuario{

    private static final long serialVersionUID = 1L;

    // Constructor que usa el constructor de Usuario
    public Conductor(int id, String nombre, String apellido, String email, String phone, String contrasena) {
        super(id, nombre, apellido, email, phone, contrasena);  // Llama al constructor de la clase padre (Usuario)
    }

    public Conductor() {
        super();
    }
}
