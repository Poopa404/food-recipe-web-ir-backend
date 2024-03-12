package recipe.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import recipe.backend.entity.Folder;

public interface FolderRepository extends JpaRepository<Folder,Long> {
    List<Folder> findAll();
}