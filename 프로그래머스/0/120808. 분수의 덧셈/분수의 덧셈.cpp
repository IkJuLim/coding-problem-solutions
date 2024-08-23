#include <string>
#include <vector>

using namespace std;

vector<int> solution(int numer1, int denom1, int numer2, int denom2) {
    vector<int> answer;
    int num1 = numer1 * denom2 + numer2 * denom1;
    int num2 = denom1 * denom2;
    
    for(int i = num2; i > 1; i--)
        if(num1 % i == 0 && num2 % i == 0){
            num1 /= i;
            num2 /= i;
        }
    answer.push_back(num1);
    answer.push_back(num2);
    return answer;
}