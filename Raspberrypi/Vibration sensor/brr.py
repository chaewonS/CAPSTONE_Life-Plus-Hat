#192.168.137.23# -*- coding: utf-8 -*-

import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BCM)
buzzer=18
GPIO.setup(buzzer, GPIO.OUT)
GPIO.setwarnings(False)
GPIO.setup(5, GPIO.IN, pull_up_down=GPIO.PUD_DOWN)
time.sleep(1)

pwm = GPIO.PWM(buzzer, 1.0)
pwm.start(50.0)

while True:
	result = GPIO.input(5)
	if result == 1:
		print("진동이 감지 되었습니다.")
		for i in range(10):
			pwm.ChangeFrequency(523)
			time.sleep(0.5)
			pwm.ChangeFrequency(440)
			time.sleep(0.5)
	else:
		print("진동이 없습니다.")
		time.sleep(0.05)

#센서에서 진동이 감지되면 1을 보내준다. 23번을 GPIO.IN으로 만들어 그 값으로 진동 여부를 판단
