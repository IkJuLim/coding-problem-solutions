class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        int len = asteroids.size();
        for(int i = 0; i < len; i++){
            for(int j = 1; j < asteroids.size(); j++){
                if(asteroids[j-1] > 0 && asteroids[j] < 0){
                    if(asteroids[j-1] > -1 * asteroids[j]){
                        asteroids.erase(asteroids.begin() + j);
                    }
                    else if(asteroids[j-1] < -1 * asteroids[j]){
                        asteroids.erase(asteroids.begin() + j - 1);
                    }
                    else if(asteroids[j-1] == -1 * asteroids[j]){
                        asteroids.erase(asteroids.begin() + j - 1, asteroids.begin() + j + 1);
                    }
                }
            }
        }
        return asteroids;
    }
};