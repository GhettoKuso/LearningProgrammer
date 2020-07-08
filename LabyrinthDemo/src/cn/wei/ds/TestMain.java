package cn.wei.ds;

public class TestMain {

    public static void main(String[] args) {
        Labyrinth labyrinth = new Labyrinth();
        labyrinth.initMap();
        System.out.println("before------------");
        labyrinth.printMap();
        labyrinth.findWay(1, 1);
        System.out.println("after-------------");
        labyrinth.printMap();
    }
}
