package Model.DAO;
import Model.Entity.Bus;
import Model.Entity.Conductor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class BusDAOMockTest {

    @Mock
    private BusDAO mockBusDAO;
    private Bus bus;

    @Before
    public void setUp() {
        bus = new Bus("A85", 44);
    }

    @Test
    public void given_Bus_when_Update_then_Bus_Is_Updated_Successfully() {
        Conductor nuevoConductor = new Conductor(1, "Carlos", "Nuñez", "carlos.nuñez@gmail.com", "0963346665", "carlos932");
        String busId = bus.getBusId();
        int nuevaCapacidad = 49;

        doNothing().when(mockBusDAO).actualizarBus(busId, nuevaCapacidad, nuevoConductor);

        mockBusDAO.actualizarBus(busId, nuevaCapacidad, nuevoConductor);

        verify(mockBusDAO, times(1)).actualizarBus(busId, nuevaCapacidad, nuevoConductor);

        bus.setCapacidad(nuevaCapacidad);

        assertEquals(nuevaCapacidad, bus.getCapacidad());

        // Imprime el resultado
        System.out.println("Prueba con Mockito: Se ha actualizado el bus correctamente" +
                "\nBus actualizado: ID: " + bus.getBusId() +
                ", Capacidad: " + bus.getCapacidad());
    }
}
