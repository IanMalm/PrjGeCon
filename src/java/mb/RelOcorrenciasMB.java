/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.TbOcorrenciaDAO;
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
import pojo.TbOcorrencia;
import pojo.TbResidencia;

/**
 *
 * @author ianmalm
 */
@ManagedBean
@RequestScoped
public class RelOcorrenciasMB {

    private BarChartModel ocorrenciasResidencia;
    private BarChartModel ocorrenciasData;

    /**
     * Creates a new instance of RelOcorrenciasMB
     */
    public RelOcorrenciasMB() {
        configurarGrafico();
    }

    private void configurarGrafico() {
        ocorrenciasResidencia = dados1();

        ocorrenciasResidencia.setTitle("Ocorrências por Residência");
        ocorrenciasResidencia.setLegendPosition("ne");

        Axis xAxis1 = ocorrenciasResidencia.getAxis(AxisType.X);
        xAxis1.setLabel("Residência");

        Axis yAxis1 = ocorrenciasResidencia.getAxis(AxisType.Y);
        yAxis1.setLabel("Ocorrências");
        
        ocorrenciasData = dados2();

        ocorrenciasData.setTitle("Ocorrências por Data");
        ocorrenciasData.setLegendPosition("ne");

        Axis xAxis2 = ocorrenciasData.getAxis(AxisType.X);
        xAxis2.setLabel("Data");

        Axis yAxis = ocorrenciasData.getAxis(AxisType.Y);
        yAxis.setLabel("Ocorrências");
    }

    private BarChartModel dados1() {
        List<TbResidencia> listaResidencias;
        TbResidenciaDAO resDao = new TbResidenciaDAO();
        listaResidencias = resDao.consultarTodosOrdenado();
        
        List<TbOcorrencia> listaOcorrencias;
        TbOcorrenciaDAO ocoDao = new TbOcorrenciaDAO();
        listaOcorrencias = ocoDao.consultarTodos();

        BarChartModel modelo = new BarChartModel();

        ChartSeries ocorrencias = new ChartSeries();
        ocorrencias.setLabel("Número de Ocorrências");

        for (TbResidencia res : listaResidencias) {
            int qtdOcorrencia = 0;
            for (TbOcorrencia oco : listaOcorrencias) {
                if(res.getTaMoradors().contains(oco.getTaMorador())){
                    qtdOcorrencia++;
                }
            }
            if(qtdOcorrencia > 0){
                ocorrencias.set(res.getDscResidencia(), qtdOcorrencia);
            }
        }

        modelo.addSeries(ocorrencias);

        return modelo;
    }
    
    private BarChartModel dados2() {
        List<TbOcorrencia> listbOcorrencias;
        TbOcorrenciaDAO visDao = new TbOcorrenciaDAO();
        listbOcorrencias = visDao.consultarTodos();
        ordenar(listbOcorrencias);
        
        BarChartModel modelo = new BarChartModel();

        ChartSeries ocorrencias = new ChartSeries();
        ocorrencias.setLabel("Número de Ocorrências");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = "";
        int qtdOcorrencia = -1;
        for (TbOcorrencia oco : listbOcorrencias) {
            if(qtdOcorrencia == -1){
                data = sdf.format(oco.getDtaOcorrencia());
                qtdOcorrencia = 1;
            }else if(data.equals(sdf.format(oco.getDtaOcorrencia()))){
                qtdOcorrencia++;
            }else{
                ocorrencias.set(data, qtdOcorrencia);
                data = new String(sdf.format(oco.getDtaOcorrencia()));
                qtdOcorrencia = 1;
            }
        }
        if(qtdOcorrencia > 0){
            ocorrencias.set(sdf.format(listbOcorrencias.get(listbOcorrencias.size()-1).getDtaOcorrencia()), qtdOcorrencia);
        }
            
        modelo.addSeries(ocorrencias);

        return modelo;
    }

    public void ordenar(List ocorrenciaList){
        Collections.sort(ocorrenciaList);
    }
    
    /**
     * @return the ocorrenciasResidencia
     */
    public BarChartModel getOcorrenciasResidencia() {
        return ocorrenciasResidencia;
    }

    /**
     * @param ocorrenciasResidencia the ocorrenciasResidencia to set
     */
    public void setOcorrenciasResidencia(BarChartModel ocorrenciasResidencia) {
        this.ocorrenciasResidencia = ocorrenciasResidencia;
    }

    public BarChartModel getOcorrenciasData() {
        return ocorrenciasData;
    }

    public void setOcorrenciasData(BarChartModel ocorrenciasData) {
        this.ocorrenciasData = ocorrenciasData;
    }

    
    
}
