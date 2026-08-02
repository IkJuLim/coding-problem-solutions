#include <string>
#include <vector>

using namespace std;

int test1[5] = {1, 2, 3, 4, 5};
int test2[8] = {2, 1, 2, 3, 2, 4, 2, 5};
int test3[10] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    int correct[4] = {0, };
    for(int i = 0; i < answers.size(); ++i){
        if(answers[i] == test1[i % 5]) ++correct[1];
        if(answers[i] == test2[i % 8]) ++correct[2];
        if(answers[i] == test3[i % 10]) ++correct[3];
    }
    int maxvalue = max(max(correct[1], correct[2]), correct[3]);
    for(int i = 1; i <= 3; ++i){
        if(correct[i] == maxvalue)
            answer.push_back(i);
    }
    return answer;
}