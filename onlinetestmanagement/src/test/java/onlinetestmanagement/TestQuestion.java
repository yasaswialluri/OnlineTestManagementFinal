package onlinetestmanagement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.otm.bean.Question;
import com.cg.otm.dao.TestDao;
import com.cg.otm.dao.TestDaoImp;
import com.cg.otm.exception.TestException;
import com.cg.otm.service.TestService;
import com.cg.otm.service.TestServiceImpl;

class TestQuestion {
	TestDao dao = null ;
	TestService service = null ;
	@BeforeEach
	public void addQuestion()
	{
		dao = new TestDaoImp();
		service = new TestServiceImpl();
	}

	@Test
	public void testAddQuestion() throws Exception{
		Question q = new Question(12,"Mcq1",1,0.0,1,0.0);
		Question q2 = dao.addQuestions(1001, q);
		assertEquals(q,q2);
	}

	@Test
	public void testAddQuestionException() throws Exception{
		Question q = new Question(11,"Mcq1",1,0.0,1,0.0);
		String str = null;
		try
		{
			Question q2 = dao.addQuestions(1001, q);
		}catch(TestException e)
		{
			str=	e.getMessage();
		}
		assertEquals("Question already exist",str);
	}

	@Test
	public void testTestIdExist() throws Exception{
		Question q = new Question(11,"Mcq1",1,0.0,1,0.0);
		String str = null;
		try
		{
			Question q2 = dao.addQuestions(1006, q);
		}catch(TestException e)
		{
			str=	e.getMessage();
		}
		assertEquals("1006 doesnot exist",str);
	}

	@Test
	public void testdeleteQuestion() throws Exception{
		Question q = new Question(18,"Mcq1",1,0.0,1,0.0);
		String str = null;
		try
		{
			Question q2 = dao.deleteQuestions(1001, q);
		}catch(TestException e)
		{
			str=	e.getMessage();
		}
		assertEquals("18 question does not exist",str);
	}

	@Test
	public void testdeleteQuestion1() throws Exception{
		Question q = new Question(11,"Mcq1",1,0.0,1,0.0);
		String str = null;
		try
		{
			Question q2 = dao.deleteQuestions(1006, q);
		}catch(TestException e)
		{
			str=	e.getMessage();
		}
		assertEquals("1006 is not found",str);
	}

	@Test
	public void testlistQuestion() throws Exception{
		Question q = new Question(11,"Mcq1",1,0.0,1,0.0);
		Question q2 = dao.deleteQuestions(1001, q);
		List<Question> list = dao.listQuestion(1001);
		int a=list.size();
		assertEquals(2,a);
	}

	@Test
	public void testQuestionId()
	{
		String str = null;
		Question q = new Question(1,"Mcq1",1,0.0,1,0.0);
		int questionId = q.getQuestionId();
		try {
			service.addQuestions(1001, q);
		} catch (TestException e) {

			str=e.getMessage();
		}
		assertEquals("Id should be 2 digit",str);

	}

	@Test
	public void testQuestionId1()
	{
		String str = null;
		Question q = new Question(1,"Mcq1",1,0.0,1,0.0);
		int questionId = q.getQuestionId();
		try {
			service.deleteQuestions(1001, q);
		} catch (TestException e) {

			str=e.getMessage();
		}
		assertEquals("Id should be 2 digit",str);

	}

	@Test
	public void testQuestionTitle()
	{
		String str = null;
		Question q = new Question(11,"",1,0.0,1,0.0);
		int questionId = q.getQuestionId();
		try {
			service.addQuestions(1001, q);
		} catch (TestException e) {

			str=e.getMessage();
		}
		assertEquals("provide the title",str);

	}
}
