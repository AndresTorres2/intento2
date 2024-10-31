package Model.DAO;

import Model.Entity.Estudiante;
import Model.Entity.Usuario;
import jakarta.persistence.Query;

import java.util.List;

public class EstudianteDAO extends GenericDAO {


    public Estudiante obtenerEstudiantePorId(int idEstudiante) {
        return em.find(Estudiante.class, idEstudiante);
    }

    public List<Usuario> obtenerEstudiantes() {
        String jpql = "SELECT u FROM Usuario u WHERE TYPE(u) = Estudiante";
        return em.createQuery(jpql, Usuario.class).getResultList();
    }


}
