public class Wall extends Obstacle {

    public Wall(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "height = " + distance +
                '}';
    }
}
