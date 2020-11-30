import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception
    {
        Variable board_arr[][];
        File file = new File("data/d-10-01.txt.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        st = br.readLine();
        String splitted[] = st.split("=");
        String splitted2[] = splitted[1].split(";");
        int n = Integer.parseInt(splitted2[0]);
        board_arr = new Variable[n][n];
        System.out.println("N's value:"+ n);
        br.readLine();
        br.readLine();
        int row_cnt=0;
        while ((st = br.readLine()) != null){
            System.out.println(st);
            String sp[] = st.split(", ");
            String last[] = sp[sp.length-1].split(" ");
            sp[sp.length-1] = last[0];
            for(int i=0;i<sp.length;i++){
                board_arr[row_cnt][i] = new Variable(row_cnt,i,Integer.parseInt(sp[i]));
            }
            row_cnt++;

        }
        System.out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board_arr[i][j].getVal()+" ");
            }
            System.out.println();
        }
        System.out.println();

        br.close();

        File file2;
        BufferedWriter bw;
        file2 = new File("output.txt");
        bw = new BufferedWriter(new FileWriter(file2));

        //BT
        System.out.println("BT+SDF:");
        bw.write("BT+");
        Board.Initialize();
        Board.BT(new Board(n,board_arr.clone()),"SDF",bw);
        System.out.println("BT+Random:");
        bw.write("BT+");
        Board.Initialize();
        Board.BT(new Board(n,board_arr.clone()),"Random",bw);
        System.out.println("BT+Brelaz:");
        bw.write("BT+");
        Board.Initialize();
        Board.BT(new Board(n,board_arr.clone()),"Brelaz",bw);
        System.out.println("BT+DomdDeg:");
        bw.write("BT+");
        Board.Initialize();
        Board.BT(new Board(n,board_arr.clone()),"DomdDeg",bw);

        //FC
        System.out.println("FC+SDF:");
        bw.write("FC+");
        Board.Initialize();
        Board.FC(new Board(n,board_arr.clone()),"SDF",bw);
        System.out.println("FC+Random:");
        bw.write("FC+");
        Board.Initialize();
        Board.FC(new Board(n,board_arr.clone()),"Random",bw);
        System.out.println("FC+Brelaz:");
        bw.write("FC+");
        Board.Initialize();
        Board.FC(new Board(n,board_arr.clone()),"Brelaz",bw);
        System.out.println("FC+Domddeg:");
        bw.write("FC+");
        Board.Initialize();
        Board.FC(new Board(n,board_arr.clone()),"DomdDeg",bw);
        bw.close();

    }

}
