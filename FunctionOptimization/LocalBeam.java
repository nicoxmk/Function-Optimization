package COMP424_A1;

import java.util.*;

public class LocalBeam {
    //f1(x,y)
    public static double f_1(double x, double y){
        return Math.sin(2.0*x)+Math.cos(y/2);
    }
    //f2(x,y)
    public static double f_2(double x, double y){
        return Math.abs(x-2) + Math.abs(0.5*y+1)-4;
    }

    public static double[] calculate_f1(double[] xs, double[] ys, int beam, double step_size){
        List<Double> originalResult = new ArrayList<>();
        double[] d = new double[2];
        for(int i =0; i<beam; i++){
            originalResult.add(f_1(xs[i],ys[i]));
        }
        originalResult.sort(new Comparator<Double>() {
            @Override
            public int compare(Double d1, Double d2) {
                return d2.compareTo(d1);
            }
        });
        HashMap<Double, double[][]> m = new HashMap<>();
        double[][][] neighbors = new double[beam][8][2];
        //double x_neighbors[][] = new double[beam][8];
        //double y_neighbors[][] = new double[beam][8];
        int counter = 0;
        for(int i = 0; i < 1000; i++){
            for(int j = 0; j < beam; j++){
                neighbors[j][0][0] = xs[j];
                neighbors[j][0][1] = Math.min(ys[j]+step_size,10.0);
                neighbors[j][1][0] = xs[j];
                neighbors[j][1][1] = Math.max(ys[j]-step_size,0.0);
                neighbors[j][2][0] = Math.min(xs[j]+step_size,10.0);
                neighbors[j][2][1] = ys[j];
                neighbors[j][3][0] = Math.min(xs[j]+step_size,10.0);
                neighbors[j][3][1] = Math.min(ys[j]+step_size,10.0);
                neighbors[j][4][0] = Math.min(xs[j]+step_size,10.0);
                neighbors[j][4][1] = Math.max(ys[j]-step_size,0.0);
                neighbors[j][5][0] = Math.max(xs[j]-step_size,0.0);
                neighbors[j][5][1] = ys[j];
                neighbors[j][6][0] = Math.max(xs[j]-step_size,0.0);
                neighbors[j][6][1] = Math.min(ys[j]+step_size,10.0);
                neighbors[j][7][0] = Math.max(xs[j]-step_size,0.0);
                neighbors[j][7][1] = Math.max(ys[j]-step_size,0.0);
            }

            for(int k = 0; k < beam; k++){
                for(int j = 0; j < 8 ; j++){
                    double value = f_1(neighbors[k][j][0],neighbors[k][j][1]);
                    if(value > originalResult.get(0)){
                        for(int n = 0; n < beam; n++){
                            if(f_1(xs[n],ys[n])==originalResult.get(0)){
                                xs[n] = neighbors[k][j][0];
                                ys[n] = neighbors[k][j][1];
                            }
                        }
                        originalResult.add(0,value);
                        originalResult.remove(1);
                        counter++;
                    }
                }

            }

        }
        System.out.println(originalResult.get(0)+"   "+counter);
        d[0] = counter;
        d[1] = originalResult.get(0);
        return d;
    }
    public static double[] calculate_f2(double[] xs, double[] ys, int beam, double step_size){
        List<Double> originalResult = new ArrayList<>();
        double[] d = new double[2];
        for(int i =0; i<beam; i++){
            originalResult.add(f_2(xs[i],ys[i]));
        }
        originalResult.sort(new Comparator<Double>() {
            @Override
            public int compare(Double d1, Double d2) {
                return d2.compareTo(d1);
            }
        });
        HashMap<Double, double[][]> m = new HashMap<>();
        double[][][] neighbors = new double[beam][8][2];
        //double x_neighbors[][] = new double[beam][8];
        //double y_neighbors[][] = new double[beam][8];
        int counter = 0;
        for(int i = 0; i < 1000; i++){
            for(int j = 0; j < beam; j++){
                    neighbors[j][0][0] = xs[j];
                    neighbors[j][0][1] = Math.min(ys[j]+step_size,10.0);
                    neighbors[j][1][0] = xs[j];
                    neighbors[j][1][1] = Math.max(ys[j]-step_size,0.0);
                    neighbors[j][2][0] = Math.min(xs[j]+step_size,10.0);
                    neighbors[j][2][1] = ys[j];
                    neighbors[j][3][0] = Math.min(xs[j]+step_size,10.0);
                    neighbors[j][3][1] = Math.min(ys[j]+step_size,10.0);
                    neighbors[j][4][0] = Math.min(xs[j]+step_size,10.0);
                    neighbors[j][4][1] = Math.max(ys[j]-step_size,0.0);
                    neighbors[j][5][0] = Math.max(xs[j]-step_size,0.0);
                    neighbors[j][5][1] = ys[j];
                    neighbors[j][6][0] = Math.max(xs[j]-step_size,0.0);
                    neighbors[j][6][1] = Math.min(ys[j]+step_size,10.0);
                    neighbors[j][7][0] = Math.max(xs[j]-step_size,0.0);
                    neighbors[j][7][1] = Math.max(ys[j]-step_size,0.0);
            }

            for(int k = 0; k < beam; k++){
                for(int j = 0; j < 8 ; j++){
                    double value = f_2(neighbors[k][j][0],neighbors[k][j][1]);
                    if(value > originalResult.get(0)){
                        for(int n = 0; n < beam; n++){
                            if(f_2(xs[n],ys[n])==originalResult.get(0)){
                                xs[n] = neighbors[k][j][0];
                                ys[n] = neighbors[k][j][1];
                            }
                        }
                        originalResult.add(0,value);
                        originalResult.remove(1);
                        counter++;
                    }
                }
            }
        }
        System.out.println(originalResult.get(0)+"   "+counter);
        d[0] = counter;
        d[1] = originalResult.get(0);
        return d;
    }

    public static void main(String[] args) {
        ArrayList<Double> numOfCounts_f1 = new ArrayList<>();
        ArrayList<Double> numOfCounts_f2 = new ArrayList<>();
        ArrayList<Double> values_f1 = new ArrayList<>();
        ArrayList<Double> values_f2 = new ArrayList<>();

        int beam = 4;
        double step_size = 0.01;

        for(int i = 1; i <=100; i++) {
            double[] xs = new double[beam];
            double[] ys = new double[beam];
            for(int j = 0; j<beam; j++){
                xs[j] = 10*Math.random();
                ys[j] = 10*Math.random();
            }
            numOfCounts_f1.add(calculate_f1(xs,ys,beam,step_size)[0]);
            numOfCounts_f2.add(calculate_f2(xs,ys,beam,step_size)[0]);
            values_f1.add(calculate_f1(xs,ys,beam,step_size)[1]);
           values_f2.add(calculate_f2(xs,ys,beam,step_size)[1]);

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
