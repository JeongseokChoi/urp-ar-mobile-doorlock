#include <Stepper.h>
#include <SoftwareSerial.h>

#define DIR 4
#define STEP 5
#define ENABLE 6
#define TXD 12
#define RXD 13

#define SPEED_STEP 1
#define COUNT_STEP 400

SoftwareSerial bluetooth(TXD, RXD);

void stepClockwise() {
  digitalWrite(DIR, LOW);
  
  for(int i=0; i<COUNT_STEP; i++){
    digitalWrite(STEP, HIGH);
    delay(SPEED_STEP);
    digitalWrite(STEP, LOW);
    delay(SPEED_STEP);
  }

  delay(1000);
}

void stepCounterClockwise() {
  digitalWrite(DIR, HIGH);
  
  for(int i=0; i<COUNT_STEP; i++){
    digitalWrite(STEP, HIGH);
    delay(SPEED_STEP);
    digitalWrite(STEP, LOW);
    delay(SPEED_STEP);
  }

  delay(1000);
}

void setup() {
  Serial.begin(9600);
  bluetooth.begin(9600);
  
  pinMode(DIR, OUTPUT);
  pinMode(STEP, OUTPUT);
  pinMode(ENABLE, OUTPUT);

  digitalWrite(DIR, LOW);
  digitalWrite(STEP, LOW);
  digitalWrite(ENABLE, LOW);
}

void loop() {
  
  if(bluetooth.available()){
    int data = bluetooth.read();
    Serial.print(data);

    if(data == 48) stepClockwise();
    else if(data == 49) stepCounterClockwise();
    else Serial.print("Not defined Order");
  }

 /*if (bluetooth.available())
     Serial.write(bluetooth.read());
   if (Serial.available())
     bluetooth.write(Serial.read());
*/
}
