public interface Movable {

    public abstract boolean jump(Wall obstacle);

    public abstract boolean run(Track obstacle);

    default public boolean passAnObstacle(Obstacle obstacle) {
        if (obstacle instanceof Wall) {
            return jump((Wall) obstacle);
        } else if (obstacle instanceof Track) {
            return run((Track) obstacle);
        } else
            return false;
    }

}
