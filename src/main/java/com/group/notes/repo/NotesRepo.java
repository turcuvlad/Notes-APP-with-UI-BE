package com.group.notes.repo;

import com.group.notes.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotesRepo extends JpaRepository<Notes, Long> {
    void deleteNoteById(Long id);

    Optional<Notes> findNotesById(Long id);
}