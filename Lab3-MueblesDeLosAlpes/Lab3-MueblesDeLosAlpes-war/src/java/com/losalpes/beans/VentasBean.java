/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.entities.RegistroVenta;
import com.losalpes.servicios.IServicioVentasMockLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author darthian
 */
public class VentasBean implements Serializable {
    
    private List<RegistroVenta> ventas;
    
    @EJB
    private IServicioVentasMockLocal servicioVentas;

    public VentasBean() {
        this.ventas = servicioVentas.darRegistroVenta();
        System.out.println("constructor lista: "+this.ventas.size());
    }
    
    @PostConstruct
    public void init() {
        this.ventas = servicioVentas.darRegistroVenta();
        System.out.println("lista: "+this.ventas.size());
    }

    public List<RegistroVenta> getVentas() {
        return servicioVentas.darRegistroVenta();
    }

    public void setVentas(List<RegistroVenta> ventas) {
        this.ventas = ventas;
    }
}
