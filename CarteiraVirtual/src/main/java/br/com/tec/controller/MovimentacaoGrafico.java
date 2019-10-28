package br.com.tec.controller;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;


@ManagedBean
@ViewScoped
public class MovimentacaoGrafico implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private BarChartModel barModel;
	
    public BarChartModel getBarModel() {
    	createBarModel();
    	
        return barModel;
    }
    
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries entrada = new ChartSeries();
        entrada.setLabel("Entrada");
        entrada.set("Jan", 120);
        entrada.set("Fev", 100);
        entrada.set("Mar", 44);
        entrada.set("Abr", 150);
        entrada.set("Mai", 25);
 
        ChartSeries saida = new ChartSeries();
        saida.setLabel("Saida");
        saida.set("Jan", 152);
        saida.set("Fev", 60);
        saida.set("Mar", 110);
        saida.set("Abr", 135);
        saida.set("Mai", 120);
 
        model.addSeries(entrada);
        model.addSeries(saida);
 
        return model;
    }
 
    private void createBarModel() {
        barModel = initBarModel();
 
        barModel.setTitle("Movimentações de Entrada");
        barModel.setLegendPosition("L");
 
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("");
 
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }

}
