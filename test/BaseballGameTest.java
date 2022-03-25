package test;

import model.BaseballGame;

public class BaseballGameTest
{
    public static void main(String[] args) {
        final int MAX = 5000;

        for (int i = 0; i < MAX; i++){
            BaseballGame b = new BaseballGame();
            assert checkKey(b.getKey());
        }
        BaseballGame b1 = new BaseballGame(0,1,2);
        b1.setGuess(0,1);
        b1.setGuess(1,5);
        b1.setGuess(2,9);
        b1.computeBallsStrikes();
        assert b1.getBallCount()==1;
        assert b1.getStrikeCount()==0;
    }
    private static boolean checkKey(int[] key)
    {
        if (key[0]==key[1] || key[0]== key[2] || key[1]==key[2])
        return false;
        else
         return true;
    }
}
