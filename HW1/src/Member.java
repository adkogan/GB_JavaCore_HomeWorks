public class Member {


    private String name;
    private int maxSwimDistance;
    private int maxPullUp;


    public Member(String name, int swimDistance, int pullUp) {
        this.name = name;
        this.maxSwimDistance = swimDistance;
        this.maxPullUp = pullUp;
    }

    public String getName() {
        return name;
    }

    public int getMaxSwimDistance() {
        return maxSwimDistance;
    }

    public int getMaxPullUp() {
        return maxPullUp;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", maxSwimDistance=" + maxSwimDistance +
                ", maxPullUp=" + maxPullUp +
                '}';
    }
}
