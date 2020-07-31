public class Cat implements Movable {

    private String name;
    private String breed;

    private int lengthToJump;
    private int distanceToRun;

    public Cat(String name, String breed, int lengthToJump, int distanceToRun) {
        this.name = name;
        this.lengthToJump = lengthToJump;
        this.distanceToRun = distanceToRun;
    }

    @Override
    public boolean jump(Wall wall) {
        if (wall.getDistance() > lengthToJump) {
            System.out.println("Cat " + name + " can't jump so high");
            return false;
        } else {
            System.out.println("Cat " + name + " jumped over the wall");
            return true;
        }
    }

    @Override
    public boolean run(Track track) {
        if (track.getDistance() > distanceToRun) {
            System.out.println("Cat " + name + " can't run so far");
            return false;
        } else {
            System.out.println("Cat " + name + " ran through the track");
            return true;
        }
    }

    public int getLengthToJump() {
        return lengthToJump;
    }

    public int getDistanceToRun() {
        return distanceToRun;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLengthToJump(int lengthToJump) {
        this.lengthToJump = lengthToJump;
    }

    public void setDistanceToRun(int distanceToRun) {
        this.distanceToRun = distanceToRun;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name = '" + name + '\'' +
                ", breed = '" + breed + '\'' +
                ", lengthToJump = " + lengthToJump +
                ", distanceToRun = " + distanceToRun +
                '}';
    }
}
