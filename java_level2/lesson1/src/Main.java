public class Main {


    public static void main(String[] args) {

        Obstacle[] obstacles = new Obstacle[5];
        obstacles[0] = new Track(100);
        obstacles[1] = new Wall(10);
        obstacles[2] = new Track(150);
        obstacles[3] = new Wall(5);
        obstacles[4] = new Track(175);

        Movable[] joggers = new Movable[6];
        joggers[0] = new Cat("Barsik", "Siamets", 5, 120);
        joggers[1] = new Cat("Semen", "Mein-kun", 11, 200);
        joggers[2] = new Robot("IG-0911", 121, 9, 99);
        joggers[3] = new Robot("NP-4902", 9088, 19, 160);
        joggers[4] = new Human("Nikolay", 45, 6, 135);
        joggers[5] = new Human("Sergey", 25, 12, 180);

        for (Movable jogger : joggers) {
            for (Obstacle obstacle : obstacles) {
                System.out.println(obstacle);
                if (!jogger.passAnObstacle(obstacle))
                    break;
            }
        }

    }

}
