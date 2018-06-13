/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.TaVisitaDAO;
import dao.TbResidenciaDAO;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import pojo.TaVisita;
import pojo.TbResidencia;

/**
 *
 * @author ianmalm
 */
@ManagedBean
@RequestScoped
public class RelVisitasMB {

    private BarChartModel visitasResidencia;
    private BarChartModel visitasData;

    /**
     * Creates a new instance of RelVisitasMB
     */
    public RelVisitasMB() {
        configurarGrafico();
    }

    private void configurarGrafico() {
        visitasResidencia = dados1();

        visitasResidencia.setTitle("Visitas por Residência");
        visitasResidencia.setLegendPosition("ne");

        Axis xAxis1 = visitasResidencia.getAxis(AxisType.X);
        xAxis1.setLabel("Residência");

        Axis yAxis1 = visitasResidencia.getAxis(AxisType.Y);
        yAxis1.setLabel("Visitas");
        
        visitasData = dados2();

        visitasData.setTitle("Visitas por Data");
        visitasData.setLegendPosition("ne");

        Axis xAxis2 = visitasData.getAxis(AxisType.X);
        xAxis2.setLabel("Data");

        Axis yAxis = visitasData.getAxis(AxisType.Y);
        yAxis.setLabel("Visitas");
    }

    private BarChartModel dados1() {
        List<TbResidencia> listaResidencias;
        TbResidenciaDAO resDao = new TbResidenciaDAO();
        listaResidencias = resDao.consultarTodosOrdenado();
        
        List<TaVisita> listaVisitas;
        TaVisitaDAO visDao = new TaVisitaDAO();
        listaVisitas = visDao.consultarTodos();

        BarChartModel modelo = new BarChartModel();

        ChartSeries visitas = new ChartSeries();
        visitas.setLabel("Número de Visitas");

        for (TbResidencia res : listaResidencias) {
            int qtdVisita = 0;
            for (TaVisita vis : listaVisitas) {
                if(res.getTaMoradors().contains(vis.getTaMorador())){
                    qtdVisita++;
                }
            }
            if(qtdVisita > 0){
                visitas.set(res.getDscResidencia(), qtdVisita);
            }
        }

        modelo.addSeries(visitas);

        return modelo;
    }
    
    private BarChartModel dados2() {
        List<TaVisita> listaVisitas;
        TaVisitaDAO visDao = new TaVisitaDAO();
        listaVisitas = visDao.consultarTodos();
        ordenar(listaVisitas);
        
        BarChartModel modelo = new BarChartModel();

        ChartSeries visitas = new ChartSeries();
        visitas.setLabel("Número de Visitas");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = "";
        int qtdVisita = -1;
        for (TaVisita vis : listaVisitas) {
            if(qtdVisita == -1){
                data = sdf.format(vis.getDtaInicioVisita());
                qtdVisita = 1;
            }else if(data.equals(sdf.format(vis.getDtaInicioVisita()))){
                qtdVisita++;
            }else{
                visitas.set(data, qtdVisita);
                data = new String(sdf.format(vis.getDtaInicioVisita()));
                qtdVisita = 1;
            }
        }
        if(qtdVisita > 0){
            visitas.set(sdf.format(listaVisitas.get(listaVisitas.size()-1).getDtaInicioVisita()), qtdVisita);
        }
            
        modelo.addSeries(visitas);

        return modelo;
    }

    public void ordenar(List visitaList){
        Collections.sort(visitaList);
    }
    
    /**
     * @return the visitasResidencia
     */
    public BarChartModel getVisitasResidencia() {
        return visitasResidencia;
    }

    /**
     * @param visitasResidencia the visitasResidencia to set
     */
    public void setVisitasResidencia(BarChartModel visitasResidencia) {
        this.visitasResidencia = visitasResidencia;
    }

    public BarChartModel getVisitasData() {
        return visitasData;
    }

    public void setVisitasData(BarChartModel visitasData) {
        this.visitasData = visitasData;
    }

    
    
}
