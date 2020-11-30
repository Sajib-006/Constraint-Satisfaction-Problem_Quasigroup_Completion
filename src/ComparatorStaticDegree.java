import java.util.Comparator;

public class ComparatorStaticDegree implements Comparator<Variable> {
    @Override
    public int compare(Variable o1, Variable o2) {
        if(o1.getS_deg() == o2.getS_deg()) return 0;
        else if( o1.getS_deg() < o2.getS_deg()) return 1;
        else return -1;
    }
}
