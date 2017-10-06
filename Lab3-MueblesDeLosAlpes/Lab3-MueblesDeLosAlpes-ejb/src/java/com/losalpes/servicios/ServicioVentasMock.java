/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.RegistroVenta;
import com.losalpes.excepciones.OperacionInvalidaException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

/**
 *
 * @author darthian
 */
@Stateful
public class ServicioVentasMock implements IServicioVentasMockLocal, IServicioVentasMockRemote {
    
    @EJB
    private IServicioPersistenciaMockLocal persistencia;

    public ServicioVentasMock() {
    }
    
    @Override
    public void agregarRegistroVenta(RegistroVenta registroVenta) throws OperacionInvalidaException {
        try
        {
            persistencia.create(registroVenta);
        }
        catch (OperacionInvalidaException ex)
        {
            throw new OperacionInvalidaException(ex.getMessage());
        }
    }

    @Override
    public void eliminarRegistroVenta(long id) throws OperacionInvalidaException {
        RegistroVenta r = (RegistroVenta) persistencia.findById(RegistroVenta.class, id);
        try
        {
            persistencia.delete(r);
        } catch (OperacionInvalidaException ex)
        {
            throw new OperacionInvalidaException(ex.getMessage());
        }
    }

    @Override
    public List<RegistroVenta> darRegistroVenta() {
        System.out.println("servicio:"+persistencia.findAll(RegistroVenta.class).size());
        return persistencia.findAll(RegistroVenta.class);
    }

     

}
