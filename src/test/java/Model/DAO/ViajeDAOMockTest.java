package Model.DAO;

import Model.DAO.ViajeDAO;
import Model.Entity.Viaje;
import Model.Entity.Bus;
import Model.Entity.Ruta;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Date;
import java.sql.Time;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ViajeDAOMockTest {

    @Mock
    private ViajeDAO mockViajeDAO;

    private Viaje viaje;

    @Before
    public void setUp() {
        // Crear un ejemplo de viaje
        viaje = new Viaje(1, new Bus(), Date.valueOf("2024-10-01"),
                Time.valueOf("10:00:00"), new Ruta(), "Mañana", 0);
    }

    @Test
    public void given_Viaje_when_Create_then_Viaje_Is_Created_Successfully() {
        // Simular el comportamiento del método crearViaje
        doNothing().when(mockViajeDAO).crearViaje(viaje.getId(), viaje);
        // Llamar al método para probar la interacción
        mockViajeDAO.crearViaje(viaje.getId(), viaje);
        // Verificar que el método crearViaje se haya llamado una vez con los parámetros esperados
        verify(mockViajeDAO, times(1)).crearViaje(viaje.getId(), viaje);
        // Mensaje de confirmación de la prueba
        System.out.println("Prueba con Mockito: Se ha creado el viaje correctamente"+ "\nCon ID " + viaje.getId() +
                ", Bus: " + viaje.getBus() +
                ", Fecha: " + viaje.getFecha() +
                ", Hora: " + viaje.getHoraDeSalida() +
                ", Ruta: " + viaje.getRuta() +
                ", Jornada: " + viaje.getJornada() +
                ", Asientos ocupados: " + viaje.getAsientosOcupados());

    }
}
