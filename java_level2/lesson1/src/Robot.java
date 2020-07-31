public class Robot implements Movable {

    private String number;
    private int model;

    private int lengthToJump;
    private int distanceToRun;

    public Robot(String number, int model, int lengthToJump, int distanceToRun) {
        this.number = number;
        this.model = model;
        this.lengthToJump = lengthToJump;
        this.distanceToRun = distanceToRun;
    }

    @Override
    public boolean jump(Wall wall) {
        if (wall.getDistance() > lengthToJump) {
            System.out.println("Robot " + number + " can't jump so high");
            return false;
        } else {
            System.out.println("Robot " + number + " jumped over the wall");
            return true;
        }
    }

    @Override
    public boolean run(Track track) {
        if (track.getDistance() > distanceToRun) {
            System.out.println("Robot " + number + " can't run so far");
            return false;
        } else {
            System.out.println("Robot " + number + " ran through the track");
            return true;
        }
    }

    public String getNumber() {
        return number;
    }

    public int getModel() {
        return model;
    }

    public int getLengthToJump() {
        return lengthToJump;
    }

    public int getDistanceToRun() {
        return distanceToRun;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public void setLengthToJump(int lengthToJump) {
        this.lengthToJump = lengthToJump;
    }

    public void setDistanceToRun(int distanceToRun) {
        this.distanceToRun = distanceToRun;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "number = '" + number + '\'' +
                ", model = " + model +
                ", lengthToJump = " + lengthToJump +
                ", distanceToRun = " + distanceToRun +
                '}';
    }
}
