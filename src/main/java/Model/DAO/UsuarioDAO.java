package Model.DAO;
import Model.Entity.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioDAO extends GenericDAO{

    public UsuarioDAO() {
        super();
    }

    private static Map<Integer, Usuario> usuarios = new HashMap<>();

    public void guardarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }
    public boolean validarCredenciales(String email, String contrasena) {
        Usuario usuario = buscarUsuarioPorEmail(email);
        if (usuario != null) {
            return usuario.getContrasena().equals(contrasena);
        }
        return false;
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        for (Usuario usuario : usuarios.values()) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }





}
