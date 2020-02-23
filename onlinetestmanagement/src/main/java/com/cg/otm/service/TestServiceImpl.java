package com.cg.otm.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.otm.bean.Question;
import com.cg.otm.bean.Test;
import com.cg.otm.dao.TestDao;
import com.cg.otm.dao.TestDaoImp;
import com.cg.otm.exception.TestException;

public class TestServiceImpl implements TestService {
	private TestDao testDao;

	public TestServiceImpl() {

		testDao = new TestDaoImp();
	}
	public boolean validateQuestionTitle(String questionTitle)
	{
		boolean validateTitle = questionTitle.isBlank();
		return validateTitle;
	}
	public boolean validateQuestionOptions(String []questionOptions)
	{
		boolean validateOption = false;
		int n= questionOptions.length;
		for(int i=0;i<n;i++)
		{
			validateOption = questionOptions[i].isBlank();
			if(validateOption)
			{
				break;
			}

		}
		return validateOption;
	}
	public boolean validateQuestionId(int questionId)
	{
		String quesId  = String.valueOf(questionId);

		boolean validateId = quesId.matches("[0-9]{2}");
		return validateId;
	}

	// add question
	@Override
	public Question addQuestions(int testId, Question question) throws TestException {

		//validating the question id

		boolean validateId = validateQuestionId(question.getQuestionId());
		if(!validateId)
		{
			throw new TestException("Id should be 2 digit");
		}
		//validating the question Title
		boolean validateTitle = validateQuestionTitle(question.getQuestionTitle());

		if(validateTitle) 
		{
			throw new TestException("provide the title");
		}

		//validating the options
		boolean validateOption = validateQuestionOptions(question.getQuestionOptions());

		if(validateOption) 
		{
			throw new TestException("fill the option field " );

		}



		return testDao.addQuestions(testId, question);

	}
	//delete question
	@Override
	public Question deleteQuestions(int testId, Question question) throws TestException {
		boolean flag = validateQuestionId(question.getQuestionId());
		if(!flag)
		{
			throw new TestException("Id should be 2 digit");
		}
		return testDao.deleteQuestions(testId, question);
	}
	@Override
	public List<Question> listQuestion(int testId) {

		return testDao.listQuestion(testId);
	}
	@Override
	public ArrayList<Test> listTest() {
		return testDao.listTest();
	}
}




