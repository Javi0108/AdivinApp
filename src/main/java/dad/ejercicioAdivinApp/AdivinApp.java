package dad.ejercicioAdivinApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {
	private Label comprobarLabel;
	private Button comprobarButton;
	private TextField nombreText;
	private final int MIN = 0;
	private final int MAX = 100;
	int adivinar =  (int) (Math.random() * (MAX - MIN + 1) + MIN);
	int contador = 0;
	int numEscrito;

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

	public void mostrarError() {
		Alert alert4 = new Alert(AlertType.ERROR);
		alert4.setTitle("AdivinApp");
		alert4.setHeaderText("Error");
		alert4.setContentText("El número introducido no es válido");
		alert4.showAndWait();
	}

	public void mostrarNuevoIntentoMayor() {
		Alert alert1 = new Alert(AlertType.WARNING);
		alert1.setTitle("AdivinApp");
		alert1.setHeaderText("¡Has Fallado!");
		alert1.setContentText("El número a adivinar es más grande que " + numEscrito + ".\nVuelve a intentarlo.");
		alert1.showAndWait();
	}

	public void mostrarNuevoIntentoMenor() {
		Alert alert1 = new Alert(AlertType.WARNING);
		alert1.setTitle("AdivinApp");
		alert1.setHeaderText("¡Has Fallado!");
		alert1.setContentText("El número a adivinar es más pequeño que " + numEscrito + ".\nVuelve a intentarlo.");
		alert1.showAndWait();
	}

	public void mostrarAcierto() {
		Alert alert3 = new Alert(AlertType.INFORMATION);
		alert3.setTitle("AdvinApp");
		alert3.setHeaderText("¡Has Ganado!");
		alert3.setContentText("Solo has necesitado " + contador + " intentos.\nVuelve a jugar y hazlo mejor.");
		alert3.showAndWait();
	}

	public void onComprobarButtonAction(ActionEvent numIN) {
		numEscrito = Integer.valueOf(nombreText.getText());
		try {
			if (numEscrito > 100) {
				mostrarError();
			} else if (numEscrito < 1) {
				mostrarError();
			} else if (adivinar > numEscrito) {
				mostrarNuevoIntentoMayor();
				contador++;
			} else if (adivinar < numEscrito) {
				mostrarNuevoIntentoMenor();
				contador++;
			} else if (adivinar == numEscrito) {
				mostrarAcierto();
			}
			
		} catch (NumberFormatException e) {
			mostrarError();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
