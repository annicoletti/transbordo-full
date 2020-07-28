package br.com.cpqd.conversation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cpqd.conversation.entities.vo.MessageVO;

public interface MessageRepository extends JpaRepository<MessageVO, String> {

	List<MessageVO> findByAttendanceid(String attendanceId);

}
