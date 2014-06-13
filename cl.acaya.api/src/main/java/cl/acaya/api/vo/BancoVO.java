package cl.acaya.api.vo;

/**
 * Created by mcastro on 13-06-14.
 */
public class BancoVO {

    private Integer idBanco;
    private String banco;

    public BancoVO() {
    }

    public BancoVO(Integer idBanco, String banco) {
        this.idBanco = idBanco;
        this.banco = banco;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
}
