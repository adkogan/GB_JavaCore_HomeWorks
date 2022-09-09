import java.util.ArrayList;

public class Course {
    private int swimDistance;
    private int numberOfPullUps;

    public Course(int swimDistance, int numberOfPullUps) {
        this.swimDistance = swimDistance;
        this.numberOfPullUps = numberOfPullUps;
    }


    public void doIt(Team team){
        ArrayList<Member> winners = new ArrayList<Member>();
        for(Member m: team.getMembers()){
            if (m.getMaxPullUp() >= numberOfPullUps && (m.getMaxSwimDistance() >= swimDistance)){
                winners.add(m);
            }
        }
        team.setWinners(winners);
    }



    public int getSwimDistance() {
        return swimDistance;
    }

    public int getNumberOfPullUps() {
        return numberOfPullUps;
    }
}
