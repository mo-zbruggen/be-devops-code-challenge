package com.example.notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
@RequestMapping("/notes")
public class NotesApplication {

	private final Map<Long, Note> notes = Collections.synchronizedMap(new HashMap<>());


	public static void main(String[] args) {
		SpringApplication.run(NotesApplication.class, args);
	}

	@GetMapping
	public Collection<Note> getNotes() {
		return notes.values();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
		Note note = notes.get(id);
		if (note == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(note, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Note> createNote(@RequestBody Note note) {
		if (notes.containsKey(note.getId()) ) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		notes.put(note.getId(), note);

		return new ResponseEntity<>(note, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note updatedNote) {
		Note existing = notes.get(id);
		if (existing == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		existing.setTitle(updatedNote.getTitle());
		existing.setContent(updatedNote.getContent());
		return new ResponseEntity<>(existing, HttpStatus.OK);
	}

}
