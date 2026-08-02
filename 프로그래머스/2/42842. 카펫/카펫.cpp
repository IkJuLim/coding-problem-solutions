#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    answer.push_back(((brown - 4)/2 + sqrt(((brown - 4)/2)*((brown - 4)/2) - 4 * yellow))/2 + 2);
    answer.push_back(((brown - 4)/2 - sqrt(((brown - 4)/2)*((brown - 4)/2) - 4 * yellow))/2 + 2);
    return answer;
}