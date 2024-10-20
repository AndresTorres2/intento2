package Model.DAO;

import Model.Entity.Bus;
import Model.Entity.Conductor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BusDAOTest {
    BusDAO busDAO;
    @Before
    public void setUp(){
        busDAO = new BusDAO();
    }

    @Test
    public void given_Bus_when_Create_then_Bus_Is_Create_Successfully() {

        Conductor conductor = new Conductor( 1, "Juan", "Perez",
                "juanp@example.com", "0978648475", "123456789");

        Bus expectedBus = new Bus("1", 40, conductor);
        Bus resultBus = busDAO.createBus("1", 40, conductor);
        //assertEquals(expectedBus,resultBus);
        assertNotNull(resultBus);
        assertEquals(expectedBus.getBusId(), resultBus.getBusId());
        assertEquals(expectedBus.getCapacidad(), resultBus.getCapacidad());
        assertEquals(expectedBus.getConductor().getId(), resultBus.getConductor().getId());
        assertEquals(expectedBus.getConductor().getNombre(), resultBus.getConductor().getNombre());
        assertEquals(expectedBus.getConductor().getEmail(), resultBus.getConductor().getEmail());
    }

    @Test
    public void given_Bus_when_Delete_then_Bus_Is_Delete_Successfully(){
        Conductor conductor = new Conductor( 2, "Pepe", "Perez",
                "juanp@example.com", "0978648475", "123456789");
        busDAO.createBus("2", 40, conductor);
        Bus expectedBus = busDAO.deleteBus("2");
        assertNotNull(expectedBus);
        assertEquals("2", expectedBus.getBusId());

        Bus resultBus = busDAO.findBusById("2");
        assertNull(resultBus);
    }
}
