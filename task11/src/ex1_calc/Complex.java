package ex1_calc;

class Complex{
    private double re,im;

    Complex(double re, double im)
    {
        this.re = re; this.im = im;}

    Complex (double re) {
        this(re, 0.0);
    }
    Complex() {
        this (0.0, 0.0);
    }
    Complex(Complex z) {
        this (z.re, z.im);
    }

    public double getRe() {
        return re;
    }
    public double getIm() {
        return im;
    }

    public void setRe (double re) {
        this.re = re;
    }
    public void setIm (double Im) {
        this.im = im;
    }
    public void setZ (Complex z) {
        this.re = z.re;
        this.im = z.im;
    }

    public String toString(){
        return  re + (im < 0.0 ? "" : " + ") + im + "i";
    }

}

