package Model.Entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "paradasEstudiante")
public class ParadaEstudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private int id;

    @Id
    @ManyToOne
    @JoinColumn(name = "ubicacionId", nullable = false)
    private Ubicacion ubicacion;

    @Id
    @ManyToOne
    @JoinColumn(name = "viajeId", nullable = false)
    private Viaje viaje;

    public ParadaEstudiante() {
    }

    public ParadaEstudiante(int estudianteId, Ubicacion ubicacion, Viaje viaje) {
        this.id = estudianteId;
        this.ubicacion = ubicacion;
        this.viaje = viaje;
    }

    public void setEstudianteId(int estudianteId) {
        this.id = estudianteId;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public int getEstudianteId() {
        return id;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public Viaje getViaje() {
        return viaje;
    }
}
