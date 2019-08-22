package leetcode.easy.math;

/****
 *
 * https://leetcode.com/problems/divisor-game/
 *
 *
 * 两个人玩游戏，假设第一个人先开始，
 *
 * 最初有一个数字N写在黑板上，然后每个人一次选择一个数字x，范围在0<x<N之间，并且N%x==0
 *
 * 对于选中之后的数字，我们要替换到N-x为黑板上已经存在的数字，依次类推，直到某个玩家不能在
 * 找到符合条件的数字，就算输调了比赛
 *
 *
 */
public class DivisorGame {

    public boolean divisorGame(int N) {

        return N%2==0;
    }

}
