package Model.DAO;

import Model.Entity.Bus;
import Model.Entity.Conductor;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BusDAO extends GenericDAO {

    private static Map<String, Bus> busDatabse = new HashMap<>();

    public Bus createBus(String id, int capacidad, Conductor conductor) {
        busDatabse.put(id, new Bus(id, capacidad, conductor));
        return busDatabse.get(id);
    }

    public Bus deleteBus(String id) {
        return busDatabse.remove(id);
    }

    public Bus findBusById(String id) {
        return busDatabse.get(id);
    }

//implementacion con la DB
    public BusDAO() {
        super();
    }

    // Método para crear un nuevo Bus en la base de datos
    public void crearBusEnDB(Bus bus) {
        try {
            beginTransaction();
            em.persist(bus);
            commitTransaction();
        } catch (Exception e) {
            rollbackTransaction();
            e.printStackTrace();
        }
    }

    // Método para verificar si un Bus existe en la base de datos por su ID
    public boolean existeBusEnDB(int id) {
        return em.find(Bus.class, id) != null;
    }

    // Método para obtener un Bus de la base de datos por su ID
    public Bus obtenerBusPorId(int id) {
        Bus bus = null;
        try {
            bus = em.find(Bus.class, id);
            if (bus != null) {
                em.refresh(bus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bus;
    }

    // Método para actualizar un Bus en la base de datos
    public void actualizarBusEnDB(Bus bus) {
        try {
            beginTransaction();
            em.merge(bus);
            commitTransaction();
        } catch (Exception e) {
            rollbackTransaction();
            e.printStackTrace();
        }
    }

    // Método para eliminar un Bus de la base de datos por su ID
    public void eliminarBusEnDB(int id) {
        try {
            Bus bus = em.find(Bus.class, id);
            if (bus != null) {
                beginTransaction();
                em.remove(bus);
                commitTransaction();
            }
        } catch (Exception e) {
            rollbackTransaction();
            e.printStackTrace();
        }
    }

    // Método para obtener todos los Buses de la base de datos
    public List<Bus> obtenerTodosLosBuses() {
        List<Bus> buses = new ArrayList<>();
        try {
            buses = em.createQuery("SELECT b FROM Bus b", Bus.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buses;
    }

}
