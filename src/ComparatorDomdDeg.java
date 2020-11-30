import java.util.Comparator;

public class ComparatorDomdDeg implements Comparator<Variable> {


    @Override
    public int compare(Variable o1, Variable o2) {
        double domddeg1 = o1.getDomain_list().size()*1.0/o1.getD_deg();
        double domddeg2 = o2.getDomain_list().size()*1.0/o2.getD_deg();
        if(domddeg1 == domddeg2) return 0;
        else if(domddeg1 < domddeg2) return -1;
        else return 1;




    }
}
