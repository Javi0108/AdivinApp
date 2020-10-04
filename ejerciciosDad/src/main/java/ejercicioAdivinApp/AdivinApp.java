package ejercicioAdivinApp;

import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AdivinApp extends Application {

	private Label comprobarLabel;
	private Button comprobarButton;
	private TextField nombreText;
	Random r = new Random();
	int adivinar = (int) Math.floor(Math.random()* 100) + 1;
	int contador = 0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		// Creamos un cuadro de texto
		nombreText = new TextField();
		nombreText.setPrefColumnCount(5);
		nombreText.setMaxWidth(100);// Establecemos el tamaño máximo del componente

		// Creamos una etiqueta
		comprobarLabel = new Label();
		comprobarLabel.setText("Introduce un número del 1 al 100");

		// Creamos un botón
		comprobarButton = new Button();
		comprobarButton.setText("Comprobar");
		comprobarButton.setOnAction(numIN -> onComprobarButtonAction(numIN));
		comprobarButton.setDefaultButton(true);
		contador++;

		// Creamos un panel con disposición vertical
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(comprobarLabel, nombreText, comprobarButton);

		// Creamos la escena
		Scene escena = new Scene(root, 320, 200);

		// Configuramos la ventana y le ponemos una escena
		primaryStage.setScene(escena);
		primaryStage.setTitle("AdivinApp");
		primaryStage.show();

	}
	
	public void onComprobarButtonAction(ActionEvent numIN) {	
		
		int pasarInt = Integer.parseInt(nombreText.getText());
		
		 if(pasarInt > 100){
			Alert alert4 = new Alert(AlertType.ERROR);
			alert4.setTitle("AdivinApp");
			alert4.setHeaderText("Error");
			alert4.setContentText("El número introducido no es válido");
			alert4.showAndWait();
		} else if(pasarInt < 0){
			Alert alert4 = new Alert(AlertType.ERROR);
			alert4.setTitle("AdivinApp");
			alert4.setHeaderText("Error");
			alert4.setContentText("El número introducido no es válido");
			alert4.showAndWait();
		} else if (adivinar > pasarInt) {
			Alert alert1 = new Alert(AlertType.WARNING);
			alert1.setTitle("AdivinApp");
			alert1.setHeaderText("¡Has Fallado!");
			alert1.setContentText("El número a adivinar es más grande que "+ pasarInt+ ".\nVuelve a intentarlo.");
			alert1.showAndWait();
			contador++;
		} else if (adivinar < pasarInt) {
			Alert alert2 = new Alert(AlertType.WARNING);
			alert2.setTitle("AdivinApp");
			alert2.setHeaderText("¡Has Fallado!");
			alert2.setContentText("El número a adivinar es más pequeño que " + pasarInt+ ".\nVuelve a intentarlo.");
			alert2.showAndWait();
			contador++;
		} else if(adivinar == pasarInt){
			Alert alert3 = new Alert(AlertType.INFORMATION);
			alert3.setTitle("AdvinApp");
			alert3.setHeaderText("¡Has Ganado!");
			alert3.setContentText("Solo has necesitado " + contador + " intentos.\nVuelve a jugar y hazlo mejor.");
			alert3.showAndWait();
		}
	}

	

	public static void main(String[] args) {
		launch(args);
	}
}
