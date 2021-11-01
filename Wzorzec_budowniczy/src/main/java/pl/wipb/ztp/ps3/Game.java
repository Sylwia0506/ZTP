package pl.wipb.ztp.ps3;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


class Game extends JPanel {
    private final int TILESIZE = 32;
    private final Sprite sprite;
    private List<Segment> plansza;
    Builder segmentB;

    private void stworzPlansze(String plik, Builder segmentB) {
        
        BufferedReader br = null;
        try {
            InputStream pFile = getClass().getResourceAsStream(plik);
            br = new BufferedReader(new InputStreamReader(pFile));
            List<Segment> plansza = new ArrayList<>(); 
            String linia;
            int liczba;
            int znaki;
            char znak;
            char cyfra1;
            char cyfra2;

            while ((linia = br.readLine()) != null) {
                segmentB.ustawX(4);
                znaki = 0;
                while ((linia.length() - znaki) >= 3) {
                    znak = linia.charAt(znaki++);
                    cyfra1 = linia.charAt(znaki++);
                    cyfra2 = linia.charAt(znaki++);
                    liczba = (cyfra1 - '0') * 10 + (cyfra2 - '0');
                    switch (znak) {
                        case 'X':
                            segmentB.stworzX(liczba);
                            break;
                        case 'A':
                            for (int i = 0; i < liczba; ++i) {
                                segmentB.stworzA();
                            }
                            break;
                        case 'B':
                            for (int i = 0; i < liczba; ++i) {
                                segmentB.stworzB();
                            }
                            break;
                        case 'C':
                            for (int i = 0; i < liczba; ++i) {
                                segmentB.stworzC();
                            }
                            break;
                        case 'G':
                            for (int i = 0; i < liczba; ++i) {
                                segmentB.stworzG();
                            }
                            break;
                    }
                }

                segmentB.ustawY(segmentB.TILESIZE() + segmentB.getY());
            }
            br.close();

        } catch (IOException e) {
            System.out.println("Blad wczytania planszy");
            e.printStackTrace();
        }
    }

    public Game(String plik) {
        setPreferredSize(new Dimension(424, 268));
        setFocusable(true);
        segmentB = new SegmentBuilder2();
        stworzPlansze(plik, segmentB);
        plansza = segmentB.getPlansza();
        sprite = new Sprite(plansza, "mario.png");
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev) {
                switch (ev.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_RIGHT:
                        sprite.stop();
                        break;
                }
            }

            @Override
            public void keyPressed(KeyEvent ev) {
                switch (ev.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        sprite.left();
                        break;
                    case KeyEvent.VK_RIGHT:
                        sprite.right();
                        break;
                    case KeyEvent.VK_SPACE:
                    case KeyEvent.VK_UP:
                        sprite.jump();
                        break;
                }
            }
        });
        
        new Thread(new SpriteController(sprite, plansza, this)).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Segment s : plansza) {
            s.draw(g);
        }
        sprite.draw(g);
    }
    
}
