
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

## 📄 Current Project iteration

###### Milestone 2: MiniSurveyMonkey Functional Web App with security and authentication, Database integration, and Testing

**Implementation**

The MiniSurvey web app has made significant strides towards becoming a reliable and secure survey application.
In its current iteration, the web app has added Web Security using SecurityFilterChain, which authenticates 
and authorizes incoming HTTP requests through login, ensuring that users are secure while navigating the web app.

The project has two controllers for the current milestone. The Account controller facilitates user authentication
by directing them through login and signup page endpoints, according to the project's WebSecurityConfig. On the other hand,
the SurveyController handles the app's core functionality, enabling users to create, fill, modify, view, and submit surveys with ease.

Moreover, the current prototype also integrates postgreSQL, a powerful and versatile open-source object-relational
database management system that is commonly used in web applications, data warehousing, and business intelligence. 
This integration enables the web app to save and host surveys, enhancing its scalability and reliability.

In addition to these features, the current prototype also includes webApplicationTest, which automates the testing 
of the web app's endpoints. This testing ensures the safe navigation and functionality of the web app, providing a
seamless experience for users.

###### Milestone 3 : MiniSurveyMonkey Functional Web App with better css, more functionalities, and Testing

This sprint for the MiniSurvey web app aimed to add more functionalities that enhance the user experience for both 
surveyors and surveyees. One of the main objectives is to create separate access for surveyors and surveyees, enabling 
them to perform different tasks based on their roles.

Surveyors will have the ability to view the saved results of their surveys. This feature will allow them to analyze
the data collected and gain insights into the opinions and preferences of their target audience. Additionally, 
surveyees will have a smoother experience, with new features that streamline the process of filling out surveys 
and submitting responses.

## 📝 Known Issues

The histogram functionality is not fully functional, we spent time debugging it but could not get it working.
