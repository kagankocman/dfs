import javax.swing.*;

public class Btn extends JButton {
    private int row,col;
    private boolean duvar,engel;
    public Btn(int row,int col){
        this.row=row;
        this.col=col;
        this.duvar=false;
        this.engel=false;
    }
}
