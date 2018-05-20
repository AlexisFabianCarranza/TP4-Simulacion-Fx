/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.simulacion.fx;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import tp4.simulacion.fx.Class.Evento;
import tp4.simulacion.fx.Class.Simulador;
import tp4.simulacion.fx.Class.VectorEstado;
import tp4.simulacion.fx.Class.VectorEstadoView;

/**
 *
 * @author aleex
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btnParametrizar;
    @FXML
    private TextField txtCantidadSimulacion;
    @FXML
    private TextField txtDesde;
    @FXML
    private TextField txtHasta;
    @FXML
    private Button btnSimular;
    @FXML
    private TableView<VectorEstadoView> tablaVectorEstado;
    @FXML
    private TableColumn<VectorEstadoView, Integer> columnReloj;
    @FXML
    private TableColumn<VectorEstadoView, Double> columnRndDemanda;
    @FXML
    private TableColumn<VectorEstadoView, Integer> columnDemanda;
    @FXML
    private TableColumn<VectorEstadoView, Double> columnRndTiempoEntrega;
    @FXML
    private TableColumn<VectorEstadoView, Integer> columnTiempoEntrega;
    @FXML
    private TableColumn<VectorEstadoView, Double> columnRndDañada;
    @FXML
    private TableColumn<VectorEstadoView, Integer> columnDañada;
    @FXML
    private TableColumn<VectorEstadoView, Integer> columnOrden;
    @FXML
    private TableColumn<VectorEstadoView, Integer> columnLlegadaPedido;
    @FXML
    private TableColumn<VectorEstadoView, Integer> columnStock;
    @FXML
    private TableColumn<VectorEstadoView, Double> columnKm;
    @FXML
    private TableColumn<VectorEstadoView, Double> columnKo;
    @FXML
    private TableColumn<VectorEstadoView, Double> columnKs;
    @FXML
    private TableColumn<VectorEstadoView, Double> columnCt;
    @FXML
    private TableColumn<VectorEstadoView, Double> columnCTA;
    @FXML
    private TableColumn<VectorEstadoView, Integer> columnBiciDañadasAcumuladas;
    @FXML
    private Button btnCostoPromedio;
    @FXML
    private Button btnBicisDañadas;
    
    private Simulador simulador;
    private ObservableList<VectorEstadoView> estados;
    private Boolean simulado = false;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        columnReloj.setCellValueFactory(new PropertyValueFactory<>("reloj"));
        columnRndDemanda.setCellValueFactory(new PropertyValueFactory<>("rndDemanda"));
        columnDemanda.setCellValueFactory(new PropertyValueFactory<>("demanda"));
        columnRndTiempoEntrega.setCellValueFactory(new PropertyValueFactory<>("rndDemora"));
        columnTiempoEntrega.setCellValueFactory(new PropertyValueFactory<>("demora"));
        columnRndDañada.setCellValueFactory(new PropertyValueFactory<>("rndBiciDañada"));
        columnDañada.setCellValueFactory(new PropertyValueFactory<>("biciDañada"));
        columnOrden.setCellValueFactory(new PropertyValueFactory<>("orden"));
        columnLlegadaPedido.setCellValueFactory(new PropertyValueFactory<>("llegadaPedido"));
        columnStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        columnKm.setCellValueFactory(new PropertyValueFactory<>("km"));
        columnKs.setCellValueFactory(new PropertyValueFactory<>("ks"));
        columnKo.setCellValueFactory(new PropertyValueFactory<>("ko"));
        columnCt.setCellValueFactory(new PropertyValueFactory<>("kt"));
        columnCTA.setCellValueFactory(new PropertyValueFactory<>("kta"));
        columnBiciDañadasAcumuladas.setCellValueFactory(new PropertyValueFactory<>("bda"));
        
        
    }    

    @FXML
    private void btnSimularClick(ActionEvent event) {
        
        double probabilidades[] = new double[4];
        probabilidades[0] = 0.5;
        probabilidades[1] = 0.15;
        probabilidades[2] = 0.25;
        probabilidades[3] = 0.1;

        ArrayList rs = new ArrayList();
        rs.add(0);
        rs.add(1);
        rs.add(2);
        rs.add(3);

        Evento demanda = new Evento(probabilidades, rs);

        probabilidades = new double[3];
        probabilidades[0] = 0.3;
        probabilidades[1] = 0.4;
        probabilidades[2] = 0.3;

        rs = new ArrayList();
        rs.add(1);
        rs.add(2);
        rs.add(3);

        Evento demora = new Evento(probabilidades, rs);

        probabilidades = new double[2];
        probabilidades[0] = 0.7;
        probabilidades[1] = 0.3;

        rs = new ArrayList();
        rs.add(0);
        rs.add(1);

        Evento biciDañada = new Evento(probabilidades, rs);
        
        int cantidadSimulaciones, desde, hasta;
        
        
        try {
            cantidadSimulaciones = Integer.valueOf(this.txtCantidadSimulacion.textProperty().get());
            desde = Integer.valueOf(this.txtDesde.textProperty().get());
            hasta = Integer.valueOf(this.txtHasta.textProperty().get());
            
        }
        catch (NumberFormatException e){
            Alert dialog = new Alert(AlertType.INFORMATION);
            dialog.setTitle("ERROR");
            dialog.setHeaderText("Los campos deben estár completos y ser de valores numéricos enteros");
            dialog.showAndWait();
            return;
        }
        
        if (cantidadSimulaciones <= 0) {
            Alert dialog = new Alert(AlertType.INFORMATION);
            dialog.setTitle("ERROR");
            dialog.setHeaderText("La cantidad de simulaciones debe ser mayor o igual a 1");
            dialog.showAndWait();
            return;
        }
        
        if (desde >= hasta ) {
            Alert dialog = new Alert(AlertType.INFORMATION);
            dialog.setTitle("ERROR");
            dialog.setHeaderText("El valor de 'Desde' debe ser menor que el valor de 'Hasta'");
            dialog.showAndWait();
            return;
        }
        
        if (desde < 0 || hasta < 0) {
            Alert dialog = new Alert(AlertType.INFORMATION);
            dialog.setTitle("ERROR");
            dialog.setHeaderText("No pueden cargarse valores negativos");
            dialog.showAndWait();
            return;
        }
        
        
        simulador = new Simulador(demanda, demora, biciDañada, desde, hasta);

        for (int i = 0; i < cantidadSimulaciones; i++) {
            simulador.simular();
        }
        
        estados = simulador.estadosDeseados();
        
        
        this.tablaVectorEstado.setItems(estados);
        
        this.simulado = true;
        
        Alert dialog = new Alert(AlertType.INFORMATION);
        dialog.setTitle("FINALIZADA");
        dialog.setHeaderText("La simulación ha finalizado con éxito");
        dialog.showAndWait();
    
    
    
    }

    @FXML
    private void btnCostoPromedioClick(ActionEvent event) {
        
        if (!simulado) {
            Alert dialog = new Alert(AlertType.INFORMATION);
            dialog.setTitle("ERROR");
            dialog.setHeaderText("Primero debe ejecutar una simulación");
            dialog.showAndWait();
            return;
        }
        
        double costoPromedio = this.simulador.costoPromedio();
        
        Alert dialog = new Alert(AlertType.INFORMATION);
        dialog.setHeaderText("El costo promedio semanal es de " + costoPromedio + "$");
        dialog.showAndWait();
        
    }

    @FXML
    private void btnBicisDañadasClick(ActionEvent event) {
        
        if (!simulado) {
            Alert dialog = new Alert(AlertType.INFORMATION);
            dialog.setTitle("ERROR");
            dialog.setHeaderText("Primero debe ejecutar una simulación");
            dialog.showAndWait();
            return;
        }
        
        int bicisDañadas = this.simulador.cantidadBicisDañadas();
        
        Alert dialog = new Alert(AlertType.INFORMATION);
        dialog.setHeaderText("La cantidad de bicis dañadas en el total de pedidos es de " + bicisDañadas);
        dialog.setTitle("BIcicletas dañadas");
        dialog.showAndWait();
        
        
    }
    
}
