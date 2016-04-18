#include <iostream>
#include <string>

// example from http://www.tutorialspoint.com/cplusplus/cpp_templates.htm
using namespace std;

template <typename T>
T const& mymax (T const& a, T const& b)
{
  return a < b ? b:a;
}
int main ()
{

  int i = 39;
  int j = 20;
  cout << "mymax(i, j): " << mymax(i, j) << endl;

  double f1 = 13.5;
  double f2 = 20.7;
  cout << "mymax(f1, f2): " << mymax(f1, f2) << endl;

  string s1 = "Hello";
  string s2 = "World";
  cout << "mymax(s1, s2): " << mymax(s1, s2) << endl;

  return 0;
}
