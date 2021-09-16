#include <iostream>
#include <wiringPi.h>
#include <softTone.h>
using namespace std;
#define PIN_TRIG 23
#define PIN_ECHO 24
#define RANGE_MAX 200
#define RANGE_MIN 0 
#define BUZZER	  18

const int aMelody[9] = {131, 147, 165, 175, 196, 208, 220, 247, 262};

int main(int argc, char* argv[]){ 
	wiringPiSetupGpio(); unsigned int T, L;
	pinMode(PIN_TRIG, OUTPUT); pinMode(PIN_ECHO, INPUT);
	softToneCreate(BUZZER);

	while (1) {
	digitalWrite(PIN_TRIG, LOW); delayMicroseconds(2);
	digitalWrite(PIN_TRIG, HIGH); delayMicroseconds(20);
	digitalWrite(PIN_TRIG, LOW);

	while (digitalRead(PIN_ECHO) == LOW);

	unsigned int startTime = micros();
	while (digitalRead(PIN_ECHO) == HIGH);
	T = micros() - startTime;
	L = T / 58.2;

	if (L >= RANGE_MAX || L <= RANGE_MIN) cout << "-1" << endl;
	else if (L < 50) softToneWrite(BUZZER, aMelody[5]); delay(300); 
    cout << "Distance is " << L << " cm" << endl;
	delay(100);
      }
}

//컴파일: g++ ./(이름).cpp -o (이름) -lwiringPi
