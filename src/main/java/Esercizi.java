import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.event.EventListenerSupport;

import java.io.Console;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Esercizi
{
    Logger logger = Logger.getLogger(Esercizi.class.getName());
    Scanner scanner;
    private List<Integer> readIntInput()
    {
        scanner = new Scanner(System.in);
        //scanner.useDelimiter("\n");
        List<Integer> integerList = new ArrayList<>();
        String input = scanner.nextLine();
        scanner.reset();
        String[] split = input.split(" ");

        try
        {
            Arrays.stream(split).forEach(n -> integerList.add(Integer.parseInt(n)));
        }
        catch (NumberFormatException e)
        {
            String message = e.getMessage();
            System.out.println("Exception: " + message + ":\nGli input non numerici come questo verranno eliminati.");
            List<String> collect = Arrays.stream(split).filter(s -> StringUtils.isNumeric(s)).collect(Collectors.toList());
            integerList.clear();
            collect.stream().forEach(n -> integerList.add(Integer.parseInt(n)));
        }

        return integerList;
    }

    private boolean isDoubleDigit(Integer number)
    {
        boolean isDoubleDigit = false;
        int doubleDigit = (int) Math.log10(number) + 1;

        if (doubleDigit == 2)
            isDoubleDigit = true;

        return isDoubleDigit;
    }

    public void esercizio_2_69()
    {
        System.out.println("*** ESERCIZIO 2_69 ***\n");
        System.out.println("Inserire due numero compresi da 0 a 9");
        List<Integer> integerList = readIntInput();
        integerList.stream().sorted().forEach(System.out::print);
        integerList.stream().sorted(Collections.reverseOrder()).max(Integer::compareTo).map(integerList::remove);
        integerList.stream().sorted(Collections.reverseOrder()).forEach(System.out::print);
        System.out.println("\n\n*** END ***");

    }

    //fatto sul mac
    public void esercizio_2_71()
    {
        System.out.println("*** ESERCIZIO 2_71 ***\n");
        List<Integer> integerList = readIntInput();
        integerList = integerList.stream().sorted().collect(Collectors.toList());
        List<Integer> doubleDigitList = integerList.stream().filter(this::isDoubleDigit).collect(Collectors.toList());



        System.out.println("\n\n*** END ***");
    }

    public void esercizio_2_73()
    {
        System.out.println("*** ESERCIZIO 2_73 ***\n");

        int rows = 9;
        int cols = 17;
        int numberLeft = 1;
        int numberRight = 8;
        int inferiorLimit = 0;
        int superiorLimit = cols;

        String[][] matrix = new String[rows][cols];
        int jump = rows;

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
                matrix[i][j] = " ";
        }



        for (int i = 8; i >= 0; i--)
        {
            for (int j = inferiorLimit; j < superiorLimit; j++)
            {
                if (numberLeft <= jump)
                {
                    matrix[i][j] = String.valueOf(numberLeft);
                    numberLeft++;

                }
                else {
                    matrix[i][j] = String.valueOf(numberRight);
                    numberRight--;

                }
            }
            numberLeft--;
            inferiorLimit++;
            superiorLimit--;
            jump--;
            numberRight = numberLeft - 2;
            numberLeft = 1;
        }

       this.printMatrix(matrix, rows, cols);

    }


    public Matrix esercizio_2_74(Boolean withPrint) {
        System.out.println("*** ESERCIZIO 2_74 ***\n");
        System.out.println("Inserire un nemro compreso fra 1 e 9");
        List<Integer> integerList = readIntInput();
        int limit = integerList.get(0);

        int rows = limit;
        int jump = limit;
        int cols = (rows * 2) - 1;
        int inferiorLimit = 0;
        int superiorLimit = cols;
        int numberLeft = 1;
        int numberRight = limit - 1;
        Matrix matrice = new Matrix(rows, cols);
        String matrix[][] = matrice.getMatrix();

        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = " ";
            }
        }

        for (int i = limit - 1; i >= 0; i--) {
            for (int j = inferiorLimit; j < superiorLimit; j++) {
                if (numberLeft <= jump) {
                    matrix[i][j] = String.valueOf(numberLeft);
                    numberLeft++;

                } else {
                    matrix[i][j] = String.valueOf(numberRight);
                    numberRight--;
                }
            }
            numberLeft--;
            inferiorLimit++;
            superiorLimit--;
            jump--;
            numberRight = numberLeft - 2;
            numberLeft = 1;
        }

        if (withPrint) {
            this.printMatrix(matrix, rows, cols);
            System.out.println("\n\n*** END ***");
        }

        return matrice;

    }

    public Matrix esercizio_2_75(Boolean withPrint)
    {
        Matrix matrix = this.esercizio_2_74(false);

        if (withPrint)
            this.inversePrintMatrix(matrix.getMatrix(), matrix.getRows(), matrix.getCols() );
        return matrix;

    }

    public Matrix esercizio_2_76(Boolean withPrint)
    {
        Matrix matrix = this.esercizio_2_74(false);

        if (withPrint)
            this.rightPrint(matrix.getMatrix(), matrix.getRows(), matrix.getCols());
        return matrix;

    }

    public void printMatrix(String[][] matrix, int rows, int cols)
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
                System.out.print(matrix[i][j]);
            System.out.println();
        }
    }

    public void inversePrintMatrix(String[][] matrix, int rows, int cols)
    {
        for (int i = rows - 1; i >= 0; i--)
        {
            for (int j = 0; j < cols; j++)
                System.out.print(matrix[i][j]);
            System.out.println();
        }
    }

    public void rightPrint(String[][] matrix, int rows, int cols)
    {
        for (int i = rows - 1; i >= 0; i--)
        {
            for (int j = 0; j < cols; j++)
            {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public Scanner getScanner()
    {
        return scanner;
    }
}
