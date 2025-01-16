package org.example.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAGAMENTO")
    private Long idPagamento;

    @Column(name = "TIPO_PAG")
    private String tipoPag;

    @Column(name = "DATA_PAG")
    private Date dataPag;

    @Column(name = "VALOR_PAG")
    private Float valorPag;

    public Pagamento(){

    }

    public Pagamento(Long idPagamento, String tipoPag, Date dataPag, Float valorPag){
        this.idPagamento = idPagamento;
        this.tipoPag = tipoPag;
        this.dataPag = dataPag;
        this.valorPag = valorPag;
    }

    public Long getIdPagamento(){return idPagamento;}

    public void setIdPagamento(Long idPagamento){this.idPagamento = idPagamento;}

    public String getTipoPag(){return tipoPag;}

    public void setTipoPag(){this.tipoPag = tipoPag;}

    public Date getDataPag(){return dataPag;}

    public void setDataPag(Date dataPag) {this.dataPag = dataPag;}

    public Float getValorPag(){return valorPag;}

    public void setValorPag(Float valorPag) {this.valorPag = valorPag;}
}
