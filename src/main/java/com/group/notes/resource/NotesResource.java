package com.group.notes.resource;

import com.group.notes.model.Notes;
import com.group.notes.service.NotesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesResource {

    private final NotesService notesService;

    public NotesResource(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Notes>> getAllNotes () {
        List<Notes> notes = notesService.findAllNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Notes> getNotesById (@PathVariable("id") Long id) {
        Notes notes = notesService.findNotesById(id);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Notes> addNotes(@RequestBody Notes notes) {
        Notes newNotes = notesService.addNotes(notes);
        return new ResponseEntity<>(newNotes, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Notes> updateNotes(@RequestBody Notes notes) {
        Notes updateNotes = notesService.updateNotes(notes);
        return new ResponseEntity<>(updateNotes, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNotes(@PathVariable("id") Long id) {
        notesService.deleteNotes(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
