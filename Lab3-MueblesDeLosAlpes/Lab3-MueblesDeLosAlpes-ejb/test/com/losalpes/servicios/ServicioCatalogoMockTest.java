/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import java.util.Properties;
import javax.naming.InitialContext;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author darthian
 */
public class ServicioCatalogoMockTest {
    
    private IServicioCatalogoMockRemote servicio;
    
    @Before
    public void setUp() throws Exception
    {
        try
        {
            Properties env = new Properties();
            env.put("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            env.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            env.put("org.omg.CORBA.ORBInitialPort", "3700");
            InitialContext contexto;
            contexto = new InitialContext(env);
            servicio = (IServicioCatalogoMockRemote) contexto.lookup("com.losalpes.servicios.IServicioCatalogoMockRemote");
        } 
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }
    
    @Test
    public void testAgregarMueble() throws Exception
    {
        Mueble mueble = null;
        servicio.agregarMueble(mueble);
    }
    
    @Test
    public void testEliminarMueble() throws Exception
    {
        servicio.eliminarMueble(1L);
    }
}
