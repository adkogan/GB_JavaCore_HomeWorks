public class MainApp {


    public static void main(String[] args) {
        Member [] members = {
                new Member ("Frank", 1, 1),
                new Member("Bob", 10, 10),
                new Member("Mike", 20, 20),
                new Member("Tom", 30, 30)};

        Course course = new Course(12, 12);

        Team team = new Team("A", members);

        team.membersInfo();
        course.doIt(team);
        team.teamShowResults();















    }
}
