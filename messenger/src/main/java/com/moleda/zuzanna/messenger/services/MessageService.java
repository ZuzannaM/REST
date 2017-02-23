package com.moleda.zuzanna.messenger.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.moleda.zuzanna.messenger.database.DatabaseClass;
import com.moleda.zuzanna.messenger.exception.DataExceptionNotFound;
import com.moleda.zuzanna.messenger.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		Message m1 = new Message(1L, "Hello World!", "zuzua");
		Message m2 = new Message(2L, "Hello Jersey!", "zuzua");
		messages.put(m1.getId(), m1);
		messages.put(m2.getId(), m2);
	}

	public List<Message> getAllMessage() {
		return new ArrayList<Message>(messages.values());
	}

	public List<Message> getAllMessagesForYear(int year) {
		List<Message> listForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message m : messages.values()) {
			cal.setTime(m.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				listForYear.add(m);
			}
		}
		return listForYear;
	}
	
	public List<Message> getMessagePagination(int start, int size) {
		List<Message> list = new ArrayList<>(messages.values());
		if(start + size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start + size);
	}

	public Message getMessage(long id) {
		Message message = messages.get(id);
		if(message == null) {
			throw new DataExceptionNotFound("The message with id: " + id + " was not found.");
		}
		return message;
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		} else {
			messages.put(message.getId(), message);
			return message;
		}
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
