import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdaptiveTextSlider extends Application
{
    private Spinner<String> stringSpinner;
    private Text text;
    private Scene scene;
    private Slider fontSlider;
	
	public void start(Stage primaryStage)
	{
		ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("let it go", "do your thing", "better late than never");
        stringSpinner = new Spinner<String>(list);
        stringSpinner.getStyleClass().add(
            Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL);
        
        text = new Text("let it go");
        text.setFont(new Font("Helvetica", 24));
        
        fontSlider = new Slider(12, 36, 12);
        fontSlider.setShowTickMarks(true);
        fontSlider.setPrefWidth(100);
        
        VBox pane = new VBox(stringSpinner, text, fontSlider);
        pane.setStyle("-fx-background-color: skyblue");
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(25);

        scene = new Scene(pane, 400, 500);
        
        stringSpinner.valueProperty().addListener(this::processText);
        
        fontSlider.valueProperty().addListener(this::processFont);
                
        primaryStage.setTitle("Adaptive Text Slider");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public void processText(ObservableValue<? extends String> property,
	        Object oldValue, Object newValue)
	    {
	        text.setText((String) newValue);
	    }
	
	public void processFont(ObservableValue<? extends Number> property,
	        Object oldValue, Object newValue)
	    {
	        text.setFont(new Font((double) newValue));
	    }
	
	public static void main(String[] args) 
	{
		launch(args);
	}

}
