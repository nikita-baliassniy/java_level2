public class Track extends Obstacle {

    public Track(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Track{" +
                "distance = " + distance +
                '}';
    }
}
