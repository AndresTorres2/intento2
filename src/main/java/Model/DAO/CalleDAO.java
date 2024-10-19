package Model.DAO;

import Model.Entity.Calle;
import Model.Entity.Ruta;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class CalleDAO extends GenericDAO {
    public List<Calle> obtenerCallesPorRutaId(int rutaId) {
        List<Calle> calles = new ArrayList<>();
        try {
            String sql = "SELECT c.id, c.nombre " +
                    "FROM rutas_calles rc " +
                    "JOIN calles c ON rc.calleId = c.id " +
                    "WHERE rc.rutaId = :rutaId";

            Query query = em.createNativeQuery(sql);
            query.setParameter("rutaId", rutaId);

            List<Object[]> resultList = query.getResultList();

            for (Object[] result : resultList) {
                Calle calle = new Calle();
                calle.setId((Integer) result[0]);
                calle.setNombre((String) result[1]);
                calles.add(calle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calles;
    }

    public List<Object[]> obtenerCallesYCoordenadasPorRutaId(int rutaId) {
        List<Object[]> callesConCoordenadas = new ArrayList<>();
        try {
            String sql = "SELECT c.id, c.nombre, u.latitud, u.longitud " +
                    "FROM rutas_calles rc " +
                    "JOIN calles c ON rc.calleId = c.id " +
                    "JOIN ubicaciones u ON c.ubicacionId = u.id " +
                    "WHERE rc.rutaId = :rutaId";

            Query query = em.createNativeQuery(sql);
            query.setParameter("rutaId", rutaId);

            List<Object[]> resultList = query.getResultList();
            callesConCoordenadas.addAll(resultList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return callesConCoordenadas;
    }
    public List<Calle> obtenerTodasLasCalles() {
        List<Calle> calles = new ArrayList<>();
        try {

            calles = em.createQuery("SELECT c FROM Calle c", Calle.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calles;
    }
    public Calle obtenerCallePorId(int id) {
        Calle calle = null;
        try {
            beginTransaction();
            TypedQuery<Calle> query = em.createQuery("SELECT c FROM Calle c WHERE c.id = :calleId", Calle.class);
            query.setParameter("calleId", id);

            calle = query.getSingleResult();
            commitTransaction();
        } catch (Exception e) {
            rollbackTransaction();
            e.printStackTrace();
        }
        return calle;
    }

    public List<Calle> obtenerCallesSeleccionadas(String[] callesIds) {
        List<Calle> callesSeleccionadas = new ArrayList<>();

        if (callesIds != null) {
            for (String calleId : callesIds) {
                Calle calle = obtenerCallePorId(Integer.parseInt(calleId));
                if (calle != null) {
                    callesSeleccionadas.add(calle);
                }
            }
        }

        return callesSeleccionadas;
    }

}
