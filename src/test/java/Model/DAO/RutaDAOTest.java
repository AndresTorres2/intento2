package Model.DAO;

import Model.Entity.Ruta;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RutaDAOTest {
    RutaDAO rutaDAO ;
    @Before
    public void setUp()  {
        Ruta ruta =  new Ruta(1,"Ciudad A", "Ciudad B", null);
        rutaDAO = new RutaDAO();
        rutaDAO.guardarRuta(ruta);
    }
    @Test
    public void given_Ruta_when_Delete_then_Ruta_Is_Delete_Successfully() {
        rutaDAO.eliminarRuta(1);
        boolean resultado = rutaDAO.existeRuta(1);
        if(resultado){
            System.out.println("No se elimino la ruta prueba fallida");
        }
        else {
            System.out.println("Se elimino la ruta");
        }
        assertFalse(resultado);


    }
    @Test
    public void given_Ruta_when_Update_then_Ruta_Is_Updated_Successfully() {
        Ruta rutaActualizada = new Ruta(1, "Ciudad X", "Ciudad Y", null);
        Ruta  rutaAnterior =  rutaDAO.obtenerRuta(1);
        rutaDAO.actualizarRuta(1, rutaActualizada);

        Ruta rutaObtenida = rutaDAO.obtenerRuta(1);
        System.out.println("Ruta Anterior: " + rutaAnterior.toString());
        System.out.println("Ruta Actualizada: "+rutaObtenida.toString());
        assertEquals("Ciudad X", rutaObtenida.getOrigen());
        assertEquals("Ciudad Y", rutaObtenida.getDestino());

    }
}