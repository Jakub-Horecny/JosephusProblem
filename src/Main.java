import java.util.ArrayList;

public class Main {
    /**
     * Josephus Problem
     * @param numberOfSoldiers - number of soldiers in circle
     * @param killStep - number of soldiers skipped
     * @param numberOfSurvivors - number of soldiers who will survive
     */
    public static void whoWillSurvive(int numberOfSoldiers, int killStep, int numberOfSurvivors){
        ArrayList<Integer> circle = new ArrayList<>(numberOfSoldiers);
        ArrayList<Integer> eliminations = new ArrayList<>(numberOfSoldiers - numberOfSurvivors); // order of elimination

        for (int i = 0; i < numberOfSoldiers; i++) {
            circle.add(i + 1);
        }

        int killIndex = killStep - 1;
        int value;

        do {
            if (killIndex <= circle.size() - 1) {
                value = circle.remove(killIndex);
                eliminations.add(value);
                //System.out.println(value);
                killIndex += killStep - 1;
            } else {
                //System.out.println(circle);
                killIndex -= circle.size();
            }
        } while (circle.size() != numberOfSurvivors);

        // print result
        System.out.println("Survivors: ");
        System.out.println(circle);
        System.out.println("Order of eliminations: ");
        System.out.println(eliminations);
    }

    public static void main(String[] args)
    {
        Main.whoWillSurvive(41,2,1);
    }
}
