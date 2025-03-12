package main;

public class Main {
    public static void main(String[] args) {

        GameManager gm = new GameManager();
        GameContainer gc = new GameContainer(gm);
//        gc.setWidth(1000);
//        gc.setHeight(1000);
//        gc.setScale(3);
        gc.startGame();

    }
}