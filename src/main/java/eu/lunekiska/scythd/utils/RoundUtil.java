package eu.lunekiska.scythd.utils;

public class RoundUtil
{
    public static int roundThat(Float n)
    {
        return (int)(n % 1 > 0.5 ? Math.ceil(n) : Math.floor(n));
    }

    public static int roundThat(Double n)
    {
        return (int)(n % 1 > 0.5 ? Math.ceil(n) : Math.floor(n));
    }
}
