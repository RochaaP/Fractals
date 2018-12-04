
public class Mandelbrot {
    
        private double real, imaginary;
       // private static int MAX =1000;
        
        //private pixel [] pixels; 
        
        public Mandelbrot (double real,double imaginary){
            this.real=real;
            this.imaginary=imaginary;
        }
        
  
     
       public int checkAbsolute(double real, double imaginary,int MAX){
            int iterations;
            ComplexNumbers C= new ComplexNumbers(0,0);
                    double abs=0;
                    for (iterations=0;iterations<MAX;iterations++){ 
                            ComplexNumbers sqr=C.getSqureValue();           //get the squre value of the complex number
                            C=sqr.addNumbers(real,imaginary);               //accoding to the given eqauation
                            abs=C.getAbsoluteValue();
                            if (abs>4 )
                               //System.out.printf("%d\n  ",iterations);
                                return iterations;
                    }
               // System.out.printf("%.5f    %.5f\n  ",re,im); 
               // fn=0;
           
            return iterations;    
    }      


} 