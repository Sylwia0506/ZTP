package pl.wipb.ztp.ps3;

import java.util.ArrayList;
import java.util.List;

public class SegmentBuilder implements Builder{
    private char segmentType;
    protected final int TILESIZE = 32;
    protected int x = 4;
    protected int y = 4;
    protected List<Segment> plansza = new ArrayList<>();


    public void ustawY(int y) {
        this.y = y;
    }


    public int getY() {
        return y;
    }


    public void ustawX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int TILESIZE() {
        return TILESIZE;
    }


    public void stworzX(int tilesAmount) {
        x += tilesAmount * TILESIZE;
    }

    public void stworzA() {
        Segment s1 = new SegmentBlock(x, y, "block1.png");
        plansza.add(s1);
        x += TILESIZE;
    }


    public void stworzB() {
        Segment s2 = new SegmentBlockV(x, y, "block2.png");
        plansza.add(s2);
        x += TILESIZE;
    }


    public void stworzC() {
        Segment s3 = new Segment(x, y, "block3.png");
        plansza.add(s3);
        x += TILESIZE;
    }

    public void stworzG() {
        Segment s4 = new SegmentAnim(x, y, "bonus.png", new int[]{0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 2, 2, 1, 1, 1, 0, 0});
        plansza.add(s4);
        x += TILESIZE;
    }

    public List<Segment> getPlansza() {
        return plansza;
    }
}
