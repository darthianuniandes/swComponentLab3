/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import com.losalpes.excepciones.OperacionInvalidaException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author darthian
 */
@Stateful
public class ServicioCatalogoMock implements IServicioCatalogoMockLocal, IServicioCatalogoMockRemote {

    @EJB
    private IServicioPersistenciaMockLocal persistencia;
    
    public ServicioCatalogoMock() {
    }

    @Override
    public void agregarMueble(Mueble mueble) throws OperacionInvalidaException {
        try
        {
            persistencia.create(mueble);
        }
        catch (OperacionInvalidaException ex)
        {
            throw new OperacionInvalidaException(ex.getMessage());
        }
    }

    @Override
    public void eliminarMueble(long id) throws OperacionInvalidaException {
        Mueble m = (Mueble) persistencia.findById(Mueble.class, id);
        try
        {
            persistencia.delete(m);
        } catch (OperacionInvalidaException ex)
        {
            throw new OperacionInvalidaException(ex.getMessage());
        }
    }

    @Override
    public List<Mueble> darMuebles() {
        return persistencia.findAll(Mueble.class);
    }

    @Override
    public void removerEjemplarMueble(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
