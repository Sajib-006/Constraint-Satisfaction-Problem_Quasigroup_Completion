import java.util.ArrayList;

public class Variable {
    int row_no;
    int col_no;
    int val;
    int s_deg;
    int d_deg;
    ArrayList<Integer> domain_list;

    public Variable() {
        this.row_no = -1;
        this.col_no = -1;
        this.val = -1;
    }

    public Variable(int val) {
        this.val = val;
    }

    public Variable(int row_no, int col_no, int val) {
        this.row_no = row_no;
        this.col_no = col_no;
        this.val = val;
    }

    public void setRow_no(int row_no) {
        this.row_no = row_no;
    }

    public void setCol_no(int col_no) {
        this.col_no = col_no;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setS_deg(int s_deg) {
        this.s_deg = s_deg;
    }

    public void setD_deg(int d_deg) {
        this.d_deg = d_deg;
    }

    public void setDomain_list(ArrayList<Integer> domain_list) {
        this.domain_list = domain_list;
    }

    public int getRow_no() {
        return row_no;
    }

    public int getCol_no() {
        return col_no;
    }

    public int getVal() {
        return val;
    }

    public int getS_deg() {
        return s_deg;
    }

    public int getD_deg() {
        return d_deg;
    }

    public ArrayList<Integer> getDomain_list() {
        return domain_list;
    }
}
