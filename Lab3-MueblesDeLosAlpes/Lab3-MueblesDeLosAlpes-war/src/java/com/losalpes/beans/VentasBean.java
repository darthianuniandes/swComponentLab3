/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.entities.RegistroVenta;
import com.losalpes.servicios.IServicioVentasMockLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LegendPlacement;

/**
 *
 * @author darthian
 */
@ManagedBean(name = "ventasBean")
@SessionScoped
public class VentasBean implements Serializable {
    
    private List<RegistroVenta> ventas;
    private List<RegistroVenta> ventasOtroMes;
    
    private BarChartModel barModel;
    
    @EJB
    private IServicioVentasMockLocal servicioVentas;

    public VentasBean() {
    }
    
    @PostConstruct
    public void init() {
        this.ventas = servicioVentas.darRegistroVenta();
        this.ventasOtroMes = new ArrayList<RegistroVenta>();
        for(int i = this.ventas.size()-1; i >= 0; i--) {
            this.ventasOtroMes.add(this.ventas.get(i));
        }
        createBarModels();
    }

    private void createBarModels() {
        createBarModel();
    }
    
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Ventas del ultimo mes");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Mueble");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Ventas");
        
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
    
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries mueblesVendidos = new ChartSeries();
        mueblesVendidos.setLabel("Mueble ultimo mes");
        for (RegistroVenta venta : ventas) {
            mueblesVendidos.set(venta.getProducto().getNombre(), venta.getCantidad());
        }
        
        ChartSeries mueblesVendidosOtroMes = new ChartSeries();
        mueblesVendidosOtroMes.setLabel("Mueble mes anterior");
        for (RegistroVenta venta : ventasOtroMes) {
            mueblesVendidosOtroMes.set(venta.getProducto().getNombre(), venta.getCantidad());
        }
 
        model.addSeries(mueblesVendidos);
        model.addSeries(mueblesVendidosOtroMes);
         
        return model;
    }
    
    public List<RegistroVenta> getVentas() {
        return this.ventas;
    }

    public void setVentas(List<RegistroVenta> ventas) {
        this.ventas = ventas;
    }
    
    public BarChartModel getBarModel() {
        return barModel;
    }
}
