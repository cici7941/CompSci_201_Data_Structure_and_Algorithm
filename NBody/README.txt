Name: Yaqian Cheng
NetID: yc233
Hours Spent: 6
Consulted With: none
Resources Used: none

Question 1: What is the final position of the planets after 1,000,000
seconds with a timestep of 25,000?
The final position of the planets are shown below.
earth: 1.4657072579675333E11 2.9603571820026024E10 
mars: 2.265919409244593E11 2.4055025673504623E10 
mercury: 3.863596759797241E10 4.2569286276404396E10 
sun: 26826.758124022024 2979.2451384889378 
venus: 1.0243682251001347E11 3.4391417962295876E10 

Question 2: For what values of timeStep, does the simulation no longer behave correctly? 
I set totalTime = 1,000,000,000, and try a series of value for timeStep, and found that
when timeStep > 1,000,000, the simulation no longer behaves correctly,
since there is a planet (the mercury) no longer follows its orbits around the Sun.