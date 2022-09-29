import java.util.ArrayList;

    public class Team {

        private String name;
        private Member[] members;
        private ArrayList<Member> winners;

        public Team(String name, Member[] members) {
            this.name = name;
            this.members = members;
        }

        public String getName() {
            return name;
        }

        public Member[] getMembers() {
            return members;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setMembers(Member[] members) {
            this.members = members;
        }

        public void setWinners(ArrayList<Member> winners) {
            this.winners = winners;
        }

        public void teamShowResults() {
            for (var w : winners) {
                System.out.println(w.getName() + " is a winner");
            }
        }


        public void membersInfo() {
            for (var m : members) {
                System.out.println(m.toString());
            }
        }
    }


