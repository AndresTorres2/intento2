package Model.DAO;

import Model.Entity.Conductor;

import java.util.HashMap;
import java.util.Map;

public class ConductorDAO extends GenericDAO{

    private static Map<Integer, Conductor> conductores = new HashMap<>();

    // < 0  (0, "Cristian", "Hernandez", "andres@gmail.com", "0991935087", "1234")  >

    public void guardarConductor(Conductor conductor) {
        conductores.put(conductor.getId(), conductor);
    }

    public void eliminarConductor(int id) {
        conductores.remove(id);
    }
//    public void actualizarConductor(int id, Conductor nuevoConductor) {
//        conductores.put(id, nuevoConductor);
//    }
    public Conductor buscarPorId(int id) {
        return conductores.get(id);
    }


}
