package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.MapLoader;
import com.codecool.dungeoncrawl.logic.actors.*;
import com.codecool.dungeoncrawl.logic.utils.Randomizers;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    GameMap map = MapLoader.loadMap();
    Canvas canvas = new Canvas(
            map.getWidth() * Tiles.TILE_WIDTH,
            map.getHeight() * Tiles.TILE_WIDTH);
    GraphicsContext context = canvas.getGraphicsContext2D();
    Label healthLabel = new Label();
    Label strengthLabel = new Label();
    Label armorLabel = new Label();
    Label keyLabel = new Label();
    Label inventoryLabel = new Label();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane ui = new GridPane();
        ui.setPrefWidth(200);
        ui.setPadding(new Insets(10));

        ui.add(new Label("Health: "), 0, 0);
        ui.add(healthLabel, 1, 0);

        ui.add(new Label("Strength: "), 0, 1);
        ui.add(strengthLabel, 1, 1);

        ui.add(new Label("Armor: "), 0, 2);
        ui.add(armorLabel, 1, 2);

        ui.add(new Label("Key in inventory "), 0, 3);
        ui.add(keyLabel, 1, 3);

        ui.add(new Label("Inventory: "), 0, 4);
        ui.add(inventoryLabel, 1, 4);

        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(canvas);
        borderPane.setRight(ui);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        if (map.getPlayer().isDead()) {
            borderPane.setCenter(new Text("You have died !"));
        }
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);

        primaryStage.setTitle("Dungeon Crawl");
        primaryStage.show();
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP:

                map.getPlayer().move(0, -1);
                refresh();

                break;
            case DOWN:

                map.getPlayer().move(0, 1);
                refresh();
                break;
            case LEFT:

                map.getPlayer().move(-1, 0);
                refresh();
                break;
            case RIGHT:

                map.getPlayer().move(1, 0);
                refresh();
                break;
        }
    }

    private void refresh() {
        int count=0;
        if (map.getPlayer().isDead()) {
            System.out.println("Player has died");
            map.getPlayer().getCell().setType(CellType.FLOOR);
            map.getPlayer().getCell().setActor(null);
            context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            context.fillText("You have died !", 250, 250);

        } else {
            context.setFill(Color.BLACK);
            context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            for (int x = 0; x < map.getWidth(); x++) {
                for (int y = 0; y < map.getHeight(); y++) {
                    Cell cell = map.getCell(x, y);
                    if (cell.getActor() != null) {
                        Tiles.drawTile(context, cell.getActor(), x, y);
                        if (cell.getActor() instanceof Skeleton) {
//                            System.out.println("Current skeleton position: X :" + cell.getActor().getX() + "Y: " + cell.getActor().getY());
                            System.out.println("entering skeleton movement");
                            int sX = Randomizers.getRandomIntInRange(-1, 2);
                            int sY = Randomizers.getRandomIntInRange(-1, 2);
//                            System.out.println("sX = " + sX + " sY = " + sY);
                            cell.getActor().move(sX, sY);
                            count++;
                            System.out.println("Actor object: "+cell.getActor()+" -movement: "+count);
                            if (cell.getActor()!=null){
                                Tiles.drawTile(context, cell.getActor(), cell.getActor().getX(), cell.getActor().getY());
                            }
//                            System.out.println("New skeleton position: X :" + cell.getActor().getX() + "Y: " + cell.getActor().getY());
//                            Tiles.drawTile(context, cell.getActor(), sX, sY);
                        }
//                        Tiles.drawTile(context, cell.getActor(), x, y);

                    } else if (cell.getItem() != null) {
                        Tiles.drawTile(context, cell.getItem(), x, y);
                    } else {
                        Tiles.drawTile(context, cell, x, y);
                    }
                }
            }
            healthLabel.setText("" + map.getPlayer().getHealth());
            strengthLabel.setText("" + map.getPlayer().getStrength());
            armorLabel.setText("" + map.getPlayer().getArmor());
            keyLabel.setText("" + map.getPlayer().getInventory().getKeyInInventory());
            inventoryLabel.setText("" + map.getPlayer().showInventory());
        }
    }
}
