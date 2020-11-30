import java.util.Comparator;

public class ComparatorDomdeg implements Comparator<Variable> {


    @Override
    public int compare(Variable o1, Variable o2) {
        double domdeg1 = o1.getDomain_list().size()*1.0/o1.getS_deg();
        double domdeg2 = o2.getDomain_list().size()*1.0/o2.getS_deg();
        if(domdeg1 == domdeg2) return 0;
        else if(domdeg1 < domdeg2) return -1;
        else return 1;




    }
}
