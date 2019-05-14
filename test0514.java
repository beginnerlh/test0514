/*在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。机器人可以接受下列三条指令之一：

"G"：直走 1 个单位
"L"：左转 90 度
"R"：右转 90 度
机器人按顺序执行指令 instructions，并一直重复它们。

只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。



示例 1：

输入："GGLLGG"
输出：true
解释：
机器人从 (0,0) 移动到 (0,2)，转 180 度，然后回到 (0,0)。
重复这些指令，机器人将保持在以原点为中心，2 为半径的环中进行移动。
示例 2：

输入："GG"
输出：false
解释：
机器人无限向北移动。
示例 3：

输入："GL"
输出：true
解释：
机器人按 (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ... 进行移动。
*/
package lianxi0514;

public class test0514 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String instructions = "GGLLGG";
        System.out.println(s.isRobotBounded(instructions));
    }
}
//        如果头向北,且没有移动距离,则为true
//        如果头向北,移动了距离,则为false
//        如果头不向北 则为true

class Solution {
    public boolean isRobotBounded(String instructions) {
        char[] arr = instructions.toCharArray();
        int[] rec = {0,0,0,0};
        int des = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='G'){
                des = (des%4+4)%4;
                rec[des]++;
            }else if(arr[i]=='L'){
                des=(des+1)%4;
            }else{
                des--;
            }
        }
        if(des%4!=0){
            return true;
        }
        return rec[0]==rec[2]&&rec[1]==rec[3];
    }
}
