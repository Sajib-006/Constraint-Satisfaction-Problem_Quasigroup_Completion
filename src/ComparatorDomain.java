import java.util.Comparator;

public class ComparatorDomain implements Comparator<Variable> {
    @Override
    public int compare(Variable o1, Variable o2) {
        if(o1.getDomain_list().size() == o2.getDomain_list().size()) return 0;
        else if(o1.getDomain_list().size()< o2.getDomain_list().size()) return -1;
        else return 1;
    }
}
