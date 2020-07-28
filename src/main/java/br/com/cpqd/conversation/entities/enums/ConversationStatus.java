package br.com.cpqd.conversation.entities.enums;

public enum ConversationStatus {

	RECEIVED(1), SENDED(2);

	private int code;

	private ConversationStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static ConversationStatus valueOf(int code) {
		for (ConversationStatus value : ConversationStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invallid OrderStatus code");
	}
}
