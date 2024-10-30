package Model.DAO;

import Model.Entity.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class UsuarioDAOParametersTest {
    private String email;
    private String contrasena;
    private boolean resultadoEsperado;
    private UsuarioDAO usuarioDAO;

    @Before
    public void setUp() {
        usuarioDAO = new UsuarioDAO();
        usuarioDAO.guardarUsuario(new Usuario("3", "Sofia", "Martínez", "gerente@example.com", "09988888", "gerente123"));
        usuarioDAO.guardarUsuario(new Usuario("2", "Carlos", "López", "profesor@example.com", "09999999", "estudiante123"));
        usuarioDAO.guardarUsuario(new Usuario("1", "Eliath", "Velasco", "eliath@example.com", "09999998", "admin123"));
        usuarioDAO.guardarUsuario(new Usuario("4", "Fernando", "García", "administrador@example.com", "09977777", "admin456"));
        usuarioDAO.guardarUsuario(new Usuario("5", "Ana", "Pérez", "administrador@example.com", "09966666", "asisten2123"));
        usuarioDAO.guardarUsuario(new Usuario("6", "Juan", "Rodríguez", "jefe@example.com", "09955555", "jefe123"));
        usuarioDAO.guardarUsuario(new Usuario("7", "Marta", "Santos", "carlos@example.com", "09944444", "testpass"));
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
          {"admin@example.com", "admin123",false},
          {"estudiante@example.com", "estudiante123",false},
          {"gerente@example.com", "gerente123",true},
          {"administrador@example.com", "admin456", true},
          {"administrador@example.com", "asistente123",false},
          {"administrador@example.com", "jefe123",false},
          {"carlos@example.com", "testpass",true}
        });
    }

    public UsuarioDAOParametersTest(String email, String contrasena, boolean resultadoEsperado) {
        this.email = email;
        this.contrasena = contrasena;
        this.resultadoEsperado = resultadoEsperado;
    }

    @Test
    public void given_EmailAndPassword_when_ValidateCredentials_then_ReturnExpectedResult() {
        boolean resultadoObtenido = usuarioDAO.validarCredenciales(email, contrasena);
        assertEquals(resultadoEsperado, resultadoObtenido);
        System.out.println("Email: " + email + ", Contraseña: " + contrasena + " - Resultado esperado: " + resultadoEsperado + ", Resultado obtenido: " + resultadoObtenido);
    }
}
