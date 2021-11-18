package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.*;
import com.codecool.dungeoncrawl.logic.items.*;

import java.io.InputStream;
import java.util.Scanner;
import java.awt.*;

public class MapLoader {
    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/map.txt");
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {

                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case ',':
                            cell.setType(CellType.FLOOR_FANCY);
                            break;
                        case 't':
                            cell.setType(CellType.TORCH);
                            break;
                        case 'r':
                            cell.setType(CellType.RUBBLE);
                            break;
                        case 'd':
                            cell.setType(CellType.DOOR);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        case '{':
                            cell.setType(CellType.FLOOR);
                            new Passive(cell);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            map.addEnemy(new Skeleton(cell));
                            break;

                        case 'j':
                            cell.setType(CellType.FLOOR);
                            map.addEnemy(new Juggernaut(cell));
                            break;
                        case 'c':
                            cell.setType(CellType.FLOOR);
                            map.addEnemy(new Scarab(cell));
                            break;
                        case 'p':
                            cell.setType(CellType.FLOOR);
                            map.addEnemy(new Phantom(cell));
                            break;
                        case 'S':
                            cell.setType(CellType.FLOOR);
                            Sword sword = new Sword(cell);
                            map.addItem(sword);
                            System.out.println(map.getItems());
                            break;
                        case 'K':
                            cell.setType(CellType.FLOOR);
                            map.setKey(new Key(cell));
                            break;
                        case 'A':
                            cell.setType(CellType.FLOOR);
                            System.out.println("setting floor for shield");
                            new Shield(cell);
                            System.out.println("added shield");
                            break;

                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}
