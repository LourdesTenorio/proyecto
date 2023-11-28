
package com.cibertec.Proyecto.McDonalds.ApiVentas.exception;


public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message){
        super(message);
    }
}
