import java.awt.*;

public class TileMap {
    private Tile[][] map;
    private Tile[][] map1;
    private Tile[] mapObjects;
    private Tile[] mapObjects1;
    private int[][] mapNum;
    private int[][] mapNum1;
    private boolean[][] mapFunction;
    private boolean[][] mapFunction1;
    TileMap() {
        mapNum = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 4, 4, 4, 4, 4, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 4, 4, 4, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1},
                {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 5, 5, 1, 1, 1, 1, 1, 1, 1, 1,},
                {1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1},
                {1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1},
                {1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1},
                {1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1},
                {1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        mapNum1 = new int[][] {
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 6, 6, 6, 6, 1, 1, 0, 0},
                {0, 1, 1, 6, 6, 6, 6, 6, 6, 1, 1, 0},
                {1, 1, 6, 6, 6, 6, 6, 6, 6, 6, 1, 1},
                {1, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 1},
                {1, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 1},
                {1, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 1},
                {1, 1, 6, 6, 6, 6, 6, 6, 6, 6, 1, 1},
                {0, 1, 1, 6, 6, 6, 6, 6, 6, 1, 1, 0},
                {0, 0, 1, 1, 6, 6, 6, 6, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 6, 6, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 6, 6, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 6, 6, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 6, 6, 1, 1, 1, 1, 1},
                {1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1},
                {1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1},
                {1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1},
                {1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1},
                {1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1},//18
                {1, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1},//19
                {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 1, 1, 1, 1, 4, 4, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0},
        };
        mapFunction = new boolean[mapNum.length][mapNum[0].length];
        mapFunction[3][14] = true;
        mapFunction[3][16] = true;
        mapFunction1 = new boolean[mapNum1.length][mapNum1[0].length];
        mapObjects = new Tile[38];
        mapObjects[0] = new Tile(true, "src/images/objects/1.png", 544, 288);
        mapObjects[1] = new Tile(true, "src/images/objects/2.png", 576, 288);
        mapObjects[2] = new Tile(true, "src/images/objects/3.png", 576, 352);
        mapObjects[3] = new Tile(true, "src/images/objects/4.png", 576, 384);
        mapObjects[4] = new Tile(true, "src/images/objects/3.png", 576, 384);
        mapObjects[5] = new Tile(true, "src/images/objects/4.png", 576, 416);
        mapObjects[6] = new Tile(true, "src/images/objects/5.png", 544, 352);
        mapObjects[7] = new Tile(true, "src/images/objects/6.png", 544, 384);
        mapObjects[8] = new Tile(true, "src/images/objects/5.png", 544, 384);
        mapObjects[9] = new Tile(true, "src/images/objects/6.png", 544, 416);
        mapObjects[10] = new Tile(true, "src/images/objects/3.png", 480, 352);
        mapObjects[11] = new Tile(true, "src/images/objects/4.png", 480, 384);
        mapObjects[12] = new Tile(true, "src/images/objects/3.png", 480, 384);
        mapObjects[13] = new Tile(true, "src/images/objects/4.png", 480, 416);
        mapObjects[14] = new Tile(true, "src/images/objects/5.png", 448, 352);
        mapObjects[15] = new Tile(true, "src/images/objects/6.png", 448, 384);
        mapObjects[16] = new Tile(true, "src/images/objects/5.png", 448, 384);
        mapObjects[17] = new Tile(true, "src/images/objects/6.png", 448, 416);
        // 672 // 96
        mapObjects[18] = new Tile(true, "src/images/objects/3.png", 256, 352);
        mapObjects[19] = new Tile(true, "src/images/objects/4.png", 256, 384);
        mapObjects[20] = new Tile(true, "src/images/objects/3.png", 256, 384);
        mapObjects[21] = new Tile(true, "src/images/objects/4.png", 256, 416);
        mapObjects[22] = new Tile(true, "src/images/objects/5.png", 224, 352);
        mapObjects[23] = new Tile(true, "src/images/objects/6.png", 224, 384);
        mapObjects[24] = new Tile(true, "src/images/objects/5.png", 224, 384);
        mapObjects[25] = new Tile(true, "src/images/objects/6.png", 224, 416);
        mapObjects[26] = new Tile(true, "src/images/objects/3.png", 160, 352);
        mapObjects[27] = new Tile(true, "src/images/objects/4.png", 160, 384);
        mapObjects[28] = new Tile(true, "src/images/objects/3.png", 160, 384);
        mapObjects[29] = new Tile(true, "src/images/objects/4.png", 160, 416);
        mapObjects[30] = new Tile(true, "src/images/objects/5.png", 128, 352);
        mapObjects[31] = new Tile(true, "src/images/objects/6.png", 128, 384);
        mapObjects[32] = new Tile(true, "src/images/objects/5.png", 128, 384);
        mapObjects[33] = new Tile(true, "src/images/objects/6.png", 128, 416);
        mapObjects[34] = new Tile(true, "src/images/objects/7.png", 224, 288);
        mapObjects[35] = new Tile(true, "src/images/objects/1.png", 160, 288);
        mapObjects[36] = new Tile(true, "src/images/objects/2.png", 192, 288);
        mapObjects[37] = new Tile(true, "src/images/objects/8.png", 480, 288);
        mapObjects1 = new Tile[0];
        map = new Tile[mapNum.length][mapNum[0].length];
        int x = 0;
        int y = 0;
        for (int r = 0; r < mapNum.length; r++) {
            for (int c = 0; c < mapNum[r].length; c++) {
                if (mapNum[r][c] == 1) {
                    map[r][c] = new Tile(true, "src/images/01.png", x, y);
                } else {
                    map[r][c] = new Tile(false, "src/images/0" + mapNum[r][c] + ".png", x, y);
                }
                x+=32;
            }
            x = 0;
            y+=32;
        }
        map1 = new Tile[mapNum1.length][mapNum1[0].length];
        y = 0;
        for (int r = 0; r < mapNum1.length; r++) {
            for (int c = 0; c < mapNum1[r].length; c++) {
                if (mapNum1[r][c] == 1) {
                    map1[r][c] = new Tile(true, "src/images/01.png", x, y);
                } else {
                    map1[r][c] = new Tile(false, "src/images/0" + mapNum1[r][c] + ".png", x, y);
                }
                x+=32;
            }
            x = 0;
            y+=32;
        }

    }
    public Tile[][] getMap() {
        return map;
    }
    public Tile[][] getMap1() {
        return map1;
    }
    public Tile[] getObject() {
        return mapObjects;
    }
    public Tile[] getObject1() {
        return mapObjects1;
    }
    public boolean[][] getFunction() {
        return mapFunction;
    }
    public boolean[][] getFunction1() {
        return mapFunction1;
    }
}
