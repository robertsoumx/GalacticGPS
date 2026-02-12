import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.List;

public class SpaceExplorerApp extends Application {

    private Pane spacePane;
    private Label statusLabel;
    private Graph<Planet> universe;

    private Planet startNode = null;
    private Planet endNode = null;

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #111;"); // Space background

        // Setup Toolbar
        HBox toolbar = new HBox(10);
        toolbar.setStyle("-fx-padding: 10px; -fx-background-color: #333;");
        Button btnGen = new Button("Generate Universe");
        Button btnClear = new Button("Clear Path");

        btnGen.setOnAction(e -> generateAndDraw());
        btnClear.setOnAction(e -> {
            startNode = null; endNode = null;
            drawGraph();
        });
        toolbar.getChildren().addAll(btnGen, btnClear);

        // Setup Canvas
        spacePane = new Pane();
        statusLabel = new Label("Click 'Generate Universe'. If screen stays black, Graph.java is empty!");
        statusLabel.setStyle("-fx-text-fill: white; -fx-padding: 10px;");

        root.setCenter(spacePane);
        root.setTop(toolbar);
        root.setBottom(statusLabel);

        Scene scene = new Scene(root, 1000, 700);
        stage.setTitle("Galactic Graph");
        stage.setScene(scene);
        stage.show();
    }

    private void generateAndDraw() {
        // This calls the Generator (which currently returns Earth/Mars)
        universe = UniverseGenerator.generate(1000, 650);
        startNode = null;
        endNode = null;
        drawGraph();
    }

    private void drawGraph() {
        spacePane.getChildren().clear();

        if (universe == null || universe.getVertices().isEmpty()) {
            statusLabel.setText("Error: Universe is empty. Did Student A implement Graph.addVertex?");
            return;
        }

        // --- STUDENT B TASK: DRAW THE GRAPH ---

        // 1. Draw Edges (Lines)
        // TODO: Loop through every planet in universe.getVertices()
        // TODO: Loop through every neighbor in universe.getNeighbors(planet)
        // TODO: Create a new Line(p.x, p.y, neighbor.x, neighbor.y)
        // TODO: spacePane.getChildren().add(line);

        // 2. Draw Nodes (Planets)
        // TODO: Loop through every planet again.
        // TODO: Create a Circle(p.x, p.y, 10)
        // TODO: Set color Color.CYAN
        // TODO: spacePane.getChildren().add(circle);

        // 3. Add Click Events
        // circle.setOnMouseClicked(e -> handlePlanetClick(p));
    }

    private void handlePlanetClick(Planet p) {
        if (startNode == null) {
            startNode = p;
            statusLabel.setText("Start: " + p.getName());
        } else if (endNode == null && p != startNode) {
            endNode = p;
            statusLabel.setText("Calculating path...");
            drawPath();
        }
    }

    private void drawPath() {
        List<Planet> path = Pathfinder.findShortestPath(universe, startNode, endNode);

        // --- STUDENT B TASK: DRAW THE PATH ---
        // TODO: Loop through the 'path' list.
        // TODO: Draw a thick GOLD line connecting the planets.

        if (path.isEmpty()) {
            statusLabel.setText("No path found.");
        } else {
            statusLabel.setText("Path found! Steps: " + path.size());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}