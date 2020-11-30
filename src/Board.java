import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Board {

    int n;
    Variable[][] board;
    ArrayList<Variable> unassignedList;
    static int failed =0;
    static int visited = 0;

    public Board(int n, Variable[][] board) throws IOException {
        this.n = n;
        unassignedList = new ArrayList<Variable>();
        this.board = new Variable[n][n];
        int row,col,val;
        for(int i=0 ;i<n ;i++){
            for(int j=0; j<n; j++){
                row = board[i][j].getRow_no();
                col = board[i][j].getCol_no();
                val = board[i][j].getVal();
                this.board[i][j] = new Variable(row,col,val);
            }
        }
        //System.out.println("Before Initial calculation ");
        calculateUnassignedList();
        //System.out.println("unass ");
        calculateDomainList();
        //System.out.println("dom");
        calculateDynamicDegree();
        //System.out.println("Initial calculation done");
    }

    public Variable[][] getBoard() {
        return board;
    }

    public static void Initialize() {
        Board.visited = 0;
        Board.failed = 0;
    }
    public void calculateUnassignedList(){
        unassignedList = new ArrayList<Variable>();
        for(int i=0 ;i<n ;i++) {
            for (int j = 0; j < n; j++) {
                if(this.board[i][j].getVal()==0) unassignedList.add(this.board[i][j]);
            }
        }
        //System.out.println("Unassigned list size: "+unassignedList.size());
    }
    public void calculateDomainList(){

        for(int x=0; x<n; x++){
            for(int y=0; y<n; y++){
                ArrayList<Integer> dom=new ArrayList<>();
                ArrayList<Integer> dom_assigned=new ArrayList<>();
                Variable v = board[x][y];
                int row = v.getRow_no();
                int col = v.getCol_no();
                int c=0;
                while(c<n)
                {
                    if(board[row][c].getVal()!=0) dom_assigned.add(board[row][c].getVal());
                    c++;
                }
                int r=0;
                while(r<n)
                {
                    if(board[r][col].getVal()!=0) dom_assigned.add(board[r][col].getVal());
                    r++;
                }
                int numb =1;
                while(numb<=n)
                {
                    if(!dom_assigned.contains(numb))
                    {
                        dom.add(numb);
                    }
                    numb++;
                }
                board[x][y].setDomain_list(dom);
            }
        }


    }

    public void calculateDynamicDegree(){
        int x,y,i,j,total_deg;

        for(x=0; x<n; x++){
            for(y=0; y<n; y++){
                total_deg=0;
                Variable v = board[x][y];
                int row = v.getRow_no();
                int col = v.getCol_no();
                int c=0;
                while(c<n)
                {
                    if(board[row][c].getVal()==0) total_deg++;
                    c++;
                }
                int r=0;
                while(r<n)
                {
                    if(board[r][col].getVal()==0) total_deg++;
                    r++;
                }
                board[x][y].setD_deg(total_deg);
            }
        }
    }

    public void updateDomainList(){
        for(Variable v:unassignedList)
        {
            ArrayList<Integer> dom=new ArrayList<>();
            ArrayList<Integer> dom_assigned=new ArrayList<>();
            //Variable v = board[x][y];
            int row = v.getRow_no();
            int col = v.getCol_no();
            int c=0;
            while(c<n)
            {
                if(board[row][c].getVal()!=0) dom_assigned.add(board[row][c].getVal());
                c++;
            }
            int r=0;
            while(r<n)
            {
                if(board[r][col].getVal()!=0) dom_assigned.add(board[r][col].getVal());
                r++;
            }
            int numb =1;
            while(numb<=n)
            {
                if(!dom_assigned.contains(numb))
                {
                    dom.add(numb);
                }
                numb++;
            }

            board[row][col].setDomain_list(dom);
        }
    }
    public void updateDynamicDegree(){
        int total_deg=0;
        for(Variable v:unassignedList){
            total_deg=0;
            //Variable v = board[x][y];
            int row = v.getRow_no();
            int col = v.getCol_no();
            int c=0;
            while(c<n)
            {
                if(board[row][c].getVal()==0) total_deg++;
                c++;
            }
            int r=0;
            while(r<n)
            {
                if(board[r][col].getVal()==0) total_deg++;
                r++;
            }
            board[row][col].setD_deg(total_deg);
        }
    }
    public void printBoard(){
        int i,j;
        i=0;
        while(i<n){
            j=0;
            while(j<n){
                System.out.print(board[i][j].getVal()+" ");
                j++;
            }
            System.out.println();
            i++;
        }
        System.out.println();
    }

    public void printBoardFile(String type,BufferedWriter bw) throws IOException {

            if(type.equalsIgnoreCase("SDF"))
            {
                bw.write("SDF\n");
            }

            else if(type.equalsIgnoreCase("Random"))
            {
                bw.write("Random\n");
            }
            else if(type.equalsIgnoreCase("Brelaz"))
            {
                bw.write("Brelaz\n");
            }

            else if(type.equalsIgnoreCase("DomdDeg"))
            {
                bw.write("DomdDeg\n");
            }
            else {
                bw.write("Invalid heuristics!");
            }
            int i,j;
            i=0;
            while(i<n){
                j=0;
                while(j<n){
                    bw.write(board[i][j].getVal()+" ");
                    j++;
                }
                bw.write("\n");
                i++;
            }
            bw.write("\n\n");
            bw.write("Total Visited Node: "+visited+"\n");
            bw.write("Number of fails: "+failed+"\n\n\n");

    }

    public boolean checkNeighboursDomainFoundZero(Variable v){
        int i=0,j=0;
        while(i<n){
            if(board[v.getRow_no()][i].getDomain_list().size()==0 && i!=v.getCol_no()) return true;
            i++;
        }
        while(j<n){
            if(board[j][v.getCol_no()].getDomain_list().size()==0 && j!=v.getRow_no()) return true;
            j++;
        }
        return false;
    }
    public void updateBoard(Variable v){
        this.board[v.getRow_no()][v.getCol_no()]=v;
    }
    public static boolean VariableOrdering(Board board, String type){
        if(type.equalsIgnoreCase("SDF"))
        {
            board.unassignedList.sort(new ComparatorDomain());
        }

        else if(type.equalsIgnoreCase("Random"))
        {
            //Sort not needed
        }
        else if(type.equalsIgnoreCase("Brelaz"))
        {
            board.unassignedList.sort(new ComparatorBrelaz() );
        }

        else if(type.equalsIgnoreCase("DomdDeg"))
        {
            board.unassignedList.sort(new ComparatorDomdDeg() );
        }
        else {
            System.out.println("Invalid heuristics!");
            return false ;
        }
        return true;
    }



    public static boolean BT(Board board, String type,BufferedWriter bw) throws IOException {
        //System.out.println("hello BT");
        //base case
        if(board.unassignedList.size()==0)
        {
            board.printBoard();
            board.printBoardFile(type,bw);
            System.out.println("Total Visited Node: "+visited);
            System.out.println("Number of fails: "+failed);
            System.out.println();
            System.out.println();
            return true;
        }
        boolean ordered =VariableOrdering(board,type);
        if(!ordered) return false;
        Variable variable = board.unassignedList.get(0);
        //System.out.println("Unassigned list size: "+board.unassignedList.size());
         for(int i=0; i<variable.getDomain_list().size(); i++){
            int x = variable.getDomain_list().get(i);
            visited++;
            //System.out.println("Visited: "+visited);
            variable.setVal(x);
            board.updateBoard(variable);
            board.calculateUnassignedList();
            board.calculateDomainList();
            board.calculateDynamicDegree();
            boolean ret = BT(board, type, bw);
            if (ret) return true;
            failed++;
            //System.out.println("Failed: "+failed);
            variable.setVal(0);
            board.updateBoard(variable);
            board.calculateUnassignedList();
            board.calculateDomainList();
            board.calculateDynamicDegree();

        }
        return false;
    }

    public static boolean FC(Board board,String type,BufferedWriter bw) throws IOException {
        //System.out.println("hello FC");
        //base case
        if(board.unassignedList.size()==0)
        {
            board.printBoard();
            board.printBoardFile(type,bw);
            System.out.println("Total Visited Node: "+visited);
            System.out.println("Number of fails: "+failed);
            System.out.println();
            System.out.println();
            return true;
        }
        boolean ordered = VariableOrdering(board,type);
        if(!ordered) return false;
        Variable variable = board.unassignedList.get(0);
        if(variable.getDomain_list().size()==0) return false;

        //System.out.println("Unassigned list size: "+board.unassignedList.size());
        for(int i=0; i<variable.getDomain_list().size(); i++){

            int x = variable.getDomain_list().get(i);
            variable.setVal(x);
            visited++;
            //System.out.println("Visited: "+visited);
            Board prevBoard=new Board(board.n, board.getBoard().clone());
            board.updateBoard(variable);
            board.calculateUnassignedList();
            board.updateDomainList();
            board.updateDynamicDegree();
            boolean result;
            if(!board.checkNeighboursDomainFoundZero(variable)) {
                result = FC(board, type,bw);
                if (result) return true;
            }

            failed++;
            //System.out.println("Failed: "+failed);
            variable.setVal(0);
            board.updateBoard(variable);
            board.calculateUnassignedList();
            board.updateDomainList();
            board.updateDynamicDegree();


        }
        return false;
    }

}
