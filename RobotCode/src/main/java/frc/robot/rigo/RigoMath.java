// package frc.robot.rigo;

// /*
// * // This file contains various statistical and mathematical functions originally written in java script converted to
// *   JAVA By Rodrigo Lopez

// //  Copyright Tim Niiler 2006-2020 AND Rodrigo Lopez 2020
// //
// //      This program is free software; you can redistribute it and/or modify
// //      it under the terms of the GNU General Public License as published by
// //      the Free Software Foundation; either version 2 of the License, or
// //      (at your option) any later version.
// //
// //      This program is distributed in the hope that it will be useful,
// //      but WITHOUT ANY WARRANTY; without even the implied warranty of
// //      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// //      GNU General Public License for more details.
// //
// //      You should have received a copy of the GNU General Public License
// //      along with this program; if not, write to the Free Software
// //      Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
// *
// * */
// public class RigoMath {

//     private static double sumPow(double[] x, double p) {
//         // x is the input vector;
//         // p is the power
//         double sum = 0;
//         for (double value : x)
//             sum += Math.pow(value, p);
//         return sum;
//     }

//     private static double sumPowY(double[] x,double[] y, double p) {
//         var sum = 0;
//         for (var i=0; i< x.length; i++) {
//                 sum += Math.pow(x[i],p)*y[i];
//         }
//         return sum;
//     }

//     private static euclidDist(x,y) {
//         // Both x and y are vectors of the same length (N), each representing
//         // an N-dimensional point.  In this case, we are finding the Euclidean
//         // distance between the points represented
//         var sqrsum = 0;
//         for (var i=0; i< x.length; i++) {
//             sqrsum += (x[i]-y[i])*(x[i]-y[i]);
//         }
//         dout = Math.sqrt(sqrsum);
//         return dout;
//     }

//     function pythagDist(x,y) {
//         // x and y are vectors containing 2 elements each.  This is a 2D
//         // subset of the problem dealt with by euclidDist(). x contains the
//         // x-coords of the points, and y contains the y-coords.
//         // As of Firefox 27, Math.hypot is available....
//         return Math.sqrt(Math.pow(x[1]-x[0],2)+Math.pow(y[1]-y[0],2));
//     }

//     function sumThenSquare(x) {
//         //alert(vect.length);
//         var sqrsum = 0;
//         for (var i=0; i< x.length; i++) {
//             if (!isNaN(x[i])) {
//                 sqrsum += Number(x[i]);
//             }
//         }
//         sqrsum = (sqrsum*sqrsum); ///x.length;
//         return sqrsum;
//     }

//     function squareThenSum(x) {
//         var sqrsum = 0;
//         for (var i=0; i< x.length; i++) {
//             if (!isNaN(x[i])) {
//                 sqrsum += Number(x[i])*Number(x[i]);
//             }
//         }
//         return sqrsum;
//     }

//     function sumSquareTot(vect1,vect2) {
//         // Misnomer?
//         sst = 0;
//         for (var i=0; i< vect1.length; i++) {
//             sst += Number(vect1[i])+Number(vect2[i]);
//         }
//         //sst = sst/(vect1.length+vect2.length);	// Changed 2012-02-26
//         sst = sst*sst/(vect1.length+vect2.length);
//         return sst;
//     }

//     function sumOfSquares(vect,avgV) {
//         var SS = 0;
//         for (var i=0; i< vect.length; i++) {
//             if (!isNaN(vect[i]) ) {
//                 SS += Math.pow(vect[i]-avgV,2)
//             }
//             //if (i > vect.length-5) alert(SS);
//         }
//         return SS;
//     }

//     function SumSquareBetw(vect1,vect2) {
//         // This is for the two vector case
//         var ssb = sumThenSquare(vect1) + sumThenSquare(vect2) - sumSquareTot(vect1,vect2);
//         return ssb;
//     }

//     function SumSquareWith(vect1,vect2) {
//         var ssw = squareThenSum(vect1)-sumThenSquare(vect1)+squareThenSum(vect2)-sumThenSquare(vect2);
//         return ssw;
//     }

//     function abs(x) {
//         return Math.abs(x);
//     }

//     function vABS(vect) {
//         // Absolute value of a vector
//         for (var i=0; i< vect.length; i++) {
//             vect[i] = Math.abs(vect[i]);
//         }
//         return vect;
//     }

//     function doSum(vect) {
//         // Sum elements within a vector
//         var theSum=0;
//         for (var i=0; i< vect.length; i++) {
//             if (vect[i]) {
//                 theSum += 1*vect[i];
//             }
//         }
//         return theSum;
//     }

//     function avg(vect,dropZeroes) {
//         //var theSum = doSum(vect);
//         // if dropZeroes is true, zeroes will not be counted
//         var theSum=0;
//         var avgCount = 0;
//         for (var i=0; i< vect.length; i++) {
//             if (dropZeroes && vect[i] == 0) continue;
//             //if (vect[i]) {
//             if (typeof(vect[i]) == 'number') {
//                 if (vect[i] != NaN) {
//                     theSum += 1*vect[i];
//                     avgCount++;
//                 }
//             } else {	// Try to convert....???
//                 vect[i] = 1*vect[i];
//                 if (vect[i] != NaN) {
//                     theSum += 1*vect[i];
//                     avgCount++;
//                 }
//             }
//             //}
//         }
//         //alert(theSum+'\t'+avgCount);
//         //alert(outString);
//         return theSum/avgCount;
//     }



//     function doSumProduct(vect1,vect2) {
//         var theSum = 0;
//         for (var i=0; i< vect1.length; i++) {
//             theSum += Number(vect1[i])*Number(vect2[i]);
//         }
//         return theSum;
//     }

//     function gaussian(xvec,xo,width) {
//         // calculate a gaussian function, g for xvec centered on xo with width as given
//         var g = new Array();
//         for (var i=0; i< xvec.length; i++) {
//             g[i] = Math.exp(-Math.pow( (xvec[i]-xo)/(0.6006*width), 2));
//         }
//         return g;
//     }

//     function pgaussFit(xvec,yvec) {
//         // Interesting idea from Tom O'Haver at University of Maryland:
//         // http://terpconnect.umd.edu/~toh/spectrum/CurveFitting.html
//         // Model gaussian as a downward facing parabola
//         // Javascript implementation is my own
//         var zvec = yvec.map(arrLog);
//         var coef = polyCor(xvec,zvec,2,"quad").coefs;
//         //alertArray(coef);
//         var a = coef[2];
//         var b = coef[1];
//         var c = coef[0];
//         var height = Math.exp(a-c*Math.pow( (b/(2*c)), 2) );
//         var center = -b/(2*c);
//         // Presume that c is negative;
//         if (c > 0) return false;
//         var width = 2.35703/(Math.sqrt(2)*Math.sqrt(-c));
//         return [center, width, height];
//     }

//     function arrLog(element, index, array) {
//         return Math.log(element);
//     }
// }
