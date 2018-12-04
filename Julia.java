
public class Julia {
        private double real, imaginary;
        //private static int MAX =1000;

   public Julia (double real,double imaginary){
                this.real=real;
                this.imaginary=imaginary;
    }
    

          public int CheckJulia(double real, double imaginary,int  MAX,double cReal,double cImag){
            int iterations;
            ComplexNumbers C= new ComplexNumbers(real,imaginary);
            
            for (iterations=0;iterations<MAX;iterations++){ 
                ComplexNumbers sqr=C.getSqureValue();
                C=sqr.addNumbers(cReal , cImag);
                double abs=C.getAbsoluteValue();
                    //System.out.printf("%.5f\n  ",abs);
                if(abs>4){
                    //System.out.printf("%d\n  ",iterations);
                    break;}
            }



            return iterations;

        }    
    
    
    
}