package Model.Entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "buses")
public class Bus implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private String busId;

    @Column(name = "capacidad")
    private int capacidad;

    public Bus() {
    }

    public Bus(String id, int capacidad, Conductor conductor) {
        this.busId = id;
        this.capacidad = capacidad;

    }
    public String getBusId() {
        return busId;
    }
    public void setBusId(String busId) {
        this.busId = busId;
    }
    public int getCapacidad() {
        return capacidad;

    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }




}
