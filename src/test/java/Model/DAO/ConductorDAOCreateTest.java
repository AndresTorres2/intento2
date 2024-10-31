package Model.DAO;

import Model.Entity.Conductor;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConductorDAOCreateTest {

    private ConductorDAO conductorDAO;
    private Conductor conductor;

    @Test
    public void given_Conductor_when_Create_then_SuccessfullyStored() {
        conductorDAO = new ConductorDAO();
        conductor = new Conductor(1, "Cristian", "Hernandez", "andres@gmail.com",
                "0991935087", "1234");
        conductorDAO.guardarConductor(conductor);

        Conductor conductorGuardado = conductorDAO.buscarPorId(String.valueOf(conductor.getId()));

        assertEquals(0, conductorGuardado.getId());

        System.out.println("ID del conductor esperado: " + "0");
        System.out.println("ID del conductor guardado: " + conductorGuardado.getId());
    }

}
