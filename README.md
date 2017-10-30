# loan-score-calculator
Given input csv file, apply some rules and calculate loan score depending on the result. Generate output csv file.

## Project Description:
Some important person is worried that his/her properties isn't good investment anymore. So he/she asked me to use my java skills to grade these properties of loans in scale of 0 to 100. All loans start out at 100, but as they stack up "exceptions" the score goes down. Depending on the condition and type of exceptions, the impact is bigger / smaller.

## Technical Notes:
* May need Java9.
* Thinking about making into maven project.

## Directory Information:
* main - LoanScoreCalculator.java
* builder - builds model objects
* model - holds model for custom objects used to represent entity
* utility - varius utilites that haven't been dist yet

## October 30th, 2017 Update
* First commit. 
* Didn't have chance to commit along the way. 
* Need junit tests for ScoreCalculator.java
