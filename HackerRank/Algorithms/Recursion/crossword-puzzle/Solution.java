import java.util.*;

// https://www.hackerrank.com/challenges/crossword-puzzle
public class Solution {
    public static final int inputSize = 10;
    /* define a direction for the name */
    public enum DIRECTION {right, down};

    /* use a helper class to store the start and end of a name and its direction */
    static class Name {
        int startI, startJ;
        int endI, endJ;
        DIRECTION direction;
        
        public Name(int startI, int startJ, int endI, int endJ, DIRECTION direction) {
        	this.startI = startI;
        	this.startJ = startJ;
        	this.endI = endI;
        	this.endJ = endJ;
        	this.direction = direction;
        }

		@Override
		public String toString() {
			return "\n[startI=" + startI + ", startJ=" + startJ + ", endI=" + endI + ", endJ=" + endJ
					+ ", direction=" + direction + "]";
		}
    }
    
    /* return an ArrayList of positions for each gap in the puzzle matrix */
    public static ArrayList<Name> getAllStartingPositions(char[][] puzzle) {
    	ArrayList<Name> positions = new ArrayList<Name>();
    	int len = puzzle.length;
    	
    	/* search rows */
    	for (int i = 0; i < len; i++)
    		for (int j = 0; j < len; j++) {
    			int start = j;
    			while (j < len && puzzle[i][j] == '-')
    				j++;
    			if (j - start > 1)
    				positions.add(new Name(i, start, i, j-1, DIRECTION.right));
    		}
    	
    	/* search columns */
    	for (int i = 0; i < len; i++)
    		for (int j = 0; j < len; j++) {
    			int start = j;
    			while (j < len && puzzle[j][i] == '-')
    				j++;
    			if (j - start > 1)
    				positions.add(new Name(start, i, j-1, i, DIRECTION.down));
    		}
    	return positions;
    }
    
    /*
     * print a char matrix
     */
    public static void printPuzzle(char[][] puzzle) {
        for (int i = 0; i < inputSize; i++) {
            for (int j = 0; j < inputSize; j++)
                System.out.print(puzzle[i][j]);
            System.out.println();
        }
    }
    
    /* insert a given name in the matrix, at a specified position */
    public static void solve(char[][] puzzle, ArrayList<Name> positions, ArrayList<String> names, Name pos, int name_i) {
    	int k = 0;
    	/* search the matrix at the given position to find if it matches the name */
		for (int i = pos.startI; i <= pos.endI; i++)
			for (int j = pos.startJ; j <= pos.endJ; j++) 
				if (puzzle[i][j] == '-')
					k++;
				/* if there is a different character at the current position, return */
				else if (puzzle[i][j] != names.get(name_i).charAt(k++))
					return;
			
		k = 0;
		/* the name can be inserted, just copy it in the puzzle matrix */
		for (int i = pos.startI; i <= pos.endI; i++)
			for (int j = pos.startJ; j <= pos.endJ; j++)
				puzzle[i][j] = names.get(name_i).charAt(k++);
		
		/* remove the name that was just copied */
		names.remove(name_i);
		/* try solving the puzzle further */
		solvePuzzle(puzzle, positions, names);
    }
    
    /* return a clone of the given matrix */
    public static char[][] cloneCharMatrix(char[][] mat) {
    	char[][] copy = new char[mat.length][mat.length];
    	for (int i = 0; i < mat.length; i++)
    		for (int j = 0; j < mat.length; j++)
    			copy[i][j] = mat[i][j];
    	return copy;
    }

    /* get one position and match it with a name, then insert the name in the matrix */
    public static void solvePuzzle(char[][] puzzle, ArrayList<Name> positions, ArrayList<String> names) {
    	/* 
    	 * if there are no positions left, 
    	 * then the matrix is filled with words, so print the matrix 
    	 */ 
    	if (positions.isEmpty()) {
    		printPuzzle(puzzle);
    		return;
    	}

    	/* get one position */
    	Name pos = positions.remove(0);
    	int len = Math.max(pos.endJ - pos.startJ + 1, pos.endI - pos.startI + 1);
    	
    	/* search for a name to fit that position */
    	for (int name_i = 0; name_i < names.size(); name_i++) {
    		/* if the name fits the position, insert the name into the matrix */
    		if (len == names.get(name_i).length())
    			solve(cloneCharMatrix(puzzle), new ArrayList<Name>(positions), new ArrayList<String>(names), pos, name_i);
    	}
    }

    public static void main(String[] args) {
        /* use scanner to read input from STDIN */
        Scanner in = new Scanner(System.in);
        String line;
        /* read the char matrix */
        char[][] puzzle = new char[inputSize][inputSize];
        for (int i = 0; i < inputSize; i++) {
            line = in.nextLine();
            for (int j = 0; j < inputSize; j++)
                puzzle[i][j] = line.charAt(j);
        }
        
        /* read the names */
        line = in.nextLine();
        /* split the names */
        String[] namesSplit = line.split(";");
        /* use an ArrayList to store the names */
        ArrayList<String> names = new ArrayList<String>();
        for(int i = 0; i < namesSplit.length; i++)
        	names.add(namesSplit[i]);

        /* iterate through the matrix and find the indexes of all names */
        ArrayList<Name> positions = getAllStartingPositions(puzzle);
        
        
        /* solve the puzzle recursively */
        solvePuzzle(puzzle, positions, names);
        
        /* close scanner */
        in.close();
    }
}
