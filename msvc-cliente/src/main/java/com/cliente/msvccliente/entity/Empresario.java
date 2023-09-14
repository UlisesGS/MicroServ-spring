package com.cliente.msvccliente.entity;

import com.cliente.msvccliente.enumeraciones.FormaContratacion;
import com.cliente.msvccliente.enumeraciones.TipoEmpresa;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Empresario extends Cliente{

    @Enumerated(value = EnumType.STRING)
    private FormaContratacion formaContratacion1;
    @Enumerated(value = EnumType.STRING)
    private FormaContratacion formaContratacion2;
    private String nombreEmpresa;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaAlta;
    @Enumerated(value = EnumType.STRING)
    private TipoEmpresa tipoEmpresa;

    private Integer empleadoMT;

    private Integer empleadoTC;

    private Boolean registroMercantil;

    private String numeroRegistroMercantil;

    @ManyToOne
    private Actividades ciiu;

}
