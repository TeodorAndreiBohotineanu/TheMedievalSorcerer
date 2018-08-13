package Display;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame Frame; /// se pune private pentru ca altele nu ar trebui sa il vada
    private Canvas canvas; /// cu asta pot sa pun grafica in fereastra
    private String Title;
    private int width, height;
    public Display (String Title, int width, int height )
    {
        this.Title=Title;
        this.width=width;
        this.height=height;///se iau parametrii
        CreateDisplay( ); /// se apeleaza metoda CreateDisplay
    }

    private void CreateDisplay ( )
    {
        Frame= new JFrame(Title);/// titlul ferestrei
        Frame.setSize(width,height);///size-ul ferestrei
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /// ca sa se inchida properly, altfel merge in background
        Frame.setResizable(false); ///sa nu poata fi modificat
        Frame.setLocationRelativeTo(null);/// o sa puna fereastra in mijlocul ecranului
        Frame.setVisible(true); /// daca nu se pune nu se afiseaza fereastra... by default nu e afisata
        canvas= new Canvas ( );
        canvas.setPreferredSize(new Dimension(width,height));/// asa creez acel canvas in fereastra cu dimensiunile w,h
        canvas.setMaximumSize(new Dimension(width,height));///  sa fiu sigur ca nu depaseste zona ferestrei si
        canvas.setMinimumSize(new Dimension(width,height)); ///  ca totul e ok. basically sa stea la dimensiunile date
        canvas.setFocusable(false);
        Frame.add(canvas);
        Frame.pack( ); /// face putin resize astfel incat acel canvas sa se vada perfect
    }
    public  Canvas getCanvas ( ) /// se poate accesa canvas de peste tot oricand e nevoie;
    {
        return  canvas;
    }
    public JFrame getFrame( )
    {
        return Frame;
    }
}
