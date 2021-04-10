package eu.lunekiska.scythd.utils;

import eu.lunekiska.scythd.Scythd;

import java.util.Calendar;
import java.util.Random;

public class MiscUtils
{
    private static final Random RANDOM = new Random(Calendar.getInstance().getTimeInMillis());
    public static int getRandomIntInRange(int min, int max)
    {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    public static String ID(String path)
    {
        return Scythd.MODID;
    }
}
