package Model.DAO;

import Model.Entity.Calle;
import Model.Entity.Ruta;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class RutaDAOParametersTest {
    private Ruta ruta;
    private Ruta rutaEsperada;

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {
                        1, "Ciudad A", "Ciudad B", null,
                        new Ruta(1, "Ciudad A", "Ciudad B", null)
                },
                {
                        2, "Ciudad C", "Ciudad D", null,
                        new Ruta(2, "Ciudad C", "Ciudad D", null)
                }
        });
    }

    public RutaDAOParametersTest(int id, String origen, String destino, List<Calle> calles, Ruta rutaEsperada) {
        this.ruta = new Ruta(id, origen, destino, calles);
        this.rutaEsperada = rutaEsperada;
    }

    @Test
    public void given_Ruta_when_Save_then_Ruta_Is_Saved_Successfully() {
        RutaDAO rutaDAO = new RutaDAO();
        rutaDAO.guardarRuta(ruta);

        Ruta rutaObtenida = rutaDAO.obtenerRuta(ruta.getId());

        assertEquals(rutaEsperada.getId(), rutaObtenida.getId());
        assertEquals(rutaEsperada.getOrigen(), rutaObtenida.getOrigen());
        assertEquals(rutaEsperada.getDestino(), rutaObtenida.getDestino());
        assertEquals(rutaEsperada.getCalles(), rutaObtenida.getCalles());
        System.out.println("Ruta esperada:" + rutaEsperada.toString());
        System.out.println("Ruta Guardada:" + rutaEsperada.toString());
    }
}
