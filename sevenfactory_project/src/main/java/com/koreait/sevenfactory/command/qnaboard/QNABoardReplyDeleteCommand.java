package com.koreait.sevenfactory.command.qnaboard;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.sevenfactory.command.Command;
import com.koreait.sevenfactory.dao.SevenFactoryDAO;

public class QNABoardReplyDeleteCommand implements Command {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		int reNo = Integer.parseInt(request.getParameter("reNo"));
		
		SevenFactoryDAO reDAO = sqlSession.getMapper(SevenFactoryDAO.class);
		reDAO.deleteQNABoardReply(reNo);
		
	}

}
