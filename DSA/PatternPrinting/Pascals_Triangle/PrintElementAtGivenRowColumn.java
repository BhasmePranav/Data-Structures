package PatternPrinting.Pascals_Triangle;


//QUESTION : u have to print number at given position  , given position is in form of row and column
public class PrintElementAtGivenRowColumn {
    
    public static void main(String[] args) {
    
        //Find element at location is Row 5 and column 3
        int row = 5;
        int column = 3;

        int sol = printElementOptimal(row-1 , column-1);        //rows and column starts from 0 so we pass values by -1
        System.out.println("Number at Position (" + row + " , " + column + ") is :: "+sol );
    }

//Brute Force Approach for this is find each factorial (n! , r! , (n-r)!) by runmning saperate while loop

    private static int printElementOptimal(int row, int column) {

        //we will use gere formula of combination which is ncr = n!/(r! * (n-r)! )

        /*In Optiaml approach we will directly cut the (n-r)! from n! 
        bcz if row = n = 5 , 5! = 5*4*3*2*1 and column = c = 3 , 3! = 3*2*1
        so 3! form denominator will divide 3! from numerator so we cut it
         and find factorial only til n-r*/

        int sol = 1;
        int x = 0;
        while(x<column)
        {
            sol = sol*(row-x);
            sol = sol/(x+1);
            x++;
        }
        return sol;
    }
}
