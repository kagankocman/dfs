import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Robot {
    private Stack<String> tutStack = new Stack<>();
    private Stack<String> donenStack = new Stack<>();
    private Stack<String> stack = new Stack<>();
    private Random random = new Random();

    String konum = "0,0";
    String s;
    String tmp;
    int[][] labirent;
    public int[] array = new int[2];

    public Stack rotaOlustur(int[][] a) {
        labirent = a;
        tutStack.push(konum);
        String sonIndis = (labirent.length-1) + "," + (labirent.length-1);
        while (!(tutStack.peek().equals(sonIndis))) {
            s = tutStack.peek();
            String[] bol = s.split(",");
            array[0] = Integer.parseInt(bol[0]);
            array[1] = Integer.parseInt(bol[1]);
            ArrayList<String> komsus = komsBul(array);
            if (!(komsus.isEmpty())) {
                rndmEkle(komsus);
            } else {
                tmp = tutStack.pop();
                stack.push(tmp);
            }
            }
        while(!tutStack.isEmpty()){
          String d=tutStack.pop();
            donenStack.push(d);
        }
            return donenStack;
        }
        private ArrayList<String> komsBul ( int[] array){
            ArrayList<String> komsus = new ArrayList<>();
            for (int y = array[1] - 1; y < array[1] + 2; y++) {
                for (int x = array[0] - 1; x < array[0] + 2; x++) {
                    if (x >= 0 && y >= 0 && x < labirent.length && y < labirent.length) {
                        if (x == array[0] || y == array[1]) {
                            if (!(x == array[0] && y == array[1])) {
                                String birlestir = x + "," + y;
                                if (labirent[x][y] == 1 && tutStack.search(birlestir) < 0) {
                                    if (!birlestir.equals(tmp)) {
                                       if(stack.search(birlestir)<0){
                                           komsus.add(birlestir);
                                       }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return komsus;
        }
        private void rndmEkle (ArrayList < String > st) {
            int hedef;
            hedef = random.nextInt(st.size());
            tutStack.push(st.remove(hedef));
        }
    }




