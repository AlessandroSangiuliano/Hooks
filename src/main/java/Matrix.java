public class Matrix
{
    private String[][] matrix;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols)
    {
        this.matrix = new String[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    public String[][] getMatrix()
    {
        return matrix;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
}
