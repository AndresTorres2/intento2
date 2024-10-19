package Model.DAO;

import Model.Entity.Conductor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConductorDAODeleteTest {

    private ConductorDAO conductorDAO;
    private Conductor conductor;

    @Before
    public void setUp() {
        conductorDAO = new ConductorDAO();
        conductor = new Conductor(0, "Cristian", "Hernandez", "andres@gmail.com", "0991935087", "1234");
        conductorDAO.guardarConductor(conductor);

    }

    @Test
    public void given_Conductor_when_Delete_then_RemovedSuccessfully() {
        conductorDAO.eliminarConductor(conductor.getId());
        Conductor conductorEliminado = conductorDAO.buscarPorId(conductor.getId());

        assertNull("El conductor ha sido eliminado correctamente.", conductorEliminado);
    }

}