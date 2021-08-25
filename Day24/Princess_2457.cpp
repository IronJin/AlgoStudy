#include <iostream>
#include <deque>
#include <algorithm>

using namespace std;

class Date {
 public :
	int month;
	int day;
	Date() { month = 0; day = 0; }
	Date(int m, int d) {month = m; day = d;}
	bool operator == (Date& t) { return (month == t.month) && (day == t.day); }	
	bool operator > (Date& t)
	{
		if(month == t.month)
			return day > t.day;
		return month > t.month;
	}	

	void print()
	{
		cout << "( " << month << ", " << day << ")" << endl;
	}
};

class Flower {
 public :
	Date start;
	Date end;
	Flower(int sm, int sd, int em, int ed) 
	{ 
		if(sm < 3) { sm = 3; sd = 1;}
		if(em > 11) { em = 12; ed = 1;}

		start = Date(sm, sd);
		end = Date(em, ed);
	}
};

bool comp(Flower& a, Flower& b)
{
	if(a.end == b.end)
		return b.start > a.start;

	return a.end > b.end;	
}
	
deque<Flower> d;

int main()
{
	int N; cin >> N;

	int input1, input2, input3, input4;
	while(N--)
	{
		cin >> input1 >> input2 >> input3 >> input4;

		d.push_back(Flower(input1, input2, input3, input4));
	}

	sort(d.begin(), d.end(), comp);



	int cnt = 0;
	bool ps = false;
	Date cutline = Date(12, 1), temp = cutline, f_day = Date(3, 1);

	while(!ps && !d.empty())
	{
		if(cutline > d.front().end)
			ps = true;

		else
		{
			while(!d.empty())
			{
				if(d.front().end > cutline || d.front().end == cutline)
				{
					if(temp > d.front().start)
						temp = d.front().start;

					d.pop_front();
				}

				else break;
			}

			cutline = temp;

			cnt++;
			if(cutline == f_day) break;	
		}		

	}
			
	if(cutline == f_day) ps = false;
	else ps = true;
	
	if(ps) cout << "0"; 
	else cout << cnt; 

	return 0;
}

		

