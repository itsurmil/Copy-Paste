package com.copy.paste.info.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.copy.paste.info.model.FieldValue;
import com.copy.paste.info.model.MainFolder;

@Component
public interface FieldValueRepository extends JpaRepository<FieldValue, Long> {
  FieldValue findById(long id);

  List<FieldValue> findByMainFolder(MainFolder mainFolder);

  @Query(value = "SELECT * FROM field_value t where t.main_folder_id = :id", nativeQuery = true)
  List<FieldValue> findByMainFolderId(@Param("id") Long id);

}
