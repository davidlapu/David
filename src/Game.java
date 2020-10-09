public class Game {
    private String name, genre;

    public Game(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public int play() {
        double luck = Math.random();
        int happiness;

        if (luck < 0.2) {
            happiness = -15;
        } else if (luck < 0.6) {
            happiness = 20;
        } else if (luck < 0.9) {
            happiness = 30;
        } else {
            happiness = 50;
            System.out.println("fishl drop");
        }

        return happiness;
    }
}
