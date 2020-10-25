package Classes;

public class MyFloat
{
    long mantissa;
    long exponent;
    protected long prev_dot;
    protected long post_dot;

    public MyFloat(long mantissa, long exponent)
    {
        this.setMantissa(mantissa);
        this.setExponent(exponent);
        this.prev_dot = mantissa / power(exponent);
        this.post_dot = (mantissa % power(exponent));
    }


    //Mantissa Setter
    public void setMantissa(long mantissa) {
        this.mantissa = mantissa;
    }
    //Mantissa Getter
    public String getMantissa() {
        return Long.toString(mantissa);
    }


    //Exponent Setter
    public void setExponent(long exponent) {
        this.exponent = exponent;
    }
    //Exponent Getter
    public String getExponent() {
        return Long.toString(exponent);
    }


    //Процедура суммирования
    public void sum(MyFloat b)
    {
        long new_prev;
        long new_post;
        long max_exp = Math.max(b.exponent, this.exponent);

        if (b.exponent > this.exponent)
            this.post_dot = this.post_dot * power(b.exponent - this.exponent);
        else if (this.exponent > b.exponent)
            b.post_dot = b.post_dot * power(this.exponent - b.exponent);

        new_post = (this.post_dot + b.post_dot) % power(max_exp);
        new_prev = this.prev_dot + b.prev_dot + (this.post_dot + b.post_dot) / power(max_exp);

        System.out.println(new_prev + "." + new_post);
    }

    //Возведение 10 в степень exp
    public static long power(long powValue)
    {
        long result = 1;
        for (int i = 1; i <= powValue; i++) {
            result = result * 10;
        }
        return result;
    }

}


