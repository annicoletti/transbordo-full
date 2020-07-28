package br.com.cpqd.conversation.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cpqd.conversation.entities.to.MessageTO;
import br.com.cpqd.conversation.entities.vo.AttendenceVO;
import br.com.cpqd.conversation.services.MessageService;

@RestController
@RequestMapping(value = "/conversation/v1")
public class ConversationResource {

	@Autowired
	private MessageService messageService;

	@PostMapping(value = "/message")
	public ResponseEntity<Void> insert(@RequestBody MessageTO to) {
		messageService.insert(to);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/message/{id}")
	public ResponseEntity<List<MessageTO>> getMessageById(@PathVariable String id) {
		List<MessageTO> out = messageService.findByAttendanceId(id);
		return ResponseEntity.ok().body(out);
	}

	@GetMapping(value = "/attendance")
	public ResponseEntity<List<AttendenceVO>> getIds() {
		List<AttendenceVO> out = messageService.findAllAtendence();
		return ResponseEntity.ok().body(out);
	}

}
