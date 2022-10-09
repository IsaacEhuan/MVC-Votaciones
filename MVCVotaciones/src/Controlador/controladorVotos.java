package Controlador;

import Modelo.Producto;
import Modelo.actualizableImp;
import Vista.vistaDocumentoPlano;
import Vista.vistaGraficaBarras;
import Vista.vistaGraficaPastel;
import Vista.vistaPrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author isaac
 */
public class controladorVotos implements ActionListener{
    private actualizableImp actualizable;
    private vistaPrincipal VistaPrincipal;
    //private vistaDocumentoPlano vistaDoc;
    private vistaGraficaPastel vistaGraficaPastel;
    private vistaGraficaBarras vistaGraficabarras;

    public controladorVotos(actualizableImp actualizable, vistaPrincipal VistaPrincipal/*, vistaDocumentoPlano vistaDoc*/, vistaGraficaPastel vistaPastel, vistaGraficaBarras barras) {
        this.actualizable = actualizable;
        this.VistaPrincipal = VistaPrincipal;
        //this.vistaDoc = vistaDoc;
        this.vistaGraficaPastel = vistaPastel;
        this.vistaGraficabarras = barras;
        
        this.VistaPrincipal.getjButton1().addActionListener(this);
        this.VistaPrincipal.getjButton2().addActionListener(this);
        this.VistaPrincipal.getjButton3().addActionListener(this);
            generarGraficaDePastel();
            generarGraficaDeBarras();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(VistaPrincipal.getjButton1()== evento.getSource()){
            actualizable.actualizarProductoUno();
            //vistaDoc.getjTable1().setValueAt(actualizable.getProductoUnoVotos(), 0, 0);
            generarGraficaDePastel();
            generarGraficaDeBarras();
        }
        if(VistaPrincipal.getjButton2()== evento.getSource()){
            actualizable.actualizarProductoDos();
            //vistaDoc.getjTable1().setValueAt(actualizable.getProductoDosVotos(), 0, 1);
            generarGraficaDePastel();
            generarGraficaDeBarras();
        }
        if(VistaPrincipal.getjButton3()== evento.getSource()){
            actualizable.actualizarProductoTres();
            //vistaDoc.getjTable1().setValueAt(actualizable.getProductoTresVotos(), 0, 2);
            generarGraficaDePastel();
            generarGraficaDeBarras();
        }
    }
    
    public void generarGraficaDePastel(){
        Producto[] product = new Producto[3];
        product = actualizable.getProducto();
        
        DefaultPieDataset datosPie = new DefaultPieDataset();
        datosPie.setValue(product[0].getNombreProducto(), product[0].getVotos());
        datosPie.setValue(product[1].getNombreProducto(), product[1].getVotos());
        datosPie.setValue(product[2].getNombreProducto(), product[2].getVotos());
        JFreeChart grafico = ChartFactory.createPieChart("Grafica pastel", datosPie,true ,true, false);
        ChartPanel cPanel = new ChartPanel(grafico);
        grafico.setBackgroundPaint(Color.CYAN);
        vistaGraficaPastel.getjPanel1().removeAll();
        vistaGraficaPastel.getjPanel1().add(cPanel,BorderLayout.CENTER);
        vistaGraficaPastel.getjPanel1().validate();
    }
    
    public void generarGraficaDeBarras(){
        Producto[] product = new Producto[3];
        product = actualizable.getProducto();
        
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        datos.addValue(product[0].getVotos(), "Grafica 1", product[0].getNombreProducto());
        datos.addValue(product[1].getVotos(), "Grafica 1", product[1].getNombreProducto());
        datos.addValue(product[2].getVotos(), "Grafica 1", product[2].getNombreProducto());
        JFreeChart grafico = ChartFactory.createBarChart("Grafica barras","Eje x", "Eje y", datos,PlotOrientation.VERTICAL,true,true,false);
        CategoryPlot plot = (CategoryPlot)grafico.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
	renderer.setSeriesPaint(0, Color.MAGENTA);
        ChartPanel cPanel = new ChartPanel(grafico);
        grafico.setBackgroundPaint(Color.ORANGE);
        vistaGraficabarras.getjPanel2().removeAll();
        vistaGraficabarras.getjPanel2().add(cPanel);
        vistaGraficabarras.getjPanel2().validate();
        
    }
}
