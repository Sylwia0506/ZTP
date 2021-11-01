package pl.wipb.ztp.ps3;

import java.util.List;

public interface Builder {

    void stworzX(int tilesAmount);
    void ustawX(int x);
    void ustawY(int y);
    void stworzA();
    void stworzB();
    void stworzC();
    void stworzG();
    int getY();
    int TILESIZE();
    List<Segment> getPlansza();
}
