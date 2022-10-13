#include<iostream>
#include<vector>
#include<algorithm>
#include<time.h>
#include<stdlib.h>
using namespace std;

#define INF 10000000000000
const int maxSize = 100000, maxRand = 1000000000;

int myRand()
{
    int random = (rand() % maxRand + rand() % maxRand) % maxRand;
    return random;
}


void merge(vector<int> &ara, int l, int mid, int r) {
    vector<int>  temp;
    int l1, l2;
    for (l1 = l, l2 = mid + 1; l1 <= mid and l2 <= r;) {
        if (ara[l1] <= ara[l2])
            temp.push_back(ara[l1++]);
        else temp.push_back(ara[l2++]);
    }

    while (l1 <= mid)
        temp.push_back(ara[l1++]);
    while (l2 <= r)
        temp.push_back(ara[l2++]);
    for (int i = l; i <= r; i++)
        ara[i] = temp[i - l];
}

void mergeSort(vector<int> &ara, int l, int r) {
    if (l < r) {
        int mid = (l + r) >> 1;
        mergeSort(ara, l, mid);
        mergeSort(ara, mid + 1, r);
        merge(ara, l, mid, r);
    }
}

void sortList(vector<int> &ara, bool ascending)
{
    mergeSort(ara, 0,(int) ara.size() - 1);

    if (!ascending)
    {
        for (int i = 0; i < ara.size() / 2; i++)
        {
            swap(ara[i], ara[(int)ara.size() - i - 1]);
        }
    }
}

void isSame(vector<int> &input, vector<int> &output)
{
    vector<int> temp1 = input, temp2 = output;
    sort(temp1.begin(), temp1.end());
    sort(temp2.begin(), temp2.end());

    if (temp1 != temp2)
    {
         cout << "List has been altered by the testing routing" << endl;
    }
}

void isSortedCorrectOrder(vector<int> &output, bool ascending)
{
    if (ascending)
    {
        long long curValue = -INF;

        for (auto &value : output)
        {
            if (curValue > value)
            {
                 cout << "not sorted in correct order" << endl;
                return ;
            }
            curValue = value;
        }

    }
    else
    {
        long long curValue = INF;

        for (auto &value : output)
        {
            if (curValue < value)
            {
                cout << "not sorted in correct order" << endl;
                return ;
            }
            curValue = value;
        }
    }

    cout << "sorted in correct order" << endl;
}

void TestDriver(vector<int> &list)
{
    vector<int> list1 = list;
    vector<int> original = list;

    //ascending
    sortList(list, true);
    isSortedCorrectOrder(list, true);
    isSame(original, list);

    //descending
    list = list1;

    sortList(list, false);
    isSortedCorrectOrder(list, false);
    isSame(original, list);
}

void TestScript()
{
    srand(time(0));
    vector<int> list;

    //blank============

    TestDriver(list);

    //one number============

    list.clear();
    list.push_back(myRand());
    TestDriver(list);

    //two numbers============
    list.clear();

    list.push_back(myRand());
    list.push_back(myRand());
    TestDriver(list);

    //random size & random values============


    int size = myRand() % maxSize;
    list.resize(size);

    for (int i = 0; i < list.size(); i++)
    {
        list[i] = myRand();
        if (myRand() & 1) list[i] = -list[i];
    }

    TestDriver(list);

     //ascending order list============
    size = myRand() % maxSize;
    list.resize(size);

    int random = -myRand();

    for (int i = 0; i < list.size(); i++)
    {
        list[i] = random;
        random = random + myRand() % 1000;
    }

    TestDriver(list);

     //descending order list============
    size = myRand() % maxSize;
    list.resize(size);

    random = myRand();

    for (int i = 0; i < list.size(); i++)
    {
        list[i] = random;
        random = random - myRand() % 1000;
    }

    TestDriver(list);

    //all numbers equal============
    size = myRand() % maxSize;
    list.resize(size);

    random = myRand();
    if (random & 1) random = -random;

    for (int i = 0; i < list.size(); i++)
    {
        list[i] = random;
    }

    TestDriver(list);
}

int main()
{
    TestScript();
}