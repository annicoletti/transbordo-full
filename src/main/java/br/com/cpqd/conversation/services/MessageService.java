package br.com.cpqd.conversation.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cpqd.conversation.entities.enums.ConversationStatus;
import br.com.cpqd.conversation.entities.to.MessageTO;
import br.com.cpqd.conversation.entities.vo.AttendenceVO;
import br.com.cpqd.conversation.entities.vo.MessageVO;
import br.com.cpqd.conversation.repositories.AttendanceRepository;
import br.com.cpqd.conversation.repositories.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private AttendanceRepository attendenceRepository;

	public void insert(MessageTO to) {
		MessageVO vo = new MessageVO();
		vo.setAttendanceid(to.getAttendanceId());
		vo.setClientId(to.getClientId());
		vo.setCompany(to.getCompany());
		vo.setDialog(to.getDialog());
		vo.setPortfolio(to.getPortfolio());
		vo.setRequestId(to.getRequestId());
		vo.setMessage(to.getMessage());
		vo.setMoment(Instant.now());
		vo.setStatus(ConversationStatus.RECEIVED.getCode());
		messageRepository.save(vo);

		Optional<AttendenceVO> find = attendenceRepository.findById(to.getAttendanceId());
		AttendenceVO attendenceVO = null;
		if (!find.isPresent()) {
			attendenceVO = new AttendenceVO();
			attendenceVO.setAttendanceid(to.getAttendanceId());
			attendenceVO.setAmount(0);
		} else {
			attendenceVO = find.get();
			int count = attendenceVO.getAmount();
			count += 1;
			attendenceVO.setAmount(count);
		}
		System.out.println(attendenceVO.getAttendanceid() + " >>>> " + attendenceVO.getAmount());
		attendenceRepository.save(attendenceVO);
	}

	public List<MessageTO> findByAttendanceId(String attendanceId) {
		List<MessageTO> out = new ArrayList<>();
		List<MessageVO> messages = messageRepository.findByAttendanceid(attendanceId);
		for (MessageVO messageVO : messages) {
			out.add(convertMessageVOtoMessageVO(messageVO));
		}
		return out;
	}

	private MessageTO convertMessageVOtoMessageVO(MessageVO vo) {
		MessageTO to = new MessageTO();
		to.setAttendanceId(vo.getAttendanceid());
		to.setClientId(vo.getClientId());
		to.setCompany(vo.getCompany());
		to.setDialog(vo.getDialog());
		to.setMessage(vo.getMessage());
		to.setPortfolio(vo.getPortfolio());
		to.setRequestId(vo.getRequestId());
		return to;
	}

	public List<AttendenceVO> findAllAtendence() {
		return attendenceRepository.findAll();
	}

}
