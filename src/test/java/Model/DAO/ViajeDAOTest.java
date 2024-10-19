package Model.DAO;

import Model.Entity.Viaje;
import Model.Entity.Bus;
import Model.Entity.Ruta;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.sql.Time;

import static org.junit.Assert.*;

public class ViajeDAOTest {
    ViajeDAO viajeDAO;
    Viaje viaje;

    @Before
    public void setUp() {

        viajeDAO = new ViajeDAO();

        Bus bus = new Bus(); // Crea un objeto Bus de prueba
        Ruta ruta = new Ruta(); // Crea un objeto Ruta de prueba

        viaje = new Viaje();
        viaje.setId(1); // Asigna un ID para el viaje
        viaje.setBus(bus);
        viaje.setRuta(ruta);
        viaje.setFecha(Date.valueOf("2024-10-20")); // Establece una fecha
        viaje.setHoraDeSalida(Time.valueOf("08:00:00")); // Establece una hora de salida
        viaje.setJornada("Mañana");
        viaje.setAsientosOcupados(0);
    }

    @Test
    public void given_Viaje_when_Create_then_Viaje_Is_Created_Successfully() {
        viajeDAO.crearViaje(viaje.getId(), viaje);

        // Verifica que el viaje se haya agregado correctamente
        assertTrue(viajeDAO.existeViaje(viaje.getId()));
        System.out.println("Viaje creado exitosamente con ID: " + viaje.getId());
    }

    @Test
    public void given_Viaje_when_Update_then_Viaje_Is_Updated_Successfully() {
        // Crea un viaje primero
        viajeDAO.crearViaje(viaje.getId(), viaje);

        // Modificar el viaje
        Bus nuevoBus = new Bus(); // Crea un nuevo objeto Bus de prueba
        Ruta nuevaRuta = new Ruta(); // Crea un nuevo objeto Ruta de prueba

        // Aquí puedes configurar el nuevo bus y la nueva ruta

        Viaje nuevoViaje = new Viaje();
        nuevoViaje.setId(viaje.getId()); // Usa el mismo ID para la actualización
        nuevoViaje.setBus(nuevoBus);
        nuevoViaje.setRuta(nuevaRuta);
        nuevoViaje.setFecha(Date.valueOf("2024-10-21")); // Cambia la fecha
        nuevoViaje.setHoraDeSalida(Time.valueOf("09:00:00")); // Cambia la hora de salida
        nuevoViaje.setJornada("Tarde");
        nuevoViaje.setAsientosOcupados(5); // Cambia los asientos ocupados

        // Obtener el viaje antes de la actualización para comparar
        Viaje viajeAnterior = viajeDAO.obtenerViaje(viaje.getId());

        // Actualiza el viaje
        viajeDAO.actualizarViaje(nuevoViaje.getId(), nuevoViaje);

        // Verifica que el viaje se haya actualizado correctamente
        Viaje actualizado = viajeDAO.obtenerViaje(nuevoViaje.getId());
        assertEquals("Tarde", actualizado.getJornada());
        assertEquals(Time.valueOf("09:00:00"), actualizado.getHoraDeSalida());
        assertEquals(Date.valueOf("2024-10-21"), actualizado.getFecha());
        assertEquals(5, actualizado.getAsientosOcupados());

        // Mensaje con información antes y después de la actualización
        System.out.println("Viaje actualizado exitosamente con ID: " + nuevoViaje.getId());
        System.out.println("Antes: Jornada: " + viajeAnterior.getJornada() + ", Hora de Salida: " + viajeAnterior.getHoraDeSalida() +
                ", Fecha: " + viajeAnterior.getFecha() + ", Asientos Ocupados: " + viajeAnterior.getAsientosOcupados());
        System.out.println("Ahora: Jornada: " + actualizado.getJornada() + ", Hora de Salida: " + actualizado.getHoraDeSalida() +
                ", Fecha: " + actualizado.getFecha() + ", Asientos Ocupados: " + actualizado.getAsientosOcupados());
    }

    @Test
    public void given_Viaje_when_Delete_then_Viaje_Is_Deleted_Successfully() {
        // Crea un viaje primero
        viajeDAO.crearViaje(viaje.getId(), viaje);

        // Verifica que el viaje existe antes de eliminarlo
        assertTrue(viajeDAO.existeViaje(viaje.getId()));

        // Elimina el viaje
        viajeDAO.eliminarViaje(viaje.getId());

        // Verifica que el viaje se haya eliminado correctamente
        assertFalse(viajeDAO.existeViaje(viaje.getId()));
        System.out.println("Viaje eliminado exitosamente con ID: " + viaje.getId());
    }

    @Test
    public void given_Viaje_when_Check_Existence_then_Viaje_Existence_Is_Verified_Successfully() {
        // Verifica que el viaje no exista inicialmente
        assertFalse(viajeDAO.existeViaje(viaje.getId()));

        // Crea un viaje
        viajeDAO.crearViaje(viaje.getId(), viaje);

        // Verifica que el viaje exista después de crearlo
        assertTrue(viajeDAO.existeViaje(viaje.getId()));
        System.out.println("Verificación exitosa: el viaje existe con ID: " + viaje.getId());
    }

}