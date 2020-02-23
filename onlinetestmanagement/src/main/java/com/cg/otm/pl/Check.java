package com.cg.otm.pl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.otm.bean.Question;
import com.cg.otm.bean.Test;
import com.cg.otm.exception.TestException;
import com.cg.otm.service.TestService;
import com.cg.otm.service.TestServiceImpl;

public class Check {
	public static void main(String[] args) {
		TestService testService = new TestServiceImpl();

		Scanner scanner = new Scanner(System.in);
		int choice=0;
		Question question = new Question();
		while(choice!=5)
		{
			System.out.println("1.Add Question");
			System.out.println("2. Delete Question");
			System.out.println("3.List of tests");
			System.out.println("4.List of questions in test");
			System.out.println("3.exit");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch(choice)
			{
			case 1: 
				System.out.println("Enter the test Id");
				int testId=scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter the question id");
				int questionId = scanner.nextInt();

				scanner.nextLine();

				System.out.println("Enter the Questin title");
				String name =scanner.nextLine();
				System.out.println("enter the question options");
				String options[] = new String[4];
				for(int i=0;i<4;i++)
				{
					options[i]=scanner.nextLine();
				}
				System.out.println("Enter the question answer");
				int questionAnswer=scanner.nextInt();
				System.out.println("Enter the Question marks");
				double questionMarks=scanner.nextDouble();
				int Id = question.setQuestionId(questionId);
				String title = question.setQuestionTitle(name);
				String []option = (String[]) question.setQuestionOptions(options);
				int answer = question.setQuestionAnswer(questionAnswer);
				double marks = question.setQuestionMarks(questionMarks);
				try
				{
					testService.addQuestions(testId,question);
					System.out.println("Question added");
					System.out.println("QuestionId = "+question.getQuestionId()+" Question Title = "+question.getQuestionTitle()+" Question Answer = "+question.getQuestionAnswer()+" Question Marks = "+question.getQuestionMarks());
				}
				catch(TestException e)
				{
					System.err.println(e.getMessage());
				}
				break;
			case 2:System.out.println("Enter the testId Id");
			int id=scanner.nextInt();
			System.out.println("Enter the question id");
			int questionid = scanner.nextInt();
			int Id1 = question.setQuestionId(questionid);
			try {
				testService.deleteQuestions(id, question);
				System.out.println(question.getQuestionId()+" is deleted");
			} catch (TestException e) {
				System.err.println(e.getMessage());
			}
			break;
			case 3:
				ArrayList<Test> listOfTest = testService.listTest();
				for(Test test:listOfTest)
				{
					System.out.println("Test Id = "+test.getTestId());
				}
				break;
			case 4:
				System.out.println("choose the test");
				int testId1 = scanner.nextInt();

				List<Question> listOfQuestion = testService.listQuestion(testId1);
				for(Question ques:listOfQuestion)
				{
					System.out.println("Question Id = "+ques.getQuestionId());

				}
				break;
			case 5: System.out.println("Thank you");
			return;  	
			}
		}
	}
}
