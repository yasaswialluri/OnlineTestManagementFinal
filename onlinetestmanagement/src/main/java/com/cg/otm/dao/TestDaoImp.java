package com.cg.otm.dao;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.cg.otm.bean.Question;
import com.cg.otm.bean.Test;
import com.cg.otm.exception.TestException;

public class TestDaoImp implements TestDao {
	private Map<Integer,Test> testMap;
	Test test1;
	List<Question> list1;
	List<Question> list2;


	public TestDaoImp()
	{
		testMap=new HashMap<Integer,Test>();
		//static data
		Question q1 = new Question(11,"Mcq1",1,0.0,1,0.0);
		Question q2 = new Question(21,"MCq2",1,0.0,1,0.0);
		list1 = new ArrayList<Question>();
		list2 = new ArrayList<Question>();
		list1.add(q1);
		list1.add(q2);
		list2.add(q1);
		list2.add(q2);
		Test  test1 = new Test(1001,"",LocalTime.now(),list1,100.0,0.0,q1,LocalDateTime.now(),LocalDateTime.now());
		Test  test2 = new Test(1002,"",LocalTime.now(),list2,100.0,0.0,q1,LocalDateTime.now(),LocalDateTime.now());
		testMap.put(1001, test1);
		testMap.put(1002, test2);
	}


	// add question		
	public Question addQuestions(int testId, Question question) throws TestException {


		Set<Integer> listOfTestId=testMap.keySet();
		boolean testIdExist=testMap.containsKey(testId);

		
			Collection<Test> listOfTest=testMap.values();

			if(!testIdExist)
			{
				throw new TestException(testId+" doesnot exist");
			}

			Collection<Test> dc= listOfTest.stream().filter(p->p.getTestId()==testId).collect(Collectors.toList());
			List<Test>  ldc = new ArrayList<Test>(dc);
			List<Question> test =  ldc.get(0).getTestQuestions();
			boolean questionIdExist=false;
			for(Question ques:test)
			{
				questionIdExist = ques.getQuestionId()==question.getQuestionId();
				break;

			}


			if(questionIdExist)
			{
				throw new TestException("Question already exist");
			}
			else
			{
				ldc.get(0).getTestQuestions().add(question);
			}
		

		return question;
	}
	// delete question
	public Question deleteQuestions(int testId, Question question) throws TestException {
		Question question1=new Question();  
		boolean testIdExist = testMap.containsKey(testId);
		if(testIdExist)
		{
			Test test = testMap.get(testId);
			List<Question> set =test.getTestQuestions();

			boolean questionIdExist = set.stream().anyMatch(p->p.getQuestionId()==question.getQuestionId());
			if(questionIdExist)
			{
				System.out.println(question.getQuestionAnswer());

				question1=question;
				set.remove(question);


			}
			else
			{
				throw new TestException(question.getQuestionId()+" question does not exist");

			}

		}
		else 
		{
			throw new TestException(testId+" is not found");
		}

		return question1;
	}


	@Override
	public List<Question> listQuestion(int testId) {

		List<Question> listOfQuestions = new ArrayList<Question>() ;

		boolean flag = testMap.containsKey(testId);
		if(flag)
		{
			test1 = testMap.get(testId);
			listOfQuestions=test1.getTestQuestions();
		}
		for(Question ques:listOfQuestions)
		{
			System.out.println(ques.getQuestionId());
		}
		return listOfQuestions;
	}


	@Override
	public ArrayList<Test> listTest() {
		Collection<Test>	col =testMap.values();
		ArrayList<Test> listOfTest= new ArrayList<Test>(col);
		return listOfTest;
	}



}
