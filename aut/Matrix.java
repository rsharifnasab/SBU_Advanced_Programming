import java.util.Scanner;
public class Matrix{

  private int[][] m;
  private int numberOfRows;
  private int numberOfColumns;

  public Matrix(int rows, int columns)
  {
    m = new int[rows][columns];
    this.numberOfRows = rows;
    this.numberOfColumns = columns;
    for(int i = 0; i < rows; i++)
    {
      for(int j = 0; j < columns; j++)
      {
        m[i][j] = 0;
      }
    }
  }

  private int getRows(){return numberOfRows;}
  private int getColumns(){return numberOfColumns;}

  public int getValue(int rows, int columns){return m[rows][columns];}

  public void setValue(int value, int i, int j){ m[i][j] = value;}


  public Matrix add(Matrix x)
  {
    Matrix z = new Matrix(numberOfRows, numberOfColumns);
    if(numberOfRows == x.getRows() && numberOfColumns == x.getColumns())
    {
      for(int i = 0; i < x.getRows(); i++)
      {
        for(int j = 0; j < x.getColumns(); j++)
        {
          int value = m[i][j] + x.getValue(i,j);
          z.setValue(value,i,j);
        }
      }
      return z;
    }
    else{return null;}
  }


  public Matrix subtract(Matrix x)
  {
    Matrix z = new Matrix(numberOfRows, numberOfColumns);

    if(numberOfRows == x.getRows() && numberOfColumns == x.getColumns())
    {
      for(int i = 0; i < x.getRows(); i++)
      {
        for(int j = 0; j < x.getColumns(); j++)
        {
          int value = m[i][j] - x.getValue(i,j);
          z.setValue(value,i,j);
        }
      }
      return z;
    }
    else{return null;}
  }

  public Matrix multiply(Matrix x)
  {
    Matrix z = new Matrix(numberOfRows, x.getColumns());

    if(numberOfColumns == x.getRows())
    {
      for(int i = 0; i < numberOfRows; i++)
      {
        for(int j = 0; j < x.getColumns(); j++)
        {
          int sum = 0;
          for(int k = 0; k < numberOfColumns; k++)
          {
            sum += m[i][k] * x.getValue(k,j);
          }
          int value = sum;
          z.setValue(value,i,j);
        }
      }
      return z;
    }
    else{ return null; }
  }

  public String toString()
  {
    String es = "";
    for(int i = 0; i < numberOfRows; i++)
    {
      for(int j = 0; j < numberOfColumns; j++)
      {
        es = es + this.getValue(i,j) + " ";
      }
      es += "\n";
    }
    System.out.println(es);
    return es;
  }

  public static void main(String[] args) {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    int n = sc.nextInt();

    int r1 = sc.nextInt();
    int c1 = sc.nextInt();
    Matrix m1 = new Matrix(r1,c1);
    for (int i=0;i<r1;i++ ) {
      for (int j=0;j<c1;j++ ) {
        m1.setValue(sc.nextInt(),i,j);
      }
    }

    int r2 = sc.nextInt();
    int c2 = sc.nextInt();
    Matrix m2 = new Matrix(r2,c2);
    for (int i=0;i<r2;i++ ) {
      for (int j=0;j<c2;j++ ) {
        m2.setValue(sc.nextInt(),i,j);
      }
    }

    String order = sc.next();


    for (int i =0;i<n ;i++ ) {

      if(order.equals("+"))
        m1 = m1.add(m2);
      if(order.equals("-"))
        m1 = m1.subtract(m2);
      if(order.equals("*"))
        m1 = m1.multiply(m2);

      if (m1==null){
        System.out.println("ERROR");
        return;
      }
    }


      for (int i=0;i<m1.getRows();i++ ) {
        for (int j=0;j<m1.getColumns();j++ ) {
          System.out.print(m1.getValue(i,j) + " ");
        }
        System.out.println();
      }

  }
}
