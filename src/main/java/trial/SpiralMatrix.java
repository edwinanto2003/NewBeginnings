package trial;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
    
    For example,
    Given the following matrix:
    
    [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    ]
    You should return [1,2,3,6,9,8,7,4,5].
    
 * 
 * @author edwin
 *
 */
public class SpiralMatrix
{
  public List<Integer> spiralOrder(int[][] matrix) 
  {
      List<Integer> vals = new ArrayList<Integer>();
      if (matrix.length == 0)
          return vals;
          
      int top = 0, left = 0;
      int right = matrix[0].length -1; int bottom = matrix.length-1;
      int totalElements = (right+1) * (bottom+1);
      while (left <= right && top <= bottom)
      {
          for (int i = left; i <= right; i++)
              vals.add(matrix[top][i]);
          top++;
                    
          if (vals.size() == totalElements)
            break;
          
          for (int i = top; i <= bottom; i++)
              vals.add(matrix[i][right]);
          right--;
          
          if (vals.size() == totalElements)
            break; 
          for (int i = right; i >=left; i--)
              vals.add(matrix[bottom][i]);
          bottom--;
          if (vals.size() == totalElements)
            break;        
          
          for (int i = bottom; i >= top ; i--)
              vals.add(matrix[i][left]);
          left++;
      }
      
      return vals;
  }
  
  public static void main(String[] args)
  {
    int val=1;
    int[][] matr = new int[3][3];
    for (int i = 0; i < 3; i ++)
      for (int j =0 ; j < 3 ; j++)
        matr[i][j] = val++;
    
    SpiralMatrix sm = new SpiralMatrix();
    System.out.println(sm.spiralOrder(matr));

  }

}
