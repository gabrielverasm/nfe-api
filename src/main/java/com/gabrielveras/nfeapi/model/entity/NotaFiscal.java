package com.gabrielveras.nfeapi.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotEmpty(message = "O Número da nota é obrigatório!")
    @NotNull(message = "O Número da nota é obrigatório!")
    private Integer numeroNota;

    @Column
    @NotEmpty(message = "O estabelecimento é obrigatório!")
    @NotNull(message = "O estabelecimento é obrigatório!")
    private String estabelecimento;

    @Column
    @NotEmpty(message = "O valor total é obrigatório!")
    @NotNull(message = "O valor total é obrigatório!")
    private Double valorTotal;

    @Column(name = "data_emissao", updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy",timezone = "Brazil/East")
    private Date dataEmissao;

    @PrePersist
    public void prePersist() {
        setDataEmissao(new Date());
    }
}

