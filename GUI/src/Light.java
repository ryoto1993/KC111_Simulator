import java.util.ArrayList;

/**
 * Created by RyotoTomioka on 2016/06/02.
 */
public class Light {
    static int ID = 0;
    static int MINLUM = 0;
    static int MAXLUM = 100;

    private int id;
    private int x, y;
    private ArrayList<Integer> lum_history;

    public Light(int x, int y) {
        id = ID++;
        this.x = x;
        this.y = y;
    }

    public void appendHistory(int l) {
        lum_history.add(l);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
