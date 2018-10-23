import java.util.Scanner;

public class RpnCalculator {

    public static void main(String[] args) {
        System.out.println( "Please input:" );
        Scanner input = new Scanner( System.in );

        RpnCalculatorHandler rpnHandler = new RpnCalculatorHandler();

        while (input.hasNextLine())
        {
            String line = input.nextLine().trim();
            String[] inputs = line.length() > 0 ? line.split( " " ) : null;

            if ( inputs == null || inputs.length == 0 )
            {
                continue;
            }

            for ( int i = 0; i < inputs.length; i++ )
            {
                rpnHandler.processInput( inputs[i].toLowerCase(), i +1 );
            }
            if ( inputs.length > 0 )
            {
                CalculatorUtil.printStack( rpnHandler.getNumbers() );
            }
        }
    }
}