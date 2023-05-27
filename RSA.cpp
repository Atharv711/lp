#include<iostream>
#include<cmath>
using namespace std;

// Find the greatest common divisor (GCD)
int gcd(int a, int b) {
   int t;
   while(1) {
      t = a % b;
      if(t == 0)
         return b;
      a = b;
      b = t;
   }
}

int main() {
   // Two prime numbers entered by the user
   int p, q;
   cout << "Enter prime p: ";
   cin >> p;
   cout << "Enter prime q: ";
   cin >> q;

   int n = p * q; // Calculate n
   int phi = (p - 1) * (q - 1); // Calculate phi

   // Public key
   // e stands for encrypt
   int e = 7;
   while(e < phi) {
      if(gcd(e, phi) == 1)
         break;
      else
         e++;
   }

   // Private key
   // d stands for decrypt
   // Choosing d such that it satisfies d * e = 1 mod phi
   int d = 1;
   while((d * e) % phi != 1)
      d++;

   int message;
   cout << "Enter a message to encrypt: ";
   cin >> message;

   int c = pow(message, e); // Encrypt the message
   int m = pow(c, d);
   c = fmod(c, n);
   m = fmod(m, n);

   cout << "Original Message = " << message << endl;
   cout << "p = " << p << endl;
   cout << "q = " << q << endl;
   cout << "n = pq = " << n << endl;
   cout << "phi = " << phi << endl;
   cout << "e = " << e << endl;
   cout << "d = " << d << endl;
   cout << "Encrypted message = " << c << endl;
   cout << "Decrypted message = " << m << endl;

   return 0;
}
