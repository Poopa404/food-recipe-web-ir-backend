package recipe.backend.dao;

import org.springframework.data.domain.Page;

import recipe.backend.entity.RatedItem;

public interface RatedItemDao {
    Page<RatedItem> getRatedItem(Integer pageSize, Integer page);
    RatedItem getRatedItem(Long id);
    RatedItem save(RatedItem ratedItem);
}
