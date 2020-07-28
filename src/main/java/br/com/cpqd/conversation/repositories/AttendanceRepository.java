package br.com.cpqd.conversation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cpqd.conversation.entities.vo.AttendenceVO;

public interface AttendanceRepository extends JpaRepository<AttendenceVO, String> {

}
