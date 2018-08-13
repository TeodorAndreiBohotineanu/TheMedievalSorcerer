package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils
{
    public static String LoadFileAsString(String path)
    {
        StringBuilder builder = new StringBuilder();
        try
        {
            BufferedReader br =  new BufferedReader(new FileReader(path));
            String line;
            while ((line=br.readLine()) != null) /// e la fel ca !f.eof ( )
                builder.append(line + "\n");
            br.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return builder.toString();
    }
    public static int parseInt (String number) /// din 5 de caracter converteste la 5 intreg
    {
        try
        {
            return Integer.parseInt(number);
        }catch(NumberFormatException e)
        {
            e.printStackTrace();
            return 0;
        }
    }
}
