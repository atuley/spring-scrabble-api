package hello;

public class Score {
    public String word;
   public int score;

   Score(String word) {
     this.word = word.toLowerCase();
     this.score = getScore();
   }

   int getScore() {
     for (int i=0; i < word.length(); i++) {
       char currentLetter = word.charAt(i);

       if ("aeioulnrst".indexOf(currentLetter) != -1) {
         score += 1;
       } else if ("dg".indexOf(currentLetter) != -1) {
         score += 2;
       } else if ("bcmp".indexOf(currentLetter) != -1) {
         score += 3;
       } else if ("fhvwy".indexOf(currentLetter) != -1) {
         score += 4;
       } else if ("k".indexOf(currentLetter) != -1) {
         score += 5;
       } else if ("jx".indexOf(currentLetter) != -1) {
         score += 8;
       } else if ("qz".indexOf(currentLetter) != -1) {
         score += 10;
       }
     }

     return score;
   }
}
