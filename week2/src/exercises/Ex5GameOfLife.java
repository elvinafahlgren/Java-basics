package exercises;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Vector;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import static java.lang.System.exit;
import static java.lang.System.out;

/*
 * Program for Conway's game of life.
 * See https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 *
 * This is a graphical program using JavaFX to draw on the screen.
 * There's a bit of "drawing" code to make this happen (far below).
 * You don't need to implement (or understand) any of it.
 * NOTE: To run tests must uncomment in init() method, see comment
 *
 * Use smallest step development + functional decomposition!
 *
 * See:
 * - UseEnum
 * - BasicJavaFX (don't need to understand, just if you're curious)
 */
public class Ex5GameOfLife extends Application {

    final Random rand = new Random();

    // Enum type for state of Cells
    enum Cell {
        DEAD, ALIVE;
    }

    // This is the *only* accepted modifiable instance variable in program.
    Cell[][] world = new Cell[100][100];
    int nLocations = 10000;
    double distribution = 0.15;   // % of locations holding a Cell

    @Override
    public void init() {
        //test();        // <--------------- Uncomment to test!
        // TODO Create and populate world
        initWorld();
        fillWorld();
    }

    
    // Implement this method (using functional decomposition)
    // Every involved method should be tested, see below, method test()
    // This method is automatically called by a JavaFX timer (don't need to call it)

    void update() {
        // TODO Update (logically) the world
        for(int i = 0; i < world.length; i++){
            for(int j = 0; j < world.length; j++){
                int neighbours = sumNeighbours(i, j);
                rules(i, j, neighbours);
            }
        }

    }

    // -------- Write methods below this --------------


    void initWorld(){
        for(int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                world[i][j] = Cell.DEAD;
            }
        }
    }

    void fillWorld(){
        for(int k = 0; k < distribution * nLocations; k++){
            boolean finding = false;
            while (!finding){
                int x = rand.nextInt(100);
                int y = rand.nextInt(100);
                if(world[x][y] != Cell.ALIVE){
                    world[x][y] = Cell.ALIVE;
                    finding = true;
                }
            }
        }
    }

    int sumNeighbours(int row, int col) {
        int neighbours = 0;
        for (int i = -1; i <= 1; i++) {
            if (row + i > 0 && row + i < 100) {
                for (int j = -1; j <= 1; j++) {
                    if (col + j > 0 && col + j < 100){
                        if (world[row + i][col + j] == Cell.ALIVE){
                            neighbours ++;
                        }
                    }
                }
            }
        }
        if(world[row][col] == Cell.ALIVE)
            neighbours--;
        return neighbours;
    }

    void rules(int row, int col, int neighbours){
        if(world[row][col] == Cell.ALIVE){
            if(neighbours < 2 || neighbours > 3){
                world[row][col] = Cell.DEAD;
            }
        }
        if(world[row][col] == Cell.DEAD && neighbours == 3){
            world[row][col] = Cell.ALIVE;
        }
    }



    // ---------- Testing -----------------
    // Here you run your tests i.e. call your logic methods
    // to see that they really work

    void test(){
        // Hard coded test world
        Cell[][] testWorld = {
                {Cell.ALIVE, Cell.ALIVE, Cell.DEAD},
                {Cell.ALIVE, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.ALIVE},

        };
        int size = testWorld.length;

        // TODO tests!

        exit(0);
    }

    // -------- Below is JavaFX stuff, nothing to do --------------

    void render() {
        gc.clearRect(0, 0, width, height);
        int size = world.length;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int x = 3 * col + 50;
                int y = 3 * row + 50;
                renderCell(x, y, world[row][col]);
            }
        }
    }

    void renderCell(int x, int y, Cell cell) {
        if (cell == Cell.ALIVE) {
            gc.setFill(Color.RED);
        } else {
            gc.setFill(Color.WHITE);
        }
        gc.fillOval(x, y, 3, 3);
    }

    final int width = 400;   // Size of window
    final int height = 400;
    GraphicsContext gc;

    // Must have public before more later.
    @Override
    public void start(Stage primaryStage) throws Exception {

        // JavaFX stuff
        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        root.getChildren().addAll(canvas);
        gc = canvas.getGraphicsContext2D();

        // Create a timer
        AnimationTimer timer = new AnimationTimer() {

            long timeLastUpdate;

            // This method called by FX at a certain rate, parameter is the current time
            public void handle(long now) {
                if (now - timeLastUpdate > 300_000_000) {
                    update();
                    render();
                    timeLastUpdate = now;
                }
            }
        };
        // Create a scene and connect to the stage
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game of Life");
        primaryStage.show();
        timer.start();  // Start simulation
    }

    public static void main(String[] args) {
        launch(args);   // Launch JavaFX
    }
}