package com.group.notes.service;

import com.group.notes.exception.NoteNotFoundException;
import com.group.notes.model.Notes;
import com.group.notes.repo.NotesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NotesService {
    private final NotesRepo notesRepo;

    @Autowired
    public NotesService(NotesRepo notesRepo) {
        this.notesRepo = notesRepo;
    }

    public Notes addNotes(Notes notes) {
        return notesRepo.save(notes);
    }

    public List<Notes> findAllNotes() {
        return notesRepo.findAll();
    }

    public Notes updateNotes(Notes notes) {
        return notesRepo.save(notes);
    }

    public Notes findNotesById(Long id) {
        return notesRepo.findNotesById(id)
                .orElseThrow(() -> new NoteNotFoundException("Could not find any note with the id "+id));
    }

    public void deleteNotes(Long id){
        notesRepo.deleteNoteById(id);


    }
}
