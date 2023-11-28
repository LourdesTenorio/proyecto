
package com.cibertec.Proyecto.McDonalds.ApiOpiniones.dto;

import lombok.Data;

@Data
public class OpinionDto {
     private Long id;
    private String coment;
    private Long idProduct;
    private Long idCliente;
}
