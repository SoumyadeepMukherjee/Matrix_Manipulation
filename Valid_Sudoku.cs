using System.Collections.Generic;
using System.Linq;
using System;
using System.Text;
using Common;

namespace ValidSudoku
{
   /// <summary>
   /// more on https://github.com/pakosel/leetcode-solutions
   /// </summary>
   public class Solution
   {
      int[][] sudoku = null;

      public bool IsValidSudoku(char[][] board)
      {
         sudoku = ConvertBoard(board);

         for (int i = 0; i < 9; i++)
         {
            bool[] arr = new bool[9];
            for (int j = 0; j < 9; j++)
               if (!Validate(ref arr, sudoku[i][j]))
                  return false;
         }

         for (int i = 0; i < 9; i++)
         {
            bool[] arr = new bool[9];
            for (int j = 0; j < 9; j++)
               if (!Validate(ref arr, sudoku[j][i]))
                  return false;
         }

         for (int i = 0; i < 9; i += 3)
            for (int j = 0; j < 9; j += 3)
               if (!ValidateSquare(i, j))
                  return false;
         return true;
      }

      private bool ValidateSquare(int i_start, int j_start)
      {
         bool[] arr = new bool[9];
         for (int i = i_start; i < i_start + 3; i++)
            for (int j = j_start; j < j_start + 3; j++)
               if (!Validate(ref arr, sudoku[j][i]))
                  return false;
         return true;
      }

      private bool Validate(ref bool[] arr, int val)
      {
         if (val == 0)
            return true;
         val--;

         if (val < 0 || val > 9)
            return false;
         if (arr[val])
            return false;

         arr[val] = true;

         return true;
      }

      private int[][] ConvertBoard(char[][] board)
      {
         int[][] res = new int[9][];

         for (int i = 0; i < 9; i++)
         {
            res[i] = new int[9];
            for (int j = 0; j < 9; j++)
               res[i][j] = board[i][j] == '.' ? 0 : board[i][j] - '0';
         }

         return res;
      }
   }
}