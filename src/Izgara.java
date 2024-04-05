import java.util.*;

public class Izgara {
    String konum="0,0";
    String str;
    int boyut;
    private Stack<String> st = new Stack<>();
    private Random rndm = new Random();
    private int[][] labirent;
    public int[] dizi= new int[2];

    public int[][] izgaraOlustur(int t){
        boyut=t;
        labirent=new int[boyut][boyut];
        st.push(konum);
        while(!st.empty()){
            str = st.pop();
            String[] a= str.split(",");
            dizi[0]= Integer.parseInt(a[0]);
            dizi[1]=Integer.parseInt(a[1]);
            if(sonrakiHucre(dizi)) {
                labirent[dizi[0]][dizi[1]] =1;
                ArrayList<String> komsular = komsulariBul(dizi);
                randomStackaEkle(komsular);
            }
        }

        return labirent;
    }

    private boolean sonrakiHucre (int[] dizi){
        int komsuSay=0;
        for(int y = dizi[1]-1; y < dizi[1]+2; y++ ){
            for( int x = dizi[0]-1 ; x < dizi[0]+2; x++){
                if(x >= 0 && y >= 0 && x < boyut && y < boyut){
                    if(!(x == dizi[0] && y == dizi[1])){
                        if(labirent[x][y]==1){
                            komsuSay++;
                        }
                    }
                }
            }
        }
        return (komsuSay < 3) && labirent[dizi[1]][dizi[0]]!= 1;
    }
    private ArrayList<String> komsulariBul(int[] dizi)
    {
        ArrayList<String> komsular = new ArrayList<>();
        for( int y = dizi[1]-1; y < dizi[1]+2; y++){
            for(int x = dizi[0]-1; x < dizi[0]+2; x++ ){
                if(x >=0 && y >=0 && x < boyut && y< boyut){
                    if(x == dizi[0] || y ==dizi[1]) //1,1deyken 2,2 gelmesin diye
                    {
                        if(!(x == dizi[0] && y == dizi[1])){
                            String b = x + "," + y;
                            komsular.add(b);
                        }
                    }
                }
            }
        }
        return komsular;
    }

    private void randomStackaEkle(ArrayList<String> str){
        int hedef;
        while(!str.isEmpty()){
            hedef=rndm.nextInt(str.size());
            String[] bol = str.get(hedef).split(",");
            if(st.search(str.get(hedef))<0 && labirent[Integer.parseInt(bol[0])][Integer.parseInt(bol[1])] ==0){
                st.push(str.remove(hedef));
            }else{
                str.remove(hedef);
            }
        }
    }
}