//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package exercises;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ex5GameOfLife extends Application {
    final Random rand = new Random();
    Ex5GameOfLife.Cell[][] world = new Ex5GameOfLife.Cell[100][100];
    int nLocations = 10000;
    double distribution = 0.15D;
    final int width = 400;
    final int height = 400;
    GraphicsContext gc;

    public Ex5GameOfLife() {
    }

    public void init() {
        this.initWorld();
        this.fillWorld();
    }

    void update() {
        for(int i = 0; i < this.world.length; ++i) {
            for(int j = 0; j < this.world.length; ++j) {
                int neighbours = this.sumNeighbours(i, j);
                this.rules(i, j, neighbours);
            }
        }

    }

    void initWorld() {
        for(int i = 0; i < 100; ++i) {
            for(int j = 0; j < 100; ++j) {
                this.world[i][j] = Ex5GameOfLife.Cell.DEAD;
            }
        }

    }

    void fillWorld() {
        for(int k = 0; (double)k < this.distribution * (double)this.nLocations; ++k) {
            boolean finding = false;

            while(!finding) {
                int x = this.rand.nextInt(100);
                int y = this.rand.nextInt(100);
                if (this.world[x][y] != Ex5GameOfLife.Cell.ALIVE) {
                    this.world[x][y] = Ex5GameOfLife.Cell.ALIVE;
                    finding = true;
                }
            }
        }

    }

    int sumNeighbours(int row, int col) {
        int neighbours = 0;

        for(int i = -1; i <= 1; ++i) {
            if (row + i > 0 && row + i < 100) {
                for(int j = -1; j <= 1; ++j) {
                    if (col + j > 0 && col + j < 100 && this.world[row + i][col + j] == Ex5GameOfLife.Cell.ALIVE) {
                        ++neighbours;
                    }
                }
            }
        }

        if (this.world[row][col] == Ex5GameOfLife.Cell.ALIVE) {
            --neighbours;
        }

        return neighbours;
    }

    void rules(int row, int col, int neighbours) {
        if (this.world[row][col] == Ex5GameOfLife.Cell.ALIVE && (neighbours < 2 || neighbours > 3)) {
            this.world[row][col] = Ex5GameOfLife.Cell.DEAD;
        }

        if (this.world[row][col] == Ex5GameOfLife.Cell.DEAD && neighbours == 3) {
            this.world[row][col] = Ex5GameOfLife.Cell.ALIVE;
        }

    }

    void test() {
        Ex5GameOfLife.Cell[][] testWorld = new Ex5GameOfLife.Cell[][]{{Ex5GameOfLife.Cell.ALIVE, Ex5GameOfLife.Cell.ALIVE, Ex5GameOfLife.Cell.DEAD}, {Ex5GameOfLife.Cell.ALIVE, Ex5GameOfLife.Cell.DEAD, Ex5GameOfLife.Cell.DEAD}, {Ex5GameOfLife.Cell.DEAD, Ex5GameOfLife.Cell.DEAD, Ex5GameOfLife.Cell.ALIVE}};
        int size = testWorld.length;
        System.exit(0);
    }

    void render() {
        this.gc.clearRect(0.0D, 0.0D, 400.0D, 400.0D);
        int size = this.world.length;

        for(int row = 0; row < size; ++row) {
            for(int col = 0; col < size; ++col) {
                int x = 3 * col + 50;
                int y = 3 * row + 50;
                this.renderCell(x, y, this.world[row][col]);
            }
        }

    }

    void renderCell(int x, int y, Ex5GameOfLife.Cell cell) {
        if (cell == Ex5GameOfLife.Cell.ALIVE) {
            this.gc.setFill(Color.RED);
        } else {
            this.gc.setFill(Color.WHITE);
        }

        this.gc.fillOval((double)x, (double)y, 3.0D, 3.0D);
    }

    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Canvas canvas = new Canvas(400.0D, 400.0D);
        root.getChildren().addAll(new Node[]{canvas});
        this.gc = canvas.getGraphicsContext2D();
        AnimationTimer timer = new AnimationTimer() {
            long timeLastUpdate;

            public void handle(long now) {
                if (now - this.timeLastUpdate > 300000000L) {
                    Ex5GameOfLife.this.update();
                    Ex5GameOfLife.this.render();
                    this.timeLastUpdate = now;
                }

            }
        };
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game of Life");
        primaryStage.show();
        timer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

    enum Cell {
        DEAD,
        ALIVE;

        private Cell() {
        }
    }
}
