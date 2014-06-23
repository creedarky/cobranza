package cl.acaya.api.enums;

/**
 * Created by mcastro on 22-06-14.
 */
public enum EtapasDocumentoType {

    DESPACHADO("Despachado",1l), VALIDADO("Validado", 2l), AGENDADO("Agendado",3l),
    RECAUDADO("Recaudado",4l), CONTIGENCIA("Contingencia",5l);

    private String label;
    private Long idTabla;
    EtapasDocumentoType(String label, Long idTabla) {
        this.label = label;
        this.idTabla = idTabla;
    }

    public String getLabel() {
        return label;
    }
}
