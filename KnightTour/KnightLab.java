public class KnightLab
{
private int[][] myBoard;
private int myRow;
private int myCol;
private int myCount;
private static final int[] horizontal = {1,2,2,1,-1,-2,-2,-1};
private static final int[] vertical = {-2,-1,1,2,2,1,-1,-2};
public KnightLab()
    {
    myBoard = new int[9][9];
    myRow = 0;
    myCol = 0;
    myCount = 1;
    myBoard[0][0] = 0;
    }
public void setBoard()
{
  for (int x = 1; x < 9; x++)
  {
      myBoard[0][x] = x;
      myBoard[x][0] = x;
    }
}
public boolean canMove(int row, int col)
    {
        if(row < 9 && row >= 1 && col < 9 && col >= 1)
        {
            if(myBoard[row][col] == 0)
            {
                return true;
            }
        }
        return false;
    }

public void move()
{
    int rand = (int)(Math.random() * 8);
    int newRow = myRow + horizontal[rand];
    int newCol = myCol + vertical[rand];
    while(!canMove(newRow,newCol))
    {
        rand = (int)(Math.random() * 8);
        newRow = myRow-horizontal[rand];
        newCol = myCol-vertical[rand];

    }
    myRow = newRow;
    myCol = newCol;
    myCount++;
    myBoard[myRow][myCol] = myCount;

}

public boolean noMoreMoves()
{
for(int i = 0; i < 8; i++)
{
    if(canMove(myRow+horizontal[i], myCol+vertical[i]))
    {
        return false;
    }
}
return true;
}

public void print()
{
for (int row = 0; row < 9; row ++)
    {
        for (int col = 0; col < 9; col ++)
        {
            System.out.print(myBoard[row][col] + "\t");
        }
System.out.println();
    }   
System.out.println(myCount + " squares were visited");
}

public void clear()
{
  myBoard = new int[9][9];  
}

public static void main(String[] args)
{
KnightLab knight = new KnightLab();
knight.setBoard();
while(!(knight.noMoreMoves()))
    {
     if (knight.noMoreMoves()) 
    {
    knight.clear();
    knight.move();
    }
        knight.move();
    }

 knight.print();
}

}

