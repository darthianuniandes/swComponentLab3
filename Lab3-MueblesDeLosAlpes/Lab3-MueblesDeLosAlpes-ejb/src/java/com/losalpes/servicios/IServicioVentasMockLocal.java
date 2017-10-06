/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.RegistroVenta;
import com.losalpes.excepciones.OperacionInvalidaException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author darthian
 */
@Local
public interface IServicioVentasMockLocal {
    
    /**
     * Agrega un registroVenta al sistema
     * @param registroVenta nuevo registroVenta
     */
    public void agregarRegistroVenta(RegistroVenta registroVenta) throws OperacionInvalidaException;

    /**
     * Elimina un registroVenta del sistema
     * @param id Identificador único del registroVenta a eliminar
     */
    public void eliminarRegistroVenta(long id) throws OperacionInvalidaException;

    /**
     * Devuelve todos los RegistroVenta del sistema
     * @return List<RegistroVenta> Lista de RegistroVenta
     */
    public List<RegistroVenta> darRegistroVenta();
}
