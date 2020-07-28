package br.com.cpqd.conversation.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.cpqd.conversation.entities.enums.ConversationStatus;
import br.com.cpqd.conversation.entities.vo.MessageVO;
import br.com.cpqd.conversation.repositories.MessageRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public void run(String... args) throws Exception {

		String attendanceid = UUID.randomUUID().toString();
		MessageVO m1 = new MessageVO();
		m1.setAttendanceid(attendanceid);
		m1.setChannel("APIREST");
		m1.setClientId("APIREST-0001");
		m1.setCompany("COMPANY");
		m1.setDialog("DIALOGDEVELOPER");
		m1.setMessage("oi");
		m1.setMoment(Instant.now());
		m1.setPortfolio("DEMOAV");
		m1.setRequestId(m1.getAttendanceid().concat(m1.getClientId()).concat(UUID.randomUUID().toString()));
		m1.setStatus(ConversationStatus.RECEIVED.getCode());

		MessageVO m2 = new MessageVO();
		m2.setAttendanceid(attendanceid);
		m2.setChannel("APIREST");
		m2.setClientId("APIREST-0001");
		m2.setCompany("COMPANY");
		m2.setDialog("DIALOGDEVELOPER");
		m2.setMessage("Sim");
		m2.setMoment(Instant.now());
		m2.setPortfolio("DEMOAV");
		m2.setRequestId(m1.getAttendanceid().concat(m1.getClientId()).concat(UUID.randomUUID().toString()));
		m2.setStatus(ConversationStatus.SENDED.getCode());

		MessageVO m3 = new MessageVO();
		m3.setAttendanceid(attendanceid);
		m3.setChannel("APIREST");
		m3.setClientId("APIREST-0001");
		m3.setCompany("COMPANY");
		m3.setDialog("DIALOGDEVELOPER");
		m3.setMessage("Tchau");
		m3.setMoment(Instant.now());
		m3.setPortfolio("DEMOAV");
		m3.setRequestId(m1.getAttendanceid().concat(m1.getClientId()).concat(UUID.randomUUID().toString()));
		m3.setStatus(ConversationStatus.RECEIVED.getCode());

		messageRepository.saveAll(Arrays.asList(m1, m2, m3));
	}

}
