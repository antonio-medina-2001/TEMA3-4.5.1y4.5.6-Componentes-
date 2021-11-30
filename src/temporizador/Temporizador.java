/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class Temporizador extends HBox{

    @FXML
    private Label lbTiempo;
    
    private EventHandler<ActionEvent> onFinished;
    private IntegerProperty tiempo = new SimpleIntegerProperty();    
    
    private Timeline timeline;

    
    public Temporizador()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/temporizador/Temporizador.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        try
        {
            fxmlLoader.load();
        }
        catch(IOException exception)
        {
            throw new RuntimeException(exception);
        }
  
    }

    public void iniciar()
    {
        KeyValue kv = new KeyValue(tiempo, 0);
        KeyFrame kf = new KeyFrame(Duration.seconds(tiempo.getValue()), onFinished , kv);
        
        timeline = new Timeline(kf);
                
        // Lo iniciamos
        timeline.play();
        
        lbTiempo.textProperty().bind(tiempo.asString());

    }

    public void setTiempo(int value) {
        tiempo.set(value);
    }

    public void setOnFinished(EventHandler<ActionEvent> onFinished) {
        this.onFinished = onFinished;
    }
    public final ObjectProperty<EventHandler<ActionEvent>> onFinishedProperty() {
     return (ObjectProperty<EventHandler<ActionEvent>>) onFinished;
    }
    public final EventHandler<ActionEvent> getOnFinished() {
        return onFinishedProperty().get();
    }
}
