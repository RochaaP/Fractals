
public class ComplexNumbers {
        
    private double real, imaginary;
            
    public ComplexNumbers (double real,double imaginary){
        this.real=real;
        this.imaginary=imaginary;
    }
        
    public double getAbsoluteValue(){
        double x=this.real;
                double y=this.imaginary;
                
        return x*x+y*y;
    }
        
        
        public ComplexNumbers getSqureValue(){
                double x= this.real;
                double y= this.imaginary;
        
                
                double x2=x*x-y*y;
                double y2=2*x*y;
                
                ComplexNumbers C2= new ComplexNumbers(x2,y2);
        return C2;
        }
        
        public double getRealPart(){
        return this.real;
        }
    
        public double getImaginaryPart(){
        return this.imaginary;
        }

        public ComplexNumbers addNumbers(double a,double b){
            double x=this.real;
            double y=this.imaginary;
            //double z = c.getRealPart();
            //double p = c.getImaginaryPart();
            
            ComplexNumbers C= new ComplexNumbers(x+a,y+b);
            //double GetReal= sqr.getRealPart();
            return C;
        
        }
//        public ComplexNumbers substractNumbers(ComplexNumbers c){
//           double x=this.real;
//           double y=this.imaginary;    
//                   
//        return ;
//        }
    //public integer add(){
    //  this.real
    //}


}