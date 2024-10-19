package Model.DAO;

import Model.Entity.Ruta;

import java.util.HashMap;
import java.util.Map;

public class RutaDAO extends GenericDAO {

    private static Map<Integer, Ruta> rutas = new HashMap<>();

    public void guardarRuta(Ruta ruta) {
        rutas.put(ruta.getId(), ruta);
    }
    public boolean existeRuta(int id) {

        return rutas.containsKey(id);
    }

    public void eliminarRuta(int id) {
        rutas.remove(id);
    }
    public void actualizarRuta(int id, Ruta nuevaRuta) {
        rutas.put(id, nuevaRuta);
    }

    public Ruta obtenerRuta(int id) {
        return rutas.get(id);
    }
}
