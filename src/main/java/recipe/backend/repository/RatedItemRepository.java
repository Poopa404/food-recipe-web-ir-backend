package recipe.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import recipe.backend.entity.RatedItem;

public interface RatedItemRepository extends JpaRepository<RatedItem,Long> {
    List<RatedItem> findAll();
}