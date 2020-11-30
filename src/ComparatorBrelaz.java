import java.util.Comparator;

public class ComparatorBrelaz implements Comparator<Variable>{
    @Override
    public int compare(Variable o1, Variable o2) {
        if(o1.getDomain_list().size() < o2.getDomain_list().size()) return -1;
        else if(o1.getDomain_list().size() > o2.getDomain_list().size()) return 1;
        else{
            if(o1.getD_deg() == o2.getD_deg()) return 0;
            else if( o1.getD_deg() < o2.getD_deg()) return 1;
            else return -1;
        }
    }
}
