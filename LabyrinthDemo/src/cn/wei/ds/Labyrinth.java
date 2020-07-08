package cn.wei.ds;

public class Labyrinth {
    private int[][] map;

    public void initMap() {
        int length = 10;
        int width = 10;
        map = new int[length][width];
        for (int i = 0; i < length; i++) {
            map[i][0] = 1;
            map[i][width - 1] = 1;
        }
        for (int i = 0; i < width; i++) {
            map[0][i] = 1;
            map[length - 1][i] = 1;
        }
        map[2][1] = 1;
        map[2][2] = 1;
        map[2][3] = 1;
        map[4][3] = 1;
        map[5][3] = 1;
        map[6][3] = 1;
        map[7][3] = 1;
        map[7][4] = 1;
        map[7][5] = 1;
        map[7][6] = 1;
        map[7][7] = 1;
        map[7][8] = 1;

    }

    public void printMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * <p>
     *     i,j 表示起点位置
     *     当找到8，8时认为完成寻路
     *     寻路策略为 下 - 右 - 上 -左
     *     map值
     *          1: 表示墙
     *          2：表示通路
     *          3：表示死路
     * </p>
     * @param i
     * @param j
     * @return
     */
    public boolean findWay(int i, int j) {
        if (map[8][8] == 2) { //走到了8，8表示找到出口
            return true;
        } else {
            if (map[i][j] == 0) { //当前节点没有走过
                map[i][j] = 2;  //假定可以走通
                if (findWay(i + 1, j)) {  //向下走
                    return true;
                } else if (findWay(i, j + 1)) { //向右走
                    return true;
                } else if (findWay(i - 1, j)) { //向上走
                    return true;
                } else if (findWay(i, j - 1)) { //向左走
                    return true;
                } else { //四个方向都走过了不通
                    map[i][j] = 3; //死路
                    return false;
                }
            } else { //当前节点 为 1，2，3 都不需要再走了，不通，或者已经走过
                return false;
            }
        }
    }
}