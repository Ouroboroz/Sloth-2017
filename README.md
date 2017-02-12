# Sloth-2017

### TODO
1. Make a PID loop for the shooter wheels. The loop will control the value going to the shooter motor. This will ensure that the motor spins at a controlled speed even with balls being fed into it to improve accuracy.
2. Alignment. GRIP will output some value to NetworkTables, we only need to send the X coordinate to turn towards it. Figure out how off-center that value is and plug it into a PID loop and output as rotation (MecanumDrive_Polar()).
3. Half Closed Loop Driving. 
4. Hopper area. Rev up shooter motors, then rotate the ball feeder after motors are completely reved up. When the button turning the hopper area off is released, keep rotating the ball feeder until it the limit switch is open.
5. Intake roller. Simple on/off button to turn the surgical tubing roller on or off.
### Controller Input Map
![Controller Input Map](chrome_2017-01-13_22-26-30.png?raw=true)

### Samarth's Pro MS Paint Thing
![Samarth Sucks](samarth.png?raw=true)
