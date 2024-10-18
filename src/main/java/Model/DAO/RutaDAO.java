package Model.DAO;

import Model.Entity.Ruta;

import java.util.ArrayList;
import java.util.List;

public class RutaDAO extends GenericDAO {

    private static List<Ruta> rutas = new ArrayList<>();

    public void guardarRuta(Ruta ruta) {
        rutas.add(ruta);
    }
    public boolean existeRuta(int id) {

        for (Ruta r : rutas) {
            if (r.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void eliminarRuta(int i) {
        rutas.remove(i);
    }
    public void actualizarRuta(int index, Ruta nuevaRuta) {
            rutas.set(index, nuevaRuta);
    }

    public Ruta obtenerRuta(int i) {
        System.out.println();
        for (Ruta r : rutas) {
            if (r.getId() == i) {
                return r;
            }
        }
        return null;
    }
}
