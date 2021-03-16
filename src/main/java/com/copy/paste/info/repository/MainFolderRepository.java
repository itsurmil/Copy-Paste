package com.copy.paste.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.copy.paste.info.model.MainFolder;

@Component
public interface MainFolderRepository extends JpaRepository<MainFolder, Long> {
  MainFolder findById(long id);
}
