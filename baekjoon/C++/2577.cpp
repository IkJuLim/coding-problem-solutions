#include<iostream>
using namespace std;  

int main(){ 
    int a, b, c, n; 
    int elements[10] = {};
    
    cin >> a >> b >> c; 
    n = a * b * c; 

    while(n != 0){ 
        elements[n % 10]++;
        n = n / 10; 
    } 
    for(int i = 0; i < 10; i++) 
        printf("%d ", elements[i]);
}