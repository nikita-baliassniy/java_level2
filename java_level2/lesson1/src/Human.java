public class Human implements Movable {

    private String name;
    private int age;

    private int lengthToJump;
    private int distanceToRun;

    public Human(String name, int age, int lengthToJump, int distanceToRun) {
        this.name = name;
        this.age = age;
        this.lengthToJump = lengthToJump;
        this.distanceToRun = distanceToRun;
    }

    @Override
    public boolean jump(Wall wall) {
        if (wall.getDistance() > lengthToJump) {
            System.out.println("Human " + name + " can't jump so high");
            return false;
        } else {
            System.out.println("Human " + name + " jumped over the wall");
            return true;
        }
    }

    @Override
    public boolean run(Track track) {
        if (track.getDistance() > distanceToRun) {
            System.out.println("Human " + name + " can't run so far");
            return false;
        } else {
            System.out.println("Human " + name + " ran through the track");
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getLengthToJump() {
        return lengthToJump;
    }

    public int getDistanceToRun() {
        return distanceToRun;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLengthToJump(int lengthToJump) {
        this.lengthToJump = lengthToJump;
    }

    public void setDistanceToRun(int distanceToRun) {
        this.distanceToRun = distanceToRun;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", lengthToJump = " + lengthToJump +
                ", distanceToRun = " + distanceToRun +
                '}';
    }

}
