import java.awt.*; /* java abstract window toolkit */
import java.awt.geom.Line2D;
import java.awt.Color;
import javax.swing.*;
import static java.lang.Math.*;

class Fractal extends JPanel { // inherit JPanel 

    private static int WIDTH=800, HEIGHT=800,MAX;
    private static double lowerReal,upperReal,upperImag,lowerImag,cValueReal,cValueImag;
    private double real,imaginary;
//    private static int CHEIGHT=HEIGHT/2,CWIDTH=WIDTH/2;
//    private static double SHEIGHT=1.0/CHEIGHT, SWIDTH=1.0/CHEIGHT;
    private static String test;
    
    //private Point [] triangle; 
    private static int points = 100; 

    public Fractal(double real, double imaginary) { 
	// set the panel size 
	this.real=real;
	this.imaginary=imaginary; 
        setPreferredSize(new Dimension(800, 800));

	
    }
     
    private static void printPoint(Graphics2D frame, Color c, Point p) {

	frame.setColor(c); 
	frame.draw(new Line2D.Double(p.getX(), p.getY(), p.getX(), p.getY())); 
    }

    public void paintComponent(Graphics g) { 
	// call paintComponent from parent class 
	super.paintComponent(g); 

	
        setPreferredSize(new Dimension(800, 800));
	//Random ran = new Random(); 
        int points = Fractal.points; 
        Mandelbrot drawMandelbrot = new Mandelbrot(0,0);
        Julia drawJulia = new Julia(0,0);
        

	//while(points-- > 0) { 
	for(int i=0;i<HEIGHT;i++){
                
                for(int j=0;j<WIDTH;j++){  
                        
                        double re= lowerReal + (j*(abs(lowerReal)+abs(upperReal)))/800;
                        double im= -upperImag +(i*(abs(upperImag)+abs(lowerImag)))/800;
                    
                    
                    
//                        double re=(j-CWIDTH)*SWIDTH;
//                        double im=(i-CHEIGHT)*SHEIGHT;    
                        //check the required fractal..
                        if(test.equals("Mandelbrot")){                            
                            int value =drawMandelbrot.checkAbsolute(re, im, MAX);
                       
                            if (value==1000)                                    //the number of interations
                                printPoint((Graphics2D)g, Color.BLACK, new Point(j,i));
                           // System.out.println(value);
//                            else
                              //  printPoint((Graphics2D)g, Color.WHITE, new Point(j,i));
                            else                    
                                printPoint((Graphics2D)g, Color.getHSBColor(0.05811f*value, 0.052f*value, 0.0283f*value), new Point(j,i));              
                                              
                                //printPoint((Graphics2D)g, Color.BLUE, new Point(j,i));
//                            else if(value>2 & value<4)
//                               printPoint((Graphics2D)g, Color.getHSBColor(0.56f, 1.0f, 0.8f), new Point(j,i));
//                            else if(value>4 & value<6)
//                               printPoint((Graphics2D)g, Color.getHSBColor(5+value/100, 7*value/255, 8+2*value/255), new Point(j,i));                        //System.out.println(re+","+im);
//                            else if(value>6 & value<8)
//                               printPoint((Graphics2D)g, Color.getHSBColor(value/255, 145+value/255, 2*value/25), new Point(j,i));
//                            else if(value>8 & value<12)
//                               printPoint((Graphics2D)g, Color.getHSBColor(10+value/255, 8*value/255, 78+2*value/255), new Point(j,i));
//                            else if(value>700 & value<800)
//                                printPoint((Graphics2D)g, Color.BLUE, new Point(j,i));
//                             else if(value>800)
//                                printPoint((Graphics2D)g, Color.GREEN, new Point(j,i));
                        }
                        //if the required fractal is Julia,
                        if(test.equals("Julia")){   
                            int value = drawJulia.CheckJulia(re,im,MAX,cValueReal,cValueImag);
                            printPoint((Graphics2D)g, Color.getHSBColor(0.00011f*value, 0.00547f*value, 0.025f*value), new Point(i,j));
                            //printPoint((Graphics2D)g, Color.getHSBColor(0.102f*value,0.0712f*value, 0.028f*value), new Point(i,j));
                            
                            
                            
                            //System.out.println(cValueImag");
                   
//                        if (value>1.7 & value<26)
//                            printPoint((Graphics2D)g, Color.getHSBColor(0.9f*value, 0.0005f*value, 0.075f*value), new Point(j,i));                
//                         if(value>25 & value<=40)
//                            printPoint((Graphics2D)g, Color.WHITE, new Point(j,i));      
//                        else if(value>40 & value<60)
//                            printPoint((Graphics2D)g, Color.BLUE, new Point(j,i));
//                        System.out.println(re+","+im);
//                         else if(value>59 & value<75)
//                            printPoint((Graphics2D)g, Color.GREEN, new Point(j,i));
//                        else if(value>75& value<101)
//                            printPoint((Graphics2D)g, Color.ORANGE, new Point(j,i));
//			             else if(value>100 & value<150)
//                            printPoint((Graphics2D)g, Color.BLUE, new Point(j,i));
//                         else if(value>250)
//                           printPoint((Graphics2D)g, Color.GREEN, new Point(j,i));
                } 
                        //printPoint((Graphics2D)g, Color.GREEN, new Point(re,im));
            
	}

    }
}
   
    public static void main(String [] args) {
        test = args[0];
        if(args[0].equals("Mandelbrot")){
           
            if(args.length==1){                     //for one argument
                lowerReal=-1;
                upperReal=1;
                lowerImag=-1;
                upperImag=1;
                MAX=1000;

            }
            else if(args.length==5){                        // for 5  arguments 
		lowerReal=Double.parseDouble(args[1]);
		upperReal=Double.parseDouble(args[2]);
		lowerImag=Double.parseDouble(args[3]);
		upperImag=Double.parseDouble(args[4]);
		MAX=1000;
            }
                else if(args.length==6){                    //for 6 arguments
               lowerReal= Double.parseDouble(args[1]);
               upperReal= Double.parseDouble(args[2]);
               lowerImag= Double.parseDouble(args[3]);
               upperImag= Double.parseDouble(args[4]);
               MAX= Integer.parseInt(args[5]);
              }
        }
        if(args[0].equals("Julia")){
            lowerReal=-1;upperReal=1;
            lowerImag=-1;upperImag=1;
                
                if(args.length==1){                         //for 1 arguments
                    cValueReal=-0.4;
                    cValueImag=0.6;
                    MAX=1000;
                    //System.out.println(args[0]+  " l " );
                }
                
                if(args.length==3){                          //for 3 arguments
                    cValueReal=Double.parseDouble(args[1]); 
                    cValueImag=Double.parseDouble(args[2]);
                    MAX=1000;
                }
                
            }
        
        
        
        
        
        
//                double static diameter1= double.valueOf(args[1]);
//               int l++;
//            }
       // }
//
//        else if (args[0].equals("Julia")){
//            ;
//        }
                
//        lowerReal=1.0;
//        upperReal=1.0;
        
// create a frame
        
        JFrame frame = new JFrame("Fractal");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	// set the content of the frame as one of this panel
	frame.setContentPane(new Fractal(800, 800)); 

	frame.pack(); 
	frame.setLocationRelativeTo(null); 
	frame.setVisible(true); 
    
        }
    }
    