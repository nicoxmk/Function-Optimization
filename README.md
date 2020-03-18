# Function-Optimization
Hill Climbing and Local Beam Search are two mathematical optimization techniques.  
In these files, I intend to maximize functions within the range of x>=0, y<=10  

The two sample functions that I use are:   
f1(x,y) = sin(2x) + cos(y / 2)  
f2(x,y) = |x - 2| + |0.5y + 1| - 4  

For Hill Climbing, starting from 100 random points in the range. Repeat this procedure for each choice of step size in [0.01, 0.05, 0.1, 0.2]. A neighbor is a point where x and/or y has has increased or decreased by the stepsize; i.e., there are up to 8 neighbours from any given point.  

For Local Beam Search, use with beam with in [2, 4, 8, 16], performing 100 runs of each.

For each part above and each setting, report the mean and standard deviation of the number of steps to convergence and of the final values of f1*, f2* for each case.  

RESULTS:  
Beam Search can improve the algorithm. As the beam width becomes bigger, less the iterations the algorithm needs, and the mean and standard deviation becomes smaller, and increases the efficiency.


By: Nico Mingkun Xia: mingkun.xia@mail.mcgill.ca
# Download
Clone the FunctionOptimization package  
In each java file, change the functions you want to test  
Run main method for each file 
