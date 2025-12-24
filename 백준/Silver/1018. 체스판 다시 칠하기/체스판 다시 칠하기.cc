#include <iostream>
#include <algorithm>

using std::cin;
using std::cout;

short int** chessBoard; //B=true, W=false

int check(int m, int n) {
    int** resultWB = new int*[n-8+1];
    int** resultBW = new int*[n-8+1];
    for(int i=0;i<=n-8;i++) {
        resultWB[i]=new int[m-8+1];
        resultBW[i]=new int[m-8+1];
        for(int j=0;j<=m-8; j++) {
            resultWB[i][j]=0;
            resultBW[i][j]=0;
        }
    }
    for(int i=0;i<n;i++)
        for(int j=0;j<m;j++) {
            for(int a=std::max(0, i-7); a<=std::min(n-8, i);a++)
                //i-7:normal(0:result minIndex) & i:normal(n-8:result maxIndex)
                for(int b=std::max(0, j-7); b<=std::min(m-8, j);b++) {
                    resultWB[a][b]+=chessBoard[i][j]^((i-a+j-b)%2);
                    resultBW[a][b]+=chessBoard[i][j]^!((i-a+j-b)%2);
                }
        }
    int min=m*n;
    for(int i=0;i<=n-8;i++) {
        for(int j=0;j<=m-8; j++) {
            min=std::min(min, resultWB[i][j]);
            min=std::min(min, resultBW[i][j]);
        }
        delete[] resultWB[i];
        delete[] resultBW[i];
    }
    delete[] resultWB;
    delete[] resultBW;

    return min;
}

int main() {
    cin.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int m, n;
    cin>>n>>m;
    chessBoard = new short int*[n];
    char input;
    for(int i=0;i<n;i++) {
        chessBoard[i] = new short int[m];
        for(int j=0;j<m;j++) {
            cin>>input;
            if(input=='B'||input!='W')
                chessBoard[i][j]=(input=='B')?1:0;
            //else
                //j--;
        }
    }
    cout<<"";
    cout<<check(m, n);

    return 0;
}
