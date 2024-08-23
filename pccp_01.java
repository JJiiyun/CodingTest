class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int limit = health; //5
        int success = 0;
        int sec = 0;
        int len = attacks.length - 1; //1
        int attack_cnt = 0;
        
        while(sec <= attacks[len][0]) { //sec < 3
            //몬스터 공격
            if (sec == attacks[attack_cnt][0]) {
                health -= attacks[attack_cnt][1];
                success = 0;
                attack_cnt++;
            } else { //기본 회복량
                health += bandage[1];
            }
            
            
            //연속 시간 달성
            if (success == bandage[0]) {
                //체력 + 추가회복량
                health += bandage[2];
                //연속 시간 초기화
                success = 0;
            }
            
            //최대 체력 초과 시
            if (health > limit) health = limit;
            if (health < 0) break;
            success++;
            sec++;
        }
        
        if(health <= 0) health = -1;
        
        return health;
    }
}