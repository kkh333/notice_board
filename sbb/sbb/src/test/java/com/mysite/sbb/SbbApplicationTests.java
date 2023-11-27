package com.mysite.sbb;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Test
	void questionDataSet() {
		Question q1 = new Question();
		q1.setSubject("질문1");
		q1.setContent("내용입니다.내용입니다.내용입니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);

		Question q2 = new Question();
		q2.setSubject("질문2");
		q2.setContent("내용입니다.내용입니다.내용입니다.");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
	}

	@Test
	void answerDataSet() {
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q1 = oq.get();

		Answer a1 = new Answer();
		a1.setContent("답변입니다1-1.");
		a1.setQuestion(q1);
		a1.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a1);

		Answer a2 = new Answer();
		a2.setContent("답변입니다1-2.");
		a2.setQuestion(q1);
		a2.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a2);
	}

}
