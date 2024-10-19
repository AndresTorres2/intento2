package Model.Entity;

public class Conductor extends  Usuario{

    private static final long serialVersionUID = 1L;
    public Conductor() {
        super();
    }

    public Conductor(String id, String nombre, String apellido, String email, String phone) {
        super(id, nombre, apellido, email, phone);
    }
}
