package sudoku;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SudokuGUI extends Application{
	
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane root = new BorderPane();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		TextField[][] textFields = new OneLetterTextField[9][9];
		TilePane[] tiles = new TilePane[9];
		
	    for(int i = 0; i < 9; i++) {
	    	tiles[i] = new TilePane();
	    	tiles[i].setHgap(10);
	    	tiles[i].setPrefColumns(9);
	    	for(int j = 0; j < 9; j++) {
	    		textFields[i][j] = new OneLetterTextField();
	    		textFields[i][j].setFont(Font.font(14));
		    	textFields[i][j].setPrefSize(40.0, 40.0);
		    	textFields[i][j].setAlignment(Pos.CENTER);
		    	if(((i < 3 || i > 5) && (j < 3 || j > 5)) || ((i >= 3 && i <= 5) && (j >= 3 && j <= 5))) {
		    		textFields[i][j].setBackground(new Background(new BackgroundFill(Paint.valueOf("fac494"), new CornerRadii(5), Insets.EMPTY)));
		    	}
		    	tiles[i].getChildren().add(textFields[i][j]);
	    	}
	    	GridPane.setConstraints(tiles[i], 0, i);
	        grid.getChildren().add(tiles[i]);
	    }
		
		HBox buttons = new HBox();
		Button solve = new Button("Solve");		
		solve.setDefaultButton(true);
		Button clear = new Button("Clear");
		buttons.getChildren().addAll(solve, clear);
		buttons.setAlignment(Pos.TOP_CENTER);
		buttons.setMargin(solve, new Insets(0, 50, 10, 0));
		
		root.setBottom(buttons);
		root.setCenter(grid);
		
		clear.setOnAction(e -> {
			for (int i = 0; i < 9; i++) {
		    	for(int j = 0; j < 9; j++) {
		    		textFields[i][j].setText("");
		    	}
			}	
		});

		solve.setOnAction(e -> {
			SudokuSolver solver = new SudokuSolver();
			
			for (int i = 0; i < 9; i++) {
		    	for(int j = 0; j < 9; j++) {
		    		if(!textFields[i][j].getText().equals("")) {
		    			solver.setValue(i, j, Integer.parseInt(textFields[i][j].getText()));
		    		}
		    	}
			}
						
			if(solver.solve()) {
				for (int i = 0; i < 9; i++) {
			    	for(int j = 0; j < 9; j++) {
			    		textFields[i][j].setText(solver.printValue(i, j));
			    	}
				}
				Alert success = new Alert(AlertType.INFORMATION);
	    		success.setTitle("Succe!");
	    		success.setHeaderText(null);
	    		success.setContentText("Sudokut är löst!");
	    		success.showAndWait();
			}
			else {
				Alert error = new Alert(AlertType.ERROR);
	    		error.setTitle("Error!");
	    		error.setHeaderText(null);
	    		error.setContentText("Sudokut kan inte lösas!");
	    		error.showAndWait();
			}
		});

		Scene scene = new Scene(root, 500, 500);
		stage.setScene(scene);
		stage.setTitle("Sudoku Solver");
		stage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}
}
