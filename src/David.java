import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class David {
    boolean alive = true, haveHomework = false;
    int happiness = 50;
    LocalTime hora = LocalTime.now();

    public static void main(String[] args) {
        David david = new David();
        david.start();
    }

    public void start() {
        Game GenshinImpact = new Game("Genshin impact", "Action role-playing");
        Building ITB = new Building(),Home = new Building();

        while (alive) {
            switch (hora.format(DateTimeFormatter.ofPattern("HH:mm"))) {
                case "11:00" ->  {
                    if (haveHomework) doHomework();
                    else play(GenshinImpact);
                }
                case "13:30" -> eat();
                case "14:35" -> rideBike(ITB);
                case "15:50" -> inClass();
                case "19:10" -> rideBike(Home);
                case "20:10" -> shower();
                case "21:00" -> eat();
                case "21:30" -> play(GenshinImpact);
                case "02:00" -> sleep(9);
            }
            hora = hora.plusMinutes(1);

            if (happiness > 100) happiness = 100;
            else if (happiness < 0) {
                System.out.println("Why live just to suffer");
                alive = false; //TODO: implementar metodo suicidio con problabilidad de fallar
            }
        }

        System.out.println("Dead...");
    }

    public void sleep(int horas) {
        hora = hora.plusHours(horas);
    }

    public void doHomework() {
        happiness = happiness - 10;
        System.out.println("Doing homework");
    }

    public void play(Game game) {
        System.out.println("Playing");
        happiness = happiness + game.play();
    }

    public void eat() {
        System.out.println("Eating...");
        happiness = happiness + 5;
    }

    public void rideBike(Building place) {
        double luck = Math.random();

        System.out.println("Riding bike...");

        if (luck < 0.01) {
            alive = false;
            System.out.println("But... I had right of way...");
        }
    }

    public void inClass() {
        System.out.println("In class...");
        happiness = happiness - 15;
    }

    public void shower() {
        System.out.println("Showering...");
        happiness = happiness + 3;
    }
}