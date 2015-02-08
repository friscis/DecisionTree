
public class Eval {
	
	/*
	 * covert old eval into discrete values
	 */
	 public static String ef1( Board board) {
		int sum = (int)(Math.random() * 10); //random seed so it doesn't always go for left column when it can't see any advantage
		int[] advantages;
		double denominator = board.N * board.N * board.N * board.N * board.N;
		for(int i = board.N  - 1; i >= 2; i--) {
			double numerator = i * i *  i * i * i;
			int multiplier =(int) (numerator/denominator * 1000) + 1;
			advantages = board.numOfConnectN(i);
			//System.out.println("Current Sum: " + sum + " Multiplier: " + multiplier + " Advantage Scores: " + advantages[0] + ", -" + advantages[1] + ", "+ advantages[2] + ", -" + advantages[3]);
			sum = sum + multiplier*advantages[0] - multiplier*advantages[1] + multiplier*advantages[2] - multiplier*advantages[3];
		}
		
		int score = board.isConnectN();
		if( score == 1 ) {			// -1 no winner, 0 tie, 1 win, 2 loss
			sum = 1000000;
		} else if( score == 2) {
			sum = -1000000;
		}
		if(sum<-90) {
			return "lowScore";
		}
		if(sum>=-90 && sum<20) {
			return "middleScore";
		}
		if(sum>=20) {
			return "highScore";
		}
		return "what";
	 }
	 
	 /*
	  * check who owns the bottom center square.
	  */
	 public static String ef2( Board board) {
		 if(board.board[5][3]==1) {
			 return "has";
		 } else if(board.board[5][3]==2) {
			 return "lost";
		 } else {
			 return "open";
		 }
	 }
	 
	 /*
	  * check who has more pieces in the center
	  */
	 public static String ef3( Board board) {
		 int p1=0;
		 int p2=0;
		 for(int i=0; i<5; i++) {
			 if(board.board[i][3] == 1) {
				 p1++;
			 }
			 if(board.board[i][3] == 2) {
				 p2++;
			 }
		 }
		 if(p1>p2){
			 return "lead";
		 } else if(p1==p2) {
			 return "equal";
		 } else {
			 return "behind";
		 }
	 }
	 
	 /*
	  * check who has more pieces on the right half of row 4
	  */
	 public static String ef4( Board board) {
		 int p1=0;
		 int p2=0;
		 for(int j=3; j<5; j++) {
			 if(board.board[4][j] == 1) {
				 p1++;
			 }
			 if(board.board[4][j] == 2) {
				 p2++;
			 }
		 }
		 if(p1>p2){
			 return "leadRow4";
		 } else if(p1==p2) {
			 return "equalRow4";
		 } else {
			 return "behindRow4";
		 }
	 }
	 
	 /*
	  * check who has more pieces in the middle three columns
	  */
	 public static String ef5( Board board) {
		 int p1=0;
		 int p2=0;
		 for(int i=0; i<board.height; i++) {
			 for(int j=3; j<5; j++) {
				 if(board.board[i][j] == 1) {
					 p1++;
				 }
				 if(board.board[i][j] == 2) {
					 p2++;
				 }
			 }
		 }
		 if(p1>p2){
			 return "lead";
		 } else if(p1==p2) {
			 return "equal";
		 } else {
			 return "behind";
		 }
	 }
	 
	 /*
	  * check who has more pieces in column 2
	  */
	 public static String ef6( Board board) {
		 int p1=0;
		 int p2=0;
		 for(int i=0; i<5; i++) {
			 if(board.board[i][2] == 1) {
				 p1++;
			 }
			 if(board.board[i][2] == 2) {
				 p2++;
			 }
		 }
		 if(p1>p2){
			 return "lead";
		 } else if(p1==p2) {
			 return "equal";
		 } else {
			 return "behind";
		 }
	 }
	 
	 /*
	  * check who has more pieces in column 1
	  */
	 public static String ef7( Board board) {
		 int p1=0;
		 int p2=0;
		 for(int i=0; i<5; i++) {
			 if(board.board[i][1] == 1) {
				 p1++;
			 }
			 if(board.board[i][1] == 2) {
				 p2++;
			 }
		 }
		 if(p1>p2){
			 return "lead";
		 } else if(p1==p2) {
			 return "equal";
		 } else {
			 return "behind";
		 }
	 }
	 
	 /*
	  * check who has the lead in row 3
	  */
	 public static String ef8( Board board) {
		 int p1=0;
		 int p2=0;
		 for(int j=0; j<5; j++) {
			 if(board.board[3][j] == 1) {
				 p1++;
			 }
			 if(board.board[3][j] == 2) {
				 p2++;
			 }
		 }
		 if(p1>p2){
			 return "leadRow2";
		 } else if(p1==p2) {
			 return "equalRow2";
		 } else {
			 return "behindRow2";
		 }

	 }
	 

}
