package Model.DAO;

import Model.Entity.Viaje;
import Model.Entity.Ruta;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ViajeDAO extends GenericDAO{
    public ViajeDAO() {
        super();
    }
    private final HashMap<Integer, Viaje> viajes = new HashMap<>();

    public void crearViaje(Integer id, Viaje viaje) {
        viajes.put(id, viaje);
    }
    public boolean existeViaje(Integer id) {
        return viajes.containsKey(id);
    }
    public void eliminarViaje(Integer id) {
        viajes.remove(id);
    }
    public void actualizarViaje(Integer id, Viaje nuevoViaje) {
        viajes.put(id, nuevoViaje);
    }
    public Viaje obtenerViaje(Integer id) {
        return viajes.get(id);
    }

    public List<Viaje> filtrarPorRuta(Ruta ruta) {
        List<Viaje> viajesFiltrados = new ArrayList<>();

        for (Viaje viaje : viajes.values()) {
            if (viaje.getRuta().equals(ruta)) {
                viajesFiltrados.add(viaje);
            }
        }

        return viajesFiltrados;
    }


    public List<Object[]> listarViajesPorJornada(String jornada) {
        List<Object[]> resultList = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT v.horaDeSalida, r.origen, r.destino, (SELECT GROUP_CONCAT(v2.id)  " +
                    "FROM Viajes v2 WHERE v2.rutaId = v.rutaId AND v2.jornada = :jornada ) AS idViajes " +
                    "FROM Viajes v " +
                    "JOIN Rutas r ON v.rutaId = r.id " +
                    "WHERE v.jornada = :jornada " +
                    "AND v.rutaId IN ( " +
                    "    SELECT DISTINCT rutaId " +
                    "    FROM Viajes " +
                    "    WHERE jornada = :jornada " +
                    ") " +
                    "ORDER BY r.origen, r.destino;";

            Query query = em.createNativeQuery(sql);
            query.setParameter("jornada", jornada);

            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public Viaje obtenerViajePorCodigo(int codigo) {
        try {
            Viaje viaje = em.find(Viaje.class, codigo);
            if (viaje != null) {
                em.refresh(viaje);
            }
            return viaje;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
