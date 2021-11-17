package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.*;
import com.codecool.dungeoncrawl.logic.items.*;

import java.io.InputStream;
import java.util.Scanner;

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
                        case 'w':
                            cell.setType(CellType.FLOOR);
                            new Sword(cell);
                            break;
                        case 'k':
                            cell.setType(CellType.FLOOR);
                            new Key(cell);
                            break;
                        case 'a':
                            cell.setType(CellType.FLOOR);
                            new Shield(cell);
                            break;
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
                        case 's':
                            cell.setType(CellType.FLOOR);
                            new Skeleton(cell);
                            break;
                        case '{':
                            cell.setType(CellType.FLOOR);
                            new Passive(cell);
                            break;
                        case 'j':
                            cell.setType(CellType.FLOOR);
                            new Juggernaut(cell);
                            break;
                        case 'c':
                            cell.setType(CellType.FLOOR);
                            new Scarab(cell);
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
