import java.util.ArrayList;

/**
 * Created by RyotoTomioka on 2016/06/02.
 */
public class Light {
    static int ID = 0;

    private int id;
    private int x, y;
    private ArrayList<Integer> lum_history;

    public Light(int x, int y) {
        id = ID++;
        this.x = x;
        this.y = y;
    }
}
