
# SYSC 4806 Project – Mini-Survey Monkey
## 👥 Authors 
Yahya Khan, Mehedi Mostofa, Jatin Kumar, Kshitij Sawhney, Peter Tanyous

## 🥅 Goal: The Mini-SurveyMonkey project consists of various entities. A Surveyor can initiate a survey by creating a list of questions.
The questions can fall into three categories: open-ended (text), numerical (within a specified range), or multiple-choice.
Users are presented with a survey form generated based on the type of questions in the survey, which they can fill out. 
The Surveyor has the authority to close the survey at any time, preventing new users from participating. 
When the survey is closed, the system generates a result by compiling the answers provided. 
For open-ended questions, the answers are presented as they are. 
For numerical questions, a histogram of the answers is generated, and for multiple-choice questions, a pie chart is created.

This software program is designed to function as a Software as a Service (SaaS) for clients, providing them with the ability 
to act as either a surveyor or surveyee for a particular survey. To accomplish this, the program includes a survey controller 
that is utilized to create a survey object and store it within a Crud repository. These survey objects can be created with a 
list of question objects, which include open-ended, numerical, and multiple-choice formats, using the constructor. 
The program utilizes a RestFUL API to create the repository, thereby allowing clients and other services to easily connect to it.
## 📄 Current Project iteration 
###### Milestone 1

**Implementation**

The current milestone includes the implementation of all question classes. The parent Question class contains the necessary 
variables and methods required by its subclasses. The NumericalRangeQuestion class enables the creation of questions that accept 
float inputs within a specified upper and lower bound. Multiple choice questions allow surveyors to add answer options for users 
to choose from. Open-ended questions allow users to provide string answers.

The survey object includes a title, name, ID, and a list of questions that can hold new questions added by the surveyor class.

A Restful repository interface is utilized by the survey repository to save survey objects, allowing for future communication 
with clients and HTML requests.

The survey controller is responsible for receiving requests and facilitating communication between the survey domain and 
persistence.

At present, the surveyor class, and the surveyee class are yet to be implemented. Additionally, the user parent class 
for both these classes is yet to be developed.

**Tests**

The current milestone has tests implemented for all types of questions MultipleChoiceTest, NumericalRangeQuestionTest, and
OpendEndedQuestionTest to test creating and answering different types of questions. 
