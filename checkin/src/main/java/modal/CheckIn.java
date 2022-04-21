package modal;

import Event.CheckInCreado;
import lombok.Data;
import util.AggregateRoot;
import java.util.Date;
import java.util.UUID;

@Data
public class CheckIn extends AggregateRoot<UUID> {

    private String CodigoSeguridad;
    private Date HoraCheckIn;
    private Boolean EstadoPaciente;
    private String Descripcion;
    private int Asiento;
    private String Vuelo;
    private String PesoEquipaje;
    private int NumeroEtiqueta;
    private String Abordaje;
    private String Desde;
    private String Hasta;
    private Date Despeje;
    private Date Aterrisaje;
    private String Puerta;

    public CheckIn(String codigoSeguridad,
                   Date horaCheckIn, Boolean estadoPaciente,
                   String descripcion, int asiento, String vuelo,
                   String pesoEquipaje, int numeroEtiqueta, String abordaje,
                   String desde, String hasta, Date despeje, Date aterrisaje, String puerta) {
        key = UUID.randomUUID();
        this.CodigoSeguridad = codigoSeguridad;
        this.HoraCheckIn = horaCheckIn;
        this.EstadoPaciente = estadoPaciente;
        this.Descripcion = descripcion;
        this.Asiento = asiento;
        this.Vuelo = vuelo;
        this.PesoEquipaje = pesoEquipaje;
        this.NumeroEtiqueta = numeroEtiqueta;
        this.Abordaje = abordaje;
        this.Desde = desde;
        this.Hasta = hasta;
        this.Despeje = despeje;
        this.Aterrisaje = aterrisaje;
        this.Puerta = puerta;
    }

    public void checkInCompletado(){
        var event = new CheckInCreado(key, CodigoSeguridad);
        addDomainEvent(event);
    }

}
