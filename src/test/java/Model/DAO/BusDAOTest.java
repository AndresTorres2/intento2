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


        Bus expectedBus = new Bus("1", 40);
        Bus resultBus = busDAO.createBus("1", 40);
        //assertEquals(expectedBus,resultBus);
        assertNotNull(resultBus);
        assertEquals(expectedBus.getBusId(), resultBus.getBusId());
        assertEquals(expectedBus.getCapacidad(), resultBus.getCapacidad());
    }

    @Test
    public void given_Bus_when_Delete_then_Bus_Is_Delete_Successfully(){
        busDAO.createBus("2", 40);
        Bus expectedBus = busDAO.deleteBus("2");
        assertNotNull(expectedBus);
        assertEquals("2", expectedBus.getBusId());

        Bus resultBus = busDAO.findBusById("2");
        assertNull(resultBus);
    }
}
