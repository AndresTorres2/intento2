package Model.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("U_Conductor")
public class Conductor extends  Usuario{

    private static final long serialVersionUID = 1L;


    public Conductor() {
        super();
    }

}
