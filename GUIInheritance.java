import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class GUIInheritance extends Application
{
	private ColorPicker colorPicker;
	private Color color = Color.BLACK;
	private Polyline line = new Polyline();
	
	public void start(Stage primaryStage)
	{
		colorPicker = new ColorPicker(Color.BLACK);
        colorPicker.setOnAction(this::processColorChoice);
        
        Button button = new Button("Clear");
        button.setLayoutX(130);
		button.setLayoutY(0);
		button.setPrefSize(50, 20);
		button.setTextAlignment(TextAlignment.CENTER);
		
		Group root = new Group(button, colorPicker);
		
		Scene scene = new Scene(root, 1000, 600);
		
		scene.setOnMousePressed( event ->
		{
			line = new Polyline();
			line.setStroke(color);
			line.setStrokeWidth(5);
			root.getChildren().add(line);
		});
		
		
		scene.setOnMouseDragged( event ->
		{
			line.getPoints().addAll(new Double[]
				{
					event.getX(), event.getY()
				});
		});
		
		button.setOnMouseClicked( event -> 
		{
			root.getChildren().clear();
			root.getChildren().addAll(button, colorPicker);
		});
		
		primaryStage.setTitle("Paint");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}

	public void processColorChoice(ActionEvent event)
    {
        color = (colorPicker.getValue());
    }
}
