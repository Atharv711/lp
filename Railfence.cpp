#include <iostream>
#include <vector>
using namespace std;

string railFenceEncrypt(const string& plaintext) {
    string ciphertext;
    int length = plaintext.length();
    vector<char> column1;
    vector<char> column2;

    for (int i = 0; i < length; i++) {
        if (i % 2 == 0) {
            column1.push_back(plaintext[i]);
        } else {
            column2.push_back(plaintext[i]);
        }
    }

    for (char c : column1) {
        ciphertext += c;
    }
    for (char c : column2) {
        ciphertext += c;
    }

    return ciphertext;
}

string railFenceDecrypt(const string& ciphertext) {
    string plaintext;
    int length = ciphertext.length();
    int halfLength = length / 2;

    for (int i = 0; i < halfLength; i++) {
        plaintext += ciphertext[i];
        plaintext += ciphertext[i + halfLength + (length % 2 == 0 ? 0 : 1)];
    }

    if (length % 2 != 0) {
        plaintext += ciphertext[halfLength];
    }

    return plaintext;
}

int main()
{
    int choice;
    cout << "Rail Fence Cipher\n";
    cout << "1. Encrypt\n";
    cout << "2. Decrypt\n";
    cout << "Enter your choice: ";
    cin >> choice;

    if (choice == 1) {
        string plaintext;
        cout << "\nEnter the plaintext: ";
        cin >> plaintext;

        string ciphertext = railFenceEncrypt(plaintext);
        cout << "The ciphertext is: " << ciphertext << endl;
    } else if (choice == 2) {
        string ciphertext;
        cout << "\nEnter the ciphertext: ";
        cin >> ciphertext;

        string plaintext = railFenceDecrypt(ciphertext);
        cout << "The plaintext is: " << plaintext << endl;
    } else {
        cout << "Invalid choice. Exiting...\n";
    }

    return 0;
}
