//Nico Mingkun Xia
package FunctionOptimization;

import java.util.*;

public class HillClimbing{

    //f1(x,y)
    public static double f_1(double x, double y){
        return Math.sin(2.0*x)+Math.cos(y/2);
    }
    //f2(x,y)
    public static double f_2(double x, double y){
        return Math.abs(x-2) + Math.abs(0.5*y+1)-4;
    }

    public static double[] calculate_f1(double x, double y, double step_size){
        double[] d = new double[2];
        double largest = f_1(x,y);
        HashMap<Double, double[]> m = new HashMap<>();
        double[][] results = new double[8][2];
        int counter = 0;
        for(int j = 0; j<1000; j++) {
            double x1 = Math.min(x+step_size,10.0);
            double x2 = Math.max(x-step_size,0.0);
            double y1 = Math.min(y+step_size,10.0);
            double y2 = Math.max(y-step_size,0.0);

            results[0][0] = x; results[0][1] = y1;
            results[1][0] = x; results[1][1] = y2;
            results[2][0] = x1; results[2][1] = y;
            results[3][0] = x1; results[3][1] = y1;
            results[4][0] = x1; results[4][1] = y2;
            results[5][0] = x2; results[5][1] = y;
            results[6][0] = x2; results[6][1] = y1;
            results[7][0] = x2; results[7][1] = y2;
            m.put(f_1(x,y1), results[0]);
            m.put(f_1(x,y2), results[1]);
            m.put(f_1(x1,y), results[2]);
            m.put(f_1(x1,y1), results[3]);
            m.put(f_1(x1,y2), results[4]);
            m.put(f_1(x2,y), results[5]);
            m.put(f_1(x2,y1), results[6]);
            m.put(f_1(x2,y2), results[7]);

            double a = Collections.max(m.keySet());
            if (a>largest) {
                largest = a;
                x = m.get(a)[0];
                y = m.get(a)[1];
                counter ++ ;
            }
    }
        System.out.println(largest+"   "+counter);
        d[0] = counter;
        d[1] = largest;
        return d;
    }
    public static double[] calculate_f2(double x, double y, double step_size) {
        double[] d = new double[2];
        double largest = f_2(x,y);
        HashMap<Double, double[]> m = new HashMap<>();
        double[][] results = new double[8][2];
        int counter = 0;
        for(int j = 0; j<5000; j++) {
            double x1 = Math.min(x+step_size,10.0);
            double x2 = Math.max(x-step_size,0.0);
            double y1 = Math.min(y+step_size,10.0);
            double y2 = Math.max(y-step_size,0.0);

            results[0][0] = x; results[0][1] = y1;
            results[1][0] = x; results[1][1] = y2;
            results[2][0] = x1; results[2][1] = y;
            results[3][0] = x1; results[3][1] = y1;
            results[4][0] = x1; results[4][1] = y2;
            results[5][0] = x2; results[5][1] = y;
            results[6][0] = x2; results[6][1] = y1;
            results[7][0] = x2; results[7][1] = y2;
            m.put(f_2(x,y1), results[0]);
            m.put(f_2(x,y2), results[1]);
            m.put(f_2(x1,y), results[2]);
            m.put(f_2(x1,y1), results[3]);
            m.put(f_2(x1,y2), results[4]);
            m.put(f_2(x2,y), results[5]);
            m.put(f_2(x2,y1), results[6]);
            m.put(f_2(x2,y2), results[7]);

            double a = Collections.max(m.keySet());
            if (a>largest) {
                largest = a;
                x = m.get(a)[0];
                y = m.get(a)[1];
                counter ++ ;
            }
        }
        System.out.println(largest+"   "+counter);
        d[0] = counter;
        d[1] = largest;
        return d;

    }


    public static void main(String[] args) {
        List<Double> numOfCounts_f1 = new ArrayList<>();
        List<Double> numOfCounts_f2 = new ArrayList<>();
        List<Double> values_f1 = new ArrayList<>();
        List<Double> values_f2 = new ArrayList<>();
        for(int i = 1; i <=100; i++) {
            double step_size = 0.01 ;
            double x = 10 * Math.random();
            double y = 10 * Math.random();
            numOfCounts_f1.add(calculate_f1(x,y,step_size)[0]);
            numOfCounts_f2.add(calculate_f2(x,y,step_size)[0]);
            values_f1.add(calculate_f1(x,y,step_size)[1]);
            values_f2.add(calculate_f2(x,y,step_size)[1]);
        }

        System.out.println("step size: 0.01");
        System.out.println("function1: mean of the number of steps to convergence: " + calMean(numOfCounts_f1));
        System.out.println("function1: standard deviation of the number of steps to convergence: " + calStd(numOfCounts_f1));
        System.out.println("function1: mean of final values: " + calMean(values_f1));
        System.out.println("function1: standard deviation of final values: " + calStd(values_f1));
        System.out.println("function2: mean of the number of steps to convergence:: " + calMean(numOfCounts_f2));
        System.out.println("function2: standard deviation of the number of steps to convergence: " + calStd(numOfCounts_f2));
        System.out.println("function2: mean of final values: " + calMean(values_f2));
        System.out.println("function2: standard deviation of final values: " + calStd(values_f2));

    }

    public static double calMean(List<Double> l){
        double sum = 0;
        for(double num : l){
            sum+=num;
        }
        return sum/l.size();
    }
    public static double calStd(List<Double> l){
        double std = 0;
        double mean = calMean(l);
        for(double num : l){
            std += Math.pow(num-mean,2);
        }
        std = std/l.size();
        return Math.pow(std,0.5);
    }



}




