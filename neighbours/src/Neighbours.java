import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.round;
import static java.lang.Math.random;
import static java.lang.Math.sqrt;
import static java.lang.System.*;

/*
 *  Program to simulate segregation.
 *  See : http://nifty.stanford.edu/2014/mccown-schelling-model-segregation/
 *
 * NOTE:
 * - JavaFX first calls method init() and then the method start() far below.
 * - The method updateWorld() is called periodically by a Java timer.
 * - To test uncomment call to test() first in init() method!
 *
 */
// Extends Application because of JavaFX (just accept for now)
public class Neighbours extends Application {

    final Random rand = new Random();

    // Enumeration type for the Actors
    enum Actor {
        BLUE, RED, NONE   // NONE used for empty locations
    }

    // Enumeration type for the state of an Actor
    enum State {
        UNSATISFIED,
        SATISFIED,
        NA     // Not applicable (NA), used for NONEs
    }

    // Below is the *only* accepted instance variable (i.e. variables outside any method)
    // This variable may *only* be used in methods init() and updateWorld()
    Actor[][] world;             // The world is a square matrix of Actors

    // This is the method called by the timer to update the world
    // (i.e move unsatisfied) approx each 1/60 sec.
    void updateWorld() {

        // % of surrounding neighbours that are like me
        final double threshold = 0.7;

        // Create states for each actor in a separate matrix.
        State[][] states = getStates(world, threshold);

        world = getUpdate(states);
    }

    // This method initializes the world variable with a random distribution of Actors
    // Method automatically called by JavaFX runtime (before graphics appear)
    // Don't care about "@Override" and "public" (just accept for now)
    @Override
    public void init() {
        //test();    // <---------------- Uncomment to TEST!

        // %-distribution of RED, BLUE and NONE
        double[] dist = {0.25, 0.25, 0.50};
        // Number of locations (places) in world (square)
        int nLocations = 900;

        world = generateWorld(world, dist, nLocations);

        // Should be last
        fixScreenSize(nLocations);
    }


    //---------------- Methods ----------------------------


    Actor[][] generateWorld(Actor[][] world, double[] dist, int nLocations){
        final int SIZE = (int)sqrt(nLocations);
        // Create world.
        world = new Actor[SIZE][SIZE];

        world = fillWorld(world, dist, nLocations);

        return world;
    }

    Actor[][] fillWorld(Actor[][] world, double[] dist, int nLocations) {
        Actor[] temp = {Actor.RED, Actor.BLUE, Actor.NONE};

        // Fill the world with red and blue actors.
        for(int i = 0; i < dist.length - 1; i++) {
            for (int k = 0; k < dist[i] * nLocations; k++) {
                boolean finding = false;
                while (!finding) {
                    int x = rand.nextInt((int) sqrt(nLocations));
                    int y = rand.nextInt((int) sqrt(nLocations));
                    if (world[x][y] == null) {
                        world[x][y] = temp[i];
                        finding = true;
                    }
                }
            }
        }
        // Fill rest with none actors.
        for(int i = 0; i < world.length; i++) {
            for (int j = 0; j < world.length; j++) {
                if (world[i][j] == null) {
                    world[i][j] = temp[temp.length - 1];
                }
            }
        }
        return world;
    }

    State[][] getStates(Actor[][] world, double threshold) {

        State[][] states = new State[world.length][world.length];

        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world.length; j++) {
                // If current actor is none, state is NA.
                if (world[i][j] == Actor.NONE) {
                    states[i][j] = State.NA;
                }
                // Otherwise, check satisfaction.
                else {
                    states[i][j] = getSatisfaction(i, j, world, threshold);
                }
            }
        }
        return states;
    }

    State getSatisfaction(int row, int col, Actor[][] world, double threshold) {

        double ratio = getRatio(row, col, world);
        if(ratio >= threshold){
            return State.SATISFIED;
        }
        else{
            return State.UNSATISFIED;
        }
    }

    double getRatio(int row, int col, Actor[][] world){
        double sameColourNeighbour = 0;
        double totalNeighbours = 0;


        for (int i = -1; i <= 1; i++) {
            if (row + i >= 0 && row + i < world.length) {
                for (int j = -1; j <= 1; j++) {
                    if (col + j >= 0 && col + j < world.length) {
                        if (world[row + i][col + j] == world[row][col]) {
                            sameColourNeighbour++;
                        }
                        if (world[row + i][col + j] != Actor.NONE) {
                            totalNeighbours++;
                        }
                    }
                }
            }
        }
        double ratio = sameColourNeighbour / totalNeighbours;

        if (ratio != 1) {
            sameColourNeighbour--;
            totalNeighbours--;
            ratio = sameColourNeighbour / totalNeighbours;
        }

        return ratio;
    }

    Actor[][] getUpdate(State[][] states){
        // Create temporary world that we will need for
        Actor[][] tempWorld = new Actor[world.length][world.length];


        for(int i = 0; i < states.length; i++) {
            for (int j = 0; j < states.length; j++) {

                // If states is unsatisfied, we want the actor at the same position to change position.
                if(states[i][j] == State.UNSATISFIED){
                    boolean finding = false;
                    while (!finding) {
                        int x = rand.nextInt(world.length);
                        int y = rand.nextInt(world.length);

                        // If the world hasn't an actor at this random position and we hasn't already used this positon
                        // ...then change to this position
                        if(world[x][y] == Actor.NONE && tempWorld[x][y] == null){
                            // We need to fill the position of the temp world so we cannot use this place again.
                            tempWorld[x][y] = world[i][j];
                            world[x][y] = world[i][j];
                            world[i][j] = Actor.NONE;
                            finding = true;
                        }
                    }
                }
            }
        }
        return world;
    }

    // Check if inside world
    boolean isValidLocation(int size, int row, int col) {
        return 0 <= row && row < size &&
                0 <= col && col < size;
    }



    // ------- Testing -------------------------------------

    // Here you run your tests i.e. call your logic methods
    // to see that they really work
    void test() {
        // A small hard coded world for testing
        Actor[][] testWorld = new Actor[][]{
                {Actor.RED, Actor.RED, Actor.NONE},
                {Actor.NONE, Actor.BLUE, Actor.NONE},
                {Actor.RED, Actor.NONE, Actor.BLUE}
        };
        double th = 0.5;   // Simple threshold used for testing

        int size = testWorld.length;
        out.println(isValidLocation(size, 0, 0));
        out.println(!isValidLocation(size, -1, 0));
        out.println(!isValidLocation(size, 0, 3));
        out.println(isValidLocation(size, 2, 2));

        // TODO More tests

        exit(0);
    }

    // Helper method for testing (NOTE: reference equality)
    <T> int count(T[] arr, T toFind) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == toFind) {
                count++;
            }
        }
        return count;
    }

    // ###########  NOTHING to do below this row, it's JavaFX stuff  ###########

    double width = 400;   // Size for window
    double height = 400;
    long previousTime = nanoTime();
    final long interval = 450000000;
    double dotSize;
    final double margin = 50;

    void fixScreenSize(int nLocations) {
        // Adjust screen window depending on nLocations
        dotSize = (width - 2 * margin) / sqrt(nLocations);
        if (dotSize < 1) {
            dotSize = 2;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Build a scene graph
        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        root.getChildren().addAll(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Create a timer
        AnimationTimer timer = new AnimationTimer() {
            // This method called by FX, parameter is the current time
            public void handle(long currentNanoTime) {
                long elapsedNanos = currentNanoTime - previousTime;
                if (elapsedNanos > interval) {
                    updateWorld();
                    renderWorld(gc, world);
                    previousTime = currentNanoTime;
                }
            }
        };

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Segregation Simulation");
        primaryStage.show();

        timer.start();  // Start simulation
    }


    // Render the state of the world to the screen
    public void renderWorld(GraphicsContext g, Actor[][] world) {
        g.clearRect(0, 0, width, height);
        int size = world.length;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                double x = dotSize * col + margin;
                double y = dotSize * row + margin;

                if (world[row][col] == Actor.RED) {
                    g.setFill(Color.RED);
                } else if (world[row][col] == Actor.BLUE) {
                    g.setFill(Color.BLUE);
                } else {
                    g.setFill(Color.WHITE);
                }
                g.fillOval(x, y, dotSize, dotSize);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
